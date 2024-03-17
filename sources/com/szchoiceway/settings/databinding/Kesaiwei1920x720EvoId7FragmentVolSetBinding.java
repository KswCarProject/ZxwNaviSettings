package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentVolSetBinding implements ViewBinding {
    public final Button KSWBtnEqClassical;
    public final Button KSWBtnEqCustom;
    public final Button KSWBtnEqDance;
    public final Button KSWBtnEqJazz;
    public final Button KSWBtnEqPop;
    public final Button KSWBtnEqRock;
    public final SeekBar KSWVolSeekBarPage2Hight;
    public final SeekBar KSWVolSeekBarPage2Low;
    public final SeekBar KSWVolSeekBarPage2Mid;
    public final TextView KSWVolValueAlto;
    public final TextView KSWVolValueBass;
    public final TextView KSWVolValueTreble;
    public final CheckBox chkClassical;
    public final CheckBox chkDance;
    public final CheckBox chkJazz;
    public final CheckBox chkPop;
    public final CheckBox chkRock;
    public final CheckBox chkUser;
    public final ScrollView mScrollView;
    private final RelativeLayout rootView;
    public final View viewKSWVolPage2Hight;
    public final View viewKSWVolPage2Low;
    public final View viewKSWVolPage2Mid;
    public final View viewKSWVolSeekBarPage2Hight;
    public final View viewKSWVolSeekBarPage2Low;
    public final View viewKSWVolSeekBarPage2Mid;

    private Kesaiwei1920x720EvoId7FragmentVolSetBinding(RelativeLayout relativeLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3, TextView textView, TextView textView2, TextView textView3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, ScrollView scrollView, View view, View view2, View view3, View view4, View view5, View view6) {
        this.rootView = relativeLayout;
        this.KSWBtnEqClassical = button;
        this.KSWBtnEqCustom = button2;
        this.KSWBtnEqDance = button3;
        this.KSWBtnEqJazz = button4;
        this.KSWBtnEqPop = button5;
        this.KSWBtnEqRock = button6;
        this.KSWVolSeekBarPage2Hight = seekBar;
        this.KSWVolSeekBarPage2Low = seekBar2;
        this.KSWVolSeekBarPage2Mid = seekBar3;
        this.KSWVolValueAlto = textView;
        this.KSWVolValueBass = textView2;
        this.KSWVolValueTreble = textView3;
        this.chkClassical = checkBox;
        this.chkDance = checkBox2;
        this.chkJazz = checkBox3;
        this.chkPop = checkBox4;
        this.chkRock = checkBox5;
        this.chkUser = checkBox6;
        this.mScrollView = scrollView;
        this.viewKSWVolPage2Hight = view;
        this.viewKSWVolPage2Low = view2;
        this.viewKSWVolPage2Mid = view3;
        this.viewKSWVolSeekBarPage2Hight = view4;
        this.viewKSWVolSeekBarPage2Low = view5;
        this.viewKSWVolSeekBarPage2Mid = view6;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentVolSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentVolSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_vol_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentVolSetBinding bind(View view) {
        View view2 = view;
        int i = R.id.KSW_btn_eq_classical;
        Button button = (Button) view2.findViewById(R.id.KSW_btn_eq_classical);
        if (button != null) {
            i = R.id.KSW_btn_eq_custom;
            Button button2 = (Button) view2.findViewById(R.id.KSW_btn_eq_custom);
            if (button2 != null) {
                i = R.id.KSW_btn_eq_dance;
                Button button3 = (Button) view2.findViewById(R.id.KSW_btn_eq_dance);
                if (button3 != null) {
                    i = R.id.KSW_btn_eq_jazz;
                    Button button4 = (Button) view2.findViewById(R.id.KSW_btn_eq_jazz);
                    if (button4 != null) {
                        i = R.id.KSW_btn_eq_pop;
                        Button button5 = (Button) view2.findViewById(R.id.KSW_btn_eq_pop);
                        if (button5 != null) {
                            i = R.id.KSW_btn_eq_rock;
                            Button button6 = (Button) view2.findViewById(R.id.KSW_btn_eq_rock);
                            if (button6 != null) {
                                i = R.id.KSW_VolSeekBar_page2_hight;
                                SeekBar seekBar = (SeekBar) view2.findViewById(R.id.KSW_VolSeekBar_page2_hight);
                                if (seekBar != null) {
                                    i = R.id.KSW_VolSeekBar_page2_low;
                                    SeekBar seekBar2 = (SeekBar) view2.findViewById(R.id.KSW_VolSeekBar_page2_low);
                                    if (seekBar2 != null) {
                                        i = R.id.KSW_VolSeekBar_page2_mid;
                                        SeekBar seekBar3 = (SeekBar) view2.findViewById(R.id.KSW_VolSeekBar_page2_mid);
                                        if (seekBar3 != null) {
                                            i = R.id.KSW_VolValue_Alto;
                                            TextView textView = (TextView) view2.findViewById(R.id.KSW_VolValue_Alto);
                                            if (textView != null) {
                                                i = R.id.KSW_VolValue_Bass;
                                                TextView textView2 = (TextView) view2.findViewById(R.id.KSW_VolValue_Bass);
                                                if (textView2 != null) {
                                                    i = R.id.KSW_VolValue_Treble;
                                                    TextView textView3 = (TextView) view2.findViewById(R.id.KSW_VolValue_Treble);
                                                    if (textView3 != null) {
                                                        i = R.id.chkClassical;
                                                        CheckBox checkBox = (CheckBox) view2.findViewById(R.id.chkClassical);
                                                        if (checkBox != null) {
                                                            i = R.id.chkDance;
                                                            CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.chkDance);
                                                            if (checkBox2 != null) {
                                                                i = R.id.chkJazz;
                                                                CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.chkJazz);
                                                                if (checkBox3 != null) {
                                                                    i = R.id.chkPop;
                                                                    CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.chkPop);
                                                                    if (checkBox4 != null) {
                                                                        i = R.id.chkRock;
                                                                        CheckBox checkBox5 = (CheckBox) view2.findViewById(R.id.chkRock);
                                                                        if (checkBox5 != null) {
                                                                            i = R.id.chkUser;
                                                                            CheckBox checkBox6 = (CheckBox) view2.findViewById(R.id.chkUser);
                                                                            if (checkBox6 != null) {
                                                                                i = R.id.mScrollView;
                                                                                ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mScrollView);
                                                                                if (scrollView != null) {
                                                                                    i = R.id.viewKSW_Vol_page2_hight;
                                                                                    View findViewById = view2.findViewById(R.id.viewKSW_Vol_page2_hight);
                                                                                    if (findViewById != null) {
                                                                                        i = R.id.viewKSW_Vol_page2_low;
                                                                                        View findViewById2 = view2.findViewById(R.id.viewKSW_Vol_page2_low);
                                                                                        if (findViewById2 != null) {
                                                                                            i = R.id.viewKSW_Vol_page2_mid;
                                                                                            View findViewById3 = view2.findViewById(R.id.viewKSW_Vol_page2_mid);
                                                                                            if (findViewById3 != null) {
                                                                                                i = R.id.viewKSW_VolSeekBar_page2_hight;
                                                                                                View findViewById4 = view2.findViewById(R.id.viewKSW_VolSeekBar_page2_hight);
                                                                                                if (findViewById4 != null) {
                                                                                                    i = R.id.viewKSW_VolSeekBar_page2_low;
                                                                                                    View findViewById5 = view2.findViewById(R.id.viewKSW_VolSeekBar_page2_low);
                                                                                                    if (findViewById5 != null) {
                                                                                                        i = R.id.viewKSW_VolSeekBar_page2_mid;
                                                                                                        View findViewById6 = view2.findViewById(R.id.viewKSW_VolSeekBar_page2_mid);
                                                                                                        if (findViewById6 != null) {
                                                                                                            return new Kesaiwei1920x720EvoId7FragmentVolSetBinding((RelativeLayout) view2, button, button2, button3, button4, button5, button6, seekBar, seekBar2, seekBar3, textView, textView2, textView3, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, scrollView, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6);
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
