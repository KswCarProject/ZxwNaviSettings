package org.vudroid.core.models;

import org.vudroid.core.events.DecodingProgressListener;
import org.vudroid.core.events.EventDispatcher;

public class DecodingProgressModel extends EventDispatcher {
    private int currentlyDecoding;

    public void increase() {
        this.currentlyDecoding++;
        dispatchChanged();
    }

    private void dispatchChanged() {
        dispatch(new DecodingProgressListener.DecodingProgressEvent(this.currentlyDecoding));
    }

    public void decrease() {
        this.currentlyDecoding--;
        dispatchChanged();
    }
}
