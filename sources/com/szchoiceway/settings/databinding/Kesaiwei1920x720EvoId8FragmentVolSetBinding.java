package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.settings.view.MySeekbar1;
import com.szchoiceway.settings.view.MySeekbar2;

public final class Kesaiwei1920x720EvoId8FragmentVolSetBinding implements ViewBinding {
    public final Button KSWBtnEqClassical;
    public final Button KSWBtnEqCustom;
    public final Button KSWBtnEqDance;
    public final Button KSWBtnEqJazz;
    public final Button KSWBtnEqPop;
    public final Button KSWBtnEqRock;
    public final TextView KSWVolVal00;
    public final TextView KSWVolVal01;
    public final TextView KSWVolVal03;
    public final TextView KSWVolVal04;
    public final TextView KSWVolValueAlto;
    public final TextView KSWVolValueBass;
    public final TextView KSWVolValueTreble;
    public final ImageButton btnAdd0;
    public final ImageButton btnAdd1;
    public final ImageButton btnAdd3;
    public final ImageButton btnAdd4;
    public final ImageButton btnAddAlto;
    public final ImageButton btnAddBass;
    public final ImageButton btnAddTreble;
    public final ImageButton btnReduce0;
    public final ImageButton btnReduce1;
    public final ImageButton btnReduce3;
    public final ImageButton btnReduce4;
    public final ImageButton btnReduceAlto;
    public final ImageButton btnReduceBass;
    public final ImageButton btnReduceTreble;
    public final ImageButton btnReturn;
    public final CheckBox chkClassical;
    public final CheckBox chkDance;
    public final CheckBox chkJazz;
    public final CheckBox chkPop;
    public final CheckBox chkRock;
    public final CheckBox chkUser;
    public final ImageView imgDirection;
    public final ImageView imgLeftBg;
    public final ImageView imgRightBg;
    public final ImageView imgRightIcon;
    public final ImageView imgUser;
    public final MyScrollbar myScrollbar;
    public final MySeekbar1 mySeekbar100;
    public final MySeekbar1 mySeekbar101;
    public final MySeekbar1 mySeekbar103;
    public final MySeekbar1 mySeekbar104;
    public final MySeekbar2 mySeekbar2Alto;
    public final MySeekbar2 mySeekbar2Bass;
    public final MySeekbar2 mySeekbar2Treble;
    public final RadioButton rbAndroid;
    public final RadioButton rbOem;
    public final RadioButton rbSound;
    private final RelativeLayout rootView;
    public final ScrollView scSound;
    public final LinearLayout scrollLayout;
    public final RelativeLayout viewAndroid;
    public final LinearLayout viewMain;
    public final RelativeLayout viewOem;
    public final LinearLayout viewOther;
    public final RelativeLayout viewSound;
    public final View viewSoundSeekBar0;
    public final View viewSoundSeekBar1;
    public final View viewSoundSeekBar2;
    public final View viewSoundSeekBar3;
    public final View viewSoundSeekBar4;
    public final View viewSoundSeekBar5;
    public final View viewSoundSeekBar6;
    public final RelativeLayout viewUser;

