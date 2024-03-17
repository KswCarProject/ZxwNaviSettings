package com.szchoiceway.settings;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;

public class SysProviderOpt {
    public static final String ADO_LastLoopMode_KEY = "Ado_LastLoopMode";
    public static final String ADO_LastLrcMode_KEY = "Ado_LastLrcMode";
    public static final String ADO_LastPlayFilePath_KEY = "Ado_LastPlayFilePath";
    public static final String ADO_LastPlayFilePos_KEY = "Ado_LastPlayFilePos";
    public static final String ADO_LastPlayFileSize_KEY = "Ado_LastPlayFileSize";
    public static final String ADO_StorageType_KEY = "Ado_StorageType";
    public static final String BT_AutoAnswer_KEY = "BT_AutoAnswer";
    public static final String CHEKU_SHOW_RADAR_P = "CHEKU_SHOW_RADAR_P";
    private static final String CONTENT_NAME = "content://com.szchoiceway.eventcenter.SysVarProvider/SysVar";
    public static final String KESAIWEI_DISPLAY_MODE_CHANGED_ACTION = "KESAIWEI_DISPLAY_MODE_CHANGED_ACTION";
    public static final String KESAIWEI_RECORD_AUX_SWITCHING = "KESAIWEI_RECORD_AUX_SWITCHING";
    public static final String KESAIWEI_RECORD_BT_CONNECT_MENU = "KESAIWEI_RECORD_BT_CONNECT_MENU";
    public static final String KESAIWEI_RECORD_BT_INDEX = "KESAIWEI_RECORD_BT_INDEX";
    public static final String KESAIWEI_RECORD_BT_OFF = "KESAIWEI_RECORD_BT_OFF";
    public static final String KESAIWEI_RECORD_DVR = "KESAIWEI_RECORD_DVR";
    public static final String KESAIWEI_SYS_ANDROID_IS_24_HOUR = "KESAIWEI_SYS_ANDROID_IS_24_HOUR";
    public static final String KESAIWEI_SYS_BACKCAR_MIRROR = "KESAIWEI_SYS_BACKCAR_MIRROR";
    public static final String KESAIWEI_SYS_BACKCAR_PAUSE_PLAY = "KESAIWEI_SYS_BACKCAR_PAUSE_PLAY";
    public static final String KESAIWEI_SYS_CAMERA_SELECTION = "KESAIWEI_SYS_CAMERA_SELECTION";
    public static final String KESAIWEI_SYS_DISPLAY_MODE = "KESAIWEI_SYS_DISPLAY_MODE";
    public static final String KESAIWEI_SYS_DVD_SELECTION = "KESAIWEI_SYS_DVD_SELECTION";
    public static final String KESAIWEI_SYS_FRONT_CAMERA = "KESAIWEI_SYS_FRONT_CAMERA";
    public static final String KESAIWEI_SYS_FRONT_MIRROR = "KESAIWEI_SYS_FRONT_MIRROR";
    public static final String KESAIWEI_SYS_LANGUAGE = "KESAIWEI_SYS_LANGUAGE";
    public static final String KESAIWEI_SYS_MODE_SELECTION = "KESAIWEI_SYS_MODE_SELECTION";
    public static final String KESAIWEI_SYS_ORIGINAL_IS_24_HOUR = "KESAIWEI_SYS_IS_24_HOUR";
    public static final String KESAIWEI_SYS_RADAR = "KESAIWEI_SYS_RADAR";
    public static final String KESAIWEI_SYS_REVERSING_TRACK = "KESAIWEI_SYS_REVERSING_TRACK";
    public static final String KESAIWEI_SYS_SD_HOST = "KESAIWEI_SYS_SD_HOST";
    public static final String KESAIWEI_SYS_USER_TIME_TYPE = "KESAIWEI_SYS_USER_TIME_TYPE";
    public static final String KESAIWEI_SYS_VIDEO_DRIVING_BAN = "KESAIWEI_SYS_VIDEO_DRIVING_BAN";
    public static final String KEY_XINGSHUO_FORWARD_VIEW = "KEY_XINGSHUO_FORWARD_VIEW";
    public static final String KEY_XINGSHUO_FORWARD_VIEW_MIRROR = "KEY_XINGSHUO_FORWARD_VIEW_MIRROR";
    public static final String KEY_XINGSHUO_RIGHT_VIEW = "KEY_XINGSHUO_RIGHT_VIEW";
    public static final String KSE_TXZ_WARING_VALUE_OIL = "KSE_TXZ_WARING_VALUE_OIL";
    public static final String KSE_TXZ_WARING_VALUE_SPEED = "KSE_TXZ_WARING_VALUE_SPEED";
    public static final String KSW_ACTION_ID8_SHOW_APP_LIST_BY_SETTINGS = "KSW_ACTION_ID8_SHOW_APP_LIST_BY_SETTINGS";
    public static final String KSW_AHD_CAMERA_TYPE = "KSW_AHD_CAMERA_TYPE";
    public static final String KSW_ANDROID_CAMERA_TYPE = "KSW_ANDROID_CAMERA_TYPE";
    public static final String KSW_AUX_ITEM_POSITION = "KSW_AUX_ITEM_POSITION";
    public static final String KSW_AUX_ITEM_POSITION2 = "KSW_AUX_ITEM_POSITION2";
    public static final String KSW_BACKLIGHT_CONTROL_INDEX = "KSW_BACKLIGHT_CONTROL_INDEX";
    public static final String KSW_BOOT_MODE_MEMORY_INDEX = "KSW_BOOT_MODE_MEMORY_INDEX";
    public static final String KSW_COLLECT_CAN_DATA_SWITCH_INDEX = "KSW_COLLECT_CAN_DATA_SWITCH_INDEX";
    public static final String KSW_DATA_CUSTOMER_RESOLUTION = "KSW_DATA_CUSTOMER_RESOLUTION";
    public static final String KSW_DATA_PRODUCT_INDEX = "KSW_DATA_PRODUCT_INDEX";
    public static final String KSW_DISTACNE_UNIT = "KSW_DISTACNE_UNIT";
    public static final String KSW_DVR_APK_PACKAGENAME = "KSW_DVR_APK_PACKAGENAME";
    public static final String KSW_FACTORY_SET_CLIENT = "KSW_FACTORY_SET_CLIENT";
    public static final String KSW_FACTORY_SET_CLIENT_ALS_TEST = "KSW_FACTORY_SET_CLIENT_ALS_TEST";
    public static final String KSW_FACTORY_SET_PASSWORD = "KSW_FACTORY_SET_PASSWORD";
    public static final String KSW_LANDROVER_THEME_BACKGROUND_INDEX = "KSW_LANDROVER_THEME_BACKGROUND_INDEX";
    public static final String KSW_OIL_UNIT = "KSW_OIL_UNIT";
    public static final String KSW_REVEERSING_MUTE_SELECT_INDEX = "KSW_REVEERSING_MUTE_SELECT_INDEX";
    public static final String KSW_TEMP_UNIT = "KSW_TEMP_UNIT";
    public static final String KSW_UI_RESOLUTION = "KSW_UI_RESOLUTION";
    public static final String MAIRUIWEI_BACKCAR_CONTROL = "MAIRUIWEI_BACKCAR_CONTROL";
    public static final String MAIRUIWEI_BACKCAR_RADAR = "MAIRUIWEI_BACKCAR_RADAR";
    public static final String MAIRUIWEI_BACKCAR_TRACK = "MAIRUIWEI_BACKCAR_TRACK";
    public static final String MAIRUIWEI_CAMERA_SELECT = "MAIRUIWEI_CAMERA_SELECT";
    public static final String MAIRUIWEI_DTV_CHANNEL_SELECT = "MAIRUIWEI_DTV_CHANNEL_SELECT";
    public static final String MAISILUO_SYS_GOOGLEPLAY = "MAISILUO_SYS_GOOGLEPLAY";
    public static final String MUSIC_ACTIVITYNAME = "Music_ActivityName";
    public static final String MUSIC_PACKAGENAME = "Music_PackageName";
    public static final String NAV_ACTIVITYNAME = "NAV_ACTIVITYNAME";
    public static final String NAV_PACKAGENAME = "NAV_PACKAGENAME";
    public static final String RESOLUTION = "RESOLUTION";
    public static final String SAILOR_T001_WALLPAPER = "SAILOR_T001_WALLPAPER";
    public static final String SET_AUTO_RUN_GPS_KEY = "Set_AutoRunGPS";
    public static final String SET_BACKGROUND_INDEX = "Set_BackgroundIndex";
    public static final String SET_BACK_RADAR_BEHIND_ONOFF_KEY = "Set_BackRadarBehindOnOff";
    public static final String SET_BACK_RADAR_HEAD_ONOFF_KEY = "Set_BackRadarHeadOnOff";
    public static final String SET_BACK_TRACK_KEY = "Set_BackTrack";
    public static final String SET_BAL_FA_KEY = "Set_BalanaceFA";
    public static final String SET_BAL_LR_KEY = "Set_BalanaceLR";
    public static final String SET_BASS_FREQ_KEY = "Set_Bass_Freq";
    public static final String SET_BASS_KEY = "Set_Bass_Val";
    public static final String SET_BRAKE_DETECT_KEY = "Set_BrakeDetection";
    public static final String SET_Canbustype_KEY = "Set_Canbustype";
    public static final String SET_CarCanbusName_ID_KEY = "Set_CarCanbusName_ID";
    public static final String SET_Carstype_ID_KEY = "Set_Carstype_ID";
    public static final String SET_DAY_LIGHT_KEY = "Set_Day_Light";
    public static final String SET_EQMODE_KEY = "Set_Eq_Mode";
    public static final String SET_LOCAL_NAV_KEY = "Set_LocalNavi";
    public static final String SET_LOUDNESS_KEY = "Set_Loudness";
    public static final String SET_MIDDLE_FREQ_KEY = "Set_Middle_Freq";
    public static final String SET_MIDDLE_KEY = "Set_Middle_Val";
    public static final String SET_NIGHT_LIGHT_KEY = "Set_Night_Light";
    public static final String SET_NavClassName_KEY = "Set_NavClassName";
    public static final String SET_NavPackageName_KEY = "Set_NavPackageName";
    public static final String SET_NavSoundVolume_KEY = "Set_NavSoundVolume";
    public static final String SET_RIGHT_SIGN_DETECT_KEY = "Set_RightSignDetect";
    public static final String SET_SUBWOOFER_KEY = "Set_Subwoofer";
    public static final String SET_TOUCH_BEEP_KEY = "Set_TouchBeep";
    public static final String SET_TREBLE_FREQ_KEY = "Set_Treble_Freq";
    public static final String SET_TREBLE_KEY = "Set_Treble_Val";
    public static final String SET_USER_BASS_KEY = "Set_User_Bass";
    public static final String SET_USER_MIDDLE_KEY = "Set_User_Middle";
    public static final String SET_USER_TREBLE_KEY = "Set_User_Treble";
    public static final String SET_USER_UI_TYPE = "Set_User_UI_Type";
    public static final String SYS_8825_UI_NUM_KEY = "Sys_8825UINumber";
    public static final String SYS_APP_VERSION = "Sys_AppVersion";
    public static final String SYS_ASSISTIVE_TOUCH = "SYS_Assistive_Touch";
    public static final String SYS_BACKCAR_AID = "Sys_Backcar_aid";
    public static final String SYS_BACKCAR_SND = "Sys_BackCar_Snd";
    public static final String SYS_BAMBIENT_LIGHT = "Sys_AmbientLight_on_off";
    public static final String SYS_BT_MOUDLE_VERSION = "Sys_BT_Moudle_Software_Version";
    public static final String SYS_BT_TYPE_KEY = "Sys_BTDeviceType";
    public static final String SYS_CAR_TYPE_KEY = "Sys_CarType";
    public static final String SYS_GPSVOL_VAL = "Sys_GpsVol_Val";
    public static final String SYS_LANDSCAPE_KEY = "Sys_Landscape";
    public static final String SYS_LAST_MODE_KEY = "Sys_Last_Mode";
    public static final String SYS_LEDCOLOR_SET_KEY = "SYS_LEDColor_Set";
    public static final String SYS_LOUND = "SYS_LOUD_DTATE";
    public static final String SYS_MCU_SET_KEY = "Sys_McuSet";
    public static final String SYS_MIC_GAIN_PARAM = "SYS_MIC_GAIN_PARAM";
    public static final String SYS_RDS_ONOFF_KEY = "SYS_RDS_OnOff";
    public static final String SYS_REVERSE_IMAGE = "Sys_ReverseImage";
    public static final String SYS_SETDEFAULT_WALLPAPER = "SYS_SETDEFAULT_WALLPAPER";
    public static final String SYS_SLEEP_SWITCH = "SYS_SLEEP_SWITCH";
    public static final String SYS_TOUCH_ORGIN_KEY = "Sys_TouchOrgin";
    public static final String SYS_UI_NUMBER_KEY = "Sys_UINumber";
    public static final String SYS_WHEEL_TRACK = "Sys_Wheel_Track";
    public static final String SYS_WND_IN_TOP = "Sys_Wnd_In_Top";
    public static final String SYS_ZHTY_UI_SELECT = "SYS_ZHTY_UI_SELECT";
    private static final String TAG = "SysProviderOpt";
    public static final int UI_ANCHANGXING = 2;
    public static final int UI_AOCHEKAI = 32;
    public static final int UI_BORUIZENGHENG = 36;
    public static final int UI_CHEKU_1280X480 = 44;
    public static final int UI_CHWY_1280X480 = 48;
    public static final int UI_HANGFEI_1280X480 = 38;
    public static final int UI_HUANGRUN_800X4800 = 35;
    public static final int UI_KANGHUI_800X480 = 43;
    public static final int UI_KESAIWEI_1280X480 = 41;
    public static final int UI_KESHANG = 1;
    public static final int UI_KESHANG_1280X480 = 40;
    public static final int UI_MAIRUIWEI_800x480 = 45;
    public static final int UI_MAISILUO_1280X480 = 37;
    public static final int UI_NORMAL = 0;
    public static final int UI_NORMAL_1920x720 = 101;
    public static final int UI_PUSIRUI = 3;
    public static final int UI_XINGSHUO_800X480 = 42;
    public static final int UI_ZHONGHANGTIANYI_800x480 = 39;
    public static final String VDO_LastLoopMode_KEY = "Vdo_LastLoopMode";
    public static final String VDO_LastPlayFilePath_KEY = "Vdo_LastPlayFilePath";
    public static final String VDO_LastPlayFilePos_KEY = "Vdo_LastPlayFilePos";
    public static final String VDO_LastPlayFileSize_KEY = "Vdo_LastPlayFileSize";
    public static final String VDO_StorageType_KEY = "Vdo_StorageType";
    public static final String VIDEO_ACTIVITYNAME = "Video_ActivityName";
    public static final String VIDEO_PACKAGENAME = "Video_PackageName";
    public static final String ZHTY_TXZ_VOICE_ICON_SHOW = "ZXW_TXZ_VOICE_ICON_CONTROL";
    public static final String ZXW_CAN_VERSION = "com.szchoiceway.eventcenter.ZXW_CAN_VERSION";
    public static final String ZXW_CHEKU_SMALL_GPS_OR_WEATHER_PAGE = "ZXW_CHEKU_SMALL_GPS_OR_WEATHER_PAGE";
    private static SysProviderOpt mSysProviderOpt;
    private ContentResolver mCntResolver;
    private Context mContext;
    private Uri mUri = Uri.parse(CONTENT_NAME);

