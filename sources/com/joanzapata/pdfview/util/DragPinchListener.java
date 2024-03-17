package com.joanzapata.pdfview.util;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class DragPinchListener implements View.OnTouchListener {
    private static final float MAX_CLICK_DISTANCE = 5.0f;
    private static final long MAX_CLICK_TIME = 500;
    private static final float MAX_DOUBLE_CLICK_TIME = 280.0f;
    private static final int POINTER1 = 0;
    private static final int POINTER2 = 1;
    private float dragLastX;
    private float dragLastY;
    private long lastClickTime;
    private float lastDownX;
    private float lastDownY;
    private OnDoubleTapListener onDoubleTapListener;
    private OnDragListener onDragListener;
    private OnPinchListener onPinchListener;
    private float pointer2LastX;
    private float pointer2LastY;
    private State state = State.NONE;
    private float zoomLastDistance;

    public interface OnDoubleTapListener {
        void onDoubleTap(float f, float f2);
    }

    public interface OnDragListener {
        void endDrag(float f, float f2);

        void onDrag(float f, float f2);

        void startDrag(float f, float f2);
    }

    public interface OnPinchListener {
        void onPinch(float f, PointF pointF);
    }

    enum State {
        NONE,
        ZOOM,
        DRAG
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        if (r8 != 2) goto L_0x00ce;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            int r8 = r9.getAction()
            r0 = 1
            if (r8 == 0) goto L_0x00bb
            if (r8 == r0) goto L_0x0077
            r1 = 2
            if (r8 == r1) goto L_0x0055
            r1 = 5
            if (r8 == r1) goto L_0x003c
            r1 = 6
            if (r8 == r1) goto L_0x002e
            r1 = 261(0x105, float:3.66E-43)
            if (r8 == r1) goto L_0x0022
            r9 = 262(0x106, float:3.67E-43)
            if (r8 == r9) goto L_0x001c
            goto L_0x00ce
        L_0x001c:
            com.joanzapata.pdfview.util.DragPinchListener$State r8 = com.joanzapata.pdfview.util.DragPinchListener.State.DRAG
            r7.state = r8
            goto L_0x00ce
        L_0x0022:
            r7.startDrag(r9)
            r7.startZoom(r9)
            com.joanzapata.pdfview.util.DragPinchListener$State r8 = com.joanzapata.pdfview.util.DragPinchListener.State.ZOOM
            r7.state = r8
            goto L_0x00ce
        L_0x002e:
            float r8 = r7.pointer2LastX
            r7.dragLastX = r8
            float r8 = r7.pointer2LastY
            r7.dragLastY = r8
            com.joanzapata.pdfview.util.DragPinchListener$State r8 = com.joanzapata.pdfview.util.DragPinchListener.State.DRAG
            r7.state = r8
            goto L_0x00ce
        L_0x003c:
            r8 = 0
            float r1 = r9.getX(r8)
            r7.pointer2LastX = r1
            float r8 = r9.getY(r8)
            r7.pointer2LastY = r8
            r7.startDrag(r9)
            r7.startZoom(r9)
            com.joanzapata.pdfview.util.DragPinchListener$State r8 = com.joanzapata.pdfview.util.DragPinchListener.State.ZOOM
            r7.state = r8
            goto L_0x00ce
        L_0x0055:
            int[] r8 = com.joanzapata.pdfview.util.DragPinchListener.AnonymousClass1.$SwitchMap$com$joanzapata$pdfview$util$DragPinchListener$State
            com.joanzapata.pdfview.util.DragPinchListener$State r2 = r7.state
            int r2 = r2.ordinal()
            r8 = r8[r2]
            if (r8 == r0) goto L_0x0064
            if (r8 == r1) goto L_0x0073
            goto L_0x00ce
        L_0x0064:
            float r8 = r9.getX(r0)
            r7.pointer2LastX = r8
            float r8 = r9.getY(r0)
            r7.pointer2LastY = r8
            r7.zoom(r9)
        L_0x0073:
            r7.drag(r9)
            goto L_0x00ce
        L_0x0077:
            com.joanzapata.pdfview.util.DragPinchListener$State r8 = com.joanzapata.pdfview.util.DragPinchListener.State.NONE
            r7.state = r8
            r7.endDrag()
            float r3 = r7.lastDownX
            float r4 = r7.lastDownY
            float r5 = r9.getX()
            float r6 = r9.getY()
            r1 = r7
            r2 = r9
            boolean r8 = r1.isClick(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L_0x00ce
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r7.lastClickTime
            long r1 = r1 - r3
            float r8 = (float) r1
            r1 = 1133248512(0x438c0000, float:280.0)
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 >= 0) goto L_0x00b4
            com.joanzapata.pdfview.util.DragPinchListener$OnDoubleTapListener r8 = r7.onDoubleTapListener
            if (r8 == 0) goto L_0x00af
            float r1 = r9.getX()
            float r9 = r9.getY()
            r8.onDoubleTap(r1, r9)
        L_0x00af:
            r8 = 0
            r7.lastClickTime = r8
            goto L_0x00ce
        L_0x00b4:
            long r8 = java.lang.System.currentTimeMillis()
            r7.lastClickTime = r8
            goto L_0x00ce
        L_0x00bb:
            r7.startDrag(r9)
            com.joanzapata.pdfview.util.DragPinchListener$State r8 = com.joanzapata.pdfview.util.DragPinchListener.State.DRAG
            r7.state = r8
            float r8 = r9.getX()
            r7.lastDownX = r8
            float r8 = r9.getY()
            r7.lastDownY = r8
        L_0x00ce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.joanzapata.pdfview.util.DragPinchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: com.joanzapata.pdfview.util.DragPinchListener$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$joanzapata$pdfview$util$DragPinchListener$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.joanzapata.pdfview.util.DragPinchListener$State[] r0 = com.joanzapata.pdfview.util.DragPinchListener.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$joanzapata$pdfview$util$DragPinchListener$State = r0
                com.joanzapata.pdfview.util.DragPinchListener$State r1 = com.joanzapata.pdfview.util.DragPinchListener.State.ZOOM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$joanzapata$pdfview$util$DragPinchListener$State     // Catch:{ NoSuchFieldError -> 0x001d }
                com.joanzapata.pdfview.util.DragPinchListener$State r1 = com.joanzapata.pdfview.util.DragPinchListener.State.DRAG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.joanzapata.pdfview.util.DragPinchListener.AnonymousClass1.<clinit>():void");
        }
    }

    private void endDrag() {
        this.onDragListener.endDrag(this.dragLastX, this.dragLastY);
    }

    private void startZoom(MotionEvent motionEvent) {
        this.zoomLastDistance = distance(motionEvent);
    }

    private void zoom(MotionEvent motionEvent) {
        float distance = distance(motionEvent);
        OnPinchListener onPinchListener2 = this.onPinchListener;
        if (onPinchListener2 != null) {
            onPinchListener2.onPinch(distance / this.zoomLastDistance, new PointF(motionEvent.getX(0), motionEvent.getY(0)));
        }
        this.zoomLastDistance = distance;
    }

    private void startDrag(MotionEvent motionEvent) {
        this.dragLastX = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        this.dragLastY = y;
        this.onDragListener.startDrag(this.dragLastX, y);
    }

    private void drag(MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        OnDragListener onDragListener2 = this.onDragListener;
        if (onDragListener2 != null) {
            onDragListener2.onDrag(x - this.dragLastX, y - this.dragLastY);
        }
        this.dragLastX = x;
        this.dragLastY = y;
    }

    private float distance(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        return PointF.length(motionEvent.getX(0) - motionEvent.getX(1), motionEvent.getY(0) - motionEvent.getY(1));
    }

    private boolean isClick(MotionEvent motionEvent, float f, float f2, float f3, float f4) {
        if (motionEvent == null) {
            return false;
        }
        float length = PointF.length(f - f3, f2 - f4);
        if (motionEvent.getEventTime() - motionEvent.getDownTime() >= MAX_CLICK_TIME || length >= MAX_CLICK_DISTANCE) {
            return false;
        }
        return true;
    }

    public void setOnDragListener(OnDragListener onDragListener2) {
        this.onDragListener = onDragListener2;
    }

    public void setOnPinchListener(OnPinchListener onPinchListener2) {
        this.onPinchListener = onPinchListener2;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener2) {
        this.onDoubleTapListener = onDoubleTapListener2;
    }
}
