package org.vudroid.core.multitouch;

import android.view.MotionEvent;
import org.vudroid.core.models.ZoomModel;

public class MultiTouchZoomImpl implements MultiTouchZoom {
    private float lastZoomDistance;
    private boolean resetLastPointAfterZoom;
    private final ZoomModel zoomModel;

    public MultiTouchZoomImpl(ZoomModel zoomModel2) {
        this.zoomModel = zoomModel2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 5) == 5) {
            this.lastZoomDistance = getZoomDistance(motionEvent);
            return true;
        } else if ((motionEvent.getAction() & 6) == 6) {
            this.lastZoomDistance = 0.0f;
            this.zoomModel.commit();
            this.resetLastPointAfterZoom = true;
            return true;
        } else if (motionEvent.getAction() != 2 || this.lastZoomDistance == 0.0f) {
            return false;
        } else {
            float zoomDistance = getZoomDistance(motionEvent);
            ZoomModel zoomModel2 = this.zoomModel;
            zoomModel2.setZoom((zoomModel2.getZoom() * zoomDistance) / this.lastZoomDistance);
            this.lastZoomDistance = zoomDistance;
            return true;
        }
    }

    private float getZoomDistance(MotionEvent motionEvent) {
        return (float) Math.sqrt(Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
    }

    public boolean isResetLastPointAfterZoom() {
        return this.resetLastPointAfterZoom;
    }

    public void setResetLastPointAfterZoom(boolean z) {
        this.resetLastPointAfterZoom = z;
    }
}
