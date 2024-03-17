package com.szchoiceway.settings;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.StatFs;
import android.os.UserHandle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.settings.view.MyScrollbar;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import kotlin.UByte;

public class FragmentSysInfor extends FragmentBase implements View.OnClickListener {
    private static final int KSW_LANGUAGE_CHANGED = 1;
    private static final String NF_SERIAL_PATH = "/sys/bus/mmc/devices/mmc0:0001/serial";
    protected static final String TAG = "FragmentSysInfor";
    private static DecimalFormat fileDecimalFormat = new DecimalFormat("#0.00");
    private static DecimalFormat fileIntegerFormat = new DecimalFormat("#0");
    private static String result = "";
    private boolean bAssistiveTouch = false;
    private boolean bBackcarFullview = false;
    private boolean bBackcarRadar = true;
    private boolean bBackcarTrack = true;
    private boolean bCheckBrake = false;
    private boolean bKeyDownSound = false;
    private boolean bLEDColorSetStatus = false;
    private boolean bLiShengDVD = true;
    private boolean bLiShengType = false;
    private boolean bNaiAoShiDVD = false;
    private boolean bNaiAoShiType = false;
    private boolean bOrgBackcar = false;
    private boolean mAmbientLight = false;
    private Handler mHandler = null;
    private MainActivity mMain;
    private SysInforReceiver mModel = new SysInforReceiver();
    /* access modifiers changed from: private */
    public ScrollView mScrollView;
    private SysProviderOpt mSysProviderOpt = null;
    private View mainView = null;
    private RelativeLayout mlytSysSet = null;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    /* access modifiers changed from: private */
    public View scrollLayout;
    /* access modifiers changed from: private */
    public int totalHeight = 0;

    public static String formatFileSize(long j, boolean z) {
        double d = ((double) j) / 1.073741824E9d;
        return (d <= 1.0d || d > 2.0d) ? (d <= 2.0d || d > 4.0d) ? (d <= 4.0d || d > 8.0d) ? (d <= 8.0d || d > 12.0d) ? "4G" : "12G" : "8G" : "4G" : "2G";
    }

