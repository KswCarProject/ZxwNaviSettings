package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class SmallKesaiwei1920x720BenzFragmentSysSetBtBinding implements ViewBinding {
    public final ImageButton btnExternalBT;
    public final ImageButton btnInstallBT;
    public final ImageButton btnOriginalBT;
    public final CheckBox kesaiweiExternalBT;
    public final CheckBox kesaiweiInstallBT;
    public final CheckBox kesaiweiOriginalBT;
    private final RelativeLayout rootView;
    public final RelativeLayout txtBTPower;
    public final RelativeLayout view0;
    public final RelativeLayout view1;
    public final RelativeLayout viewExternalBt;
    public final ImageView viewLine;

    private SmallKesaiwei1920x720BenzFragmentSysSetBtBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, ImageView imageView) {
        this.rootView = relativeLayout;
        this.btnExternalBT = imageButton;
        this.btnInstallBT = imageButton2;
        this.btnOriginalBT = imageButton3;
        this.kesaiweiExternalBT = checkBox;
        this.kesaiweiInstallBT = checkBox2;
        this.kesaiweiOriginalBT = checkBox3;
        this.txtBTPower = relativeLayout2;
        this.view0 = relativeLayout3;
        this.view1 = relativeLayout4;
        this.viewExternalBt = relativeLayout5;
        this.viewLine = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallKesaiwei1920x720BenzFragmentSysSetBtBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallKesaiwei1920x720BenzFragmentSysSetBtBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_bt, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallKesaiwei1920x720BenzFragmentSysSetBtBinding bind(View view) {
        int i = R.id.btnExternalBT;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnExternalBT);
        if (imageButton != null) {
            i = R.id.btnInstallBT;
            ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnInstallBT);
            if (imageButton2 != null) {
                i = R.id.btnOriginalBT;
                ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnOriginalBT);
                if (imageButton3 != null) {
                    i = R.id.kesaiwei_External_BT;
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.kesaiwei_External_BT);
                    if (checkBox != null) {
                        i = R.id.kesaiwei_Install_BT;
                        CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.kesaiwei_Install_BT);
                        if (checkBox2 != null) {
                            i = R.id.kesaiwei_Original_BT;
                            CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.kesaiwei_Original_BT);
                            if (checkBox3 != null) {
                                i = R.id.txtBTPower;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.txtBTPower);
                                if (relativeLayout != null) {
                                    i = R.id.view0;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.view0);
                                    if (relativeLayout2 != null) {
                                        i = R.id.view1;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.view1);
                                        if (relativeLayout3 != null) {
                                            i = R.id.viewExternalBt;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.viewExternalBt);
                                            if (relativeLayout4 != null) {
                                                i = R.id.viewLine;
                                                ImageView imageView = (ImageView) view.findViewById(R.id.viewLine);
                                                if (imageView != null) {
                                                    return new SmallKesaiwei1920x720BenzFragmentSysSetBtBinding((RelativeLayout) view, imageButton, imageButton2, imageButton3, checkBox, checkBox2, checkBox3, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, imageView);
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
