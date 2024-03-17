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

public final class AudiCodeLayout1560x700Binding implements ViewBinding {
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
    public final ImageView imgKeyBk;
    public final ImageView imgNum0;
    public final ImageView imgNum1;
    public final ImageView imgNum2;
    public final ImageView imgNum3;
    public final ImageView imgNum4;
    public final ImageView imgNum5;
    public final ImageView imgNum6;
    public final ImageView imgNum7;
    public final ImageView imgNum8;
    public final ImageView imgNum9;
    public final ImageView imgNumEnter;
    private final ConstraintLayout rootView;

    private AudiCodeLayout1560x700Binding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, ImageButton imageButton12, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12) {
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
        this.imgKeyBk = imageView;
        this.imgNum0 = imageView2;
        this.imgNum1 = imageView3;
        this.imgNum2 = imageView4;
        this.imgNum3 = imageView5;
        this.imgNum4 = imageView6;
        this.imgNum5 = imageView7;
        this.imgNum6 = imageView8;
        this.imgNum7 = imageView9;
        this.imgNum8 = imageView10;
        this.imgNum9 = imageView11;
        this.imgNumEnter = imageView12;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AudiCodeLayout1560x700Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiCodeLayout1560x700Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_code_layout_1560x700, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiCodeLayout1560x700Binding bind(View view) {
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
                                                            i = R.id.imgKeyBk;
                                                            ImageView imageView = (ImageView) view2.findViewById(R.id.imgKeyBk);
                                                            if (imageView != null) {
                                                                i = R.id.imgNum0;
                                                                ImageView imageView2 = (ImageView) view2.findViewById(R.id.imgNum0);
                                                                if (imageView2 != null) {
                                                                    i = R.id.imgNum1;
                                                                    ImageView imageView3 = (ImageView) view2.findViewById(R.id.imgNum1);
                                                                    if (imageView3 != null) {
                                                                        i = R.id.imgNum2;
                                                                        ImageView imageView4 = (ImageView) view2.findViewById(R.id.imgNum2);
                                                                        if (imageView4 != null) {
                                                                            i = R.id.imgNum3;
                                                                            ImageView imageView5 = (ImageView) view2.findViewById(R.id.imgNum3);
                                                                            if (imageView5 != null) {
                                                                                i = R.id.imgNum4;
                                                                                ImageView imageView6 = (ImageView) view2.findViewById(R.id.imgNum4);
                                                                                if (imageView6 != null) {
                                                                                    i = R.id.imgNum5;
                                                                                    ImageView imageView7 = (ImageView) view2.findViewById(R.id.imgNum5);
                                                                                    if (imageView7 != null) {
                                                                                        i = R.id.imgNum6;
                                                                                        ImageView imageView8 = (ImageView) view2.findViewById(R.id.imgNum6);
                                                                                        if (imageView8 != null) {
                                                                                            i = R.id.imgNum7;
                                                                                            ImageView imageView9 = (ImageView) view2.findViewById(R.id.imgNum7);
                                                                                            if (imageView9 != null) {
                                                                                                i = R.id.imgNum8;
                                                                                                ImageView imageView10 = (ImageView) view2.findViewById(R.id.imgNum8);
                                                                                                if (imageView10 != null) {
                                                                                                    i = R.id.imgNum9;
                                                                                                    ImageView imageView11 = (ImageView) view2.findViewById(R.id.imgNum9);
                                                                                                    if (imageView11 != null) {
                                                                                                        i = R.id.imgNumEnter;
                                                                                                        ImageView imageView12 = (ImageView) view2.findViewById(R.id.imgNumEnter);
                                                                                                        if (imageView12 != null) {
                                                                                                            return new AudiCodeLayout1560x700Binding((ConstraintLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, imageButton12, textView, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12);
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
