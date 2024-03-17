package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollView;
import com.szchoiceway.settings.view.MySeekbar1;

public final class SmallKesaiwei1920x720BenzFragmentVolumeSetBinding implements ViewBinding {
    public final TextView KSWVolVal00;
    public final TextView KSWVolVal01;
    public final TextView KSWVolVal03;
    public final TextView KSWVolVal04;
    public final MyScrollView mScrollView;
    public final MySeekbar1 mySeekbar100;
    public final MySeekbar1 mySeekbar101;
    public final MySeekbar1 mySeekbar103;
    public final MySeekbar1 mySeekbar104;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollLayout;
    public final TextView text2;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;
    public final View viewKSWVolVal00;
    public final View viewKSWVolVal01;
    public final View viewKSWVolVal03;
    public final View viewKSWVolVal04;

    private SmallKesaiwei1920x720BenzFragmentVolumeSetBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, MyScrollView myScrollView, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, MySeekbar1 mySeekbar13, MySeekbar1 mySeekbar14, RelativeLayout relativeLayout2, TextView textView5, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, View view, View view4, View view5, View view6) {
        this.rootView = relativeLayout;
        this.KSWVolVal00 = textView;
        this.KSWVolVal01 = textView2;
        this.KSWVolVal03 = textView3;
        this.KSWVolVal04 = textView4;
        this.mScrollView = myScrollView;
        this.mySeekbar100 = mySeekbar1;
        this.mySeekbar101 = mySeekbar12;
        this.mySeekbar103 = mySeekbar13;
        this.mySeekbar104 = mySeekbar14;
        this.scrollLayout = relativeLayout2;
        this.text2 = textView5;
        this.view0 = relativeLayout3;
        this.view1 = relativeLayout4;
        this.view2 = relativeLayout5;
        this.view3 = relativeLayout6;
        this.viewKSWVolVal00 = view;
        this.viewKSWVolVal01 = view4;
        this.viewKSWVolVal03 = view5;
        this.viewKSWVolVal04 = view6;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallKesaiwei1920x720BenzFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallKesaiwei1920x720BenzFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_volume_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallKesaiwei1920x720BenzFragmentVolumeSetBinding bind(View view) {
        View view4 = view;
        int i = R.id.KSW_Vol_val_00;
        TextView textView = (TextView) view4.findViewById(R.id.KSW_Vol_val_00);
        if (textView != null) {
            i = R.id.KSW_Vol_val_01;
            TextView textView2 = (TextView) view4.findViewById(R.id.KSW_Vol_val_01);
            if (textView2 != null) {
                i = R.id.KSW_Vol_val_03;
                TextView textView3 = (TextView) view4.findViewById(R.id.KSW_Vol_val_03);
                if (textView3 != null) {
                    i = R.id.KSW_Vol_val_04;
                    TextView textView4 = (TextView) view4.findViewById(R.id.KSW_Vol_val_04);
                    if (textView4 != null) {
                        i = R.id.mScrollView;
                        MyScrollView myScrollView = (MyScrollView) view4.findViewById(R.id.mScrollView);
                        if (myScrollView != null) {
                            i = R.id.my_seekbar1_00;
                            MySeekbar1 mySeekbar1 = (MySeekbar1) view4.findViewById(R.id.my_seekbar1_00);
                            if (mySeekbar1 != null) {
                                i = R.id.my_seekbar1_01;
                                MySeekbar1 mySeekbar12 = (MySeekbar1) view4.findViewById(R.id.my_seekbar1_01);
                                if (mySeekbar12 != null) {
                                    i = R.id.my_seekbar1_03;
                                    MySeekbar1 mySeekbar13 = (MySeekbar1) view4.findViewById(R.id.my_seekbar1_03);
                                    if (mySeekbar13 != null) {
                                        i = R.id.my_seekbar1_04;
                                        MySeekbar1 mySeekbar14 = (MySeekbar1) view4.findViewById(R.id.my_seekbar1_04);
                                        if (mySeekbar14 != null) {
                                            i = R.id.scrollLayout;
                                            RelativeLayout relativeLayout = (RelativeLayout) view4.findViewById(R.id.scrollLayout);
                                            if (relativeLayout != null) {
                                                i = R.id.text2;
                                                TextView textView5 = (TextView) view4.findViewById(R.id.text2);
                                                if (textView5 != null) {
                                                    i = R.id.view0;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view4.findViewById(R.id.view0);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.view1;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view4.findViewById(R.id.view1);
                                                        if (relativeLayout3 != null) {
                                                            i = R.id.view2;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) view4.findViewById(R.id.view2);
                                                            if (relativeLayout4 != null) {
                                                                i = R.id.view3;
                                                                RelativeLayout relativeLayout5 = (RelativeLayout) view4.findViewById(R.id.view3);
                                                                if (relativeLayout5 != null) {
                                                                    i = R.id.viewKSW_Vol_val_00;
                                                                    View findViewById = view4.findViewById(R.id.viewKSW_Vol_val_00);
                                                                    if (findViewById != null) {
                                                                        i = R.id.viewKSW_Vol_val_01;
                                                                        View findViewById2 = view4.findViewById(R.id.viewKSW_Vol_val_01);
                                                                        if (findViewById2 != null) {
                                                                            i = R.id.viewKSW_Vol_val_03;
                                                                            View findViewById3 = view4.findViewById(R.id.viewKSW_Vol_val_03);
                                                                            if (findViewById3 != null) {
                                                                                i = R.id.viewKSW_Vol_val_04;
                                                                                View findViewById4 = view4.findViewById(R.id.viewKSW_Vol_val_04);
                                                                                if (findViewById4 != null) {
                                                                                    return new SmallKesaiwei1920x720BenzFragmentVolumeSetBinding((RelativeLayout) view4, textView, textView2, textView3, textView4, myScrollView, mySeekbar1, mySeekbar12, mySeekbar13, mySeekbar14, relativeLayout, textView5, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, findViewById, findViewById2, findViewById3, findViewById4);
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
