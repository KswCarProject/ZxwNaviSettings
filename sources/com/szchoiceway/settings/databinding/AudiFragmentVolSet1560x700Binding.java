package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.settings.view.MySeekbar1;

public final class AudiFragmentVolSet1560x700Binding implements ViewBinding {
    public final ImageButton KSWBtnEqClassical;
    public final ImageButton KSWBtnEqCustom;
    public final ImageButton KSWBtnEqDance;
    public final ImageButton KSWBtnEqJazz;
    public final ImageButton KSWBtnEqPop;
    public final ImageButton KSWBtnEqRock;
    public final TextView KSWVolValueAlto;
    public final TextView KSWVolValueBass;
    public final TextView KSWVolValueTreble;
    public final CheckBox chkClassical;
    public final CheckBox chkDance;
    public final CheckBox chkJazz;
    public final CheckBox chkPop;
    public final CheckBox chkRock;
    public final CheckBox chkUser;
    public final ScrollView mScrollView;
    public final MyScrollbar myScrollbar;
    public final MySeekbar1 mySeekbar1Alto;
    public final MySeekbar1 mySeekbar1Bass;
    public final MySeekbar1 mySeekbar1Treble;
    private final ConstraintLayout rootView;
    public final LinearLayout scrollLayout;
    public final View viewKSWVolPage2Hight;
    public final View viewKSWVolPage2Low;
    public final View viewKSWVolPage2Mid;
    public final RelativeLayout viewUser;

