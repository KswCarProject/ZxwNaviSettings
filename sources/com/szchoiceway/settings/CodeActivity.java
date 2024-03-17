package com.szchoiceway.settings;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.zxwlib.bean.Customer;

public class CodeActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {
    private static final int HANDLE_KSW_FINISH_CODE_ACTIVITY = 1;
    protected static final String TAG = "CodeActivity";
    View btn = null;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1 && CodeActivity.this.mService != null) {
                try {
                    if (!CodeActivity.this.mService.getmIsAddMouseView()) {
                        CodeActivity.this.finish();
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private boolean mInitVar = false;
    private NavSetModel mModel = new NavSetModel();
    IEventService mService = null;
    private SysProviderOpt mSysProviderOpt = null;
    protected Toast mTip = null;
    private TextView mTvInputUserFreq = null;
    private String mUserInputFreq = "";
    private int m_iModeSet = 0;
    public int m_iUITypeVer = 101;
    private ServiceConnection osc = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(CodeActivity.TAG, "onServiceConnected");
            CodeActivity.this.mService = IEventService.Stub.asInterface(iBinder);
            Log.i(CodeActivity.TAG, "onServiceConnected end");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(CodeActivity.TAG, "onServiceDisconnected");
            CodeActivity.this.mService = null;
        }
    };

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SysProviderOpt instance = SysProviderOpt.getInstance(this);
        this.mSysProviderOpt = instance;
        this.m_iUITypeVer = instance.getRecordInteger("Set_User_UI_Type", this.m_iUITypeVer);
        int recordInteger = this.mSysProviderOpt.getRecordInteger("KESAIWEI_SYS_MODE_SELECTION", this.m_iModeSet);
        this.m_iModeSet = recordInteger;
        int i = this.m_iUITypeVer;
        if (i == 101) {
            setTheme(R.style.Transparent);
        } else if (i == 41 && recordInteger == 11) {
            setTheme(R.style.Transparent);
        }
        if (this.m_iUITypeVer == 41) {
            if (Build.VERSION.SDK_INT >= 21 && !Build.MODEL.equals("px7_zxw")) {
                Window window = getWindow();
                window.clearFlags(201326592);
                window.getDecorView().setSystemUiVisibility(1792);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
            }
            if (Customer.getUIIndex(this) == 2 || Customer.getUIIndex(this) == 1) {
                setContentView(R.layout.kesaiwei_1920x720_evo_id7_code_layout);
            } else if (Customer.getUIIndex(this) == 6) {
                setContentView(R.layout.kesaiwei_1920x720_benz_code_layout);
            } else {
                setContentView(R.layout.kesaiwei_1920x720_evo_id7_code_layout);
            }
        } else {
            setContentView(R.layout.kesaiwei_1920x720_evo_id7_code_layout);
        }
        this.mInitVar = true;
        startConnectService();
        initView();
        registerReceiver();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.d(TAG, "onResume");
        if (getRequestedOrientation() != 0) {
            setRequestedOrientation(0);
        }
        super.onResume();
        MainActivity.run_CodeActivity = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MainActivity.run_CodeActivity = false;
    }

    public void onWindowFocusChanged(boolean z) {
        Log.i(TAG, "onWindowFocusChanged: hasFocus = " + z);
        super.onWindowFocusChanged(z);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
        unregisterReceiver();
        stopConntectService();
    }

    private void startConnectService() {
        try {
            bindService(new Intent("com.szchoiceway.eventcenter.EventService"), this.osc, 1);
        } catch (Exception e) {
            Log.e(TAG, "onBindService error " + e.toString());
        }
    }

    private void stopConntectService() {
        try {
            unbindService(this.osc);
        } catch (Exception e) {
            Log.e(TAG, "unbindService error " + e.toString());
        }
    }

    private void initView() {
        int[] iArr = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9, R.id.BtnNumDel, R.id.BtnNumOK};
        for (int i = 0; i < 12; i++) {
            View findViewById = findViewById(iArr[i]);
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
            }
        }
        TextView textView = (TextView) findViewById(R.id.TvInputUserFreq);
        this.mTvInputUserFreq = textView;
        if (textView != null) {
            textView.setText(this.mUserInputFreq);
        }
    }

    /* access modifiers changed from: package-private */
    public void inputUserFreq(int i) {
        Log.i(TAG, "inputUser num = " + i);
        TextView textView = this.mTvInputUserFreq;
        if (textView != null) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
            this.mTvInputUserFreq.setTextSize(2, 34.0f);
        }
        if (this.mUserInputFreq.equals(getString(R.string.lbl_code_error))) {
            this.mUserInputFreq = "";
        }
        if (i != 11) {
            this.mUserInputFreq += i;
        } else if (this.mUserInputFreq.length() == 1) {
            this.mUserInputFreq = "";
        } else if (this.mUserInputFreq.length() > 0) {
            String str = this.mUserInputFreq;
            this.mUserInputFreq = str.substring(0, str.length() - 1);
        }
        TextView textView2 = this.mTvInputUserFreq;
        if (textView2 != null) {
            textView2.setText(this.mUserInputFreq);
        }
    }

    /* access modifiers changed from: package-private */
    public void confirmUserFreq() {
        if (this.mUserInputFreq.length() != 0) {
            if (isValidUserFreq()) {
                Log.i(TAG, "Code ok");
                this.mUserInputFreq = "";
                EventUtils.startActivityIfNotRuning(getApplicationContext(), "com.szchoiceway.fatset", "com.szchoiceway.fatset.FatSetMainActivity");
                finish();
            } else {
                Log.i(TAG, "Code error");
                this.mUserInputFreq = getString(R.string.lbl_code_error);
                TextView textView = this.mTvInputUserFreq;
                if (textView != null) {
                    textView.setTypeface(Typeface.defaultFromStyle(0));
                    this.mTvInputUserFreq.setTextSize(2, 28.0f);
                }
            }
            TextView textView2 = this.mTvInputUserFreq;
            if (textView2 != null) {
                textView2.setText(this.mUserInputFreq);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isValidUserFreq() {
        String str;
        int i = this.m_iUITypeVer;
        SysProviderOpt sysProviderOpt = this.mSysProviderOpt;
        if (i == 1 || i == 32 || i == 35 || i == 37 || i == 38 || i == 39 || i == 40 || i == 42 || i == 43 || i == 44 || i == 45) {
            str = "7890";
        } else if (i == 41) {
            str = sysProviderOpt.getRecordValue(SysProviderOpt.KSW_FACTORY_SET_PASSWORD);
            if (str.equals("")) {
                str = "1314";
            }
        } else {
            str = i == 36 ? "0000" : "8888";
        }
        if (str.equals(this.mUserInputFreq)) {
            return true;
        }
        Log.i(TAG, "Code error");
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mUserInputFreq = "";
        finish();
        return true;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BtnNum0 /*2131230727*/:
                inputUserFreq(0);
                return;
            case R.id.BtnNum1 /*2131230728*/:
                inputUserFreq(1);
                return;
            case R.id.BtnNum2 /*2131230731*/:
                inputUserFreq(2);
                return;
            case R.id.BtnNum3 /*2131230733*/:
                inputUserFreq(3);
                return;
            case R.id.BtnNum4 /*2131230735*/:
                inputUserFreq(4);
                return;
            case R.id.BtnNum5 /*2131230737*/:
                inputUserFreq(5);
                return;
            case R.id.BtnNum6 /*2131230738*/:
                inputUserFreq(6);
                return;
            case R.id.BtnNum7 /*2131230739*/:
                inputUserFreq(7);
                return;
            case R.id.BtnNum8 /*2131230741*/:
                inputUserFreq(8);
                return;
            case R.id.BtnNum9 /*2131230742*/:
                inputUserFreq(9);
                return;
            case R.id.BtnNumDel /*2131230743*/:
                inputUserFreq(11);
                return;
            case R.id.BtnNumOK /*2131230745*/:
                Log.i(TAG, "++++++BtnNumOK confirmUserFreq++++++");
                confirmUserFreq();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.choiceway.eventcenter.EventUtils.ZXW_ORIGINAL_MCU_KEY_FOCUS_MOVE_EVT");
        registerReceiver(this.mModel, intentFilter);
    }

    public void unregisterReceiver() {
        unregisterReceiver(this.mModel);
    }

    class NavSetModel extends BroadcastReceiver {
        NavSetModel() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.choiceway.eventcenter.EventUtils.ZXW_ORIGINAL_MCU_KEY_FOCUS_MOVE_EVT") && intent.getIntExtra("com.choiceway.eventcenter.EventUtils.ZXW_ORIGINAL_MCU_KEY_FOCUS_MOVE_DATA", -1) != -1 && CodeActivity.this.mHandler != null) {
                CodeActivity.this.mHandler.removeMessages(1);
                CodeActivity.this.mHandler.sendEmptyMessage(1);
            }
        }
    }
}
