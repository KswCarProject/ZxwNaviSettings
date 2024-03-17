package org.vudroid.core.events;

import java.lang.reflect.Method;

public abstract class SafeEvent<T> implements Event<T> {
    private final Class<?> listenerType = getListenerType();

    public abstract void dispatchSafely(T t);

    protected SafeEvent() {
    }

    private Class<?> getListenerType() {
        for (Method method : getClass().getMethods()) {
            if ("dispatchSafely".equals(method.getName()) && !method.isSynthetic()) {
                return method.getParameterTypes()[0];
            }
        }
        throw new RuntimeException("Couldn't find dispatchSafely method");
    }

    public final void dispatchOn(Object obj) {
        if (this.listenerType.isAssignableFrom(obj.getClass())) {
            dispatchSafely(obj);
        }
    }
}
