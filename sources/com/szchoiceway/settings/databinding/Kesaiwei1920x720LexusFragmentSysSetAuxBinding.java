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
import com.szchoiceway.settings.view.MyScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.settings.view.MySeekbar1;

public final class Kesaiwei1920x720LexusFragmentSysSetAuxBinding implements ViewBinding {
    public final TextView KSWAux1Val;
    public final TextView KSWAux2Val;
    public final TextView aux1Title;
    public final TextView aux2Title;
    public final ImageButton btnAutoAux;
    public final ImageButton btnAuxTypeA;
    public final ImageButton btnAuxTypeCustomize;
    public final ImageButton btnAuxTypeH;
    public final CheckBox kesaiweiAuxTypeA;
    public final CheckBox kesaiweiAuxTypeCustomize;
    public final CheckBox kesaiweiAuxTypeH;
    public final CheckBox kesaiweiChkAutoAux;
    public final MyScrollView mScrollView;
    public final MyScrollbar myScrollbar;
    public final MySeekbar1 mySeekBar1Aux1;
    public final MySeekbar1 mySeekBar1Aux2;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollLayout;
    public final RelativeLayout title0;
    public final RelativeLayout title1;
    public final RelativeLayout title2;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;
    public final RelativeLayout view4;
    public final View viewKSWAux1SeekBar;
    public final View viewKSWAux2SeekBar;

