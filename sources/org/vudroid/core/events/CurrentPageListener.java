package org.vudroid.core.events;

public interface CurrentPageListener {
    void currentPageChanged(int i);

    public static class CurrentPageChangedEvent extends SafeEvent<CurrentPageListener> {
        private final int pageIndex;

        public CurrentPageChangedEvent(int i) {
            this.pageIndex = i;
        }

        public void dispatchSafely(CurrentPageListener currentPageListener) {
            currentPageListener.currentPageChanged(this.pageIndex);
        }
    }
}
