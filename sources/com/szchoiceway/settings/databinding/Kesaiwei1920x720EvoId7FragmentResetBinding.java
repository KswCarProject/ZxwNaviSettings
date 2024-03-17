package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentResetBinding implements ViewBinding {
    public final ImageButton BtnResetNo;
    public final ImageButton BtnResetYes;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720EvoId7FragmentResetBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2) {
        this.rootView = relativeLayout;
        this.BtnResetNo = imageButton;
        this.BtnResetYes = imageButton2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentResetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentResetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_reset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentResetBinding bind(View view) {
        int i = R.id.BtnResetNo;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.BtnResetNo);
        if (imageButton != null) {
            i = R.id.BtnResetYes;
            ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.BtnResetYes);
            if (imageButton2 != null) {
                return new Kesaiwei1920x720EvoId7FragmentResetBinding((RelativeLayout) view, imageButton, imageButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
