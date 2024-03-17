package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720LexusFragmentSysSetUnitBinding implements ViewBinding {
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
    public final MyScrollbar myScrollbar;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollLayout;
    public final RelativeLayout title0;
    public final RelativeLayout title1;
    public final RelativeLayout title2;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;
    public final RelativeLayout view4;
    public final RelativeLayout view5;
    public final RelativeLayout view6;

    private Kesaiwei1920x720LexusFragmentSysSetUnitBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, ScrollView scrollView, MyScrollbar myScrollbar2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, RelativeLayout relativeLayout12) {
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
        this.myScrollbar = myScrollbar2;
        this.scrollLayout = relativeLayout2;
        this.title0 = relativeLayout3;
        this.title1 = relativeLayout4;
        this.title2 = relativeLayout5;
        this.view0 = relativeLayout6;
        this.view1 = relativeLayout7;
        this.view2 = relativeLayout8;
        this.view3 = relativeLayout9;
        this.view4 = relativeLayout10;
        this.view5 = relativeLayout11;
        this.view6 = relativeLayout12;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720LexusFragmentSysSetUnitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetUnitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_unit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720LexusFragmentSysSetUnitBinding bind(View view) {
        View view7 = view;
        int i = R.id.btnDistanceUnitImperial;
        ImageButton imageButton = (ImageButton) view7.findViewById(R.id.btnDistanceUnitImperial);
        if (imageButton != null) {
            i = R.id.btnDistanceUnitMetric;
            ImageButton imageButton2 = (ImageButton) view7.findViewById(R.id.btnDistanceUnitMetric);
            if (imageButton2 != null) {
                i = R.id.btnOilUnitIUS;
                ImageButton imageButton3 = (ImageButton) view7.findViewById(R.id.btnOilUnitIUS);
                if (imageButton3 != null) {
                    i = R.id.btnOilUnitL;
                    ImageButton imageButton4 = (ImageButton) view7.findViewById(R.id.btnOilUnitL);
                    if (imageButton4 != null) {
                        i = R.id.btnOilUnitUK;
                        ImageButton imageButton5 = (ImageButton) view7.findViewById(R.id.btnOilUnitUK);
                        if (imageButton5 != null) {
                            i = R.id.btnTempUnitC;
                            ImageButton imageButton6 = (ImageButton) view7.findViewById(R.id.btnTempUnitC);
                            if (imageButton6 != null) {
                                i = R.id.btnTempUnitF;
                                ImageButton imageButton7 = (ImageButton) view7.findViewById(R.id.btnTempUnitF);
                                if (imageButton7 != null) {
                                    i = R.id.kesaiwei_distance_UnitImperial;
                                    CheckBox checkBox = (CheckBox) view7.findViewById(R.id.kesaiwei_distance_UnitImperial);
                                    if (checkBox != null) {
                                        i = R.id.kesaiwei_distance_UnitMetric;
                                        CheckBox checkBox2 = (CheckBox) view7.findViewById(R.id.kesaiwei_distance_UnitMetric);
                                        if (checkBox2 != null) {
                                            i = R.id.kesaiwei_oil_UnitL;
                                            CheckBox checkBox3 = (CheckBox) view7.findViewById(R.id.kesaiwei_oil_UnitL);
                                            if (checkBox3 != null) {
                                                i = R.id.kesaiwei_oil_UnitUK;
                                                CheckBox checkBox4 = (CheckBox) view7.findViewById(R.id.kesaiwei_oil_UnitUK);
                                                if (checkBox4 != null) {
                                                    i = R.id.kesaiwei_oil_UnitUS;
                                                    CheckBox checkBox5 = (CheckBox) view7.findViewById(R.id.kesaiwei_oil_UnitUS);
                                                    if (checkBox5 != null) {
                                                        i = R.id.kesaiwei_temp_unitC;
                                                        CheckBox checkBox6 = (CheckBox) view7.findViewById(R.id.kesaiwei_temp_unitC);
                                                        if (checkBox6 != null) {
                                                            i = R.id.kesaiwei_temp_unitF;
                                                            CheckBox checkBox7 = (CheckBox) view7.findViewById(R.id.kesaiwei_temp_unitF);
                                                            if (checkBox7 != null) {
                                                                i = R.id.mScrollView;
                                                                ScrollView scrollView = (ScrollView) view7.findViewById(R.id.mScrollView);
                                                                if (scrollView != null) {
                                                                    i = R.id.myScrollbar;
                                                                    MyScrollbar myScrollbar2 = (MyScrollbar) view7.findViewById(R.id.myScrollbar);
                                                                    if (myScrollbar2 != null) {
                                                                        i = R.id.scrollLayout;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) view7.findViewById(R.id.scrollLayout);
                                                                        if (relativeLayout != null) {
                                                                            i = R.id.title0;
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view7.findViewById(R.id.title0);
                                                                            if (relativeLayout2 != null) {
                                                                                i = R.id.title1;
                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) view7.findViewById(R.id.title1);
                                                                                if (relativeLayout3 != null) {
                                                                                    i = R.id.title2;
                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) view7.findViewById(R.id.title2);
                                                                                    if (relativeLayout4 != null) {
                                                                                        i = R.id.view0;
                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) view7.findViewById(R.id.view0);
                                                                                        if (relativeLayout5 != null) {
                                                                                            i = R.id.view1;
                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) view7.findViewById(R.id.view1);
                                                                                            if (relativeLayout6 != null) {
                                                                                                i = R.id.view2;
                                                                                                RelativeLayout relativeLayout7 = (RelativeLayout) view7.findViewById(R.id.view2);
                                                                                                if (relativeLayout7 != null) {
                                                                                                    i = R.id.view3;
                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) view7.findViewById(R.id.view3);
                                                                                                    if (relativeLayout8 != null) {
                                                                                                        i = R.id.view4;
                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) view7.findViewById(R.id.view4);
                                                                                                        if (relativeLayout9 != null) {
                                                                                                            i = R.id.view5;
                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) view7.findViewById(R.id.view5);
                                                                                                            if (relativeLayout10 != null) {
                                                                                                                i = R.id.view6;
                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) view7.findViewById(R.id.view6);
                                                                                                                if (relativeLayout11 != null) {
                                                                                                                    return new Kesaiwei1920x720LexusFragmentSysSetUnitBinding((RelativeLayout) view7, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, scrollView, myScrollbar2, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, relativeLayout11);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
