package com.szchoiceway.settings.fragments;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import java.util.ArrayList;

public class FragmentSystemSet_BT extends FragmentBase implements View.OnClickListener {
    private static final String TAG = "SystemSet_BT";
    TextView KSW_BTGain = null;
    SeekBar KSW_BTGainSeekBar = null;
    BluetoothAdapter bluetoothAdapter;
    private String client = "";
    int i_kesaiwei_Bluetooth_index = 0;
    int i_kesaiwei_Bluetooth_power = 0;
    CheckBox kesaiwei_External_BT = null;
    CheckBox kesaiwei_Install_BT = null;
    CheckBox kesaiwei_Original_BT = null;
    private MainActivity mMain;
    private View mMainView;
    /* access modifiers changed from: private */
    public SysProviderOpt mProvider;
    private Toast mToast;
    int micGainValue = 0;
    private View viewExternalBt;
    private View viewLine;

    public String getFragmentTag() {
        return TAG;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mMain = (MainActivity) getActivity();
        SysProviderOpt instance = SysProviderOpt.getInstance(context);
        this.mProvider = instance;
        this.i_kesaiwei_Bluetooth_power = instance.getRecordInteger(SysProviderOpt.KESAIWEI_RECORD_BT_OFF, this.i_kesaiwei_Bluetooth_power);
        this.i_kesaiwei_Bluetooth_index = this.mProvider.getRecordInteger("KESAIWEI_RECORD_BT_INDEX", this.i_kesaiwei_Bluetooth_index);
        this.micGainValue = this.mProvider.getRecordInteger(SysProviderOpt.SYS_MIC_GAIN_PARAM, this.micGainValue);
        this.client = this.mProvider.getRecordValue(SysProviderOpt.KSW_FACTORY_SET_CLIENT, "KSW");
        this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_bt, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_bt, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_bt, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_bt, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_bt, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_bt, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_bt_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_bt, (ViewGroup) null);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_bt, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set_bt, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_bt, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_bt, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_bt, (ViewGroup) null);
        } else if (this.m_iUIIndex != 5) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_bt, (ViewGroup) null);
        } else if (this.m_iModeSet == 32) {
            view = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_bt, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_bt, (ViewGroup) null);
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
        int i = 0;
        boolean recordBoolean = this.mProvider.getRecordBoolean(SysProviderOpt.KSW_FACTORY_SET_CLIENT_ALS_TEST, false);
        View findViewById = view.findViewById(R.id.viewLine);
        this.viewLine = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(recordBoolean ? 0 : 8);
        }
        View findViewById2 = view.findViewById(R.id.viewExternalBt);
        this.viewExternalBt = findViewById2;
        if (findViewById2 != null) {
            if (!recordBoolean) {
                i = 8;
            }
            findViewById2.setVisibility(i);
        }
        this.kesaiwei_Install_BT = (CheckBox) view.findViewById(R.id.kesaiwei_Install_BT);
        this.kesaiwei_Original_BT = (CheckBox) view.findViewById(R.id.kesaiwei_Original_BT);
        this.kesaiwei_External_BT = (CheckBox) view.findViewById(R.id.kesaiwei_External_BT);
        refreshChk();
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnInstallBT);
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnOriginalBT);
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnExternalBT);
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this);
        }
        refreshChk();
        this.KSW_BTGain = (TextView) view.findViewById(R.id.KSW_BTGain);
        refreshBTGainValue();
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.KSW_BTGainSeekBar);
        this.KSW_BTGainSeekBar = seekBar;
        if (seekBar != null) {
            seekBar.setProgress(this.micGainValue);
            this.KSW_BTGainSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (z) {
                        FragmentSystemSet_BT.this.micGainValue = i;
                        FragmentSystemSet_BT.this.refreshBTGainValue();
                    }
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    FragmentSystemSet_BT.this.mProvider.updateRecord(SysProviderOpt.SYS_MIC_GAIN_PARAM, FragmentSystemSet_BT.this.micGainValue + "");
                }
            });
        }
    }

    private void refreshChk() {
        CheckBox checkBox = this.kesaiwei_Install_BT;
        boolean z = false;
        if (checkBox != null) {
            checkBox.setChecked(this.i_kesaiwei_Bluetooth_index == 0);
        }
        CheckBox checkBox2 = this.kesaiwei_Original_BT;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.i_kesaiwei_Bluetooth_index == 1);
        }
        CheckBox checkBox3 = this.kesaiwei_External_BT;
        if (checkBox3 != null) {
            if (this.i_kesaiwei_Bluetooth_index == 2) {
                z = true;
            }
            checkBox3.setChecked(z);
        }
    }

    /* access modifiers changed from: private */
    public void refreshBTGainValue() {
        TextView textView = this.KSW_BTGain;
        if (textView != null) {
            textView.setText("" + this.micGainValue);
        }
    }

    public void onClick(View view) {
        if (BaseApp.getFocusUtil().inSeekbarKnobMode) {
            BaseApp.getFocusUtil().clearSeekbarFocus();
        }
        if (this.focusViews == null || this.focusViews.isEmpty()) {
            this.focusViews = new ArrayList();
            this.focusViews.add(Integer.valueOf(R.id.btnInstallBT));
            this.focusViews.add(Integer.valueOf(R.id.btnOriginalBT));
            View view2 = this.viewExternalBt;
            if (view2 != null && view2.getVisibility() == 0) {
                this.focusViews.add(Integer.valueOf(R.id.btnExternalBT));
            }
        }
        for (int i = 0; i < this.focusViews.size(); i++) {
            if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                this.m_CurrFocus = i;
            }
        }
        this.baseApp.setFocusPage(2);
        this.mMain.m_iCurrFocus = this.m_CurrFocus;
        this.mMain.lastYFocus = 2;
        BaseApp.getFocusUtil().refreshFirstViews(this.mMain, -1, false);
        BaseApp.getFocusUtil().refreshSecondViews(-1, false);
        BaseApp.getFocusUtil().locateFragment(this, TAG);
        addViewIds();
        BaseApp.getFocusUtil().refreshThirdViews(this.mMain.m_iCurrFocus, false);
        int id = view.getId();
        if (id == R.id.btnExternalBT) {
            this.i_kesaiwei_Bluetooth_power = 1;
            this.i_kesaiwei_Bluetooth_index = 2;
            this.mProvider.updateRecord("KESAIWEI_RECORD_BT_INDEX", this.i_kesaiwei_Bluetooth_index + "");
            this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_RECORD_BT_OFF, this.i_kesaiwei_Bluetooth_power + "");
            kesaiwei_sendBroadcast2(11);
            refreshChk();
            kesaiwei_sendBroadcast3(48, 5, this.i_kesaiwei_Bluetooth_index);
            if (!this.bluetoothAdapter.isEnabled()) {
                this.bluetoothAdapter.enable();
            }
            if (!"1".equals(SystemProperties.get("persist.vendor.bluetooth_ext"))) {
                SystemProperties.set("persist.vendor.bluetooth_ext", "1");
                showToast();
            }
        } else if (id == R.id.btnInstallBT) {
            this.i_kesaiwei_Bluetooth_power = 1;
            this.i_kesaiwei_Bluetooth_index = 0;
            this.mProvider.updateRecord("KESAIWEI_RECORD_BT_INDEX", this.i_kesaiwei_Bluetooth_index + "");
            this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_RECORD_BT_OFF, this.i_kesaiwei_Bluetooth_power + "");
            kesaiwei_sendBroadcast2(11);
            refreshChk();
            kesaiwei_sendBroadcast3(48, 5, this.i_kesaiwei_Bluetooth_index);
            if (!this.bluetoothAdapter.isEnabled()) {
                this.bluetoothAdapter.enable();
            }
            if (!"0".equals(SystemProperties.get("persist.vendor.bluetooth_ext"))) {
                SystemProperties.set("persist.vendor.bluetooth_ext", "0");
                showToast();
            }
        } else if (id == R.id.btnOriginalBT) {
            this.i_kesaiwei_Bluetooth_power = 0;
            this.i_kesaiwei_Bluetooth_index = 1;
            this.mProvider.updateRecord("KESAIWEI_RECORD_BT_INDEX", this.i_kesaiwei_Bluetooth_index + "");
            this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_RECORD_BT_OFF, this.i_kesaiwei_Bluetooth_power + "");
            kesaiwei_sendBroadcast2(11);
            refreshChk();
            kesaiwei_sendBroadcast3(48, 5, this.i_kesaiwei_Bluetooth_index);
            if (this.bluetoothAdapter.isEnabled()) {
                this.bluetoothAdapter.disable();
            }
            if (!"0".equals(SystemProperties.get("persist.vendor.bluetooth_ext"))) {
                SystemProperties.set("persist.vendor.bluetooth_ext", "0");
                showToast();
            }
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        this.focusViews.add(Integer.valueOf(R.id.btnInstallBT));
        this.focusViews.add(Integer.valueOf(R.id.btnOriginalBT));
        View view = this.viewExternalBt;
        if (view != null && view.getVisibility() == 0) {
            this.focusViews.add(Integer.valueOf(R.id.btnExternalBT));
        }
        BaseApp.getFocusUtil().addViewIds(this.focusViews);
    }

    private void showToast() {
        Toast toast = this.mToast;
        if (toast != null) {
            toast.cancel();
        }
        this.mToast = Toast.makeText(getContext(), "", 0);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getMainActivity()).inflate(R.layout.layout_toast, (ViewGroup) null, false);
        ((TextView) viewGroup.findViewById(R.id.tvMessage)).setText(getString(R.string.lbl_switch_bt));
        this.mToast.setView(viewGroup);
        this.mToast.show();
    }
}
