package com.szchoiceway.settings;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;

public class FragmentSysSet_KSW extends FragmentBase implements View.OnClickListener {
    protected static final String TAG = "FragmentSysSet_KSW";
    boolean b_kesaiwei_chk_Front_camera = false;
    boolean b_kesaiwei_chk_Radar = true;
    boolean b_kesaiwei_chk_ReversingTrack = true;
    boolean b_kesaiwei_chk_VideoDrivingBan = false;
    boolean b_kesaiwei_chk_backcarMirror = false;
    /* access modifiers changed from: private */
    public int iBL = 50;
    int i_kesaiwei_Camera_Selection = 1;
    int i_kesaiwei_TempUnit_Selection = 0;
    CheckBox kesaiwei_Android_360 = null;
    CheckBox kesaiwei_Camera_360 = null;
    CheckBox kesaiwei_Camera_Original = null;
    CheckBox kesaiwei_Camera_install = null;
    CheckBox kesaiwei_chk_Front_camera = null;
    CheckBox kesaiwei_chk_Radar = null;
    CheckBox kesaiwei_chk_ReversingTrack = null;
    CheckBox kesaiwei_chk_VideoDrivingBan = null;
    CheckBox kesaiwei_chk_backcarMirror = null;
    CheckBox kesaiwei_temp_unitC = null;
    CheckBox kesaiwei_temp_unitF = null;
    SeekBar mBLSeekBar;
    private SysSetKSW_Receiver mModel = new SysSetKSW_Receiver();
    IEventService mService = null;
    /* access modifiers changed from: private */
    public int m_iCurrDim = 0;
    /* access modifiers changed from: private */
    public View mainView = null;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        MainActivity mainActivity = (MainActivity) getActivity();
        Log.i(TAG, "m_iUITypeVer = " + this.m_iUITypeVer);
        if (this.m_iModeSet == 18) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set, (ViewGroup) null);
        }
        this.mainView = view;
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i(TAG, "onCreateView'");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.szchoiceway.settings.bl");
        getActivity().registerReceiver(this.mModel, intentFilter);
        return view;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Log.i(TAG, "onViewCreated'");
        super.onViewCreated(view, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
        this.mainView = null;
        getActivity().unregisterReceiver(this.mModel);
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        if (view != null) {
            Log.i(TAG, "--->>> bindViewListener");
            initService((IEventService) null);
            initBLSeekBar(view);
            initView(view);
        }
    }

    private void initView(View view) {
        CheckBox checkBox;
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
            this.b_kesaiwei_chk_backcarMirror = mainActivity.mSysProviderOpt.getRecordBoolean(SysProviderOpt.KESAIWEI_SYS_BACKCAR_MIRROR, this.b_kesaiwei_chk_backcarMirror);
            this.b_kesaiwei_chk_ReversingTrack = mainActivity.mSysProviderOpt.getRecordBoolean(SysProviderOpt.KESAIWEI_SYS_REVERSING_TRACK, this.b_kesaiwei_chk_ReversingTrack);
            this.b_kesaiwei_chk_Radar = mainActivity.mSysProviderOpt.getRecordBoolean(SysProviderOpt.KESAIWEI_SYS_RADAR, this.b_kesaiwei_chk_Radar);
            this.i_kesaiwei_Camera_Selection = mainActivity.mSysProviderOpt.getRecordInteger("KESAIWEI_SYS_CAMERA_SELECTION", this.i_kesaiwei_Camera_Selection);
            this.b_kesaiwei_chk_VideoDrivingBan = mainActivity.mSysProviderOpt.getRecordBoolean("KESAIWEI_SYS_VIDEO_DRIVING_BAN", this.b_kesaiwei_chk_VideoDrivingBan);
            this.b_kesaiwei_chk_Front_camera = mainActivity.mSysProviderOpt.getRecordBoolean(SysProviderOpt.KESAIWEI_SYS_FRONT_CAMERA, this.b_kesaiwei_chk_Front_camera);
            this.i_kesaiwei_TempUnit_Selection = mainActivity.mSysProviderOpt.getRecordInteger(SysProviderOpt.KSW_TEMP_UNIT, 0);
        }
        CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.kesaiwei_chk_backcarMirror);
        this.kesaiwei_chk_backcarMirror = checkBox2;
        if (checkBox2 != null) {
            checkBox2.setOnClickListener(this);
            this.kesaiwei_chk_backcarMirror.setChecked(this.b_kesaiwei_chk_backcarMirror);
        }
        CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.kesaiwei_chk_ReversingTrack);
        this.kesaiwei_chk_ReversingTrack = checkBox3;
        if (checkBox3 != null) {
            checkBox3.setOnClickListener(this);
            this.kesaiwei_chk_ReversingTrack.setChecked(this.b_kesaiwei_chk_ReversingTrack);
        }
        CheckBox checkBox4 = (CheckBox) view.findViewById(R.id.kesaiwei_chk_Radar);
        this.kesaiwei_chk_Radar = checkBox4;
        if (checkBox4 != null) {
            checkBox4.setOnClickListener(this);
            this.kesaiwei_chk_Radar.setChecked(this.b_kesaiwei_chk_Radar);
        }
        CheckBox checkBox5 = (CheckBox) view.findViewById(R.id.kesaiwei_chk_VideoDrivingBan);
        this.kesaiwei_chk_VideoDrivingBan = checkBox5;
        if (checkBox5 != null) {
            checkBox5.setOnClickListener(this);
            this.kesaiwei_chk_VideoDrivingBan.setChecked(this.b_kesaiwei_chk_VideoDrivingBan);
        }
        this.kesaiwei_Camera_install = (CheckBox) view.findViewById(R.id.kesaiwei_Camera_Install);
        this.kesaiwei_Camera_Original = (CheckBox) view.findViewById(R.id.kesaiwei_Camera_Original);
        this.kesaiwei_Camera_360 = (CheckBox) view.findViewById(R.id.kesaiwei_Camera_360);
        CheckBox checkBox6 = (CheckBox) view.findViewById(R.id.kesaiwei_Android_360);
        this.kesaiwei_Android_360 = checkBox6;
        CheckBox checkBox7 = this.kesaiwei_Camera_install;
        if (!(checkBox7 == null || this.kesaiwei_Camera_Original == null || this.kesaiwei_Camera_360 == null || checkBox6 == null)) {
            checkBox7.setOnClickListener(this);
            this.kesaiwei_Camera_Original.setOnClickListener(this);
            this.kesaiwei_Camera_360.setOnClickListener(this);
            this.kesaiwei_Android_360.setOnClickListener(this);
            setCheck_Camera_Selection();
        }
        this.kesaiwei_temp_unitC = (CheckBox) view.findViewById(R.id.kesaiwei_temp_unitC);
        CheckBox checkBox8 = (CheckBox) view.findViewById(R.id.kesaiwei_temp_unitF);
        this.kesaiwei_temp_unitF = checkBox8;
        if (!(checkBox8 == null || (checkBox = this.kesaiwei_temp_unitC) == null)) {
            checkBox.setOnClickListener(this);
            this.kesaiwei_temp_unitF.setOnClickListener(this);
            setCheck_TempUnit_Selection();
        }
        int[] iArr = {R.id.btnReversingTrack, R.id.btnRadar, R.id.btnBackcarMirror, R.id.btnVideoDrivingBan, R.id.btnCameraInstall, R.id.btnCameraOriginal, R.id.btnCamera360, R.id.btnAndroid360, R.id.btnTempUnitC, R.id.btnTempUnitF};
        for (int i = 0; i < 10; i++) {
            View findViewById = view.findViewById(iArr[i]);
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initService(IEventService iEventService) {
        Log.i(TAG, "initService...............");
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (this.mainView == null) {
            this.mainView = getView();
        }
        if (mainActivity != null) {
            if (this.mService == null) {
                this.mService = mainActivity.getService();
            }
            initBLSetttings_KSW(this.mService);
        }
    }

    private void initBLSetttings_KSW(IEventService iEventService) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null) {
            if (iEventService == null) {
                iEventService = mainActivity.getService();
            }
            if (iEventService != null) {
                try {
                    this.iBL = iEventService.getSettingInt(EventUtils.KEY_BRIGHTNESS_SETTINGS, this.iBL);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mainView == null) {
            this.mainView = getView();
            Log.i(TAG, "mainView = getView();");
        }
    }

    /* access modifiers changed from: package-private */
    public void WgtChkSetValue(int i, boolean z) {
        if (this.mainView == null) {
            View view = getView();
            this.mainView = view;
            if (view == null) {
                return;
            }
        }
        CheckBox checkBox = (CheckBox) this.mainView.findViewById(i);
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
    }

    public void NotifyServiceConntected(IEventService iEventService) {
        super.NotifyServiceConntected(iEventService);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(TAG, "onCreate'");
    }

    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart'");
    }

    public void onAttach(Activity activity) {
        Log.i(TAG, "onAttach'");
        super.onAttach(activity);
    }

    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume'");
        if (this.mainView == null) {
            this.mainView = getView();
        }
    }

    public void onClick(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        switch (view.getId()) {
            case R.id.btnAndroid360 /*2131230935*/:
            case R.id.kesaiwei_Android_360 /*2131231205*/:
                Log.d(TAG, "android 360");
                this.i_kesaiwei_Camera_Selection = 3;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord("KESAIWEI_SYS_CAMERA_SELECTION", "" + this.i_kesaiwei_Camera_Selection);
                }
                setCheck_Camera_Selection();
                kesaiwei_sendBroadcast(4);
                return;
            case R.id.btnBackcarMirror /*2131230949*/:
            case R.id.kesaiwei_chk_backcarMirror /*2131231225*/:
                this.b_kesaiwei_chk_backcarMirror = !this.b_kesaiwei_chk_backcarMirror;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord(SysProviderOpt.KESAIWEI_SYS_BACKCAR_MIRROR, "" + (this.b_kesaiwei_chk_backcarMirror ? 1 : 0));
                }
                this.kesaiwei_chk_backcarMirror.setChecked(this.b_kesaiwei_chk_backcarMirror);
                kesaiwei_sendBroadcast(1);
                return;
            case R.id.btnCamera360 /*2131230963*/:
            case R.id.kesaiwei_Camera_360 /*2131231207*/:
                this.i_kesaiwei_Camera_Selection = 2;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord("KESAIWEI_SYS_CAMERA_SELECTION", "" + this.i_kesaiwei_Camera_Selection);
                }
                setCheck_Camera_Selection();
                kesaiwei_sendBroadcast(4);
                return;
            case R.id.btnCameraInstall /*2131230964*/:
            case R.id.kesaiwei_Camera_Install /*2131231208*/:
                this.i_kesaiwei_Camera_Selection = 0;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord("KESAIWEI_SYS_CAMERA_SELECTION", "" + this.i_kesaiwei_Camera_Selection);
                }
                setCheck_Camera_Selection();
                kesaiwei_sendBroadcast(4);
                return;
            case R.id.btnCameraOriginal /*2131230965*/:
            case R.id.kesaiwei_Camera_Original /*2131231209*/:
                this.i_kesaiwei_Camera_Selection = 1;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord("KESAIWEI_SYS_CAMERA_SELECTION", "" + this.i_kesaiwei_Camera_Selection);
                }
                setCheck_Camera_Selection();
                kesaiwei_sendBroadcast(4);
                return;
            case R.id.btnRadar /*2131231022*/:
            case R.id.kesaiwei_chk_Radar /*2131231220*/:
                this.b_kesaiwei_chk_Radar = !this.b_kesaiwei_chk_Radar;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord(SysProviderOpt.KESAIWEI_SYS_RADAR, "" + (this.b_kesaiwei_chk_Radar ? 1 : 0));
                }
                this.kesaiwei_chk_Radar.setChecked(this.b_kesaiwei_chk_Radar);
                kesaiwei_sendBroadcast(28);
                return;
            case R.id.btnReversingTrack /*2131231033*/:
            case R.id.kesaiwei_chk_ReversingTrack /*2131231221*/:
                this.b_kesaiwei_chk_ReversingTrack = !this.b_kesaiwei_chk_ReversingTrack;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord(SysProviderOpt.KESAIWEI_SYS_REVERSING_TRACK, "" + (this.b_kesaiwei_chk_ReversingTrack ? 1 : 0));
                }
                this.kesaiwei_chk_ReversingTrack.setChecked(this.b_kesaiwei_chk_ReversingTrack);
                kesaiwei_sendBroadcast(27);
                return;
            case R.id.btnTempUnitC /*2131231048*/:
            case R.id.kesaiwei_temp_unitC /*2131231244*/:
                this.i_kesaiwei_TempUnit_Selection = 0;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord(SysProviderOpt.KSW_TEMP_UNIT, "" + this.i_kesaiwei_TempUnit_Selection);
                }
                setCheck_TempUnit_Selection();
                kesaiwei_sendBroadcast(4);
                return;
            case R.id.btnTempUnitF /*2131231049*/:
            case R.id.kesaiwei_temp_unitF /*2131231245*/:
                this.i_kesaiwei_TempUnit_Selection = 1;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord(SysProviderOpt.KSW_TEMP_UNIT, "" + this.i_kesaiwei_TempUnit_Selection);
                }
                setCheck_TempUnit_Selection();
                kesaiwei_sendBroadcast(4);
                return;
            case R.id.btnVideoDrivingBan /*2131231052*/:
            case R.id.kesaiwei_chk_VideoDrivingBan /*2131231223*/:
                this.b_kesaiwei_chk_VideoDrivingBan = !this.b_kesaiwei_chk_VideoDrivingBan;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord("KESAIWEI_SYS_VIDEO_DRIVING_BAN", "" + (this.b_kesaiwei_chk_VideoDrivingBan ? 1 : 0));
                }
                this.kesaiwei_chk_VideoDrivingBan.setChecked(this.b_kesaiwei_chk_VideoDrivingBan);
                kesaiwei_sendBroadcast(2);
                return;
            default:
                return;
        }
    }

    public void SendBLVal_KSW() {
        IEventService service;
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null && (service = mainActivity.getService()) != null) {
            try {
                service.SendBLVal((byte) this.iBL, (byte) 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void SaveBLSettings_KSW() {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        IEventService service = mainActivity != null ? mainActivity.getService() : null;
        if (service != null) {
            try {
                service.putSettingInt(EventUtils.KEY_BRIGHTNESS_SETTINGS, this.iBL);
                service.appySetting();
                service.commitSetting();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void initBLSeekBar(View view) {
        View view2 = this.mainView;
        if (view2 != null) {
            SeekBar seekBar = (SeekBar) view2.findViewById(R.id.KSW_BLSeekBar);
            this.mBLSeekBar = seekBar;
            if (seekBar != null) {
                seekBar.setProgress(this.iBL);
                Log.i(TAG, "--->>> iBL = " + this.iBL);
                TextView textView = (TextView) view.findViewById(R.id.KSW_BL_val);
                if (textView != null) {
                    textView.setText("" + this.iBL + "");
                }
                this.mBLSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                        System.out.println("onProgressChanged*******************");
                        FragmentSysSet_KSW fragmentSysSet_KSW = FragmentSysSet_KSW.this;
                        int unused = fragmentSysSet_KSW.iBL = fragmentSysSet_KSW.mBLSeekBar.getProgress();
                        TextView textView = (TextView) FragmentSysSet_KSW.this.mainView.findViewById(R.id.KSW_BL_val);
                        if (textView != null) {
                            textView.setText("" + FragmentSysSet_KSW.this.iBL + "");
                        }
                        FragmentSysSet_KSW.this.SendBLVal_KSW();
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        System.out.println("onStopTrackingTouch*******************");
                        FragmentSysSet_KSW fragmentSysSet_KSW = FragmentSysSet_KSW.this;
                        int unused = fragmentSysSet_KSW.iBL = fragmentSysSet_KSW.mBLSeekBar.getProgress();
                        TextView textView = (TextView) FragmentSysSet_KSW.this.mainView.findViewById(R.id.KSW_BL_val);
                        if (textView != null) {
                            textView.setText("" + FragmentSysSet_KSW.this.iBL + "");
                        }
                        FragmentSysSet_KSW.this.SaveBLSettings_KSW();
                        MainActivity mainActivity = (MainActivity) FragmentSysSet_KSW.this.getActivity();
                        IEventService iEventService = null;
                        if (mainActivity == null) {
                            mainActivity = FragmentSysSet_KSW.this.getMainActivity();
                        }
                        if (mainActivity != null) {
                            iEventService = mainActivity.getService();
                        }
                        try {
                            if (FragmentSysSet_KSW.this.iBL < 33) {
                                int unused2 = FragmentSysSet_KSW.this.m_iCurrDim = 0;
                            } else if (FragmentSysSet_KSW.this.iBL < 66) {
                                int unused3 = FragmentSysSet_KSW.this.m_iCurrDim = 1;
                            } else if (FragmentSysSet_KSW.this.iBL < 100) {
                                int unused4 = FragmentSysSet_KSW.this.m_iCurrDim = 2;
                            } else {
                                int unused5 = FragmentSysSet_KSW.this.m_iCurrDim = 3;
                            }
                            iEventService.SetCurrDim(FragmentSysSet_KSW.this.m_iCurrDim);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    private void kesaiwei_sendBroadcast(int i) {
        Intent intent = new Intent(EventUtils.ZXW_SENDBROADCAST8902MOD);
        intent.putExtra(EventUtils.ZXW_SENDBROADCAST8902MOD_EXTRA, i);
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        mainActivity.sendBroadcast(intent);
    }

    private void setCheck_Camera_Selection() {
        this.kesaiwei_Camera_install.setChecked(false);
        this.kesaiwei_Camera_Original.setChecked(false);
        this.kesaiwei_Camera_360.setChecked(false);
        this.kesaiwei_Android_360.setChecked(false);
        int i = this.i_kesaiwei_Camera_Selection;
        if (i == 0) {
            this.kesaiwei_Camera_install.setChecked(true);
        } else if (i == 1) {
            this.kesaiwei_Camera_Original.setChecked(true);
        } else if (i == 2) {
            this.kesaiwei_Camera_360.setChecked(true);
        } else if (i == 3) {
            this.kesaiwei_Android_360.setChecked(true);
        }
    }

    private void setCheck_TempUnit_Selection() {
        this.kesaiwei_temp_unitC.setChecked(false);
        this.kesaiwei_temp_unitF.setChecked(false);
        int i = this.i_kesaiwei_TempUnit_Selection;
        if (i == 0) {
            this.kesaiwei_temp_unitC.setChecked(true);
        } else if (i == 1) {
            this.kesaiwei_temp_unitF.setChecked(true);
        }
    }

    /* access modifiers changed from: private */
    public void mcu_to_bl_set_view() {
        IEventService iEventService;
        if (this.mBLSeekBar != null && (iEventService = this.mService) != null) {
            try {
                this.iBL = iEventService.getSettingInt(EventUtils.KEY_BRIGHTNESS_SETTINGS, this.iBL);
                Log.i(TAG, "mcu_to_bl_set_view: iBL = " + this.iBL);
                this.mBLSeekBar.setProgress(this.iBL);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public class SysSetKSW_Receiver extends BroadcastReceiver {
        public SysSetKSW_Receiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.szchoiceway.settings.bl".equals(intent.getAction())) {
                FragmentSysSet_KSW.this.mcu_to_bl_set_view();
            }
        }
    }
}
