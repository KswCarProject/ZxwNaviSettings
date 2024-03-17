package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class SmallAudiFragmentTimeSetBinding implements ViewBinding {
    public final ImageButton btn12Hour;
    public final ImageButton btn24Hour;
    public final ImageButton btnAutoSync;
    public final ImageButton btnOriginalTime;
    public final TextView btnSys;
    public final CheckBox kesaiwei12Hour;
    public final CheckBox kesaiwei24Hour;
    public final CheckBox kesaiweiAutoSync;
    public final CheckBox kesaiweiOriginalTime;
    private final LinearLayoutCompat rootView;

    private SmallAudiFragmentTimeSetBinding(LinearLayoutCompat linearLayoutCompat, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, TextView textView, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4) {
        this.rootView = linearLayoutCompat;
        this.btn12Hour = imageButton;
        this.btn24Hour = imageButton2;
        this.btnAutoSync = imageButton3;
        this.btnOriginalTime = imageButton4;
        this.btnSys = textView;
        this.kesaiwei12Hour = checkBox;
        this.kesaiwei24Hour = checkBox2;
        this.kesaiweiAutoSync = checkBox3;
        this.kesaiweiOriginalTime = checkBox4;
    }

    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static SmallAudiFragmentTimeSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallAudiFragmentTimeSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_audi_fragment_time_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallAudiFragmentTimeSetBinding bind(View view) {
        int i = R.id.btn12Hour;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn12Hour);
        if (imageButton != null) {
            i = R.id.btn24Hour;
            ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btn24Hour);
            if (imageButton2 != null) {
                i = R.id.btnAutoSync;
                ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnAutoSync);
                if (imageButton3 != null) {
                    i = R.id.btnOriginalTime;
                    ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.btnOriginalTime);
                    if (imageButton4 != null) {
                        i = R.id.btnSys;
                        TextView textView = (TextView) view.findViewById(R.id.btnSys);
                        if (textView != null) {
                            i = R.id.kesaiwei_12_hour;
                            CheckBox checkBox = (CheckBox) view.findViewById(R.id.kesaiwei_12_hour);
                            if (checkBox != null) {
                                i = R.id.kesaiwei_24_hour;
                                CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.kesaiwei_24_hour);
                                if (checkBox2 != null) {
                                    i = R.id.kesaiwei_Auto_Sync;
                                    CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.kesaiwei_Auto_Sync);
                                    if (checkBox3 != null) {
                                        i = R.id.kesaiwei_Original_Time;
                                        CheckBox checkBox4 = (CheckBox) view.findViewById(R.id.kesaiwei_Original_Time);
                                        if (checkBox4 != null) {
                                            return new SmallAudiFragmentTimeSetBinding((LinearLayoutCompat) view, imageButton, imageButton2, imageButton3, imageButton4, textView, checkBox, checkBox2, checkBox3, checkBox4);
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
