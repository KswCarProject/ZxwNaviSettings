package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class AudiFragmentSysSetVideo1560x700Binding implements ViewBinding {
    public final RecyclerView appList;
    public final MyScrollbar myScrollbar;
    public final ImageView myScrollbarBg;
    private final RelativeLayout rootView;

    private AudiFragmentSysSetVideo1560x700Binding(RelativeLayout relativeLayout, RecyclerView recyclerView, MyScrollbar myScrollbar2, ImageView imageView) {
        this.rootView = relativeLayout;
        this.appList = recyclerView;
        this.myScrollbar = myScrollbar2;
        this.myScrollbarBg = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AudiFragmentSysSetVideo1560x700Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiFragmentSysSetVideo1560x700Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_fragment_sys_set_video_1560x700, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiFragmentSysSetVideo1560x700Binding bind(View view) {
        int i = R.id.appList;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            i = R.id.myScrollbar;
            MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            if (myScrollbar2 != null) {
                i = R.id.myScrollbarBg;
                ImageView imageView = (ImageView) view.findViewById(R.id.myScrollbarBg);
                if (imageView != null) {
                    return new AudiFragmentSysSetVideo1560x700Binding((RelativeLayout) view, recyclerView, myScrollbar2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
