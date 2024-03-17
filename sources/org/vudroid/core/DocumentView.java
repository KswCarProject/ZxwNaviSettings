package org.vudroid.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;
import java.util.HashMap;
import java.util.Map;
import org.vudroid.core.events.ZoomListener;
import org.vudroid.core.models.CurrentPageModel;
import org.vudroid.core.models.DecodingProgressModel;
import org.vudroid.core.models.ZoomModel;
import org.vudroid.core.multitouch.MultiTouchZoom;

public class DocumentView extends View implements ZoomListener {
    private static final int DOUBLE_TAP_TIME = 500;
    /* access modifiers changed from: private */
    public final CurrentPageModel currentPageModel;
    DecodeService decodeService;
    private boolean inZoom;
    private boolean isInitialized = false;
    private long lastDownEventTime;
    private float lastX;
    private float lastY;
    private MultiTouchZoom multiTouchZoom;
    private int pageToGoTo;
    private final HashMap<Integer, Page> pages = new HashMap<>();
    DecodingProgressModel progressModel;
    private final Scroller scroller;
    private VelocityTracker velocityTracker;
    private RectF viewRect;
    final ZoomModel zoomModel;

    private int getLeftLimit() {
        return 0;
    }

    private int getTopLimit() {
        return 0;
    }

    public DocumentView(Context context, ZoomModel zoomModel2, DecodingProgressModel decodingProgressModel, CurrentPageModel currentPageModel2) {
        super(context);
        this.zoomModel = zoomModel2;
        this.progressModel = decodingProgressModel;
        this.currentPageModel = currentPageModel2;
        setKeepScreenOn(true);
        this.scroller = new Scroller(getContext());
        setFocusable(true);
        setFocusableInTouchMode(true);
        initMultiTouchZoomIfAvailable(zoomModel2);
    }

    private void initMultiTouchZoomIfAvailable(ZoomModel zoomModel2) {
        try {
            this.multiTouchZoom = (MultiTouchZoom) Class.forName("org.vudroid.core.multitouch.MultiTouchZoomImpl").getConstructor(new Class[]{ZoomModel.class}).newInstance(new Object[]{zoomModel2});
        } catch (Exception e) {
            System.out.println("Multi touch zoom is not available: " + e);
        }
    }

    public void setDecodeService(DecodeService decodeService2) {
        this.decodeService = decodeService2;
    }

    /* access modifiers changed from: private */
    public void init() {
        if (!this.isInitialized) {
            int effectivePagesWidth = this.decodeService.getEffectivePagesWidth();
            int effectivePagesHeight = this.decodeService.getEffectivePagesHeight();
            for (int i = 0; i < this.decodeService.getPageCount(); i++) {
                this.pages.put(Integer.valueOf(i), new Page(this, i));
                this.pages.get(Integer.valueOf(i)).setAspectRatio(effectivePagesWidth, effectivePagesHeight);
            }
            this.isInitialized = true;
            invalidatePageSizes();
            goToPageImpl(this.pageToGoTo);
        }
    }