    private AudiFragmentVolSet1560x700Binding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, TextView textView, TextView textView2, TextView textView3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, ScrollView scrollView, MyScrollbar myScrollbar2, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, MySeekbar1 mySeekbar13, LinearLayout linearLayout, View view, View view2, View view3, RelativeLayout relativeLayout) {
        this.rootView = constraintLayout;
        this.KSWBtnEqClassical = imageButton;
        this.KSWBtnEqCustom = imageButton2;
        this.KSWBtnEqDance = imageButton3;
        this.KSWBtnEqJazz = imageButton4;
        this.KSWBtnEqPop = imageButton5;
        this.KSWBtnEqRock = imageButton6;
        this.KSWVolValueAlto = textView;
        this.KSWVolValueBass = textView2;
        this.KSWVolValueTreble = textView3;
        this.chkClassical = checkBox;
        this.chkDance = checkBox2;
        this.chkJazz = checkBox3;
        this.chkPop = checkBox4;
        this.chkRock = checkBox5;
        this.chkUser = checkBox6;
        this.mScrollView = scrollView;
        this.myScrollbar = myScrollbar2;
        this.mySeekbar1Alto = mySeekbar1;
        this.mySeekbar1Bass = mySeekbar12;
        this.mySeekbar1Treble = mySeekbar13;
        this.scrollLayout = linearLayout;
        this.viewKSWVolPage2Hight = view;
        this.viewKSWVolPage2Low = view2;
        this.viewKSWVolPage2Mid = view3;
        this.viewUser = relativeLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AudiFragmentVolSet1560x700Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiFragmentVolSet1560x700Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_fragment_vol_set_1560x700, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiFragmentVolSet1560x700Binding bind(View view) {
        View view2 = view;
        int i = R.id.KSW_btn_eq_classical;
        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.KSW_btn_eq_classical);
        if (imageButton != null) {
            i = R.id.KSW_btn_eq_custom;
            ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.KSW_btn_eq_custom);
            if (imageButton2 != null) {
                i = R.id.KSW_btn_eq_dance;
                ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.KSW_btn_eq_dance);
                if (imageButton3 != null) {
                    i = R.id.KSW_btn_eq_jazz;
                    ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.KSW_btn_eq_jazz);
                    if (imageButton4 != null) {
                        i = R.id.KSW_btn_eq_pop;
                        ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.KSW_btn_eq_pop);
                        if (imageButton5 != null) {
                            i = R.id.KSW_btn_eq_rock;
                            ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.KSW_btn_eq_rock);
                            if (imageButton6 != null) {
                                i = R.id.KSW_VolValue_Alto;
                                TextView textView = (TextView) view2.findViewById(R.id.KSW_VolValue_Alto);
                                if (textView != null) {
                                    i = R.id.KSW_VolValue_Bass;
                                    TextView textView2 = (TextView) view2.findViewById(R.id.KSW_VolValue_Bass);
                                    if (textView2 != null) {
                                        i = R.id.KSW_VolValue_Treble;
                                        TextView textView3 = (TextView) view2.findViewById(R.id.KSW_VolValue_Treble);
                                        if (textView3 != null) {
                                            i = R.id.chkClassical;
                                            CheckBox checkBox = (CheckBox) view2.findViewById(R.id.chkClassical);
                                            if (checkBox != null) {
                                                i = R.id.chkDance;
                                                CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.chkDance);
                                                if (checkBox2 != null) {
                                                    i = R.id.chkJazz;
                                                    CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.chkJazz);
                                                    if (checkBox3 != null) {
                                                        i = R.id.chkPop;
                                                        CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.chkPop);
                                                        if (checkBox4 != null) {
                                                            i = R.id.chkRock;
                                                            CheckBox checkBox5 = (CheckBox) view2.findViewById(R.id.chkRock);
                                                            if (checkBox5 != null) {
                                                                i = R.id.chkUser;
                                                                CheckBox checkBox6 = (CheckBox) view2.findViewById(R.id.chkUser);
                                                                if (checkBox6 != null) {
                                                                    i = R.id.mScrollView;
                                                                    ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mScrollView);
                                                                    if (scrollView != null) {
                                                                        i = R.id.myScrollbar;
                                                                        MyScrollbar myScrollbar2 = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
                                                                        if (myScrollbar2 != null) {
                                                                            i = R.id.my_seekbar1_alto;
                                                                            MySeekbar1 mySeekbar1 = (MySeekbar1) view2.findViewById(R.id.my_seekbar1_alto);
                                                                            if (mySeekbar1 != null) {
                                                                                i = R.id.my_seekbar1_bass;
                                                                                MySeekbar1 mySeekbar12 = (MySeekbar1) view2.findViewById(R.id.my_seekbar1_bass);
                                                                                if (mySeekbar12 != null) {
                                                                                    i = R.id.my_seekbar1_treble;
                                                                                    MySeekbar1 mySeekbar13 = (MySeekbar1) view2.findViewById(R.id.my_seekbar1_treble);
                                                                                    if (mySeekbar13 != null) {
                                                                                        i = R.id.scrollLayout;
                                                                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.scrollLayout);
                                                                                        if (linearLayout != null) {
                                                                                            i = R.id.viewKSW_Vol_page2_hight;
                                                                                            View findViewById = view2.findViewById(R.id.viewKSW_Vol_page2_hight);
                                                                                            if (findViewById != null) {
                                                                                                i = R.id.viewKSW_Vol_page2_low;
                                                                                                View findViewById2 = view2.findViewById(R.id.viewKSW_Vol_page2_low);
                                                                                                if (findViewById2 != null) {
                                                                                                    i = R.id.viewKSW_Vol_page2_mid;
                                                                                                    View findViewById3 = view2.findViewById(R.id.viewKSW_Vol_page2_mid);
                                                                                                    if (findViewById3 != null) {
                                                                                                        i = R.id.viewUser;
                                                                                                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.viewUser);
                                                                                                        if (relativeLayout != null) {
                                                                                                            return new AudiFragmentVolSet1560x700Binding((ConstraintLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, textView, textView2, textView3, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, scrollView, myScrollbar2, mySeekbar1, mySeekbar12, mySeekbar13, linearLayout, findViewById, findViewById2, findViewById3, relativeLayout);
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
