package com.szchoiceway.util.logcapture;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.szchoiceway.settings.SysProviderOpt;

public class MCULogService extends Service {
    private static final int MSG_START_CAPTURE_LOG = 16385;
    private static final int MSG_STOP_CAPTURE_LOG = 16386;
    private static final String TAG = "MCULogService";
    private static String ksw_cartype_xml_gpscard_dir = "/storage/external_sd0";
    private static String ksw_cartype_xml_mediacard_dir = "/storage/external_sd";
    private static String ksw_cartype_xml_usb_dir = "/storage/usb_storage0";
    private static String ksw_cartype_xml_usb_dir1 = "/storage/usb_storage1";
    private static String ksw_cartype_xml_usb_dir2 = "/storage/usb_storage2";
    private static String local_path = "/storage/sdcard0/";
    /* access modifiers changed from: private */
    public int canIndex = 0;
    /* access modifiers changed from: private */
    public String mDestPath;
    /* access modifiers changed from: private */
    public Handler mhandler = new Handler() {
        private MCULogcatHelper mLogcatHelper = null;

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == MCULogService.MSG_START_CAPTURE_LOG) {
                MCULogService mCULogService = MCULogService.this;
                int unused = mCULogService.canIndex = SysProviderOpt.getInstance(mCULogService).getRecordInteger(SysProviderOpt.KSW_COLLECT_CAN_DATA_SWITCH_INDEX, 1);
                MCULogcatHelper mCULogcatHelper = this.mLogcatHelper;
                if (mCULogcatHelper != null) {
                    mCULogcatHelper.stop();
                }
                MCULogService mCULogService2 = MCULogService.this;
                MCULogcatHelper mCULogcatHelper2 = new MCULogcatHelper(mCULogService2, mCULogService2.mDestPath, MCULogService.this.canIndex);
                this.mLogcatHelper = mCULogcatHelper2;
                mCULogcatHelper2.start();
            } else if (i == 16386) {
                MCULogcatHelper mCULogcatHelper3 = this.mLogcatHelper;
                if (mCULogcatHelper3 != null) {
                    mCULogcatHelper3.stop();
                    do {
                    } while (!this.mLogcatHelper.getStopLog());
                    if (MCULogService.this.canIndex == 1) {
                        MCULogService.this.sendBroadcast(new Intent("ZXW_MCU_CAN1_LOG_CAPTURE_SAVE_SUCCEED"));
                    } else {
                        MCULogService.this.sendBroadcast(new Intent("ZXW_MCU_CAN2_LOG_CAPTURE_SAVE_SUCCEED"));
                    }
                    this.mLogcatHelper = null;
                }
                MCULogService.this.stopSelf();
            }
        }
    };
    private MyBroadcast myBroadcast;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        Log.i(TAG, "onCreate");
        super.onCreate();
        register();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.mDestPath = intent.getStringExtra("path");
        Log.d(TAG, "onStartCommand mDestPath = " + this.mDestPath);
        this.mhandler.sendEmptyMessage(MSG_START_CAPTURE_LOG);
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        unregisterReceiver(this.myBroadcast);
    }

    private void register() {
        if (this.myBroadcast == null) {
            this.myBroadcast = new MyBroadcast();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ZXW_MCU_LOG_CAPTURE_STOP");
        registerReceiver(this.myBroadcast, intentFilter);
    }

    class MyBroadcast extends BroadcastReceiver {
        MyBroadcast() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("ZXW_MCU_LOG_CAPTURE_STOP")) {
                Log.d(MCULogService.TAG, "onReceive ");
                MCULogService.this.mhandler.sendEmptyMessage(16386);
            }
        }
    }
}
