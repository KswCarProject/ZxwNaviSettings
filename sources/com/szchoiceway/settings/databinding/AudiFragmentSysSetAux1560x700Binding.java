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

public final class AudiFragmentSysSetAux1560x700Binding implements ViewBinding {
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
    public final MyScrollView mScrollView;
    public final MyScrollbar myScrollbar;
    public final MySeekbar1 mySeekBar1Aux1;
    public final MySeekbar1 mySeekBar1Aux2;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollLayout;
    public final TextView txtAuxSwitch;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;
    public final RelativeLayout view4;
    public final RelativeLayout view5;
    public final View viewKSWAux1SeekBar;
    public final View viewKSWAux2SeekBar;

    private AudiFragmentSysSetAux1560x700Binding(RelativeLayout relativeLayout, TextView textView, TextView textView2, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, MyScrollView myScrollView, MyScrollbar myScrollbar2, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, RelativeLayout relativeLayout2, TextView textView3, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, View view, View view6) {
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
        this.mScrollView = myScrollView;
        this.myScrollbar = myScrollbar2;
        this.mySeekBar1Aux1 = mySeekbar1;
        this.mySeekBar1Aux2 = mySeekbar12;
        this.scrollLayout = relativeLayout2;
        this.txtAuxSwitch = textView3;
        this.view0 = relativeLayout3;
        this.view1 = relativeLayout4;
        this.view2 = relativeLayout5;
        this.view3 = relativeLayout6;
        this.view4 = relativeLayout7;
        this.view5 = relativeLayout8;
        this.viewKSWAux1SeekBar = view;
        this.viewKSWAux2SeekBar = view6;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AudiFragmentSysSetAux1560x700Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiFragmentSysSetAux1560x700Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_fragment_sys_set_aux_1560x700, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiFragmentSysSetAux1560x700Binding bind(View view) {
        View view6 = view;
        int i = R.id.KSW_aux1_val;
        TextView textView = (TextView) view6.findViewById(R.id.KSW_aux1_val);
        if (textView != null) {
            i = R.id.KSW_aux2_val;
            TextView textView2 = (TextView) view6.findViewById(R.id.KSW_aux2_val);
            if (textView2 != null) {
                i = R.id.btnAutoAux;
                ImageButton imageButton = (ImageButton) view6.findViewById(R.id.btnAutoAux);
                if (imageButton != null) {
                    i = R.id.btnAuxTypeA;
                    ImageButton imageButton2 = (ImageButton) view6.findViewById(R.id.btnAuxTypeA);
                    if (imageButton2 != null) {
                        i = R.id.btnAuxTypeCustomize;
                        ImageButton imageButton3 = (ImageButton) view6.findViewById(R.id.btnAuxTypeCustomize);
                        if (imageButton3 != null) {
                            i = R.id.btnAuxTypeH;
                            ImageButton imageButton4 = (ImageButton) view6.findViewById(R.id.btnAuxTypeH);
                            if (imageButton4 != null) {
                                i = R.id.kesaiwei_aux_typeA;
                                CheckBox checkBox = (CheckBox) view6.findViewById(R.id.kesaiwei_aux_typeA);
                                if (checkBox != null) {
                                    i = R.id.kesaiwei_aux_type_customize;
                                    CheckBox checkBox2 = (CheckBox) view6.findViewById(R.id.kesaiwei_aux_type_customize);
                                    if (checkBox2 != null) {
                                        i = R.id.kesaiwei_aux_typeH;
                                        CheckBox checkBox3 = (CheckBox) view6.findViewById(R.id.kesaiwei_aux_typeH);
                                        if (checkBox3 != null) {
                                            i = R.id.kesaiwei_chk_auto_aux;
                                            CheckBox checkBox4 = (CheckBox) view6.findViewById(R.id.kesaiwei_chk_auto_aux);
                                            if (checkBox4 != null) {
                                                i = R.id.mScrollView;
                                                MyScrollView myScrollView = (MyScrollView) view6.findViewById(R.id.mScrollView);
                                                if (myScrollView != null) {
                                                    i = R.id.myScrollbar;
                                                    MyScrollbar myScrollbar2 = (MyScrollbar) view6.findViewById(R.id.myScrollbar);
                                                    if (myScrollbar2 != null) {
                                                        i = R.id.my_seekBar1_aux1;
                                                        MySeekbar1 mySeekbar1 = (MySeekbar1) view6.findViewById(R.id.my_seekBar1_aux1);
                                                        if (mySeekbar1 != null) {
                                                            i = R.id.my_seekBar1_aux2;
                                                            MySeekbar1 mySeekbar12 = (MySeekbar1) view6.findViewById(R.id.my_seekBar1_aux2);
                                                            if (mySeekbar12 != null) {
                                                                i = R.id.scrollLayout;
                                                                RelativeLayout relativeLayout = (RelativeLayout) view6.findViewById(R.id.scrollLayout);
                                                                if (relativeLayout != null) {
                                                                    i = R.id.txtAuxSwitch;
                                                                    TextView textView3 = (TextView) view6.findViewById(R.id.txtAuxSwitch);
                                                                    if (textView3 != null) {
                                                                        i = R.id.view0;
                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view6.findViewById(R.id.view0);
                                                                        if (relativeLayout2 != null) {
                                                                            i = R.id.view1;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) view6.findViewById(R.id.view1);
                                                                            if (relativeLayout3 != null) {
                                                                                i = R.id.view2;
                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) view6.findViewById(R.id.view2);
                                                                                if (relativeLayout4 != null) {
                                                                                    i = R.id.view3;
                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) view6.findViewById(R.id.view3);
                                                                                    if (relativeLayout5 != null) {
                                                                                        i = R.id.view4;
                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) view6.findViewById(R.id.view4);
                                                                                        if (relativeLayout6 != null) {
                                                                                            i = R.id.view5;
                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) view6.findViewById(R.id.view5);
                                                                                            if (relativeLayout7 != null) {
                                                                                                i = R.id.viewKSW_aux1_SeekBar;
                                                                                                View findViewById = view6.findViewById(R.id.viewKSW_aux1_SeekBar);
                                                                                                if (findViewById != null) {
                                                                                                    i = R.id.viewKSW_aux2_SeekBar;
                                                                                                    View findViewById2 = view6.findViewById(R.id.viewKSW_aux2_SeekBar);
                                                                                                    if (findViewById2 != null) {
                                                                                                        return new AudiFragmentSysSetAux1560x700Binding((RelativeLayout) view6, textView, textView2, imageButton, imageButton2, imageButton3, imageButton4, checkBox, checkBox2, checkBox3, checkBox4, myScrollView, myScrollbar2, mySeekbar1, mySeekbar12, relativeLayout, textView3, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, findViewById, findViewById2);
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
