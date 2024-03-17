package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class LandroverLanguageSetItemBinding implements ViewBinding {
    public final ImageButton btnMainSetItem;
    public final CheckBox chkIcon;
    public final ImageView line;
    private final ConstraintLayout rootView;
    public final TextView txtTitle;

    private LandroverLanguageSetItemBinding(ConstraintLayout constraintLayout, ImageButton imageButton, CheckBox checkBox, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.btnMainSetItem = imageButton;
        this.chkIcon = checkBox;
        this.line = imageView;
        this.txtTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LandroverLanguageSetItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverLanguageSetItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_language_set_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverLanguageSetItemBinding bind(View view) {
        int i = R.id.btnMainSetItem;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnMainSetItem);
        if (imageButton != null) {
            i = R.id.chkIcon;
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.chkIcon);
            if (checkBox != null) {
                i = R.id.line;
                ImageView imageView = (ImageView) view.findViewById(R.id.line);
                if (imageView != null) {
                    i = R.id.txtTitle;
                    TextView textView = (TextView) view.findViewById(R.id.txtTitle);
                    if (textView != null) {
                        return new LandroverLanguageSetItemBinding((ConstraintLayout) view, imageButton, checkBox, imageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
