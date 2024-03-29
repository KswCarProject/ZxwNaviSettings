package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class PempId7FragmentSysSetUnitBinding implements ViewBinding {
    public final ImageButton btnDistanceUnitImperial;
    public final ImageButton btnDistanceUnitMetric;
    public final ImageButton btnOilUnitIUS;
    public final ImageButton btnOilUnitL;
    public final ImageButton btnOilUnitUK;
    public final ImageButton btnTempUnitC;
    public final ImageButton btnTempUnitF;
    public final CheckBox kesaiweiDistanceUnitImperial;
    public final CheckBox kesaiweiDistanceUnitMetric;
    public final CheckBox kesaiweiOilUnitL;
    public final CheckBox kesaiweiOilUnitUK;
    public final CheckBox kesaiweiOilUnitUS;
    public final CheckBox kesaiweiTempUnitC;
    public final CheckBox kesaiweiTempUnitF;
    public final ScrollView mScrollView;
    private final RelativeLayout rootView;
    public final TextView txtDistanceUnit;
    public final TextView txtOilUnit;
    public final TextView txtTempUnit;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;
    public final RelativeLayout view4;
    public final RelativeLayout view5;

    private PempId7FragmentSysSetUnitBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7) {
        this.rootView = relativeLayout;
        this.btnDistanceUnitImperial = imageButton;
        this.btnDistanceUnitMetric = imageButton2;
        this.btnOilUnitIUS = imageButton3;
        this.btnOilUnitL = imageButton4;
        this.btnOilUnitUK = imageButton5;
        this.btnTempUnitC = imageButton6;
        this.btnTempUnitF = imageButton7;
        this.kesaiweiDistanceUnitImperial = checkBox;
        this.kesaiweiDistanceUnitMetric = checkBox2;
        this.kesaiweiOilUnitL = checkBox3;
        this.kesaiweiOilUnitUK = checkBox4;
        this.kesaiweiOilUnitUS = checkBox5;
        this.kesaiweiTempUnitC = checkBox6;
        this.kesaiweiTempUnitF = checkBox7;
        this.mScrollView = scrollView;
        this.txtDistanceUnit = textView;
        this.txtOilUnit = textView2;
        this.txtTempUnit = textView3;
        this.view0 = relativeLayout2;
        this.view1 = relativeLayout3;
        this.view2 = relativeLayout4;
        this.view3 = relativeLayout5;
        this.view4 = relativeLayout6;
        this.view5 = relativeLayout7;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PempId7FragmentSysSetUnitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PempId7FragmentSysSetUnitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_unit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PempId7FragmentSysSetUnitBinding bind(View view) {
        View view6 = view;
        int i = R.id.btnDistanceUnitImperial;
        ImageButton imageButton = (ImageButton) view6.findViewById(R.id.btnDistanceUnitImperial);
        if (imageButton != null) {
            i = R.id.btnDistanceUnitMetric;
            ImageButton imageButton2 = (ImageButton) view6.findViewById(R.id.btnDistanceUnitMetric);
            if (imageButton2 != null) {
                i = R.id.btnOilUnitIUS;
                ImageButton imageButton3 = (ImageButton) view6.findViewById(R.id.btnOilUnitIUS);
                if (imageButton3 != null) {
                    i = R.id.btnOilUnitL;
                    ImageButton imageButton4 = (ImageButton) view6.findViewById(R.id.btnOilUnitL);
                    if (imageButton4 != null) {
                        i = R.id.btnOilUnitUK;
                        ImageButton imageButton5 = (ImageButton) view6.findViewById(R.id.btnOilUnitUK);
                        if (imageButton5 != null) {
                            i = R.id.btnTempUnitC;
                            ImageButton imageButton6 = (ImageButton) view6.findViewById(R.id.btnTempUnitC);
                            if (imageButton6 != null) {
                                i = R.id.btnTempUnitF;
                                ImageButton imageButton7 = (ImageButton) view6.findViewById(R.id.btnTempUnitF);
                                if (imageButton7 != null) {
                                    i = R.id.kesaiwei_distance_UnitImperial;
                                    CheckBox checkBox = (CheckBox) view6.findViewById(R.id.kesaiwei_distance_UnitImperial);
                                    if (checkBox != null) {
                                        i = R.id.kesaiwei_distance_UnitMetric;
                                        CheckBox checkBox2 = (CheckBox) view6.findViewById(R.id.kesaiwei_distance_UnitMetric);
                                        if (checkBox2 != null) {
                                            i = R.id.kesaiwei_oil_UnitL;
                                            CheckBox checkBox3 = (CheckBox) view6.findViewById(R.id.kesaiwei_oil_UnitL);
                                            if (checkBox3 != null) {
                                                i = R.id.kesaiwei_oil_UnitUK;
                                                CheckBox checkBox4 = (CheckBox) view6.findViewById(R.id.kesaiwei_oil_UnitUK);
                                                if (checkBox4 != null) {
                                                    i = R.id.kesaiwei_oil_UnitUS;
                                                    CheckBox checkBox5 = (CheckBox) view6.findViewById(R.id.kesaiwei_oil_UnitUS);
                                                    if (checkBox5 != null) {
                                                        i = R.id.kesaiwei_temp_unitC;
                                                        CheckBox checkBox6 = (CheckBox) view6.findViewById(R.id.kesaiwei_temp_unitC);
                                                        if (checkBox6 != null) {
                                                            i = R.id.kesaiwei_temp_unitF;
                                                            CheckBox checkBox7 = (CheckBox) view6.findViewById(R.id.kesaiwei_temp_unitF);
                                                            if (checkBox7 != null) {
                                                                i = R.id.mScrollView;
                                                                ScrollView scrollView = (ScrollView) view6.findViewById(R.id.mScrollView);
                                                                if (scrollView != null) {
                                                                    i = R.id.txtDistanceUnit;
                                                                    TextView textView = (TextView) view6.findViewById(R.id.txtDistanceUnit);
                                                                    if (textView != null) {
                                                                        i = R.id.txtOilUnit;
                                                                        TextView textView2 = (TextView) view6.findViewById(R.id.txtOilUnit);
                                                                        if (textView2 != null) {
                                                                            i = R.id.txtTempUnit;
                                                                            TextView textView3 = (TextView) view6.findViewById(R.id.txtTempUnit);
                                                                            if (textView3 != null) {
                                                                                i = R.id.view0;
                                                                                RelativeLayout relativeLayout = (RelativeLayout) view6.findViewById(R.id.view0);
                                                                                if (relativeLayout != null) {
                                                                                    i = R.id.view1;
                                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view6.findViewById(R.id.view1);
                                                                                    if (relativeLayout2 != null) {
                                                                                        i = R.id.view2;
                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view6.findViewById(R.id.view2);
                                                                                        if (relativeLayout3 != null) {
                                                                                            i = R.id.view3;
                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) view6.findViewById(R.id.view3);
                                                                                            if (relativeLayout4 != null) {
                                                                                                i = R.id.view4;
                                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) view6.findViewById(R.id.view4);
                                                                                                if (relativeLayout5 != null) {
                                                                                                    i = R.id.view5;
                                                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) view6.findViewById(R.id.view5);
                                                                                                    if (relativeLayout6 != null) {
                                                                                                        return new PempId7FragmentSysSetUnitBinding((RelativeLayout) view6, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, scrollView, textView, textView2, textView3, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6);
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
