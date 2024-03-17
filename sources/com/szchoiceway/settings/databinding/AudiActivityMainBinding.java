package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class AudiActivityMainBinding implements ViewBinding {
    public final ConstraintLayout contentView;
    public final ImageView iconView;
    public final ScrollView idScrollView;
    public final MyScrollbar myScrollbar;
    public final ConstraintLayout passwordView;
    private final ConstraintLayout rootView;
    public final ConstraintLayout titleView;
    public final IndexViewPager viewpager;

    private AudiActivityMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ScrollView scrollView, MyScrollbar myScrollbar2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, IndexViewPager indexViewPager) {
        this.rootView = constraintLayout;
        this.contentView = constraintLayout2;
        this.iconView = imageView;
        this.idScrollView = scrollView;
        this.myScrollbar = myScrollbar2;
        this.passwordView = constraintLayout3;
        this.titleView = constraintLayout4;
        this.viewpager = indexViewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AudiActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiActivityMainBinding bind(View view) {
        int i = R.id.contentView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.contentView);
        if (constraintLayout != null) {
            i = R.id.iconView;
            ImageView imageView = (ImageView) view.findViewById(R.id.iconView);
            if (imageView != null) {
                i = R.id.id_scroll_view;
                ScrollView scrollView = (ScrollView) view.findViewById(R.id.id_scroll_view);
                if (scrollView != null) {
                    i = R.id.myScrollbar;
                    MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
                    if (myScrollbar2 != null) {
                        i = R.id.passwordView;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.passwordView);
                        if (constraintLayout2 != null) {
                            i = R.id.titleView;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.titleView);
                            if (constraintLayout3 != null) {
                                i = R.id.viewpager;
                                IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewpager);
                                if (indexViewPager != null) {
                                    return new AudiActivityMainBinding((ConstraintLayout) view, constraintLayout, imageView, scrollView, myScrollbar2, constraintLayout2, constraintLayout3, indexViewPager);
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
