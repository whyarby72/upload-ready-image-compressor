package com.uploadready.app;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;

import java.io.File;
import java.io.FileNotFoundException;

public final class ResultContentProvider extends ContentProvider {
    static final String AUTHORITY = "com.uploadready.app.result";
    static final Uri RESULT_URI = Uri.parse("content://" + AUTHORITY + "/result");

    @Override public boolean onCreate() { return true; }

    @Override public String getType(Uri uri) {
        requireResult(uri);
        return "image/jpeg";
    }

    @Override public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        requireResult(uri);
        if (!"r".equals(mode)) throw new FileNotFoundException("Read-only provider");
        File f = ResultStore.resultFile(getContext());
        if (!f.isFile()) throw new FileNotFoundException("No result available");
        return ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY);
    }

    private static void requireResult(Uri uri) {
        if (uri == null || !AUTHORITY.equals(uri.getAuthority()) || !"/result".equals(uri.getPath())) {
            throw new IllegalArgumentException("Unsupported URI");
        }
    }

    @Override public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        requireResult(uri);
        File f = ResultStore.resultFile(getContext());
        String[] cols = projection == null ? new String[]{OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE} : projection;
        MatrixCursor cursor = new MatrixCursor(cols, 1);
        MatrixCursor.RowBuilder row = cursor.newRow();
        for (String col : cols) {
            if (OpenableColumns.DISPLAY_NAME.equals(col)) row.add("UploadReady_result.jpg");
            else if (OpenableColumns.SIZE.equals(col)) row.add(f.isFile() ? f.length() : 0L);
            else row.add(null);
        }
        return cursor;
    }
    @Override public Uri insert(Uri uri, ContentValues values) { throw new UnsupportedOperationException(); }
    @Override public int delete(Uri uri, String selection, String[] selectionArgs) { throw new UnsupportedOperationException(); }
    @Override public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) { throw new UnsupportedOperationException(); }
}
