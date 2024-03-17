package com.szchoiceway.settings.adapter;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class DefaultTransformer implements ViewPager.PageTransformer {
    public void transformPage(View view, float f) {
        float f2 = 0.0f;
        if (0.0f <= f && f <= 1.0f) {
            f2 = 1.0f - f;
        } else if (-1.0f < f && f < 0.0f) {
            f2 = f + 1.0f;
        }
        view.setAlpha(f2);
        view.setTranslationX(((float) view.getWidth()) * (-f));
        view.setTranslationY(f * ((float) view.getHeight()));
    }
}
