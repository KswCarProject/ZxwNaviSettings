package org.vudroid.core.events;

import java.util.ArrayList;
import java.util.Iterator;

public class EventDispatcher {
    private final ArrayList<Object> listeners = new ArrayList<>();

    public void dispatch(Event event) {
        Iterator<Object> it = this.listeners.iterator();
        while (it.hasNext()) {
            event.dispatchOn(it.next());
        }
    }

    public void addEventListener(Object obj) {
        this.listeners.add(obj);
    }

    public void removeEventListener(Object obj) {
        this.listeners.remove(obj);
    }
}
