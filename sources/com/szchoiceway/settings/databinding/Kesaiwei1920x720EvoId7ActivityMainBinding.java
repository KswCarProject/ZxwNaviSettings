package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7ActivityMainBinding implements ViewBinding {
    public final ImageView btnReturn;
    public final ScrollView idScrollView;
    private final RelativeLayout rootView;
    public final TextView txtModeTitle;
    public final IndexViewPager viewpager;

    private Kesaiwei1920x720EvoId7ActivityMainBinding(RelativeLayout relativeLayout, ImageView imageView, ScrollView scrollView, TextView textView, IndexViewPager indexViewPager) {
        this.rootView = relativeLayout;
        this.btnReturn = imageView;
        this.idScrollView = scrollView;
        this.txtModeTitle = textView;
        this.viewpager = indexViewPager;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7ActivityMainBinding bind(View view) {
        int i = R.id.btnReturn;
        ImageView imageView = (ImageView) view.findViewById(R.id.btnReturn);
        if (imageView != null) {
            i = R.id.id_scroll_view;
            ScrollView scrollView = (ScrollView) view.findViewById(R.id.id_scroll_view);
            if (scrollView != null) {
                i = R.id.txtModeTitle;
                TextView textView = (TextView) view.findViewById(R.id.txtModeTitle);
                if (textView != null) {
                    i = R.id.viewpager;
                    IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewpager);
                    if (indexViewPager != null) {
                        return new Kesaiwei1920x720EvoId7ActivityMainBinding((RelativeLayout) view, imageView, scrollView, textView, indexViewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
