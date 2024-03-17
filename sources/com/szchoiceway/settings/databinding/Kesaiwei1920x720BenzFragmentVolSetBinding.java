package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.settings.view.MySeekbar1;

public final class Kesaiwei1920x720BenzFragmentVolSetBinding implements ViewBinding {
    public final Button KSWBtnEqClassical;
    public final Button KSWBtnEqCustom;
    public final Button KSWBtnEqDance;
    public final Button KSWBtnEqJazz;
    public final Button KSWBtnEqPop;
    public final Button KSWBtnEqRock;
    public final TextView KSWVolValueAlto;
    public final TextView KSWVolValueBass;
    public final TextView KSWVolValueTreble;
    public final CheckBox chkClassical;
    public final CheckBox chkDance;
    public final CheckBox chkJazz;
    public final CheckBox chkPop;
    public final CheckBox chkRock;
    public final CheckBox chkUser;
    public final MyScrollView mScrollView;
    public final MyScrollbar myScrollbar;
    public final MySeekbar1 mySeekbar1Alto;
    public final MySeekbar1 mySeekbar1Bass;
    public final MySeekbar1 mySeekbar1Treble;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollLayout;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;
    public final RelativeLayout view4;
    public final RelativeLayout view5;
    public final RelativeLayout view6;
    public final RelativeLayout view7;
    public final RelativeLayout view8;
    public final View viewKSWVolPage2Hight;
    public final View viewKSWVolPage2Low;
    public final View viewKSWVolPage2Mid;

