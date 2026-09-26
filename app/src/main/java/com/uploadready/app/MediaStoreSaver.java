package com.uploadready.app;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class MediaStoreSaver {
    private MediaStoreSaver() {}

    static Uri saveJpeg(Context context, File resultFile) throws Exception {
        ContentResolver cr = context.getContentResolver();
        String stamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, "UploadReady_" + stamp + ".jpg");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/Upload Ready");
        values.put(MediaStore.Images.Media.IS_PENDING, 1);

        Uri uri = cr.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        if (uri == null) throw new IllegalStateException("MediaStore insert failed");
        boolean ok = false;
        try (FileInputStream in = new FileInputStream(resultFile);
             OutputStream out = cr.openOutputStream(uri, "w")) {
            if (out == null) throw new IllegalStateException("MediaStore output unavailable");
            byte[] buf = new byte[8192];
            int r;
            while ((r = in.read(buf)) != -1) out.write(buf, 0, r);
            out.flush();
            ok = true;
        } finally {
            if (!ok) cr.delete(uri, null, null);
        }
        ContentValues done = new ContentValues();
        done.put(MediaStore.Images.Media.IS_PENDING, 0);
        cr.update(uri, done, null, null);
        return uri;
    }
}
