package org.vudroid.core.events;

public class BringUpZoomControlsEvent extends SafeEvent<BringUpZoomControlsListener> {
    public void dispatchSafely(BringUpZoomControlsListener bringUpZoomControlsListener) {
        bringUpZoomControlsListener.toggleZoomControls();
    }
}
