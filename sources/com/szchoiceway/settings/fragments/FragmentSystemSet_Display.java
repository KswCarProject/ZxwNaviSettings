package com.szchoiceway.settings.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.settings.view.MySeekbar1;
import java.util.ArrayList;

public class FragmentSystemSet_Display extends FragmentBase implements View.OnClickListener {
    private static final String TAG = "SystemSet_Display";
    TextView KSW_BL_val;
    boolean b_kesaiwei_chk_SmallLightBL = false;
    boolean b_kesaiwei_chk_VideoDrivingBan = false;
    ImageButton btnAddBL;
    ImageButton btnReduceBL;
    /* access modifiers changed from: private */
    public boolean fromUser = false;
    /* access modifiers changed from: private */
    public int iBL = 50;
    CheckBox kesaiwei_chk_SmallLightBL = null;
    CheckBox kesaiwei_chk_VideoDrivingBan = null;
    SeekBar mBLSeekBar;
    /* access modifiers changed from: private */
    public MainActivity mMain;
    private View mMainView;
    private SysProviderOpt mProvider;
    private BrightnessKSW_Receiver mReceiver = new BrightnessKSW_Receiver();
    IEventService mService = null;
    /* access modifiers changed from: private */
    public int m_iCurrDim = 0;
    MySeekbar1 myBLSeekBar;
    View viewAddBL;
    View viewReduceBL;

