package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.szchoiceway.model.VolumeSetViewModel;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.settings.view.MySeekbar1;

public abstract class Kesaiwei1920x720LexusFragmentVolumeSetBinding extends ViewDataBinding {
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
    public final RelativeLayout androidVolumeLayout;
    public final CheckBox chkClassical;
    public final CheckBox chkDance;
    public final CheckBox chkJazz;
    public final CheckBox chkPop;
    public final CheckBox chkRock;
    public final CheckBox chkUser;
    @Bindable
    protected VolumeSetViewModel mViewModel;
    public final MyScrollbar myScrollbar;
    public final MySeekbar1 mySeekbar100;
    public final MySeekbar1 mySeekbar101;
    public final MySeekbar1 mySeekbar103;
    public final MySeekbar1 mySeekbar104;
    public final MySeekbar1 mySeekbar1Alto;
    public final MySeekbar1 mySeekbar1Bass;
    public final MySeekbar1 mySeekbar1Treble;
    public final RelativeLayout oemVolumeLayout;
    public final RadioButton rbAndroid;
    public final RadioButton rbOem;
    public final RadioButton rbSound;
    public final MyScrollView scSound;
    public final RelativeLayout scrollLayout;
    public final RelativeLayout soundSettingLayout;
    public final Guideline systemScrollViewLeGuideline;
    public final Guideline systemScrollViewRiGuideline;
    public final TextView text3Tv;
    public final TextView text4Tv;
    public final TextView text5Tv;
    public final TextView text6Tv;
    public final TextView text7Tv;
    public final TextView title1Tv;
    public final TextView title2Tv;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view10;
    public final RelativeLayout view11;
    public final RelativeLayout view12;
    public final RelativeLayout view13;
    public final RelativeLayout view14;
    public final RelativeLayout view15;
    public final RelativeLayout view16;
    public final RelativeLayout view17;
    public final RelativeLayout view18;
    public final RelativeLayout view2;
    public final RelativeLayout view3;
    public final RelativeLayout viewAndroid;
    public final RelativeLayout viewOem;
    public final Guideline viewPagerLeGuideline;
    public final ConstraintLayout viewSound;
    public final View viewSoundSeekBar0;
    public final View viewSoundSeekBar1;
    public final View viewSoundSeekBar2;
    public final View viewSoundSeekBar3;
    public final View viewSoundSeekBar4;
    public final View viewSoundSeekBar5;
    public final View viewSoundSeekBar6;

    public abstract void setViewModel(VolumeSetViewModel volumeSetViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected Kesaiwei1920x720LexusFragmentVolumeSetBinding(Object obj, View view, int i, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RelativeLayout relativeLayout, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, MyScrollbar myScrollbar2, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, MySeekbar1 mySeekbar13, MySeekbar1 mySeekbar14, MySeekbar1 mySeekbar15, MySeekbar1 mySeekbar16, MySeekbar1 mySeekbar17, RelativeLayout relativeLayout2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, MyScrollView myScrollView, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, Guideline guideline, Guideline guideline2, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, RelativeLayout relativeLayout12, RelativeLayout relativeLayout13, RelativeLayout relativeLayout14, RelativeLayout relativeLayout15, RelativeLayout relativeLayout16, RelativeLayout relativeLayout17, RelativeLayout relativeLayout18, RelativeLayout relativeLayout19, Guideline guideline3, ConstraintLayout constraintLayout, View view4, View view5, View view6, View view7, View view8, View view9, View view19) {
        super(obj, view, i);
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
        this.androidVolumeLayout = relativeLayout;
        this.chkClassical = checkBox;
        this.chkDance = checkBox2;
        this.chkJazz = checkBox3;
        this.chkPop = checkBox4;
        this.chkRock = checkBox5;
        this.chkUser = checkBox6;
        this.myScrollbar = myScrollbar2;
        this.mySeekbar100 = mySeekbar1;
        this.mySeekbar101 = mySeekbar12;
        this.mySeekbar103 = mySeekbar13;
        this.mySeekbar104 = mySeekbar14;
        this.mySeekbar1Alto = mySeekbar15;
        this.mySeekbar1Bass = mySeekbar16;
        this.mySeekbar1Treble = mySeekbar17;
        this.oemVolumeLayout = relativeLayout2;
        this.rbAndroid = radioButton;
        this.rbOem = radioButton2;
        this.rbSound = radioButton3;
        this.scSound = myScrollView;
        this.scrollLayout = relativeLayout3;
        this.soundSettingLayout = relativeLayout4;
        this.systemScrollViewLeGuideline = guideline;
        this.systemScrollViewRiGuideline = guideline2;
        this.text3Tv = textView8;
        this.text4Tv = textView9;
        this.text5Tv = textView10;
        this.text6Tv = textView11;
        this.text7Tv = textView12;
        this.title1Tv = textView13;
        this.title2Tv = textView14;
        this.view0 = relativeLayout5;
        this.view1 = relativeLayout6;
        this.view10 = relativeLayout7;
        this.view11 = relativeLayout8;
        this.view12 = relativeLayout9;
        this.view13 = relativeLayout10;
        this.view14 = relativeLayout11;
        this.view15 = relativeLayout12;
        this.view16 = relativeLayout13;
        this.view17 = relativeLayout14;
        this.view18 = relativeLayout15;
        this.view2 = relativeLayout16;
        this.view3 = relativeLayout17;
        this.viewAndroid = relativeLayout18;
        this.viewOem = relativeLayout19;
        this.viewPagerLeGuideline = guideline3;
        this.viewSound = constraintLayout;
        this.viewSoundSeekBar0 = view4;
        this.viewSoundSeekBar1 = view5;
        this.viewSoundSeekBar2 = view6;
        this.viewSoundSeekBar3 = view7;
        this.viewSoundSeekBar4 = view8;
        this.viewSoundSeekBar5 = view9;
        this.viewSoundSeekBar6 = view19;
    }

    public VolumeSetViewModel getViewModel() {
        return this.mViewModel;
    }

    public static Kesaiwei1920x720LexusFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Kesaiwei1920x720LexusFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (Kesaiwei1920x720LexusFragmentVolumeSetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.kesaiwei_1920x720_lexus_fragment_volume_set, viewGroup, z, obj);
    }

    public static Kesaiwei1920x720LexusFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Kesaiwei1920x720LexusFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (Kesaiwei1920x720LexusFragmentVolumeSetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.kesaiwei_1920x720_lexus_fragment_volume_set, (ViewGroup) null, false, obj);
    }

    public static Kesaiwei1920x720LexusFragmentVolumeSetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Kesaiwei1920x720LexusFragmentVolumeSetBinding bind(View view, Object obj) {
        return (Kesaiwei1920x720LexusFragmentVolumeSetBinding) bind(obj, view, R.layout.kesaiwei_1920x720_lexus_fragment_volume_set);
    }
}
