package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class LandroverFragmentSysSetMediaSelectBinding implements ViewBinding {
    public final RecyclerView appList;
    private final ConstraintLayout rootView;

    private LandroverFragmentSysSetMediaSelectBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.appList = recyclerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LandroverFragmentSysSetMediaSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverFragmentSysSetMediaSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_media_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverFragmentSysSetMediaSelectBinding bind(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            return new LandroverFragmentSysSetMediaSelectBinding((ConstraintLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.appList)));
    }
}
