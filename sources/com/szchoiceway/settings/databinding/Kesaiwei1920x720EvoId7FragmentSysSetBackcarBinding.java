package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentSysSetBackcarBinding implements ViewBinding {
    public final ImageButton btnAndroid360;
    public final ImageButton btnAndroid3601080P;
    public final ImageButton btnAndroid360720P;
    public final ImageButton btnBackcarMirror;
    public final ImageButton btnCamera360;
    public final ImageButton btnCameraInstall;
    public final ImageButton btnCameraOriginal;
    public final ImageButton btnFrontMirror;
    public final ImageButton btnMute;
    public final ImageButton btnRadar;
    public final ImageButton btnReversingTrack;
    public final ImageButton btnSignalAHD108025;
    public final ImageButton btnSignalAHD108030;
    public final ImageButton btnSignalAHD72025;
    public final ImageButton btnSignalAHD72030;
    public final ImageButton btnSignalAuto;
    public final ImageButton btnSignalCVBSNTSC;
    public final ImageButton btnSignalCVBSPAL;
    public final CheckBox kesaiweiAndroid360;
    public final CheckBox kesaiweiAndroid3601080P;
    public final CheckBox kesaiweiAndroid360720P;
    public final CheckBox kesaiweiCamera360;
    public final CheckBox kesaiweiCameraInstall;
    public final CheckBox kesaiweiCameraOriginal;
    public final CheckBox kesaiweiChkBackcarMirror;
    public final CheckBox kesaiweiChkFrontMirror;
    public final CheckBox kesaiweiChkMute;
    public final CheckBox kesaiweiChkRadar;
    public final CheckBox kesaiweiChkReversingTrack;
    public final CheckBox kesaiweiChkSignalAHD108025;
    public final CheckBox kesaiweiChkSignalAHD108030;
    public final CheckBox kesaiweiChkSignalAHD72025;
    public final CheckBox kesaiweiChkSignalAHD72030;
    public final CheckBox kesaiweiChkSignalAuto;
    public final CheckBox kesaiweiChkSignalCVBSNTSC;
    public final CheckBox kesaiweiChkSignalCVBSPAL;
    public final ImageView lineBackcar;
    public final ImageView lineCamera;
    public final ScrollView mBackCarScrollView;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollLayout;
    public final TextView txtCamera;
    public final TextView txtSignalType;
    public final RelativeLayout viewAndroid360CameraSelect;
    public final RelativeLayout viewFront;

    private Kesaiwei1920x720EvoId7FragmentSysSetBackcarBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, ImageButton imageButton12, ImageButton imageButton13, ImageButton imageButton14, ImageButton imageButton15, ImageButton imageButton16, ImageButton imageButton17, ImageButton imageButton18, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9, CheckBox checkBox10, CheckBox checkBox11, CheckBox checkBox12, CheckBox checkBox13, CheckBox checkBox14, CheckBox checkBox15, CheckBox checkBox16, CheckBox checkBox17, CheckBox checkBox18, ImageView imageView, ImageView imageView2, ScrollView scrollView, RelativeLayout relativeLayout2, TextView textView, TextView textView2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4) {
        this.rootView = relativeLayout;
        this.btnAndroid360 = imageButton;
        this.btnAndroid3601080P = imageButton2;
        this.btnAndroid360720P = imageButton3;
        this.btnBackcarMirror = imageButton4;
        this.btnCamera360 = imageButton5;
        this.btnCameraInstall = imageButton6;
        this.btnCameraOriginal = imageButton7;
        this.btnFrontMirror = imageButton8;
        this.btnMute = imageButton9;
        this.btnRadar = imageButton10;
        this.btnReversingTrack = imageButton11;
        this.btnSignalAHD108025 = imageButton12;
        this.btnSignalAHD108030 = imageButton13;
        this.btnSignalAHD72025 = imageButton14;
        this.btnSignalAHD72030 = imageButton15;
        this.btnSignalAuto = imageButton16;
        this.btnSignalCVBSNTSC = imageButton17;
        this.btnSignalCVBSPAL = imageButton18;
        this.kesaiweiAndroid360 = checkBox;
        this.kesaiweiAndroid3601080P = checkBox2;
        this.kesaiweiAndroid360720P = checkBox3;
        this.kesaiweiCamera360 = checkBox4;
        this.kesaiweiCameraInstall = checkBox5;
        this.kesaiweiCameraOriginal = checkBox6;
        this.kesaiweiChkBackcarMirror = checkBox7;
        this.kesaiweiChkFrontMirror = checkBox8;
        this.kesaiweiChkMute = checkBox9;
        this.kesaiweiChkRadar = checkBox10;
        this.kesaiweiChkReversingTrack = checkBox11;
        this.kesaiweiChkSignalAHD108025 = checkBox12;
        this.kesaiweiChkSignalAHD108030 = checkBox13;
        this.kesaiweiChkSignalAHD72025 = checkBox14;
        this.kesaiweiChkSignalAHD72030 = checkBox15;
        this.kesaiweiChkSignalAuto = checkBox16;
        this.kesaiweiChkSignalCVBSNTSC = checkBox17;
        this.kesaiweiChkSignalCVBSPAL = checkBox18;
        this.lineBackcar = imageView;
        this.lineCamera = imageView2;
        this.mBackCarScrollView = scrollView;
        this.scrollLayout = relativeLayout2;
        this.txtCamera = textView;
        this.txtSignalType = textView2;
        this.viewAndroid360CameraSelect = relativeLayout3;
        this.viewFront = relativeLayout4;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetBackcarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetBackcarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_backcar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetBackcarBinding bind(View view) {
        View view2 = view;
        int i = R.id.btnAndroid360;
        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btnAndroid360);
        if (imageButton != null) {
            i = R.id.btnAndroid360_1080P;
            ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btnAndroid360_1080P);
            if (imageButton2 != null) {
                i = R.id.btnAndroid360_720P;
                ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnAndroid360_720P);
                if (imageButton3 != null) {
                    i = R.id.btnBackcarMirror;
                    ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.btnBackcarMirror);
                    if (imageButton4 != null) {
                        i = R.id.btnCamera360;
                        ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.btnCamera360);
                        if (imageButton5 != null) {
                            i = R.id.btnCameraInstall;
                            ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.btnCameraInstall);
                            if (imageButton6 != null) {
                                i = R.id.btnCameraOriginal;
                                ImageButton imageButton7 = (ImageButton) view2.findViewById(R.id.btnCameraOriginal);
                                if (imageButton7 != null) {
                                    i = R.id.btnFrontMirror;
                                    ImageButton imageButton8 = (ImageButton) view2.findViewById(R.id.btnFrontMirror);
                                    if (imageButton8 != null) {
                                        i = R.id.btnMute;
                                        ImageButton imageButton9 = (ImageButton) view2.findViewById(R.id.btnMute);
                                        if (imageButton9 != null) {
                                            i = R.id.btnRadar;
                                            ImageButton imageButton10 = (ImageButton) view2.findViewById(R.id.btnRadar);
                                            if (imageButton10 != null) {
                                                i = R.id.btnReversingTrack;
                                                ImageButton imageButton11 = (ImageButton) view2.findViewById(R.id.btnReversingTrack);
                                                if (imageButton11 != null) {
                                                    i = R.id.btnSignal_AHD1080_25;
                                                    ImageButton imageButton12 = (ImageButton) view2.findViewById(R.id.btnSignal_AHD1080_25);
                                                    if (imageButton12 != null) {
                                                        i = R.id.btnSignal_AHD1080_30;
                                                        ImageButton imageButton13 = (ImageButton) view2.findViewById(R.id.btnSignal_AHD1080_30);
                                                        if (imageButton13 != null) {
                                                            i = R.id.btnSignal_AHD720_25;
                                                            ImageButton imageButton14 = (ImageButton) view2.findViewById(R.id.btnSignal_AHD720_25);
                                                            if (imageButton14 != null) {
                                                                i = R.id.btnSignal_AHD720_30;
                                                                ImageButton imageButton15 = (ImageButton) view2.findViewById(R.id.btnSignal_AHD720_30);
                                                                if (imageButton15 != null) {
                                                                    i = R.id.btnSignal_auto;
                                                                    ImageButton imageButton16 = (ImageButton) view2.findViewById(R.id.btnSignal_auto);
                                                                    if (imageButton16 != null) {
                                                                        i = R.id.btnSignal_CVBS_NTSC;
                                                                        ImageButton imageButton17 = (ImageButton) view2.findViewById(R.id.btnSignal_CVBS_NTSC);
                                                                        if (imageButton17 != null) {
                                                                            i = R.id.btnSignal_CVBS_PAL;
                                                                            ImageButton imageButton18 = (ImageButton) view2.findViewById(R.id.btnSignal_CVBS_PAL);
                                                                            if (imageButton18 != null) {
                                                                                i = R.id.kesaiwei_Android360;
                                                                                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.kesaiwei_Android360);
                                                                                if (checkBox != null) {
                                                                                    i = R.id.kesaiwei_Android360_1080P;
                                                                                    CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.kesaiwei_Android360_1080P);
                                                                                    if (checkBox2 != null) {
                                                                                        i = R.id.kesaiwei_Android360_720P;
                                                                                        CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.kesaiwei_Android360_720P);
                                                                                        if (checkBox3 != null) {
                                                                                            i = R.id.kesaiwei_Camera_360;
                                                                                            CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.kesaiwei_Camera_360);
                                                                                            if (checkBox4 != null) {
                                                                                                i = R.id.kesaiwei_Camera_Install;
                                                                                                CheckBox checkBox5 = (CheckBox) view2.findViewById(R.id.kesaiwei_Camera_Install);
                                                                                                if (checkBox5 != null) {
                                                                                                    i = R.id.kesaiwei_Camera_Original;
                                                                                                    CheckBox checkBox6 = (CheckBox) view2.findViewById(R.id.kesaiwei_Camera_Original);
                                                                                                    if (checkBox6 != null) {
                                                                                                        i = R.id.kesaiwei_chk_BackcarMirror;
                                                                                                        CheckBox checkBox7 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_BackcarMirror);
                                                                                                        if (checkBox7 != null) {
                                                                                                            i = R.id.kesaiwei_chk_FrontMirror;
                                                                                                            CheckBox checkBox8 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_FrontMirror);
                                                                                                            if (checkBox8 != null) {
                                                                                                                i = R.id.kesaiwei_chk_Mute;
                                                                                                                CheckBox checkBox9 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_Mute);
                                                                                                                if (checkBox9 != null) {
                                                                                                                    i = R.id.kesaiwei_chk_Radar;
                                                                                                                    CheckBox checkBox10 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_Radar);
                                                                                                                    if (checkBox10 != null) {
                                                                                                                        i = R.id.kesaiwei_chk_ReversingTrack;
                                                                                                                        CheckBox checkBox11 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_ReversingTrack);
                                                                                                                        if (checkBox11 != null) {
                                                                                                                            i = R.id.kesaiwei_chk_signal_AHD1080_25;
                                                                                                                            CheckBox checkBox12 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_signal_AHD1080_25);
                                                                                                                            if (checkBox12 != null) {
                                                                                                                                i = R.id.kesaiwei_chk_signal_AHD1080_30;
                                                                                                                                CheckBox checkBox13 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_signal_AHD1080_30);
                                                                                                                                if (checkBox13 != null) {
                                                                                                                                    i = R.id.kesaiwei_chk_signal_AHD720_25;
                                                                                                                                    CheckBox checkBox14 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_signal_AHD720_25);
                                                                                                                                    if (checkBox14 != null) {
                                                                                                                                        i = R.id.kesaiwei_chk_signal_AHD720_30;
                                                                                                                                        CheckBox checkBox15 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_signal_AHD720_30);
                                                                                                                                        if (checkBox15 != null) {
                                                                                                                                            i = R.id.kesaiwei_chk_signal_auto;
                                                                                                                                            CheckBox checkBox16 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_signal_auto);
                                                                                                                                            if (checkBox16 != null) {
                                                                                                                                                i = R.id.kesaiwei_chk_signal_CVBS_NTSC;
                                                                                                                                                CheckBox checkBox17 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_signal_CVBS_NTSC);
                                                                                                                                                if (checkBox17 != null) {
                                                                                                                                                    i = R.id.kesaiwei_chk_signal_CVBS_PAL;
                                                                                                                                                    CheckBox checkBox18 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_signal_CVBS_PAL);
                                                                                                                                                    if (checkBox18 != null) {
                                                                                                                                                        i = R.id.lineBackcar;
                                                                                                                                                        ImageView imageView = (ImageView) view2.findViewById(R.id.lineBackcar);
                                                                                                                                                        if (imageView != null) {
                                                                                                                                                            i = R.id.lineCamera;
                                                                                                                                                            ImageView imageView2 = (ImageView) view2.findViewById(R.id.lineCamera);
                                                                                                                                                            if (imageView2 != null) {
                                                                                                                                                                i = R.id.mBackCarScrollView;
                                                                                                                                                                ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mBackCarScrollView);
                                                                                                                                                                if (scrollView != null) {
                                                                                                                                                                    i = R.id.scrollLayout;
                                                                                                                                                                    RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.scrollLayout);
                                                                                                                                                                    if (relativeLayout != null) {
                                                                                                                                                                        i = R.id.txtCamera;
                                                                                                                                                                        TextView textView = (TextView) view2.findViewById(R.id.txtCamera);
                                                                                                                                                                        if (textView != null) {
                                                                                                                                                                            i = R.id.txtSignalType;
                                                                                                                                                                            TextView textView2 = (TextView) view2.findViewById(R.id.txtSignalType);
                                                                                                                                                                            if (textView2 != null) {
                                                                                                                                                                                i = R.id.viewAndroid360CameraSelect;
                                                                                                                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.viewAndroid360CameraSelect);
                                                                                                                                                                                if (relativeLayout2 != null) {
                                                                                                                                                                                    i = R.id.viewFront;
                                                                                                                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.viewFront);
                                                                                                                                                                                    if (relativeLayout3 != null) {
                                                                                                                                                                                        return new Kesaiwei1920x720EvoId7FragmentSysSetBackcarBinding((RelativeLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, imageButton12, imageButton13, imageButton14, imageButton15, imageButton16, imageButton17, imageButton18, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17, checkBox18, imageView, imageView2, scrollView, relativeLayout, textView, textView2, relativeLayout2, relativeLayout3);
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