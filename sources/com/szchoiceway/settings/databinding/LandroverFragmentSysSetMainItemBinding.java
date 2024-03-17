package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class LandroverFragmentSysSetMainItemBinding implements ViewBinding {
    public final ImageButton btnMainSetItem;
    public final ImageView line;
    private final ConstraintLayout rootView;
    public final TextView txtTitle;

    private LandroverFragmentSysSetMainItemBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.btnMainSetItem = imageButton;
        this.line = imageView;
        this.txtTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LandroverFragmentSysSetMainItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverFragmentSysSetMainItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_main_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverFragmentSysSetMainItemBinding bind(View view) {
        int i = R.id.btnMainSetItem;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnMainSetItem);
        if (imageButton != null) {
            i = R.id.line;
            ImageView imageView = (ImageView) view.findViewById(R.id.line);
            if (imageView != null) {
                i = R.id.txtTitle;
                TextView textView = (TextView) view.findViewById(R.id.txtTitle);
                if (textView != null) {
                    return new LandroverFragmentSysSetMainItemBinding((ConstraintLayout) view, imageButton, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
