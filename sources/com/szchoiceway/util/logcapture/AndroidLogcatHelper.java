package com.szchoiceway.util.logcapture;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.szchoiceway.settings.SysProviderOpt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class AndroidLogcatHelper {
    private static final String TAG = "AndroidLogcatHelper";
    private static String mTargetPath;
    /* access modifiers changed from: private */
    public InputStream in;
    /* access modifiers changed from: private */
    public boolean logStatus = false;
    /* access modifiers changed from: private */
    public AndroidLogService mContext;
    /* access modifiers changed from: private */
    public LogDumper mLogDumper = null;
    private int mPId;
    /* access modifiers changed from: private */
    public File mTargetFile;

    public AndroidLogcatHelper(Context context, String str) {
        this.mContext = (AndroidLogService) context;
        mTargetPath = str;
        this.mTargetFile = new File(mTargetPath);
        this.mPId = Process.myPid();
    }

    public void start() {
        if (this.mLogDumper == null) {
            this.mLogDumper = new LogDumper(String.valueOf(this.mPId), mTargetPath);
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

        public LogDumper(String str, String str2) {
            this.mPID = str;
            try {
                this.out = new FileOutputStream(new File(str2, "AndroidLogcat-" + MyDate.getFileName() + ".log"));
            } catch (Exception e) {
                this.mRunning = false;
                this.out = null;
                e.printStackTrace();
            }
            this.cmds = "logcat -b main -b system -b radio -b kernel -v threadtime ";
        }

        public void stopLogs() {
            this.mRunning = false;
        }

        public void run() {
            int read;
            try {
                Log.d(AndroidLogcatHelper.TAG, "LogDumper run");
                this.mRunning = true;
                byte[] bArr = new byte[524288];
                if (new File("/product/app/customer.xml").exists()) {
                    this.logcatProc = Runtime.getRuntime().exec("cat /product/app/customer.xml");
                } else if (new File("/product/app/customer_1920x720.xml").exists()) {
                    this.logcatProc = Runtime.getRuntime().exec("cat /product/app/customer_1920x720.xml");
                }
                InputStream unused = AndroidLogcatHelper.this.in = this.logcatProc.getInputStream();
                while (true) {
                    int read2 = AndroidLogcatHelper.this.in.read(bArr, 0, 524288);
                    if (read2 <= 0) {
                        break;
                    }
                    FileOutputStream fileOutputStream = this.out;
                    if (fileOutputStream != null) {
                        fileOutputStream.write(bArr, 0, read2);
                    }
                }
                Log.d(AndroidLogcatHelper.TAG, "LogDumper 000");
                AndroidLogcatHelper.this.in.close();
                SysProviderOpt instance = SysProviderOpt.getInstance(AndroidLogcatHelper.this.mContext);
                Iterator<String> it = instance.queryRecordItemName().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String recordValue = instance.getRecordValue(next);
                    FileOutputStream fileOutputStream2 = this.out;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.write((next + "|" + recordValue + "\n").getBytes());
                    }
                }
                Process exec = Runtime.getRuntime().exec("dmesg");
                this.logcatProc = exec;
                InputStream unused2 = AndroidLogcatHelper.this.in = exec.getInputStream();
                FileOutputStream fileOutputStream3 = this.out;
                if (fileOutputStream3 != null) {
                    fileOutputStream3.write("============================================================开始打印系统内核Log============================================================\n".getBytes());
                    Log.d(AndroidLogcatHelper.TAG, "开始打印系统内核Log");
                    while (true) {
                        int read3 = AndroidLogcatHelper.this.in.read(bArr, 0, 524288);
                        if (read3 <= 0) {
                            break;
                        }
                        FileOutputStream fileOutputStream4 = this.out;
                        if (fileOutputStream4 != null) {
                            fileOutputStream4.write(bArr, 0, read3);
                        }
                    }
                    AndroidLogcatHelper.this.in.close();
                    FileOutputStream fileOutputStream5 = this.out;
                    if (fileOutputStream5 != null) {
                        fileOutputStream5.write("============================================================开始打印系统Log============================================================\n".getBytes());
                    }
                    Log.d(AndroidLogcatHelper.TAG, "开始打印系统Log");
                    Process exec2 = Runtime.getRuntime().exec(this.cmds);
                    this.logcatProc = exec2;
                    InputStream unused3 = AndroidLogcatHelper.this.in = exec2.getInputStream();
                    while (this.mRunning && AndroidLogcatHelper.this.mTargetFile.exists() && (read = AndroidLogcatHelper.this.in.read(bArr, 0, 524288)) > 0) {
                        FileOutputStream fileOutputStream6 = this.out;
                        if (fileOutputStream6 != null) {
                            fileOutputStream6.write(bArr, 0, read);
                        }
                    }
                    Log.d(AndroidLogcatHelper.TAG, "LogDumper 111");
                    this.out.flush();
                    this.out.getFD().sync();
                    Log.d(AndroidLogcatHelper.TAG, "LogDumper 222");
                    Log.d(AndroidLogcatHelper.TAG, "finally");
                    Process process = this.logcatProc;
                    if (process != null) {
                        process.destroy();
                        this.logcatProc = null;
                    }
                    try {
                        if (AndroidLogcatHelper.this.in != null) {
                            AndroidLogcatHelper.this.in.close();
                            InputStream unused4 = AndroidLogcatHelper.this.in = null;
                        }
                        FileOutputStream fileOutputStream7 = this.out;
                        if (fileOutputStream7 != null) {
                            fileOutputStream7.close();
                            this.out = null;
                        }
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        LogDumper unused5 = AndroidLogcatHelper.this.mLogDumper = null;
                        boolean unused6 = AndroidLogcatHelper.this.logStatus = true;
                        Log.d(AndroidLogcatHelper.TAG, "LogDumper stop");
                    }
                    LogDumper unused7 = AndroidLogcatHelper.this.mLogDumper = null;
                    boolean unused8 = AndroidLogcatHelper.this.logStatus = true;
                    Log.d(AndroidLogcatHelper.TAG, "LogDumper stop");
                }
                Log.d(AndroidLogcatHelper.TAG, "finally");
                Process process2 = this.logcatProc;
                if (process2 != null) {
                    process2.destroy();
                    this.logcatProc = null;
                }
                try {
                    if (AndroidLogcatHelper.this.in != null) {
                        AndroidLogcatHelper.this.in.close();
                        InputStream unused9 = AndroidLogcatHelper.this.in = null;
                    }
                    FileOutputStream fileOutputStream8 = this.out;
                    if (fileOutputStream8 != null) {
                        fileOutputStream8.close();
                        this.out = null;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                LogDumper unused10 = AndroidLogcatHelper.this.mLogDumper = null;
                boolean unused11 = AndroidLogcatHelper.this.logStatus = true;
            } catch (Exception e3) {
                Log.d(AndroidLogcatHelper.TAG, "error");
                e3.printStackTrace();
                Log.d(AndroidLogcatHelper.TAG, "finally");
                Process process3 = this.logcatProc;
                if (process3 != null) {
                    process3.destroy();
                    this.logcatProc = null;
                }
                try {
                    if (AndroidLogcatHelper.this.in != null) {
                        AndroidLogcatHelper.this.in.close();
                        InputStream unused12 = AndroidLogcatHelper.this.in = null;
                    }
                    FileOutputStream fileOutputStream9 = this.out;
                    if (fileOutputStream9 != null) {
                        fileOutputStream9.close();
                        this.out = null;
                    }
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    LogDumper unused13 = AndroidLogcatHelper.this.mLogDumper = null;
                    boolean unused14 = AndroidLogcatHelper.this.logStatus = true;
                    Log.d(AndroidLogcatHelper.TAG, "LogDumper stop");
                }
            } catch (Throwable th) {
                Log.d(AndroidLogcatHelper.TAG, "finally");
                Process process4 = this.logcatProc;
                if (process4 != null) {
                    process4.destroy();
                    this.logcatProc = null;
                }
                try {
                    if (AndroidLogcatHelper.this.in != null) {
                        AndroidLogcatHelper.this.in.close();
                        InputStream unused15 = AndroidLogcatHelper.this.in = null;
                    }
                    FileOutputStream fileOutputStream10 = this.out;
                    if (fileOutputStream10 != null) {
                        fileOutputStream10.close();
                        this.out = null;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                LogDumper unused16 = AndroidLogcatHelper.this.mLogDumper = null;
                boolean unused17 = AndroidLogcatHelper.this.logStatus = true;
                throw th;
            }
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
