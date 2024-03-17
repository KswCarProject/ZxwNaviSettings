package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class AudiFragmentTimeSet1560x700Binding implements ViewBinding {
    public final ImageButton btn12Hour;
    public final ImageButton btn24Hour;
    public final ImageButton btnAutoSync;
    public final ImageButton btnOriginalTime;
    public final Button btnSyc;
    public final Button btnSys;
    public final CheckBox kesaiwei12Hour;
    public final CheckBox kesaiwei24Hour;
    public final CheckBox kesaiweiAutoSync;
    public final CheckBox kesaiweiOriginalTime;
    private final ConstraintLayout rootView;
    public final RelativeLayout viewSyc;
    public final RelativeLayout viewSys;

    private AudiFragmentTimeSet1560x700Binding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, Button button, Button button2, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
        this.rootView = constraintLayout;
        this.btn12Hour = imageButton;
        this.btn24Hour = imageButton2;
        this.btnAutoSync = imageButton3;
        this.btnOriginalTime = imageButton4;
        this.btnSyc = button;
        this.btnSys = button2;
        this.kesaiwei12Hour = checkBox;
        this.kesaiwei24Hour = checkBox2;
        this.kesaiweiAutoSync = checkBox3;
        this.kesaiweiOriginalTime = checkBox4;
        this.viewSyc = relativeLayout;
        this.viewSys = relativeLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AudiFragmentTimeSet1560x700Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiFragmentTimeSet1560x700Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_fragment_time_set_1560x700, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiFragmentTimeSet1560x700Binding bind(View view) {
        View view2 = view;
        int i = R.id.btn12Hour;
        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btn12Hour);
        if (imageButton != null) {
            i = R.id.btn24Hour;
            ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btn24Hour);
            if (imageButton2 != null) {
                i = R.id.btnAutoSync;
                ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnAutoSync);
                if (imageButton3 != null) {
                    i = R.id.btnOriginalTime;
                    ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.btnOriginalTime);
                    if (imageButton4 != null) {
                        i = R.id.btnSyc;
                        Button button = (Button) view2.findViewById(R.id.btnSyc);
                        if (button != null) {
                            i = R.id.btnSys;
                            Button button2 = (Button) view2.findViewById(R.id.btnSys);
                            if (button2 != null) {
                                i = R.id.kesaiwei_12_hour;
                                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.kesaiwei_12_hour);
                                if (checkBox != null) {
                                    i = R.id.kesaiwei_24_hour;
                                    CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.kesaiwei_24_hour);
                                    if (checkBox2 != null) {
                                        i = R.id.kesaiwei_Auto_Sync;
                                        CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.kesaiwei_Auto_Sync);
                                        if (checkBox3 != null) {
                                            i = R.id.kesaiwei_Original_Time;
                                            CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.kesaiwei_Original_Time);
                                            if (checkBox4 != null) {
                                                i = R.id.viewSyc;
                                                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.viewSyc);
                                                if (relativeLayout != null) {
                                                    i = R.id.viewSys;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.viewSys);
                                                    if (relativeLayout2 != null) {
                                                        return new AudiFragmentTimeSet1560x700Binding((ConstraintLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, button, button2, checkBox, checkBox2, checkBox3, checkBox4, relativeLayout, relativeLayout2);
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
