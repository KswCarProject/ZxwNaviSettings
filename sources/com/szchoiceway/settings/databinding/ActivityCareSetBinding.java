package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MySeekbar3;

public final class ActivityCareSetBinding implements ViewBinding {
    public final ImageView img1;
    public final ImageView img2;
    private final ConstraintLayout rootView;
    public final MySeekbar3 seekbarOil;
    public final MySeekbar3 seekbarSpeed;
    public final TextView valueOil;
    public final TextView valueSpeed;

    private ActivityCareSetBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, MySeekbar3 mySeekbar3, MySeekbar3 mySeekbar32, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.img1 = imageView;
        this.img2 = imageView2;
        this.seekbarOil = mySeekbar3;
        this.seekbarSpeed = mySeekbar32;
        this.valueOil = textView;
        this.valueSpeed = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCareSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityCareSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_care_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCareSetBinding bind(View view) {
        int i = R.id.img1;
        ImageView imageView = (ImageView) view.findViewById(R.id.img1);
        if (imageView != null) {
            i = R.id.img2;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img2);
            if (imageView2 != null) {
                i = R.id.seekbarOil;
                MySeekbar3 mySeekbar3 = (MySeekbar3) view.findViewById(R.id.seekbarOil);
                if (mySeekbar3 != null) {
                    i = R.id.seekbarSpeed;
                    MySeekbar3 mySeekbar32 = (MySeekbar3) view.findViewById(R.id.seekbarSpeed);
                    if (mySeekbar32 != null) {
                        i = R.id.valueOil;
                        TextView textView = (TextView) view.findViewById(R.id.valueOil);
                        if (textView != null) {
                            i = R.id.valueSpeed;
                            TextView textView2 = (TextView) view.findViewById(R.id.valueSpeed);
                            if (textView2 != null) {
                                return new ActivityCareSetBinding((ConstraintLayout) view, imageView, imageView2, mySeekbar3, mySeekbar32, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
