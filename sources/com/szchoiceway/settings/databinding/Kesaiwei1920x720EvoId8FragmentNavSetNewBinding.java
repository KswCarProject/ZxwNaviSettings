package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720EvoId8FragmentNavSetNewBinding implements ViewBinding {
    public final RecyclerView appList;
    public final ImageButton btnReturn;
    public final MyScrollbar myScrollbar;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720EvoId8FragmentNavSetNewBinding(RelativeLayout relativeLayout, RecyclerView recyclerView, ImageButton imageButton, MyScrollbar myScrollbar2) {
        this.rootView = relativeLayout;
        this.appList = recyclerView;
        this.btnReturn = imageButton;
        this.myScrollbar = myScrollbar2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentNavSetNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentNavSetNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_nav_set_new, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentNavSetNewBinding bind(View view) {
        int i = R.id.appList;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            i = R.id.btnReturn;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnReturn);
            if (imageButton != null) {
                i = R.id.myScrollbar;
                MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
                if (myScrollbar2 != null) {
                    return new Kesaiwei1920x720EvoId8FragmentNavSetNewBinding((RelativeLayout) view, recyclerView, imageButton, myScrollbar2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