    private Kesaiwei1920x720EvoId8FragmentVolSetBinding(RelativeLayout relativeLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, ImageButton imageButton12, ImageButton imageButton13, ImageButton imageButton14, ImageButton imageButton15, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, MyScrollbar myScrollbar2, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, MySeekbar1 mySeekbar13, MySeekbar1 mySeekbar14, MySeekbar2 mySeekbar2, MySeekbar2 mySeekbar22, MySeekbar2 mySeekbar23, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, ScrollView scrollView, LinearLayout linearLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout3, RelativeLayout relativeLayout4, View view, View view2, View view3, View view4, View view5, View view6, View view7, RelativeLayout relativeLayout5) {
        this.rootView = relativeLayout;
        this.KSWBtnEqClassical = button;
        this.KSWBtnEqCustom = button2;
        this.KSWBtnEqDance = button3;
        this.KSWBtnEqJazz = button4;
        this.KSWBtnEqPop = button5;
        this.KSWBtnEqRock = button6;
        this.KSWVolVal00 = textView;
        this.KSWVolVal01 = textView2;
        this.KSWVolVal03 = textView3;
        this.KSWVolVal04 = textView4;
        this.KSWVolValueAlto = textView5;
        this.KSWVolValueBass = textView6;
        this.KSWVolValueTreble = textView7;
        this.btnAdd0 = imageButton;
        this.btnAdd1 = imageButton2;
        this.btnAdd3 = imageButton3;
        this.btnAdd4 = imageButton4;
        this.btnAddAlto = imageButton5;
        this.btnAddBass = imageButton6;
        this.btnAddTreble = imageButton7;
        this.btnReduce0 = imageButton8;
        this.btnReduce1 = imageButton9;
        this.btnReduce3 = imageButton10;
        this.btnReduce4 = imageButton11;
        this.btnReduceAlto = imageButton12;
        this.btnReduceBass = imageButton13;
        this.btnReduceTreble = imageButton14;
        this.btnReturn = imageButton15;
        this.chkClassical = checkBox;
        this.chkDance = checkBox2;
        this.chkJazz = checkBox3;
        this.chkPop = checkBox4;
        this.chkRock = checkBox5;
        this.chkUser = checkBox6;
        this.imgDirection = imageView;
        this.imgLeftBg = imageView2;
        this.imgRightBg = imageView3;
        this.imgRightIcon = imageView4;
        this.imgUser = imageView5;
        this.myScrollbar = myScrollbar2;
        this.mySeekbar100 = mySeekbar1;
        this.mySeekbar101 = mySeekbar12;
        this.mySeekbar103 = mySeekbar13;
        this.mySeekbar104 = mySeekbar14;
        this.mySeekbar2Alto = mySeekbar2;
        this.mySeekbar2Bass = mySeekbar22;
        this.mySeekbar2Treble = mySeekbar23;
        this.rbAndroid = radioButton;
        this.rbOem = radioButton2;
        this.rbSound = radioButton3;
        this.scSound = scrollView;
        this.scrollLayout = linearLayout;
        this.viewAndroid = relativeLayout2;
        this.viewMain = linearLayout2;
        this.viewOem = relativeLayout3;
        this.viewOther = linearLayout3;
        this.viewSound = relativeLayout4;
        this.viewSoundSeekBar0 = view;
        this.viewSoundSeekBar1 = view2;
        this.viewSoundSeekBar2 = view3;
        this.viewSoundSeekBar3 = view4;
        this.viewSoundSeekBar4 = view5;
        this.viewSoundSeekBar5 = view6;
        this.viewSoundSeekBar6 = view7;
        this.viewUser = relativeLayout5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentVolSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentVolSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_vol_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentVolSetBinding bind(View view) {
        View view2 = view;
        int i = R.id.KSW_btn_eq_classical;
        Button button = (Button) view2.findViewById(R.id.KSW_btn_eq_classical);
        if (button != null) {
            i = R.id.KSW_btn_eq_custom;
            Button button2 = (Button) view2.findViewById(R.id.KSW_btn_eq_custom);
            if (button2 != null) {
                i = R.id.KSW_btn_eq_dance;
                Button button3 = (Button) view2.findViewById(R.id.KSW_btn_eq_dance);
                if (button3 != null) {
                    i = R.id.KSW_btn_eq_jazz;
                    Button button4 = (Button) view2.findViewById(R.id.KSW_btn_eq_jazz);
                    if (button4 != null) {
                        i = R.id.KSW_btn_eq_pop;
                        Button button5 = (Button) view2.findViewById(R.id.KSW_btn_eq_pop);
                        if (button5 != null) {
                            i = R.id.KSW_btn_eq_rock;
                            Button button6 = (Button) view2.findViewById(R.id.KSW_btn_eq_rock);
                            if (button6 != null) {
                                i = R.id.KSW_Vol_val_00;
                                TextView textView = (TextView) view2.findViewById(R.id.KSW_Vol_val_00);
                                if (textView != null) {
                                    i = R.id.KSW_Vol_val_01;
                                    TextView textView2 = (TextView) view2.findViewById(R.id.KSW_Vol_val_01);
                                    if (textView2 != null) {
                                        i = R.id.KSW_Vol_val_03;
                                        TextView textView3 = (TextView) view2.findViewById(R.id.KSW_Vol_val_03);
                                        if (textView3 != null) {
                                            i = R.id.KSW_Vol_val_04;
                                            TextView textView4 = (TextView) view2.findViewById(R.id.KSW_Vol_val_04);
                                            if (textView4 != null) {
                                                i = R.id.KSW_VolValue_Alto;
                                                TextView textView5 = (TextView) view2.findViewById(R.id.KSW_VolValue_Alto);
                                                if (textView5 != null) {
                                                    i = R.id.KSW_VolValue_Bass;
                                                    TextView textView6 = (TextView) view2.findViewById(R.id.KSW_VolValue_Bass);
                                                    if (textView6 != null) {
                                                        i = R.id.KSW_VolValue_Treble;
                                                        TextView textView7 = (TextView) view2.findViewById(R.id.KSW_VolValue_Treble);
                                                        if (textView7 != null) {
                                                            i = R.id.btnAdd0;
                                                            ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btnAdd0);
                                                            if (imageButton != null) {
                                                                i = R.id.btnAdd1;
                                                                ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btnAdd1);
                                                                if (imageButton2 != null) {
                                                                    i = R.id.btnAdd3;
                                                                    ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnAdd3);
                                                                    if (imageButton3 != null) {
                                                                        i = R.id.btnAdd4;
                                                                        ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.btnAdd4);
                                                                        if (imageButton4 != null) {
                                                                            i = R.id.btnAddAlto;
                                                                            ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.btnAddAlto);
                                                                            if (imageButton5 != null) {
                                                                                i = R.id.btnAddBass;
                                                                                ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.btnAddBass);
                                                                                if (imageButton6 != null) {
                                                                                    i = R.id.btnAddTreble;
                                                                                    ImageButton imageButton7 = (ImageButton) view2.findViewById(R.id.btnAddTreble);
                                                                                    if (imageButton7 != null) {
                                                                                        i = R.id.btnReduce0;
                                                                                        ImageButton imageButton8 = (ImageButton) view2.findViewById(R.id.btnReduce0);
                                                                                        if (imageButton8 != null) {
                                                                                            i = R.id.btnReduce1;
                                                                                            ImageButton imageButton9 = (ImageButton) view2.findViewById(R.id.btnReduce1);
                                                                                            if (imageButton9 != null) {
                                                                                                i = R.id.btnReduce3;
                                                                                                ImageButton imageButton10 = (ImageButton) view2.findViewById(R.id.btnReduce3);
                                                                                                if (imageButton10 != null) {
                                                                                                    i = R.id.btnReduce4;
                                                                                                    ImageButton imageButton11 = (ImageButton) view2.findViewById(R.id.btnReduce4);
                                                                                                    if (imageButton11 != null) {
                                                                                                        i = R.id.btnReduceAlto;
                                                                                                        ImageButton imageButton12 = (ImageButton) view2.findViewById(R.id.btnReduceAlto);
                                                                                                        if (imageButton12 != null) {
                                                                                                            i = R.id.btnReduceBass;
                                                                                                            ImageButton imageButton13 = (ImageButton) view2.findViewById(R.id.btnReduceBass);
                                                                                                            if (imageButton13 != null) {
                                                                                                                i = R.id.btnReduceTreble;
                                                                                                                ImageButton imageButton14 = (ImageButton) view2.findViewById(R.id.btnReduceTreble);
                                                                                                                if (imageButton14 != null) {
                                                                                                                    i = R.id.btnReturn;
                                                                                                                    ImageButton imageButton15 = (ImageButton) view2.findViewById(R.id.btnReturn);
                                                                                                                    if (imageButton15 != null) {
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
                                                                                                                                                i = R.id.imgDirection;
                                                                                                                                                ImageView imageView = (ImageView) view2.findViewById(R.id.imgDirection);
                                                                                                                                                if (imageView != null) {
                                                                                                                                                    i = R.id.imgLeftBg;
                                                                                                                                                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.imgLeftBg);
                                                                                                                                                    if (imageView2 != null) {
                                                                                                                                                        i = R.id.imgRightBg;
                                                                                                                                                        ImageView imageView3 = (ImageView) view2.findViewById(R.id.imgRightBg);
                                                                                                                                                        if (imageView3 != null) {
                                                                                                                                                            i = R.id.imgRightIcon;
                                                                                                                                                            ImageView imageView4 = (ImageView) view2.findViewById(R.id.imgRightIcon);
                                                                                                                                                            if (imageView4 != null) {
                                                                                                                                                                i = R.id.imgUser;
                                                                                                                                                                ImageView imageView5 = (ImageView) view2.findViewById(R.id.imgUser);
                                                                                                                                                                if (imageView5 != null) {
                                                                                                                                                                    i = R.id.myScrollbar;
                                                                                                                                                                    MyScrollbar myScrollbar2 = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
                                                                                                                                                                    if (myScrollbar2 != null) {
                                                                                                                                                                        i = R.id.my_seekbar1_00;
                                                                                                                                                                        MySeekbar1 mySeekbar1 = (MySeekbar1) view2.findViewById(R.id.my_seekbar1_00);
                                                                                                                                                                        if (mySeekbar1 != null) {
                                                                                                                                                                            i = R.id.my_seekbar1_01;
                                                                                                                                                                            MySeekbar1 mySeekbar12 = (MySeekbar1) view2.findViewById(R.id.my_seekbar1_01);
                                                                                                                                                                            if (mySeekbar12 != null) {
                                                                                                                                                                                i = R.id.my_seekbar1_03;
                                                                                                                                                                                MySeekbar1 mySeekbar13 = (MySeekbar1) view2.findViewById(R.id.my_seekbar1_03);
                                                                                                                                                                                if (mySeekbar13 != null) {
                                                                                                                                                                                    i = R.id.my_seekbar1_04;
                                                                                                                                                                                    MySeekbar1 mySeekbar14 = (MySeekbar1) view2.findViewById(R.id.my_seekbar1_04);
                                                                                                                                                                                    if (mySeekbar14 != null) {
                                                                                                                                                                                        i = R.id.my_seekbar2_alto;
                                                                                                                                                                                        MySeekbar2 mySeekbar2 = (MySeekbar2) view2.findViewById(R.id.my_seekbar2_alto);
                                                                                                                                                                                        if (mySeekbar2 != null) {
                                                                                                                                                                                            i = R.id.my_seekbar2_bass;
                                                                                                                                                                                            MySeekbar2 mySeekbar22 = (MySeekbar2) view2.findViewById(R.id.my_seekbar2_bass);
                                                                                                                                                                                            if (mySeekbar22 != null) {
                                                                                                                                                                                                i = R.id.my_seekbar2_treble;
                                                                                                                                                                                                MySeekbar2 mySeekbar23 = (MySeekbar2) view2.findViewById(R.id.my_seekbar2_treble);
                                                                                                                                                                                                if (mySeekbar23 != null) {
                                                                                                                                                                                                    i = R.id.rbAndroid;
                                                                                                                                                                                                    RadioButton radioButton = (RadioButton) view2.findViewById(R.id.rbAndroid);
                                                                                                                                                                                                    if (radioButton != null) {
                                                                                                                                                                                                        i = R.id.rbOem;
                                                                                                                                                                                                        RadioButton radioButton2 = (RadioButton) view2.findViewById(R.id.rbOem);
                                                                                                                                                                                                        if (radioButton2 != null) {
                                                                                                                                                                                                            i = R.id.rbSound;
                                                                                                                                                                                                            RadioButton radioButton3 = (RadioButton) view2.findViewById(R.id.rbSound);
                                                                                                                                                                                                            if (radioButton3 != null) {
                                                                                                                                                                                                                i = R.id.scSound;
                                                                                                                                                                                                                ScrollView scrollView = (ScrollView) view2.findViewById(R.id.scSound);
                                                                                                                                                                                                                if (scrollView != null) {
                                                                                                                                                                                                                    i = R.id.scrollLayout;
                                                                                                                                                                                                                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.scrollLayout);
                                                                                                                                                                                                                    if (linearLayout != null) {
                                                                                                                                                                                                                        i = R.id.viewAndroid;
                                                                                                                                                                                                                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.viewAndroid);
                                                                                                                                                                                                                        if (relativeLayout != null) {
                                                                                                                                                                                                                            i = R.id.viewMain;
                                                                                                                                                                                                                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.viewMain);
                                                                                                                                                                                                                            if (linearLayout2 != null) {
                                                                                                                                                                                                                                i = R.id.viewOem;
                                                                                                                                                                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.viewOem);
                                                                                                                                                                                                                                if (relativeLayout2 != null) {
                                                                                                                                                                                                                                    i = R.id.viewOther;
                                                                                                                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(R.id.viewOther);
                                                                                                                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                                                                                                                        i = R.id.viewSound;
                                                                                                                                                                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.viewSound);
                                                                                                                                                                                                                                        if (relativeLayout3 != null) {
                                                                                                                                                                                                                                            i = R.id.viewSound_SeekBar0;
                                                                                                                                                                                                                                            View findViewById = view2.findViewById(R.id.viewSound_SeekBar0);
                                                                                                                                                                                                                                            if (findViewById != null) {
                                                                                                                                                                                                                                                i = R.id.viewSound_SeekBar1;
                                                                                                                                                                                                                                                View findViewById2 = view2.findViewById(R.id.viewSound_SeekBar1);
                                                                                                                                                                                                                                                if (findViewById2 != null) {
                                                                                                                                                                                                                                                    i = R.id.viewSound_SeekBar2;
                                                                                                                                                                                                                                                    View findViewById3 = view2.findViewById(R.id.viewSound_SeekBar2);
                                                                                                                                                                                                                                                    if (findViewById3 != null) {
                                                                                                                                                                                                                                                        i = R.id.viewSound_SeekBar3;
                                                                                                                                                                                                                                                        View findViewById4 = view2.findViewById(R.id.viewSound_SeekBar3);
                                                                                                                                                                                                                                                        if (findViewById4 != null) {
                                                                                                                                                                                                                                                            i = R.id.viewSound_SeekBar4;
                                                                                                                                                                                                                                                            View findViewById5 = view2.findViewById(R.id.viewSound_SeekBar4);
                                                                                                                                                                                                                                                            if (findViewById5 != null) {
                                                                                                                                                                                                                                                                i = R.id.viewSound_SeekBar5;
                                                                                                                                                                                                                                                                View findViewById6 = view2.findViewById(R.id.viewSound_SeekBar5);
                                                                                                                                                                                                                                                                if (findViewById6 != null) {
                                                                                                                                                                                                                                                                    i = R.id.viewSound_SeekBar6;
                                                                                                                                                                                                                                                                    View findViewById7 = view2.findViewById(R.id.viewSound_SeekBar6);
                                                                                                                                                                                                                                                                    if (findViewById7 != null) {
                                                                                                                                                                                                                                                                        i = R.id.viewUser;
                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) view2.findViewById(R.id.viewUser);
                                                                                                                                                                                                                                                                        if (relativeLayout4 != null) {
                                                                                                                                                                                                                                                                            return new Kesaiwei1920x720EvoId8FragmentVolSetBinding((RelativeLayout) view2, button, button2, button3, button4, button5, button6, textView, textView2, textView3, textView4, textView5, textView6, textView7, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, imageButton12, imageButton13, imageButton14, imageButton15, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, imageView, imageView2, imageView3, imageView4, imageView5, myScrollbar2, mySeekbar1, mySeekbar12, mySeekbar13, mySeekbar14, mySeekbar2, mySeekbar22, mySeekbar23, radioButton, radioButton2, radioButton3, scrollView, linearLayout, relativeLayout, linearLayout2, relativeLayout2, linearLayout3, relativeLayout3, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6, findViewById7, relativeLayout4);
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
