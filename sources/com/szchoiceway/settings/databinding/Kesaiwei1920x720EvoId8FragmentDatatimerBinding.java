package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId8FragmentDatatimerBinding implements ViewBinding {
    public final ImageButton btn12Hour;
    public final ImageButton btn24Hour;
    public final ImageButton btnAutoSync;
    public final ImageButton btnOriginalTime;
    public final ImageButton btnReturn;
    public final ImageButton btnSyc;
    public final ImageButton btnSys;
    public final ImageView imgSyc;
    public final ImageView imgSys;
    public final CheckBox kesaiwei12Hour;
    public final CheckBox kesaiwei24Hour;
    public final CheckBox kesaiweiAutoSync;
    public final CheckBox kesaiweiOriginalTime;
    public final ImageView lineSys;
    private final RelativeLayout rootView;
    public final TextView titleSyc;
    public final TextView valueSyc;
    public final TextView valueSys;
    public final RelativeLayout view12Hour;
    public final LinearLayout viewSyc;
    public final LinearLayout viewSys;

    private Kesaiwei1920x720EvoId8FragmentDatatimerBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageView imageView, ImageView imageView2, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.rootView = relativeLayout;
        this.btn12Hour = imageButton;
        this.btn24Hour = imageButton2;
        this.btnAutoSync = imageButton3;
        this.btnOriginalTime = imageButton4;
        this.btnReturn = imageButton5;
        this.btnSyc = imageButton6;
        this.btnSys = imageButton7;
        this.imgSyc = imageView;
        this.imgSys = imageView2;
        this.kesaiwei12Hour = checkBox;
        this.kesaiwei24Hour = checkBox2;
        this.kesaiweiAutoSync = checkBox3;
        this.kesaiweiOriginalTime = checkBox4;
        this.lineSys = imageView3;
        this.titleSyc = textView;
        this.valueSyc = textView2;
        this.valueSys = textView3;
        this.view12Hour = relativeLayout2;
        this.viewSyc = linearLayout;
        this.viewSys = linearLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentDatatimerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentDatatimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_datatimer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentDatatimerBinding bind(View view) {
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
                        i = R.id.btnReturn;
                        ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.btnReturn);
                        if (imageButton5 != null) {
                            i = R.id.btnSyc;
                            ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.btnSyc);
                            if (imageButton6 != null) {
                                i = R.id.btnSys;
                                ImageButton imageButton7 = (ImageButton) view2.findViewById(R.id.btnSys);
                                if (imageButton7 != null) {
                                    i = R.id.imgSyc;
                                    ImageView imageView = (ImageView) view2.findViewById(R.id.imgSyc);
                                    if (imageView != null) {
                                        i = R.id.imgSys;
                                        ImageView imageView2 = (ImageView) view2.findViewById(R.id.imgSys);
                                        if (imageView2 != null) {
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
                                                            i = R.id.lineSys;
                                                            ImageView imageView3 = (ImageView) view2.findViewById(R.id.lineSys);
                                                            if (imageView3 != null) {
                                                                i = R.id.titleSyc;
                                                                TextView textView = (TextView) view2.findViewById(R.id.titleSyc);
                                                                if (textView != null) {
                                                                    i = R.id.valueSyc;
                                                                    TextView textView2 = (TextView) view2.findViewById(R.id.valueSyc);
                                                                    if (textView2 != null) {
                                                                        i = R.id.valueSys;
                                                                        TextView textView3 = (TextView) view2.findViewById(R.id.valueSys);
                                                                        if (textView3 != null) {
                                                                            i = R.id.view12Hour;
                                                                            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.view12Hour);
                                                                            if (relativeLayout != null) {
                                                                                i = R.id.viewSyc;
                                                                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.viewSyc);
                                                                                if (linearLayout != null) {
                                                                                    i = R.id.viewSys;
                                                                                    LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.viewSys);
                                                                                    if (linearLayout2 != null) {
                                                                                        return new Kesaiwei1920x720EvoId8FragmentDatatimerBinding((RelativeLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageView, imageView2, checkBox, checkBox2, checkBox3, checkBox4, imageView3, textView, textView2, textView3, relativeLayout, linearLayout, linearLayout2);
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
