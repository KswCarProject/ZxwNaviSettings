package com.szchoiceway.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.settings.bean.AppInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AppUtil {
    private static final String TAG = "AppUtil";
    private List<AppInfo> appInfoList;
    private List<String> dvrApkList;
    private Context mContext;
    private int mType = 0;
    private List<String> mapApkList;

    public AppUtil(Context context, int i) {
        this.mContext = context;
        this.mType = i;
        initAppList(context);
    }

    public void initAppList(Context context) {
        int i;
        int i2;
        initMapApkList();
        initDvrList();
        this.appInfoList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager packageManager = context.getPackageManager();
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 0).iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            String str = next.activityInfo.packageName;
            if (this.mapApkList.size() <= 0 || (!((i2 = this.mType) == 1 || i2 == 2) || (!this.mapApkList.contains(str) && !this.dvrApkList.contains(str)))) {
                try {
                    PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(str, 0);
                    AppInfo appInfo = new AppInfo();
                    if ((packageInfo.applicationInfo.flags & 1) > 0) {
                        if (this.mType == 1 && str.equals(EventUtils.MUSIC_MODE_PACKAGE_NAME)) {
                            appInfo.setLabel(next.loadLabel(this.mContext.getPackageManager()).toString());
                            appInfo.setPackageName(next.activityInfo.packageName);
                            appInfo.setClassName(next.activityInfo.name);
                            appInfo.setIcon(packageManager.getApplicationIcon(next.activityInfo.packageName));
                            if (!(appInfo.getLabel() == null && appInfo.getClassName() == null && appInfo.getPackageName() == null)) {
                                this.appInfoList.add(appInfo);
                            }
                        }
                        if (this.mType == 2 && str.equals("com.szchoiceway.videoplayer")) {
                            appInfo.setLabel(next.loadLabel(this.mContext.getPackageManager()).toString());
                            appInfo.setPackageName(next.activityInfo.packageName);
                            appInfo.setClassName(next.activityInfo.name);
                            appInfo.setIcon(packageManager.getApplicationIcon(next.activityInfo.packageName));
                            if (!(appInfo.getLabel() == null && appInfo.getClassName() == null && appInfo.getPackageName() == null)) {
                                this.appInfoList.add(appInfo);
                            }
                        }
                        String language = Locale.getDefault().getLanguage();
                        String country = Locale.getDefault().getCountry();
                        if (!language.equals("zh") || !country.equals("CN")) {
                            z = false;
                        }
                        if (com.szchoiceway.zxwlib.utils.EventUtils.GOOGLE_MAP_MODE_PACKAGE_NAME.equals(next.activityInfo.packageName) && com.szchoiceway.zxwlib.utils.EventUtils.GOOGLE_MAP_MODE_CLASS_NAME.equals(next.activityInfo.name) && !z) {
                            appInfo.setLabel(next.loadLabel(this.mContext.getPackageManager()).toString());
                            appInfo.setPackageName(next.activityInfo.packageName);
                            appInfo.setClassName(next.activityInfo.name);
                            appInfo.setIcon(packageManager.getApplicationIcon(next.activityInfo.packageName));
                            this.appInfoList.add(appInfo);
                        }
                    } else {
                        appInfo.setLabel(next.loadLabel(this.mContext.getPackageManager()).toString());
                        appInfo.setPackageName(next.activityInfo.packageName);
                        appInfo.setClassName(next.activityInfo.name);
                        appInfo.setIcon(packageManager.getApplicationIcon(next.activityInfo.packageName));
                        if (appInfo.getLabel() != null || appInfo.getClassName() != null || appInfo.getPackageName() != null) {
                            this.appInfoList.add(appInfo);
                        }
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mType == 1) {
            i = 0;
            for (int i3 = 0; i3 < this.appInfoList.size(); i3++) {
                if (EventUtils.MUSIC_MODE_PACKAGE_NAME.equals(this.appInfoList.get(i3).getPackageName())) {
                    i = i3;
                }
            }
            Collections.swap(this.appInfoList, 0, i);
        } else {
            i = 0;
        }
        if (this.mType == 2) {
            for (int i4 = 0; i4 < this.appInfoList.size(); i4++) {
                if ("com.szchoiceway.videoplayer".equals(this.appInfoList.get(i4).getPackageName())) {
                    i = i4;
                }
            }
            Collections.swap(this.appInfoList, 0, i);
        }
    }

    private void initMapApkList() {
        if (this.mContext != null) {
            this.mapApkList = new ArrayList();
            try {
                SharedPreferences sharedPreferences = this.mContext.createPackageContext(EventUtils.EVENT_SERVICE_PACKAGE, 2).getSharedPreferences(EventUtils.ZXW_DATABASE_NAVI_LIST_FILENAME, 4);
                if (sharedPreferences.getAll().size() > 0) {
                    this.mapApkList.addAll(sharedPreferences.getAll().keySet());
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void initDvrList() {
        if (this.mContext != null) {
            this.dvrApkList = new ArrayList();
            try {
                SharedPreferences sharedPreferences = this.mContext.createPackageContext(EventUtils.EVENT_SERVICE_PACKAGE, 2).getSharedPreferences(EventUtils.ZXW_DATABASE_DVR_LIST_FILENAME, 4);
                if (sharedPreferences.getAll().size() > 0) {
                    this.dvrApkList.addAll(sharedPreferences.getAll().keySet());
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public List<AppInfo> getAppList() {
        return this.appInfoList;
    }
}
