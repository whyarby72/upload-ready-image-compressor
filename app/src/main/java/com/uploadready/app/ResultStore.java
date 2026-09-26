package com.uploadready.app;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

final class ResultStore {
    private ResultStore() {}

    static File resultFile(Context context) {
        File dir = new File(context.getCacheDir(), "share");
        if (!dir.exists() && !dir.mkdirs()) throw new IllegalStateException("Cannot create result cache");
        return new File(dir, "result.jpg");
    }

    static File write(Context context, byte[] data) throws Exception {
        File f = resultFile(context);
        try (FileOutputStream out = new FileOutputStream(f, false)) {
            out.write(data);
            out.flush();
        }
        return f;
    }

    static File copySource(Context context, android.net.Uri uri) throws Exception {
        File f = resultFile(context);
        try (InputStream in = context.getContentResolver().openInputStream(uri);
             FileOutputStream out = new FileOutputStream(f, false)) {
            if (in == null) throw new IllegalArgumentException("Unable to open source");
            byte[] buf = new byte[8192];
            int r;
            while ((r = in.read(buf)) != -1) out.write(buf, 0, r);
            out.flush();
        }
        return f;
    }
}
