package com.joanzapata.pdfview;

import android.graphics.PointF;
import com.joanzapata.pdfview.util.DragPinchListener;

class DragPinchManager implements DragPinchListener.OnDragListener, DragPinchListener.OnPinchListener, DragPinchListener.OnDoubleTapListener {
    private DragPinchListener dragPinchListener;
    private boolean isSwipeEnabled = false;
    private PDFView pdfView;
    private long startDragTime;
    private float startDragX;
    private float startDragY;
    private boolean swipeVertical;

    public DragPinchManager(PDFView pDFView) {
        this.pdfView = pDFView;
        this.swipeVertical = pDFView.isSwipeVertical();
        DragPinchListener dragPinchListener2 = new DragPinchListener();
        this.dragPinchListener = dragPinchListener2;
        dragPinchListener2.setOnDragListener(this);
        this.dragPinchListener.setOnPinchListener(this);
        this.dragPinchListener.setOnDoubleTapListener(this);
        pDFView.setOnTouchListener(this.dragPinchListener);
    }

    public void onPinch(float f, PointF pointF) {
        float zoom;
        float zoom2 = this.pdfView.getZoom() * f;
        float f2 = 1.0f;
        if (zoom2 < 1.0f) {
            zoom = this.pdfView.getZoom();
        } else {
            f2 = 10.0f;
            if (zoom2 > 10.0f) {
                zoom = this.pdfView.getZoom();
            }
            this.pdfView.zoomCenteredRelativeTo(f, pointF);
        }
        f = f2 / zoom;
        this.pdfView.zoomCenteredRelativeTo(f, pointF);
    }

    public void startDrag(float f, float f2) {
        this.startDragTime = System.currentTimeMillis();
        this.startDragX = f;
        this.startDragY = f2;
    }

    public void onDrag(float f, float f2) {
        if (isZooming() || this.isSwipeEnabled) {
            this.pdfView.moveRelativeTo(f, f2);
        }
    }

    public void endDrag(float f, float f2) {
        float f3;
        if (isZooming()) {
            this.pdfView.loadPages();
        } else if (this.isSwipeEnabled) {
            if (this.swipeVertical) {
                f3 = f2 - this.startDragY;
            } else {
                f3 = f - this.startDragX;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.startDragTime;
            int i = f3 > 0.0f ? -1 : 1;
            if (isQuickMove(f3, currentTimeMillis) || isPageChange(f3)) {
                PDFView pDFView = this.pdfView;
                pDFView.showPage(pDFView.getCurrentPage() + i);
                return;
            }
            PDFView pDFView2 = this.pdfView;
            pDFView2.showPage(pDFView2.getCurrentPage());
        }
    }

    public boolean isZooming() {
        return this.pdfView.isZooming();
    }

    private boolean isPageChange(float f) {
        float abs = Math.abs(f);
        PDFView pDFView = this.pdfView;
        return abs > Math.abs(pDFView.toCurrentScale(pDFView.getOptimalPageWidth()) / 2.0f);
    }

    private boolean isQuickMove(float f, long j) {
        return Math.abs(f) >= 50.0f && j <= 250;
    }

    public void setSwipeEnabled(boolean z) {
        this.isSwipeEnabled = z;
    }

    public void onDoubleTap(float f, float f2) {
        if (isZooming()) {
            this.pdfView.resetZoomWithAnimation();
        }
    }

    public void setSwipeVertical(boolean z) {
        this.swipeVertical = z;
    }
}
