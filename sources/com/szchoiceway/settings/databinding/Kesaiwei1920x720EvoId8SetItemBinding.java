package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId8SetItemBinding implements ViewBinding {
    public final RadioButton BtnDataTimer;
    public final RadioButton BtnFatSetting;
    public final RadioButton BtnLanguage;
    public final RadioButton BtnMoreSetting;
    public final RadioButton BtnNavSet;
    public final RadioButton BtnSysInfor;
    public final RadioButton BtnSysSetting;
    public final RadioButton BtnVolSetKSW;
    public final RadioGroup radioGroupMain;
    private final RelativeLayout rootView;

    private Kesaiwei1920x720EvoId8SetItemBinding(RelativeLayout relativeLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioGroup radioGroup) {
        this.rootView = relativeLayout;
        this.BtnDataTimer = radioButton;
        this.BtnFatSetting = radioButton2;
        this.BtnLanguage = radioButton3;
        this.BtnMoreSetting = radioButton4;
        this.BtnNavSet = radioButton5;
        this.BtnSysInfor = radioButton6;
        this.BtnSysSetting = radioButton7;
        this.BtnVolSetKSW = radioButton8;
        this.radioGroupMain = radioGroup;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8SetItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8SetItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_set_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8SetItemBinding bind(View view) {
        int i = R.id.BtnDataTimer;
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.BtnDataTimer);
        if (radioButton != null) {
            i = R.id.BtnFatSetting;
            RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.BtnFatSetting);
            if (radioButton2 != null) {
                i = R.id.BtnLanguage;
                RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.BtnLanguage);
                if (radioButton3 != null) {
                    i = R.id.BtnMoreSetting;
                    RadioButton radioButton4 = (RadioButton) view.findViewById(R.id.BtnMoreSetting);
                    if (radioButton4 != null) {
                        i = R.id.BtnNavSet;
                        RadioButton radioButton5 = (RadioButton) view.findViewById(R.id.BtnNavSet);
                        if (radioButton5 != null) {
                            i = R.id.BtnSysInfor;
                            RadioButton radioButton6 = (RadioButton) view.findViewById(R.id.BtnSysInfor);
                            if (radioButton6 != null) {
                                i = R.id.BtnSysSetting;
                                RadioButton radioButton7 = (RadioButton) view.findViewById(R.id.BtnSysSetting);
                                if (radioButton7 != null) {
                                    i = R.id.BtnVolSet_KSW;
                                    RadioButton radioButton8 = (RadioButton) view.findViewById(R.id.BtnVolSet_KSW);
                                    if (radioButton8 != null) {
                                        i = R.id.radioGroupMain;
                                        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroupMain);
                                        if (radioGroup != null) {
                                            return new Kesaiwei1920x720EvoId8SetItemBinding((RelativeLayout) view, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioGroup);
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
