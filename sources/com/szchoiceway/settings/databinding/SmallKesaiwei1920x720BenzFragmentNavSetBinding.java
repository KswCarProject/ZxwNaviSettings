package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.ClipRecyclerView;
import com.szchoiceway.settings.view.MyScrollbar;

public final class SmallKesaiwei1920x720BenzFragmentNavSetBinding implements ViewBinding {
    public final ClipRecyclerView appList;
    public final MyScrollbar myScrollbar;
    private final ConstraintLayout rootView;

    private SmallKesaiwei1920x720BenzFragmentNavSetBinding(ConstraintLayout constraintLayout, ClipRecyclerView clipRecyclerView, MyScrollbar myScrollbar2) {
        this.rootView = constraintLayout;
        this.appList = clipRecyclerView;
        this.myScrollbar = myScrollbar2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SmallKesaiwei1920x720BenzFragmentNavSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallKesaiwei1920x720BenzFragmentNavSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_nav_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallKesaiwei1920x720BenzFragmentNavSetBinding bind(View view) {
        int i = R.id.appList;
        ClipRecyclerView clipRecyclerView = (ClipRecyclerView) view.findViewById(R.id.appList);
        if (clipRecyclerView != null) {
            i = R.id.myScrollbar;
            MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            if (myScrollbar2 != null) {
                return new SmallKesaiwei1920x720BenzFragmentNavSetBinding((ConstraintLayout) view, clipRecyclerView, myScrollbar2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
