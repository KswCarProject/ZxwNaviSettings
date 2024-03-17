package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class SmallAudiFragmentSysSetMusicVideoBinding implements ViewBinding {
    public final RecyclerView appList;
    private final RelativeLayout rootView;

    private SmallAudiFragmentSysSetMusicVideoBinding(RelativeLayout relativeLayout, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.appList = recyclerView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallAudiFragmentSysSetMusicVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallAudiFragmentSysSetMusicVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_music_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallAudiFragmentSysSetMusicVideoBinding bind(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
            return new SmallAudiFragmentSysSetMusicVideoBinding((RelativeLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.appList)));
    }
}
