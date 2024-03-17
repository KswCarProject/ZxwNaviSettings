package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class PempId7FragmentNavSetBinding implements ViewBinding {
    public final ImageButton BtnResetNo;
    public final ImageView BtnResetView;
    public final ImageButton BtnResetYes;
    public final ImageButton BtnRunNav;
    public final RelativeLayout LytMsgYesNo;
    public final TextView TextResetTip;
    public final TextView TvApkInfor;
    public final ImageView VwApkIcon;
    public final RecyclerView appList;
    private final RelativeLayout rootView;

    private PempId7FragmentNavSetBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageView imageView, ImageButton imageButton2, ImageButton imageButton3, RelativeLayout relativeLayout2, TextView textView, TextView textView2, ImageView imageView2, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.BtnResetNo = imageButton;
        this.BtnResetView = imageView;
        this.BtnResetYes = imageButton2;
        this.BtnRunNav = imageButton3;
        this.LytMsgYesNo = relativeLayout2;
        this.TextResetTip = textView;
        this.TvApkInfor = textView2;
        this.VwApkIcon = imageView2;
        this.appList = recyclerView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PempId7FragmentNavSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PempId7FragmentNavSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pemp_id7_fragment_nav_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PempId7FragmentNavSetBinding bind(View view) {
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
                                        i = R.id.appList;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
                                        if (recyclerView != null) {
                                            return new PempId7FragmentNavSetBinding((RelativeLayout) view, imageButton, imageView, imageButton2, imageButton3, relativeLayout, textView, textView2, imageView2, recyclerView);
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
