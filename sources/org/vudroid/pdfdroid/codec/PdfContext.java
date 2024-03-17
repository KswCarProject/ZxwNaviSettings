package org.vudroid.pdfdroid.codec;

import android.content.ContentResolver;
import org.vudroid.core.VuDroidLibraryLoader;
import org.vudroid.core.codec.CodecContext;
import org.vudroid.core.codec.CodecDocument;

public class PdfContext implements CodecContext {
    public void recycle() {
    }

    public void setContentResolver(ContentResolver contentResolver) {
    }

    static {
        VuDroidLibraryLoader.load();
    }

    public CodecDocument openDocument(String str) {
        return PdfDocument.openDocument(str, "");
    }
}
