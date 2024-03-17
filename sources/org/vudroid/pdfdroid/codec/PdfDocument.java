package org.vudroid.pdfdroid.codec;

import org.vudroid.core.codec.CodecDocument;
import org.vudroid.core.codec.CodecPage;

public class PdfDocument implements CodecDocument {
    private static final int FITZMEMORY = 524288;
    private long docHandle;

    private static native void free(long j);

    private static native int getPageCount(long j);

    private static native long open(int i, String str, String str2);

    private PdfDocument(long j) {
        this.docHandle = j;
    }

    public CodecPage getPage(int i) {
        return PdfPage.createPage(this.docHandle, i + 1);
    }

    public int getPageCount() {
        return getPageCount(this.docHandle);
    }

    static PdfDocument openDocument(String str, String str2) {
        return new PdfDocument(open(524288, str, str2));
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        recycle();
        super.finalize();
    }

    public synchronized void recycle() {
        long j = this.docHandle;
        if (j != 0) {
            free(j);
            this.docHandle = 0;
        }
    }
}
