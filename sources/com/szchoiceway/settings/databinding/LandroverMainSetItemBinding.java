package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class LandroverMainSetItemBinding implements ViewBinding {
    public final ImageButton btnMainSetItem;
    public final CheckBox chkIcon;
    private final ConstraintLayout rootView;
    public final TextView txtTitle;
    public final View viewInterval;

    private LandroverMainSetItemBinding(ConstraintLayout constraintLayout, ImageButton imageButton, CheckBox checkBox, TextView textView, View view) {
        this.rootView = constraintLayout;
        this.btnMainSetItem = imageButton;
        this.chkIcon = checkBox;
        this.txtTitle = textView;
        this.viewInterval = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LandroverMainSetItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverMainSetItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_main_set_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverMainSetItemBinding bind(View view) {
        int i = R.id.btnMainSetItem;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnMainSetItem);
        if (imageButton != null) {
            i = R.id.chkIcon;
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.chkIcon);
            if (checkBox != null) {
                i = R.id.txtTitle;
                TextView textView = (TextView) view.findViewById(R.id.txtTitle);
                if (textView != null) {
                    i = R.id.viewInterval;
                    View findViewById = view.findViewById(R.id.viewInterval);
                    if (findViewById != null) {
                        return new LandroverMainSetItemBinding((ConstraintLayout) view, imageButton, checkBox, textView, findViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
