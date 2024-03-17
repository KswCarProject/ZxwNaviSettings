package com.szchoiceway.kt_like;

import java.util.List;
import kotlin.jvm.functions.Function1;

public interface ListHelper {
    <T> List<T> listOf(T... tArr) {
        return ListUtil.listOf(tArr);
    }

    <T> void forEach(List<T> list, Function1Void<T> function1Void) {
        ListUtil.forEach(list, function1Void);
    }

    Integer sum(List<Integer> list) {
        return ListUtil.sum(list);
    }

    <T> void forEachIndexed(List<T> list, Function2Void<T, Integer> function2Void) {
        ListUtil.forEachIndexed(list, function2Void);
    }

    <T> T getOrNull(List<T> list, int i) {
        return ListUtil.getOrNull(list, i);
    }

    <T> T first(List<T> list) {
        return ListUtil.first(list);
    }

    <T> T last(List<T> list) {
        return ListUtil.last(list);
    }

    <T, R> List<R> map(List<T> list, Function1<T, R> function1) {
        return ListUtil.map(list, function1);
    }
}
