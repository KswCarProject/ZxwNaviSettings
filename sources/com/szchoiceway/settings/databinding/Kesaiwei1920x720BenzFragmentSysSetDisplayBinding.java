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
import com.szchoiceway.settings.view.MySeekbar1;

public final class Kesaiwei1920x720BenzFragmentSysSetDisplayBinding implements ViewBinding {
    public final TextView KSWBLVal;
    public final ImageButton btnSmallLightBL;
    public final ImageButton btnVideoDrivingBan;
    public final CheckBox kesaiweiChkSmallLightBL;
    public final CheckBox kesaiweiChkVideoDrivingBan;
    public final MySeekbar1 mySeekbarBrightness;
    private final RelativeLayout rootView;
    public final TextView txtBl;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final View viewKSWBLSeekBar;
    public final RelativeLayout viewProduct;

    private Kesaiwei1920x720BenzFragmentSysSetDisplayBinding(RelativeLayout relativeLayout, TextView textView, ImageButton imageButton, ImageButton imageButton2, CheckBox checkBox, CheckBox checkBox2, MySeekbar1 mySeekbar1, TextView textView2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, View view, RelativeLayout relativeLayout5) {
        this.rootView = relativeLayout;
        this.KSWBLVal = textView;
        this.btnSmallLightBL = imageButton;
        this.btnVideoDrivingBan = imageButton2;
        this.kesaiweiChkSmallLightBL = checkBox;
        this.kesaiweiChkVideoDrivingBan = checkBox2;
        this.mySeekbarBrightness = mySeekbar1;
        this.txtBl = textView2;
        this.view0 = relativeLayout2;
        this.view1 = relativeLayout3;
        this.view2 = relativeLayout4;
        this.viewKSWBLSeekBar = view;
        this.viewProduct = relativeLayout5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720BenzFragmentSysSetDisplayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720BenzFragmentSysSetDisplayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set_display, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720BenzFragmentSysSetDisplayBinding bind(View view) {
        View view3 = view;
        int i = R.id.KSW_BL_val;
        TextView textView = (TextView) view3.findViewById(R.id.KSW_BL_val);
        if (textView != null) {
            i = R.id.btnSmallLightBL;
            ImageButton imageButton = (ImageButton) view3.findViewById(R.id.btnSmallLightBL);
            if (imageButton != null) {
                i = R.id.btnVideoDrivingBan;
                ImageButton imageButton2 = (ImageButton) view3.findViewById(R.id.btnVideoDrivingBan);
                if (imageButton2 != null) {
                    i = R.id.kesaiwei_chk_SmallLightBL;
                    CheckBox checkBox = (CheckBox) view3.findViewById(R.id.kesaiwei_chk_SmallLightBL);
                    if (checkBox != null) {
                        i = R.id.kesaiwei_chk_VideoDrivingBan;
                        CheckBox checkBox2 = (CheckBox) view3.findViewById(R.id.kesaiwei_chk_VideoDrivingBan);
                        if (checkBox2 != null) {
                            i = R.id.my_seekbar_brightness;
                            MySeekbar1 mySeekbar1 = (MySeekbar1) view3.findViewById(R.id.my_seekbar_brightness);
                            if (mySeekbar1 != null) {
                                i = R.id.txtBl;
                                TextView textView2 = (TextView) view3.findViewById(R.id.txtBl);
                                if (textView2 != null) {
                                    i = R.id.view0;
                                    RelativeLayout relativeLayout = (RelativeLayout) view3.findViewById(R.id.view0);
                                    if (relativeLayout != null) {
                                        i = R.id.view1;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) view3.findViewById(R.id.view1);
                                        if (relativeLayout2 != null) {
                                            i = R.id.view2;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) view3.findViewById(R.id.view2);
                                            if (relativeLayout3 != null) {
                                                i = R.id.viewKSW_BLSeekBar;
                                                View findViewById = view3.findViewById(R.id.viewKSW_BLSeekBar);
                                                if (findViewById != null) {
                                                    i = R.id.viewProduct;
                                                    RelativeLayout relativeLayout4 = (RelativeLayout) view3.findViewById(R.id.viewProduct);
                                                    if (relativeLayout4 != null) {
                                                        return new Kesaiwei1920x720BenzFragmentSysSetDisplayBinding((RelativeLayout) view3, textView, imageButton, imageButton2, checkBox, checkBox2, mySeekbar1, textView2, relativeLayout, relativeLayout2, relativeLayout3, findViewById, relativeLayout4);
                                                    }
                                                }
                                            }
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
