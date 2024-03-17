package org.vudroid.core.models;

import org.vudroid.core.events.BringUpZoomControlsEvent;
import org.vudroid.core.events.EventDispatcher;
import org.vudroid.core.events.ZoomChangedEvent;
import org.vudroid.core.events.ZoomListener;

public class ZoomModel extends EventDispatcher {
    private static final float INCREMENT_DELTA = 0.05f;
    private boolean horizontalScrollEnabled;
    private boolean isCommited;
    private float zoom = 1.0f;

    public void setZoom(float f) {
        float max = Math.max(f, 1.0f);
        float f2 = this.zoom;
        if (f2 != max) {
            this.zoom = max;
            this.isCommited = false;
            dispatch(new ZoomChangedEvent(max, f2));
        }
    }

    public float getZoom() {
        return this.zoom;
    }

    public void increaseZoom() {
        setZoom(getZoom() + INCREMENT_DELTA);
    }

    public void decreaseZoom() {
        setZoom(getZoom() - INCREMENT_DELTA);
    }

    public void toggleZoomControls() {
        dispatch(new BringUpZoomControlsEvent());
    }

    public void setHorizontalScrollEnabled(boolean z) {
        this.horizontalScrollEnabled = z;
    }

    public boolean isHorizontalScrollEnabled() {
        return this.horizontalScrollEnabled;
    }

    public boolean canDecrement() {
        return this.zoom > 1.0f;
    }

    public void commit() {
        if (!this.isCommited) {
            this.isCommited = true;
            dispatch(new ZoomListener.CommitZoomEvent());
        }
    }
}