    public String getFragmentTag() {
        return TAG;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        this.mSysProviderOpt = SysProviderOpt.getInstance(getContext());
        this.mMain = (MainActivity) getActivity();
        Log.i(TAG, "mMain.m_iUITypeVer = " + this.mMain.m_iUITypeVer);
        if (this.m_iUITypeVer != 41) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_infor, (ViewGroup) null);
        } else if (this.isSmallResolution) {
            if (isDefaultUI()) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_infor, (ViewGroup) null);
            } else if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_infor, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_infor, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_infor, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_info, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_system_info, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_infor, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_info_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_infor, (ViewGroup) null);
            }
        } else if (isDefaultUI()) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_infor, (ViewGroup) null);
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_infor, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_infor, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_infor, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_infor, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_info, (ViewGroup) null);
        } else if (this.m_iUIIndex == 5) {
            view = layoutInflater.inflate(R.layout.landrover_fragment_system_info, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_infor, (ViewGroup) null);
        }
        this.mainView = view;
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i(TAG, "onCreateView'");
        registerReceiver();
        this.mHandler = new Handler_KSW();
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mainView = null;
        unregisterReceiver();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindViewListener(android.view.View r11) {
        /*
            r10 = this;
            super.bindViewListener(r11)
            if (r11 != 0) goto L_0x0006
            return
        L_0x0006:
            r0 = 2131231285(0x7f080235, float:1.8078647E38)
            android.view.View r0 = r11.findViewById(r0)
            com.szchoiceway.settings.view.MyScrollbar r0 = (com.szchoiceway.settings.view.MyScrollbar) r0
            r10.myScrollbar = r0
            r0 = 2131231275(0x7f08022b, float:1.8078626E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r10.mScrollView = r0
            r0 = 2131231273(0x7f080229, float:1.8078622E38)
            android.view.View r0 = r11.findViewById(r0)
            r10.scrollLayout = r0
            if (r0 == 0) goto L_0x0033
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
            com.szchoiceway.settings.FragmentSysInfor$1 r1 = new com.szchoiceway.settings.FragmentSysInfor$1
            r1.<init>()
            r0.addOnGlobalLayoutListener(r1)
        L_0x0033:
            android.os.Handler r0 = r10.mHandler
            if (r0 != 0) goto L_0x003e
            com.szchoiceway.settings.FragmentSysInfor$Handler_KSW r0 = new com.szchoiceway.settings.FragmentSysInfor$Handler_KSW
            r0.<init>()
            r10.mHandler = r0
        L_0x003e:
            r10.SetMcuVer()
            r0 = 2131230834(0x7f080072, float:1.8077732E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0051
            java.lang.String r1 = android.os.Build.VERSION.RELEASE
            r0.setText(r1)
        L_0x0051:
            r0 = 2131230824(0x7f080068, float:1.8077712E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 1
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x012e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "bindViewListener: android.os.Build.DISPLAY = "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = android.os.Build.DISPLAY
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "FragmentSysInfor"
            android.util.Log.i(r4, r3)
            java.lang.String r3 = android.os.Build.MODEL
            java.lang.String r5 = android.os.Build.DISPLAY
            java.lang.String r6 = r10.getBasebandVer()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "baseband_ver = "
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r6)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r4, r7)
            boolean r7 = r2.equals(r6)
            java.lang.String r8 = "-"
            if (r7 != 0) goto L_0x00a7
            java.lang.String r7 = "GT6"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x00af
        L_0x00a7:
            java.lang.String r7 = "GT6-CAR"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x00f6
        L_0x00af:
            boolean r3 = r2.equals(r6)
            if (r3 != 0) goto L_0x00c2
            java.lang.String r3 = "\\."
            java.lang.String[] r3 = r6.split(r3)
            int r7 = r3.length
            r9 = 4
            if (r7 <= r9) goto L_0x00c2
            r3 = r3[r9]
            goto L_0x00c3
        L_0x00c2:
            r3 = r2
        L_0x00c3:
            int r7 = r3.length()
            if (r7 <= 0) goto L_0x00ef
            r7 = 0
            java.lang.String r3 = r3.substring(r7, r1)
            java.lang.String r7 = "3"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x00e2
            java.lang.String r3 = "SS.V0.02"
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x00df
            goto L_0x00e2
        L_0x00df:
            java.lang.String r3 = "EAU"
            goto L_0x00e4
        L_0x00e2:
            java.lang.String r3 = "NA"
        L_0x00e4:
            java.lang.String[] r6 = r5.split(r8)
            r6 = r6[r1]
            java.lang.String r5 = r5.replace(r6, r3)
            goto L_0x00fc
        L_0x00ef:
            java.lang.String[] r3 = r5.split(r8)
            r3 = r3[r1]
            goto L_0x00fc
        L_0x00f6:
            java.lang.String[] r3 = r5.split(r8)
            r3 = r3[r1]
        L_0x00fc:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "value = "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r3)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r4, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "bootVer = "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r5)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r4, r6)
            r10.SetAppVer(r3)
            r0.setText(r5)
        L_0x012e:
            r0 = 2131230833(0x7f080071, float:1.807773E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x015b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = getAvailableInternalMemorySize()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "/"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = getTotalInternalMemorySize()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
        L_0x015b:
            r0 = 2131230836(0x7f080074, float:1.8077736E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0190
            androidx.fragment.app.FragmentActivity r3 = r10.getActivity()
            android.content.Context r3 = r3.getApplicationContext()
            long r3 = getTotalMemorySize(r3)
            java.lang.String r1 = formatFileSize(r3, r1)
            r0.setText(r1)
            com.szchoiceway.settings.MainActivity r1 = r10.mMain
            java.lang.String r1 = r1.xml_client
            java.lang.String r3 = "als"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0190
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            if (r1 > r3) goto L_0x0190
            r1 = 8
            r0.setVisibility(r1)
        L_0x0190:
            r0 = 2131230840(0x7f080078, float:1.8077744E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x01c3
            java.lang.String r1 = r10.getSerial()
            if (r1 == 0) goto L_0x01c0
            boolean r3 = r2.equals(r1)
            if (r3 != 0) goto L_0x01c0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "A000-"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r3 = "0"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
        L_0x01c0:
            r0.setText(r1)
        L_0x01c3:
            r0 = 2131230822(0x7f080066, float:1.8077708E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x01d9
            com.szchoiceway.settings.SysProviderOpt r1 = r10.mSysProviderOpt
            java.lang.String r3 = "Sys_BT_Moudle_Software_Version"
            java.lang.String r1 = r1.getRecordValue(r3, r2)
            r0.setText(r1)
        L_0x01d9:
            r0 = 2131231053(0x7f08014d, float:1.8078176E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x01e7
            r0.setOnClickListener(r10)
        L_0x01e7:
            r0 = 2131231045(0x7f080145, float:1.807816E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x01f5
            r0.setOnClickListener(r10)
        L_0x01f5:
            r0 = 2131231032(0x7f080138, float:1.8078134E38)
            android.view.View r11 = r11.findViewById(r0)
            if (r11 == 0) goto L_0x0206
            com.szchoiceway.settings.-$$Lambda$FragmentSysInfor$ZrR6ZdnI5qsPjhLlYb4zIh1rM9c r0 = new com.szchoiceway.settings.-$$Lambda$FragmentSysInfor$ZrR6ZdnI5qsPjhLlYb4zIh1rM9c
            r0.<init>()
            r11.setOnClickListener(r0)
        L_0x0206:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szchoiceway.settings.FragmentSysInfor.bindViewListener(android.view.View):void");
    }

    public /* synthetic */ void lambda$bindViewListener$0$FragmentSysInfor(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        Log.d(TAG, "onClick btnReturn main = " + mainActivity);
        if (mainActivity != null) {
            mainActivity.hideID8Content();
        }
    }

    public void NotifyServiceConntected(IEventService iEventService) {
        super.NotifyServiceConntected(iEventService);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(TAG, "onCreate'");
        this.mainActivity = (MainActivity) getActivity();
        this.baseApp = (BaseApp) this.mainActivity.getApplication();
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
        SetMcuVer();
    }

    public void sendBroadcase8902mod() {
        getActivity().getApplicationContext().sendBroadcast(new Intent(EventUtils.ZXW_SENDBROADCAST8902MOD));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnSysReset) {
            Log.i(TAG, "R.id.btnSysReset ***************");
            if (!this.focusUtil.showMCUUpgradeView) {
                this.m_CurrFocus = 1;
                this.baseApp.setFocusPage(1);
                this.mainActivity.m_iCurrFocus = this.m_CurrFocus;
                this.mainActivity.lastXFocus = 8;
                BaseApp.getFocusUtil().locateFragment(this, TAG);
                BaseApp.getFocusUtil().refreshSecondViews(this.mainActivity.m_iCurrFocus, false);
                if (this.m_iUIIndex != 4) {
                    BaseApp.getFocusUtil().refreshFirstViews(this.mainActivity, -1, false);
                }
                MainActivity mainActivity = (MainActivity) getActivity();
                if (mainActivity == null) {
                    mainActivity = getMainActivity();
                }
                if (mainActivity != null) {
                    try {
                        Intent intent = new Intent();
                        intent.addCategory("android.intent.category.LAUNCHER");
                        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$FactoryResetActivity"));
                        intent.setFlags(335544320);
                        mainActivity.startActivityAsUser(intent, UserHandle.CURRENT);
                    } catch (Exception unused) {
                    }
                }
            }
        } else if (id == R.id.btn_mcu_upgrade) {
            Log.d(TAG, "onClick btn_mcu_upgrade focusUtil.showMCUUpgradeView = " + this.focusUtil.showMCUUpgradeView);
            if (!this.focusUtil.showMCUUpgradeView) {
                this.focusUtil.showMCUUpgradeView = true;
                getActivity().startService(new Intent("com.szchoiceway.updatemcu.UpdateMcuService").setPackage("com.szchoiceway.updatemcu"));
                this.m_CurrFocus = 0;
                this.baseApp.setFocusPage(1);
                this.mainActivity.m_iCurrFocus = this.m_CurrFocus;
                this.mainActivity.lastXFocus = 8;
                BaseApp.getFocusUtil().locateFragment(this, TAG);
                BaseApp.getFocusUtil().refreshSecondViews(this.mainActivity.m_iCurrFocus, false);
                if (this.m_iUIIndex != 4) {
                    BaseApp.getFocusUtil().refreshFirstViews(this.mainActivity, -1, false);
                }
                if (view.isSelected()) {
                    view.setSelected(false);
                }
            }
        }
    }

    public static String getAvailableInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (long) statFs.getBlockSize();
        return String.format("%.2f", new Object[]{Float.valueOf(((float) (((long) statFs.getAvailableBlocks()) * blockSize)) / 1.07374182E9f)}) + "G";
    }

    public static String getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        float blockCountLong = ((float) (statFs.getBlockCountLong() * statFs.getBlockSizeLong())) / 1.07374182E9f;
        if (blockCountLong <= 8.0f) {
            blockCountLong = 8.0f;
        } else if (blockCountLong <= 16.0f) {
            blockCountLong = 16.0f;
        } else if (blockCountLong <= 32.0f) {
            blockCountLong = 32.0f;
        } else if (blockCountLong <= 64.0f) {
            blockCountLong = 64.0f;
        } else if (blockCountLong <= 128.0f) {
            blockCountLong = 128.0f;
        } else if (blockCountLong <= 256.0f) {
            blockCountLong = 256.0f;
        } else if (blockCountLong <= 512.0f) {
            blockCountLong = 512.0f;
        } else if (blockCountLong <= 1024.0f) {
            blockCountLong = 1024.0f;
        }
        return String.format("%.2f", new Object[]{Float.valueOf(blockCountLong)}) + "G";
    }

    public static long getTotalMemorySize(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 2048);
            String readLine = bufferedReader.readLine();
            String substring = readLine.substring(readLine.indexOf("MemTotal:"));
            bufferedReader.close();
            return ((long) Integer.parseInt(substring.replaceAll("\\D+", ""))) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long getAvailableMemory(Context context) {
        if (context == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public void SetAppVer(String str) {
        if (this.mainView != null) {
            SysProviderOpt sysProviderOpt = this.mSysProviderOpt;
            String str2 = "";
            String recordValue = sysProviderOpt != null ? sysProviderOpt.getRecordValue(SysProviderOpt.SYS_APP_VERSION) : str2;
            if (str2.equals(recordValue)) {
                recordValue = loadXmlFile().get("AppVersion");
                Log.i(TAG, "initSystemParam: appVersion = " + recordValue);
            }
            Log.i(TAG, "SetAppVer: StrAppver = " + recordValue);
            TextView textView = (TextView) this.mainView.findViewById(R.id.TvAppVer);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            try {
                if (getContext() != null) {
                    SharedPreferences sharedPreferences = getContext().createPackageContext(EventUtils.EVENT_SERVICE_PACKAGE, 2).getSharedPreferences(EventUtils.ZXW_DATABASE_SCREEN_DENSITY_CODE, 4);
                    for (String next : sharedPreferences.getAll().keySet()) {
                        if (next.contains(i + "x" + i2) || next.contains(i + "X" + i2)) {
                            str2 = sharedPreferences.getAll().get(next).toString();
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (textView != null) {
                textView.setText(recordValue + "_" + str2 + "_" + str);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0098, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00b1, code lost:
        r8 = new java.io.FileInputStream("/system/app/" + "customer_1920x720.xml");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2 = new java.io.FileInputStream("/oem/app/customer.xml");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00ba, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r2 = new java.io.FileInputStream("/system/app/customer.xml");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c4, code lost:
        android.util.Log.i(TAG, "loadXmlFile: e = " + r9.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r9 = new java.io.FileInputStream("/oem/app/" + "customer_1920x720.xml");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00b3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x00bc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x007f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.String> loadXmlFile() {
        /*
            r13 = this;
            java.lang.String r0 = "value"
            java.lang.String r1 = "name"
            com.szchoiceway.settings.SysProviderOpt r2 = r13.mSysProviderOpt
            java.lang.String r3 = "RESOLUTION"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.getRecordValue(r3, r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "loadXmlFile: strResolution = "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "FragmentSysInfor"
            android.util.Log.i(r3, r2)
            com.szchoiceway.settings.SysProviderOpt r2 = r13.mSysProviderOpt
            java.lang.String r4 = "KESAIWEI_SYS_MODE_SELECTION"
            r5 = 0
            r2.getRecordInteger(r4, r5)
            java.lang.String r2 = "customer_1920x720.xml"
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            javax.xml.parsers.DocumentBuilderFactory r6 = javax.xml.parsers.DocumentBuilderFactory.newInstance()
            java.lang.String r7 = "test"
            java.lang.String r8 = "start"
            android.util.Log.i(r7, r8)
            r8 = 0
            javax.xml.parsers.DocumentBuilder r6 = r6.newDocumentBuilder()     // Catch:{ ParserConfigurationException -> 0x0046 }
            goto L_0x0065
        L_0x0046:
            r6 = move-exception
            r6.printStackTrace()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "err=="
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r6 = r9.append(r6)
            java.lang.String r6 = r6.toString()
            android.util.Log.i(r7, r6)
            r6 = r8
        L_0x0065:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x007f }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x007f }
            r10.<init>()     // Catch:{ FileNotFoundException -> 0x007f }
            java.lang.String r11 = "/odm/app/"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ FileNotFoundException -> 0x007f }
            java.lang.StringBuilder r10 = r10.append(r2)     // Catch:{ FileNotFoundException -> 0x007f }
            java.lang.String r10 = r10.toString()     // Catch:{ FileNotFoundException -> 0x007f }
            r9.<init>(r10)     // Catch:{ FileNotFoundException -> 0x007f }
        L_0x007d:
            r8 = r9
            goto L_0x00de
        L_0x007f:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0098 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0098 }
            r10.<init>()     // Catch:{ FileNotFoundException -> 0x0098 }
            java.lang.String r11 = "/oem/app/"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ FileNotFoundException -> 0x0098 }
            java.lang.StringBuilder r10 = r10.append(r2)     // Catch:{ FileNotFoundException -> 0x0098 }
            java.lang.String r10 = r10.toString()     // Catch:{ FileNotFoundException -> 0x0098 }
            r9.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0098 }
            goto L_0x007d
        L_0x0098:
            r9 = move-exception
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00b3 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00b3 }
            r11.<init>()     // Catch:{ FileNotFoundException -> 0x00b3 }
            java.lang.String r12 = "/system/app/"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ FileNotFoundException -> 0x00b3 }
            java.lang.StringBuilder r2 = r11.append(r2)     // Catch:{ FileNotFoundException -> 0x00b3 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x00b3 }
            r10.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00b3 }
            r8 = r10
            goto L_0x00de
        L_0x00b3:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00bc }
            java.lang.String r10 = "/oem/app/customer.xml"
            r2.<init>(r10)     // Catch:{ FileNotFoundException -> 0x00bc }
        L_0x00ba:
            r8 = r2
            goto L_0x00de
        L_0x00bc:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00c4 }
            java.lang.String r10 = "/system/app/customer.xml"
            r2.<init>(r10)     // Catch:{ FileNotFoundException -> 0x00c4 }
            goto L_0x00ba
        L_0x00c4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r10 = "loadXmlFile: e = "
            java.lang.StringBuilder r2 = r2.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r3, r2)
        L_0x00de:
            if (r8 == 0) goto L_0x0192
            if (r6 == 0) goto L_0x0192
            org.w3c.dom.Document r2 = r6.parse(r8)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r3 = "customer"
            org.w3c.dom.NodeList r2 = r2.getElementsByTagName(r3)     // Catch:{ Exception -> 0x0174 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0174 }
            r3.<init>()     // Catch:{ Exception -> 0x0174 }
            java.lang.String r6 = "customer list.getLength() = "
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ Exception -> 0x0174 }
            int r6 = r2.getLength()     // Catch:{ Exception -> 0x0174 }
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0174 }
            android.util.Log.i(r7, r3)     // Catch:{ Exception -> 0x0174 }
            int r3 = r2.getLength()     // Catch:{ Exception -> 0x0174 }
            if (r3 <= 0) goto L_0x0192
            org.w3c.dom.Node r2 = r2.item(r5)     // Catch:{ Exception -> 0x0174 }
            org.w3c.dom.Element r2 = (org.w3c.dom.Element) r2     // Catch:{ Exception -> 0x0174 }
            java.lang.String r3 = "item"
            org.w3c.dom.NodeList r2 = r2.getElementsByTagName(r3)     // Catch:{ Exception -> 0x0174 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0174 }
            r3.<init>()     // Catch:{ Exception -> 0x0174 }
            java.lang.String r6 = "item list.getLength() = "
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ Exception -> 0x0174 }
            int r6 = r2.getLength()     // Catch:{ Exception -> 0x0174 }
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0174 }
            android.util.Log.i(r7, r3)     // Catch:{ Exception -> 0x0174 }
        L_0x0132:
            int r3 = r2.getLength()     // Catch:{ Exception -> 0x0174 }
            if (r5 >= r3) goto L_0x0192
            org.w3c.dom.Node r3 = r2.item(r5)     // Catch:{ Exception -> 0x0174 }
            org.w3c.dom.Element r3 = (org.w3c.dom.Element) r3     // Catch:{ Exception -> 0x0174 }
            java.lang.String r6 = r3.getAttribute(r1)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r9 = r3.getAttribute(r0)     // Catch:{ Exception -> 0x0174 }
            r4.put(r6, r9)     // Catch:{ Exception -> 0x0174 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0174 }
            r6.<init>()     // Catch:{ Exception -> 0x0174 }
            java.lang.String r9 = "name ="
            java.lang.StringBuilder r6 = r6.append(r9)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r9 = r3.getAttribute(r1)     // Catch:{ Exception -> 0x0174 }
            java.lang.StringBuilder r6 = r6.append(r9)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r9 = " value="
            java.lang.StringBuilder r6 = r6.append(r9)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r3 = r3.getAttribute(r0)     // Catch:{ Exception -> 0x0174 }
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0174 }
            android.util.Log.i(r7, r3)     // Catch:{ Exception -> 0x0174 }
            int r5 = r5 + 1
            goto L_0x0132
        L_0x0174:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "errSAXException=="
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r7, r0)
        L_0x0192:
            if (r8 == 0) goto L_0x019c
            r8.close()     // Catch:{ IOException -> 0x0198 }
            goto L_0x019c
        L_0x0198:
            r0 = move-exception
            r0.printStackTrace()
        L_0x019c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szchoiceway.settings.FragmentSysInfor.loadXmlFile():java.util.Map");
    }

    public void SetMcuVer() {
        String str;
        TextView textView;
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        IEventService iEventService = null;
        if (mainActivity != null) {
            iEventService = mainActivity.getService();
        }
        if (iEventService != null) {
            try {
                str = iEventService.getMCUVer();
            } catch (RemoteException e) {
                e.printStackTrace();
                str = "";
            }
            View view = this.mainView;
            if (view != null && (textView = (TextView) view.findViewById(R.id.TvMCUVer)) != null) {
                if (str == null || str.length() <= 0) {
                    textView.setText("null");
                } else {
                    textView.setText(str);
                }
            }
        } else {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(1);
                this.mHandler.sendEmptyMessageDelayed(1, 500);
            }
        }
    }

    private String getSerial() {
        Log.i("get", "getNandFlashIDToUSBStorage:");
        String str = null;
        try {
            byte[] bArr = new byte[50];
            int read = new FileInputStream(NF_SERIAL_PATH).read(bArr);
            Log.i("get", "inStream.read(buffer):" + read);
            if (read > 0) {
                byte[] bArr2 = new byte[read];
                for (int i = 0; i < read; i++) {
                    bArr2[i] = bArr[i];
                    Log.i("", "byte[" + i + "] = 0x" + Integer.toHexString(bArr[i] & UByte.MAX_VALUE));
                }
                String str2 = new String(bArr2);
                Log.d("get", "strID:" + str2);
                str = str2;
            }
        } catch (Exception e) {
            Log.i("", "getNandFlashIDToUSBStorage error " + e.toString());
        }
        return str == null ? "NULL" : str;
    }

    private String getBasebandVer() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{"gsm.version.baseband", ""});
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private class SysInforReceiver extends BroadcastReceiver {
        private SysInforReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (EventUtils.ZXW_CAN_VER_CHANGE.equals(intent.getAction())) {
                Log.i(FragmentSysInfor.TAG, "onReceive: ZXW_CAN_VER_CHANGE");
                FragmentSysInfor.this.SetMcuVer();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EventUtils.ZXW_CAN_VER_CHANGE);
        getActivity().registerReceiver(this.mModel, intentFilter);
    }

    public void unregisterReceiver() {
        getActivity().unregisterReceiver(this.mModel);
    }

    class Handler_KSW extends Handler {
        Handler_KSW() {
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                FragmentSysInfor.this.SetMcuVer();
            }
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        this.focusViews.add(Integer.valueOf(R.id.btn_mcu_upgrade));
        this.focusViews.add(Integer.valueOf(R.id.btnSysReset));
        this.focusUtil.addViewIds(this.focusViews);
    }
}
