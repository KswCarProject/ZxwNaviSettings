package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentVolumeSetBinding implements ViewBinding {
    public final SeekBar KSWVolSeekBar00;
    public final SeekBar KSWVolSeekBar01;
    public final SeekBar KSWVolSeekBar03;
    public final SeekBar KSWVolSeekBar04;
    public final TextView KSWVolVal00;
    public final TextView KSWVolVal01;
    public final TextView KSWVolVal03;
    public final TextView KSWVolVal04;
    private final RelativeLayout rootView;
    public final View viewKSWVolVal00;
    public final View viewKSWVolVal01;
    public final View viewKSWVolVal03;
    public final View viewKSWVolVal04;

    private Kesaiwei1920x720EvoId7FragmentVolumeSetBinding(RelativeLayout relativeLayout, SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3, SeekBar seekBar4, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, View view2, View view3, View view4) {
        this.rootView = relativeLayout;
        this.KSWVolSeekBar00 = seekBar;
        this.KSWVolSeekBar01 = seekBar2;
        this.KSWVolSeekBar03 = seekBar3;
        this.KSWVolSeekBar04 = seekBar4;
        this.KSWVolVal00 = textView;
        this.KSWVolVal01 = textView2;
        this.KSWVolVal03 = textView3;
        this.KSWVolVal04 = textView4;
        this.viewKSWVolVal00 = view;
        this.viewKSWVolVal01 = view2;
        this.viewKSWVolVal03 = view3;
        this.viewKSWVolVal04 = view4;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentVolumeSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentVolumeSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_volume_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentVolumeSetBinding bind(View view) {
        View view2 = view;
        int i = R.id.KSW_VolSeekBar_00;
        SeekBar seekBar = (SeekBar) view2.findViewById(R.id.KSW_VolSeekBar_00);
        if (seekBar != null) {
            i = R.id.KSW_VolSeekBar_01;
            SeekBar seekBar2 = (SeekBar) view2.findViewById(R.id.KSW_VolSeekBar_01);
            if (seekBar2 != null) {
                i = R.id.KSW_VolSeekBar_03;
                SeekBar seekBar3 = (SeekBar) view2.findViewById(R.id.KSW_VolSeekBar_03);
                if (seekBar3 != null) {
                    i = R.id.KSW_VolSeekBar_04;
                    SeekBar seekBar4 = (SeekBar) view2.findViewById(R.id.KSW_VolSeekBar_04);
                    if (seekBar4 != null) {
                        i = R.id.KSW_Vol_val_00;
                        TextView textView = (TextView) view2.findViewById(R.id.KSW_Vol_val_00);
                        if (textView != null) {
                            i = R.id.KSW_Vol_val_01;
                            TextView textView2 = (TextView) view2.findViewById(R.id.KSW_Vol_val_01);
                            if (textView2 != null) {
                                i = R.id.KSW_Vol_val_03;
                                TextView textView3 = (TextView) view2.findViewById(R.id.KSW_Vol_val_03);
                                if (textView3 != null) {
                                    i = R.id.KSW_Vol_val_04;
                                    TextView textView4 = (TextView) view2.findViewById(R.id.KSW_Vol_val_04);
                                    if (textView4 != null) {
                                        i = R.id.viewKSW_Vol_val_00;
                                        View findViewById = view2.findViewById(R.id.viewKSW_Vol_val_00);
                                        if (findViewById != null) {
                                            i = R.id.viewKSW_Vol_val_01;
                                            View findViewById2 = view2.findViewById(R.id.viewKSW_Vol_val_01);
                                            if (findViewById2 != null) {
                                                i = R.id.viewKSW_Vol_val_03;
                                                View findViewById3 = view2.findViewById(R.id.viewKSW_Vol_val_03);
                                                if (findViewById3 != null) {
                                                    i = R.id.viewKSW_Vol_val_04;
                                                    View findViewById4 = view2.findViewById(R.id.viewKSW_Vol_val_04);
                                                    if (findViewById4 != null) {
                                                        return new Kesaiwei1920x720EvoId7FragmentVolumeSetBinding((RelativeLayout) view2, seekBar, seekBar2, seekBar3, seekBar4, textView, textView2, textView3, textView4, findViewById, findViewById2, findViewById3, findViewById4);
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
