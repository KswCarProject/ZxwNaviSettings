package org.vudroid.core.events;

public interface DecodingProgressListener {
    void decodingProgressChanged(int i);

    public static class DecodingProgressEvent extends SafeEvent<DecodingProgressListener> {
        private final int currentlyDecoding;

        public DecodingProgressEvent(int i) {
            this.currentlyDecoding = i;
        }

        public void dispatchSafely(DecodingProgressListener decodingProgressListener) {
            decodingProgressListener.decodingProgressChanged(this.currentlyDecoding);
        }
    }
}
