package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.IndexViewPager;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class AudiFragmentSysSetMain1560x700Binding implements ViewBinding {
    public final RadioButton btnAuxSwitchSet;
    public final RadioButton btnBackCarSet;
    public final RadioButton btnBtSet;
    public final RadioButton btnDisplaySet;
    public final RadioButton btnDvrSet;
    public final RadioButton btnMusicAppSet;
    public final RadioButton btnOtherSet;
    public final RadioButton btnUnitSet;
    public final RadioButton btnVideoAppSet;
    public final RelativeLayout listView;
    public final MyScrollbar myScrollbar;
    public final RelativeLayout pagerView;
    public final RadioGroup radioGroup;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollLayout;
    public final ScrollView systemScrollView;
    public final IndexViewPager viewPager;

    private AudiFragmentSysSetMain1560x700Binding(RelativeLayout relativeLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RelativeLayout relativeLayout2, MyScrollbar myScrollbar2, RelativeLayout relativeLayout3, RadioGroup radioGroup2, RelativeLayout relativeLayout4, ScrollView scrollView, IndexViewPager indexViewPager) {
        this.rootView = relativeLayout;
        this.btnAuxSwitchSet = radioButton;
        this.btnBackCarSet = radioButton2;
        this.btnBtSet = radioButton3;
        this.btnDisplaySet = radioButton4;
        this.btnDvrSet = radioButton5;
        this.btnMusicAppSet = radioButton6;
        this.btnOtherSet = radioButton7;
        this.btnUnitSet = radioButton8;
        this.btnVideoAppSet = radioButton9;
        this.listView = relativeLayout2;
        this.myScrollbar = myScrollbar2;
        this.pagerView = relativeLayout3;
        this.radioGroup = radioGroup2;
        this.scrollLayout = relativeLayout4;
        this.systemScrollView = scrollView;
        this.viewPager = indexViewPager;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AudiFragmentSysSetMain1560x700Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AudiFragmentSysSetMain1560x700Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audi_fragment_sys_set_main_1560x700, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AudiFragmentSysSetMain1560x700Binding bind(View view) {
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
                                    i = R.id.btnUnitSet;
                                    RadioButton radioButton8 = (RadioButton) view2.findViewById(R.id.btnUnitSet);
                                    if (radioButton8 != null) {
                                        i = R.id.btnVideoAppSet;
                                        RadioButton radioButton9 = (RadioButton) view2.findViewById(R.id.btnVideoAppSet);
                                        if (radioButton9 != null) {
                                            i = R.id.listView;
                                            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.listView);
                                            if (relativeLayout != null) {
                                                i = R.id.myScrollbar;
                                                MyScrollbar myScrollbar2 = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
                                                if (myScrollbar2 != null) {
                                                    i = R.id.pagerView;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.pagerView);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.radioGroup;
                                                        RadioGroup radioGroup2 = (RadioGroup) view2.findViewById(R.id.radioGroup);
                                                        if (radioGroup2 != null) {
                                                            i = R.id.scrollLayout;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.scrollLayout);
                                                            if (relativeLayout3 != null) {
                                                                i = R.id.systemScrollView;
                                                                ScrollView scrollView = (ScrollView) view2.findViewById(R.id.systemScrollView);
                                                                if (scrollView != null) {
                                                                    i = R.id.viewPager;
                                                                    IndexViewPager indexViewPager = (IndexViewPager) view2.findViewById(R.id.viewPager);
                                                                    if (indexViewPager != null) {
                                                                        return new AudiFragmentSysSetMain1560x700Binding((RelativeLayout) view2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9, relativeLayout, myScrollbar2, relativeLayout2, radioGroup2, relativeLayout3, scrollView, indexViewPager);
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
