package com.joanzapata.pdfview;

import android.net.Uri;
import android.os.AsyncTask;
import org.vudroid.core.DecodeService;
import org.vudroid.core.DecodeServiceBase;
import org.vudroid.pdfdroid.codec.PdfContext;

class DecodingAsyncTask extends AsyncTask<Void, Void, Void> {
    private boolean cancelled = false;
    private DecodeService decodeService;
    private PDFView pdfView;
    private Uri uri;

    public DecodingAsyncTask(Uri uri2, PDFView pDFView) {
        this.pdfView = pDFView;
        this.uri = uri2;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        DecodeServiceBase decodeServiceBase = new DecodeServiceBase(new PdfContext());
        this.decodeService = decodeServiceBase;
        decodeServiceBase.setContentResolver(this.pdfView.getContext().getContentResolver());
        this.decodeService.open(this.uri);
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Void voidR) {
        if (!this.cancelled) {
            this.pdfView.loadComplete(this.decodeService);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        this.cancelled = true;
    }
}
