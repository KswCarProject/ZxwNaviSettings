package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;

public final class LexusActivityMainBinding implements ViewBinding {
    public final RadioButton BtnDataTimer;
    public final RadioButton BtnFatSetting;
    public final RadioButton BtnLanguage;
    public final RadioButton BtnMoreSetting;
    public final RadioButton BtnNavSet;
    public final RadioButton BtnSysInfor;
    public final RadioButton BtnSysSetting;
    public final RadioButton BtnVolumeSet;
    public final ScrollView idScrollView;
    private final ConstraintLayout rootView;
    public final TextView txtModeTitle;
    public final IndexViewPager viewpager;

    private LexusActivityMainBinding(ConstraintLayout constraintLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, ScrollView scrollView, TextView textView, IndexViewPager indexViewPager) {
        this.rootView = constraintLayout;
        this.BtnDataTimer = radioButton;
        this.BtnFatSetting = radioButton2;
        this.BtnLanguage = radioButton3;
        this.BtnMoreSetting = radioButton4;
        this.BtnNavSet = radioButton5;
        this.BtnSysInfor = radioButton6;
        this.BtnSysSetting = radioButton7;
        this.BtnVolumeSet = radioButton8;
        this.idScrollView = scrollView;
        this.txtModeTitle = textView;
        this.viewpager = indexViewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LexusActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LexusActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.lexus_activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LexusActivityMainBinding bind(View view) {
        int i = R.id.BtnDataTimer;
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.BtnDataTimer);
        if (radioButton != null) {
            i = R.id.BtnFatSetting;
            RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.BtnFatSetting);
            if (radioButton2 != null) {
                i = R.id.BtnLanguage;
                RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.BtnLanguage);
                if (radioButton3 != null) {
                    i = R.id.BtnMoreSetting;
                    RadioButton radioButton4 = (RadioButton) view.findViewById(R.id.BtnMoreSetting);
                    if (radioButton4 != null) {
                        i = R.id.BtnNavSet;
                        RadioButton radioButton5 = (RadioButton) view.findViewById(R.id.BtnNavSet);
                        if (radioButton5 != null) {
                            i = R.id.BtnSysInfor;
                            RadioButton radioButton6 = (RadioButton) view.findViewById(R.id.BtnSysInfor);
                            if (radioButton6 != null) {
                                i = R.id.BtnSysSetting;
                                RadioButton radioButton7 = (RadioButton) view.findViewById(R.id.BtnSysSetting);
                                if (radioButton7 != null) {
                                    i = R.id.BtnVolumeSet;
                                    RadioButton radioButton8 = (RadioButton) view.findViewById(R.id.BtnVolumeSet);
                                    if (radioButton8 != null) {
                                        i = R.id.id_scroll_view;
                                        ScrollView scrollView = (ScrollView) view.findViewById(R.id.id_scroll_view);
                                        if (scrollView != null) {
                                            i = R.id.txtModeTitle;
                                            TextView textView = (TextView) view.findViewById(R.id.txtModeTitle);
                                            if (textView != null) {
                                                i = R.id.viewpager;
                                                IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewpager);
                                                if (indexViewPager != null) {
                                                    return new LexusActivityMainBinding((ConstraintLayout) view, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, scrollView, textView, indexViewPager);
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
