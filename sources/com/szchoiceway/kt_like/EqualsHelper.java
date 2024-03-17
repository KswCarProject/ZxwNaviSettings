package com.szchoiceway.kt_like;

import java.util.List;
import kotlin.jvm.functions.Function2;

public interface EqualsHelper {
    boolean equals(Object obj, Object obj2) {
        return EqualsUtil.equals(obj, obj2);
    }

    <T> boolean equals(List<T> list, List<T> list2) {
        return EqualsUtil.equals(list, list2);
    }

    <T> boolean equals(List<T> list, List<T> list2, Function2<T, T, Boolean> function2) {
        return EqualsUtil.equals(list, list2, function2);
    }
}
