package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentSysSetVideoBinding implements ViewBinding {
    public final RecyclerView appList;
    private final RelativeLayout rootView;
    public final TextView txtMusicApk;

    private Kesaiwei1920x720EvoId7FragmentSysSetVideoBinding(RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView) {
        this.rootView = relativeLayout;
        this.appList = recyclerView;
        this.txtMusicApk = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetVideoBinding bind(View view) {
        int i = R.id.appList;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            i = R.id.txtMusicApk;
            TextView textView = (TextView) view.findViewById(R.id.txtMusicApk);
            if (textView != null) {
                return new Kesaiwei1920x720EvoId7FragmentSysSetVideoBinding((RelativeLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
