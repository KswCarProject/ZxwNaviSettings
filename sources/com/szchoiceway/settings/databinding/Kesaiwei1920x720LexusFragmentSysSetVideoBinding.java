package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720LexusFragmentSysSetVideoBinding implements ViewBinding {
    public final RecyclerView appList;
    public final MyScrollbar myScrollbar;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720LexusFragmentSysSetVideoBinding(RelativeLayout relativeLayout, RecyclerView recyclerView, MyScrollbar myScrollbar2) {
        this.rootView = relativeLayout;
        this.appList = recyclerView;
        this.myScrollbar = myScrollbar2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720LexusFragmentSysSetVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetVideoBinding bind(View view) {
        int i = R.id.appList;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            i = R.id.myScrollbar;
            MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            if (myScrollbar2 != null) {
                return new Kesaiwei1920x720LexusFragmentSysSetVideoBinding((RelativeLayout) view, recyclerView, myScrollbar2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
