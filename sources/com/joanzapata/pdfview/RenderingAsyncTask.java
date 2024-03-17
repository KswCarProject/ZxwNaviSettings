package com.joanzapata.pdfview;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.AsyncTask;
import com.joanzapata.pdfview.model.PagePart;
import java.util.ArrayList;
import java.util.List;
import org.vudroid.core.DecodeService;
import org.vudroid.core.codec.CodecPage;

class RenderingAsyncTask extends AsyncTask<Void, PagePart, Void> {
    private DecodeService decodeService;
    private PDFView pdfView;
    private List<RenderingTask> renderingTasks = new ArrayList();

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    public RenderingAsyncTask(PDFView pDFView) {
        this.pdfView = pDFView;
    }

    public void addRenderingTask(int i, int i2, float f, float f2, RectF rectF, boolean z, int i3) {
        this.renderingTasks.add(new RenderingTask(f, f2, rectF, i, i2, z, i3));
        wakeUp();
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        while (!isCancelled()) {
            while (!this.renderingTasks.isEmpty()) {
                RenderingTask renderingTask = this.renderingTasks.get(0);
                PagePart proceed = proceed(renderingTask);
                if (this.renderingTasks.remove(renderingTask)) {
                    publishProgress(new PagePart[]{proceed});
                } else {
                    proceed.getRenderedBitmap().recycle();
                }
            }
            if (waitForRenderingTasks()) {
                if (isCancelled()) {
                    break;
                }
            } else {
                break;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(PagePart... pagePartArr) {
        this.pdfView.onBitmapRendered(pagePartArr[0]);
    }

    private boolean waitForRenderingTasks() {
        try {
            synchronized (this.renderingTasks) {
                this.renderingTasks.wait();
            }
            return true;
        } catch (InterruptedException unused) {
            return false;
        }
    }

    private PagePart proceed(RenderingTask renderingTask) {
        Bitmap renderBitmap;
        DecodeService decodeService2 = this.pdfView.getDecodeService();
        this.decodeService = decodeService2;
        CodecPage page = decodeService2.getPage(renderingTask.page);
        synchronized (this.decodeService.getClass()) {
            renderBitmap = page.renderBitmap(Math.round(renderingTask.width), Math.round(renderingTask.height), renderingTask.bounds);
        }
        return new PagePart(renderingTask.userPage, renderingTask.page, renderBitmap, renderingTask.width, renderingTask.height, renderingTask.bounds, renderingTask.thumbnail, renderingTask.cacheOrder);
    }

    public void removeAllTasks() {
        this.renderingTasks.clear();
    }

    public void wakeUp() {
        synchronized (this.renderingTasks) {
            this.renderingTasks.notify();
        }
    }

    private class RenderingTask {
        RectF bounds;
        int cacheOrder;
        float height;
        int page;
        boolean thumbnail;
        int userPage;
        float width;

        public RenderingTask(float f, float f2, RectF rectF, int i, int i2, boolean z, int i3) {
            this.page = i2;
            this.width = f;
            this.height = f2;
            this.bounds = rectF;
            this.userPage = i;
            this.thumbnail = z;
            this.cacheOrder = i3;
        }
    }
}
