package com.szchoiceway.settings.fragments;

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
import android.widget.TextView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.settings.view.MySeekbar1;

public class FragmentSystemNew_Copilot extends FragmentBase {
    private static final String TAG = "FragmentSystemNew";
    /* access modifiers changed from: private */
    public boolean fromUser = false;
    /* access modifiers changed from: private */
    public int iBL = 50;
    private MainActivity mMain;
    private View mMainView;
    private SysProviderOpt mProvider;
    private BrightnessKSW_Receiver mReceiver = new BrightnessKSW_Receiver();
    IEventService mService = null;
    private int m_iCurrDim = 0;
    /* access modifiers changed from: private */
    public MySeekbar1 mySeekbarBrightness;
    /* access modifiers changed from: private */
    public TextView tvValueBrightness;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mProvider = SysProviderOpt.getInstance(context);
        this.mMain = (MainActivity) getActivity();
        initService();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EventUtils.ZXW_ACTION_SYS_BRIGHTNESS_SETTINGS);
        if (getContext() != null) {
            getContext().registerReceiver(this.mReceiver, intentFilter);
        }
        if (this.m_iModeSet == 39) {
            view = layoutInflater.inflate(R.layout.landrover_copilot_fragment_sys_set_main, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.landrover_copilot_fragment_sys_set_main, (ViewGroup) null);
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
        MainActivity mainActivity = this.mMain;
        if (mainActivity != null) {
            mainActivity.unregisterReceiver(this.mReceiver);
        }
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        this.mMain = (MainActivity) getActivity();
        TextView textView = (TextView) view.findViewById(R.id.tvValueBrightness);
        this.tvValueBrightness = textView;
        if (textView != null) {
            textView.setText(this.iBL + "");
        }
        MySeekbar1 mySeekbar1 = (MySeekbar1) view.findViewById(R.id.mySeekbarBrightness);
        this.mySeekbarBrightness = mySeekbar1;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.iBL);
            this.mySeekbarBrightness.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    boolean unused = FragmentSystemNew_Copilot.this.fromUser = true;
                }

                public void onSeeking(int i) {
                    int unused = FragmentSystemNew_Copilot.this.iBL = i;
                    if (FragmentSystemNew_Copilot.this.tvValueBrightness != null) {
                        FragmentSystemNew_Copilot.this.tvValueBrightness.setText("" + FragmentSystemNew_Copilot.this.iBL + "");
                    }
                    FragmentSystemNew_Copilot fragmentSystemNew_Copilot = FragmentSystemNew_Copilot.this;
                    fragmentSystemNew_Copilot.SendBLVal_KSW(fragmentSystemNew_Copilot.fromUser);
                }

                public void onSeekStop(int i) {
                    Log.d(FragmentSystemNew_Copilot.TAG, "onSeekStop progress = " + i);
                    int unused = FragmentSystemNew_Copilot.this.iBL = i;
                    if (FragmentSystemNew_Copilot.this.tvValueBrightness != null) {
                        FragmentSystemNew_Copilot.this.tvValueBrightness.setText("" + FragmentSystemNew_Copilot.this.iBL + "");
                    }
                    FragmentSystemNew_Copilot fragmentSystemNew_Copilot = FragmentSystemNew_Copilot.this;
                    fragmentSystemNew_Copilot.SendBLVal_KSW(fragmentSystemNew_Copilot.fromUser);
                    boolean unused2 = FragmentSystemNew_Copilot.this.fromUser = false;
                    FragmentSystemNew_Copilot.this.SaveBLSettings_KSW();
                }
            });
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

    public class BrightnessKSW_Receiver extends BroadcastReceiver {
        public BrightnessKSW_Receiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (EventUtils.ZXW_ACTION_SYS_BRIGHTNESS_SETTINGS.equals(intent.getAction())) {
                int intExtra = intent.getIntExtra(EventUtils.ZXW_ACTION_SYS_BRIGHTNESS_SETTINGS_EXTRA, 0);
                if (FragmentSystemNew_Copilot.this.tvValueBrightness != null) {
                    FragmentSystemNew_Copilot.this.tvValueBrightness.setText("" + intExtra + "");
                }
                if (FragmentSystemNew_Copilot.this.mySeekbarBrightness != null) {
                    FragmentSystemNew_Copilot.this.mySeekbarBrightness.setCurrentProgress(intExtra);
                }
            }
        }
    }
}