    private Kesaiwei1920x720BenzFragmentVolSetBinding(RelativeLayout relativeLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, TextView textView, TextView textView2, TextView textView3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, MyScrollView myScrollView, MyScrollbar myScrollbar2, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, MySeekbar1 mySeekbar13, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, View view, View view9, View view10) {
        this.rootView = relativeLayout;
        this.KSWBtnEqClassical = button;
        this.KSWBtnEqCustom = button2;
        this.KSWBtnEqDance = button3;
        this.KSWBtnEqJazz = button4;
        this.KSWBtnEqPop = button5;
        this.KSWBtnEqRock = button6;
        this.KSWVolValueAlto = textView;
        this.KSWVolValueBass = textView2;
        this.KSWVolValueTreble = textView3;
        this.chkClassical = checkBox;
        this.chkDance = checkBox2;
        this.chkJazz = checkBox3;
        this.chkPop = checkBox4;
        this.chkRock = checkBox5;
        this.chkUser = checkBox6;
        this.mScrollView = myScrollView;
        this.myScrollbar = myScrollbar2;
        this.mySeekbar1Alto = mySeekbar1;
        this.mySeekbar1Bass = mySeekbar12;
        this.mySeekbar1Treble = mySeekbar13;
        this.scrollLayout = relativeLayout2;
        this.view0 = relativeLayout3;
        this.view1 = relativeLayout4;
        this.view2 = relativeLayout5;
        this.view3 = relativeLayout6;
        this.view4 = relativeLayout7;
        this.view5 = relativeLayout8;
        this.view6 = relativeLayout9;
        this.view7 = relativeLayout10;
        this.view8 = relativeLayout11;
        this.viewKSWVolPage2Hight = view;
        this.viewKSWVolPage2Low = view9;
        this.viewKSWVolPage2Mid = view10;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720BenzFragmentVolSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720BenzFragmentVolSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_vol_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720BenzFragmentVolSetBinding bind(View view) {
        View view9 = view;
        int i = R.id.KSW_btn_eq_classical;
        Button button = (Button) view9.findViewById(R.id.KSW_btn_eq_classical);
        if (button != null) {
            i = R.id.KSW_btn_eq_custom;
            Button button2 = (Button) view9.findViewById(R.id.KSW_btn_eq_custom);
            if (button2 != null) {
                i = R.id.KSW_btn_eq_dance;
                Button button3 = (Button) view9.findViewById(R.id.KSW_btn_eq_dance);
                if (button3 != null) {
                    i = R.id.KSW_btn_eq_jazz;
                    Button button4 = (Button) view9.findViewById(R.id.KSW_btn_eq_jazz);
                    if (button4 != null) {
                        i = R.id.KSW_btn_eq_pop;
                        Button button5 = (Button) view9.findViewById(R.id.KSW_btn_eq_pop);
                        if (button5 != null) {
                            i = R.id.KSW_btn_eq_rock;
                            Button button6 = (Button) view9.findViewById(R.id.KSW_btn_eq_rock);
                            if (button6 != null) {
                                i = R.id.KSW_VolValue_Alto;
                                TextView textView = (TextView) view9.findViewById(R.id.KSW_VolValue_Alto);
                                if (textView != null) {
                                    i = R.id.KSW_VolValue_Bass;
                                    TextView textView2 = (TextView) view9.findViewById(R.id.KSW_VolValue_Bass);
                                    if (textView2 != null) {
                                        i = R.id.KSW_VolValue_Treble;
                                        TextView textView3 = (TextView) view9.findViewById(R.id.KSW_VolValue_Treble);
                                        if (textView3 != null) {
                                            i = R.id.chkClassical;
                                            CheckBox checkBox = (CheckBox) view9.findViewById(R.id.chkClassical);
                                            if (checkBox != null) {
                                                i = R.id.chkDance;
                                                CheckBox checkBox2 = (CheckBox) view9.findViewById(R.id.chkDance);
                                                if (checkBox2 != null) {
                                                    i = R.id.chkJazz;
                                                    CheckBox checkBox3 = (CheckBox) view9.findViewById(R.id.chkJazz);
                                                    if (checkBox3 != null) {
                                                        i = R.id.chkPop;
                                                        CheckBox checkBox4 = (CheckBox) view9.findViewById(R.id.chkPop);
                                                        if (checkBox4 != null) {
                                                            i = R.id.chkRock;
                                                            CheckBox checkBox5 = (CheckBox) view9.findViewById(R.id.chkRock);
                                                            if (checkBox5 != null) {
                                                                i = R.id.chkUser;
                                                                CheckBox checkBox6 = (CheckBox) view9.findViewById(R.id.chkUser);
                                                                if (checkBox6 != null) {
                                                                    i = R.id.mScrollView;
                                                                    MyScrollView myScrollView = (MyScrollView) view9.findViewById(R.id.mScrollView);
                                                                    if (myScrollView != null) {
                                                                        i = R.id.myScrollbar;
                                                                        MyScrollbar myScrollbar2 = (MyScrollbar) view9.findViewById(R.id.myScrollbar);
                                                                        if (myScrollbar2 != null) {
                                                                            i = R.id.my_seekbar1_alto;
                                                                            MySeekbar1 mySeekbar1 = (MySeekbar1) view9.findViewById(R.id.my_seekbar1_alto);
                                                                            if (mySeekbar1 != null) {
                                                                                i = R.id.my_seekbar1_bass;
                                                                                MySeekbar1 mySeekbar12 = (MySeekbar1) view9.findViewById(R.id.my_seekbar1_bass);
                                                                                if (mySeekbar12 != null) {
                                                                                    i = R.id.my_seekbar1_treble;
                                                                                    MySeekbar1 mySeekbar13 = (MySeekbar1) view9.findViewById(R.id.my_seekbar1_treble);
                                                                                    if (mySeekbar13 != null) {
                                                                                        i = R.id.scrollLayout;
                                                                                        RelativeLayout relativeLayout = (RelativeLayout) view9.findViewById(R.id.scrollLayout);
                                                                                        if (relativeLayout != null) {
                                                                                            i = R.id.view0;
                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view9.findViewById(R.id.view0);
                                                                                            if (relativeLayout2 != null) {
                                                                                                i = R.id.view1;
                                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) view9.findViewById(R.id.view1);
                                                                                                if (relativeLayout3 != null) {
                                                                                                    i = R.id.view2;
                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) view9.findViewById(R.id.view2);
                                                                                                    if (relativeLayout4 != null) {
                                                                                                        i = R.id.view3;
                                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) view9.findViewById(R.id.view3);
                                                                                                        if (relativeLayout5 != null) {
                                                                                                            i = R.id.view4;
                                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) view9.findViewById(R.id.view4);
                                                                                                            if (relativeLayout6 != null) {
                                                                                                                i = R.id.view5;
                                                                                                                RelativeLayout relativeLayout7 = (RelativeLayout) view9.findViewById(R.id.view5);
                                                                                                                if (relativeLayout7 != null) {
                                                                                                                    i = R.id.view6;
                                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) view9.findViewById(R.id.view6);
                                                                                                                    if (relativeLayout8 != null) {
                                                                                                                        i = R.id.view7;
                                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) view9.findViewById(R.id.view7);
                                                                                                                        if (relativeLayout9 != null) {
                                                                                                                            i = R.id.view8;
                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) view9.findViewById(R.id.view8);
                                                                                                                            if (relativeLayout10 != null) {
                                                                                                                                i = R.id.viewKSW_Vol_page2_hight;
                                                                                                                                View findViewById = view9.findViewById(R.id.viewKSW_Vol_page2_hight);
                                                                                                                                if (findViewById != null) {
                                                                                                                                    i = R.id.viewKSW_Vol_page2_low;
                                                                                                                                    View findViewById2 = view9.findViewById(R.id.viewKSW_Vol_page2_low);
                                                                                                                                    if (findViewById2 != null) {
                                                                                                                                        i = R.id.viewKSW_Vol_page2_mid;
                                                                                                                                        View findViewById3 = view9.findViewById(R.id.viewKSW_Vol_page2_mid);
                                                                                                                                        if (findViewById3 != null) {
                                                                                                                                            return new Kesaiwei1920x720BenzFragmentVolSetBinding((RelativeLayout) view9, button, button2, button3, button4, button5, button6, textView, textView2, textView3, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, myScrollView, myScrollbar2, mySeekbar1, mySeekbar12, mySeekbar13, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, findViewById, findViewById2, findViewById3);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
