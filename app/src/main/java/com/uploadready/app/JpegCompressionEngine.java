package com.uploadready.app;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;

import com.uploadready.app.core.QualitySearch;
import com.uploadready.app.core.ScalePlanner;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

final class JpegCompressionEngine {
    private static final int MIN_QUALITY = 40;
    private static final int MAX_QUALITY = 95;
    private static final int MAX_LONG_EDGE = 4096;
    private static final int QUALITY_GUARD_LONG_EDGE = 720;
    private static final int MAX_RESIZE_PASSES = 8;

    private JpegCompressionEngine() {}

    static CompressionResult compressKnown(Context context, ImageInfo info, long targetBytes) {
        try {
            if (targetBytes <= 0) throw new IllegalArgumentException("Target must be positive");
            if (!isJpeg(info.mimeType, info.displayName)) {
                return error(info, targetBytes, "This vertical slice currently supports JPEG/JPG input only.");
            }
            if (info.sizeBytes <= targetBytes) {
                java.io.File f = ResultStore.copySource(context, info.uri);
                return new CompressionResult(CompressionResult.State.ALREADY_READY, f, info.sizeBytes,
                        f.length(), targetBytes, info.width, info.height, 100, false,
                        "The selected photo already meets the website limit. No recompression was needed.");
            }
            return compressToTarget(context, info, targetBytes, CompressionResult.State.PASS, true);
        } catch (Exception e) {
            return error(info, targetBytes, e.getMessage() == null ? "Compression failed" : e.getMessage());
        }
    }

    static CompressionResult reduceUnknown(Context context, ImageInfo info) {
        try {
            if (!isJpeg(info.mimeType, info.displayName)) {
                return error(info, 0, "This vertical slice currently supports JPEG/JPG input only.");
            }
            if (info.sizeBytes <= 64L * 1024L) {
                java.io.File f = ResultStore.copySource(context, info.uri);
                return new CompressionResult(CompressionResult.State.ALREADY_SMALL, f, info.sizeBytes,
                        f.length(), 0, info.width, info.height, 100, false,
                        "The photo is already very small. No upload-limit guarantee is possible without the website requirement.");
            }
            long target = Math.max(48L * 1024L, info.sizeBytes / 2L);
            CompressionResult r = compressToTarget(context, info, target, CompressionResult.State.REDUCED, true);
            if (r.state == CompressionResult.State.PASS) {
                return new CompressionResult(CompressionResult.State.REDUCED, r.resultFile, r.sourceBytes,
                        r.outputBytes, 0, r.width, r.height, r.jpegQuality, r.resized,
                        "Reduced locally. Upload compatibility is not verified because no website limit was provided.");
            }
            if (r.state == CompressionResult.State.NOT_MET && r.resultFile != null && r.outputBytes < info.sizeBytes) {
                return new CompressionResult(CompressionResult.State.REDUCED, r.resultFile, r.sourceBytes,
                        r.outputBytes, 0, r.width, r.height, r.jpegQuality, r.resized,
                        "Reduced locally. Upload compatibility is not verified because no website limit was provided.");
            }
            return r;
        } catch (Exception e) {
            return error(info, 0, e.getMessage() == null ? "Compression failed" : e.getMessage());
        }
    }

