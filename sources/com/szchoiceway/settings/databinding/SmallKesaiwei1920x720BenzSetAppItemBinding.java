package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class SmallKesaiwei1920x720BenzSetAppItemBinding implements ViewBinding {
    public final ImageView appIcon;
    public final TextView appLabel;
    public final ImageButton btnApp;
    public final CheckBox chkApp;
    public final ImageView line;
    private final RelativeLayout rootView;

    private SmallKesaiwei1920x720BenzSetAppItemBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, ImageButton imageButton, CheckBox checkBox, ImageView imageView2) {
        this.rootView = relativeLayout;
        this.appIcon = imageView;
        this.appLabel = textView;
        this.btnApp = imageButton;
        this.chkApp = checkBox;
        this.line = imageView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallKesaiwei1920x720BenzSetAppItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallKesaiwei1920x720BenzSetAppItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_set_app_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallKesaiwei1920x720BenzSetAppItemBinding bind(View view) {
        int i = R.id.appIcon;
        ImageView imageView = (ImageView) view.findViewById(R.id.appIcon);
        if (imageView != null) {
            i = R.id.appLabel;
            TextView textView = (TextView) view.findViewById(R.id.appLabel);
            if (textView != null) {
                i = R.id.btnApp;
                ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnApp);
                if (imageButton != null) {
                    i = R.id.chkApp;
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.chkApp);
                    if (checkBox != null) {
                        i = R.id.line;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.line);
                        if (imageView2 != null) {
                            return new SmallKesaiwei1920x720BenzSetAppItemBinding((RelativeLayout) view, imageView, textView, imageButton, checkBox, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
