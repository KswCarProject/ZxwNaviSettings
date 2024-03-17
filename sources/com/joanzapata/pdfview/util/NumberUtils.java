package com.joanzapata.pdfview.util;

public class NumberUtils {
    public static int limit(int i, int i2, int i3) {
        return i <= i2 ? i2 : i >= i3 ? i3 : i;
    }

    private NumberUtils() {
    }
}
