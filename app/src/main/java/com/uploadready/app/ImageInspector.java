package com.uploadready.app;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.OpenableColumns;

import java.io.InputStream;

final class ImageInspector {
    private ImageInspector() {}

    static ImageInfo inspect(Context context, Uri uri) throws Exception {
        ContentResolver cr = context.getContentResolver();
        String name = "photo.jpg";
        long size = -1L;
        try (Cursor c = cr.query(uri, new String[]{OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE}, null, null, null)) {
            if (c != null && c.moveToFirst()) {
                int n = c.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                int s = c.getColumnIndex(OpenableColumns.SIZE);
                if (n >= 0 && !c.isNull(n)) name = c.getString(n);
                if (s >= 0 && !c.isNull(s)) size = c.getLong(s);
            }
        }
        String mime = cr.getType(uri);
        if (mime == null) mime = "application/octet-stream";

        BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        try (InputStream in = cr.openInputStream(uri)) {
            if (in == null) throw new IllegalArgumentException("Unable to open selected image");
            BitmapFactory.decodeStream(in, null, bounds);
        }
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) {
            throw new IllegalArgumentException("Unable to read image dimensions");
        }
        if (size < 0) {
            try (InputStream in = cr.openInputStream(uri)) {
                if (in == null) throw new IllegalArgumentException("Unable to open selected image");
                byte[] buf = new byte[8192];
                long total = 0;
                int r;
                while ((r = in.read(buf)) != -1) total += r;
                size = total;
            }
        }

        int width = bounds.outWidth;
        int height = bounds.outHeight;
        try (InputStream exifIn = cr.openInputStream(uri)) {
            if (exifIn != null) {
                ExifInterface exif = new ExifInterface(exifIn);
                int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                if (orientation == ExifInterface.ORIENTATION_ROTATE_90 ||
                        orientation == ExifInterface.ORIENTATION_ROTATE_270 ||
                        orientation == ExifInterface.ORIENTATION_TRANSPOSE ||
                        orientation == ExifInterface.ORIENTATION_TRANSVERSE) {
                    int tmp = width; width = height; height = tmp;
                }
            }
        } catch (Exception ignored) { }

        return new ImageInfo(uri, name, mime, size, width, height);
    }
}
