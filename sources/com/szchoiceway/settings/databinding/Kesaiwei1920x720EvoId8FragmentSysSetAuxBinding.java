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
import com.szchoiceway.settings.view.MyScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.settings.view.MySeekbar1;

public final class Kesaiwei1920x720EvoId8FragmentSysSetAuxBinding implements ViewBinding {
    public final TextView KSWAux1Val;
    public final TextView KSWAux2Val;
    public final ImageButton btnAdd1;
    public final ImageButton btnAdd2;
    public final ImageButton btnAutoAux;
    public final ImageButton btnAuxTypeA;
    public final ImageButton btnAuxTypeCustomize;
    public final ImageButton btnAuxTypeH;
    public final ImageButton btnReduce1;
    public final ImageButton btnReduce2;
    public final CheckBox kesaiweiAuxTypeA;
    public final CheckBox kesaiweiAuxTypeCustomize;
    public final CheckBox kesaiweiAuxTypeH;
    public final CheckBox kesaiweiChkAutoAux;
    public final MyScrollView mScrollView;
    public final MyScrollbar myScrollbar;
    public final MySeekbar1 mySeekBar1Aux1;
    public final MySeekbar1 mySeekBar1Aux2;
    private final RelativeLayout rootView;
    public final LinearLayout scrollLayout;
    public final View viewKSWAux1SeekBar;
    public final View viewKSWAux2SeekBar;

    private Kesaiwei1920x720EvoId8FragmentSysSetAuxBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, MyScrollView myScrollView, MyScrollbar myScrollbar2, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, LinearLayout linearLayout, View view, View view2) {
        this.rootView = relativeLayout;
        this.KSWAux1Val = textView;
        this.KSWAux2Val = textView2;
        this.btnAdd1 = imageButton;
        this.btnAdd2 = imageButton2;
        this.btnAutoAux = imageButton3;
        this.btnAuxTypeA = imageButton4;
        this.btnAuxTypeCustomize = imageButton5;
        this.btnAuxTypeH = imageButton6;
        this.btnReduce1 = imageButton7;
        this.btnReduce2 = imageButton8;
        this.kesaiweiAuxTypeA = checkBox;
        this.kesaiweiAuxTypeCustomize = checkBox2;
        this.kesaiweiAuxTypeH = checkBox3;
        this.kesaiweiChkAutoAux = checkBox4;
        this.mScrollView = myScrollView;
        this.myScrollbar = myScrollbar2;
        this.mySeekBar1Aux1 = mySeekbar1;
        this.mySeekBar1Aux2 = mySeekbar12;
        this.scrollLayout = linearLayout;
        this.viewKSWAux1SeekBar = view;
        this.viewKSWAux2SeekBar = view2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetAuxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetAuxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_aux, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetAuxBinding bind(View view) {
        View view2 = view;
        int i = R.id.KSW_aux1_val;
        TextView textView = (TextView) view2.findViewById(R.id.KSW_aux1_val);
        if (textView != null) {
            i = R.id.KSW_aux2_val;
            TextView textView2 = (TextView) view2.findViewById(R.id.KSW_aux2_val);
            if (textView2 != null) {
                i = R.id.btnAdd1;
                ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btnAdd1);
                if (imageButton != null) {
                    i = R.id.btnAdd2;
                    ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btnAdd2);
                    if (imageButton2 != null) {
                        i = R.id.btnAutoAux;
                        ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnAutoAux);
                        if (imageButton3 != null) {
                            i = R.id.btnAuxTypeA;
                            ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.btnAuxTypeA);
                            if (imageButton4 != null) {
                                i = R.id.btnAuxTypeCustomize;
                                ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.btnAuxTypeCustomize);
                                if (imageButton5 != null) {
                                    i = R.id.btnAuxTypeH;
                                    ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.btnAuxTypeH);
                                    if (imageButton6 != null) {
                                        i = R.id.btnReduce1;
                                        ImageButton imageButton7 = (ImageButton) view2.findViewById(R.id.btnReduce1);
                                        if (imageButton7 != null) {
                                            i = R.id.btnReduce2;
                                            ImageButton imageButton8 = (ImageButton) view2.findViewById(R.id.btnReduce2);
                                            if (imageButton8 != null) {
                                                i = R.id.kesaiwei_aux_typeA;
                                                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.kesaiwei_aux_typeA);
                                                if (checkBox != null) {
                                                    i = R.id.kesaiwei_aux_type_customize;
                                                    CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.kesaiwei_aux_type_customize);
                                                    if (checkBox2 != null) {
                                                        i = R.id.kesaiwei_aux_typeH;
                                                        CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.kesaiwei_aux_typeH);
                                                        if (checkBox3 != null) {
                                                            i = R.id.kesaiwei_chk_auto_aux;
                                                            CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.kesaiwei_chk_auto_aux);
                                                            if (checkBox4 != null) {
                                                                i = R.id.mScrollView;
                                                                MyScrollView myScrollView = (MyScrollView) view2.findViewById(R.id.mScrollView);
                                                                if (myScrollView != null) {
                                                                    i = R.id.myScrollbar;
                                                                    MyScrollbar myScrollbar2 = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
                                                                    if (myScrollbar2 != null) {
                                                                        i = R.id.my_seekBar1_aux1;
                                                                        MySeekbar1 mySeekbar1 = (MySeekbar1) view2.findViewById(R.id.my_seekBar1_aux1);
                                                                        if (mySeekbar1 != null) {
                                                                            i = R.id.my_seekBar1_aux2;
                                                                            MySeekbar1 mySeekbar12 = (MySeekbar1) view2.findViewById(R.id.my_seekBar1_aux2);
                                                                            if (mySeekbar12 != null) {
                                                                                i = R.id.scrollLayout;
                                                                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.scrollLayout);
                                                                                if (linearLayout != null) {
                                                                                    i = R.id.viewKSW_aux1_SeekBar;
                                                                                    View findViewById = view2.findViewById(R.id.viewKSW_aux1_SeekBar);
                                                                                    if (findViewById != null) {
                                                                                        i = R.id.viewKSW_aux2_SeekBar;
                                                                                        View findViewById2 = view2.findViewById(R.id.viewKSW_aux2_SeekBar);
                                                                                        if (findViewById2 != null) {
                                                                                            return new Kesaiwei1920x720EvoId8FragmentSysSetAuxBinding((RelativeLayout) view2, textView, textView2, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, checkBox, checkBox2, checkBox3, checkBox4, myScrollView, myScrollbar2, mySeekbar1, mySeekbar12, linearLayout, findViewById, findViewById2);
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
