package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentNavSetBinding implements ViewBinding {
    public final ImageButton BtnResetNo;
    public final ImageView BtnResetView;
    public final ImageButton BtnResetYes;
    public final ImageButton BtnRunNav;
    public final ListView LvApkLst;
    public final RelativeLayout LytMsgYesNo;
    public final TextView TextResetTip;
    public final TextView TvApkInfor;
    public final ImageView VwApkIcon;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720EvoId7FragmentNavSetBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageView imageView, ImageButton imageButton2, ImageButton imageButton3, ListView listView, RelativeLayout relativeLayout2, TextView textView, TextView textView2, ImageView imageView2) {
        this.rootView = relativeLayout;
        this.BtnResetNo = imageButton;
        this.BtnResetView = imageView;
        this.BtnResetYes = imageButton2;
        this.BtnRunNav = imageButton3;
        this.LvApkLst = listView;
        this.LytMsgYesNo = relativeLayout2;
        this.TextResetTip = textView;
        this.TvApkInfor = textView2;
        this.VwApkIcon = imageView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentNavSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentNavSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_nav_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentNavSetBinding bind(View view) {
        int i = R.id.BtnResetNo;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.BtnResetNo);
        if (imageButton != null) {
            i = R.id.BtnResetView;
            ImageView imageView = (ImageView) view.findViewById(R.id.BtnResetView);
            if (imageView != null) {
                i = R.id.BtnResetYes;
                ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.BtnResetYes);
                if (imageButton2 != null) {
                    i = R.id.BtnRunNav;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.BtnRunNav);
                    if (imageButton3 != null) {
                        i = R.id.LvApkLst;
                        ListView listView = (ListView) view.findViewById(R.id.LvApkLst);
                        if (listView != null) {
                            i = R.id.LytMsgYesNo;
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.LytMsgYesNo);
                            if (relativeLayout != null) {
                                i = R.id.TextResetTip;
                                TextView textView = (TextView) view.findViewById(R.id.TextResetTip);
                                if (textView != null) {
                                    i = R.id.TvApkInfor;
                                    TextView textView2 = (TextView) view.findViewById(R.id.TvApkInfor);
                                    if (textView2 != null) {
                                        i = R.id.VwApkIcon;
                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.VwApkIcon);
                                        if (imageView2 != null) {
                                            return new Kesaiwei1920x720EvoId7FragmentNavSetBinding((RelativeLayout) view, imageButton, imageView, imageButton2, imageButton3, listView, relativeLayout, textView, textView2, imageView2);
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
