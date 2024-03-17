package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720EvoId8FragmentSysInforBinding implements ViewBinding {
    public final TextView TvAppVer;
    public final TextView TvBTVer;
    public final TextView TvBootVer;
    public final TextView TvMCUVer;
    public final TextView TvNandflash;
    public final TextView TvOSVer;
    public final TextView TvRAM;
    public final TextView TvUUID;
    public final Button btnMcuUpgrade;
    public final ImageButton btnReturn;
    public final Button btnSysReset;
    public final LinearLayout lytSysInfor;
    public final ScrollView mScrollView;
    public final MyScrollbar myScrollbar;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720EvoId8FragmentSysInforBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, Button button, ImageButton imageButton, Button button2, LinearLayout linearLayout, ScrollView scrollView, MyScrollbar myScrollbar2) {
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
        this.btnReturn = imageButton;
        this.btnSysReset = button2;
        this.lytSysInfor = linearLayout;
        this.mScrollView = scrollView;
        this.myScrollbar = myScrollbar2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentSysInforBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysInforBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_infor, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysInforBinding bind(View view) {
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
                                    i = R.id.TvUUID;
                                    TextView textView8 = (TextView) view2.findViewById(R.id.TvUUID);
                                    if (textView8 != null) {
                                        i = R.id.btn_mcu_upgrade;
                                        Button button = (Button) view2.findViewById(R.id.btn_mcu_upgrade);
                                        if (button != null) {
                                            i = R.id.btnReturn;
                                            ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btnReturn);
                                            if (imageButton != null) {
                                                i = R.id.btnSysReset;
                                                Button button2 = (Button) view2.findViewById(R.id.btnSysReset);
                                                if (button2 != null) {
                                                    i = R.id.lytSysInfor;
                                                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.lytSysInfor);
                                                    if (linearLayout != null) {
                                                        i = R.id.mScrollView;
                                                        ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mScrollView);
                                                        if (scrollView != null) {
                                                            i = R.id.myScrollbar;
                                                            MyScrollbar myScrollbar2 = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
                                                            if (myScrollbar2 != null) {
                                                                return new Kesaiwei1920x720EvoId8FragmentSysInforBinding((RelativeLayout) view2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, button, imageButton, button2, linearLayout, scrollView, myScrollbar2);
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
