package org.vudroid.core.events;

public class ZoomChangedEvent extends SafeEvent<ZoomListener> {
    private final float newZoom;
    private final float oldZoom;

    public ZoomChangedEvent(float f, float f2) {
        this.newZoom = f;
        this.oldZoom = f2;
    }

    public void dispatchSafely(ZoomListener zoomListener) {
        zoomListener.zoomChanged(this.newZoom, this.oldZoom);
    }
}
