package org.vudroid.core.events;

public interface ZoomListener {
    void commitZoom();

    void zoomChanged(float f, float f2);

    public static class CommitZoomEvent extends SafeEvent<ZoomListener> {
        public void dispatchSafely(ZoomListener zoomListener) {
            zoomListener.commitZoom();
        }
    }
}
