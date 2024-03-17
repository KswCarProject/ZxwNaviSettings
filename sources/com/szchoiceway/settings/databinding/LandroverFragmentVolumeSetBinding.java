package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MySeekbar1;

public final class LandroverFragmentVolumeSetBinding implements ViewBinding {
    public final TextView KSWVolVal00;
    public final TextView KSWVolVal01;
    public final TextView KSWVolVal03;
    public final TextView KSWVolVal04;
    public final ImageButton btnEq;
    public final ImageView img0;
    public final ImageView img1;
    public final ImageView img3;
    public final ImageView img4;
    public final MySeekbar1 mySeekbar100;
    public final MySeekbar1 mySeekbar101;
    public final MySeekbar1 mySeekbar103;
    public final MySeekbar1 mySeekbar104;
    private final ConstraintLayout rootView;
    public final TextView title0;
    public final TextView title1;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout view3;

    private LandroverFragmentVolumeSetBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageButton imageButton, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, MySeekbar1 mySeekbar1, MySeekbar1 mySeekbar12, MySeekbar1 mySeekbar13, MySeekbar1 mySeekbar14, TextView textView5, TextView textView6, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4) {
        this.rootView = constraintLayout;
        this.KSWVolVal00 = textView;
        this.KSWVolVal01 = textView2;
        this.KSWVolVal03 = textView3;
        this.KSWVolVal04 = textView4;
        this.btnEq = imageButton;
        this.img0 = imageView;
        this.img1 = imageView2;
        this.img3 = imageView3;
        this.img4 = imageView4;
        this.mySeekbar100 = mySeekbar1;
        this.mySeekbar101 = mySeekbar12;
        this.mySeekbar103 = mySeekbar13;
        this.mySeekbar104 = mySeekbar14;
        this.title0 = textView5;
        this.title1 = textView6;
        this.view0 = relativeLayout;
        this.view1 = relativeLayout2;
        this.view2 = relativeLayout3;
        this.view3 = relativeLayout4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LandroverFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LandroverFragmentVolumeSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.landrover_fragment_volume_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LandroverFragmentVolumeSetBinding bind(View view) {
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
                        i = R.id.btnEq;
                        ImageButton imageButton = (ImageButton) view4.findViewById(R.id.btnEq);
                        if (imageButton != null) {
                            i = R.id.img0;
                            ImageView imageView = (ImageView) view4.findViewById(R.id.img0);
                            if (imageView != null) {
                                i = R.id.img1;
                                ImageView imageView2 = (ImageView) view4.findViewById(R.id.img1);
                                if (imageView2 != null) {
                                    i = R.id.img3;
                                    ImageView imageView3 = (ImageView) view4.findViewById(R.id.img3);
                                    if (imageView3 != null) {
                                        i = R.id.img4;
                                        ImageView imageView4 = (ImageView) view4.findViewById(R.id.img4);
                                        if (imageView4 != null) {
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
                                                            i = R.id.title0;
                                                            TextView textView5 = (TextView) view4.findViewById(R.id.title0);
                                                            if (textView5 != null) {
                                                                i = R.id.title1;
                                                                TextView textView6 = (TextView) view4.findViewById(R.id.title1);
                                                                if (textView6 != null) {
                                                                    i = R.id.view0;
                                                                    RelativeLayout relativeLayout = (RelativeLayout) view4.findViewById(R.id.view0);
                                                                    if (relativeLayout != null) {
                                                                        i = R.id.view1;
                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view4.findViewById(R.id.view1);
                                                                        if (relativeLayout2 != null) {
                                                                            i = R.id.view2;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) view4.findViewById(R.id.view2);
                                                                            if (relativeLayout3 != null) {
                                                                                i = R.id.view3;
                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) view4.findViewById(R.id.view3);
                                                                                if (relativeLayout4 != null) {
                                                                                    return new LandroverFragmentVolumeSetBinding((ConstraintLayout) view4, textView, textView2, textView3, textView4, imageButton, imageView, imageView2, imageView3, imageView4, mySeekbar1, mySeekbar12, mySeekbar13, mySeekbar14, textView5, textView6, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4);
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
