package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class LandroverFragmentTimeSetBinding implements ViewBinding {
    public final ImageButton btn12Hour;
    public final ImageButton btn24Hour;
    public final ImageButton btnAutoSync;
    public final ImageButton btnOriginalTime;
    public final CheckBox kesaiwei12Hour;
    public final CheckBox kesaiwei24Hour;
    public final CheckBox kesaiweiAutoSync;
    public final CheckBox kesaiweiOriginalTime;
    private final ConstraintLayout rootView;
    public final TextView title0;
    public final TextView title1;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;

    private LandroverFragmentTimeSetBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, TextView textView, TextView textView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4) {
        this.rootView = constraintLayout;
        this.btn12Hour = imageButton;
        this.btn24Hour = imageButton2;
        this.btnAutoSync = imageButton3;
        this.btnOriginalTime = imageButton4;
        this.kesaiwei12Hour = checkBox;
        this.kesaiwei24Hour = checkBox2;
        this.kesaiweiAutoSync = checkBox3;
        this.kesaiweiOriginalTime = checkBox4;
        this.title0 = textView;
        this.title1 = textView2;
        this.view0 = relativeLayout;
        this.view1 = relativeLayout2;
        this.view2 = relativeLayout3;
        this.view3 = relativeLayout4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LandroverFragmentTimeSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverFragmentTimeSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_fragment_time_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverFragmentTimeSetBinding bind(View view) {
        View view4 = view;
        int i = R.id.btn12Hour;
        ImageButton imageButton = (ImageButton) view4.findViewById(R.id.btn12Hour);
        if (imageButton != null) {
            i = R.id.btn24Hour;
            ImageButton imageButton2 = (ImageButton) view4.findViewById(R.id.btn24Hour);
            if (imageButton2 != null) {
                i = R.id.btnAutoSync;
                ImageButton imageButton3 = (ImageButton) view4.findViewById(R.id.btnAutoSync);
                if (imageButton3 != null) {
                    i = R.id.btnOriginalTime;
                    ImageButton imageButton4 = (ImageButton) view4.findViewById(R.id.btnOriginalTime);
                    if (imageButton4 != null) {
                        i = R.id.kesaiwei_12_hour;
                        CheckBox checkBox = (CheckBox) view4.findViewById(R.id.kesaiwei_12_hour);
                        if (checkBox != null) {
                            i = R.id.kesaiwei_24_hour;
                            CheckBox checkBox2 = (CheckBox) view4.findViewById(R.id.kesaiwei_24_hour);
                            if (checkBox2 != null) {
                                i = R.id.kesaiwei_Auto_Sync;
                                CheckBox checkBox3 = (CheckBox) view4.findViewById(R.id.kesaiwei_Auto_Sync);
                                if (checkBox3 != null) {
                                    i = R.id.kesaiwei_Original_Time;
                                    CheckBox checkBox4 = (CheckBox) view4.findViewById(R.id.kesaiwei_Original_Time);
                                    if (checkBox4 != null) {
                                        i = R.id.title0;
                                        TextView textView = (TextView) view4.findViewById(R.id.title0);
                                        if (textView != null) {
                                            i = R.id.title1;
                                            TextView textView2 = (TextView) view4.findViewById(R.id.title1);
                                            if (textView2 != null) {
                                                i = R.id.view0;
                                                RelativeLayout relativeLayout = (RelativeLayout) view4.findViewById(R.id.view0);
                                                if (relativeLayout != null) {
                                                    i = R.id.view1;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view4.findViewById(R.id.view1);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.view2;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view4.findViewById(R.id.view2);
                                                        if (relativeLayout3 != null) {
                                                            i = R.id.view3;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) view4.findViewById(R.id.view3);
                                                            if (relativeLayout4 != null) {
                                                                return new LandroverFragmentTimeSetBinding((ConstraintLayout) view4, imageButton, imageButton2, imageButton3, imageButton4, checkBox, checkBox2, checkBox3, checkBox4, textView, textView2, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
