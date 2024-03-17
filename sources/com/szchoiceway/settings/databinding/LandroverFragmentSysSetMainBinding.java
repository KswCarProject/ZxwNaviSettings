package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;

public final class LandroverFragmentSysSetMainBinding implements ViewBinding {
    public final ImageButton btnHidePagerView;
    public final ConstraintLayout listView;
    public final ConstraintLayout pagerView;
    public final RecyclerView recycleViewSystemSet;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;
    public final IndexViewPager viewPager;

    private LandroverFragmentSysSetMainBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, RecyclerView recyclerView, TextView textView, IndexViewPager indexViewPager) {
        this.rootView = constraintLayout;
        this.btnHidePagerView = imageButton;
        this.listView = constraintLayout2;
        this.pagerView = constraintLayout3;
        this.recycleViewSystemSet = recyclerView;
        this.tvTitle = textView;
        this.viewPager = indexViewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LandroverFragmentSysSetMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverFragmentSysSetMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverFragmentSysSetMainBinding bind(View view) {
        int i = R.id.btnHidePagerView;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnHidePagerView);
        if (imageButton != null) {
            i = R.id.listView;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.listView);
            if (constraintLayout != null) {
                i = R.id.pagerView;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.pagerView);
                if (constraintLayout2 != null) {
                    i = R.id.recycleViewSystemSet;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewSystemSet);
                    if (recyclerView != null) {
                        i = R.id.tvTitle;
                        TextView textView = (TextView) view.findViewById(R.id.tvTitle);
                        if (textView != null) {
                            i = R.id.viewPager;
                            IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewPager);
                            if (indexViewPager != null) {
                                return new LandroverFragmentSysSetMainBinding((ConstraintLayout) view, imageButton, constraintLayout, constraintLayout2, recyclerView, textView, indexViewPager);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
