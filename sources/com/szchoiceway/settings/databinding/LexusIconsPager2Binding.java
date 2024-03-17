package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class LexusIconsPager2Binding implements ViewBinding {
    public final ImageView BtnFatSetting;
    public final ImageView BtnMoreSetting;
    private final ConstraintLayout rootView;

    private LexusIconsPager2Binding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.BtnFatSetting = imageView;
        this.BtnMoreSetting = imageView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LexusIconsPager2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LexusIconsPager2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.lexus_icons_pager2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LexusIconsPager2Binding bind(View view) {
        int i = R.id.BtnFatSetting;
        ImageView imageView = (ImageView) view.findViewById(R.id.BtnFatSetting);
        if (imageView != null) {
            i = R.id.BtnMoreSetting;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.BtnMoreSetting);
            if (imageView2 != null) {
                return new LexusIconsPager2Binding((ConstraintLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
