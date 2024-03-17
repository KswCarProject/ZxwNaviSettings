package org.vudroid.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import java.lang.ref.SoftReference;
import org.vudroid.core.DecodeService;

class PageTreeNode {
    private static final int SLICE_SIZE = 65535;
    private Bitmap bitmap;
    private final Paint bitmapPaint = new Paint();
    private SoftReference<Bitmap> bitmapWeakReference;
    private PageTreeNode[] children;
    private boolean decodingNow;
    /* access modifiers changed from: private */
    public DocumentView documentView;
    /* access modifiers changed from: private */
    public boolean invalidateFlag;
    private Matrix matrix = new Matrix();
    /* access modifiers changed from: private */
    public final Page page;
    private final RectF pageSliceBounds;
    private Rect targetRect;
    private RectF targetRectF;
    private final int treeNodeDepthLevel;

    PageTreeNode(DocumentView documentView2, RectF rectF, Page page2, int i, PageTreeNode pageTreeNode) {
        this.documentView = documentView2;
        this.pageSliceBounds = evaluatePageSliceBounds(rectF, pageTreeNode);
        this.page = page2;
        this.treeNodeDepthLevel = i;
    }

    public void updateVisibility() {
        invalidateChildren();
        PageTreeNode[] pageTreeNodeArr = this.children;
        if (pageTreeNodeArr != null) {
            for (PageTreeNode updateVisibility : pageTreeNodeArr) {
                updateVisibility.updateVisibility();
            }
        }
        if (isVisible() && !thresholdHit()) {
            if (getBitmap() == null || this.invalidateFlag) {
                decodePageTreeNode();
            } else {
                restoreBitmapReference();
            }
        }
        if (!isVisibleAndNotHiddenByChildren()) {
            stopDecodingThisNode();
            setBitmap((Bitmap) null);
        }
    }

    public void invalidate() {
        invalidateChildren();
        invalidateRecursive();
        updateVisibility();
    }

    private void invalidateRecursive() {
        this.invalidateFlag = true;
        PageTreeNode[] pageTreeNodeArr = this.children;
        if (pageTreeNodeArr != null) {
            for (PageTreeNode invalidateRecursive : pageTreeNodeArr) {
                invalidateRecursive.invalidateRecursive();
            }
        }
        stopDecodingThisNode();
    }

