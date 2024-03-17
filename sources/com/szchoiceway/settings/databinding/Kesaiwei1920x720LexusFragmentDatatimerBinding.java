package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720LexusFragmentDatatimerBinding implements ViewBinding {
    public final ImageButton btn12Hour;
    public final ImageButton btn24Hour;
    public final ImageButton btnAutoSync;
    public final ImageButton btnOriginalTime;
    public final RadioButton btnSyc;
    public final RadioButton btnSys;
    public final RelativeLayout content0;
    public final RelativeLayout content1;
    public final RelativeLayout content2;
    public final RelativeLayout content3;
    public final CheckBox kesaiwei12Hour;
    public final CheckBox kesaiwei24Hour;
    public final CheckBox kesaiweiAutoSync;
    public final CheckBox kesaiweiOriginalTime;
    public final ScrollView mScrollView;
    private final ConstraintLayout rootView;
    public final RelativeLayout scrollLayout;
    public final Guideline systemScrollViewLeGuideline;
    public final Guideline systemScrollViewRiGuideline;
    public final RelativeLayout title0;
    public final RelativeLayout title1;
    public final View viewPager;
    public final Guideline viewPagerLeGuideline;
    public final RelativeLayout viewSyc;
    public final RelativeLayout viewSys;

    private Kesaiwei1920x720LexusFragmentDatatimerBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, RadioButton radioButton, RadioButton radioButton2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, ScrollView scrollView, RelativeLayout relativeLayout5, Guideline guideline, Guideline guideline2, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, View view, Guideline guideline3, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9) {
        this.rootView = constraintLayout;
        this.btn12Hour = imageButton;
        this.btn24Hour = imageButton2;
        this.btnAutoSync = imageButton3;
        this.btnOriginalTime = imageButton4;
        this.btnSyc = radioButton;
        this.btnSys = radioButton2;
        this.content0 = relativeLayout;
        this.content1 = relativeLayout2;
        this.content2 = relativeLayout3;
        this.content3 = relativeLayout4;
        this.kesaiwei12Hour = checkBox;
        this.kesaiwei24Hour = checkBox2;
        this.kesaiweiAutoSync = checkBox3;
        this.kesaiweiOriginalTime = checkBox4;
        this.mScrollView = scrollView;
        this.scrollLayout = relativeLayout5;
        this.systemScrollViewLeGuideline = guideline;
        this.systemScrollViewRiGuideline = guideline2;
        this.title0 = relativeLayout6;
        this.title1 = relativeLayout7;
        this.viewPager = view;
        this.viewPagerLeGuideline = guideline3;
        this.viewSyc = relativeLayout8;
        this.viewSys = relativeLayout9;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720LexusFragmentDatatimerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720LexusFragmentDatatimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_datatimer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720LexusFragmentDatatimerBinding bind(View view) {
        View view2 = view;
        int i = R.id.btn12Hour;
        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btn12Hour);
        if (imageButton != null) {
            i = R.id.btn24Hour;
            ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btn24Hour);
            if (imageButton2 != null) {
                i = R.id.btnAutoSync;
                ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnAutoSync);
                if (imageButton3 != null) {
                    i = R.id.btnOriginalTime;
                    ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.btnOriginalTime);
                    if (imageButton4 != null) {
                        i = R.id.btnSyc;
                        RadioButton radioButton = (RadioButton) view2.findViewById(R.id.btnSyc);
                        if (radioButton != null) {
                            i = R.id.btnSys;
                            RadioButton radioButton2 = (RadioButton) view2.findViewById(R.id.btnSys);
                            if (radioButton2 != null) {
                                i = R.id.content0;
                                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.content0);
                                if (relativeLayout != null) {
                                    i = R.id.content1;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.content1);
                                    if (relativeLayout2 != null) {
                                        i = R.id.content2;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.content2);
                                        if (relativeLayout3 != null) {
                                            i = R.id.content3;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) view2.findViewById(R.id.content3);
                                            if (relativeLayout4 != null) {
                                                i = R.id.kesaiwei_12_hour;
                                                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.kesaiwei_12_hour);
                                                if (checkBox != null) {
                                                    i = R.id.kesaiwei_24_hour;
                                                    CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.kesaiwei_24_hour);
                                                    if (checkBox2 != null) {
                                                        i = R.id.kesaiwei_Auto_Sync;
                                                        CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.kesaiwei_Auto_Sync);
                                                        if (checkBox3 != null) {
                                                            i = R.id.kesaiwei_Original_Time;
                                                            CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.kesaiwei_Original_Time);
                                                            if (checkBox4 != null) {
                                                                i = R.id.mScrollView;
                                                                ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mScrollView);
                                                                if (scrollView != null) {
                                                                    i = R.id.scrollLayout;
                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) view2.findViewById(R.id.scrollLayout);
                                                                    if (relativeLayout5 != null) {
                                                                        i = R.id.systemScrollView_le_guideline;
                                                                        Guideline guideline = (Guideline) view2.findViewById(R.id.systemScrollView_le_guideline);
                                                                        if (guideline != null) {
                                                                            i = R.id.systemScrollView_ri_guideline;
                                                                            Guideline guideline2 = (Guideline) view2.findViewById(R.id.systemScrollView_ri_guideline);
                                                                            if (guideline2 != null) {
                                                                                i = R.id.title0;
                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) view2.findViewById(R.id.title0);
                                                                                if (relativeLayout6 != null) {
                                                                                    i = R.id.title1;
                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) view2.findViewById(R.id.title1);
                                                                                    if (relativeLayout7 != null) {
                                                                                        i = R.id.viewPager;
                                                                                        View findViewById = view2.findViewById(R.id.viewPager);
                                                                                        if (findViewById != null) {
                                                                                            i = R.id.viewPager_le_guideline;
                                                                                            Guideline guideline3 = (Guideline) view2.findViewById(R.id.viewPager_le_guideline);
                                                                                            if (guideline3 != null) {
                                                                                                i = R.id.viewSyc;
                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) view2.findViewById(R.id.viewSyc);
                                                                                                if (relativeLayout8 != null) {
                                                                                                    i = R.id.viewSys;
                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) view2.findViewById(R.id.viewSys);
                                                                                                    if (relativeLayout9 != null) {
                                                                                                        return new Kesaiwei1920x720LexusFragmentDatatimerBinding((ConstraintLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, radioButton, radioButton2, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, checkBox, checkBox2, checkBox3, checkBox4, scrollView, relativeLayout5, guideline, guideline2, relativeLayout6, relativeLayout7, findViewById, guideline3, relativeLayout8, relativeLayout9);
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
