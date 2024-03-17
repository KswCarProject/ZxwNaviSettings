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

public final class Kesaiwei1920x720EvoId7FragmentSysSetBinding implements ViewBinding {
    public final SeekBar KSWBLSeekBar;
    public final TextView KSWBLVal;
    public final ImageButton btnAndroid360;
    public final ImageButton btnBackcarMirror;
    public final ImageButton btnCamera360;
    public final ImageButton btnCameraInstall;
    public final ImageButton btnCameraOriginal;
    public final ImageButton btnRadar;
    public final ImageButton btnReversingTrack;
    public final ImageButton btnTempUnitC;
    public final ImageButton btnTempUnitF;
    public final ImageButton btnVideoDrivingBan;
    public final CheckBox kesaiweiAndroid360;
    public final CheckBox kesaiweiCamera360;
    public final CheckBox kesaiweiCameraInstall;
    public final CheckBox kesaiweiCameraOriginal;
    public final CheckBox kesaiweiChkBackcarMirror;
    public final CheckBox kesaiweiChkRadar;
    public final CheckBox kesaiweiChkReversingTrack;
    public final CheckBox kesaiweiChkVideoDrivingBan;
    public final CheckBox kesaiweiTempUnitC;
    public final CheckBox kesaiweiTempUnitF;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720EvoId7FragmentSysSetBinding(RelativeLayout relativeLayout, SeekBar seekBar, TextView textView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9, CheckBox checkBox10) {
        this.rootView = relativeLayout;
        this.KSWBLSeekBar = seekBar;
        this.KSWBLVal = textView;
        this.btnAndroid360 = imageButton;
        this.btnBackcarMirror = imageButton2;
        this.btnCamera360 = imageButton3;
        this.btnCameraInstall = imageButton4;
        this.btnCameraOriginal = imageButton5;
        this.btnRadar = imageButton6;
        this.btnReversingTrack = imageButton7;
        this.btnTempUnitC = imageButton8;
        this.btnTempUnitF = imageButton9;
        this.btnVideoDrivingBan = imageButton10;
        this.kesaiweiAndroid360 = checkBox;
        this.kesaiweiCamera360 = checkBox2;
        this.kesaiweiCameraInstall = checkBox3;
        this.kesaiweiCameraOriginal = checkBox4;
        this.kesaiweiChkBackcarMirror = checkBox5;
        this.kesaiweiChkRadar = checkBox6;
        this.kesaiweiChkReversingTrack = checkBox7;
        this.kesaiweiChkVideoDrivingBan = checkBox8;
        this.kesaiweiTempUnitC = checkBox9;
        this.kesaiweiTempUnitF = checkBox10;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetBinding bind(View view) {
        View view2 = view;
        int i = R.id.KSW_BLSeekBar;
        SeekBar seekBar = (SeekBar) view2.findViewById(R.id.KSW_BLSeekBar);
        if (seekBar != null) {
            i = R.id.KSW_BL_val;
            TextView textView = (TextView) view2.findViewById(R.id.KSW_BL_val);
            if (textView != null) {
                i = R.id.btnAndroid360;
                ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btnAndroid360);
                if (imageButton != null) {
                    i = R.id.btnBackcarMirror;
                    ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btnBackcarMirror);
                    if (imageButton2 != null) {
                        i = R.id.btnCamera360;
                        ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnCamera360);
                        if (imageButton3 != null) {
                            i = R.id.btnCameraInstall;
                            ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.btnCameraInstall);
                            if (imageButton4 != null) {
                                i = R.id.btnCameraOriginal;
                                ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.btnCameraOriginal);
                                if (imageButton5 != null) {
                                    i = R.id.btnRadar;
                                    ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.btnRadar);
                                    if (imageButton6 != null) {
                                        i = R.id.btnReversingTrack;
                                        ImageButton imageButton7 = (ImageButton) view2.findViewById(R.id.btnReversingTrack);
                                        if (imageButton7 != null) {
                                            i = R.id.btnTempUnitC;
                                            ImageButton imageButton8 = (ImageButton) view2.findViewById(R.id.btnTempUnitC);
                                            if (imageButton8 != null) {
                                                i = R.id.btnTempUnitF;
                                                ImageButton imageButton9 = (ImageButton) view2.findViewById(R.id.btnTempUnitF);
                                                if (imageButton9 != null) {
                                                    i = R.id.btnVideoDrivingBan;
                                                    ImageButton imageButton10 = (ImageButton) view2.findViewById(R.id.btnVideoDrivingBan);
                                                    if (imageButton10 != null) {
                                                        i = R.id.kesaiwei_Android_360;
                                                        CheckBox checkBox = (CheckBox) view2.findViewById(R.id.kesaiwei_Android_360);
                                                        if (checkBox != null) {
                                                            i = R.id.kesaiwei_Camera_360;
                                                            CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.kesaiwei_Camera_360);
                                                            if (checkBox2 != null) {
                                                                i = R.id.kesaiwei_Camera_Install;
                                                                CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.kesaiwei_Camera_Install);
                                                                if (checkBox3 != null) {
                                                                    i = R.id.kesaiwei_Camera_Original;
                                                                    CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.kesaiwei_Camera_Original);
                                                                    if (checkBox4 != null) {
                                                                        i = R.id.kesaiwei_chk_backcarMirror;
                                                                        CheckBox checkBox5 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_backcarMirror);
                                                                        if (checkBox5 != null) {
                                                                            i = R.id.kesaiwei_chk_Radar;
                                                                            CheckBox checkBox6 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_Radar);
                                                                            if (checkBox6 != null) {
                                                                                i = R.id.kesaiwei_chk_ReversingTrack;
                                                                                CheckBox checkBox7 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_ReversingTrack);
                                                                                if (checkBox7 != null) {
                                                                                    i = R.id.kesaiwei_chk_VideoDrivingBan;
                                                                                    CheckBox checkBox8 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_VideoDrivingBan);
                                                                                    if (checkBox8 != null) {
                                                                                        i = R.id.kesaiwei_temp_unitC;
                                                                                        CheckBox checkBox9 = (CheckBox) view2.findViewById(R.id.kesaiwei_temp_unitC);
                                                                                        if (checkBox9 != null) {
                                                                                            i = R.id.kesaiwei_temp_unitF;
                                                                                            CheckBox checkBox10 = (CheckBox) view2.findViewById(R.id.kesaiwei_temp_unitF);
                                                                                            if (checkBox10 != null) {
                                                                                                return new Kesaiwei1920x720EvoId7FragmentSysSetBinding((RelativeLayout) view2, seekBar, textView, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10);
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
