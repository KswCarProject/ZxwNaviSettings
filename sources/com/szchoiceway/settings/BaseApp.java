package com.szchoiceway.settings;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import com.szchoiceway.eventcenter.CrashHandler;
import com.szchoiceway.settings.util.FocusUtil;
import com.szchoiceway.zxwlib.bean.Customer;
import com.szchoiceway.zxwlib.utils.MultipleUtils;

public class BaseApp extends Application {
    private static final String TAG = "BaseApp";
    public static int focusPage = 0;
    private static FocusUtil focusUtil = null;
    public static boolean isSmallResolution = false;
    public static int mProductIndex = 0;
    public static String mResolution = "1920x720";
    public static int m_iModeSet = 17;
    public static int m_iUIIndex = 0;
    public static int m_iUITypeVer = 41;
    private boolean hasFocusChange = false;

    public void onCreate() {
        super.onCreate();
        MultipleUtils.setCustomDensity((Activity) null, this);
        isSmallResolution = Customer.isSmallResolution(this);
        m_iModeSet = SysProviderOpt.getInstance(this).getRecordInteger("KESAIWEI_SYS_MODE_SELECTION", m_iModeSet);
        m_iUITypeVer = SysProviderOpt.getInstance(this).getRecordInteger("Set_User_UI_Type", m_iUITypeVer);
        mResolution = SysProviderOpt.getInstance(this).getRecordValue("KSW_UI_RESOLUTION", "1920x720");
        m_iUIIndex = Customer.getUIIndex(getApplicationContext());
        mProductIndex = SysProviderOpt.getInstance(this).getRecordInteger(SysProviderOpt.KSW_DATA_PRODUCT_INDEX, mProductIndex);
        focusUtil = new FocusUtil(m_iModeSet, m_iUIIndex);
        CrashHandler.getInstance().init(this);
    }

    public boolean getHasFocusChange() {
        return this.hasFocusChange;
    }

    public void setHasFocusChange(boolean z) {
        this.hasFocusChange = z;
    }

    public void setFocusPage(int i) {
        Log.d(TAG, "setFocusPage focusPage = " + i);
        focusPage = i;
    }

    public int getFocusPage() {
        return focusPage;
    }

    public static FocusUtil getFocusUtil() {
        return focusUtil;
    }
}