    private Kesaiwei1920x720LexusFragmentSysSetAuxBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, MyScrollView myScrollView, MyScrollbar myScrollbar2, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, View view, View view5) {
        this.rootView = relativeLayout;
        this.KSWAux1Val = textView;
        this.KSWAux2Val = textView2;
        this.aux1Title = textView3;
        this.aux2Title = textView4;
        this.btnAutoAux = imageButton;
        this.btnAuxTypeA = imageButton2;
        this.btnAuxTypeCustomize = imageButton3;
        this.btnAuxTypeH = imageButton4;
        this.kesaiweiAuxTypeA = checkBox;
        this.kesaiweiAuxTypeCustomize = checkBox2;
        this.kesaiweiAuxTypeH = checkBox3;
        this.kesaiweiChkAutoAux = checkBox4;
        this.mScrollView = myScrollView;
        this.myScrollbar = myScrollbar2;
        this.mySeekBar1Aux1 = mySeekbar1;
        this.mySeekBar1Aux2 = mySeekbar12;
        this.scrollLayout = relativeLayout2;
        this.title0 = relativeLayout3;
        this.title1 = relativeLayout4;
        this.title2 = relativeLayout5;
        this.view0 = relativeLayout6;
        this.view1 = relativeLayout7;
        this.view2 = relativeLayout8;
        this.view3 = relativeLayout9;
        this.view4 = relativeLayout10;
        this.viewKSWAux1SeekBar = view;
        this.viewKSWAux2SeekBar = view5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720LexusFragmentSysSetAuxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetAuxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_aux, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetAuxBinding bind(View view) {
        View view5 = view;
        int i = R.id.KSW_aux1_val;
        TextView textView = (TextView) view5.findViewById(R.id.KSW_aux1_val);
        if (textView != null) {
            i = R.id.KSW_aux2_val;
            TextView textView2 = (TextView) view5.findViewById(R.id.KSW_aux2_val);
            if (textView2 != null) {
                i = R.id.aux1Title;
                TextView textView3 = (TextView) view5.findViewById(R.id.aux1Title);
                if (textView3 != null) {
                    i = R.id.aux2Title;
                    TextView textView4 = (TextView) view5.findViewById(R.id.aux2Title);
                    if (textView4 != null) {
                        i = R.id.btnAutoAux;
                        ImageButton imageButton = (ImageButton) view5.findViewById(R.id.btnAutoAux);
                        if (imageButton != null) {
                            i = R.id.btnAuxTypeA;
                            ImageButton imageButton2 = (ImageButton) view5.findViewById(R.id.btnAuxTypeA);
                            if (imageButton2 != null) {
                                i = R.id.btnAuxTypeCustomize;
                                ImageButton imageButton3 = (ImageButton) view5.findViewById(R.id.btnAuxTypeCustomize);
                                if (imageButton3 != null) {
                                    i = R.id.btnAuxTypeH;
                                    ImageButton imageButton4 = (ImageButton) view5.findViewById(R.id.btnAuxTypeH);
                                    if (imageButton4 != null) {
                                        i = R.id.kesaiwei_aux_typeA;
                                        CheckBox checkBox = (CheckBox) view5.findViewById(R.id.kesaiwei_aux_typeA);
                                        if (checkBox != null) {
                                            i = R.id.kesaiwei_aux_type_customize;
                                            CheckBox checkBox2 = (CheckBox) view5.findViewById(R.id.kesaiwei_aux_type_customize);
                                            if (checkBox2 != null) {
                                                i = R.id.kesaiwei_aux_typeH;
                                                CheckBox checkBox3 = (CheckBox) view5.findViewById(R.id.kesaiwei_aux_typeH);
                                                if (checkBox3 != null) {
                                                    i = R.id.kesaiwei_chk_auto_aux;
                                                    CheckBox checkBox4 = (CheckBox) view5.findViewById(R.id.kesaiwei_chk_auto_aux);
                                                    if (checkBox4 != null) {
                                                        i = R.id.mScrollView;
                                                        MyScrollView myScrollView = (MyScrollView) view5.findViewById(R.id.mScrollView);
                                                        if (myScrollView != null) {
                                                            i = R.id.myScrollbar;
                                                            MyScrollbar myScrollbar2 = (MyScrollbar) view5.findViewById(R.id.myScrollbar);
                                                            if (myScrollbar2 != null) {
                                                                i = R.id.my_seekBar1_aux1;
                                                                MySeekbar1 mySeekbar1 = (MySeekbar1) view5.findViewById(R.id.my_seekBar1_aux1);
                                                                if (mySeekbar1 != null) {
                                                                    i = R.id.my_seekBar1_aux2;
                                                                    MySeekbar1 mySeekbar12 = (MySeekbar1) view5.findViewById(R.id.my_seekBar1_aux2);
                                                                    if (mySeekbar12 != null) {
                                                                        i = R.id.scrollLayout;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) view5.findViewById(R.id.scrollLayout);
                                                                        if (relativeLayout != null) {
                                                                            i = R.id.title0;
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view5.findViewById(R.id.title0);
                                                                            if (relativeLayout2 != null) {
                                                                                i = R.id.title1;
                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) view5.findViewById(R.id.title1);
                                                                                if (relativeLayout3 != null) {
                                                                                    i = R.id.title2;
                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) view5.findViewById(R.id.title2);
                                                                                    if (relativeLayout4 != null) {
                                                                                        i = R.id.view0;
                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) view5.findViewById(R.id.view0);
                                                                                        if (relativeLayout5 != null) {
                                                                                            i = R.id.view1;
                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) view5.findViewById(R.id.view1);
                                                                                            if (relativeLayout6 != null) {
                                                                                                i = R.id.view2;
                                                                                                RelativeLayout relativeLayout7 = (RelativeLayout) view5.findViewById(R.id.view2);
                                                                                                if (relativeLayout7 != null) {
                                                                                                    i = R.id.view3;
                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) view5.findViewById(R.id.view3);
                                                                                                    if (relativeLayout8 != null) {
                                                                                                        i = R.id.view4;
                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) view5.findViewById(R.id.view4);
                                                                                                        if (relativeLayout9 != null) {
                                                                                                            i = R.id.viewKSW_aux1_SeekBar;
                                                                                                            View findViewById = view5.findViewById(R.id.viewKSW_aux1_SeekBar);
                                                                                                            if (findViewById != null) {
                                                                                                                i = R.id.viewKSW_aux2_SeekBar;
                                                                                                                View findViewById2 = view5.findViewById(R.id.viewKSW_aux2_SeekBar);
                                                                                                                if (findViewById2 != null) {
                                                                                                                    return new Kesaiwei1920x720LexusFragmentSysSetAuxBinding((RelativeLayout) view5, textView, textView2, textView3, textView4, imageButton, imageButton2, imageButton3, imageButton4, checkBox, checkBox2, checkBox3, checkBox4, myScrollView, myScrollbar2, mySeekbar1, mySeekbar12, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, findViewById, findViewById2);
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
