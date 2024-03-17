package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class SmallAudiFragmentSysInfoBinding implements ViewBinding {
    public final TextView TvAppVer;
    public final TextView TvBTVer;
    public final TextView TvBootVer;
    public final TextView TvMCUVer;
    public final TextView TvNandflash;
    public final TextView TvOSVer;
    public final TextView TvRAM;
    public final Button btnMcuUpgrade;
    public final Button btnSysReset;
    public final LinearLayout lytSysInfor;
    public final ScrollView mScrollView;
    private final ConstraintLayout rootView;
    public final TextView titleAndroidVer;
    public final TextView titleAppVer;
    public final TextView titleBootVer;
    public final TextView titleBtVer;
    public final TextView titleFlash;
    public final TextView titleMCUVer;
    public final TextView titleRam;

    private SmallAudiFragmentSysInfoBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, Button button, Button button2, LinearLayout linearLayout, ScrollView scrollView, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
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
        this.lytSysInfor = linearLayout;
        this.mScrollView = scrollView;
        this.titleAndroidVer = textView8;
        this.titleAppVer = textView9;
        this.titleBootVer = textView10;
        this.titleBtVer = textView11;
        this.titleFlash = textView12;
        this.titleMCUVer = textView13;
        this.titleRam = textView14;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SmallAudiFragmentSysInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallAudiFragmentSysInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_audi_fragment_sys_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallAudiFragmentSysInfoBinding bind(View view) {
        View view2 = view;
        int i = R.id.TvAppVer;
        TextView textView = (TextView) view2.findViewById(R.id.TvAppVer);
        if (textView != null) {
            i = R.id.TvBTVer;
            TextView textView2 = (TextView) view2.findViewById(R.id.TvBTVer);
            if (textView2 != null) {
                i = R.id.TvBootVer;
                TextView textView3 = (TextView) view2.findViewById(R.id.TvBootVer);
                if (textView3 != null) {
                    i = R.id.TvMCUVer;
                    TextView textView4 = (TextView) view2.findViewById(R.id.TvMCUVer);
                    if (textView4 != null) {
                        i = R.id.TvNandflash;
                        TextView textView5 = (TextView) view2.findViewById(R.id.TvNandflash);
                        if (textView5 != null) {
                            i = R.id.TvOSVer;
                            TextView textView6 = (TextView) view2.findViewById(R.id.TvOSVer);
                            if (textView6 != null) {
                                i = R.id.TvRAM;
                                TextView textView7 = (TextView) view2.findViewById(R.id.TvRAM);
                                if (textView7 != null) {
                                    i = R.id.btn_mcu_upgrade;
                                    Button button = (Button) view2.findViewById(R.id.btn_mcu_upgrade);
                                    if (button != null) {
                                        i = R.id.btnSysReset;
                                        Button button2 = (Button) view2.findViewById(R.id.btnSysReset);
                                        if (button2 != null) {
                                            i = R.id.lytSysInfor;
                                            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.lytSysInfor);
                                            if (linearLayout != null) {
                                                i = R.id.mScrollView;
                                                ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mScrollView);
                                                if (scrollView != null) {
                                                    i = R.id.titleAndroidVer;
                                                    TextView textView8 = (TextView) view2.findViewById(R.id.titleAndroidVer);
                                                    if (textView8 != null) {
                                                        i = R.id.titleAppVer;
                                                        TextView textView9 = (TextView) view2.findViewById(R.id.titleAppVer);
                                                        if (textView9 != null) {
                                                            i = R.id.titleBootVer;
                                                            TextView textView10 = (TextView) view2.findViewById(R.id.titleBootVer);
                                                            if (textView10 != null) {
                                                                i = R.id.titleBtVer;
                                                                TextView textView11 = (TextView) view2.findViewById(R.id.titleBtVer);
                                                                if (textView11 != null) {
                                                                    i = R.id.titleFlash;
                                                                    TextView textView12 = (TextView) view2.findViewById(R.id.titleFlash);
                                                                    if (textView12 != null) {
                                                                        i = R.id.titleMCUVer;
                                                                        TextView textView13 = (TextView) view2.findViewById(R.id.titleMCUVer);
                                                                        if (textView13 != null) {
                                                                            i = R.id.titleRam;
                                                                            TextView textView14 = (TextView) view2.findViewById(R.id.titleRam);
                                                                            if (textView14 != null) {
                                                                                return new SmallAudiFragmentSysInfoBinding((ConstraintLayout) view2, textView, textView2, textView3, textView4, textView5, textView6, textView7, button, button2, linearLayout, scrollView, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
