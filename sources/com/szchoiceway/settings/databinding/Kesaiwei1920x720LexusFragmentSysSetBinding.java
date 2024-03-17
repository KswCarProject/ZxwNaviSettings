package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720LexusFragmentSysSetBinding implements ViewBinding {
    public final RadioButton btnAuxSwitchSet;
    public final RadioButton btnBackCarSet;
    public final RadioButton btnBtSet;
    public final RadioButton btnDisplaySet;
    public final RadioButton btnDvrSet;
    public final RadioButton btnMusicAppSet;
    public final RadioButton btnOtherSet;
    public final RadioButton btnUnitSet;
    public final RadioButton btnVideoAppSet;
    public final MyScrollbar myScrollbar;
    public final RadioGroup radioGroup;
    private final ConstraintLayout rootView;
    public final ConstraintLayout scrollLayout;
    public final ScrollView systemScrollView;
    public final Guideline systemScrollViewLeGuideline;
    public final Guideline systemScrollViewRiGuideline;
    public final IndexViewPager viewPager;
    public final Guideline viewPagerLeGuideline;

    private Kesaiwei1920x720LexusFragmentSysSetBinding(ConstraintLayout constraintLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, MyScrollbar myScrollbar2, RadioGroup radioGroup2, ConstraintLayout constraintLayout2, ScrollView scrollView, Guideline guideline, Guideline guideline2, IndexViewPager indexViewPager, Guideline guideline3) {
        this.rootView = constraintLayout;
        this.btnAuxSwitchSet = radioButton;
        this.btnBackCarSet = radioButton2;
        this.btnBtSet = radioButton3;
        this.btnDisplaySet = radioButton4;
        this.btnDvrSet = radioButton5;
        this.btnMusicAppSet = radioButton6;
        this.btnOtherSet = radioButton7;
        this.btnUnitSet = radioButton8;
        this.btnVideoAppSet = radioButton9;
        this.myScrollbar = myScrollbar2;
        this.radioGroup = radioGroup2;
        this.scrollLayout = constraintLayout2;
        this.systemScrollView = scrollView;
        this.systemScrollViewLeGuideline = guideline;
        this.systemScrollViewRiGuideline = guideline2;
        this.viewPager = indexViewPager;
        this.viewPagerLeGuideline = guideline3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720LexusFragmentSysSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetBinding bind(View view) {
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
                                            i = R.id.myScrollbar;
                                            MyScrollbar myScrollbar2 = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
                                            if (myScrollbar2 != null) {
                                                i = R.id.radioGroup;
                                                RadioGroup radioGroup2 = (RadioGroup) view2.findViewById(R.id.radioGroup);
                                                if (radioGroup2 != null) {
                                                    i = R.id.scrollLayout;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.scrollLayout);
                                                    if (constraintLayout != null) {
                                                        i = R.id.systemScrollView;
                                                        ScrollView scrollView = (ScrollView) view2.findViewById(R.id.systemScrollView);
                                                        if (scrollView != null) {
                                                            i = R.id.systemScrollView_le_guideline;
                                                            Guideline guideline = (Guideline) view2.findViewById(R.id.systemScrollView_le_guideline);
                                                            if (guideline != null) {
                                                                i = R.id.systemScrollView_ri_guideline;
                                                                Guideline guideline2 = (Guideline) view2.findViewById(R.id.systemScrollView_ri_guideline);
                                                                if (guideline2 != null) {
                                                                    i = R.id.viewPager;
                                                                    IndexViewPager indexViewPager = (IndexViewPager) view2.findViewById(R.id.viewPager);
                                                                    if (indexViewPager != null) {
                                                                        i = R.id.viewPager_le_guideline;
                                                                        Guideline guideline3 = (Guideline) view2.findViewById(R.id.viewPager_le_guideline);
                                                                        if (guideline3 != null) {
                                                                            return new Kesaiwei1920x720LexusFragmentSysSetBinding((ConstraintLayout) view2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9, myScrollbar2, radioGroup2, constraintLayout, scrollView, guideline, guideline2, indexViewPager, guideline3);
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
