package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720EvoId7FragmentSysSetBtBinding implements ViewBinding {
    public final TextView KSWBTGain;
    public final SeekBar KSWBTGainSeekBar;
    public final ImageButton btnExternalBT;
    public final ImageButton btnInstallBT;
    public final ImageButton btnOriginalBT;
    public final CheckBox kesaiweiExternalBT;
    public final CheckBox kesaiweiInstallBT;
    public final CheckBox kesaiweiOriginalBT;
    public final ImageView lineBT;
    private final RelativeLayout rootView;
    public final TextView txtBT;
    public final TextView txtBTPower;
    public final RelativeLayout viewExternalBt;

    private Kesaiwei1920x720EvoId7FragmentSysSetBtBinding(RelativeLayout relativeLayout, TextView textView, SeekBar seekBar, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, ImageView imageView, TextView textView2, TextView textView3, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.KSWBTGain = textView;
        this.KSWBTGainSeekBar = seekBar;
        this.btnExternalBT = imageButton;
        this.btnInstallBT = imageButton2;
        this.btnOriginalBT = imageButton3;
        this.kesaiweiExternalBT = checkBox;
        this.kesaiweiInstallBT = checkBox2;
        this.kesaiweiOriginalBT = checkBox3;
        this.lineBT = imageView;
        this.txtBT = textView2;
        this.txtBTPower = textView3;
        this.viewExternalBt = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetBtBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetBtBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_bt, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720EvoId7FragmentSysSetBtBinding bind(View view) {
        View view2 = view;
        int i = R.id.KSW_BTGain;
        TextView textView = (TextView) view2.findViewById(R.id.KSW_BTGain);
        if (textView != null) {
            i = R.id.KSW_BTGainSeekBar;
            SeekBar seekBar = (SeekBar) view2.findViewById(R.id.KSW_BTGainSeekBar);
            if (seekBar != null) {
                i = R.id.btnExternalBT;
                ImageButton imageButton = (ImageButton) view2.findViewById(R.id.btnExternalBT);
                if (imageButton != null) {
                    i = R.id.btnInstallBT;
                    ImageButton imageButton2 = (ImageButton) view2.findViewById(R.id.btnInstallBT);
                    if (imageButton2 != null) {
                        i = R.id.btnOriginalBT;
                        ImageButton imageButton3 = (ImageButton) view2.findViewById(R.id.btnOriginalBT);
                        if (imageButton3 != null) {
                            i = R.id.kesaiwei_External_BT;
                            CheckBox checkBox = (CheckBox) view2.findViewById(R.id.kesaiwei_External_BT);
                            if (checkBox != null) {
                                i = R.id.kesaiwei_Install_BT;
                                CheckBox checkBox2 = (CheckBox) view2.findViewById(R.id.kesaiwei_Install_BT);
                                if (checkBox2 != null) {
                                    i = R.id.kesaiwei_Original_BT;
                                    CheckBox checkBox3 = (CheckBox) view2.findViewById(R.id.kesaiwei_Original_BT);
                                    if (checkBox3 != null) {
                                        i = R.id.lineBT;
                                        ImageView imageView = (ImageView) view2.findViewById(R.id.lineBT);
                                        if (imageView != null) {
                                            i = R.id.txtBT;
                                            TextView textView2 = (TextView) view2.findViewById(R.id.txtBT);
                                            if (textView2 != null) {
                                                i = R.id.txtBTPower;
                                                TextView textView3 = (TextView) view2.findViewById(R.id.txtBTPower);
                                                if (textView3 != null) {
                                                    i = R.id.viewExternalBt;
                                                    RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.viewExternalBt);
                                                    if (relativeLayout != null) {
                                                        return new Kesaiwei1920x720EvoId7FragmentSysSetBtBinding((RelativeLayout) view2, textView, seekBar, imageButton, imageButton2, imageButton3, checkBox, checkBox2, checkBox3, imageView, textView2, textView3, relativeLayout);
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
