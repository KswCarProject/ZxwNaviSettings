package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720EvoId8FragmentSysSetUnitBinding implements ViewBinding {
    public final ImageButton btnDistanceUnitImperial;
    public final ImageButton btnDistanceUnitMetric;
    public final ImageButton btnOilUnitIUS;
    public final ImageButton btnOilUnitL;
    public final ImageButton btnOilUnitUK;
    public final CheckBox kesaiweiDistanceUnitImperial;
    public final CheckBox kesaiweiDistanceUnitMetric;
    public final CheckBox kesaiweiOilUnitL;
    public final CheckBox kesaiweiOilUnitUK;
    public final CheckBox kesaiweiOilUnitUS;
    public final ScrollView mScrollView;
    public final MyScrollbar myScrollbar;
    private final RelativeLayout rootView;
    public final LinearLayout scrollLayout;

    private Kesaiwei1920x720EvoId8FragmentSysSetUnitBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, ScrollView scrollView, MyScrollbar myScrollbar2, LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.btnDistanceUnitImperial = imageButton;
        this.btnDistanceUnitMetric = imageButton2;
        this.btnOilUnitIUS = imageButton3;
        this.btnOilUnitL = imageButton4;
        this.btnOilUnitUK = imageButton5;
        this.kesaiweiDistanceUnitImperial = checkBox;
        this.kesaiweiDistanceUnitMetric = checkBox2;
        this.kesaiweiOilUnitL = checkBox3;
        this.kesaiweiOilUnitUK = checkBox4;
        this.kesaiweiOilUnitUS = checkBox5;
        this.mScrollView = scrollView;
        this.myScrollbar = myScrollbar2;
        this.scrollLayout = linearLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetUnitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetUnitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_unit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetUnitBinding bind(View view) {
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
                                                i = R.id.mScrollView;
                                                ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mScrollView);
                                                if (scrollView != null) {
                                                    i = R.id.myScrollbar;
                                                    MyScrollbar myScrollbar2 = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
                                                    if (myScrollbar2 != null) {
                                                        i = R.id.scrollLayout;
                                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.scrollLayout);
                                                        if (linearLayout != null) {
                                                            return new Kesaiwei1920x720EvoId8FragmentSysSetUnitBinding((RelativeLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, scrollView, myScrollbar2, linearLayout);
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
