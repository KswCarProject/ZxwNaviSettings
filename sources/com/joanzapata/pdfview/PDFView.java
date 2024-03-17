package com.joanzapata.pdfview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.SurfaceView;
import androidx.core.view.ViewCompat;
import com.joanzapata.pdfview.SpiralLoopManager;
import com.joanzapata.pdfview.exception.FileNotFoundException;
import com.joanzapata.pdfview.listener.OnDrawListener;
import com.joanzapata.pdfview.listener.OnLoadCompleteListener;
import com.joanzapata.pdfview.listener.OnPageChangeListener;
import com.joanzapata.pdfview.model.PagePart;
import com.joanzapata.pdfview.util.ArrayUtils;
import com.joanzapata.pdfview.util.Constants;
import com.joanzapata.pdfview.util.FileUtils;
import com.joanzapata.pdfview.util.NumberUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.vudroid.core.DecodeService;

public class PDFView extends SurfaceView {
    private static final String TAG = "PDFView";
    private AnimationManager animationManager = new AnimationManager(this);
    /* access modifiers changed from: private */
    public CacheManager cacheManager = new CacheManager();
    private int currentFilteredPage;
    private int currentPage;
    private float currentXOffset = 0.0f;
    private float currentYOffset = 0.0f;
    private Paint debugPaint;
    private DecodeService decodeService;
    private DecodingAsyncTask decodingAsyncTask;
    private int defaultPage = 0;
    private int documentPageCount;
    /* access modifiers changed from: private */
    public DragPinchManager dragPinchManager = new DragPinchManager(this);
    private int[] filteredUserPageIndexes;
    private int[] filteredUserPages;
    private RectF leftMask;
    /* access modifiers changed from: private */
    public Paint maskPaint;
    private boolean miniMapRequired = false;
    private RectF minimapBounds;
    private RectF minimapScreenBounds;
    private OnDrawListener onDrawListener;
    private OnLoadCompleteListener onLoadCompleteListener;
    private OnPageChangeListener onPageChangeListener;
    private float optimalPageHeight;
    private float optimalPageWidth;
    private int[] originalUserPages;
    private int pageHeight;
    private int pageWidth;
    private Paint paint = new Paint();
    private Paint paintMinimapBack;
    private Paint paintMinimapFront;
    private boolean recycled = true;
    /* access modifiers changed from: private */
    public RenderingAsyncTask renderingAsyncTask;
    private RectF rightMask;
    private State state = State.DEFAULT;
    private boolean swipeVertical = false;
    private boolean userWantsMinimap = false;
    private float zoom = 1.0f;

    private enum State {
        DEFAULT,
        LOADED,
        SHOWN
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint2 = new Paint();
        this.debugPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.paintMinimapBack = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.paintMinimapBack.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.paintMinimapBack.setAlpha(50);
        Paint paint4 = new Paint();
        this.paintMinimapFront = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.paintMinimapFront.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.paintMinimapFront.setAlpha(50);
        setWillNotDraw(false);
    }

    /* access modifiers changed from: private */
    public void load(Uri uri, OnLoadCompleteListener onLoadCompleteListener2) {
        load(uri, onLoadCompleteListener2, (int[]) null);
    }

