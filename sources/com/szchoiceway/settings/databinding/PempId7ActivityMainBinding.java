package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;

public final class PempId7ActivityMainBinding implements ViewBinding {
    public final ImageView btnReturn;
    public final ScrollView idScrollView;
    private final RelativeLayout rootView;
    public final IndexViewPager viewpager;

    private PempId7ActivityMainBinding(RelativeLayout relativeLayout, ImageView imageView, ScrollView scrollView, IndexViewPager indexViewPager) {
        this.rootView = relativeLayout;
        this.btnReturn = imageView;
        this.idScrollView = scrollView;
        this.viewpager = indexViewPager;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PempId7ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PempId7ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pemp_id7_activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PempId7ActivityMainBinding bind(View view) {
        int i = R.id.btnReturn;
        ImageView imageView = (ImageView) view.findViewById(R.id.btnReturn);
        if (imageView != null) {
            i = R.id.id_scroll_view;
            ScrollView scrollView = (ScrollView) view.findViewById(R.id.id_scroll_view);
            if (scrollView != null) {
                i = R.id.viewpager;
                IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewpager);
                if (indexViewPager != null) {
                    return new PempId7ActivityMainBinding((RelativeLayout) view, imageView, scrollView, indexViewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
