package org.vudroid.core.models;

import org.vudroid.core.events.CurrentPageListener;
import org.vudroid.core.events.EventDispatcher;

public class CurrentPageModel extends EventDispatcher {
    private int currentPageIndex;

    public void setCurrentPageIndex(int i) {
        if (this.currentPageIndex != i) {
            this.currentPageIndex = i;
            dispatch(new CurrentPageListener.CurrentPageChangedEvent(i));
        }
    }
}