    /* access modifiers changed from: private */
    public void load(Uri uri, OnLoadCompleteListener onLoadCompleteListener2, int[] iArr) {
        if (this.recycled) {
            if (iArr != null) {
                this.originalUserPages = iArr;
                this.filteredUserPages = ArrayUtils.deleteDuplicatedPages(iArr);
                this.filteredUserPageIndexes = ArrayUtils.calculateIndexesInDuplicateArray(this.originalUserPages);
            }
            this.onLoadCompleteListener = onLoadCompleteListener2;
            DecodingAsyncTask decodingAsyncTask2 = new DecodingAsyncTask(uri, this);
            this.decodingAsyncTask = decodingAsyncTask2;
            decodingAsyncTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            RenderingAsyncTask renderingAsyncTask2 = new RenderingAsyncTask(this);
            this.renderingAsyncTask = renderingAsyncTask2;
            renderingAsyncTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
    }

    public void jumpTo(int i) {
        showPage(i - 1);
    }

    /* access modifiers changed from: package-private */
    public void showPage(int i) {
        this.state = State.SHOWN;
        int determineValidPageNumberFrom = determineValidPageNumberFrom(i);
        this.currentPage = determineValidPageNumberFrom;
        this.currentFilteredPage = determineValidPageNumberFrom;
        int[] iArr = this.filteredUserPageIndexes;
        if (iArr != null && determineValidPageNumberFrom >= 0 && determineValidPageNumberFrom < iArr.length) {
            determineValidPageNumberFrom = iArr[determineValidPageNumberFrom];
            this.currentFilteredPage = determineValidPageNumberFrom;
        }
        resetZoom();
        if (this.swipeVertical) {
            this.animationManager.startYAnimation(this.currentYOffset, calculateCenterOffsetForPage(determineValidPageNumberFrom));
        } else {
            this.animationManager.startXAnimation(this.currentXOffset, calculateCenterOffsetForPage(determineValidPageNumberFrom));
        }
        loadPages();
        OnPageChangeListener onPageChangeListener2 = this.onPageChangeListener;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageChanged(this.currentPage + 1, getPageCount());
        }
    }

    public int getPageCount() {
        int[] iArr = this.originalUserPages;
        if (iArr != null) {
            return iArr.length;
        }
        return this.documentPageCount;
    }

    public void enableSwipe(boolean z) {
        this.dragPinchManager.setSwipeEnabled(z);
    }

