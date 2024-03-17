package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.MyScrollbar;

public final class Kesaiwei1920x720EvoId8FragmentSysSetDvrBinding implements ViewBinding {
    public final RecyclerView appList;
    public final ImageButton btnDvrCVBS;
    public final ImageButton btnDvrOFF;
    public final ImageButton btnDvrUSB;
    public final CheckBox kesaiweiDvrCVBS;
    public final CheckBox kesaiweiDvrOFF;
    public final CheckBox kesaiweiDvrUSB;
    public final MyScrollbar myScrollbar;
    private final RelativeLayout rootView;
    public final RelativeLayout view1;
    public final RelativeLayout viewDvrApp;

    private Kesaiwei1920x720EvoId8FragmentSysSetDvrBinding(RelativeLayout relativeLayout, RecyclerView recyclerView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, MyScrollbar myScrollbar2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.appList = recyclerView;
        this.btnDvrCVBS = imageButton;
        this.btnDvrOFF = imageButton2;
        this.btnDvrUSB = imageButton3;
        this.kesaiweiDvrCVBS = checkBox;
        this.kesaiweiDvrOFF = checkBox2;
        this.kesaiweiDvrUSB = checkBox3;
        this.myScrollbar = myScrollbar2;
        this.view1 = relativeLayout2;
        this.viewDvrApp = relativeLayout3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetDvrBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetDvrBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_dvr, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetDvrBinding bind(View view) {
        int i = R.id.appList;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.appList);
        if (recyclerView != null) {
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
                                    i = R.id.myScrollbar;
                                    MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
                                    if (myScrollbar2 != null) {
                                        i = R.id.view1;
                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.view1);
                                        if (relativeLayout != null) {
                                            i = R.id.viewDvrApp;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.viewDvrApp);
                                            if (relativeLayout2 != null) {
                                                return new Kesaiwei1920x720EvoId8FragmentSysSetDvrBinding((RelativeLayout) view, recyclerView, imageButton, imageButton2, imageButton3, checkBox, checkBox2, checkBox3, myScrollbar2, relativeLayout, relativeLayout2);
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
