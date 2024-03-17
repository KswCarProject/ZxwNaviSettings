package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;

public final class SmallAudiActivityMainBinding implements ViewBinding {
    public final ConstraintLayout contentView;
    public final ScrollView idScrollView;
    public final ImageView imgBg;
    public final ImageView imgDate;
    public final ConstraintLayout passwordView;
    private final ConstraintLayout rootView;
    public final ConstraintLayout titleView;
    public final TextView tvDate;
    public final IndexViewPager viewpager;

    private SmallAudiActivityMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ScrollView scrollView, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, IndexViewPager indexViewPager) {
        this.rootView = constraintLayout;
        this.contentView = constraintLayout2;
        this.idScrollView = scrollView;
        this.imgBg = imageView;
        this.imgDate = imageView2;
        this.passwordView = constraintLayout3;
        this.titleView = constraintLayout4;
        this.tvDate = textView;
        this.viewpager = indexViewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SmallAudiActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallAudiActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_audi_activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallAudiActivityMainBinding bind(View view) {
        int i = R.id.contentView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.contentView);
        if (constraintLayout != null) {
            i = R.id.id_scroll_view;
            ScrollView scrollView = (ScrollView) view.findViewById(R.id.id_scroll_view);
            if (scrollView != null) {
                i = R.id.imgBg;
                ImageView imageView = (ImageView) view.findViewById(R.id.imgBg);
                if (imageView != null) {
                    i = R.id.imgDate;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.imgDate);
                    if (imageView2 != null) {
                        i = R.id.passwordView;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.passwordView);
                        if (constraintLayout2 != null) {
                            i = R.id.titleView;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.titleView);
                            if (constraintLayout3 != null) {
                                i = R.id.tvDate;
                                TextView textView = (TextView) view.findViewById(R.id.tvDate);
                                if (textView != null) {
                                    i = R.id.viewpager;
                                    IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewpager);
                                    if (indexViewPager != null) {
                                        return new SmallAudiActivityMainBinding((ConstraintLayout) view, constraintLayout, scrollView, imageView, imageView2, constraintLayout2, constraintLayout3, textView, indexViewPager);
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
