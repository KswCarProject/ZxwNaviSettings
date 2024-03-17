package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class SmallAudiFragmentSysSetOtherBinding implements ViewBinding {
    public final ImageButton btnModeAndroid;
    public final ImageButton btnModeEnable;
    public final ImageButton btnModeOriginal;
    public final CheckBox kesaiweiModeAndroid;
    public final CheckBox kesaiweiModeEnable;
    public final CheckBox kesaiweiModeOriginal;
    private final RelativeLayout rootView;
    public final TextView txtMode;
    public final RelativeLayout view0;
    public final RelativeLayout view1;

    private SmallAudiFragmentSysSetOtherBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, TextView textView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.btnModeAndroid = imageButton;
        this.btnModeEnable = imageButton2;
        this.btnModeOriginal = imageButton3;
        this.kesaiweiModeAndroid = checkBox;
        this.kesaiweiModeEnable = checkBox2;
        this.kesaiweiModeOriginal = checkBox3;
        this.txtMode = textView;
        this.view0 = relativeLayout2;
        this.view1 = relativeLayout3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallAudiFragmentSysSetOtherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallAudiFragmentSysSetOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_other, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallAudiFragmentSysSetOtherBinding bind(View view) {
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
                                i = R.id.txtMode;
                                TextView textView = (TextView) view.findViewById(R.id.txtMode);
                                if (textView != null) {
                                    i = R.id.view0;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.view0);
                                    if (relativeLayout != null) {
                                        i = R.id.view1;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.view1);
                                        if (relativeLayout2 != null) {
                                            return new SmallAudiFragmentSysSetOtherBinding((RelativeLayout) view, imageButton, imageButton2, imageButton3, checkBox, checkBox2, checkBox3, textView, relativeLayout, relativeLayout2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
