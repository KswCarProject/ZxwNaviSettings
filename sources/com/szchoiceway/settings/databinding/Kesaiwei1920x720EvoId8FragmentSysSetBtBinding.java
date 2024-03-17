package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId8FragmentSysSetBtBinding implements ViewBinding {
    public final ImageButton btnExternalBT;
    public final ImageButton btnInstallBT;
    public final ImageButton btnOriginalBT;
    public final CheckBox kesaiweiExternalBT;
    public final CheckBox kesaiweiInstallBT;
    public final CheckBox kesaiweiOriginalBT;
    private final RelativeLayout rootView;
    public final RelativeLayout viewExternalBt;

    private Kesaiwei1920x720EvoId8FragmentSysSetBtBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.btnExternalBT = imageButton;
        this.btnInstallBT = imageButton2;
        this.btnOriginalBT = imageButton3;
        this.kesaiweiExternalBT = checkBox;
        this.kesaiweiInstallBT = checkBox2;
        this.kesaiweiOriginalBT = checkBox3;
        this.viewExternalBt = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetBtBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetBtBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_bt, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId8FragmentSysSetBtBinding bind(View view) {
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
                                i = R.id.viewExternalBt;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.viewExternalBt);
                                if (relativeLayout != null) {
                                    return new Kesaiwei1920x720EvoId8FragmentSysSetBtBinding((RelativeLayout) view, imageButton, imageButton2, imageButton3, checkBox, checkBox2, checkBox3, relativeLayout);
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
