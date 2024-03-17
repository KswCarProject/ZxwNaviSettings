package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class PempId7FragmentSysSetAuxBinding implements ViewBinding {
    public final SeekBar KSWAux1SeekBar;
    public final TextView KSWAux1Val;
    public final SeekBar KSWAux2SeekBar;
    public final TextView KSWAux2Val;
    public final ImageButton btnAutoAux;
    public final ImageButton btnAuxTypeA;
    public final ImageButton btnAuxTypeCustomize;
    public final ImageButton btnAuxTypeH;
    public final CheckBox kesaiweiAuxTypeA;
    public final CheckBox kesaiweiAuxTypeCustomize;
    public final CheckBox kesaiweiAuxTypeH;
    public final CheckBox kesaiweiChkAutoAux;
    public final ScrollView mScrollView;
    private final RelativeLayout rootView;
    public final TextView txtAuxSwitch;
    public final TextView txtOriginalAux1;
    public final TextView txtOriginalAux2;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;
    public final View viewKSWAux1SeekBar;
    public final View viewKSWAux2SeekBar;

    private PempId7FragmentSysSetAuxBinding(RelativeLayout relativeLayout, SeekBar seekBar, TextView textView, SeekBar seekBar2, TextView textView2, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, ScrollView scrollView, TextView textView3, TextView textView4, TextView textView5, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, View view, View view4) {
        this.rootView = relativeLayout;
        this.KSWAux1SeekBar = seekBar;
        this.KSWAux1Val = textView;
        this.KSWAux2SeekBar = seekBar2;
        this.KSWAux2Val = textView2;
        this.btnAutoAux = imageButton;
        this.btnAuxTypeA = imageButton2;
        this.btnAuxTypeCustomize = imageButton3;
        this.btnAuxTypeH = imageButton4;
        this.kesaiweiAuxTypeA = checkBox;
        this.kesaiweiAuxTypeCustomize = checkBox2;
        this.kesaiweiAuxTypeH = checkBox3;
        this.kesaiweiChkAutoAux = checkBox4;
        this.mScrollView = scrollView;
        this.txtAuxSwitch = textView3;
        this.txtOriginalAux1 = textView4;
        this.txtOriginalAux2 = textView5;
        this.view0 = relativeLayout2;
        this.view1 = relativeLayout3;
        this.view2 = relativeLayout4;
        this.view3 = relativeLayout5;
        this.viewKSWAux1SeekBar = view;
        this.viewKSWAux2SeekBar = view4;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PempId7FragmentSysSetAuxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PempId7FragmentSysSetAuxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_aux, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PempId7FragmentSysSetAuxBinding bind(View view) {
        View view4 = view;
        int i = R.id.KSW_aux1_SeekBar;
        SeekBar seekBar = (SeekBar) view4.findViewById(R.id.KSW_aux1_SeekBar);
        if (seekBar != null) {
            i = R.id.KSW_aux1_val;
            TextView textView = (TextView) view4.findViewById(R.id.KSW_aux1_val);
            if (textView != null) {
                i = R.id.KSW_aux2_SeekBar;
                SeekBar seekBar2 = (SeekBar) view4.findViewById(R.id.KSW_aux2_SeekBar);
                if (seekBar2 != null) {
                    i = R.id.KSW_aux2_val;
                    TextView textView2 = (TextView) view4.findViewById(R.id.KSW_aux2_val);
                    if (textView2 != null) {
                        i = R.id.btnAutoAux;
                        ImageButton imageButton = (ImageButton) view4.findViewById(R.id.btnAutoAux);
                        if (imageButton != null) {
                            i = R.id.btnAuxTypeA;
                            ImageButton imageButton2 = (ImageButton) view4.findViewById(R.id.btnAuxTypeA);
                            if (imageButton2 != null) {
                                i = R.id.btnAuxTypeCustomize;
                                ImageButton imageButton3 = (ImageButton) view4.findViewById(R.id.btnAuxTypeCustomize);
                                if (imageButton3 != null) {
                                    i = R.id.btnAuxTypeH;
                                    ImageButton imageButton4 = (ImageButton) view4.findViewById(R.id.btnAuxTypeH);
                                    if (imageButton4 != null) {
                                        i = R.id.kesaiwei_aux_typeA;
                                        CheckBox checkBox = (CheckBox) view4.findViewById(R.id.kesaiwei_aux_typeA);
                                        if (checkBox != null) {
                                            i = R.id.kesaiwei_aux_type_customize;
                                            CheckBox checkBox2 = (CheckBox) view4.findViewById(R.id.kesaiwei_aux_type_customize);
                                            if (checkBox2 != null) {
                                                i = R.id.kesaiwei_aux_typeH;
                                                CheckBox checkBox3 = (CheckBox) view4.findViewById(R.id.kesaiwei_aux_typeH);
                                                if (checkBox3 != null) {
                                                    i = R.id.kesaiwei_chk_auto_aux;
                                                    CheckBox checkBox4 = (CheckBox) view4.findViewById(R.id.kesaiwei_chk_auto_aux);
                                                    if (checkBox4 != null) {
                                                        i = R.id.mScrollView;
                                                        ScrollView scrollView = (ScrollView) view4.findViewById(R.id.mScrollView);
                                                        if (scrollView != null) {
                                                            i = R.id.txtAuxSwitch;
                                                            TextView textView3 = (TextView) view4.findViewById(R.id.txtAuxSwitch);
                                                            if (textView3 != null) {
                                                                i = R.id.txtOriginalAux1;
                                                                TextView textView4 = (TextView) view4.findViewById(R.id.txtOriginalAux1);
                                                                if (textView4 != null) {
                                                                    i = R.id.txtOriginalAux2;
                                                                    TextView textView5 = (TextView) view4.findViewById(R.id.txtOriginalAux2);
                                                                    if (textView5 != null) {
                                                                        i = R.id.view0;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) view4.findViewById(R.id.view0);
                                                                        if (relativeLayout != null) {
                                                                            i = R.id.view1;
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view4.findViewById(R.id.view1);
                                                                            if (relativeLayout2 != null) {
                                                                                i = R.id.view2;
                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) view4.findViewById(R.id.view2);
                                                                                if (relativeLayout3 != null) {
                                                                                    i = R.id.view3;
                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) view4.findViewById(R.id.view3);
                                                                                    if (relativeLayout4 != null) {
                                                                                        i = R.id.viewKSW_aux1_SeekBar;
                                                                                        View findViewById = view4.findViewById(R.id.viewKSW_aux1_SeekBar);
                                                                                        if (findViewById != null) {
                                                                                            i = R.id.viewKSW_aux2_SeekBar;
                                                                                            View findViewById2 = view4.findViewById(R.id.viewKSW_aux2_SeekBar);
                                                                                            if (findViewById2 != null) {
                                                                                                return new PempId7FragmentSysSetAuxBinding((RelativeLayout) view4, seekBar, textView, seekBar2, textView2, imageButton, imageButton2, imageButton3, imageButton4, checkBox, checkBox2, checkBox3, checkBox4, scrollView, textView3, textView4, textView5, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, findViewById, findViewById2);
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
