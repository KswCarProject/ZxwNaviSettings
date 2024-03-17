package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.ClipRecyclerView;
import com.szchoiceway.settings.view.MyScrollbar;

public final class SmallKesaiwei1920x720BenzFragmentSysSetMusicBinding implements ViewBinding {
    public final ClipRecyclerView appList;
    public final MyScrollbar myScrollbar;
    private final RelativeLayout rootView;
    public final ImageView scrollFrame;

    private SmallKesaiwei1920x720BenzFragmentSysSetMusicBinding(RelativeLayout relativeLayout, ClipRecyclerView clipRecyclerView, MyScrollbar myScrollbar2, ImageView imageView) {
        this.rootView = relativeLayout;
        this.appList = clipRecyclerView;
        this.myScrollbar = myScrollbar2;
        this.scrollFrame = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallKesaiwei1920x720BenzFragmentSysSetMusicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallKesaiwei1920x720BenzFragmentSysSetMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_music, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallKesaiwei1920x720BenzFragmentSysSetMusicBinding bind(View view) {
        int i = R.id.appList;
        ClipRecyclerView clipRecyclerView = (ClipRecyclerView) view.findViewById(R.id.appList);
        if (clipRecyclerView != null) {
            i = R.id.myScrollbar;
            MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            if (myScrollbar2 != null) {
                i = R.id.scrollFrame;
                ImageView imageView = (ImageView) view.findViewById(R.id.scrollFrame);
                if (imageView != null) {
                    return new SmallKesaiwei1920x720BenzFragmentSysSetMusicBinding((RelativeLayout) view, clipRecyclerView, myScrollbar2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
