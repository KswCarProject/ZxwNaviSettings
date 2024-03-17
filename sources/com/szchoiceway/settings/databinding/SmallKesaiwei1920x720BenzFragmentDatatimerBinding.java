package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class SmallKesaiwei1920x720BenzFragmentDatatimerBinding implements ViewBinding {
    public final ImageButton btn12Hour;
    public final ImageButton btn24Hour;
    public final ImageButton btnAutoSync;
    public final ImageButton btnOriginalTime;
    public final RelativeLayout content0;
    public final RelativeLayout content1;
    public final RelativeLayout content2;
    public final RelativeLayout content3;
    public final CheckBox kesaiwei12Hour;
    public final CheckBox kesaiwei24Hour;
    public final CheckBox kesaiweiAutoSync;
    public final CheckBox kesaiweiOriginalTime;
    public final ScrollView mScrollView;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollLayout;
    public final RelativeLayout title0;
    public final RelativeLayout title1;

    private SmallKesaiwei1920x720BenzFragmentDatatimerBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, ScrollView scrollView, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8) {
        this.rootView = relativeLayout;
        this.btn12Hour = imageButton;
        this.btn24Hour = imageButton2;
        this.btnAutoSync = imageButton3;
        this.btnOriginalTime = imageButton4;
        this.content0 = relativeLayout2;
        this.content1 = relativeLayout3;
        this.content2 = relativeLayout4;
        this.content3 = relativeLayout5;
        this.kesaiwei12Hour = checkBox;
        this.kesaiwei24Hour = checkBox2;
        this.kesaiweiAutoSync = checkBox3;
        this.kesaiweiOriginalTime = checkBox4;
        this.mScrollView = scrollView;
        this.scrollLayout = relativeLayout6;
        this.title0 = relativeLayout7;
        this.title1 = relativeLayout8;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallKesaiwei1920x720BenzFragmentDatatimerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallKesaiwei1920x720BenzFragmentDatatimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_datatimer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallKesaiwei1920x720BenzFragmentDatatimerBinding bind(View view) {
        View view2 = view;
        int i = R.id.btn12Hour;
        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btn12Hour);
        if (imageButton != null) {
            i = R.id.btn24Hour;
            ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btn24Hour);
            if (imageButton2 != null) {
                i = R.id.btnAutoSync;
                ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnAutoSync);
                if (imageButton3 != null) {
                    i = R.id.btnOriginalTime;
                    ImageButton imageButton4 = (ImageButton) view2.findViewById(R.id.btnOriginalTime);
                    if (imageButton4 != null) {
                        i = R.id.content0;
                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.content0);
                        if (relativeLayout != null) {
                            i = R.id.content1;
                            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.content1);
                            if (relativeLayout2 != null) {
                                i = R.id.content2;
                                RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.content2);
                                if (relativeLayout3 != null) {
                                    i = R.id.content3;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) view2.findViewById(R.id.content3);
                                    if (relativeLayout4 != null) {
                                        i = R.id.kesaiwei_12_hour;
                                        CheckBox checkBox = (CheckBox) view2.findViewById(R.id.kesaiwei_12_hour);
                                        if (checkBox != null) {
                                            i = R.id.kesaiwei_24_hour;
                                            CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.kesaiwei_24_hour);
                                            if (checkBox2 != null) {
                                                i = R.id.kesaiwei_Auto_Sync;
                                                CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.kesaiwei_Auto_Sync);
                                                if (checkBox3 != null) {
                                                    i = R.id.kesaiwei_Original_Time;
                                                    CheckBox checkBox4 = (CheckBox) view2.findViewById(R.id.kesaiwei_Original_Time);
                                                    if (checkBox4 != null) {
                                                        i = R.id.mScrollView;
                                                        ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mScrollView);
                                                        if (scrollView != null) {
                                                            i = R.id.scrollLayout;
                                                            RelativeLayout relativeLayout5 = (RelativeLayout) view2.findViewById(R.id.scrollLayout);
                                                            if (relativeLayout5 != null) {
                                                                i = R.id.title0;
                                                                RelativeLayout relativeLayout6 = (RelativeLayout) view2.findViewById(R.id.title0);
                                                                if (relativeLayout6 != null) {
                                                                    i = R.id.title1;
                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) view2.findViewById(R.id.title1);
                                                                    if (relativeLayout7 != null) {
                                                                        return new SmallKesaiwei1920x720BenzFragmentDatatimerBinding((RelativeLayout) view2, imageButton, imageButton2, imageButton3, imageButton4, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, checkBox, checkBox2, checkBox3, checkBox4, scrollView, relativeLayout5, relativeLayout6, relativeLayout7);
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
