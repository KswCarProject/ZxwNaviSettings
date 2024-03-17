package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.ClipRecyclerView;

public final class SmallKesaiwei1920x720BenzFragmentSysSetDvrBinding implements ViewBinding {
    public final ClipRecyclerView appList;
    public final ImageButton btnDvrCVBS;
    public final ImageButton btnDvrOFF;
    public final ImageButton btnDvrUSB;
    public final CheckBox kesaiweiDvrCVBS;
    public final CheckBox kesaiweiDvrOFF;
    public final CheckBox kesaiweiDvrUSB;
    private final RelativeLayout rootView;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout view2;
    public final RelativeLayout viewDvrApp;

    private SmallKesaiwei1920x720BenzFragmentSysSetDvrBinding(RelativeLayout relativeLayout, ClipRecyclerView clipRecyclerView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5) {
        this.rootView = relativeLayout;
        this.appList = clipRecyclerView;
        this.btnDvrCVBS = imageButton;
        this.btnDvrOFF = imageButton2;
        this.btnDvrUSB = imageButton3;
        this.kesaiweiDvrCVBS = checkBox;
        this.kesaiweiDvrOFF = checkBox2;
        this.kesaiweiDvrUSB = checkBox3;
        this.view0 = relativeLayout2;
        this.view1 = relativeLayout3;
        this.view2 = relativeLayout4;
        this.viewDvrApp = relativeLayout5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallKesaiwei1920x720BenzFragmentSysSetDvrBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallKesaiwei1920x720BenzFragmentSysSetDvrBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_dvr, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallKesaiwei1920x720BenzFragmentSysSetDvrBinding bind(View view) {
        int i = R.id.appList;
        ClipRecyclerView clipRecyclerView = (ClipRecyclerView) view.findViewById(R.id.appList);
        if (clipRecyclerView != null) {
            i = R.id.btnDvrCVBS;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnDvrCVBS);
            if (imageButton != null) {
                i = R.id.btnDvrOFF;
                ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnDvrOFF);
                if (imageButton2 != null) {
                    i = R.id.btnDvrUSB;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnDvrUSB);
                    if (imageButton3 != null) {
                        i = R.id.kesaiwei_dvr_CVBS;
                        CheckBox checkBox = (CheckBox) view.findViewById(R.id.kesaiwei_dvr_CVBS);
                        if (checkBox != null) {
                            i = R.id.kesaiwei_dvr_OFF;
                            CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.kesaiwei_dvr_OFF);
                            if (checkBox2 != null) {
                                i = R.id.kesaiwei_dvr_USB;
                                CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.kesaiwei_dvr_USB);
                                if (checkBox3 != null) {
                                    i = R.id.view0;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.view0);
                                    if (relativeLayout != null) {
                                        i = R.id.view1;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.view1);
                                        if (relativeLayout2 != null) {
                                            i = R.id.view2;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.view2);
                                            if (relativeLayout3 != null) {
                                                i = R.id.viewDvrApp;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.viewDvrApp);
                                                if (relativeLayout4 != null) {
                                                    return new SmallKesaiwei1920x720BenzFragmentSysSetDvrBinding((RelativeLayout) view, clipRecyclerView, imageButton, imageButton2, imageButton3, checkBox, checkBox2, checkBox3, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4);
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
