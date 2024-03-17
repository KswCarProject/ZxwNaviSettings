package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollView;
import com.szchoiceway.settings.view.MySeekbar1;

public final class LandroverThemeFragmentSysSetAuxBinding implements ViewBinding {
    public final TextView KSWAux1Val;
    public final TextView KSWAux2Val;
    public final ImageButton btnAutoAux;
    public final ImageButton btnAuxTypeA;
    public final ImageButton btnAuxTypeCustomize;
    public final ImageButton btnAuxTypeH;
    public final CheckBox kesaiweiAuxTypeA;
    public final CheckBox kesaiweiAuxTypeCustomize;
    public final CheckBox kesaiweiAuxTypeH;
    public final CheckBox kesaiweiChkAutoAux;
    public final ImageView lineAuxSwitch;
    public final MyScrollView mScrollView;
    public final MySeekbar1 mySeekBar1Aux1;
    public final MySeekbar1 mySeekBar1Aux2;
    private final RelativeLayout rootView;
    public final TextView txtAuxSwitch;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;
    public final RelativeLayout view4;
    public final RelativeLayout view5;
    public final RelativeLayout view6;
    public final RelativeLayout view7;

    private LandroverThemeFragmentSysSetAuxBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, ImageView imageView, MyScrollView myScrollView, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, TextView textView3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9) {
        this.rootView = relativeLayout;
        this.KSWAux1Val = textView;
        this.KSWAux2Val = textView2;
        this.btnAutoAux = imageButton;
        this.btnAuxTypeA = imageButton2;
        this.btnAuxTypeCustomize = imageButton3;
        this.btnAuxTypeH = imageButton4;
        this.kesaiweiAuxTypeA = checkBox;
        this.kesaiweiAuxTypeCustomize = checkBox2;
        this.kesaiweiAuxTypeH = checkBox3;
        this.kesaiweiChkAutoAux = checkBox4;
        this.lineAuxSwitch = imageView;
        this.mScrollView = myScrollView;
        this.mySeekBar1Aux1 = mySeekbar1;
        this.mySeekBar1Aux2 = mySeekbar12;
        this.txtAuxSwitch = textView3;
        this.view0 = relativeLayout2;
        this.view1 = relativeLayout3;
        this.view2 = relativeLayout4;
        this.view3 = relativeLayout5;
        this.view4 = relativeLayout6;
        this.view5 = relativeLayout7;
        this.view6 = relativeLayout8;
        this.view7 = relativeLayout9;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LandroverThemeFragmentSysSetAuxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverThemeFragmentSysSetAuxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_aux, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverThemeFragmentSysSetAuxBinding bind(View view) {
        View view8 = view;
        int i = R.id.KSW_aux1_val;
        TextView textView = (TextView) view8.findViewById(R.id.KSW_aux1_val);
        if (textView != null) {
            i = R.id.KSW_aux2_val;
            TextView textView2 = (TextView) view8.findViewById(R.id.KSW_aux2_val);
            if (textView2 != null) {
                i = R.id.btnAutoAux;
                ImageButton imageButton = (ImageButton) view8.findViewById(R.id.btnAutoAux);
                if (imageButton != null) {
                    i = R.id.btnAuxTypeA;
                    ImageButton imageButton2 = (ImageButton) view8.findViewById(R.id.btnAuxTypeA);
                    if (imageButton2 != null) {
                        i = R.id.btnAuxTypeCustomize;
                        ImageButton imageButton3 = (ImageButton) view8.findViewById(R.id.btnAuxTypeCustomize);
                        if (imageButton3 != null) {
                            i = R.id.btnAuxTypeH;
                            ImageButton imageButton4 = (ImageButton) view8.findViewById(R.id.btnAuxTypeH);
                            if (imageButton4 != null) {
                                i = R.id.kesaiwei_aux_typeA;
                                CheckBox checkBox = (CheckBox) view8.findViewById(R.id.kesaiwei_aux_typeA);
                                if (checkBox != null) {
                                    i = R.id.kesaiwei_aux_type_customize;
                                    CheckBox checkBox2 = (CheckBox) view8.findViewById(R.id.kesaiwei_aux_type_customize);
                                    if (checkBox2 != null) {
                                        i = R.id.kesaiwei_aux_typeH;
                                        CheckBox checkBox3 = (CheckBox) view8.findViewById(R.id.kesaiwei_aux_typeH);
                                        if (checkBox3 != null) {
                                            i = R.id.kesaiwei_chk_auto_aux;
                                            CheckBox checkBox4 = (CheckBox) view8.findViewById(R.id.kesaiwei_chk_auto_aux);
                                            if (checkBox4 != null) {
                                                i = R.id.lineAuxSwitch;
                                                ImageView imageView = (ImageView) view8.findViewById(R.id.lineAuxSwitch);
                                                if (imageView != null) {
                                                    i = R.id.mScrollView;
                                                    MyScrollView myScrollView = (MyScrollView) view8.findViewById(R.id.mScrollView);
                                                    if (myScrollView != null) {
                                                        i = R.id.my_seekBar1_aux1;
                                                        MySeekbar1 mySeekbar1 = (MySeekbar1) view8.findViewById(R.id.my_seekBar1_aux1);
                                                        if (mySeekbar1 != null) {
                                                            i = R.id.my_seekBar1_aux2;
                                                            MySeekbar1 mySeekbar12 = (MySeekbar1) view8.findViewById(R.id.my_seekBar1_aux2);
                                                            if (mySeekbar12 != null) {
                                                                i = R.id.txtAuxSwitch;
                                                                TextView textView3 = (TextView) view8.findViewById(R.id.txtAuxSwitch);
                                                                if (textView3 != null) {
                                                                    i = R.id.view0;
                                                                    RelativeLayout relativeLayout = (RelativeLayout) view8.findViewById(R.id.view0);
                                                                    if (relativeLayout != null) {
                                                                        i = R.id.view1;
                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view8.findViewById(R.id.view1);
                                                                        if (relativeLayout2 != null) {
                                                                            i = R.id.view2;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) view8.findViewById(R.id.view2);
                                                                            if (relativeLayout3 != null) {
                                                                                i = R.id.view3;
                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) view8.findViewById(R.id.view3);
                                                                                if (relativeLayout4 != null) {
                                                                                    i = R.id.view4;
                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) view8.findViewById(R.id.view4);
                                                                                    if (relativeLayout5 != null) {
                                                                                        i = R.id.view5;
                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) view8.findViewById(R.id.view5);
                                                                                        if (relativeLayout6 != null) {
                                                                                            i = R.id.view6;
                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) view8.findViewById(R.id.view6);
                                                                                            if (relativeLayout7 != null) {
                                                                                                i = R.id.view7;
                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) view8.findViewById(R.id.view7);
                                                                                                if (relativeLayout8 != null) {
                                                                                                    return new LandroverThemeFragmentSysSetAuxBinding((RelativeLayout) view8, textView, textView2, imageButton, imageButton2, imageButton3, imageButton4, checkBox, checkBox2, checkBox3, checkBox4, imageView, myScrollView, mySeekbar1, mySeekbar12, textView3, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8);
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
