package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720LexusFragmentNavSetBinding implements ViewBinding {
    public final RecyclerView appList;
    public final ImageView imgNaviBg;
    public final MyScrollbar myScrollbar;
    private final ConstraintLayout rootView;
    public final Guideline systemScrollViewLeGuideline;
    public final Guideline systemScrollViewRiGuideline;
    public final Guideline viewPagerLeGuideline;

    private Kesaiwei1920x720LexusFragmentNavSetBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, ImageView imageView, MyScrollbar myScrollbar2, Guideline guideline, Guideline guideline2, Guideline guideline3) {
        this.rootView = constraintLayout;
        this.appList = recyclerView;
        this.imgNaviBg = imageView;
        this.myScrollbar = myScrollbar2;
        this.systemScrollViewLeGuideline = guideline;
        this.systemScrollViewRiGuideline = guideline2;
        this.viewPagerLeGuideline = guideline3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720LexusFragmentNavSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720LexusFragmentNavSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_nav_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720LexusFragmentNavSetBinding bind(View view) {
        int i = R.id.appList;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            i = R.id.imgNaviBg;
            ImageView imageView = (ImageView) view.findViewById(R.id.imgNaviBg);
            if (imageView != null) {
                i = R.id.myScrollbar;
                MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
                if (myScrollbar2 != null) {
                    i = R.id.systemScrollView_le_guideline;
                    Guideline guideline = (Guideline) view.findViewById(R.id.systemScrollView_le_guideline);
                    if (guideline != null) {
                        i = R.id.systemScrollView_ri_guideline;
                        Guideline guideline2 = (Guideline) view.findViewById(R.id.systemScrollView_ri_guideline);
                        if (guideline2 != null) {
                            i = R.id.viewPager_le_guideline;
                            Guideline guideline3 = (Guideline) view.findViewById(R.id.viewPager_le_guideline);
                            if (guideline3 != null) {
                                return new Kesaiwei1920x720LexusFragmentNavSetBinding((ConstraintLayout) view, recyclerView, imageView, myScrollbar2, guideline, guideline2, guideline3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
