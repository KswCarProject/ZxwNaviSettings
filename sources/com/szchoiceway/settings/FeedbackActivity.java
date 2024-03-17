package com.szchoiceway.settings;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.util.logcapture.AndroidLogService;
import com.szchoiceway.zxwlib.utils.MultipleUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FeedbackActivity extends BaseActivity implements View.OnClickListener {
    private static final int LOG_ANDROID_CAPTURE_END = 1003;
    private static final int LOG_ANDROID_CAPTURE_SAVE = 1002;
    private static final int LOG_ANDROID_CAPTURE_START = 1001;
    private static final int LOG_HIDE_TIPS = 1000;
    private static final int LOG_MCU_CAN1_CAPTURE_END = 2003;
    private static final int LOG_MCU_CAN1_CAPTURE_SAVE = 2002;
    private static final int LOG_MCU_CAN1_CAPTURE_START = 2001;
    private static final int LOG_MCU_CAN2_CAPTURE_END = 3003;
    private static final int LOG_MCU_CAN2_CAPTURE_SAVE = 3002;
    private static final int LOG_MCU_CAN2_CAPTURE_START = 3001;
    private static final int LOG_NO_DISK = 998;
    private static final int LOG_REMOVE_DISK = 999;
    private static final String TAG = "FeedbackActivity";
    CheckBox btnAndroidLog;
    /* access modifiers changed from: private */
    public Button btnCanEnd;
    /* access modifiers changed from: private */
    public Button btnCanStart;
    Button btnMCULog;
    private CheckBox chkCan1;
    private CheckBox chkCan2;
    /* access modifiers changed from: private */
    public String localPath;
    Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            switch (i) {
                case FeedbackActivity.LOG_NO_DISK /*998*/:
                    FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_no_disk));
                    if (FeedbackActivity.this.btnAndroidLog.isChecked()) {
                        FeedbackActivity.this.btnAndroidLog.setChecked(false);
                    }
                    FeedbackActivity.this.btnAndroidLog.setClickable(true);
                    FeedbackActivity.this.btnCanStart.setClickable(true);
                    return;
                case FeedbackActivity.LOG_REMOVE_DISK /*999*/:
                    if (FeedbackActivity.this.btnAndroidLog.isChecked()) {
                        FeedbackActivity.this.btnAndroidLog.setChecked(false);
                    }
                    FeedbackActivity.this.btnAndroidLog.setClickable(true);
                    FeedbackActivity.this.btnCanStart.setClickable(true);
                    FeedbackActivity.this.tips.setText(R.string.lbl_remove_disk);
                    sendEmptyMessageDelayed(1000, 5000);
                    return;
                case 1000:
                    FeedbackActivity.this.tips.setVisibility(8);
                    return;
                case 1001:
                    Log.d(FeedbackActivity.TAG, "LOG_ANDROID_CAPTURE_START mPath = " + FeedbackActivity.this.mPath);
                    FeedbackActivity.this.tips.setVisibility(0);
                    FeedbackActivity.this.tips.setText("");
                    if (FeedbackActivity.this.mPath.startsWith(FeedbackActivity.this.localPath)) {
                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_android_logcapture_start_local));
                    } else {
                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_android_logcapture_start));
                    }
                    FeedbackActivity.this.btnCanStart.setClickable(false);
                    FeedbackActivity.this.btnCanEnd.setClickable(false);
                    return;
                case 1002:
                    Log.d(FeedbackActivity.TAG, "LOG_ANDROID_CAPTURE_SAVE");
                    if (FeedbackActivity.this.mPath.startsWith(FeedbackActivity.this.localPath)) {
                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_android_logcapture_save_local));
                        return;
                    } else {
                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_android_logcapture_save));
                        return;
                    }
                case 1003:
                    Log.d(FeedbackActivity.TAG, "LOG_ANDROID_CAPTURE_END");
                    if (FeedbackActivity.this.mPath.startsWith(FeedbackActivity.this.localPath)) {
                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_android_logcapture_end_local));
                    } else {
                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_android_logcapture_end));
                    }
                    FeedbackActivity.this.btnCanStart.setClickable(true);
                    FeedbackActivity.this.btnCanEnd.setClickable(true);
                    if (FeedbackActivity.this.btnAndroidLog.isChecked()) {
                        FeedbackActivity.this.btnAndroidLog.setChecked(false);
                        return;
                    }
                    return;
                default:
                    switch (i) {
                        case FeedbackActivity.LOG_MCU_CAN1_CAPTURE_START /*2001*/:
                            Log.d(FeedbackActivity.TAG, "LOG_MCU_CAN1_CAPTURE_START");
                            FeedbackActivity.this.tips.setVisibility(0);
                            FeedbackActivity.this.tips.setText("");
                            if (FeedbackActivity.this.mPath.startsWith(FeedbackActivity.this.localPath)) {
                                FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can1_logcapture_start_local));
                            } else {
                                FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can1_logcapture_start));
                            }
                            FeedbackActivity.this.btnAndroidLog.setClickable(false);
                            FeedbackActivity.this.btnCanStart.setClickable(false);
                            FeedbackActivity.this.viewCan2.setClickable(false);
                            return;
                        case FeedbackActivity.LOG_MCU_CAN1_CAPTURE_SAVE /*2002*/:
                            Log.d(FeedbackActivity.TAG, "LOG_MCU_CAN1_CAPTURE_SAVE");
                            if (FeedbackActivity.this.mPath.startsWith(FeedbackActivity.this.localPath)) {
                                FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can1_logcapture_save_local));
                                return;
                            } else {
                                FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can1_logcapture_save));
                                return;
                            }
                        case FeedbackActivity.LOG_MCU_CAN1_CAPTURE_END /*2003*/:
                            Log.d(FeedbackActivity.TAG, "LOG_MCU_CAN1_CAPTURE_END");
                            if (FeedbackActivity.this.mPath.startsWith(FeedbackActivity.this.localPath)) {
                                FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can1_logcapture_end_local));
                            } else {
                                FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can1_logcapture_end));
                            }
                            FeedbackActivity.this.btnAndroidLog.setClickable(true);
                            FeedbackActivity.this.btnCanStart.setClickable(true);
                            FeedbackActivity.this.viewCan2.setClickable(true);
                            return;
                        default:
                            switch (i) {
                                case FeedbackActivity.LOG_MCU_CAN2_CAPTURE_START /*3001*/:
                                    Log.d(FeedbackActivity.TAG, "LOG_MCU_CAN2_CAPTURE_START");
                                    FeedbackActivity.this.tips.setVisibility(0);
                                    FeedbackActivity.this.tips.setText("");
                                    if (FeedbackActivity.this.mPath.startsWith(FeedbackActivity.this.localPath)) {
                                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can2_logcapture_start_local));
                                    } else {
                                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can2_logcapture_start));
                                    }
                                    FeedbackActivity.this.btnAndroidLog.setClickable(false);
                                    FeedbackActivity.this.btnCanStart.setClickable(false);
                                    FeedbackActivity.this.viewCan1.setClickable(false);
                                    return;
                                case FeedbackActivity.LOG_MCU_CAN2_CAPTURE_SAVE /*3002*/:
                                    Log.d(FeedbackActivity.TAG, "LOG_MCU_CAN2_CAPTURE_SAVE");
                                    if (FeedbackActivity.this.mPath.startsWith(FeedbackActivity.this.localPath)) {
                                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can2_logcapture_save_local));
                                        return;
                                    } else {
                                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can2_logcapture_save));
                                        return;
                                    }
                                case FeedbackActivity.LOG_MCU_CAN2_CAPTURE_END /*3003*/:
                                    Log.d(FeedbackActivity.TAG, "LOG_MCU_CAN2_CAPTURE_END");
                                    if (FeedbackActivity.this.mPath.startsWith(FeedbackActivity.this.localPath)) {
                                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can2_logcapture_end_local));
                                    } else {
                                        FeedbackActivity.this.tips.setText(FeedbackActivity.this.getString(R.string.lbl_mcu_can2_logcapture_end));
                                    }
                                    FeedbackActivity.this.btnAndroidLog.setClickable(true);
                                    FeedbackActivity.this.btnCanStart.setClickable(true);
                                    FeedbackActivity.this.viewCan1.setClickable(true);
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
    };
    /* access modifiers changed from: private */
    public String mPath;
    private SysProviderOpt mProvider = null;
    IEventService mService;
    private int m_iModeSet = 0;
    public int m_iUITypeVer = 101;
    private MyBroadcast myBroadcast;
    private ServiceConnection osc = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(FeedbackActivity.TAG, "onServiceConnected");
            FeedbackActivity.this.mService = IEventService.Stub.asInterface(iBinder);
            Log.d(FeedbackActivity.TAG, "mService = " + FeedbackActivity.this.mService);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(FeedbackActivity.TAG, "onServiceDisconnected");
            FeedbackActivity.this.mService = null;
        }
    };
    TextView tips;
    /* access modifiers changed from: private */
    public View viewCan1;
    /* access modifiers changed from: private */
    public View viewCan2;
    private View viewPage1;
    private View viewPage2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MultipleUtils.setCustomDensity(this, getApplication());
        startConnectService();
        SysProviderOpt instance = SysProviderOpt.getInstance(this);
        this.mProvider = instance;
        this.m_iUITypeVer = instance.getRecordInteger("Set_User_UI_Type", this.m_iUITypeVer);
        this.m_iModeSet = this.mProvider.getRecordInteger("KESAIWEI_SYS_MODE_SELECTION", this.m_iModeSet);
        String recordValue = this.mProvider.getRecordValue("KSW_UI_RESOLUTION", "");
        Log.d(TAG, "resolution = " + recordValue);
        if (this.m_iUITypeVer == 41) {
            if ("1024x600".equals(recordValue)) {
                setContentView(R.layout.small_kesaiwei_1920x720_evo_id7_activity_feedback);
            } else if ("1280x720".equals(recordValue)) {
                setContentView(R.layout.small_kesaiwei_1280x720_evo_id7_activity_feedback);
            } else if ("1560x700".equals(recordValue)) {
                setContentView(R.layout.kesaiwei_1560x700_evo_id7_activity_feedback);
            } else {
                setContentView(R.layout.kesaiwei_1920x720_evo_id7_activity_feedback);
            }
        }
        initView();
        registerMyBroadcast();
        this.localPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        sendModeTitle(EventUtils.eSrcMode.SRC_FEEDBACK.getIntValue());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        sendModeTitle(EventUtils.eSrcMode.SRC_NULL.getIntValue());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        unregisterReceiver(this.myBroadcast);
        stopConntectService();
    }

    private void initView() {
        this.viewPage1 = findViewById(R.id.viewPage1);
        this.viewPage2 = findViewById(R.id.viewPage2);
        showPage1(true);
        CheckBox checkBox = (CheckBox) findViewById(R.id.btnAndroidLog);
        this.btnAndroidLog = checkBox;
        if (checkBox != null) {
            checkBox.setOnClickListener(this);
            this.btnAndroidLog.setClickable(true);
        }
        Button button = (Button) findViewById(R.id.btnMCULog);
        this.btnMCULog = button;
        if (button != null) {
            button.setOnClickListener(this);
        }
        TextView textView = (TextView) findViewById(R.id.tips);
        this.tips = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View findViewById = findViewById(R.id.viewCan1);
        this.viewCan1 = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = findViewById(R.id.viewCan2);
        this.viewCan2 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        this.chkCan1 = (CheckBox) findViewById(R.id.chkCan1);
        this.chkCan2 = (CheckBox) findViewById(R.id.chkCan2);
        switchCan(1);
        Button button2 = (Button) findViewById(R.id.btnStart);
        this.btnCanStart = button2;
        if (button2 != null) {
            button2.setOnClickListener(this);
        }
        Button button3 = (Button) findViewById(R.id.btnEnd);
        this.btnCanEnd = button3;
        if (button3 != null) {
            button3.setOnClickListener(this);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAndroidLog /*2131230938*/:
                Log.d(TAG, "onClick btnAndroidLog  " + this.btnAndroidLog.isChecked());
                if (this.btnAndroidLog.isChecked()) {
                    this.mPath = getAndroidLogPath("alog");
                    this.mHandler.removeMessages(1001);
                    this.mHandler.sendEmptyMessage(1001);
                    Intent intent = new Intent(getApplicationContext(), AndroidLogService.class);
                    intent.putExtra("path", this.mPath);
                    startService(intent);
                    return;
                }
                sendBroadcast(new Intent("ZXW_ANDROID_LOG_CAPTURE_STOP"));
                this.mHandler.removeMessages(1002);
                this.mHandler.sendEmptyMessage(1002);
                return;
            case R.id.btnEnd /*2131230973*/:
                if (this.chkCan1.isChecked() && !this.chkCan2.isChecked()) {
                    this.mProvider.updateRecord(SysProviderOpt.KSW_COLLECT_CAN_DATA_SWITCH_INDEX, "0");
                    kesaiwei_sendBroadcast(34);
                    sendBroadcast(new Intent("ZXW_MCU_LOG_CAPTURE_STOP"));
                    this.mHandler.removeMessages(LOG_MCU_CAN1_CAPTURE_SAVE);
                    this.mHandler.sendEmptyMessage(LOG_MCU_CAN1_CAPTURE_SAVE);
                }
                if (!this.chkCan1.isChecked() && this.chkCan2.isChecked()) {
                    this.mProvider.updateRecord(SysProviderOpt.KSW_COLLECT_CAN_DATA_SWITCH_INDEX, "0");
                    kesaiwei_sendBroadcast(34);
                    sendBroadcast(new Intent("ZXW_MCU_LOG_CAPTURE_STOP"));
                    this.mHandler.removeMessages(LOG_MCU_CAN2_CAPTURE_SAVE);
                    this.mHandler.sendEmptyMessage(LOG_MCU_CAN2_CAPTURE_SAVE);
                    return;
                }
                return;
            case R.id.btnMCULog /*2131231001*/:
                showPage1(false);
                return;
            case R.id.btnStart /*2131231042*/:
                if (this.chkCan1.isChecked() && !this.chkCan2.isChecked()) {
                    this.mPath = getAndroidLogPath("mlog");
                    this.mProvider.updateRecord(SysProviderOpt.KSW_COLLECT_CAN_DATA_SWITCH_INDEX, "1");
                    kesaiwei_sendBroadcast(34);
                    this.mHandler.removeMessages(LOG_MCU_CAN1_CAPTURE_START);
                    this.mHandler.sendEmptyMessage(LOG_MCU_CAN1_CAPTURE_START);
                }
                if (!this.chkCan1.isChecked() && this.chkCan2.isChecked()) {
                    this.mPath = getAndroidLogPath("mlog");
                    this.mProvider.updateRecord(SysProviderOpt.KSW_COLLECT_CAN_DATA_SWITCH_INDEX, "2");
                    kesaiwei_sendBroadcast(34);
                    this.mHandler.removeMessages(LOG_MCU_CAN2_CAPTURE_START);
                    this.mHandler.sendEmptyMessage(LOG_MCU_CAN2_CAPTURE_START);
                    return;
                }
                return;
            case R.id.viewCan1 /*2131231540*/:
                switchCan(1);
                return;
            case R.id.viewCan2 /*2131231541*/:
                switchCan(2);
                return;
            default:
                return;
        }
    }

    private void switchCan(int i) {
        if (i == 1) {
            CheckBox checkBox = this.chkCan1;
            if (checkBox != null) {
                checkBox.setChecked(true);
            }
            CheckBox checkBox2 = this.chkCan2;
            if (checkBox2 != null) {
                checkBox2.setChecked(false);
            }
        } else if (i == 2) {
            CheckBox checkBox3 = this.chkCan1;
            if (checkBox3 != null) {
                checkBox3.setChecked(false);
            }
            CheckBox checkBox4 = this.chkCan2;
            if (checkBox4 != null) {
                checkBox4.setChecked(true);
            }
        } else {
            CheckBox checkBox5 = this.chkCan1;
            if (checkBox5 != null) {
                checkBox5.setChecked(false);
            }
            CheckBox checkBox6 = this.chkCan2;
            if (checkBox6 != null) {
                checkBox6.setChecked(false);
            }
        }
    }

    private void showPage1(boolean z) {
        Log.d(TAG, "showPage1 " + z);
        if (z) {
            View view = this.viewPage1;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.viewPage2;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.viewPage1;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.viewPage2;
        if (view4 != null) {
            view4.setVisibility(0);
        }
    }

    public void onBackPressed() {
        View view;
        Log.d(TAG, "onBackPressed");
        View view2 = this.viewPage1;
        if (view2 == null || view2.getVisibility() != 8 || (view = this.viewPage2) == null || view.getVisibility() != 0) {
            super.onBackPressed();
            finish();
            return;
        }
        showPage1(true);
    }

    private void registerMyBroadcast() {
        if (this.myBroadcast == null) {
            this.myBroadcast = new MyBroadcast();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.myBroadcast, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("ZXW_ANDROID_LOG_CAPTURE_SAVE_SUCCEED");
        intentFilter2.addAction("ZXW_MCU_CAN1_LOG_CAPTURE_SAVE_SUCCEED");
        intentFilter2.addAction("ZXW_MCU_CAN2_LOG_CAPTURE_SAVE_SUCCEED");
        intentFilter2.addAction("ZXW_LOG_CAPTURE_NO_DISK");
        registerReceiver(this.myBroadcast, intentFilter2);
    }

    class MyBroadcast extends BroadcastReceiver {
        MyBroadcast() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
                FeedbackActivity.this.mHandler.sendEmptyMessage(FeedbackActivity.LOG_REMOVE_DISK);
            } else if (action.equals("ZXW_ANDROID_LOG_CAPTURE_SAVE_SUCCEED")) {
                FeedbackActivity.this.mHandler.sendEmptyMessage(1003);
            } else if (action.equals("ZXW_MCU_CAN1_LOG_CAPTURE_SAVE_SUCCEED")) {
                FeedbackActivity.this.mHandler.sendEmptyMessage(FeedbackActivity.LOG_MCU_CAN1_CAPTURE_END);
            } else if (action.equals("ZXW_MCU_CAN2_LOG_CAPTURE_SAVE_SUCCEED")) {
                FeedbackActivity.this.mHandler.sendEmptyMessage(FeedbackActivity.LOG_MCU_CAN2_CAPTURE_END);
            } else if (action.equals("ZXW_LOG_CAPTURE_NO_DISK")) {
                FeedbackActivity.this.mHandler.sendEmptyMessage(FeedbackActivity.LOG_NO_DISK);
            }
        }
    }

    private void startConnectService() {
        try {
            Intent intent = new Intent();
            intent.setAction("com.szchoiceway.eventcenter.EventService");
            intent.setPackage(EventUtils.EVENT_SERVICE_PACKAGE);
            Log.d(TAG, "onBindService: " + bindService(intent, this.osc, 1));
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

    public void sendModeTitle(int i) {
        Intent intent = new Intent("com.szchoiceway.action.mode_title_change");
        intent.putExtra("com.szchoiceway.action.mode_title_change_extra", i);
        intent.putExtra("com.szchoiceway.action.mode_title_change_screen_extra", true);
        sendBroadcastAsUser(intent, UserHandle.ALL);
    }

    private void kesaiwei_sendBroadcast(int i) {
        Intent intent = new Intent(EventUtils.ZXW_SENDBROADCAST8902MOD);
        intent.putExtra(EventUtils.ZXW_SENDBROADCAST8902MOD_EXTRA, i);
        sendBroadcast(intent);
    }

    private String getAndroidLogPath(String str) {
        List volumes = ((StorageManager) getSystemService(StorageManager.class)).getVolumes();
        Log.d(TAG, "localPath = " + this.localPath);
        Iterator it = volumes.iterator();
        String str2 = "";
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            VolumeInfo volumeInfo = (VolumeInfo) it.next();
            if (volumeInfo.getType() == 0 && volumeInfo.isMountedReadable()) {
                Log.d(TAG, "Volume path:" + volumeInfo.getPath());
                File file = new File(volumeInfo.getPath().toString());
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        File file2 = listFiles[i];
                        if (file2.isDirectory() && str.equalsIgnoreCase(file2.getName())) {
                            str2 = file2.getPath();
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        Log.d(TAG, "savePath0 = " + str2);
        if ("".equals(str2)) {
            File file3 = new File(this.localPath + "/" + str);
            if (!file3.exists() || !file3.isDirectory()) {
                file3.mkdir();
            }
            str2 = file3.getPath();
        }
        Log.d(TAG, "savePath1 = " + str2);
        File[] listFiles2 = new File(str2).listFiles();
        if (listFiles2.length == 10) {
            Arrays.sort(listFiles2, new Comparator<File>() {
                public int compare(File file, File file2) {
                    return file2.lastModified() > file.lastModified() ? -1 : 1;
                }
            });
            Log.d(TAG, "delete = " + listFiles2[0].delete() + ", childFile size = " + listFiles2.length);
        }
        return str2;
    }
}
