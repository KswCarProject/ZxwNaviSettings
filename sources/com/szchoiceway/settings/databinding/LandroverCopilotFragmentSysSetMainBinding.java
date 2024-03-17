package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MySeekbar1;

public final class LandroverCopilotFragmentSysSetMainBinding implements ViewBinding {
    public final MySeekbar1 mySeekbarBrightness;
    private final RelativeLayout rootView;
    public final TextView tvValueBrightness;
    public final TextView txtBl;

    private LandroverCopilotFragmentSysSetMainBinding(RelativeLayout relativeLayout, MySeekbar1 mySeekbar1, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.mySeekbarBrightness = mySeekbar1;
        this.tvValueBrightness = textView;
        this.txtBl = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LandroverCopilotFragmentSysSetMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverCopilotFragmentSysSetMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_copilot_fragment_sys_set_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverCopilotFragmentSysSetMainBinding bind(View view) {
        int i = R.id.mySeekbarBrightness;
        MySeekbar1 mySeekbar1 = (MySeekbar1) view.findViewById(R.id.mySeekbarBrightness);
        if (mySeekbar1 != null) {
            i = R.id.tvValueBrightness;
            TextView textView = (TextView) view.findViewById(R.id.tvValueBrightness);
            if (textView != null) {
                i = R.id.txtBl;
                TextView textView2 = (TextView) view.findViewById(R.id.txtBl);
                if (textView2 != null) {
                    return new LandroverCopilotFragmentSysSetMainBinding((RelativeLayout) view, mySeekbar1, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
