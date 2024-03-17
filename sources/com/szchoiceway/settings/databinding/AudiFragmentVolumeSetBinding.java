package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MySeekbar1;

public final class AudiFragmentVolumeSetBinding implements ViewBinding {
    public final TextView KSWVolVal00;
    public final TextView KSWVolVal01;
    public final TextView KSWVolVal03;
    public final TextView KSWVolVal04;
    public final Button btnAndroidVolume;
    public final Button btnOemVolume;
    public final MySeekbar1 mySeekbar100;
    public final MySeekbar1 mySeekbar101;
    public final MySeekbar1 mySeekbar103;
    public final MySeekbar1 mySeekbar104;
    private final ConstraintLayout rootView;
    public final RelativeLayout viewAndroidVolume;
    public final View viewKSWVolVal00;
    public final View viewKSWVolVal01;
    public final View viewKSWVolVal03;
    public final View viewKSWVolVal04;
    public final RelativeLayout viewOemVolume;

    private AudiFragmentVolumeSetBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, Button button, Button button2, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, MySeekbar1 mySeekbar13, MySeekbar1 mySeekbar14, RelativeLayout relativeLayout, View view, View view2, View view3, View view4, RelativeLayout relativeLayout2) {
        this.rootView = constraintLayout;
        this.KSWVolVal00 = textView;
        this.KSWVolVal01 = textView2;
        this.KSWVolVal03 = textView3;
        this.KSWVolVal04 = textView4;
        this.btnAndroidVolume = button;
        this.btnOemVolume = button2;
        this.mySeekbar100 = mySeekbar1;
        this.mySeekbar101 = mySeekbar12;
        this.mySeekbar103 = mySeekbar13;
        this.mySeekbar104 = mySeekbar14;
        this.viewAndroidVolume = relativeLayout;
        this.viewKSWVolVal00 = view;
        this.viewKSWVolVal01 = view2;
        this.viewKSWVolVal03 = view3;
        this.viewKSWVolVal04 = view4;
        this.viewOemVolume = relativeLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AudiFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_fragment_volume_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiFragmentVolumeSetBinding bind(View view) {
        View view2 = view;
        int i = R.id.KSW_Vol_val_00;
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
                        i = R.id.btnAndroidVolume;
                        Button button = (Button) view2.findViewById(R.id.btnAndroidVolume);
                        if (button != null) {
                            i = R.id.btnOemVolume;
                            Button button2 = (Button) view2.findViewById(R.id.btnOemVolume);
                            if (button2 != null) {
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
                                                i = R.id.viewAndroidVolume;
                                                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.viewAndroidVolume);
                                                if (relativeLayout != null) {
                                                    i = R.id.viewKSW_Vol_val_00;
                                                    View findViewById = view2.findViewById(R.id.viewKSW_Vol_val_00);
                                                    if (findViewById != null) {
                                                        i = R.id.viewKSW_Vol_val_01;
                                                        View findViewById2 = view2.findViewById(R.id.viewKSW_Vol_val_01);
                                                        if (findViewById2 != null) {
                                                            i = R.id.viewKSW_Vol_val_03;
                                                            View findViewById3 = view2.findViewById(R.id.viewKSW_Vol_val_03);
                                                            if (findViewById3 != null) {
                                                                i = R.id.viewKSW_Vol_val_04;
                                                                View findViewById4 = view2.findViewById(R.id.viewKSW_Vol_val_04);
                                                                if (findViewById4 != null) {
                                                                    i = R.id.viewOemVolume;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.viewOemVolume);
                                                                    if (relativeLayout2 != null) {
                                                                        return new AudiFragmentVolumeSetBinding((ConstraintLayout) view2, textView, textView2, textView3, textView4, button, button2, mySeekbar1, mySeekbar12, mySeekbar13, mySeekbar14, relativeLayout, findViewById, findViewById2, findViewById3, findViewById4, relativeLayout2);
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
