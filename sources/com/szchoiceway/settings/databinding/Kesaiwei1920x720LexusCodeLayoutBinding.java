package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720LexusCodeLayoutBinding implements ViewBinding {
    public final ImageButton BtnNum0;
    public final ImageButton BtnNum1;
    public final Guideline BtnNum1LeGuideline;
    public final Guideline BtnNum1ToGuideline;
    public final ImageButton BtnNum2;
    public final Guideline BtnNum2LeGuideline;
    public final ImageButton BtnNum3;
    public final Guideline BtnNum3LeGuideline;
    public final ImageButton BtnNum4;
    public final Guideline BtnNum4ToGuideline;
    public final ImageButton BtnNum5;
    public final ImageButton BtnNum6;
    public final ImageButton BtnNum7;
    public final Guideline BtnNum7ToGuideline;
    public final ImageButton BtnNum8;
    public final ImageButton BtnNum9;
    public final ImageButton BtnNumDel;
    public final Guideline BtnNumDelLeGuideline;
    public final ImageButton BtnNumOK;
    public final TextView TvInputUserFreq;
    public final Guideline TvInputUserFreqToGuideline;
    private final ConstraintLayout rootView;

    private Kesaiwei1920x720LexusCodeLayoutBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, Guideline guideline, Guideline guideline2, ImageButton imageButton3, Guideline guideline3, ImageButton imageButton4, Guideline guideline4, ImageButton imageButton5, Guideline guideline5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, Guideline guideline6, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, Guideline guideline7, ImageButton imageButton12, TextView textView, Guideline guideline8) {
        this.rootView = constraintLayout;
        this.BtnNum0 = imageButton;
        this.BtnNum1 = imageButton2;
        this.BtnNum1LeGuideline = guideline;
        this.BtnNum1ToGuideline = guideline2;
        this.BtnNum2 = imageButton3;
        this.BtnNum2LeGuideline = guideline3;
        this.BtnNum3 = imageButton4;
        this.BtnNum3LeGuideline = guideline4;
        this.BtnNum4 = imageButton5;
        this.BtnNum4ToGuideline = guideline5;
        this.BtnNum5 = imageButton6;
        this.BtnNum6 = imageButton7;
        this.BtnNum7 = imageButton8;
        this.BtnNum7ToGuideline = guideline6;
        this.BtnNum8 = imageButton9;
        this.BtnNum9 = imageButton10;
        this.BtnNumDel = imageButton11;
        this.BtnNumDelLeGuideline = guideline7;
        this.BtnNumOK = imageButton12;
        this.TvInputUserFreq = textView;
        this.TvInputUserFreqToGuideline = guideline8;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720LexusCodeLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720LexusCodeLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_code_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720LexusCodeLayoutBinding bind(View view) {
        View view2 = view;
        int i = R.id.BtnNum0;
        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.BtnNum0);
        if (imageButton != null) {
            i = R.id.BtnNum1;
            ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.BtnNum1);
            if (imageButton2 != null) {
                i = R.id.BtnNum1_le_guideline;
                Guideline guideline = (Guideline) view2.findViewById(R.id.BtnNum1_le_guideline);
                if (guideline != null) {
                    i = R.id.BtnNum1_to_guideline;
                    Guideline guideline2 = (Guideline) view2.findViewById(R.id.BtnNum1_to_guideline);
                    if (guideline2 != null) {
                        i = R.id.BtnNum2;
                        ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.BtnNum2);
                        if (imageButton3 != null) {
                            i = R.id.BtnNum2_le_guideline;
                            Guideline guideline3 = (Guideline) view2.findViewById(R.id.BtnNum2_le_guideline);
                            if (guideline3 != null) {
                                i = R.id.BtnNum3;
                                ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.BtnNum3);
                                if (imageButton4 != null) {
                                    i = R.id.BtnNum3_le_guideline;
                                    Guideline guideline4 = (Guideline) view2.findViewById(R.id.BtnNum3_le_guideline);
                                    if (guideline4 != null) {
                                        i = R.id.BtnNum4;
                                        ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.BtnNum4);
                                        if (imageButton5 != null) {
                                            i = R.id.BtnNum4_to_guideline;
                                            Guideline guideline5 = (Guideline) view2.findViewById(R.id.BtnNum4_to_guideline);
                                            if (guideline5 != null) {
                                                i = R.id.BtnNum5;
                                                ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.BtnNum5);
                                                if (imageButton6 != null) {
                                                    i = R.id.BtnNum6;
                                                    ImageButton imageButton7 = (ImageButton) view2.findViewById(R.id.BtnNum6);
                                                    if (imageButton7 != null) {
                                                        i = R.id.BtnNum7;
                                                        ImageButton imageButton8 = (ImageButton) view2.findViewById(R.id.BtnNum7);
                                                        if (imageButton8 != null) {
                                                            i = R.id.BtnNum7_to_guideline;
                                                            Guideline guideline6 = (Guideline) view2.findViewById(R.id.BtnNum7_to_guideline);
                                                            if (guideline6 != null) {
                                                                i = R.id.BtnNum8;
                                                                ImageButton imageButton9 = (ImageButton) view2.findViewById(R.id.BtnNum8);
                                                                if (imageButton9 != null) {
                                                                    i = R.id.BtnNum9;
                                                                    ImageButton imageButton10 = (ImageButton) view2.findViewById(R.id.BtnNum9);
                                                                    if (imageButton10 != null) {
                                                                        i = R.id.BtnNumDel;
                                                                        ImageButton imageButton11 = (ImageButton) view2.findViewById(R.id.BtnNumDel);
                                                                        if (imageButton11 != null) {
                                                                            i = R.id.BtnNumDel_le_guideline;
                                                                            Guideline guideline7 = (Guideline) view2.findViewById(R.id.BtnNumDel_le_guideline);
                                                                            if (guideline7 != null) {
                                                                                i = R.id.BtnNumOK;
                                                                                ImageButton imageButton12 = (ImageButton) view2.findViewById(R.id.BtnNumOK);
                                                                                if (imageButton12 != null) {
                                                                                    i = R.id.TvInputUserFreq;
                                                                                    TextView textView = (TextView) view2.findViewById(R.id.TvInputUserFreq);
                                                                                    if (textView != null) {
                                                                                        i = R.id.TvInputUserFreq_to_guideline;
                                                                                        Guideline guideline8 = (Guideline) view2.findViewById(R.id.TvInputUserFreq_to_guideline);
                                                                                        if (guideline8 != null) {
                                                                                            return new Kesaiwei1920x720LexusCodeLayoutBinding((ConstraintLayout) view2, imageButton, imageButton2, guideline, guideline2, imageButton3, guideline3, imageButton4, guideline4, imageButton5, guideline5, imageButton6, imageButton7, imageButton8, guideline6, imageButton9, imageButton10, imageButton11, guideline7, imageButton12, textView, guideline8);
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
