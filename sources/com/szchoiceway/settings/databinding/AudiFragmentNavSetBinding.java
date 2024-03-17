package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class AudiFragmentNavSetBinding implements ViewBinding {
    public final RecyclerView appList;
    public final MyScrollbar myScrollbar;
    private final ConstraintLayout rootView;

    private AudiFragmentNavSetBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, MyScrollbar myScrollbar2) {
        this.rootView = constraintLayout;
        this.appList = recyclerView;
        this.myScrollbar = myScrollbar2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AudiFragmentNavSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiFragmentNavSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_fragment_nav_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiFragmentNavSetBinding bind(View view) {
        int i = R.id.appList;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            i = R.id.myScrollbar;
            MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            if (myScrollbar2 != null) {
                return new AudiFragmentNavSetBinding((ConstraintLayout) view, recyclerView, myScrollbar2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
