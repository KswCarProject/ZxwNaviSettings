package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.ClipScrollView;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720BenzActivityMainBinding implements ViewBinding {
    public final ConstraintLayout contentView;
    public final ImageView iconView;
    public final ClipScrollView idScrollView;
    public final ImageButton kswBenzBack;
    public final ImageView kswBenzView2Right;
    public final MyScrollbar myScrollbar;
    public final ConstraintLayout passwordView;
    private final ConstraintLayout rootView;
    public final TextView textSettingsTitle;
    public final ConstraintLayout titleView;
    public final ImageView viewBg;
    public final IndexViewPager viewpager;

    private Kesaiwei1920x720BenzActivityMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ClipScrollView clipScrollView, ImageButton imageButton, ImageView imageView2, MyScrollbar myScrollbar2, ConstraintLayout constraintLayout3, TextView textView, ConstraintLayout constraintLayout4, ImageView imageView3, IndexViewPager indexViewPager) {
        this.rootView = constraintLayout;
        this.contentView = constraintLayout2;
        this.iconView = imageView;
        this.idScrollView = clipScrollView;
        this.kswBenzBack = imageButton;
        this.kswBenzView2Right = imageView2;
        this.myScrollbar = myScrollbar2;
        this.passwordView = constraintLayout3;
        this.textSettingsTitle = textView;
        this.titleView = constraintLayout4;
        this.viewBg = imageView3;
        this.viewpager = indexViewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720BenzActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720BenzActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720BenzActivityMainBinding bind(View view) {
        int i = R.id.contentView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.contentView);
        if (constraintLayout != null) {
            i = R.id.iconView;
            ImageView imageView = (ImageView) view.findViewById(R.id.iconView);
            if (imageView != null) {
                i = R.id.id_scroll_view;
                ClipScrollView clipScrollView = (ClipScrollView) view.findViewById(R.id.id_scroll_view);
                if (clipScrollView != null) {
                    i = R.id.kswBenzBack;
                    ImageButton imageButton = (ImageButton) view.findViewById(R.id.kswBenzBack);
                    if (imageButton != null) {
                        i = R.id.ksw_benz_view2_right;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.ksw_benz_view2_right);
                        if (imageView2 != null) {
                            i = R.id.myScrollbar;
                            MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
                            if (myScrollbar2 != null) {
                                i = R.id.passwordView;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.passwordView);
                                if (constraintLayout2 != null) {
                                    i = R.id.textSettingsTitle;
                                    TextView textView = (TextView) view.findViewById(R.id.textSettingsTitle);
                                    if (textView != null) {
                                        i = R.id.titleView;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.titleView);
                                        if (constraintLayout3 != null) {
                                            i = R.id.viewBg;
                                            ImageView imageView3 = (ImageView) view.findViewById(R.id.viewBg);
                                            if (imageView3 != null) {
                                                i = R.id.viewpager;
                                                IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewpager);
                                                if (indexViewPager != null) {
                                                    return new Kesaiwei1920x720BenzActivityMainBinding((ConstraintLayout) view, constraintLayout, imageView, clipScrollView, imageButton, imageView2, myScrollbar2, constraintLayout2, textView, constraintLayout3, imageView3, indexViewPager);
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