    private static CompressionResult compressToTarget(Context context, ImageInfo info, long targetBytes,
                                                      CompressionResult.State successState,
                                                      boolean enforceQualityGuard) throws Exception {
        Bitmap bitmap = decodeOriented(context, info.uri, info.width, info.height);
        if (bitmap == null) throw new IllegalArgumentException("Unable to decode JPEG");

        Bitmap working = bitmap;
        boolean resized = working.getWidth() != info.width || working.getHeight() != info.height;
        byte[] bestBytes = null;
        int bestQ = MIN_QUALITY;
        int bestW = working.getWidth();
        int bestH = working.getHeight();

        try {
            for (int pass = 0; pass <= MAX_RESIZE_PASSES; pass++) {
                final Bitmap probeBitmap = working;
                QualitySearch.Result q = QualitySearch.highestQualityUnderTarget(
                        quality -> encodeSize(probeBitmap, quality),
                        MIN_QUALITY, MAX_QUALITY, safeInt(targetBytes));
                if (q != null) {
                    byte[] bytes = encode(probeBitmap, q.quality);
                    java.io.File f = ResultStore.write(context, bytes);
                    String successMessage = successState == CompressionResult.State.REDUCED
                            ? "Reduced locally. Upload compatibility is not verified because no website limit was provided."
                            : "Verified using actual output bytes.";
                    return new CompressionResult(successState, f, info.sizeBytes, bytes.length, targetBytes,
                            probeBitmap.getWidth(), probeBitmap.getHeight(), q.quality, resized, successMessage);
                }

                byte[] minBytes = encode(probeBitmap, MIN_QUALITY);
                if (bestBytes == null || minBytes.length < bestBytes.length) {
                    bestBytes = minBytes;
                    bestQ = MIN_QUALITY;
                    bestW = probeBitmap.getWidth();
                    bestH = probeBitmap.getHeight();
                }

                int currentLong = Math.max(probeBitmap.getWidth(), probeBitmap.getHeight());
                int originalLong = Math.max(info.width, info.height);
                int minAllowedLong = Math.min(originalLong, QUALITY_GUARD_LONG_EDGE);
                if (enforceQualityGuard && currentLong <= minAllowedLong) break;

                double scale = ScalePlanner.nextScale(minBytes.length, safeInt(targetBytes));
                int newW = ScalePlanner.scaledDimension(probeBitmap.getWidth(), scale);
                int newH = ScalePlanner.scaledDimension(probeBitmap.getHeight(), scale);
                int newLong = Math.max(newW, newH);

                if (enforceQualityGuard && newLong < minAllowedLong) {
                    double guardScale = (double) minAllowedLong / (double) currentLong;
                    newW = Math.max(1, (int) Math.round(probeBitmap.getWidth() * guardScale));
                    newH = Math.max(1, (int) Math.round(probeBitmap.getHeight() * guardScale));
                    if (newW == probeBitmap.getWidth() && newH == probeBitmap.getHeight()) break;
                }

                Bitmap next = Bitmap.createScaledBitmap(probeBitmap, newW, newH, true);
                if (working != bitmap && !working.isRecycled()) working.recycle();
                working = next;
                resized = true;
            }

            if (bestBytes == null) bestBytes = encode(working, MIN_QUALITY);
            java.io.File f = ResultStore.write(context, bestBytes);
            return new CompressionResult(CompressionResult.State.NOT_MET, f, info.sizeBytes, bestBytes.length,
                    targetBytes, bestW, bestH, bestQ, resized,
                    "Target not met without crossing the current quality guard (JPEG quality 40 / 720 px long-edge floor)." );
        } finally {
            if (working != bitmap && !working.isRecycled()) working.recycle();
            if (!bitmap.isRecycled()) bitmap.recycle();
        }
    }

    private static Bitmap decodeOriented(Context context, Uri uri, int srcW, int srcH) throws Exception {
        ContentResolver cr = context.getContentResolver();
        int sample = 1;
        int longEdge = Math.max(srcW, srcH);
        while (longEdge / sample > MAX_LONG_EDGE) sample *= 2;

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = sample;
        opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap;
        try (InputStream in = cr.openInputStream(uri)) {
            if (in == null) throw new IllegalArgumentException("Unable to open image");
            bitmap = BitmapFactory.decodeStream(in, null, opts);
        }
        if (bitmap == null) return null;

        int orientation = ExifInterface.ORIENTATION_NORMAL;
        try (InputStream exifIn = cr.openInputStream(uri)) {
            if (exifIn != null) {
                ExifInterface exif = new ExifInterface(exifIn);
                orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            }
        } catch (Exception ignored) { }

        Matrix m = new Matrix();
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90: m.postRotate(90); break;
            case ExifInterface.ORIENTATION_ROTATE_180: m.postRotate(180); break;
            case ExifInterface.ORIENTATION_ROTATE_270: m.postRotate(270); break;
            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL: m.postScale(-1, 1); break;
            case ExifInterface.ORIENTATION_FLIP_VERTICAL: m.postScale(1, -1); break;
            case ExifInterface.ORIENTATION_TRANSPOSE: m.postRotate(90); m.postScale(-1, 1); break;
            case ExifInterface.ORIENTATION_TRANSVERSE: m.postRotate(270); m.postScale(-1, 1); break;
            default: return bitmap;
        }
        Bitmap oriented = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
        if (oriented != bitmap) bitmap.recycle();
        return oriented;
    }

    private static byte[] encode(Bitmap bitmap, int quality) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        if (!bitmap.compress(Bitmap.CompressFormat.JPEG, quality, out)) {
            throw new IllegalStateException("JPEG encoder failed");
        }
        return out.toByteArray();
    }

    private static int encodeSize(Bitmap bitmap, int quality) throws Exception {
        return encode(bitmap, quality).length;
    }

    private static int safeInt(long bytes) {
        return bytes > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) bytes;
    }

    private static boolean isJpeg(String mime, String name) {
        if ("image/jpeg".equalsIgnoreCase(mime)) return true;
        String n = name == null ? "" : name.toLowerCase(java.util.Locale.US);
        return n.endsWith(".jpg") || n.endsWith(".jpeg");
    }

    private static CompressionResult error(ImageInfo info, long target, String message) {
        return new CompressionResult(CompressionResult.State.ERROR, null,
                info == null ? 0 : info.sizeBytes, 0, target,
                info == null ? 0 : info.width, info == null ? 0 : info.height,
                0, false, message);
    }
}
