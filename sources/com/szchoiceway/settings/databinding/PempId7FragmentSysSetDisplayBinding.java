package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class PempId7FragmentSysSetDisplayBinding implements ViewBinding {
    public final SeekBar KSWBLSeekBar;
    public final TextView KSWBLVal;
    public final TextView TvPercent;
    public final ImageButton btnSmallLightBL;
    public final ImageButton btnVideoDrivingBan;
    public final CheckBox kesaiweiChkSmallLightBL;
    public final CheckBox kesaiweiChkVideoDrivingBan;
    private final RelativeLayout rootView;
    public final TextView txtBl;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final View viewKSWBLSeekBar;

    private PempId7FragmentSysSetDisplayBinding(RelativeLayout relativeLayout, SeekBar seekBar, TextView textView, TextView textView2, ImageButton imageButton, ImageButton imageButton2, CheckBox checkBox, CheckBox checkBox2, TextView textView3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, View view) {
        this.rootView = relativeLayout;
        this.KSWBLSeekBar = seekBar;
        this.KSWBLVal = textView;
        this.TvPercent = textView2;
        this.btnSmallLightBL = imageButton;
        this.btnVideoDrivingBan = imageButton2;
        this.kesaiweiChkSmallLightBL = checkBox;
        this.kesaiweiChkVideoDrivingBan = checkBox2;
        this.txtBl = textView3;
        this.view0 = relativeLayout2;
        this.view1 = relativeLayout3;
        this.viewKSWBLSeekBar = view;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PempId7FragmentSysSetDisplayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PempId7FragmentSysSetDisplayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_display, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PempId7FragmentSysSetDisplayBinding bind(View view) {
        int i = R.id.KSW_BLSeekBar;
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.KSW_BLSeekBar);
        if (seekBar != null) {
            i = R.id.KSW_BL_val;
            TextView textView = (TextView) view.findViewById(R.id.KSW_BL_val);
            if (textView != null) {
                i = R.id.TvPercent;
                TextView textView2 = (TextView) view.findViewById(R.id.TvPercent);
                if (textView2 != null) {
                    i = R.id.btnSmallLightBL;
                    ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnSmallLightBL);
                    if (imageButton != null) {
                        i = R.id.btnVideoDrivingBan;
                        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnVideoDrivingBan);
                        if (imageButton2 != null) {
                            i = R.id.kesaiwei_chk_SmallLightBL;
                            CheckBox checkBox = (CheckBox) view.findViewById(R.id.kesaiwei_chk_SmallLightBL);
                            if (checkBox != null) {
                                i = R.id.kesaiwei_chk_VideoDrivingBan;
                                CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.kesaiwei_chk_VideoDrivingBan);
                                if (checkBox2 != null) {
                                    i = R.id.txtBl;
                                    TextView textView3 = (TextView) view.findViewById(R.id.txtBl);
                                    if (textView3 != null) {
                                        i = R.id.view0;
                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.view0);
                                        if (relativeLayout != null) {
                                            i = R.id.view1;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.view1);
                                            if (relativeLayout2 != null) {
                                                i = R.id.viewKSW_BLSeekBar;
                                                View findViewById = view.findViewById(R.id.viewKSW_BLSeekBar);
                                                if (findViewById != null) {
                                                    return new PempId7FragmentSysSetDisplayBinding((RelativeLayout) view, seekBar, textView, textView2, imageButton, imageButton2, checkBox, checkBox2, textView3, relativeLayout, relativeLayout2, findViewById);
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
