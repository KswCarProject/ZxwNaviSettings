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

public final class SmallAudiSetAppItemBinding implements ViewBinding {
    public final ImageView appIcon;
    public final TextView appLabel;
    public final ImageButton btnApp;
    public final CheckBox chkApp;
    public final View line;
    private final RelativeLayout rootView;

    private SmallAudiSetAppItemBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, ImageButton imageButton, CheckBox checkBox, View view) {
        this.rootView = relativeLayout;
        this.appIcon = imageView;
        this.appLabel = textView;
        this.btnApp = imageButton;
        this.chkApp = checkBox;
        this.line = view;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallAudiSetAppItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallAudiSetAppItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_audi_set_app_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallAudiSetAppItemBinding bind(View view) {
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
                        View findViewById = view.findViewById(R.id.line);
                        if (findViewById != null) {
                            return new SmallAudiSetAppItemBinding((RelativeLayout) view, imageView, textView, imageButton, checkBox, findViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