    /* access modifiers changed from: private */
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener2) {
        this.onPageChangeListener = onPageChangeListener2;
    }

    /* access modifiers changed from: private */
    public void setOnDrawListener(OnDrawListener onDrawListener2) {
        this.onDrawListener = onDrawListener2;
    }

    public void recycle() {
        RenderingAsyncTask renderingAsyncTask2 = this.renderingAsyncTask;
        if (renderingAsyncTask2 != null) {
            renderingAsyncTask2.cancel(true);
        }
        DecodingAsyncTask decodingAsyncTask2 = this.decodingAsyncTask;
        if (decodingAsyncTask2 != null) {
            decodingAsyncTask2.cancel(true);
        }
        this.cacheManager.recycle();
        this.recycled = true;
        this.state = State.DEFAULT;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        recycle();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.animationManager.stopAll();
        calculateOptimalWidthAndHeight();
        loadPages();
        if (this.swipeVertical) {
            moveTo(this.currentXOffset, calculateCenterOffsetForPage(this.currentFilteredPage));
        } else {
            moveTo(calculateCenterOffsetForPage(this.currentFilteredPage), this.currentYOffset);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawColor(-1);
        if (this.state == State.SHOWN) {
            float f = this.currentXOffset;
            float f2 = this.currentYOffset;
            canvas.translate(f, f2);
            Iterator<PagePart> it = this.cacheManager.getThumbnails().iterator();
            while (it.hasNext()) {
                drawPart(canvas, it.next());
            }
            Iterator<PagePart> it2 = this.cacheManager.getPageParts().iterator();
            while (it2.hasNext()) {
                drawPart(canvas, it2.next());
            }
            if (this.onDrawListener != null) {
                canvas.translate(toCurrentScale(((float) this.currentFilteredPage) * this.optimalPageWidth), 0.0f);
                this.onDrawListener.onLayerDrawn(canvas, toCurrentScale(this.optimalPageWidth), toCurrentScale(this.optimalPageHeight), this.currentPage);
                canvas.translate(-toCurrentScale(((float) this.currentFilteredPage) * this.optimalPageWidth), 0.0f);
            }
            canvas.translate(-f, -f2);
            canvas.drawRect(this.leftMask, this.maskPaint);
            canvas.drawRect(this.rightMask, this.maskPaint);
            if (this.userWantsMinimap && this.miniMapRequired) {
                drawMiniMap(canvas);
            }
        }
    }

    public void onLayerUpdate() {
        invalidate();
    }

    private void drawPart(Canvas canvas, PagePart pagePart) {
        float f;
        float f2;
        RectF pageRelativeBounds = pagePart.getPageRelativeBounds();
        Bitmap renderedBitmap = pagePart.getRenderedBitmap();
        if (this.swipeVertical) {
            f2 = toCurrentScale(((float) pagePart.getUserPage()) * this.optimalPageHeight);
            f = 0.0f;
        } else {
            f = toCurrentScale(((float) pagePart.getUserPage()) * this.optimalPageWidth);
            f2 = 0.0f;
        }
        canvas.translate(f, f2);
        Rect rect = new Rect(0, 0, renderedBitmap.getWidth(), renderedBitmap.getHeight());
        float currentScale = toCurrentScale(pageRelativeBounds.left * this.optimalPageWidth);
        float currentScale2 = toCurrentScale(pageRelativeBounds.top * this.optimalPageHeight);
        RectF rectF = new RectF((float) ((int) currentScale), (float) ((int) currentScale2), (float) ((int) (currentScale + toCurrentScale(pageRelativeBounds.width() * this.optimalPageWidth))), (float) ((int) (currentScale2 + toCurrentScale(pageRelativeBounds.height() * this.optimalPageHeight))));
        float f3 = this.currentXOffset + f;
        float f4 = this.currentYOffset + f2;
        if (rectF.left + f3 >= ((float) getWidth()) || f3 + rectF.right <= 0.0f || rectF.top + f4 >= ((float) getHeight()) || f4 + rectF.bottom <= 0.0f) {
            canvas.translate(-f, -f2);
            return;
        }
        canvas.drawBitmap(renderedBitmap, rect, rectF, this.paint);
        canvas.translate(-f, -f2);
    }

    private void drawMiniMap(Canvas canvas) {
        canvas.drawRect(this.minimapBounds, this.paintMinimapBack);
        canvas.drawRect(this.minimapScreenBounds, this.paintMinimapFront);
    }

    public void loadPages() {
        if (this.optimalPageWidth != 0.0f && this.optimalPageHeight != 0.0f) {
            this.renderingAsyncTask.removeAllTasks();
            this.cacheManager.makeANewSet();
            int i = this.currentPage;
            int[] iArr = this.filteredUserPageIndexes;
            if (iArr != null) {
                i = iArr[i];
            }
            int i2 = 0;
            for (int i3 = 0; i3 <= 1 && i2 < Constants.Cache.CACHE_SIZE; i3++) {
                i2 += loadPage(i + i3, Constants.Cache.CACHE_SIZE - i2);
                if (i3 != 0 && i2 < Constants.Cache.CACHE_SIZE) {
                    i2 += loadPage(i - i3, Constants.Cache.CACHE_SIZE - i2);
                }
            }
            invalidate();
        }
    }

    private int loadPage(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5 = i;
        int[] iArr = this.filteredUserPages;
        if (iArr == null) {
            i3 = i5;
        } else if (i5 < 0 || i5 >= iArr.length) {
            return 0;
        } else {
            i3 = iArr[i5];
        }
        if (i3 < 0 || i5 >= this.documentPageCount) {
            return 0;
        }
        if (!this.cacheManager.containsThumbnail(i, i3, (float) ((int) (this.optimalPageWidth * 0.2f)), (float) ((int) (this.optimalPageHeight * 0.2f)), new RectF(0.0f, 0.0f, 1.0f, 1.0f))) {
            f = 1.0f;
            i4 = 0;
            this.renderingAsyncTask.addRenderingTask(i, i3, (float) ((int) (this.optimalPageWidth * 0.2f)), (float) ((int) (this.optimalPageHeight * 0.2f)), new RectF(0.0f, 0.0f, 1.0f, 1.0f), true, 0);
        } else {
            f = 1.0f;
            i4 = 0;
        }
        float f2 = f / this.optimalPageWidth;
        float f3 = this.zoom;
        int ceil = (int) Math.ceil((double) (f / (((f / this.optimalPageHeight) * 256.0f) / f3)));
        int ceil2 = (int) Math.ceil((double) (f / ((f2 * 256.0f) / f3)));
        float f4 = (float) ceil2;
        float f5 = f / f4;
        float f6 = (float) ceil;
        float f7 = f / f6;
        float width = (-this.currentXOffset) + ((float) (getWidth() / 2));
        float height = (-this.currentYOffset) + ((float) (getHeight() / 2));
        if (this.swipeVertical) {
            width -= ((float) i5) * toCurrentScale(this.optimalPageWidth);
        } else {
            height -= ((float) i5) * toCurrentScale(this.optimalPageHeight);
        }
        float currentScale = width / toCurrentScale(this.optimalPageWidth);
        int limit = NumberUtils.limit((int) ((height / toCurrentScale(this.optimalPageHeight)) * f6), i4, ceil);
        int limit2 = NumberUtils.limit((int) (currentScale * f4), i4, ceil2);
        final float f8 = f5;
        final float f9 = f7;
        final int i6 = i;
        final int i7 = i3;
        final int i8 = i2;
        AnonymousClass1SpiralLoopListenerImpl r0 = new SpiralLoopManager.SpiralLoopListener() {
            int nbItemTreated = 0;

            public boolean onLoop(int i, int i2) {
                float f = f8;
                float f2 = ((float) i2) * f;
                float f3 = f9;
                float f4 = ((float) i) * f3;
                float f5 = 256.0f / f;
                float f6 = 256.0f / f3;
                if (f2 + f > 1.0f) {
                    f = 1.0f - f2;
                }
                if (f4 + f3 > 1.0f) {
                    f3 = 1.0f - f4;
                }
                float f7 = f5 * f;
                float f8 = f6 * f3;
                RectF rectF = new RectF(f2, f4, f + f2, f3 + f4);
                if (!(f7 == 0.0f || f8 == 0.0f)) {
                    if (!PDFView.this.cacheManager.upPartIfContained(i6, i7, f7, f8, rectF, this.nbItemTreated)) {
                        PDFView.this.renderingAsyncTask.addRenderingTask(i6, i7, f7, f8, rectF, false, this.nbItemTreated);
                    }
                }
                int i3 = this.nbItemTreated + 1;
                this.nbItemTreated = i3;
                if (i3 >= i8) {
                    return false;
                }
                return true;
            }
        };
        new SpiralLoopManager(r0).startLoop(ceil, ceil2, limit, limit2);
        return r0.nbItemTreated;
    }

    public void loadComplete(DecodeService decodeService2) {
        this.decodeService = decodeService2;
        this.documentPageCount = decodeService2.getPageCount();
        this.pageWidth = decodeService2.getPageWidth(0);
        this.pageHeight = decodeService2.getPageHeight(0);
        this.state = State.LOADED;
        calculateOptimalWidthAndHeight();
        jumpTo(this.defaultPage);
        OnLoadCompleteListener onLoadCompleteListener2 = this.onLoadCompleteListener;
        if (onLoadCompleteListener2 != null) {
            onLoadCompleteListener2.loadComplete(this.documentPageCount);
        }
    }

    public void onBitmapRendered(PagePart pagePart) {
        if (pagePart.isThumbnail()) {
            this.cacheManager.cacheThumbnail(pagePart);
        } else {
            this.cacheManager.cachePart(pagePart);
        }
        invalidate();
    }

    private int determineValidPageNumberFrom(int i) {
        if (i <= 0) {
            return 0;
        }
        int[] iArr = this.originalUserPages;
        if (iArr == null) {
            int i2 = this.documentPageCount;
            if (i >= i2) {
                return i2 - 1;
            }
        } else if (i >= iArr.length) {
            return iArr.length - 1;
        }
        return i;
    }

    private float calculateCenterOffsetForPage(int i) {
        float f;
        float width;
        float f2;
        if (this.swipeVertical) {
            f = -(((float) i) * this.optimalPageHeight);
            width = (float) (getHeight() / 2);
            f2 = this.optimalPageHeight;
        } else {
            f = -(((float) i) * this.optimalPageWidth);
            width = (float) (getWidth() / 2);
            f2 = this.optimalPageWidth;
        }
        return f + (width - (f2 / 2.0f));
    }

    private void calculateOptimalWidthAndHeight() {
        if (this.state != State.DEFAULT && getWidth() != 0) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            float f = ((float) this.pageWidth) / ((float) this.pageHeight);
            float floor = (float) Math.floor((double) (width / f));
            if (floor > height) {
                width = (float) Math.floor((double) (f * height));
            } else {
                height = floor;
            }
            this.optimalPageWidth = width;
            this.optimalPageHeight = height;
            calculateMasksBounds();
            calculateMinimapBounds();
        }
    }

    private void calculateMinimapBounds() {
        float min = Math.min(200.0f / this.optimalPageWidth, 200.0f / this.optimalPageHeight);
        this.minimapBounds = new RectF(((float) (getWidth() - 5)) - (this.optimalPageWidth * min), 5.0f, (float) (getWidth() - 5), (this.optimalPageHeight * min) + 5.0f);
        calculateMinimapAreaBounds();
    }

    private void calculateMinimapAreaBounds() {
        if (this.minimapBounds != null) {
            if (this.zoom == 1.0f) {
                this.miniMapRequired = false;
                return;
            }
            float currentScale = (((-this.currentXOffset) - toCurrentScale(((float) this.currentFilteredPage) * this.optimalPageWidth)) / toCurrentScale(this.optimalPageWidth)) * this.minimapBounds.width();
            float width = (((float) getWidth()) / toCurrentScale(this.optimalPageWidth)) * this.minimapBounds.width();
            float currentScale2 = ((-this.currentYOffset) / toCurrentScale(this.optimalPageHeight)) * this.minimapBounds.height();
            RectF rectF = new RectF(this.minimapBounds.left + currentScale, this.minimapBounds.top + currentScale2, this.minimapBounds.left + currentScale + width, this.minimapBounds.top + currentScale2 + ((((float) getHeight()) / toCurrentScale(this.optimalPageHeight)) * this.minimapBounds.height()));
            this.minimapScreenBounds = rectF;
            rectF.intersect(this.minimapBounds);
            this.miniMapRequired = true;
        }
    }

    private void calculateMasksBounds() {
        this.leftMask = new RectF(0.0f, 0.0f, ((float) (getWidth() / 2)) - (toCurrentScale(this.optimalPageWidth) / 2.0f), (float) getHeight());
        this.rightMask = new RectF(((float) (getWidth() / 2)) + (toCurrentScale(this.optimalPageWidth) / 2.0f), 0.0f, (float) getWidth(), (float) getHeight());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0187  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void moveTo(float r8, float r9) {
        /*
            r7 = this;
            boolean r0 = r7.swipeVertical
            r1 = 1056964608(0x3f000000, float:0.5)
            r2 = 0
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x00d8
            float r0 = r7.optimalPageWidth
            float r0 = r7.toCurrentScale(r0)
            int r6 = r7.getWidth()
            float r6 = (float) r6
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x002a
            int r8 = r7.getWidth()
            int r8 = r8 / 2
            float r8 = (float) r8
            float r0 = r7.optimalPageWidth
            float r0 = r7.toCurrentScale(r0)
            float r0 = r0 / r3
        L_0x0028:
            float r8 = r8 - r0
            goto L_0x004c
        L_0x002a:
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0030
            r8 = r4
            goto L_0x004c
        L_0x0030:
            float r0 = r7.optimalPageWidth
            float r0 = r7.toCurrentScale(r0)
            float r0 = r0 + r8
            int r3 = r7.getWidth()
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x004c
            int r8 = r7.getWidth()
            float r8 = (float) r8
            float r0 = r7.optimalPageWidth
            float r0 = r7.toCurrentScale(r0)
            goto L_0x0028
        L_0x004c:
            boolean r0 = r7.isZooming()
            if (r0 == 0) goto L_0x00bc
            float r0 = r7.optimalPageHeight
            float r0 = r7.toCurrentScale(r0)
            int r3 = r7.getHeight()
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0078
            r7.miniMapRequired = r2
            int r9 = r7.getHeight()
            int r9 = r9 / 2
            float r9 = (float) r9
            int r0 = r7.currentFilteredPage
            float r0 = (float) r0
            float r0 = r0 + r1
            float r1 = r7.optimalPageHeight
            float r0 = r0 * r1
            float r0 = r7.toCurrentScale(r0)
        L_0x0075:
            float r9 = r9 - r0
            goto L_0x01a0
        L_0x0078:
            r7.miniMapRequired = r5
            int r0 = r7.currentFilteredPage
            float r0 = (float) r0
            float r1 = r7.optimalPageHeight
            float r0 = r0 * r1
            float r0 = r7.toCurrentScale(r0)
            float r0 = r0 + r9
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0096
            int r9 = r7.currentFilteredPage
            float r9 = (float) r9
            float r0 = r7.optimalPageHeight
            float r9 = r9 * r0
            float r9 = r7.toCurrentScale(r9)
            float r9 = -r9
            goto L_0x01a0
        L_0x0096:
            int r0 = r7.currentFilteredPage
            int r0 = r0 + r5
            float r0 = (float) r0
            float r1 = r7.optimalPageHeight
            float r0 = r0 * r1
            float r0 = r7.toCurrentScale(r0)
            float r0 = r0 + r9
            int r1 = r7.getHeight()
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x01a0
            int r9 = r7.getHeight()
            float r9 = (float) r9
            int r0 = r7.currentFilteredPage
            int r0 = r0 + r5
            float r0 = (float) r0
            float r1 = r7.optimalPageHeight
            float r0 = r0 * r1
            float r0 = r7.toCurrentScale(r0)
            goto L_0x0075
        L_0x00bc:
            int r0 = r7.currentFilteredPage
            int r0 = r0 + r5
            float r0 = r7.calculateCenterOffsetForPage(r0)
            int r1 = r7.currentFilteredPage
            int r1 = r1 - r5
            float r1 = r7.calculateCenterOffsetForPage(r1)
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x00d1
            r9 = r0
            goto L_0x01a0
        L_0x00d1:
            int r0 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x01a0
            r9 = r1
            goto L_0x01a0
        L_0x00d8:
            float r0 = r7.optimalPageHeight
            float r0 = r7.toCurrentScale(r0)
            int r6 = r7.getHeight()
            float r6 = (float) r6
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00f7
            int r9 = r7.getHeight()
            int r9 = r9 / 2
            float r9 = (float) r9
            float r0 = r7.optimalPageHeight
            float r0 = r7.toCurrentScale(r0)
            float r0 = r0 / r3
        L_0x00f5:
            float r9 = r9 - r0
            goto L_0x0119
        L_0x00f7:
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00fd
            r9 = r4
            goto L_0x0119
        L_0x00fd:
            float r0 = r7.optimalPageHeight
            float r0 = r7.toCurrentScale(r0)
            float r0 = r0 + r9
            int r3 = r7.getHeight()
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0119
            int r9 = r7.getHeight()
            float r9 = (float) r9
            float r0 = r7.optimalPageHeight
            float r0 = r7.toCurrentScale(r0)
            goto L_0x00f5
        L_0x0119:
            boolean r0 = r7.isZooming()
            if (r0 == 0) goto L_0x0187
            float r0 = r7.optimalPageWidth
            float r0 = r7.toCurrentScale(r0)
            int r3 = r7.getWidth()
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0144
            r7.miniMapRequired = r2
            int r8 = r7.getWidth()
            int r8 = r8 / 2
            float r8 = (float) r8
            int r0 = r7.currentFilteredPage
            float r0 = (float) r0
            float r0 = r0 + r1
            float r1 = r7.optimalPageWidth
            float r0 = r0 * r1
            float r0 = r7.toCurrentScale(r0)
        L_0x0142:
            float r8 = r8 - r0
            goto L_0x01a0
        L_0x0144:
            r7.miniMapRequired = r5
            int r0 = r7.currentFilteredPage
            float r0 = (float) r0
            float r1 = r7.optimalPageWidth
            float r0 = r0 * r1
            float r0 = r7.toCurrentScale(r0)
            float r0 = r0 + r8
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0161
            int r8 = r7.currentFilteredPage
            float r8 = (float) r8
            float r0 = r7.optimalPageWidth
            float r8 = r8 * r0
            float r8 = r7.toCurrentScale(r8)
            float r8 = -r8
            goto L_0x01a0
        L_0x0161:
            int r0 = r7.currentFilteredPage
            int r0 = r0 + r5
            float r0 = (float) r0
            float r1 = r7.optimalPageWidth
            float r0 = r0 * r1
            float r0 = r7.toCurrentScale(r0)
            float r0 = r0 + r8
            int r1 = r7.getWidth()
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x01a0
            int r8 = r7.getWidth()
            float r8 = (float) r8
            int r0 = r7.currentFilteredPage
            int r0 = r0 + r5
            float r0 = (float) r0
            float r1 = r7.optimalPageWidth
            float r0 = r0 * r1
            float r0 = r7.toCurrentScale(r0)
            goto L_0x0142
        L_0x0187:
            int r0 = r7.currentFilteredPage
            int r0 = r0 + r5
            float r0 = r7.calculateCenterOffsetForPage(r0)
            int r1 = r7.currentFilteredPage
            int r1 = r1 - r5
            float r1 = r7.calculateCenterOffsetForPage(r1)
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x019b
            r8 = r0
            goto L_0x01a0
        L_0x019b:
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x01a0
            r8 = r1
        L_0x01a0:
            r7.currentXOffset = r8
            r7.currentYOffset = r9
            r7.calculateMinimapAreaBounds()
            r7.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.joanzapata.pdfview.PDFView.moveTo(float, float):void");
    }

    public void moveRelativeTo(float f, float f2) {
        moveTo(this.currentXOffset + f, this.currentYOffset + f2);
    }

    public void zoomTo(float f) {
        this.zoom = f;
        calculateMasksBounds();
    }

    public void zoomCenteredTo(float f, PointF pointF) {
        float f2 = f / this.zoom;
        zoomTo(f);
        moveTo((this.currentXOffset * f2) + (pointF.x - (pointF.x * f2)), (this.currentYOffset * f2) + (pointF.y - (pointF.y * f2)));
    }

    public void zoomCenteredRelativeTo(float f, PointF pointF) {
        zoomCenteredTo(this.zoom * f, pointF);
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public float getCurrentXOffset() {
        return this.currentXOffset;
    }

    public float getCurrentYOffset() {
        return this.currentYOffset;
    }

    public float toRealScale(float f) {
        return f / this.zoom;
    }

    public float toCurrentScale(float f) {
        return f * this.zoom;
    }

    public float getZoom() {
        return this.zoom;
    }

    /* access modifiers changed from: package-private */
    public DecodeService getDecodeService() {
        return this.decodeService;
    }

    public boolean isZooming() {
        return this.zoom != 1.0f;
    }

    public float getOptimalPageWidth() {
        return this.optimalPageWidth;
    }

    /* access modifiers changed from: private */
    public void setUserWantsMinimap(boolean z) {
        this.userWantsMinimap = z;
    }

    /* access modifiers changed from: private */
    public void setDefaultPage(int i) {
        this.defaultPage = i;
    }

    public void resetZoom() {
        zoomTo(1.0f);
    }

    public void resetZoomWithAnimation() {
        this.animationManager.startZoomAnimation(this.zoom, 1.0f);
    }

    public Configurator fromAsset(String str) {
        try {
            return fromFile(FileUtils.fileFromAsset(getContext(), str));
        } catch (IOException e) {
            throw new FileNotFoundException(str + " does not exist.", e);
        }
    }

    public Configurator fromFile(File file) {
        if (file.exists()) {
            return new Configurator(Uri.fromFile(file));
        }
        throw new FileNotFoundException(file.getAbsolutePath() + "does not exist.");
    }

    public class Configurator {
        private int defaultPage;
        private boolean enableSwipe;
        private int maskAlpha;
        private int maskColor;
        private OnDrawListener onDrawListener;
        private OnLoadCompleteListener onLoadCompleteListener;
        private OnPageChangeListener onPageChangeListener;
        private int[] pageNumbers;
        private boolean showMinimap;
        private boolean swipeVertical;
        private final Uri uri;

        private Configurator(Uri uri2) {
            this.pageNumbers = null;
            this.enableSwipe = true;
            this.defaultPage = 1;
            this.showMinimap = false;
            this.swipeVertical = false;
            this.maskColor = ViewCompat.MEASURED_STATE_MASK;
            this.maskAlpha = 20;
            this.uri = uri2;
        }

        public Configurator pages(int... iArr) {
            this.pageNumbers = iArr;
            return this;
        }

        public Configurator enableSwipe(boolean z) {
            this.enableSwipe = z;
            return this;
        }

        public Configurator onDraw(OnDrawListener onDrawListener2) {
            this.onDrawListener = onDrawListener2;
            return this;
        }

        public Configurator onLoad(OnLoadCompleteListener onLoadCompleteListener2) {
            this.onLoadCompleteListener = onLoadCompleteListener2;
            return this;
        }

        public Configurator onPageChange(OnPageChangeListener onPageChangeListener2) {
            this.onPageChangeListener = onPageChangeListener2;
            return this;
        }

        public Configurator defaultPage(int i) {
            this.defaultPage = i;
            return this;
        }

        public Configurator swipeVertical(boolean z) {
            this.swipeVertical = z;
            return this;
        }

        public Configurator mask(int i, int i2) {
            this.maskColor = i;
            this.maskAlpha = i2;
            return this;
        }

        public void load() {
            PDFView.this.recycle();
            PDFView.this.setOnDrawListener(this.onDrawListener);
            PDFView.this.setOnPageChangeListener(this.onPageChangeListener);
            PDFView.this.enableSwipe(this.enableSwipe);
            PDFView.this.setDefaultPage(this.defaultPage);
            PDFView.this.setUserWantsMinimap(this.showMinimap);
            PDFView.this.setSwipeVertical(this.swipeVertical);
            PDFView.this.dragPinchManager.setSwipeVertical(this.swipeVertical);
            Paint unused = PDFView.this.maskPaint = new Paint();
            PDFView.this.maskPaint.setColor(this.maskColor);
            PDFView.this.maskPaint.setAlpha(this.maskAlpha);
            int[] iArr = this.pageNumbers;
            if (iArr != null) {
                PDFView.this.load(this.uri, this.onLoadCompleteListener, iArr);
            } else {
                PDFView.this.load(this.uri, this.onLoadCompleteListener);
            }
        }

        public Configurator showMinimap(boolean z) {
            this.showMinimap = z;
            return this;
        }
    }

    public boolean isSwipeVertical() {
        return this.swipeVertical;
    }

    public void setSwipeVertical(boolean z) {
        this.swipeVertical = z;
    }
}
