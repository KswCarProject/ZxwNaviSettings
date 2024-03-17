package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class AudiFragmentLanguageSetBinding implements ViewBinding {
    public final CheckBox CkbLangAR;
    public final CheckBox CkbLangDE;
    public final CheckBox CkbLangEL;
    public final CheckBox CkbLangEN;
    public final CheckBox CkbLangES;
    public final CheckBox CkbLangFR;
    public final CheckBox CkbLangHR;
    public final CheckBox CkbLangIT;
    public final CheckBox CkbLangIW;
    public final CheckBox CkbLangJA;
    public final CheckBox CkbLangKO;
    public final CheckBox CkbLangNL;
    public final CheckBox CkbLangPL;
    public final CheckBox CkbLangPT;
    public final CheckBox CkbLangRU;
    public final CheckBox CkbLangSCN;
    public final CheckBox CkbLangTCN;
    public final CheckBox CkbLangTH;
    public final CheckBox CkbLangTR;
    public final CheckBox CkbLangVI;
    public final ImageButton btnLangAR;
    public final ImageButton btnLangDE;
    public final ImageButton btnLangEL;
    public final ImageButton btnLangEN;
    public final ImageButton btnLangES;
    public final ImageButton btnLangFR;
    public final ImageButton btnLangHR;
    public final ImageButton btnLangIT;
    public final ImageButton btnLangIW;
    public final ImageButton btnLangJA;
    public final ImageButton btnLangKO;
    public final ImageButton btnLangNL;
    public final ImageButton btnLangPL;
    public final ImageButton btnLangPT;
    public final ImageButton btnLangRU;
    public final ImageButton btnLangSCN;
    public final ImageButton btnLangTCN;
    public final ImageButton btnLangTH;
    public final ImageButton btnLangTR;
    public final ImageButton btnLangVI;
    public final ScrollView mScrollView;
    public final MyScrollbar myScrollbar;
    private final RelativeLayout rootView;
    public final LinearLayout scrollLayout;

    private AudiFragmentLanguageSetBinding(RelativeLayout relativeLayout, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9, CheckBox checkBox10, CheckBox checkBox11, CheckBox checkBox12, CheckBox checkBox13, CheckBox checkBox14, CheckBox checkBox15, CheckBox checkBox16, CheckBox checkBox17, CheckBox checkBox18, CheckBox checkBox19, CheckBox checkBox20, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, ImageButton imageButton12, ImageButton imageButton13, ImageButton imageButton14, ImageButton imageButton15, ImageButton imageButton16, ImageButton imageButton17, ImageButton imageButton18, ImageButton imageButton19, ImageButton imageButton20, ScrollView scrollView, MyScrollbar myScrollbar2, LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.CkbLangAR = checkBox;
        this.CkbLangDE = checkBox2;
        this.CkbLangEL = checkBox3;
        this.CkbLangEN = checkBox4;
        this.CkbLangES = checkBox5;
        this.CkbLangFR = checkBox6;
        this.CkbLangHR = checkBox7;
        this.CkbLangIT = checkBox8;
        this.CkbLangIW = checkBox9;
        this.CkbLangJA = checkBox10;
        this.CkbLangKO = checkBox11;
        this.CkbLangNL = checkBox12;
        this.CkbLangPL = checkBox13;
        this.CkbLangPT = checkBox14;
        this.CkbLangRU = checkBox15;
        this.CkbLangSCN = checkBox16;
        this.CkbLangTCN = checkBox17;
        this.CkbLangTH = checkBox18;
        this.CkbLangTR = checkBox19;
        this.CkbLangVI = checkBox20;
        this.btnLangAR = imageButton;
        this.btnLangDE = imageButton2;
        this.btnLangEL = imageButton3;
        this.btnLangEN = imageButton4;
        this.btnLangES = imageButton5;
        this.btnLangFR = imageButton6;
        this.btnLangHR = imageButton7;
        this.btnLangIT = imageButton8;
        this.btnLangIW = imageButton9;
        this.btnLangJA = imageButton10;
        this.btnLangKO = imageButton11;
        this.btnLangNL = imageButton12;
        this.btnLangPL = imageButton13;
        this.btnLangPT = imageButton14;
        this.btnLangRU = imageButton15;
        this.btnLangSCN = imageButton16;
        this.btnLangTCN = imageButton17;
        this.btnLangTH = imageButton18;
        this.btnLangTR = imageButton19;
        this.btnLangVI = imageButton20;
        this.mScrollView = scrollView;
        this.myScrollbar = myScrollbar2;
        this.scrollLayout = linearLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AudiFragmentLanguageSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiFragmentLanguageSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_fragment_language_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiFragmentLanguageSetBinding bind(View view) {
        View view2 = view;
        int i = R.id.CkbLangAR;
        CheckBox checkBox = (CheckBox) view2.findViewById(R.id.CkbLangAR);
        if (checkBox != null) {
            i = R.id.CkbLangDE;
            CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.CkbLangDE);
            if (checkBox2 != null) {
                i = R.id.CkbLangEL;
                CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.CkbLangEL);
                if (checkBox3 != null) {
                    i = R.id.CkbLangEN;
                    CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.CkbLangEN);
                    if (checkBox4 != null) {
                        i = R.id.CkbLangES;
                        CheckBox checkBox5 = (CheckBox) view2.findViewById(R.id.CkbLangES);
                        if (checkBox5 != null) {
                            i = R.id.CkbLangFR;
                            CheckBox checkBox6 = (CheckBox) view2.findViewById(R.id.CkbLangFR);
                            if (checkBox6 != null) {
                                i = R.id.CkbLangHR;
                                CheckBox checkBox7 = (CheckBox) view2.findViewById(R.id.CkbLangHR);
                                if (checkBox7 != null) {
                                    i = R.id.CkbLangIT;
                                    CheckBox checkBox8 = (CheckBox) view2.findViewById(R.id.CkbLangIT);
                                    if (checkBox8 != null) {
                                        i = R.id.CkbLangIW;
                                        CheckBox checkBox9 = (CheckBox) view2.findViewById(R.id.CkbLangIW);
                                        if (checkBox9 != null) {
                                            i = R.id.CkbLangJA;
                                            CheckBox checkBox10 = (CheckBox) view2.findViewById(R.id.CkbLangJA);
                                            if (checkBox10 != null) {
                                                i = R.id.CkbLangKO;
                                                CheckBox checkBox11 = (CheckBox) view2.findViewById(R.id.CkbLangKO);
                                                if (checkBox11 != null) {
                                                    i = R.id.CkbLangNL;
                                                    CheckBox checkBox12 = (CheckBox) view2.findViewById(R.id.CkbLangNL);
                                                    if (checkBox12 != null) {
                                                        i = R.id.CkbLangPL;
                                                        CheckBox checkBox13 = (CheckBox) view2.findViewById(R.id.CkbLangPL);
                                                        if (checkBox13 != null) {
                                                            i = R.id.CkbLangPT;
                                                            CheckBox checkBox14 = (CheckBox) view2.findViewById(R.id.CkbLangPT);
                                                            if (checkBox14 != null) {
                                                                i = R.id.CkbLangRU;
                                                                CheckBox checkBox15 = (CheckBox) view2.findViewById(R.id.CkbLangRU);
                                                                if (checkBox15 != null) {
                                                                    i = R.id.CkbLangSCN;
                                                                    CheckBox checkBox16 = (CheckBox) view2.findViewById(R.id.CkbLangSCN);
                                                                    if (checkBox16 != null) {
                                                                        i = R.id.CkbLangTCN;
                                                                        CheckBox checkBox17 = (CheckBox) view2.findViewById(R.id.CkbLangTCN);
                                                                        if (checkBox17 != null) {
                                                                            i = R.id.CkbLangTH;
                                                                            CheckBox checkBox18 = (CheckBox) view2.findViewById(R.id.CkbLangTH);
                                                                            if (checkBox18 != null) {
                                                                                i = R.id.CkbLangTR;
                                                                                CheckBox checkBox19 = (CheckBox) view2.findViewById(R.id.CkbLangTR);
                                                                                if (checkBox19 != null) {
                                                                                    i = R.id.CkbLangVI;
                                                                                    CheckBox checkBox20 = (CheckBox) view2.findViewById(R.id.CkbLangVI);
                                                                                    if (checkBox20 != null) {
                                                                                        i = R.id.btnLangAR;
                                                                                        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btnLangAR);
                                                                                        if (imageButton != null) {
                                                                                            i = R.id.btnLangDE;
                                                                                            ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btnLangDE);
                                                                                            if (imageButton2 != null) {
                                                                                                i = R.id.btnLangEL;
                                                                                                ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnLangEL);
                                                                                                if (imageButton3 != null) {
                                                                                                    i = R.id.btnLangEN;
                                                                                                    ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.btnLangEN);
                                                                                                    if (imageButton4 != null) {
                                                                                                        i = R.id.btnLangES;
                                                                                                        ImageButton imageButton5 = (ImageButton) view2.findViewById(R.id.btnLangES);
                                                                                                        if (imageButton5 != null) {
                                                                                                            i = R.id.btnLangFR;
                                                                                                            ImageButton imageButton6 = (ImageButton) view2.findViewById(R.id.btnLangFR);
                                                                                                            if (imageButton6 != null) {
                                                                                                                i = R.id.btnLangHR;
                                                                                                                ImageButton imageButton7 = (ImageButton) view2.findViewById(R.id.btnLangHR);
                                                                                                                if (imageButton7 != null) {
                                                                                                                    i = R.id.btnLangIT;
                                                                                                                    ImageButton imageButton8 = (ImageButton) view2.findViewById(R.id.btnLangIT);
                                                                                                                    if (imageButton8 != null) {
                                                                                                                        i = R.id.btnLangIW;
                                                                                                                        ImageButton imageButton9 = (ImageButton) view2.findViewById(R.id.btnLangIW);
                                                                                                                        if (imageButton9 != null) {
                                                                                                                            i = R.id.btnLangJA;
                                                                                                                            ImageButton imageButton10 = (ImageButton) view2.findViewById(R.id.btnLangJA);
                                                                                                                            if (imageButton10 != null) {
                                                                                                                                i = R.id.btnLangKO;
                                                                                                                                ImageButton imageButton11 = (ImageButton) view2.findViewById(R.id.btnLangKO);
                                                                                                                                if (imageButton11 != null) {
                                                                                                                                    i = R.id.btnLangNL;
                                                                                                                                    ImageButton imageButton12 = (ImageButton) view2.findViewById(R.id.btnLangNL);
                                                                                                                                    if (imageButton12 != null) {
                                                                                                                                        i = R.id.btnLangPL;
                                                                                                                                        ImageButton imageButton13 = (ImageButton) view2.findViewById(R.id.btnLangPL);
                                                                                                                                        if (imageButton13 != null) {
                                                                                                                                            i = R.id.btnLangPT;
                                                                                                                                            ImageButton imageButton14 = (ImageButton) view2.findViewById(R.id.btnLangPT);
                                                                                                                                            if (imageButton14 != null) {
                                                                                                                                                i = R.id.btnLangRU;
                                                                                                                                                ImageButton imageButton15 = (ImageButton) view2.findViewById(R.id.btnLangRU);
                                                                                                                                                if (imageButton15 != null) {
                                                                                                                                                    i = R.id.btnLangSCN;
                                                                                                                                                    ImageButton imageButton16 = (ImageButton) view2.findViewById(R.id.btnLangSCN);
                                                                                                                                                    if (imageButton16 != null) {
                                                                                                                                                        i = R.id.btnLangTCN;
                                                                                                                                                        ImageButton imageButton17 = (ImageButton) view2.findViewById(R.id.btnLangTCN);
                                                                                                                                                        if (imageButton17 != null) {
                                                                                                                                                            i = R.id.btnLangTH;
                                                                                                                                                            ImageButton imageButton18 = (ImageButton) view2.findViewById(R.id.btnLangTH);
                                                                                                                                                            if (imageButton18 != null) {
                                                                                                                                                                i = R.id.btnLangTR;
                                                                                                                                                                ImageButton imageButton19 = (ImageButton) view2.findViewById(R.id.btnLangTR);
                                                                                                                                                                if (imageButton19 != null) {
                                                                                                                                                                    i = R.id.btnLangVI;
                                                                                                                                                                    ImageButton imageButton20 = (ImageButton) view2.findViewById(R.id.btnLangVI);
                                                                                                                                                                    if (imageButton20 != null) {
                                                                                                                                                                        i = R.id.mScrollView;
                                                                                                                                                                        ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mScrollView);
                                                                                                                                                                        if (scrollView != null) {
                                                                                                                                                                            i = R.id.myScrollbar;
                                                                                                                                                                            MyScrollbar myScrollbar2 = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
                                                                                                                                                                            if (myScrollbar2 != null) {
                                                                                                                                                                                i = R.id.scrollLayout;
                                                                                                                                                                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.scrollLayout);
                                                                                                                                                                                if (linearLayout != null) {
                                                                                                                                                                                    return new AudiFragmentLanguageSetBinding((RelativeLayout) view2, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17, checkBox18, checkBox19, checkBox20, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, imageButton12, imageButton13, imageButton14, imageButton15, imageButton16, imageButton17, imageButton18, imageButton19, imageButton20, scrollView, myScrollbar2, linearLayout);
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
