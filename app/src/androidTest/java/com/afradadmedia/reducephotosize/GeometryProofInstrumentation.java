package com.afradadmedia.reducephotosize;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ContentValues;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/** Test-only runner: invokes the real package-private JpegCompressionEngine. */
public final class GeometryProofInstrumentation extends Instrumentation {
    private static final String[] FIXTURES = {
            "ratio_1x1.jpg", "ratio_3x2.jpg", "ratio_2x3.jpg", "ratio_4x3.jpg",
            "ratio_3x4.jpg", "ratio_16x9.jpg", "ratio_9x16.jpg",
            "exif_rotate_90.jpg", "exif_mirrored.jpg", "already_ready.jpg"
    };

    @Override public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
        Bundle result = new Bundle();
        try {
            File root = new File(getTargetContext().getFilesDir(), "geometry-proof");
            if (!root.exists() && !root.mkdirs()) throw new IllegalStateException("mkdir failed");
            for (String fixture : FIXTURES) {
                File source = materialize(fixture, root);
                if (fixture.equals("exif_mirrored.jpg")) {
                    ExifInterface exif = new ExifInterface(source.getAbsolutePath());
                    exif.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(ExifInterface.ORIENTATION_FLIP_HORIZONTAL));
                    exif.saveAttributes();
                }
                BitmapFactory.Options bounds = new BitmapFactory.Options();
                bounds.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(source.getAbsolutePath(), bounds);
                ExifInterface exif = new ExifInterface(source.getAbsolutePath());
                int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                boolean swapsAxes = orientation == ExifInterface.ORIENTATION_ROTATE_90
                        || orientation == ExifInterface.ORIENTATION_ROTATE_270
                        || orientation == ExifInterface.ORIENTATION_TRANSPOSE
                        || orientation == ExifInterface.ORIENTATION_TRANSVERSE;
                int displayW = swapsAxes
                        ? bounds.outHeight : bounds.outWidth;
                int displayH = swapsAxes
                        ? bounds.outWidth : bounds.outHeight;
                Uri uri = publish(source, fixture);
                ImageInfo info = new ImageInfo(uri, fixture, "image/jpeg", source.length(), displayW, displayH);
                long target = fixture.equals("already_ready.jpg") ? source.length() + 1 : 1000;
                CompressionResult actual = JpegCompressionEngine.compressKnown(getTargetContext(), info, target);
                File output = actual.resultFile;
                File retainedOutput = new File(root, fixture + ".output.jpg");
                copy(output, retainedOutput);
                BitmapFactory.Options outputBounds = new BitmapFactory.Options();
                BitmapFactory.decodeFile(retainedOutput.getAbsolutePath(), outputBounds);
                String key = fixture.replace('.', '_');
                result.putString(key, String.format(Locale.US,
                        "%s|%d|%d|%d|%s|%s|%d|%d|%d|%s|%s",
                        fixture, bounds.outWidth, bounds.outHeight, orientation, actual.state.name(),
                        Boolean.toString(actual.resized), retainedOutput.length(), outputBounds.outWidth,
                        outputBounds.outHeight, sha256(source), sha256(retainedOutput)));
            }
            result.putString("output_root", root.getAbsolutePath());
            finish(Activity.RESULT_OK, result);
        } catch (Throwable t) {
            result.putString("error", t.toString());
            finish(Activity.RESULT_CANCELED, result);
        }
    }

    private File materialize(String name, File root) throws Exception {
        File out = new File(root, name);
        String assetName = name.equals("exif_rotate_90.jpg") ? "exif_orientation_6_1600x1200.jpg"
                : name.equals("exif_mirrored.jpg") ? "ratio_3x2.jpg" : name;
        try (InputStream in = getContext().getAssets().open("fixtures/" + assetName);
             OutputStream os = new FileOutputStream(out)) {
            byte[] b = new byte[8192]; int n; while ((n = in.read(b)) != -1) os.write(b, 0, n);
        }
        return out;
    }

    private Uri publish(File file, String name) throws Exception {
        ContentValues v = new ContentValues();
        v.put(MediaStore.Images.Media.DISPLAY_NAME, name);
        v.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        v.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/S5GeometryProof");
        Uri uri = getTargetContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, v);
        if (uri == null) throw new IllegalStateException("MediaStore insert failed");
        try (InputStream in = new FileInputStream(file); OutputStream out = getTargetContext().getContentResolver().openOutputStream(uri)) {
            byte[] b = new byte[8192]; int n; while ((n = in.read(b)) != -1) out.write(b, 0, n);
        }
        return uri;
    }

    private static void copy(File source, File destination) throws Exception {
        try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(destination)) {
            byte[] b = new byte[8192]; int n; while ((n = in.read(b)) != -1) out.write(b, 0, n);
        }
    }

    private static String sha256(File file) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        try (InputStream in = new FileInputStream(file)) { byte[] b = new byte[8192]; int n; while ((n = in.read(b)) != -1) md.update(b, 0, n); }
        StringBuilder s = new StringBuilder(); for (byte b : md.digest()) s.append(String.format(Locale.US, "%02x", b)); return s.toString();
    }
}
