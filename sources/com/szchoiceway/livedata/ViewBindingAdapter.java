package com.szchoiceway.livedata;

import android.view.View;
import android.view.ViewGroup;
import com.szchoiceway.kt_like.JavaStandard;

public class ViewBindingAdapter {
    public static void marginEnd(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) JavaStandard.as(layoutParams)).setMarginEnd(i);
        }
    }
}