    private void goToPageImpl(int i) {
        scrollTo(0, this.pages.get(Integer.valueOf(i)).getTop());
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        post(new Runnable() {
            public void run() {
                DocumentView.this.currentPageModel.setCurrentPageIndex(DocumentView.this.getCurrentPage());
            }
        });
        if (!this.inZoom) {
            post(new Runnable() {
                public void run() {
                    DocumentView.this.updatePageVisibility();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updatePageVisibility() {
        for (Page updateVisibility : this.pages.values()) {
            updateVisibility.updateVisibility();
        }
    }

    public void commitZoom() {
        for (Page invalidate : this.pages.values()) {
            invalidate.invalidate();
        }
        this.inZoom = false;
    }

    public void showDocument() {
        post(new Runnable() {
            public void run() {
                DocumentView.this.init();
                DocumentView.this.updatePageVisibility();
            }
        });
    }

    public void goToPage(int i) {
        if (this.isInitialized) {
            goToPageImpl(i);
        } else {
            this.pageToGoTo = i;
        }
    }

    public int getCurrentPage() {
        for (Map.Entry next : this.pages.entrySet()) {
            if (((Page) next.getValue()).isVisible()) {
                return ((Integer) next.getKey()).intValue();
            }
        }
        return 0;
    }

    public void zoomChanged(float f, float f2) {
        this.inZoom = true;
        stopScroller();
        float f3 = f / f2;
        invalidatePageSizes();
        scrollTo((int) ((((float) (getScrollX() + (getWidth() / 2))) * f3) - ((float) (getWidth() / 2))), (int) ((((float) (getScrollY() + (getHeight() / 2))) * f3) - ((float) (getHeight() / 2))));
        postInvalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        MultiTouchZoom multiTouchZoom2 = this.multiTouchZoom;
        if (multiTouchZoom2 != null) {
            if (multiTouchZoom2.onTouchEvent(motionEvent)) {
                return true;
            }
            if (this.multiTouchZoom.isResetLastPointAfterZoom()) {
                setLastPosition(motionEvent);
                this.multiTouchZoom.setResetLastPointAfterZoom(false);
            }
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            stopScroller();
            setLastPosition(motionEvent);
            if (motionEvent.getEventTime() - this.lastDownEventTime < 500) {
                this.zoomModel.toggleZoomControls();
            } else {
                this.lastDownEventTime = motionEvent.getEventTime();
            }
        } else if (action == 1) {
            this.velocityTracker.computeCurrentVelocity(1000);
            this.scroller.fling(getScrollX(), getScrollY(), (int) (-this.velocityTracker.getXVelocity()), (int) (-this.velocityTracker.getYVelocity()), getLeftLimit(), getRightLimit(), getTopLimit(), getBottomLimit());
            this.velocityTracker.recycle();
            this.velocityTracker = null;
        } else if (action == 2) {
            scrollBy((int) (this.lastX - motionEvent.getX()), (int) (this.lastY - motionEvent.getY()));
            setLastPosition(motionEvent);
        }
        return true;
    }

    private void setLastPosition(MotionEvent motionEvent) {
        this.lastX = motionEvent.getX();
        this.lastY = motionEvent.getY();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    verticalDpadScroll(-1);
                    return true;
                case 20:
                    verticalDpadScroll(1);
                    return true;
                case 21:
                    lineByLineMoveTo(-1);
                    return true;
                case 22:
                    lineByLineMoveTo(1);
                    return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private void verticalDpadScroll(int i) {
        this.scroller.startScroll(getScrollX(), getScrollY(), 0, (i * getHeight()) / 2);
        invalidate();
    }

    private void lineByLineMoveTo(int i) {
        if (i != 1 ? getScrollX() != getLeftLimit() : getScrollX() != getRightLimit()) {
            this.scroller.startScroll(getScrollX(), getScrollY(), (i * getWidth()) / 2, 0);
        } else {
            this.scroller.startScroll(getScrollX(), getScrollY(), (getLeftLimit() - getRightLimit()) * i, (int) ((((float) i) * this.pages.get(Integer.valueOf(getCurrentPage())).bounds.height()) / 50.0f));
        }
        invalidate();
    }

    private int getBottomLimit() {
        HashMap<Integer, Page> hashMap = this.pages;
        return ((int) hashMap.get(Integer.valueOf(hashMap.size() - 1)).bounds.bottom) - getHeight();
    }

    private int getRightLimit() {
        return ((int) (((float) getWidth()) * this.zoomModel.getZoom())) - getWidth();
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(Math.min(Math.max(i, getLeftLimit()), getRightLimit()), Math.min(Math.max(i2, getTopLimit()), getBottomLimit()));
        this.viewRect = null;
    }

    /* access modifiers changed from: package-private */
    public RectF getViewRect() {
        if (this.viewRect == null) {
            this.viewRect = new RectF((float) getScrollX(), (float) getScrollY(), (float) (getScrollX() + getWidth()), (float) (getScrollY() + getHeight()));
        }
        return this.viewRect;
    }

    public void computeScroll() {
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Page draw : this.pages.values()) {
            draw.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float scrollScaleRatio = getScrollScaleRatio();
        invalidatePageSizes();
        invalidateScroll(scrollScaleRatio);
        commitZoom();
    }

    /* access modifiers changed from: package-private */
    public void invalidatePageSizes() {
        if (this.isInitialized) {
            int width = getWidth();
            float zoom = this.zoomModel.getZoom();
            int i = 0;
            float f = 0.0f;
            while (i < this.pages.size()) {
                Page page = this.pages.get(Integer.valueOf(i));
                float pageHeight = page.getPageHeight(width, zoom) + f;
                page.setBounds(new RectF(0.0f, f, ((float) width) * zoom, pageHeight));
                i++;
                f = pageHeight;
            }
        }
    }

    private void invalidateScroll(float f) {
        if (this.isInitialized) {
            stopScroller();
            Page page = this.pages.get(0);
            if (page != null && page.bounds != null) {
                scrollTo((int) (((float) getScrollX()) * f), (int) (((float) getScrollY()) * f));
            }
        }
    }

    private float getScrollScaleRatio() {
        Page page = this.pages.get(0);
        if (page == null || page.bounds == null) {
            return 0.0f;
        }
        return (((float) getWidth()) * this.zoomModel.getZoom()) / page.bounds.width();
    }

    private void stopScroller() {
        if (!this.scroller.isFinished()) {
            this.scroller.abortAnimation();
        }
    }
}
