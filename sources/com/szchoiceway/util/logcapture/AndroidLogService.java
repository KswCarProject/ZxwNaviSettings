package com.szchoiceway.util.logcapture;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class AndroidLogService extends Service {
    private static final int MSG_START_CAPTURE_LOG = 16385;
    public static final int MSG_STOP_CAPTURE_LOG = 16386;
    private static final String TAG = "AndroidLogService";
    private static String ksw_cartype_xml_gpscard_dir = "/storage/external_sd0";
    private static String ksw_cartype_xml_mediacard_dir = "/storage/external_sd";
    private static String ksw_cartype_xml_usb_dir = "/storage/usb_storage0";
    private static String ksw_cartype_xml_usb_dir1 = "/storage/usb_storage1";
    private static String ksw_cartype_xml_usb_dir2 = "/storage/usb_storage2";
    private static String local_path = "/storage/sdcard0/";
    /* access modifiers changed from: private */
    public boolean isLogCapture = false;
    /* access modifiers changed from: private */
    public String mDestPath = "";
    public final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != AndroidLogService.MSG_START_CAPTURE_LOG) {
                if (i == 16386 && AndroidLogService.this.isLogCapture) {
                    if (AndroidLogService.this.mLogcatHelper != null) {
                        AndroidLogService.this.mLogcatHelper.stop();
                        do {
                        } while (!AndroidLogService.this.mLogcatHelper.getStopLog());
                    }
                    AndroidLogService.this.sendBroadcast(new Intent("ZXW_ANDROID_LOG_CAPTURE_SAVE_SUCCEED"));
                    AndroidLogcatHelper unused = AndroidLogService.this.mLogcatHelper = null;
                    boolean unused2 = AndroidLogService.this.isLogCapture = false;
                    AndroidLogService.this.stopSelf();
                }
            } else if (!AndroidLogService.this.isLogCapture) {
                AndroidLogService androidLogService = AndroidLogService.this;
                AndroidLogService androidLogService2 = AndroidLogService.this;
                AndroidLogcatHelper unused3 = androidLogService.mLogcatHelper = new AndroidLogcatHelper(androidLogService2, androidLogService2.mDestPath);
                AndroidLogService.this.mLogcatHelper.start();
                sendEmptyMessageDelayed(16386, 30000);
                boolean unused4 = AndroidLogService.this.isLogCapture = true;
            }
        }
    };
    /* access modifiers changed from: private */
    public AndroidLogcatHelper mLogcatHelper = null;
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
        if (intent != null) {
            this.mDestPath = intent.getStringExtra("path");
            Log.d(TAG, "onStartCommand mDestPath = " + this.mDestPath);
            this.mHandler.sendEmptyMessage(MSG_START_CAPTURE_LOG);
        }
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
        intentFilter.addAction("ZXW_ANDROID_LOG_CAPTURE_STOP");
        registerReceiver(this.myBroadcast, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter2.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter2.addDataScheme("file");
        registerReceiver(this.myBroadcast, intentFilter2);
    }

    class MyBroadcast extends BroadcastReceiver {
        MyBroadcast() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("ZXW_ANDROID_LOG_CAPTURE_STOP")) {
                Log.d(AndroidLogService.TAG, "onReceive ZXW_ANDROID_LOG_CAPTURE_STOP");
                AndroidLogService.this.mHandler.removeMessages(16386);
                AndroidLogService.this.mHandler.sendEmptyMessage(16386);
            } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
                Log.d(AndroidLogService.TAG, "onReceive ACTION_MEDIA_UNMOUNTED");
                if (AndroidLogService.this.isLogCapture) {
                    AndroidLogService.this.stopSelf();
                }
            }
        }
    }
}
