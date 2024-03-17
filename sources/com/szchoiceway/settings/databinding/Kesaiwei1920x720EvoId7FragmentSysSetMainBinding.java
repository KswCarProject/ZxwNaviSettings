package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentSysSetMainBinding implements ViewBinding {
    public final RadioButton btnAuxSwitchSet;
    public final RadioButton btnBackCarSet;
    public final RadioButton btnBtSet;
    public final RadioButton btnDisplaySet;
    public final RadioButton btnDvrSet;
    public final RadioButton btnMusicAppSet;
    public final RadioButton btnOtherSet;
    public final RadioButton btnUnitSet;
    public final RadioButton btnVideoAppSet;
    public final RadioGroup radioGroup;
    private final RelativeLayout rootView;
    public final ScrollView systemScrollView;
    public final IndexViewPager viewPager;

    private Kesaiwei1920x720EvoId7FragmentSysSetMainBinding(RelativeLayout relativeLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RadioGroup radioGroup2, ScrollView scrollView, IndexViewPager indexViewPager) {
        this.rootView = relativeLayout;
        this.btnAuxSwitchSet = radioButton;
        this.btnBackCarSet = radioButton2;
        this.btnBtSet = radioButton3;
        this.btnDisplaySet = radioButton4;
        this.btnDvrSet = radioButton5;
        this.btnMusicAppSet = radioButton6;
        this.btnOtherSet = radioButton7;
        this.btnUnitSet = radioButton8;
        this.btnVideoAppSet = radioButton9;
        this.radioGroup = radioGroup2;
        this.systemScrollView = scrollView;
        this.viewPager = indexViewPager;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetMainBinding bind(View view) {
        View view2 = view;
        int i = R.id.btnAuxSwitchSet;
        RadioButton radioButton = (RadioButton) view2.findViewById(R.id.btnAuxSwitchSet);
        if (radioButton != null) {
            i = R.id.btnBackCarSet;
            RadioButton radioButton2 = (RadioButton) view2.findViewById(R.id.btnBackCarSet);
            if (radioButton2 != null) {
                i = R.id.btnBtSet;
                RadioButton radioButton3 = (RadioButton) view2.findViewById(R.id.btnBtSet);
                if (radioButton3 != null) {
                    i = R.id.btnDisplaySet;
                    RadioButton radioButton4 = (RadioButton) view2.findViewById(R.id.btnDisplaySet);
                    if (radioButton4 != null) {
                        i = R.id.btnDvrSet;
                        RadioButton radioButton5 = (RadioButton) view2.findViewById(R.id.btnDvrSet);
                        if (radioButton5 != null) {
                            i = R.id.btnMusicAppSet;
                            RadioButton radioButton6 = (RadioButton) view2.findViewById(R.id.btnMusicAppSet);
                            if (radioButton6 != null) {
                                i = R.id.btnOtherSet;
                                RadioButton radioButton7 = (RadioButton) view2.findViewById(R.id.btnOtherSet);
                                if (radioButton7 != null) {
                                    i = R.id.btnUnitSet;
                                    RadioButton radioButton8 = (RadioButton) view2.findViewById(R.id.btnUnitSet);
                                    if (radioButton8 != null) {
                                        i = R.id.btnVideoAppSet;
                                        RadioButton radioButton9 = (RadioButton) view2.findViewById(R.id.btnVideoAppSet);
                                        if (radioButton9 != null) {
                                            i = R.id.radioGroup;
                                            RadioGroup radioGroup2 = (RadioGroup) view2.findViewById(R.id.radioGroup);
                                            if (radioGroup2 != null) {
                                                i = R.id.systemScrollView;
                                                ScrollView scrollView = (ScrollView) view2.findViewById(R.id.systemScrollView);
                                                if (scrollView != null) {
                                                    i = R.id.viewPager;
                                                    IndexViewPager indexViewPager = (IndexViewPager) view2.findViewById(R.id.viewPager);
                                                    if (indexViewPager != null) {
                                                        return new Kesaiwei1920x720EvoId7FragmentSysSetMainBinding((RelativeLayout) view2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9, radioGroup2, scrollView, indexViewPager);
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
