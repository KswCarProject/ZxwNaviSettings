package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentSysInforBinding implements ViewBinding {
    public final TextView TvAppVer;
    public final TextView TvBTVer;
    public final TextView TvBootVer;
    public final TextView TvMCUVer;
    public final TextView TvNandflash;
    public final TextView TvOSVer;
    public final TextView TvRAM;
    public final TextView TvUUID;
    public final Button btnMcuUpgrade;
    public final Button btnSysReset;
    public final RelativeLayout lytSysInfor;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720EvoId7FragmentSysInforBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, Button button, Button button2, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.TvAppVer = textView;
        this.TvBTVer = textView2;
        this.TvBootVer = textView3;
        this.TvMCUVer = textView4;
        this.TvNandflash = textView5;
        this.TvOSVer = textView6;
        this.TvRAM = textView7;
        this.TvUUID = textView8;
        this.btnMcuUpgrade = button;
        this.btnSysReset = button2;
        this.lytSysInfor = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentSysInforBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysInforBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_infor, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysInforBinding bind(View view) {
        int i = R.id.TvAppVer;
        TextView textView = (TextView) view.findViewById(R.id.TvAppVer);
        if (textView != null) {
            i = R.id.TvBTVer;
            TextView textView2 = (TextView) view.findViewById(R.id.TvBTVer);
            if (textView2 != null) {
                i = R.id.TvBootVer;
                TextView textView3 = (TextView) view.findViewById(R.id.TvBootVer);
                if (textView3 != null) {
                    i = R.id.TvMCUVer;
                    TextView textView4 = (TextView) view.findViewById(R.id.TvMCUVer);
                    if (textView4 != null) {
                        i = R.id.TvNandflash;
                        TextView textView5 = (TextView) view.findViewById(R.id.TvNandflash);
                        if (textView5 != null) {
                            i = R.id.TvOSVer;
                            TextView textView6 = (TextView) view.findViewById(R.id.TvOSVer);
                            if (textView6 != null) {
                                i = R.id.TvRAM;
                                TextView textView7 = (TextView) view.findViewById(R.id.TvRAM);
                                if (textView7 != null) {
                                    i = R.id.TvUUID;
                                    TextView textView8 = (TextView) view.findViewById(R.id.TvUUID);
                                    if (textView8 != null) {
                                        i = R.id.btn_mcu_upgrade;
                                        Button button = (Button) view.findViewById(R.id.btn_mcu_upgrade);
                                        if (button != null) {
                                            i = R.id.btnSysReset;
                                            Button button2 = (Button) view.findViewById(R.id.btnSysReset);
                                            if (button2 != null) {
                                                i = R.id.lytSysInfor;
                                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.lytSysInfor);
                                                if (relativeLayout != null) {
                                                    return new Kesaiwei1920x720EvoId7FragmentSysInforBinding((RelativeLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, button, button2, relativeLayout);
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
