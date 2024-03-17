package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720LexusFragmentSysInforBinding implements ViewBinding {
    public final TextView TvAppVer;
    public final TextView TvBTVer;
    public final TextView TvBootVer;
    public final TextView TvMCUVer;
    public final TextView TvNandflash;
    public final TextView TvOSVer;
    public final TextView TvRAM;
    public final Button btnMcuUpgrade;
    public final Button btnSysReset;
    public final RelativeLayout lytSysInfor;
    public final ScrollView mScrollView;
    public final MyScrollbar myScrollbar;
    private final ConstraintLayout rootView;
    public final Guideline systemScrollViewLeGuideline;
    public final Guideline systemScrollViewRiGuideline;
    public final TextView titleAndroid;
    public final TextView titleApp;
    public final TextView titleBT;
    public final TextView titleFlash;
    public final TextView titleFrame;
    public final TextView titleMcu;
    public final TextView titleRam;
    public final ConstraintLayout view0;
    public final ConstraintLayout view1;
    public final ConstraintLayout view2;
    public final ConstraintLayout view3;
    public final ConstraintLayout view4;
    public final ConstraintLayout view5;
    public final RelativeLayout view6;
    public final ConstraintLayout view7;
    public final View viewPager;
    public final Guideline viewPagerLeGuideline;

    private Kesaiwei1920x720LexusFragmentSysInforBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, Button button, Button button2, RelativeLayout relativeLayout, ScrollView scrollView, MyScrollbar myScrollbar2, Guideline guideline, Guideline guideline2, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, RelativeLayout relativeLayout2, ConstraintLayout constraintLayout8, View view, Guideline guideline3) {
        this.rootView = constraintLayout;
        this.TvAppVer = textView;
        this.TvBTVer = textView2;
        this.TvBootVer = textView3;
        this.TvMCUVer = textView4;
        this.TvNandflash = textView5;
        this.TvOSVer = textView6;
        this.TvRAM = textView7;
        this.btnMcuUpgrade = button;
        this.btnSysReset = button2;
        this.lytSysInfor = relativeLayout;
        this.mScrollView = scrollView;
        this.myScrollbar = myScrollbar2;
        this.systemScrollViewLeGuideline = guideline;
        this.systemScrollViewRiGuideline = guideline2;
        this.titleAndroid = textView8;
        this.titleApp = textView9;
        this.titleBT = textView10;
        this.titleFlash = textView11;
        this.titleFrame = textView12;
        this.titleMcu = textView13;
        this.titleRam = textView14;
        this.view0 = constraintLayout2;
        this.view1 = constraintLayout3;
        this.view2 = constraintLayout4;
        this.view3 = constraintLayout5;
        this.view4 = constraintLayout6;
        this.view5 = constraintLayout7;
        this.view6 = relativeLayout2;
        this.view7 = constraintLayout8;
        this.viewPager = view;
        this.viewPagerLeGuideline = guideline3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720LexusFragmentSysInforBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720LexusFragmentSysInforBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_infor, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720LexusFragmentSysInforBinding bind(View view) {
        View view8 = view;
        int i = R.id.TvAppVer;
        TextView textView = (TextView) view8.findViewById(R.id.TvAppVer);
        if (textView != null) {
            i = R.id.TvBTVer;
            TextView textView2 = (TextView) view8.findViewById(R.id.TvBTVer);
            if (textView2 != null) {
                i = R.id.TvBootVer;
                TextView textView3 = (TextView) view8.findViewById(R.id.TvBootVer);
                if (textView3 != null) {
                    i = R.id.TvMCUVer;
                    TextView textView4 = (TextView) view8.findViewById(R.id.TvMCUVer);
                    if (textView4 != null) {
                        i = R.id.TvNandflash;
                        TextView textView5 = (TextView) view8.findViewById(R.id.TvNandflash);
                        if (textView5 != null) {
                            i = R.id.TvOSVer;
                            TextView textView6 = (TextView) view8.findViewById(R.id.TvOSVer);
                            if (textView6 != null) {
                                i = R.id.TvRAM;
                                TextView textView7 = (TextView) view8.findViewById(R.id.TvRAM);
                                if (textView7 != null) {
                                    i = R.id.btn_mcu_upgrade;
                                    Button button = (Button) view8.findViewById(R.id.btn_mcu_upgrade);
                                    if (button != null) {
                                        i = R.id.btnSysReset;
                                        Button button2 = (Button) view8.findViewById(R.id.btnSysReset);
                                        if (button2 != null) {
                                            i = R.id.lytSysInfor;
                                            RelativeLayout relativeLayout = (RelativeLayout) view8.findViewById(R.id.lytSysInfor);
                                            if (relativeLayout != null) {
                                                i = R.id.mScrollView;
                                                ScrollView scrollView = (ScrollView) view8.findViewById(R.id.mScrollView);
                                                if (scrollView != null) {
                                                    i = R.id.myScrollbar;
                                                    MyScrollbar myScrollbar2 = (MyScrollbar) view8.findViewById(R.id.myScrollbar);
                                                    if (myScrollbar2 != null) {
                                                        i = R.id.systemScrollView_le_guideline;
                                                        Guideline guideline = (Guideline) view8.findViewById(R.id.systemScrollView_le_guideline);
                                                        if (guideline != null) {
                                                            i = R.id.systemScrollView_ri_guideline;
                                                            Guideline guideline2 = (Guideline) view8.findViewById(R.id.systemScrollView_ri_guideline);
                                                            if (guideline2 != null) {
                                                                i = R.id.titleAndroid;
                                                                TextView textView8 = (TextView) view8.findViewById(R.id.titleAndroid);
                                                                if (textView8 != null) {
                                                                    i = R.id.titleApp;
                                                                    TextView textView9 = (TextView) view8.findViewById(R.id.titleApp);
                                                                    if (textView9 != null) {
                                                                        i = R.id.titleBT;
                                                                        TextView textView10 = (TextView) view8.findViewById(R.id.titleBT);
                                                                        if (textView10 != null) {
                                                                            i = R.id.titleFlash;
                                                                            TextView textView11 = (TextView) view8.findViewById(R.id.titleFlash);
                                                                            if (textView11 != null) {
                                                                                i = R.id.titleFrame;
                                                                                TextView textView12 = (TextView) view8.findViewById(R.id.titleFrame);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.titleMcu;
                                                                                    TextView textView13 = (TextView) view8.findViewById(R.id.titleMcu);
                                                                                    if (textView13 != null) {
                                                                                        i = R.id.titleRam;
                                                                                        TextView textView14 = (TextView) view8.findViewById(R.id.titleRam);
                                                                                        if (textView14 != null) {
                                                                                            i = R.id.view0;
                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view8.findViewById(R.id.view0);
                                                                                            if (constraintLayout != null) {
                                                                                                i = R.id.view1;
                                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view8.findViewById(R.id.view1);
                                                                                                if (constraintLayout2 != null) {
                                                                                                    i = R.id.view2;
                                                                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view8.findViewById(R.id.view2);
                                                                                                    if (constraintLayout3 != null) {
                                                                                                        i = R.id.view3;
                                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view8.findViewById(R.id.view3);
                                                                                                        if (constraintLayout4 != null) {
                                                                                                            i = R.id.view4;
                                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view8.findViewById(R.id.view4);
                                                                                                            if (constraintLayout5 != null) {
                                                                                                                i = R.id.view5;
                                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) view8.findViewById(R.id.view5);
                                                                                                                if (constraintLayout6 != null) {
                                                                                                                    i = R.id.view6;
                                                                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view8.findViewById(R.id.view6);
                                                                                                                    if (relativeLayout2 != null) {
                                                                                                                        i = R.id.view7;
                                                                                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) view8.findViewById(R.id.view7);
                                                                                                                        if (constraintLayout7 != null) {
                                                                                                                            i = R.id.viewPager;
                                                                                                                            View findViewById = view8.findViewById(R.id.viewPager);
                                                                                                                            if (findViewById != null) {
                                                                                                                                i = R.id.viewPager_le_guideline;
                                                                                                                                Guideline guideline3 = (Guideline) view8.findViewById(R.id.viewPager_le_guideline);
                                                                                                                                if (guideline3 != null) {
                                                                                                                                    return new Kesaiwei1920x720LexusFragmentSysInforBinding((ConstraintLayout) view8, textView, textView2, textView3, textView4, textView5, textView6, textView7, button, button2, relativeLayout, scrollView, myScrollbar2, guideline, guideline2, textView8, textView9, textView10, textView11, textView12, textView13, textView14, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, relativeLayout2, constraintLayout7, findViewById, guideline3);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
