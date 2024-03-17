package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentSysSetDvrBinding implements ViewBinding {
    public final RecyclerView appList;
    public final ImageButton btnDvrCVBS;
    public final ImageButton btnDvrOFF;
    public final ImageButton btnDvrUSB;
    public final CheckBox kesaiweiDvrCVBS;
    public final CheckBox kesaiweiDvrOFF;
    public final CheckBox kesaiweiDvrUSB;
    public final ImageView lineUnitDistance;
    private final RelativeLayout rootView;
    public final TextView txtDvrApk;
    public final RelativeLayout viewDvrApp;

    private Kesaiwei1920x720EvoId7FragmentSysSetDvrBinding(RelativeLayout relativeLayout, RecyclerView recyclerView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, ImageView imageView, TextView textView, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.appList = recyclerView;
        this.btnDvrCVBS = imageButton;
        this.btnDvrOFF = imageButton2;
        this.btnDvrUSB = imageButton3;
        this.kesaiweiDvrCVBS = checkBox;
        this.kesaiweiDvrOFF = checkBox2;
        this.kesaiweiDvrUSB = checkBox3;
        this.lineUnitDistance = imageView;
        this.txtDvrApk = textView;
        this.viewDvrApp = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetDvrBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetDvrBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_dvr, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetDvrBinding bind(View view) {
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
                                    i = R.id.lineUnitDistance;
                                    ImageView imageView = (ImageView) view.findViewById(R.id.lineUnitDistance);
                                    if (imageView != null) {
                                        i = R.id.txtDvrApk;
                                        TextView textView = (TextView) view.findViewById(R.id.txtDvrApk);
                                        if (textView != null) {
                                            i = R.id.viewDvrApp;
                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.viewDvrApp);
                                            if (relativeLayout != null) {
                                                return new Kesaiwei1920x720EvoId7FragmentSysSetDvrBinding((RelativeLayout) view, recyclerView, imageButton, imageButton2, imageButton3, checkBox, checkBox2, checkBox3, imageView, textView, relativeLayout);
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
