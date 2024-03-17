package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyRecycleView;

public final class LandroverActivityMainBinding implements ViewBinding {
    public final View bottomView;
    public final ImageButton btnMainSetItem0;
    public final ImageButton btnMainSetItem1;
    public final ImageButton btnMainSetItem2;
    public final ImageButton btnMainSetItem3;
    public final ImageButton btnMainSetItem4;
    public final ImageView img1;
    public final ImageView imgBg;
    public final MyRecycleView recycleViewMenu;
    private final ConstraintLayout rootView;
    public final IndexViewPager viewpager;

    private LandroverActivityMainBinding(ConstraintLayout constraintLayout, View view, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageView imageView, ImageView imageView2, MyRecycleView myRecycleView, IndexViewPager indexViewPager) {
        this.rootView = constraintLayout;
        this.bottomView = view;
        this.btnMainSetItem0 = imageButton;
        this.btnMainSetItem1 = imageButton2;
        this.btnMainSetItem2 = imageButton3;
        this.btnMainSetItem3 = imageButton4;
        this.btnMainSetItem4 = imageButton5;
        this.img1 = imageView;
        this.imgBg = imageView2;
        this.recycleViewMenu = myRecycleView;
        this.viewpager = indexViewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LandroverActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverActivityMainBinding bind(View view) {
        int i = R.id.bottomView;
        View findViewById = view.findViewById(R.id.bottomView);
        if (findViewById != null) {
            i = R.id.btnMainSetItem0;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnMainSetItem0);
            if (imageButton != null) {
                i = R.id.btnMainSetItem1;
                ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnMainSetItem1);
                if (imageButton2 != null) {
                    i = R.id.btnMainSetItem2;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnMainSetItem2);
                    if (imageButton3 != null) {
                        i = R.id.btnMainSetItem3;
                        ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.btnMainSetItem3);
                        if (imageButton4 != null) {
                            i = R.id.btnMainSetItem4;
                            ImageButton imageButton5 = (ImageButton) view.findViewById(R.id.btnMainSetItem4);
                            if (imageButton5 != null) {
                                i = R.id.img1;
                                ImageView imageView = (ImageView) view.findViewById(R.id.img1);
                                if (imageView != null) {
                                    i = R.id.imgBg;
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.imgBg);
                                    if (imageView2 != null) {
                                        i = R.id.recycleViewMenu;
                                        MyRecycleView myRecycleView = (MyRecycleView) view.findViewById(R.id.recycleViewMenu);
                                        if (myRecycleView != null) {
                                            i = R.id.viewpager;
                                            IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewpager);
                                            if (indexViewPager != null) {
                                                return new LandroverActivityMainBinding((ConstraintLayout) view, findViewById, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageView, imageView2, myRecycleView, indexViewPager);
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
