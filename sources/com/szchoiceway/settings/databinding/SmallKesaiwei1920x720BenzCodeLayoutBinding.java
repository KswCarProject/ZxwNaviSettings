package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class SmallKesaiwei1920x720BenzCodeLayoutBinding implements ViewBinding {
    public final ImageButton BtnNum0;
    public final ImageButton BtnNum1;
    public final ImageButton BtnNum2;
    public final ImageButton BtnNum3;
    public final ImageButton BtnNum4;
    public final ImageButton BtnNum5;
    public final ImageButton BtnNum6;
    public final ImageButton BtnNum7;
    public final ImageButton BtnNum8;
    public final ImageButton BtnNum9;
    public final ImageButton BtnNumDel;
    public final ImageButton BtnNumOK;
    public final TextView TvInputUserFreq;
    public final ImageView img3;
    public final ImageView imgBg;
    private final ConstraintLayout rootView;
    public final View viewLeft;
    public final View viewRight;

    private SmallKesaiwei1920x720BenzCodeLayoutBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, ImageButton imageButton12, TextView textView, ImageView imageView, ImageView imageView2, View view, View view2) {
        this.rootView = constraintLayout;
        this.BtnNum0 = imageButton;
        this.BtnNum1 = imageButton2;
        this.BtnNum2 = imageButton3;
        this.BtnNum3 = imageButton4;
        this.BtnNum4 = imageButton5;
        this.BtnNum5 = imageButton6;
        this.BtnNum6 = imageButton7;
        this.BtnNum7 = imageButton8;
        this.BtnNum8 = imageButton9;
        this.BtnNum9 = imageButton10;
        this.BtnNumDel = imageButton11;
        this.BtnNumOK = imageButton12;
        this.TvInputUserFreq = textView;
        this.img3 = imageView;
        this.imgBg = imageView2;
        this.viewLeft = view;
        this.viewRight = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SmallKesaiwei1920x720BenzCodeLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallKesaiwei1920x720BenzCodeLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_code_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallKesaiwei1920x720BenzCodeLayoutBinding bind(View view) {
        View view2 = view;
        int i = R.id.BtnNum0;
        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.BtnNum0);
        if (imageButton != null) {
            i = R.id.BtnNum1;
            ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.BtnNum1);
            if (imageButton2 != null) {
                i = R.id.BtnNum2;
                ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.BtnNum2);
                if (imageButton3 != null) {
                    i = R.id.BtnNum3;
                    ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.BtnNum3);
                    if (imageButton4 != null) {
                        i = R.id.BtnNum4;
                        ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.BtnNum4);
                        if (imageButton5 != null) {
                            i = R.id.BtnNum5;
                            ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.BtnNum5);
                            if (imageButton6 != null) {
                                i = R.id.BtnNum6;
                                ImageButton imageButton7 = (ImageButton) view2.findViewById(R.id.BtnNum6);
                                if (imageButton7 != null) {
                                    i = R.id.BtnNum7;
                                    ImageButton imageButton8 = (ImageButton) view2.findViewById(R.id.BtnNum7);
                                    if (imageButton8 != null) {
                                        i = R.id.BtnNum8;
                                        ImageButton imageButton9 = (ImageButton) view2.findViewById(R.id.BtnNum8);
                                        if (imageButton9 != null) {
                                            i = R.id.BtnNum9;
                                            ImageButton imageButton10 = (ImageButton) view2.findViewById(R.id.BtnNum9);
                                            if (imageButton10 != null) {
                                                i = R.id.BtnNumDel;
                                                ImageButton imageButton11 = (ImageButton) view2.findViewById(R.id.BtnNumDel);
                                                if (imageButton11 != null) {
                                                    i = R.id.BtnNumOK;
                                                    ImageButton imageButton12 = (ImageButton) view2.findViewById(R.id.BtnNumOK);
                                                    if (imageButton12 != null) {
                                                        i = R.id.TvInputUserFreq;
                                                        TextView textView = (TextView) view2.findViewById(R.id.TvInputUserFreq);
                                                        if (textView != null) {
                                                            i = R.id.img3;
                                                            ImageView imageView = (ImageView) view2.findViewById(R.id.img3);
                                                            if (imageView != null) {
                                                                i = R.id.imgBg;
                                                                ImageView imageView2 = (ImageView) view2.findViewById(R.id.imgBg);
                                                                if (imageView2 != null) {
                                                                    i = R.id.viewLeft;
                                                                    View findViewById = view2.findViewById(R.id.viewLeft);
                                                                    if (findViewById != null) {
                                                                        i = R.id.viewRight;
                                                                        View findViewById2 = view2.findViewById(R.id.viewRight);
                                                                        if (findViewById2 != null) {
                                                                            return new SmallKesaiwei1920x720BenzCodeLayoutBinding((ConstraintLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, imageButton12, textView, imageView, imageView2, findViewById, findViewById2);
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
