package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId8ActivityMainBinding implements ViewBinding {
    public final ImageButton btnAppList;
    public final ImageButton btnMusic;
    public final ImageButton btnNav;
    public final ImageButton btnTel;
    public final HorizontalScrollView id8ScrollView;
    private final RelativeLayout rootView;
    public final TextView txtModeTitle;
    public final IndexViewPager viewpager;

    private Kesaiwei1920x720EvoId8ActivityMainBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, HorizontalScrollView horizontalScrollView, TextView textView, IndexViewPager indexViewPager) {
        this.rootView = relativeLayout;
        this.btnAppList = imageButton;
        this.btnMusic = imageButton2;
        this.btnNav = imageButton3;
        this.btnTel = imageButton4;
        this.id8ScrollView = horizontalScrollView;
        this.txtModeTitle = textView;
        this.viewpager = indexViewPager;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8ActivityMainBinding bind(View view) {
        int i = R.id.btnAppList;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnAppList);
        if (imageButton != null) {
            i = R.id.btnMusic;
            ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnMusic);
            if (imageButton2 != null) {
                i = R.id.btnNav;
                ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnNav);
                if (imageButton3 != null) {
                    i = R.id.btnTel;
                    ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.btnTel);
                    if (imageButton4 != null) {
                        i = R.id.id8_scroll_view;
                        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.id8_scroll_view);
                        if (horizontalScrollView != null) {
                            i = R.id.txtModeTitle;
                            TextView textView = (TextView) view.findViewById(R.id.txtModeTitle);
                            if (textView != null) {
                                i = R.id.viewpager;
                                IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewpager);
                                if (indexViewPager != null) {
                                    return new Kesaiwei1920x720EvoId8ActivityMainBinding((RelativeLayout) view, imageButton, imageButton2, imageButton3, imageButton4, horizontalScrollView, textView, indexViewPager);
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
