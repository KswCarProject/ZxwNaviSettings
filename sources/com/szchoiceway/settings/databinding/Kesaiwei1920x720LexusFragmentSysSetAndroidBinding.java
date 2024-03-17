package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720LexusFragmentSysSetAndroidBinding implements ViewBinding {
    public final TextView androidSystemSettingsTv;
    private final ConstraintLayout rootView;
    public final Guideline systemScrollViewLeGuideline;
    public final Guideline systemScrollViewRiGuideline;
    public final View viewPager;
    public final Guideline viewPagerLeGuideline;

    private Kesaiwei1920x720LexusFragmentSysSetAndroidBinding(ConstraintLayout constraintLayout, TextView textView, Guideline guideline, Guideline guideline2, View view, Guideline guideline3) {
        this.rootView = constraintLayout;
        this.androidSystemSettingsTv = textView;
        this.systemScrollViewLeGuideline = guideline;
        this.systemScrollViewRiGuideline = guideline2;
        this.viewPager = view;
        this.viewPagerLeGuideline = guideline3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720LexusFragmentSysSetAndroidBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetAndroidBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_android, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetAndroidBinding bind(View view) {
        int i = R.id.android_system_settings_tv;
        TextView textView = (TextView) view.findViewById(R.id.android_system_settings_tv);
        if (textView != null) {
            i = R.id.systemScrollView_le_guideline;
            Guideline guideline = (Guideline) view.findViewById(R.id.systemScrollView_le_guideline);
            if (guideline != null) {
                i = R.id.systemScrollView_ri_guideline;
                Guideline guideline2 = (Guideline) view.findViewById(R.id.systemScrollView_ri_guideline);
                if (guideline2 != null) {
                    i = R.id.viewPager;
                    View findViewById = view.findViewById(R.id.viewPager);
                    if (findViewById != null) {
                        i = R.id.viewPager_le_guideline;
                        Guideline guideline3 = (Guideline) view.findViewById(R.id.viewPager_le_guideline);
                        if (guideline3 != null) {
                            return new Kesaiwei1920x720LexusFragmentSysSetAndroidBinding((ConstraintLayout) view, textView, guideline, guideline2, findViewById, guideline3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
