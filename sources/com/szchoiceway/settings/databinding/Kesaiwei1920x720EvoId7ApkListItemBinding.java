package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7ApkListItemBinding implements ViewBinding {
    public final RelativeLayout LytLstItemRoot;
    public final TextView TvApkInfor;
    public final ImageView VwApkIcon;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720EvoId7ApkListItemBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, ImageView imageView) {
        this.rootView = relativeLayout;
        this.LytLstItemRoot = relativeLayout2;
        this.TvApkInfor = textView;
        this.VwApkIcon = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7ApkListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7ApkListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_apk_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7ApkListItemBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.TvApkInfor;
        TextView textView = (TextView) view.findViewById(R.id.TvApkInfor);
        if (textView != null) {
            i = R.id.VwApkIcon;
            ImageView imageView = (ImageView) view.findViewById(R.id.VwApkIcon);
            if (imageView != null) {
                return new Kesaiwei1920x720EvoId7ApkListItemBinding(relativeLayout, relativeLayout, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
