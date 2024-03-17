package org.vudroid.core;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.vudroid.core.DecodeService;
import org.vudroid.core.codec.CodecContext;
import org.vudroid.core.codec.CodecDocument;
import org.vudroid.core.codec.CodecPage;
import org.vudroid.core.utils.PathFromUri;

public class DecodeServiceBase implements DecodeService {
    public static final String DECODE_SERVICE = "ViewDroidDecodeService";
    private static final int PAGE_POOL_SIZE = 16;
    /* access modifiers changed from: private */
    public final CodecContext codecContext;
    private View containerView;
    private ContentResolver contentResolver;
    private final Map<Object, Future<?>> decodingFutures = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public CodecDocument document;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private boolean isRecycled;
    private Queue<Integer> pageEvictionQueue = new LinkedList();
    /* access modifiers changed from: private */
    public final HashMap<Integer, SoftReference<CodecPage>> pages = new HashMap<>();

    public DecodeServiceBase(CodecContext codecContext2) {
        this.codecContext = codecContext2;
    }

    public void setContentResolver(ContentResolver contentResolver2) {
        this.contentResolver = contentResolver2;
        this.codecContext.setContentResolver(contentResolver2);
    }

    public void setContainerView(View view) {
        this.containerView = view;
    }

    public void open(Uri uri) {
        this.document = this.codecContext.openDocument(PathFromUri.retrieve(this.contentResolver, uri));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decodePage(java.lang.Object r10, int r11, org.vudroid.core.DecodeService.DecodeCallback r12, float r13, android.graphics.RectF r14) {
        /*
            r9 = this;
            org.vudroid.core.DecodeServiceBase$DecodeTask r8 = new org.vudroid.core.DecodeServiceBase$DecodeTask
            r7 = 0
            r0 = r8
            r1 = r9
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r10
            r6 = r14
            r0.<init>(r2, r3, r4, r5, r6)
            java.util.Map<java.lang.Object, java.util.concurrent.Future<?>> r11 = r9.decodingFutures
            monitor-enter(r11)
            boolean r12 = r9.isRecycled     // Catch:{ all -> 0x0031 }
            if (r12 == 0) goto L_0x0016
            monitor-exit(r11)     // Catch:{ all -> 0x0031 }
            return
        L_0x0016:
            java.util.concurrent.ExecutorService r12 = r9.executorService     // Catch:{ all -> 0x0031 }
            org.vudroid.core.DecodeServiceBase$1 r13 = new org.vudroid.core.DecodeServiceBase$1     // Catch:{ all -> 0x0031 }
            r13.<init>(r8)     // Catch:{ all -> 0x0031 }
            java.util.concurrent.Future r12 = r12.submit(r13)     // Catch:{ all -> 0x0031 }
            java.util.Map<java.lang.Object, java.util.concurrent.Future<?>> r13 = r9.decodingFutures     // Catch:{ all -> 0x0031 }
            java.lang.Object r10 = r13.put(r10, r12)     // Catch:{ all -> 0x0031 }
            java.util.concurrent.Future r10 = (java.util.concurrent.Future) r10     // Catch:{ all -> 0x0031 }
            if (r10 == 0) goto L_0x002f
            r12 = 0
            r10.cancel(r12)     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r11)     // Catch:{ all -> 0x0031 }
            return
        L_0x0031:
            r10 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0031 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vudroid.core.DecodeServiceBase.decodePage(java.lang.Object, int, org.vudroid.core.DecodeService$DecodeCallback, float, android.graphics.RectF):void");
    }

    public void stopDecoding(Object obj) {
        Future remove = this.decodingFutures.remove(obj);
        if (remove != null) {
            remove.cancel(false);
        }
    }

    /* access modifiers changed from: private */
    public void performDecode(DecodeTask decodeTask) throws IOException {
        if (isTaskDead(decodeTask)) {
            Log.d(DECODE_SERVICE, "Skipping decode task for page " + decodeTask.pageNumber);
            return;
        }
        Log.d(DECODE_SERVICE, "Starting decode of page: " + decodeTask.pageNumber);
        CodecPage page = getPage(decodeTask.pageNumber);
        preloadNextPage(decodeTask.pageNumber);
        if (!isTaskDead(decodeTask)) {
            Log.d(DECODE_SERVICE, "Start converting map to bitmap");
            float calculateScale = calculateScale(page) * decodeTask.zoom;
            Bitmap renderBitmap = page.renderBitmap(getScaledWidth(decodeTask, page, calculateScale), getScaledHeight(decodeTask, page, calculateScale), decodeTask.pageSliceBounds);
            Log.d(DECODE_SERVICE, "Converting map to bitmap finished");
            if (isTaskDead(decodeTask)) {
                renderBitmap.recycle();
            } else {
                finishDecoding(decodeTask, renderBitmap);
            }
        }
    }

    private int getScaledHeight(DecodeTask decodeTask, CodecPage codecPage, float f) {
        return Math.round(((float) getScaledHeight(codecPage, f)) * decodeTask.pageSliceBounds.height());
    }

    private int getScaledWidth(DecodeTask decodeTask, CodecPage codecPage, float f) {
        return Math.round(((float) getScaledWidth(codecPage, f)) * decodeTask.pageSliceBounds.width());
    }

    private int getScaledHeight(CodecPage codecPage, float f) {
        return (int) (f * ((float) codecPage.getHeight()));
    }

    private int getScaledWidth(CodecPage codecPage, float f) {
        return (int) (f * ((float) codecPage.getWidth()));
    }

    private float calculateScale(CodecPage codecPage) {
        return (((float) getTargetWidth()) * 1.0f) / ((float) codecPage.getWidth());
    }

    private void finishDecoding(DecodeTask decodeTask, Bitmap bitmap) {
        updateImage(decodeTask, bitmap);
        stopDecoding(Integer.valueOf(decodeTask.pageNumber));
    }

    private void preloadNextPage(int i) throws IOException {
        int i2 = i + 1;
        if (i2 < getPageCount()) {
            getPage(i2);
        }
    }

    public CodecPage getPage(int i) {
        if (!this.pages.containsKey(Integer.valueOf(i)) || this.pages.get(Integer.valueOf(i)).get() == null) {
            this.pages.put(Integer.valueOf(i), new SoftReference(this.document.getPage(i)));
            this.pageEvictionQueue.remove(Integer.valueOf(i));
            this.pageEvictionQueue.offer(Integer.valueOf(i));
            if (this.pageEvictionQueue.size() > 16) {
                CodecPage codecPage = (CodecPage) this.pages.remove(this.pageEvictionQueue.poll()).get();
                if (codecPage != null) {
                    codecPage.recycle();
                }
            }
        }
        return (CodecPage) this.pages.get(Integer.valueOf(i)).get();
    }

    private void waitForDecode(CodecPage codecPage) {
        codecPage.waitForDecode();
    }

    private int getTargetWidth() {
        return this.containerView.getWidth();
    }

    public int getEffectivePagesWidth() {
        CodecPage page = getPage(0);
        return getScaledWidth(page, calculateScale(page));
    }

    public int getEffectivePagesHeight() {
        CodecPage page = getPage(0);
        return getScaledHeight(page, calculateScale(page));
    }

    public int getPageWidth(int i) {
        return getPage(i).getWidth();
    }

    public int getPageHeight(int i) {
        return getPage(i).getHeight();
    }

    private void updateImage(DecodeTask decodeTask, Bitmap bitmap) {
        decodeTask.decodeCallback.decodeComplete(bitmap);
    }

    private boolean isTaskDead(DecodeTask decodeTask) {
        boolean z;
        synchronized (this.decodingFutures) {
            z = !this.decodingFutures.containsKey(decodeTask.decodeKey);
        }
        return z;
    }

    public int getPageCount() {
        return this.document.getPageCount();
    }

    private class DecodeTask {
        /* access modifiers changed from: private */
        public final DecodeService.DecodeCallback decodeCallback;
        /* access modifiers changed from: private */
        public final Object decodeKey;
        /* access modifiers changed from: private */
        public final int pageNumber;
        /* access modifiers changed from: private */
        public final RectF pageSliceBounds;
        /* access modifiers changed from: private */
        public final float zoom;

        private DecodeTask(int i, DecodeService.DecodeCallback decodeCallback2, float f, Object obj, RectF rectF) {
            this.pageNumber = i;
            this.decodeCallback = decodeCallback2;
            this.zoom = f;
            this.decodeKey = obj;
            this.pageSliceBounds = rectF;
        }
    }

    public void recycle() {
        synchronized (this.decodingFutures) {
            this.isRecycled = true;
        }
        for (Object stopDecoding : this.decodingFutures.keySet()) {
            stopDecoding(stopDecoding);
        }
        this.executorService.submit(new Runnable() {
            public void run() {
                for (SoftReference softReference : DecodeServiceBase.this.pages.values()) {
                    CodecPage codecPage = (CodecPage) softReference.get();
                    if (codecPage != null) {
                        codecPage.recycle();
                    }
                }
                DecodeServiceBase.this.document.recycle();
                DecodeServiceBase.this.codecContext.recycle();
            }
        });
        this.executorService.shutdown();
    }
}
