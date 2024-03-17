package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId8FragmentSysSetOtherBinding implements ViewBinding {
    public final ImageButton btnModeAndroid;
    public final ImageButton btnModeEnable;
    public final ImageButton btnModeOriginal;
    public final CheckBox kesaiweiModeAndroid;
    public final CheckBox kesaiweiModeEnable;
    public final CheckBox kesaiweiModeOriginal;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720EvoId8FragmentSysSetOtherBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3) {
        this.rootView = relativeLayout;
        this.btnModeAndroid = imageButton;
        this.btnModeEnable = imageButton2;
        this.btnModeOriginal = imageButton3;
        this.kesaiweiModeAndroid = checkBox;
        this.kesaiweiModeEnable = checkBox2;
        this.kesaiweiModeOriginal = checkBox3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetOtherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_other, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetOtherBinding bind(View view) {
        int i = R.id.btnModeAndroid;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnModeAndroid);
        if (imageButton != null) {
            i = R.id.btnModeEnable;
            ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnModeEnable);
            if (imageButton2 != null) {
                i = R.id.btnModeOriginal;
                ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnModeOriginal);
                if (imageButton3 != null) {
                    i = R.id.kesaiwei_mode_android;
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.kesaiwei_mode_android);
                    if (checkBox != null) {
                        i = R.id.kesaiwei_mode_enable;
                        CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.kesaiwei_mode_enable);
                        if (checkBox2 != null) {
                            i = R.id.kesaiwei_mode_original;
                            CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.kesaiwei_mode_original);
                            if (checkBox3 != null) {
                                return new Kesaiwei1920x720EvoId8FragmentSysSetOtherBinding((RelativeLayout) view, imageButton, imageButton2, imageButton3, checkBox, checkBox2, checkBox3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