    public SysProviderOpt(Context context) {
        this.mCntResolver = context.getContentResolver();
    }

    public static SysProviderOpt getInstance(Context context) {
        if (mSysProviderOpt == null) {
            synchronized (SysProviderOpt.class) {
                if (mSysProviderOpt == null) {
                    mSysProviderOpt = new SysProviderOpt(context);
                }
            }
        }
        return mSysProviderOpt;
    }

    public Uri insertRecord(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("keyname", str);
        contentValues.put("keyvalue", str2);
        try {
            return this.mCntResolver.insert(this.mUri, contentValues);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public String getRecordValue(String str) {
        return getRecordValue(str, "");
    }

    public String getRecordValue(String str, String str2) {
        String str3 = "";
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            Cursor query = this.mCntResolver.query(this.mUri, (String[]) null, "keyname=?", strArr, (String) null);
            if (query != null && query.getCount() > 0 && query.moveToNext()) {
                str3 = query.getString(query.getColumnIndex("keyvalue"));
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
            Log.e(TAG, e.toString());
        }
        return str3;
    }

    public int getRecordInteger(String str, int i) {
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            Cursor query = this.mCntResolver.query(this.mUri, (String[]) null, "keyname=?", strArr, (String) null);
            if (query != null && query.getCount() > 0 && query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("keyvalue"));
                if (string.length() > 0) {
                    i = Integer.valueOf(string).intValue();
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
            Log.e(TAG, e.toString());
        }
        return i;
    }

    public long getRecordLong(String str, long j) {
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            Cursor query = this.mCntResolver.query(this.mUri, (String[]) null, "keyname=?", strArr, (String) null);
            if (query != null && query.getCount() > 0 && query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("keyvalue"));
                if (string.length() > 0) {
                    j = Long.valueOf(string).longValue();
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
            Log.e(TAG, e.toString());
        }
        return j;
    }

    public float getRecordFloat(String str, float f) {
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            Cursor query = this.mCntResolver.query(this.mUri, (String[]) null, "keyname=?", strArr, (String) null);
            if (query != null && query.getCount() > 0 && query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("keyvalue"));
                if (string.length() > 0) {
                    f = Float.valueOf(string).floatValue();
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
            Log.e(TAG, e.toString());
        }
        return f;
    }

    public boolean getRecordBoolean(String str, boolean z) {
        boolean z2 = true;
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            Cursor query = this.mCntResolver.query(this.mUri, (String[]) null, "keyname=?", strArr, (String) null);
            if (query != null && query.getCount() > 0 && query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("keyvalue"));
                if (string.length() > 0) {
                    if (Integer.valueOf(string).intValue() != 1) {
                        z2 = false;
                    }
                    z = z2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
            Log.e(TAG, e.toString());
        }
        return z;
    }

    public byte getRecordByte(String str, byte b) {
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            Cursor query = this.mCntResolver.query(this.mUri, (String[]) null, "keyname=?", strArr, (String) null);
            if (query != null && query.getCount() > 0 && query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("keyvalue"));
                if (string.length() > 0) {
                    b = Byte.valueOf(string).byteValue();
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
            Log.e(TAG, e.toString());
        }
        return b;
    }

    public double getRecordDouble(String str, double d) {
        String recordValue = getRecordValue(str, "");
        return recordValue.length() > 0 ? Double.valueOf(recordValue).doubleValue() : d;
    }

    public void updateRecord(String str, String str2) {
        updateRecord(str, str2, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[SYNTHETIC, Splitter:B:20:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateRecord(java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            r10 = this;
            java.lang.String r6 = "keyname=?"
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]
            r0 = 0
            r7[r0] = r11
            java.lang.String r8 = "keyvalue"
            java.lang.String[] r2 = new java.lang.String[]{r8}
            r9 = 0
            android.content.ContentResolver r0 = r10.mCntResolver     // Catch:{ Exception -> 0x0048 }
            android.net.Uri r1 = r10.mUri     // Catch:{ Exception -> 0x0048 }
            r5 = 0
            r3 = r6
            r4 = r7
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0048 }
            if (r0 == 0) goto L_0x003c
            int r1 = r0.getCount()     // Catch:{ Exception -> 0x0039 }
            if (r1 <= 0) goto L_0x003c
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ Exception -> 0x0039 }
            r11.<init>()     // Catch:{ Exception -> 0x0039 }
            r11.put(r8, r12)     // Catch:{ Exception -> 0x0039 }
            if (r0 == 0) goto L_0x0030
            r0.close()     // Catch:{ Exception -> 0x0039 }
            goto L_0x0031
        L_0x0030:
            r9 = r0
        L_0x0031:
            android.content.ContentResolver r12 = r10.mCntResolver     // Catch:{ Exception -> 0x0048 }
            android.net.Uri r13 = r10.mUri     // Catch:{ Exception -> 0x0048 }
            r12.update(r13, r11, r6, r7)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0042
        L_0x0039:
            r11 = move-exception
            r9 = r0
            goto L_0x0049
        L_0x003c:
            if (r13 == 0) goto L_0x0041
            r10.insertRecord(r11, r12)     // Catch:{ Exception -> 0x0039 }
        L_0x0041:
            r9 = r0
        L_0x0042:
            if (r9 == 0) goto L_0x0057
            r9.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x0057
        L_0x0048:
            r11 = move-exception
        L_0x0049:
            if (r9 == 0) goto L_0x004e
            r9.close()
        L_0x004e:
            java.lang.String r11 = r11.toString()
            java.lang.String r12 = "SysProviderOpt"
            android.util.Log.e(r12, r11)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szchoiceway.settings.SysProviderOpt.updateRecord(java.lang.String, java.lang.String, boolean):void");
    }

    public void setRecordDefaultValue(String str, String str2) {
        if (!checkRecordExist(str)) {
            insertRecord(str, str2);
        }
    }

    public boolean checkRecordExist(String str) {
        boolean z = true;
        boolean z2 = false;
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            cursor = this.mCntResolver.query(this.mUri, new String[]{"keyvalue"}, "keyname=?", strArr, (String) null);
            if (cursor == null || cursor.getCount() <= 0) {
                z = false;
            }
            if (cursor == null) {
                return z;
            }
            try {
                cursor.close();
                return z;
            } catch (Exception e) {
                e = e;
                z2 = z;
            }
        } catch (Exception e2) {
            e = e2;
            if (cursor != null) {
                cursor.close();
            }
            Log.e(TAG, e.toString());
            return z2;
        }
    }

    public ArrayList<String> queryRecordItemName() {
        new String[]{""};
        String[] strArr = {"keyname"};
        ArrayList<String> arrayList = new ArrayList<>(100);
        Cursor cursor = null;
        try {
            Cursor query = this.mCntResolver.query(this.mUri, strArr, (String) null, (String[]) null, (String) null);
            int count = query.getCount();
            query.getColumnIndex("keyname");
            query.moveToFirst();
            if (query != null && count > 0) {
                for (int i = 0; i < count; i++) {
                    arrayList.add(query.getString(0));
                    query.moveToNext();
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
            Log.e(TAG, e.toString());
        }
        return arrayList;
    }
}
