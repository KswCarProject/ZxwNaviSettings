package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class AudiFragmentNavSet1560x700Binding implements ViewBinding {
    public final RecyclerView appList;
    public final MyScrollbar myScrollbar;
    private final ConstraintLayout rootView;

    private AudiFragmentNavSet1560x700Binding(ConstraintLayout constraintLayout, RecyclerView recyclerView, MyScrollbar myScrollbar2) {
        this.rootView = constraintLayout;
        this.appList = recyclerView;
        this.myScrollbar = myScrollbar2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AudiFragmentNavSet1560x700Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiFragmentNavSet1560x700Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_fragment_nav_set_1560x700, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiFragmentNavSet1560x700Binding bind(View view) {
        int i = R.id.appList;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            i = R.id.myScrollbar;
            MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            if (myScrollbar2 != null) {
                return new AudiFragmentNavSet1560x700Binding((ConstraintLayout) view, recyclerView, myScrollbar2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
