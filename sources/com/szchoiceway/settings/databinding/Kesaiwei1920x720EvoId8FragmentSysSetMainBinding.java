package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720EvoId8FragmentSysSetMainBinding implements ViewBinding {
    public final RadioButton btnAuxSwitchSet;
    public final RadioButton btnBackCarSet;
    public final RadioButton btnBtSet;
    public final RadioButton btnDisplaySet;
    public final RadioButton btnDvrSet;
    public final RadioButton btnMusicAppSet;
    public final RadioButton btnOtherSet;
    public final ImageButton btnReturn;
    public final RadioButton btnUnitSet;
    public final RadioButton btnVideoAppSet;
    public final ImageView imgDirection;
    public final ImageView imgLeftBg;
    public final ImageView imgRightBg;
    public final ImageView imgRightIcon;
    public final MyScrollbar myScrollbar;
    public final RadioGroup radioGroup;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollLayout;
    public final ScrollView systemScrollView;
    public final IndexViewPager viewPager;
    public final ImageView viewProductLine;

    private Kesaiwei1920x720EvoId8FragmentSysSetMainBinding(RelativeLayout relativeLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, ImageButton imageButton, RadioButton radioButton8, RadioButton radioButton9, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, MyScrollbar myScrollbar2, RadioGroup radioGroup2, RelativeLayout relativeLayout2, ScrollView scrollView, IndexViewPager indexViewPager, ImageView imageView5) {
        this.rootView = relativeLayout;
        this.btnAuxSwitchSet = radioButton;
        this.btnBackCarSet = radioButton2;
        this.btnBtSet = radioButton3;
        this.btnDisplaySet = radioButton4;
        this.btnDvrSet = radioButton5;
        this.btnMusicAppSet = radioButton6;
        this.btnOtherSet = radioButton7;
        this.btnReturn = imageButton;
        this.btnUnitSet = radioButton8;
        this.btnVideoAppSet = radioButton9;
        this.imgDirection = imageView;
        this.imgLeftBg = imageView2;
        this.imgRightBg = imageView3;
        this.imgRightIcon = imageView4;
        this.myScrollbar = myScrollbar2;
        this.radioGroup = radioGroup2;
        this.scrollLayout = relativeLayout2;
        this.systemScrollView = scrollView;
        this.viewPager = indexViewPager;
        this.viewProductLine = imageView5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetMainBinding bind(View view) {
        View view2 = view;
        int i = R.id.btnAuxSwitchSet;
        RadioButton radioButton = (RadioButton) view2.findViewById(R.id.btnAuxSwitchSet);
        if (radioButton != null) {
            i = R.id.btnBackCarSet;
            RadioButton radioButton2 = (RadioButton) view2.findViewById(R.id.btnBackCarSet);
            if (radioButton2 != null) {
                i = R.id.btnBtSet;
                RadioButton radioButton3 = (RadioButton) view2.findViewById(R.id.btnBtSet);
                if (radioButton3 != null) {
                    i = R.id.btnDisplaySet;
                    RadioButton radioButton4 = (RadioButton) view2.findViewById(R.id.btnDisplaySet);
                    if (radioButton4 != null) {
                        i = R.id.btnDvrSet;
                        RadioButton radioButton5 = (RadioButton) view2.findViewById(R.id.btnDvrSet);
                        if (radioButton5 != null) {
                            i = R.id.btnMusicAppSet;
                            RadioButton radioButton6 = (RadioButton) view2.findViewById(R.id.btnMusicAppSet);
                            if (radioButton6 != null) {
                                i = R.id.btnOtherSet;
                                RadioButton radioButton7 = (RadioButton) view2.findViewById(R.id.btnOtherSet);
                                if (radioButton7 != null) {
                                    i = R.id.btnReturn;
                                    ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btnReturn);
                                    if (imageButton != null) {
                                        i = R.id.btnUnitSet;
                                        RadioButton radioButton8 = (RadioButton) view2.findViewById(R.id.btnUnitSet);
                                        if (radioButton8 != null) {
                                            i = R.id.btnVideoAppSet;
                                            RadioButton radioButton9 = (RadioButton) view2.findViewById(R.id.btnVideoAppSet);
                                            if (radioButton9 != null) {
                                                i = R.id.imgDirection;
                                                ImageView imageView = (ImageView) view2.findViewById(R.id.imgDirection);
                                                if (imageView != null) {
                                                    i = R.id.imgLeftBg;
                                                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.imgLeftBg);
                                                    if (imageView2 != null) {
                                                        i = R.id.imgRightBg;
                                                        ImageView imageView3 = (ImageView) view2.findViewById(R.id.imgRightBg);
                                                        if (imageView3 != null) {
                                                            i = R.id.imgRightIcon;
                                                            ImageView imageView4 = (ImageView) view2.findViewById(R.id.imgRightIcon);
                                                            if (imageView4 != null) {
                                                                i = R.id.myScrollbar;
                                                                MyScrollbar myScrollbar2 = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
                                                                if (myScrollbar2 != null) {
                                                                    i = R.id.radioGroup;
                                                                    RadioGroup radioGroup2 = (RadioGroup) view2.findViewById(R.id.radioGroup);
                                                                    if (radioGroup2 != null) {
                                                                        i = R.id.scrollLayout;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.scrollLayout);
                                                                        if (relativeLayout != null) {
                                                                            i = R.id.systemScrollView;
                                                                            ScrollView scrollView = (ScrollView) view2.findViewById(R.id.systemScrollView);
                                                                            if (scrollView != null) {
                                                                                i = R.id.viewPager;
                                                                                IndexViewPager indexViewPager = (IndexViewPager) view2.findViewById(R.id.viewPager);
                                                                                if (indexViewPager != null) {
                                                                                    i = R.id.viewProductLine;
                                                                                    ImageView imageView5 = (ImageView) view2.findViewById(R.id.viewProductLine);
                                                                                    if (imageView5 != null) {
                                                                                        return new Kesaiwei1920x720EvoId8FragmentSysSetMainBinding((RelativeLayout) view2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, imageButton, radioButton8, radioButton9, imageView, imageView2, imageView3, imageView4, myScrollbar2, radioGroup2, relativeLayout, scrollView, indexViewPager, imageView5);
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
