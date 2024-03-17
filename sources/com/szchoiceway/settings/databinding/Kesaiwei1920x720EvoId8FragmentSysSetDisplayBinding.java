package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MySeekbar1;

public final class Kesaiwei1920x720EvoId8FragmentSysSetDisplayBinding implements ViewBinding {
    public final TextView KSWBLVal;
    public final ImageButton btnAddBL;
    public final ImageButton btnReduceBL;
    public final ImageButton btnSmallLightBL;
    public final ImageButton btnVideoDrivingBan;
    public final CheckBox kesaiweiChkSmallLightBL;
    public final CheckBox kesaiweiChkVideoDrivingBan;
    public final MySeekbar1 mySeekbarBrightness;
    private final RelativeLayout rootView;
    public final View viewKSWBLSeekBar;
    public final LinearLayout viewProduct;

    private Kesaiwei1920x720EvoId8FragmentSysSetDisplayBinding(RelativeLayout relativeLayout, TextView textView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, CheckBox checkBox, CheckBox checkBox2, MySeekbar1 mySeekbar1, View view, LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.KSWBLVal = textView;
        this.btnAddBL = imageButton;
        this.btnReduceBL = imageButton2;
        this.btnSmallLightBL = imageButton3;
        this.btnVideoDrivingBan = imageButton4;
        this.kesaiweiChkSmallLightBL = checkBox;
        this.kesaiweiChkVideoDrivingBan = checkBox2;
        this.mySeekbarBrightness = mySeekbar1;
        this.viewKSWBLSeekBar = view;
        this.viewProduct = linearLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetDisplayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetDisplayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_display, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetDisplayBinding bind(View view) {
        int i = R.id.KSW_BL_val;
        TextView textView = (TextView) view.findViewById(R.id.KSW_BL_val);
        if (textView != null) {
            i = R.id.btnAddBL;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnAddBL);
            if (imageButton != null) {
                i = R.id.btnReduceBL;
                ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnReduceBL);
                if (imageButton2 != null) {
                    i = R.id.btnSmallLightBL;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnSmallLightBL);
                    if (imageButton3 != null) {
                        i = R.id.btnVideoDrivingBan;
                        ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.btnVideoDrivingBan);
                        if (imageButton4 != null) {
                            i = R.id.kesaiwei_chk_SmallLightBL;
                            CheckBox checkBox = (CheckBox) view.findViewById(R.id.kesaiwei_chk_SmallLightBL);
                            if (checkBox != null) {
                                i = R.id.kesaiwei_chk_VideoDrivingBan;
                                CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.kesaiwei_chk_VideoDrivingBan);
                                if (checkBox2 != null) {
                                    i = R.id.my_seekbar_brightness;
                                    MySeekbar1 mySeekbar1 = (MySeekbar1) view.findViewById(R.id.my_seekbar_brightness);
                                    if (mySeekbar1 != null) {
                                        i = R.id.viewKSW_BLSeekBar;
                                        View findViewById = view.findViewById(R.id.viewKSW_BLSeekBar);
                                        if (findViewById != null) {
                                            i = R.id.viewProduct;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.viewProduct);
                                            if (linearLayout != null) {
                                                return new Kesaiwei1920x720EvoId8FragmentSysSetDisplayBinding((RelativeLayout) view, textView, imageButton, imageButton2, imageButton3, imageButton4, checkBox, checkBox2, mySeekbar1, findViewById, linearLayout);
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