    /* access modifiers changed from: package-private */
    public void invalidateNodeBounds() {
        this.targetRect = null;
        this.targetRectF = null;
        PageTreeNode[] pageTreeNodeArr = this.children;
        if (pageTreeNodeArr != null) {
            for (PageTreeNode invalidateNodeBounds : pageTreeNodeArr) {
                invalidateNodeBounds.invalidateNodeBounds();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas) {
        if (getBitmap() != null) {
            canvas.drawBitmap(getBitmap(), new Rect(0, 0, getBitmap().getWidth(), getBitmap().getHeight()), getTargetRect(), this.bitmapPaint);
        }
        PageTreeNode[] pageTreeNodeArr = this.children;
        if (pageTreeNodeArr != null) {
            for (PageTreeNode draw : pageTreeNodeArr) {
                draw.draw(canvas);
            }
        }
    }

    private boolean isVisible() {
        return RectF.intersects(this.documentView.getViewRect(), getTargetRectF());
    }

    private RectF getTargetRectF() {
        if (this.targetRectF == null) {
            this.targetRectF = new RectF(getTargetRect());
        }
        return this.targetRectF;
    }

    /* access modifiers changed from: private */
    public void invalidateChildren() {
        if (thresholdHit() && this.children == null && isVisible()) {
            int i = this.treeNodeDepthLevel * 2;
            this.children = new PageTreeNode[]{new PageTreeNode(this.documentView, new RectF(0.0f, 0.0f, 0.5f, 0.5f), this.page, i, this), new PageTreeNode(this.documentView, new RectF(0.5f, 0.0f, 1.0f, 0.5f), this.page, i, this), new PageTreeNode(this.documentView, new RectF(0.0f, 0.5f, 0.5f, 1.0f), this.page, i, this), new PageTreeNode(this.documentView, new RectF(0.5f, 0.5f, 1.0f, 1.0f), this.page, i, this)};
        }
        if ((!thresholdHit() && getBitmap() != null) || !isVisible()) {
            recycleChildren();
        }
    }

    private boolean thresholdHit() {
        float zoom = this.documentView.zoomModel.getZoom();
        int width = this.documentView.getWidth();
        float pageHeight = this.page.getPageHeight(width, zoom);
        int i = this.treeNodeDepthLevel;
        return ((((float) width) * zoom) * pageHeight) / ((float) (i * i)) > 65535.0f;
    }

    public Bitmap getBitmap() {
        SoftReference<Bitmap> softReference = this.bitmapWeakReference;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    private void restoreBitmapReference() {
        setBitmap(getBitmap());
    }

    private void decodePageTreeNode() {
        if (!isDecodingNow()) {
            setDecodingNow(true);
            this.documentView.decodeService.decodePage(this, this.page.index, new DecodeService.DecodeCallback() {
                public void decodeComplete(final Bitmap bitmap) {
                    PageTreeNode.this.documentView.post(new Runnable() {
                        public void run() {
                            PageTreeNode.this.setBitmap(bitmap);
                            boolean unused = PageTreeNode.this.invalidateFlag = false;
                            PageTreeNode.this.setDecodingNow(false);
                            PageTreeNode.this.page.setAspectRatio(PageTreeNode.this.documentView.decodeService.getPageWidth(PageTreeNode.this.page.index), PageTreeNode.this.documentView.decodeService.getPageHeight(PageTreeNode.this.page.index));
                            PageTreeNode.this.invalidateChildren();
                        }
                    });
                }
            }, this.documentView.zoomModel.getZoom(), this.pageSliceBounds);
        }
    }

    private RectF evaluatePageSliceBounds(RectF rectF, PageTreeNode pageTreeNode) {
        if (pageTreeNode == null) {
            return rectF;
        }
        Matrix matrix2 = new Matrix();
        matrix2.postScale(pageTreeNode.pageSliceBounds.width(), pageTreeNode.pageSliceBounds.height());
        matrix2.postTranslate(pageTreeNode.pageSliceBounds.left, pageTreeNode.pageSliceBounds.top);
        RectF rectF2 = new RectF();
        matrix2.mapRect(rectF2, rectF);
        return rectF2;
    }

    /* access modifiers changed from: private */
    public void setBitmap(Bitmap bitmap2) {
        Bitmap bitmap3;
        if ((bitmap2 == null || bitmap2.getWidth() != -1 || bitmap2.getHeight() != -1) && (bitmap3 = this.bitmap) != bitmap2) {
            if (bitmap2 != null) {
                if (bitmap3 != null) {
                    bitmap3.recycle();
                }
                this.bitmapWeakReference = new SoftReference<>(bitmap2);
                this.documentView.postInvalidate();
            }
            this.bitmap = bitmap2;
        }
    }

    private boolean isDecodingNow() {
        return this.decodingNow;
    }

    /* access modifiers changed from: private */
    public void setDecodingNow(boolean z) {
        if (this.decodingNow != z) {
            this.decodingNow = z;
            if (z) {
                this.documentView.progressModel.increase();
            } else {
                this.documentView.progressModel.decrease();
            }
        }
    }

    private Rect getTargetRect() {
        if (this.targetRect == null) {
            this.matrix.reset();
            this.matrix.postScale(this.page.bounds.width(), this.page.bounds.height());
            this.matrix.postTranslate(this.page.bounds.left, this.page.bounds.top);
            RectF rectF = new RectF();
            this.matrix.mapRect(rectF, this.pageSliceBounds);
            this.targetRect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
        return this.targetRect;
    }

    private void stopDecodingThisNode() {
        if (isDecodingNow()) {
            this.documentView.decodeService.stopDecoding(this);
            setDecodingNow(false);
        }
    }

    private boolean isHiddenByChildren() {
        PageTreeNode[] pageTreeNodeArr = this.children;
        if (pageTreeNodeArr == null) {
            return false;
        }
        for (PageTreeNode bitmap2 : pageTreeNodeArr) {
            if (bitmap2.getBitmap() == null) {
                return false;
            }
        }
        return true;
    }

    private void recycleChildren() {
        PageTreeNode[] pageTreeNodeArr = this.children;
        if (pageTreeNodeArr != null) {
            for (PageTreeNode recycle : pageTreeNodeArr) {
                recycle.recycle();
            }
            if (!childrenContainBitmaps()) {
                this.children = null;
            }
        }
    }

    private boolean containsBitmaps() {
        return getBitmap() != null || childrenContainBitmaps();
    }

    private boolean childrenContainBitmaps() {
        PageTreeNode[] pageTreeNodeArr = this.children;
        if (pageTreeNodeArr == null) {
            return false;
        }
        for (PageTreeNode containsBitmaps : pageTreeNodeArr) {
            if (containsBitmaps.containsBitmaps()) {
                return true;
            }
        }
        return false;
    }

    private void recycle() {
        stopDecodingThisNode();
        setBitmap((Bitmap) null);
        PageTreeNode[] pageTreeNodeArr = this.children;
        if (pageTreeNodeArr != null) {
            for (PageTreeNode recycle : pageTreeNodeArr) {
                recycle.recycle();
            }
        }
    }

    private boolean isVisibleAndNotHiddenByChildren() {
        return isVisible() && !isHiddenByChildren();
    }
}