    public String getFragmentTag() {
        return TAG;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
        this.mMain = (MainActivity) getActivity();
        initService();
        SysProviderOpt instance = SysProviderOpt.getInstance(context);
        this.mProvider = instance;
        this.b_kesaiwei_chk_VideoDrivingBan = instance.getRecordBoolean("KESAIWEI_SYS_VIDEO_DRIVING_BAN", this.b_kesaiwei_chk_VideoDrivingBan);
        this.b_kesaiwei_chk_SmallLightBL = this.mProvider.getRecordBoolean(SysProviderOpt.KSW_BACKLIGHT_CONTROL_INDEX, this.b_kesaiwei_chk_SmallLightBL);
        Log.d(TAG, "b_kesaiwei_chk_SmallLightBL = " + this.b_kesaiwei_chk_SmallLightBL);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EventUtils.ZXW_ACTION_SYS_BRIGHTNESS_SETTINGS);
        if (getContext() != null) {
            getContext().registerReceiver(this.mReceiver, intentFilter);
        }
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_display, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_display, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_display, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_display, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_display, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_display, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_display_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_display, (ViewGroup) null);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_display, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set_display, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_display, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_display, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_display, (ViewGroup) null);
        } else if (this.m_iUIIndex != 5) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_display, (ViewGroup) null);
        } else if (this.m_iModeSet == 32) {
            view = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_display, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_display, (ViewGroup) null);
        }
        this.mMainView = view;
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void onResume() {
        super.onResume();
        if (this.mMainView == null) {
            this.mMainView = getView();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mMain.unregisterReceiver(this.mReceiver);
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mMain = mainActivity;
        this.baseApp = (BaseApp) mainActivity.getApplication();
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnVideoDrivingBan);
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnSmallLightBL);
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.kesaiwei_chk_VideoDrivingBan);
        this.kesaiwei_chk_VideoDrivingBan = checkBox;
        if (checkBox != null) {
            checkBox.setChecked(this.b_kesaiwei_chk_VideoDrivingBan);
        }
        CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.kesaiwei_chk_SmallLightBL);
        this.kesaiwei_chk_SmallLightBL = checkBox2;
        if (checkBox2 != null) {
            checkBox2.setChecked(!this.b_kesaiwei_chk_SmallLightBL);
        }
        ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnReduceBL);
        this.btnReduceBL = imageButton3;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this);
        }
        View view2 = this.viewReduceBL;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.btnAddBL);
        this.btnAddBL = imageButton4;
        if (imageButton4 != null) {
            imageButton4.setOnClickListener(this);
        }
        View view3 = this.viewAddBL;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        initBLSeekBar(view);
        initProductView(view);
    }

    private void initProductView(View view) {
        View findViewById = view.findViewById(R.id.viewProduct);
        if (findViewById != null) {
            findViewById.setVisibility(this.mProductIndex > 0 ? 8 : 0);
        }
    }

    private void initService() {
        if (this.mMain == null) {
            this.mMain = (MainActivity) getActivity();
        }
        MainActivity mainActivity = this.mMain;
        if (mainActivity != null) {
            IEventService service = mainActivity.getService();
            this.mService = service;
            if (service != null) {
                try {
                    this.iBL = service.getSettingInt(EventUtils.KEY_BRIGHTNESS_SETTINGS, this.iBL);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void SendBLVal_KSW(boolean z) {
        if (this.mMain == null) {
            this.mMain = (MainActivity) getActivity();
        }
        MainActivity mainActivity = this.mMain;
        if (mainActivity != null && this.mService == null) {
            this.mService = mainActivity.getService();
        }
        IEventService iEventService = this.mService;
        if (iEventService != null) {
            try {
                iEventService.SendBLVal((byte) this.iBL, (byte) 0);
                if (getContext() != null && z) {
                    Intent intent = new Intent(EventUtils.ZXW_ACTION_CHANGE_BRIGHTNESS_SETTINGS);
                    intent.putExtra(EventUtils.ZXW_ACTION_CHANGE_BRIGHTNESS_EXTRA, this.iBL);
                    Log.d(TAG, "sendBroadcast ZXW_ACTION_CHANGE_BRIGHTNESS_SETTINGS");
                    getContext().sendBroadcast(intent);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void SaveBLSettings_KSW() {
        IEventService iEventService = this.mService;
        if (iEventService != null) {
            try {
                iEventService.putSettingInt(EventUtils.KEY_BRIGHTNESS_SETTINGS, this.iBL);
                this.mService.appySetting();
                this.mService.commitSetting();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void initBLSeekBar(View view) {
        if (this.mMainView != null) {
            Log.i(TAG, "--->>> iBL = " + this.iBL);
            TextView textView = (TextView) view.findViewById(R.id.KSW_BL_val);
            this.KSW_BL_val = textView;
            if (textView != null) {
                textView.setText("" + this.iBL + "");
            }
            MySeekbar1 mySeekbar1 = (MySeekbar1) this.mMainView.findViewById(R.id.my_seekbar_brightness);
            this.myBLSeekBar = mySeekbar1;
            if (mySeekbar1 != null) {
                mySeekbar1.setCurrentProgress(this.iBL);
                this.myBLSeekBar.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                    public void onSeekTouch() {
                        boolean unused = FragmentSystemSet_Display.this.fromUser = true;
                    }

                    public void onSeeking(int i) {
                        int unused = FragmentSystemSet_Display.this.iBL = i;
                        if (FragmentSystemSet_Display.this.KSW_BL_val != null) {
                            FragmentSystemSet_Display.this.KSW_BL_val.setText("" + FragmentSystemSet_Display.this.iBL + "");
                            if (FragmentSystemSet_Display.this.m_iUIIndex == 2) {
                                FragmentSystemSet_Display.this.KSW_BL_val.setTextColor(FragmentSystemSet_Display.this.mMain.getColor(FragmentSystemSet_Display.this.getAttrId(R.attr.ksw_id8_fontColor)));
                            }
                        }
                        FragmentSystemSet_Display fragmentSystemSet_Display = FragmentSystemSet_Display.this;
                        fragmentSystemSet_Display.SendBLVal_KSW(fragmentSystemSet_Display.fromUser);
                    }

                    public void onSeekStop(int i) {
                        int unused = FragmentSystemSet_Display.this.iBL = i;
                        if (FragmentSystemSet_Display.this.KSW_BL_val != null) {
                            FragmentSystemSet_Display.this.KSW_BL_val.setText("" + FragmentSystemSet_Display.this.iBL + "");
                            if (FragmentSystemSet_Display.this.m_iUIIndex != 5 && !FragmentSystemSet_Display.this.focusUtil.inSeekbarKnobMode) {
                                FragmentSystemSet_Display.this.KSW_BL_val.setTextColor(-1);
                            }
                        }
                        FragmentSystemSet_Display fragmentSystemSet_Display = FragmentSystemSet_Display.this;
                        fragmentSystemSet_Display.SendBLVal_KSW(fragmentSystemSet_Display.fromUser);
                        boolean unused2 = FragmentSystemSet_Display.this.fromUser = false;
                        FragmentSystemSet_Display.this.SaveBLSettings_KSW();
                    }
                });
            }
            SeekBar seekBar = (SeekBar) this.mMainView.findViewById(R.id.KSW_BLSeekBar);
            this.mBLSeekBar = seekBar;
            if (seekBar != null) {
                seekBar.setProgress(this.iBL);
                this.mBLSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                        System.out.println("onProgressChanged*******************");
                        FragmentSystemSet_Display fragmentSystemSet_Display = FragmentSystemSet_Display.this;
                        int unused = fragmentSystemSet_Display.iBL = fragmentSystemSet_Display.mBLSeekBar.getProgress();
                        FragmentSystemSet_Display.this.KSW_BL_val.setText("" + FragmentSystemSet_Display.this.iBL + "");
                        FragmentSystemSet_Display.this.SendBLVal_KSW(z);
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        System.out.println("onStopTrackingTouch*******************");
                        FragmentSystemSet_Display fragmentSystemSet_Display = FragmentSystemSet_Display.this;
                        int unused = fragmentSystemSet_Display.iBL = fragmentSystemSet_Display.mBLSeekBar.getProgress();
                        FragmentSystemSet_Display.this.KSW_BL_val.setText("" + FragmentSystemSet_Display.this.iBL + "");
                        FragmentSystemSet_Display.this.SaveBLSettings_KSW();
                        MainActivity mainActivity = (MainActivity) FragmentSystemSet_Display.this.getActivity();
                        if (mainActivity == null) {
                            mainActivity = FragmentSystemSet_Display.this.getMainActivity();
                        }
                        IEventService service = mainActivity != null ? mainActivity.getService() : null;
                        try {
                            if (FragmentSystemSet_Display.this.iBL < 33) {
                                int unused2 = FragmentSystemSet_Display.this.m_iCurrDim = 0;
                            } else if (FragmentSystemSet_Display.this.iBL < 66) {
                                int unused3 = FragmentSystemSet_Display.this.m_iCurrDim = 1;
                            } else if (FragmentSystemSet_Display.this.iBL < 100) {
                                int unused4 = FragmentSystemSet_Display.this.m_iCurrDim = 2;
                            } else {
                                int unused5 = FragmentSystemSet_Display.this.m_iCurrDim = 3;
                            }
                            service.SetCurrDim(FragmentSystemSet_Display.this.m_iCurrDim);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void onClick(View view) {
        if (BaseApp.getFocusUtil().inSeekbarKnobMode) {
            BaseApp.getFocusUtil().clearSeekbarFocus();
        }
        if (this.focusViews == null || this.focusViews.isEmpty()) {
            this.focusViews = new ArrayList();
            this.focusViews.add(Integer.valueOf(R.id.btnVideoDrivingBan));
            this.focusViews.add(Integer.valueOf(R.id.btnSmallLightBL));
            if (this.m_iModeSet == 19 || isDefaultUI()) {
                this.focusViews.add(Integer.valueOf(R.id.viewKSW_BLSeekBar));
            }
        }
        for (int i = 0; i < this.focusViews.size(); i++) {
            if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                this.m_CurrFocus = i;
            }
        }
        BaseApp.getFocusUtil().refreshFirstViews(this.mMain, -1, false);
        BaseApp.getFocusUtil().refreshSecondViews(-1, false);
        this.baseApp.setFocusPage(2);
        this.mMain.m_iCurrFocus = this.m_CurrFocus;
        this.mMain.lastYFocus = 1;
        BaseApp.getFocusUtil().locateFragment(this, TAG);
        addViewIds();
        BaseApp.getFocusUtil().refreshThirdViews(this.mMain.m_iCurrFocus, false);
        switch (view.getId()) {
            case R.id.btnAddBL:
                int i2 = this.iBL + 1;
                this.iBL = i2;
                if (i2 > 100) {
                    this.iBL = 100;
                }
                TextView textView = this.KSW_BL_val;
                if (textView != null) {
                    textView.setText("" + this.iBL + "");
                }
                this.myBLSeekBar.setCurrentProgress(this.iBL);
                SendBLVal_KSW(true);
                SaveBLSettings_KSW();
                return;
            case R.id.btnReduceBL:
                int i3 = this.iBL - 1;
                this.iBL = i3;
                if (i3 < 0) {
                    this.iBL = 0;
                }
                TextView textView2 = this.KSW_BL_val;
                if (textView2 != null) {
                    textView2.setText("" + this.iBL + "");
                }
                this.myBLSeekBar.setCurrentProgress(this.iBL);
                SendBLVal_KSW(true);
                SaveBLSettings_KSW();
                return;
            case R.id.btnSmallLightBL:
                boolean z = !this.b_kesaiwei_chk_SmallLightBL;
                this.b_kesaiwei_chk_SmallLightBL = z;
                this.kesaiwei_chk_SmallLightBL.setChecked(!z);
                this.mProvider.updateRecord(SysProviderOpt.KSW_BACKLIGHT_CONTROL_INDEX, "" + (this.b_kesaiwei_chk_SmallLightBL ? 1 : 0));
                kesaiwei_sendBroadcast2(38);
                return;
            case R.id.btnVideoDrivingBan:
                boolean z2 = !this.b_kesaiwei_chk_VideoDrivingBan;
                this.b_kesaiwei_chk_VideoDrivingBan = z2;
                this.kesaiwei_chk_VideoDrivingBan.setChecked(z2);
                this.mProvider.updateRecord("KESAIWEI_SYS_VIDEO_DRIVING_BAN", "" + (this.b_kesaiwei_chk_VideoDrivingBan ? 1 : 0));
                kesaiwei_sendBroadcast2(2);
                return;
            default:
                return;
        }
    }

    public class BrightnessKSW_Receiver extends BroadcastReceiver {
        public BrightnessKSW_Receiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (EventUtils.ZXW_ACTION_SYS_BRIGHTNESS_SETTINGS.equals(intent.getAction()) && !FragmentSystemSet_Display.this.fromUser) {
                int intExtra = intent.getIntExtra(EventUtils.ZXW_ACTION_SYS_BRIGHTNESS_SETTINGS_EXTRA, 0);
                if (FragmentSystemSet_Display.this.KSW_BL_val != null) {
                    FragmentSystemSet_Display.this.KSW_BL_val.setText("" + intExtra + "");
                }
                if (FragmentSystemSet_Display.this.mBLSeekBar != null) {
                    FragmentSystemSet_Display.this.mBLSeekBar.setProgress(intExtra);
                }
                if (FragmentSystemSet_Display.this.myBLSeekBar != null) {
                    FragmentSystemSet_Display.this.myBLSeekBar.setCurrentProgress(intExtra);
                }
            }
        }
    }

    public void addViewIds() {
        super.addViewIds();
        Log.d(TAG, "addViewIds mProductIndex = " + this.mProductIndex);
        this.focusViews = new ArrayList();
        this.focusViews.add(Integer.valueOf(R.id.btnVideoDrivingBan));
        if (this.mProductIndex == 0) {
            this.focusViews.add(Integer.valueOf(R.id.btnSmallLightBL));
            this.focusViews.add(Integer.valueOf(R.id.viewKSW_BLSeekBar));
        }
        BaseApp.getFocusUtil().addViewIds(this.focusViews);
    }

    /* access modifiers changed from: private */
    public int getAttrId(int i) {
        if (getActivity() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        this.mMain.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }
}
