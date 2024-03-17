package com.szchoiceway.settings.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import java.util.ArrayList;

public class FragmentSystemSet_Other extends FragmentBase implements View.OnClickListener {
    private static final String TAG = "Set_Other";
    CheckBox kesaiwei_mode_android = null;
    CheckBox kesaiwei_mode_enable = null;
    CheckBox kesaiwei_mode_original = null;
    private MainActivity mMain;
    private View mMainView;
    private SysProviderOpt mProvider;
    int mode = 0;

    public String getFragmentTag() {
        return TAG;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mMain = (MainActivity) getActivity();
        SysProviderOpt instance = SysProviderOpt.getInstance(context);
        this.mProvider = instance;
        this.mode = instance.getRecordInteger(SysProviderOpt.KSW_BOOT_MODE_MEMORY_INDEX, this.mode);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_other, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_other, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_other, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_other, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_other, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_other, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_other_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_other, (ViewGroup) null);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_other, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set_other, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_other, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_other, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_other, (ViewGroup) null);
        } else if (this.m_iUIIndex != 5) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_other, (ViewGroup) null);
        } else if (this.m_iModeSet == 32) {
            view = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_other, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_other, (ViewGroup) null);
        }
        this.mMainView = view;
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mMain = mainActivity;
        this.baseApp = (BaseApp) mainActivity.getApplication();
        this.kesaiwei_mode_enable = (CheckBox) view.findViewById(R.id.kesaiwei_mode_enable);
        this.kesaiwei_mode_android = (CheckBox) view.findViewById(R.id.kesaiwei_mode_android);
        this.kesaiwei_mode_original = (CheckBox) view.findViewById(R.id.kesaiwei_mode_original);
        int[] iArr = {R.id.btnModeEnable, R.id.btnModeAndroid, R.id.btnModeOriginal};
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(iArr[i]);
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
            }
        }
        refreshChk();
    }

    private void refreshChk() {
        CheckBox checkBox = this.kesaiwei_mode_enable;
        boolean z = false;
        if (checkBox != null) {
            checkBox.setChecked(this.mode == 0);
        }
        CheckBox checkBox2 = this.kesaiwei_mode_android;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.mode == 2);
        }
        CheckBox checkBox3 = this.kesaiwei_mode_original;
        if (checkBox3 != null) {
            if (this.mode == 1) {
                z = true;
            }
            checkBox3.setChecked(z);
        }
    }

    public void onClick(View view) {
        if (BaseApp.getFocusUtil().inSeekbarKnobMode) {
            BaseApp.getFocusUtil().clearSeekbarFocus();
        }
        if (this.focusViews == null || this.focusViews.isEmpty()) {
            this.focusViews = new ArrayList();
            this.focusViews.add(Integer.valueOf(R.id.btnModeEnable));
            this.focusViews.add(Integer.valueOf(R.id.btnModeAndroid));
            this.focusViews.add(Integer.valueOf(R.id.btnModeOriginal));
        }
        for (int i = 0; i < this.focusViews.size(); i++) {
            if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                this.m_CurrFocus = i;
            }
        }
        this.baseApp.setFocusPage(2);
        this.mMain.m_iCurrFocus = this.m_CurrFocus;
        if (this.mProductIndex > 0) {
            this.mMain.lastYFocus = 7;
        } else {
            this.mMain.lastYFocus = 8;
        }
        BaseApp.getFocusUtil().refreshFirstViews(this.mMain, -1, false);
        BaseApp.getFocusUtil().refreshSecondViews(-1, false);
        BaseApp.getFocusUtil().locateFragment(this, TAG);
        addViewIds();
        BaseApp.getFocusUtil().refreshThirdViews(this.mMain.m_iCurrFocus, false);
        switch (view.getId()) {
            case R.id.btnModeAndroid:
                this.mode = 2;
                this.mProvider.updateRecord(SysProviderOpt.KSW_BOOT_MODE_MEMORY_INDEX, "" + this.mode);
                refreshChk();
                kesaiwei_sendBroadcast3(48, 25, this.mode);
                return;
            case R.id.btnModeEnable:
                this.mode = 0;
                this.mProvider.updateRecord(SysProviderOpt.KSW_BOOT_MODE_MEMORY_INDEX, "" + this.mode);
                refreshChk();
                kesaiwei_sendBroadcast3(48, 25, this.mode);
                return;
            case R.id.btnModeOriginal:
                this.mode = 1;
                this.mProvider.updateRecord(SysProviderOpt.KSW_BOOT_MODE_MEMORY_INDEX, "" + this.mode);
                refreshChk();
                kesaiwei_sendBroadcast3(48, 25, this.mode);
                return;
            default:
                return;
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        this.focusViews.add(Integer.valueOf(R.id.btnModeEnable));
        this.focusViews.add(Integer.valueOf(R.id.btnModeAndroid));
        this.focusViews.add(Integer.valueOf(R.id.btnModeOriginal));
        BaseApp.getFocusUtil().addViewIds(this.focusViews);
    }
}
