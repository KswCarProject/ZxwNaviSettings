package com.szchoiceway.util.logcapture;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.szchoiceway.eventcenter.EventUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MCULogcatHelper {
    private static String PATH_LOGCAT = null;
    private static final String TAG = "MCULogcatHelper";
    /* access modifiers changed from: private */
    public int canIndex;
    /* access modifiers changed from: private */
    public boolean logStatus = false;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public LogDumper mLogDumper = null;
    private int mPId;

    public void init(Context context, String str) {
        PATH_LOGCAT = str;
    }

    public MCULogcatHelper(Context context, String str, int i) {
        this.mContext = context;
        this.canIndex = i;
        init(context, str);
        this.mPId = Process.myPid();
    }

    public void start() {
        if (this.mLogDumper == null) {
            this.mLogDumper = new LogDumper(this.mContext, String.valueOf(this.mPId), PATH_LOGCAT);
        }
        this.mLogDumper.start();
    }

    public void stop() {
        LogDumper logDumper = this.mLogDumper;
        if (logDumper != null) {
            logDumper.stopLogs();
        }
    }

    private class LogDumper extends Thread {
        String cmds = null;
        private Process logcatProc;
        private String mPID;
        private boolean mRunning = true;
        private FileOutputStream out = null;

        public LogDumper(Context context, String str, String str2) {
            Log.d(MCULogcatHelper.TAG, "LogDumper canIndex = " + MCULogcatHelper.this.canIndex);
            this.mPID = str;
            try {
                if (MCULogcatHelper.this.canIndex == 1) {
                    this.out = new FileOutputStream(new File(str2, "CANBus_Log_CAN1_" + MyDate.getFileName() + ".log"));
                } else {
                    this.out = new FileOutputStream(new File(str2, "CANBus_Log_CAN2_" + MyDate.getFileName() + ".log"));
                }
            } catch (Exception e) {
                this.mRunning = false;
                this.out = null;
                e.printStackTrace();
            }
            this.cmds = "logcat -s SerialPortData";
        }

        public void stopLogs() {
            this.mRunning = false;
            Log.d(MCULogcatHelper.TAG, "set mRunning false");
            MCULogcatHelper.this.mContext.sendBroadcast(new Intent(EventUtils.ZXW_ACTION_KSW_END_MCU_LOGCAT));
        }

        public void run() {
            int read;
            try {
                Runtime.getRuntime().exec("logcat -c");
                this.mRunning = true;
                byte[] bArr = new byte[1024];
                FileOutputStream fileOutputStream = this.out;
                if (fileOutputStream != null) {
                    fileOutputStream.write("============================================================开始打印MCULog============================================================\n".getBytes());
                }
                Log.d(MCULogcatHelper.TAG, "开始打印MCULog");
                Process exec = Runtime.getRuntime().exec(this.cmds);
                this.logcatProc = exec;
                InputStream inputStream = exec.getInputStream();
                while (this.mRunning && (read = inputStream.read(bArr, 0, 1024)) > 0) {
                    Log.d(MCULogcatHelper.TAG, "mRunning = " + this.mRunning);
                    if (this.out != null) {
                        Log.d(MCULogcatHelper.TAG, "out.write111");
                        this.out.write(bArr, 0, read);
                        Log.d(MCULogcatHelper.TAG, "out.write222");
                    }
                }
                Log.d(MCULogcatHelper.TAG, "停止打印MCULog111");
                inputStream.close();
                this.out.flush();
                this.out.getFD().sync();
                Log.d(MCULogcatHelper.TAG, "停止打印MCULog222");
                boolean unused = MCULogcatHelper.this.logStatus = true;
                Process process = this.logcatProc;
                if (process != null) {
                    process.destroy();
                    this.logcatProc = null;
                }
                FileOutputStream fileOutputStream2 = this.out;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.out = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Process process2 = this.logcatProc;
                if (process2 != null) {
                    process2.destroy();
                    this.logcatProc = null;
                }
                FileOutputStream fileOutputStream3 = this.out;
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                Process process3 = this.logcatProc;
                if (process3 != null) {
                    process3.destroy();
                    this.logcatProc = null;
                }
                FileOutputStream fileOutputStream4 = this.out;
                if (fileOutputStream4 != null) {
                    try {
                        fileOutputStream4.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    this.out = null;
                }
                LogDumper unused2 = MCULogcatHelper.this.mLogDumper = null;
                throw th;
            }
            LogDumper unused3 = MCULogcatHelper.this.mLogDumper = null;
        }
    }

    public boolean getStopLog() {
        return this.logStatus;
    }

    public static class MyDate {
        public static String getFileName() {
            return new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date(System.currentTimeMillis()));
        }

        public static String getDateEN() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        }
    }
}
