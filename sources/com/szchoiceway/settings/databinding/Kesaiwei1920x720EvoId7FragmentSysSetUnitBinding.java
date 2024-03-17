package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentSysSetUnitBinding implements ViewBinding {
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
    public final ImageView lineUnitDistance;
    public final ImageView lineUnitOil;
    public final ScrollView mScrollView;
    private final RelativeLayout rootView;
    public final TextView txtDistanceUnit;
    public final TextView txtOilUnit;
    public final TextView txtTempUnit;

    private Kesaiwei1920x720EvoId7FragmentSysSetUnitBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, ImageView imageView, ImageView imageView2, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3) {
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
        this.lineUnitDistance = imageView;
        this.lineUnitOil = imageView2;
        this.mScrollView = scrollView;
        this.txtDistanceUnit = textView;
        this.txtOilUnit = textView2;
        this.txtTempUnit = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetUnitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetUnitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_unit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetUnitBinding bind(View view) {
        View view2 = view;
        int i = R.id.btnDistanceUnitImperial;
        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btnDistanceUnitImperial);
        if (imageButton != null) {
            i = R.id.btnDistanceUnitMetric;
            ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btnDistanceUnitMetric);
            if (imageButton2 != null) {
                i = R.id.btnOilUnitIUS;
                ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnOilUnitIUS);
                if (imageButton3 != null) {
                    i = R.id.btnOilUnitL;
                    ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.btnOilUnitL);
                    if (imageButton4 != null) {
                        i = R.id.btnOilUnitUK;
                        ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.btnOilUnitUK);
                        if (imageButton5 != null) {
                            i = R.id.btnTempUnitC;
                            ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.btnTempUnitC);
                            if (imageButton6 != null) {
                                i = R.id.btnTempUnitF;
                                ImageButton imageButton7 = (ImageButton) view2.findViewById(R.id.btnTempUnitF);
                                if (imageButton7 != null) {
                                    i = R.id.kesaiwei_distance_UnitImperial;
                                    CheckBox checkBox = (CheckBox) view2.findViewById(R.id.kesaiwei_distance_UnitImperial);
                                    if (checkBox != null) {
                                        i = R.id.kesaiwei_distance_UnitMetric;
                                        CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.kesaiwei_distance_UnitMetric);
                                        if (checkBox2 != null) {
                                            i = R.id.kesaiwei_oil_UnitL;
                                            CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.kesaiwei_oil_UnitL);
                                            if (checkBox3 != null) {
                                                i = R.id.kesaiwei_oil_UnitUK;
                                                CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.kesaiwei_oil_UnitUK);
                                                if (checkBox4 != null) {
                                                    i = R.id.kesaiwei_oil_UnitUS;
                                                    CheckBox checkBox5 = (CheckBox) view2.findViewById(R.id.kesaiwei_oil_UnitUS);
                                                    if (checkBox5 != null) {
                                                        i = R.id.kesaiwei_temp_unitC;
                                                        CheckBox checkBox6 = (CheckBox) view2.findViewById(R.id.kesaiwei_temp_unitC);
                                                        if (checkBox6 != null) {
                                                            i = R.id.kesaiwei_temp_unitF;
                                                            CheckBox checkBox7 = (CheckBox) view2.findViewById(R.id.kesaiwei_temp_unitF);
                                                            if (checkBox7 != null) {
                                                                i = R.id.lineUnitDistance;
                                                                ImageView imageView = (ImageView) view2.findViewById(R.id.lineUnitDistance);
                                                                if (imageView != null) {
                                                                    i = R.id.lineUnitOil;
                                                                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.lineUnitOil);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.mScrollView;
                                                                        ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mScrollView);
                                                                        if (scrollView != null) {
                                                                            i = R.id.txtDistanceUnit;
                                                                            TextView textView = (TextView) view2.findViewById(R.id.txtDistanceUnit);
                                                                            if (textView != null) {
                                                                                i = R.id.txtOilUnit;
                                                                                TextView textView2 = (TextView) view2.findViewById(R.id.txtOilUnit);
                                                                                if (textView2 != null) {
                                                                                    i = R.id.txtTempUnit;
                                                                                    TextView textView3 = (TextView) view2.findViewById(R.id.txtTempUnit);
                                                                                    if (textView3 != null) {
                                                                                        return new Kesaiwei1920x720EvoId7FragmentSysSetUnitBinding((RelativeLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, imageView, imageView2, scrollView, textView, textView2, textView3);
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
