package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;

public final class LandroverThemeFragmentSysSetMainBinding implements ViewBinding {
    public final ConstraintLayout pagerView;
    public final RecyclerView recycleViewSystemSet;
    private final ConstraintLayout rootView;
    public final IndexViewPager viewPager;

    private LandroverThemeFragmentSysSetMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, IndexViewPager indexViewPager) {
        this.rootView = constraintLayout;
        this.pagerView = constraintLayout2;
        this.recycleViewSystemSet = recyclerView;
        this.viewPager = indexViewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LandroverThemeFragmentSysSetMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverThemeFragmentSysSetMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverThemeFragmentSysSetMainBinding bind(View view) {
        int i = R.id.pagerView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.pagerView);
        if (constraintLayout != null) {
            i = R.id.recycleViewSystemSet;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewSystemSet);
            if (recyclerView != null) {
                i = R.id.viewPager;
                IndexViewPager indexViewPager = (IndexViewPager) view.findViewById(R.id.viewPager);
                if (indexViewPager != null) {
                    return new LandroverThemeFragmentSysSetMainBinding((ConstraintLayout) view, constraintLayout, recyclerView, indexViewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
