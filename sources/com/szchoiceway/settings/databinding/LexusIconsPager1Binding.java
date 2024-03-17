package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class LexusIconsPager1Binding implements ViewBinding {
    public final ImageView BtnDataTimer;
    public final ImageView BtnLanguage;
    public final ImageView BtnNavSet;
    public final ImageView BtnSysInfor;
    public final ImageView BtnSysSetting;
    public final ImageView BtnVolumeSet;
    private final ConstraintLayout rootView;

    private LexusIconsPager1Binding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6) {
        this.rootView = constraintLayout;
        this.BtnDataTimer = imageView;
        this.BtnLanguage = imageView2;
        this.BtnNavSet = imageView3;
        this.BtnSysInfor = imageView4;
        this.BtnSysSetting = imageView5;
        this.BtnVolumeSet = imageView6;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LexusIconsPager1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LexusIconsPager1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.lexus_icons_pager1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LexusIconsPager1Binding bind(View view) {
        int i = R.id.BtnDataTimer;
        ImageView imageView = (ImageView) view.findViewById(R.id.BtnDataTimer);
        if (imageView != null) {
            i = R.id.BtnLanguage;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.BtnLanguage);
            if (imageView2 != null) {
                i = R.id.BtnNavSet;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.BtnNavSet);
                if (imageView3 != null) {
                    i = R.id.BtnSysInfor;
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.BtnSysInfor);
                    if (imageView4 != null) {
                        i = R.id.BtnSysSetting;
                        ImageView imageView5 = (ImageView) view.findViewById(R.id.BtnSysSetting);
                        if (imageView5 != null) {
                            i = R.id.BtnVolumeSet;
                            ImageView imageView6 = (ImageView) view.findViewById(R.id.BtnVolumeSet);
                            if (imageView6 != null) {
                                return new LexusIconsPager1Binding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
