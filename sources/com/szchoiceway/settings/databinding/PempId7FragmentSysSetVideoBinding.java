package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class PempId7FragmentSysSetVideoBinding implements ViewBinding {
    public final RecyclerView appList;
    private final RelativeLayout rootView;
    public final TextView txtVideoApk;

    private PempId7FragmentSysSetVideoBinding(RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView) {
        this.rootView = relativeLayout;
        this.appList = recyclerView;
        this.txtVideoApk = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PempId7FragmentSysSetVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PempId7FragmentSysSetVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PempId7FragmentSysSetVideoBinding bind(View view) {
        int i = R.id.appList;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            i = R.id.txtVideoApk;
            TextView textView = (TextView) view.findViewById(R.id.txtVideoApk);
            if (textView != null) {
                return new PempId7FragmentSysSetVideoBinding((RelativeLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
