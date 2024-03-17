package com.szchoiceway.settings.util;

import android.graphics.Color;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.FragmentNavSetNew;
import com.szchoiceway.settings.FragmentVolSet_KSW;
import com.szchoiceway.settings.FragmentVolumeSet;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.settings.adapter.AppListAdapter;
import com.szchoiceway.settings.bean.AppInfo;
import com.szchoiceway.settings.fragments.FragmentSystemNew;
import com.szchoiceway.settings.fragments.FragmentSystemSet_Dvr;
import com.szchoiceway.settings.fragments.FragmentSystemSet_MusicPlayer;
import com.szchoiceway.settings.fragments.FragmentSystemSet_VideoPlayer;
import com.szchoiceway.settings.view.MySeekbar1;
import com.szchoiceway.settings.view.MySeekbar2;
import com.szchoiceway.util.AppUtil;
import com.szchoiceway.zxwlib.GyroScopeWithCompassView;
import java.util.ArrayList;
import java.util.List;

public class FocusUtil {
    private static final String TAG = "FocusUtil";
    private List<AppInfo> appInfoList;
    private AppUtil appUtil;
    private Fragment currentFragment;
    private MySeekbar1 currentMySeekbar = null;
    private MySeekbar2 currentMySeekbar2 = null;
    private RecyclerView currentRecycleView = null;
    private String currentSeekBarString = "";
    private SeekBar currentSeekbar = null;
    public TextView currentText = null;
    private View currentView;
    private List<Integer> focusViewIds = new ArrayList();
    private FragmentSystemNew fragmentSystemNew;
    public boolean inSeekbarKnobMode = false;
    private IEventService mService;
    private boolean mShowAndroidCameraType = false;
    private int m_iModeSet = 16;
    private int m_iUIIndex = 1;
    private MainActivity mainActivity;
    private String resolution = "1920x720";
    private View rootView;
    private int seekBarProgress = 0;
    private String[] seekBarStrings;
    private int[] seekbarIds;
    private int[] seekbarViewIds;
    public boolean showMCUUpgradeView = false;
    private String tag = "";
    private int[] textViewIds;
    public TextView tvPercent = null;

    public FocusUtil(int i, int i2) {
        this.m_iModeSet = i;
        this.m_iUIIndex = i2;
    }

    public void loadResolution(String str) {
        this.resolution = str;
    }

    public void setService(IEventService iEventService, MainActivity mainActivity2) {
        this.mService = iEventService;
        if (this.mainActivity == null) {
            this.mainActivity = mainActivity2;
        }
    }

    public void setActivity(MainActivity mainActivity2) {
        this.mainActivity = mainActivity2;
        boolean z = false;
        int recordInteger = SysProviderOpt.getInstance(mainActivity2).getRecordInteger("KESAIWEI_SYS_CAMERA_SELECTION", 0);
        if (Build.VERSION.SDK_INT > 31 && recordInteger == 3) {
            z = true;
        }
        this.mShowAndroidCameraType = z;
    }

    public void showAndroidCameraType(boolean z) {
        this.mShowAndroidCameraType = z;
    }

    public void locateFragment(Fragment fragment, String str) {
        Log.d(TAG, "locateFragment tag = " + str + ", fragment = " + fragment);
        if (this.mainActivity.hasKnob) {
            this.currentFragment = fragment;
            this.tag = str;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1463163304:
                    if (str.equals(FragmentVolumeSet.TAG)) {
                        c = 0;
                        break;
                    }
                    break;
                case 83436534:
                    if (str.equals("SystemSet_Display")) {
                        c = 1;
                        break;
                    }
                    break;
                case 518208504:
                    if (str.equals("SystemSet_AUX")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1561374927:
                    if (str.equals("FragmentVolSet_KSW")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1794241633:
                    if (str.equals("FragmentSystemNew")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    int i = this.m_iUIIndex;
                    if (i == 4 || i == 6) {
                        this.seekbarIds = new int[]{R.id.my_seekbar1_00, R.id.my_seekbar1_01, R.id.my_seekbar1_03, R.id.my_seekbar1_04};
                        this.seekbarViewIds = new int[]{R.id.viewKSW_Vol_val_00, R.id.viewKSW_Vol_val_01, R.id.viewKSW_Vol_val_03, R.id.viewKSW_Vol_val_04};
                    } else {
                        this.seekbarIds = new int[]{R.id.KSW_VolSeekBar_00, R.id.KSW_VolSeekBar_01, R.id.KSW_VolSeekBar_03, R.id.KSW_VolSeekBar_04};
                    }
                    this.seekBarStrings = new String[]{EventUtils.KEY_KSW_VOL_VAL_00, EventUtils.KEY_KSW_VOL_VAL_01, EventUtils.KEY_KSW_VOL_VAL_03, EventUtils.KEY_KSW_VOL_VAL_04};
                    this.textViewIds = new int[]{R.id.KSW_Vol_val_00, R.id.KSW_Vol_val_01, R.id.KSW_Vol_val_03, R.id.KSW_Vol_val_04};
                    return;
                case 1:
                    if (this.m_iUIIndex == 3 || isDefaultUI()) {
                        this.seekbarIds = new int[]{R.id.KSW_BLSeekBar};
                    } else {
                        this.seekbarIds = new int[]{R.id.my_seekbar_brightness};
                    }
                    this.seekBarStrings = new String[]{EventUtils.KEY_BRIGHTNESS_SETTINGS};
                    return;
                case 2:
                    if (this.m_iUIIndex == 3 || isDefaultUI()) {
                        this.seekbarIds = new int[]{R.id.KSW_aux1_SeekBar, R.id.KSW_aux2_SeekBar};
                    } else {
                        int i2 = this.m_iUIIndex;
                        if (i2 == 2 || i2 == 4 || i2 == 6 || i2 == 7) {
                            this.seekbarIds = new int[]{R.id.my_seekBar1_aux1, R.id.my_seekBar1_aux2};
                        }
                    }
                    this.textViewIds = new int[]{R.id.KSW_aux1_val, R.id.KSW_aux2_val};
                    this.seekBarStrings = new String[]{SysProviderOpt.KSW_AUX_ITEM_POSITION, SysProviderOpt.KSW_AUX_ITEM_POSITION2};
                    return;
                case 3:
                    if (this.m_iUIIndex == 3 || isDefaultUI()) {
                        this.seekbarIds = new int[]{R.id.KSW_VolSeekBar_page2_low, R.id.KSW_VolSeekBar_page2_mid, R.id.KSW_VolSeekBar_page2_hight};
                        this.textViewIds = new int[]{R.id.KSW_VolValue_Bass, R.id.KSW_VolValue_Alto, R.id.KSW_VolValue_Treble};
                    } else {
                        int i3 = this.m_iUIIndex;
                        if (i3 == 4 || i3 == 6) {
                            this.seekbarIds = new int[]{R.id.my_seekbar1_bass, R.id.my_seekbar1_alto, R.id.my_seekbar1_treble};
                            this.textViewIds = new int[]{R.id.KSW_VolValue_Bass, R.id.KSW_VolValue_Alto, R.id.KSW_VolValue_Treble};
                        }
                    }
                    this.seekBarStrings = new String[]{EventUtils.KESAIWEI_EQ_USER_LOW, EventUtils.KESAIWEI_EQ_USER_MID, EventUtils.KESAIWEI_EQ_USER_HIGHT};
                    return;
                case 4:
                    this.fragmentSystemNew = (FragmentSystemNew) fragment;
                    return;
                default:
                    return;
            }
        }
    }

    public void addViewIds(List<Integer> list) {
        this.focusViewIds = new ArrayList();
        if (list.size() > 0) {
            this.focusViewIds.addAll(list);
        }
    }

    public List<Integer> getViewIds() {
        return this.focusViewIds;
    }

    public int getFocusViewSize() {
        if (FragmentNavSetNew.TAG.equals(this.tag)) {
            AppUtil appUtil2 = new AppUtil(this.currentFragment.getContext(), 3);
            this.appUtil = appUtil2;
            this.appInfoList = appUtil2.getAppList();
            if (this.m_iUIIndex == 3 || isDefaultUI()) {
                return this.appInfoList.size() + 1;
            }
            return this.appInfoList.size();
        }
        if ("SystemSet_Dvr".equals(this.tag)) {
            CheckBox checkBox = (CheckBox) this.currentFragment.getView().findViewById(R.id.kesaiwei_dvr_USB);
            if (checkBox != null && checkBox.isChecked()) {
                AppUtil appUtil3 = new AppUtil(this.currentFragment.getContext(), 0);
                this.appUtil = appUtil3;
                List<AppInfo> appList = appUtil3.getAppList();
                this.appInfoList = appList;
                return appList.size() + this.focusViewIds.size();
            }
        } else if ("Set_MusicPlayer".equals(this.tag)) {
            AppUtil appUtil4 = new AppUtil(this.currentFragment.getContext(), 1);
            this.appUtil = appUtil4;
            List<AppInfo> appList2 = appUtil4.getAppList();
            this.appInfoList = appList2;
            return appList2.size();
        } else if ("Set_VideoPlayer".equals(this.tag)) {
            AppUtil appUtil5 = new AppUtil(this.currentFragment.getContext(), 2);
            this.appUtil = appUtil5;
            List<AppInfo> appList3 = appUtil5.getAppList();
            this.appInfoList = appList3;
            return appList3.size();
        }
        return this.focusViewIds.size();
    }

    public void refreshFirstViews(MainActivity mainActivity2, int i, boolean z) {
        if (!this.mainActivity.hasKnob || mainActivity2.radioButtonIds.isEmpty()) {
            return;
        }
        if (this.m_iUIIndex != 2) {
            int i2 = 0;
            while (i2 < mainActivity2.radioButtonIds.size()) {
                View findViewById = mainActivity2.findViewById(mainActivity2.radioButtonIds.get(i2).intValue());
                if (findViewById != null) {
                    findViewById.setSelected(i2 == i);
                }
                i2++;
            }
            ScrollView scrollView = (ScrollView) mainActivity2.findViewById(R.id.id_scroll_view);
            if (scrollView != null && z) {
                if (i >= 5) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 512));
                } else if (i > 0) {
                    scrollView.scrollTo(0, 0);
                }
            }
        } else if (mainActivity2.leftFocus) {
            int i3 = 0;
            while (i3 < mainActivity2.leftButtonIds.size()) {
                View findViewById2 = mainActivity2.findViewById(mainActivity2.leftButtonIds.get(i3).intValue());
                if (findViewById2 != null) {
                    findViewById2.setSelected(i3 == i);
                }
                i3++;
            }
            for (int i4 = 0; i4 < mainActivity2.radioButtonIds.size(); i4++) {
                View findViewById3 = mainActivity2.findViewById(mainActivity2.radioButtonIds.get(i4).intValue());
                if (findViewById3 != null) {
                    findViewById3.setSelected(false);
                }
            }
        } else {
            for (int i5 = 0; i5 < mainActivity2.leftButtonIds.size(); i5++) {
                View findViewById4 = mainActivity2.findViewById(mainActivity2.leftButtonIds.get(i5).intValue());
                if (findViewById4 != null) {
                    findViewById4.setSelected(false);
                }
            }
            int i6 = 0;
            while (i6 < mainActivity2.radioButtonIds.size()) {
                View findViewById5 = mainActivity2.findViewById(mainActivity2.radioButtonIds.get(i6).intValue());
                if (findViewById5 != null) {
                    findViewById5.setSelected(i6 == i);
                }
                i6++;
            }
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) mainActivity2.findViewById(R.id.id8_scroll_view);
            if (horizontalScrollView != null && z) {
                if (i >= 4) {
                    horizontalScrollView.scrollTo(EventUtils.pxToDp(this.resolution, 1500), 0);
                } else if (i > 0) {
                    horizontalScrollView.scrollTo(0, 0);
                }
            }
        }
    }

    public void refreshFirstViews_PasswordView(MainActivity mainActivity2, int i) {
        if (this.mainActivity.hasKnob) {
            int i2 = 0;
            while (i2 < mainActivity2.passwordButtonIds.length) {
                View findViewById = mainActivity2.findViewById(mainActivity2.passwordButtonIds[i2]);
                if (findViewById != null) {
                    findViewById.setSelected(i2 == i);
                }
                i2++;
            }
        }
    }

    public void enterFirstViews_PasswordView(MainActivity mainActivity2, int i) {
        View findViewById;
        if (this.mainActivity.hasKnob && (findViewById = mainActivity2.findViewById(mainActivity2.passwordButtonIds[i])) != null) {
            findViewById.performClick();
        }
    }

    public void enterFirstViews(MainActivity mainActivity2, int i) {
        View view;
        if (this.mainActivity.hasKnob) {
            if (!mainActivity2.leftFocus) {
                view = mainActivity2.findViewById(mainActivity2.radioButtonIds.get(i).intValue());
            } else {
                view = mainActivity2.findViewById(mainActivity2.leftButtonIds.get(i).intValue());
            }
            if (view != null) {
                view.performClick();
            }
        }
    }

    public void refreshSecondViews(int i, boolean z) {
        if (this.mainActivity.hasKnob) {
            Fragment fragment = this.currentFragment;
            if (fragment != null) {
                this.rootView = fragment.getView();
            }
            String str = this.tag;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1464664865:
                    if (str.equals("FragmentStartCode")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1463163304:
                    if (str.equals(FragmentVolumeSet.TAG)) {
                        c = 1;
                        break;
                    }
                    break;
                case -535759545:
                    if (str.equals("FragmentSysInfor")) {
                        c = 2;
                        break;
                    }
                    break;
                case 208981480:
                    if (str.equals("FragmentLanguage")) {
                        c = 3;
                        break;
                    }
                    break;
                case 291273003:
                    if (str.equals("FragmentDataTimer")) {
                        c = 4;
                        break;
                    }
                    break;
                case 786794577:
                    if (str.equals(FragmentNavSetNew.TAG)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1561374927:
                    if (str.equals("FragmentVolSet_KSW")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1794241633:
                    if (str.equals("FragmentSystemNew")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    refreshFragmentStartCode(i);
                    return;
                case 1:
                    refreshFragmentVolumeSet(i, z);
                    return;
                case 2:
                    refreshFragmentSysInfor(i, z);
                    return;
                case 3:
                    refreshFragmentLanguage(i, z);
                    return;
                case 4:
                    refreshFragmentDataTimer(i, z);
                    return;
                case 5:
                    refreshFragmentNavSetNew(i);
                    return;
                case 6:
                    refreshFragmentVolSet_KSW(i, z);
                    return;
                case 7:
                    refreshFragmentSystemNew(i, z);
                    return;
                default:
                    return;
            }
        }
    }

    public void enterSecondViews(int i) {
        if (this.mainActivity.hasKnob) {
            String str = this.tag;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1464664865:
                    if (str.equals("FragmentStartCode")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1463163304:
                    if (str.equals(FragmentVolumeSet.TAG)) {
                        c = 1;
                        break;
                    }
                    break;
                case -535759545:
                    if (str.equals("FragmentSysInfor")) {
                        c = 2;
                        break;
                    }
                    break;
                case 208981480:
                    if (str.equals("FragmentLanguage")) {
                        c = 3;
                        break;
                    }
                    break;
                case 291273003:
                    if (str.equals("FragmentDataTimer")) {
                        c = 4;
                        break;
                    }
                    break;
                case 786794577:
                    if (str.equals(FragmentNavSetNew.TAG)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1561374927:
                    if (str.equals("FragmentVolSet_KSW")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1794241633:
                    if (str.equals("FragmentSystemNew")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    enterFragmentStartCode(i);
                    return;
                case 1:
                    enterFragmentVolumeSet(i);
                    return;
                case 2:
                    enterFragmentSysInfor(i);
                    return;
                case 3:
                    enterFragmentLanguage(i);
                    return;
                case 4:
                    enterFragmentDataTimer(i);
                    return;
                case 5:
                    enterFragmentNavSetNew(i);
                    return;
                case 6:
                    enterFragmentVolSet_KSW(i);
                    return;
                case 7:
                    enterFragmentSystemNew(i);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0124, code lost:
        if (r0.equals("Set_Other") == false) goto L_0x00b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void refreshThirdViews(int r9, boolean r10) {
        /*
            r8 = this;
            com.szchoiceway.settings.MainActivity r0 = r8.mainActivity
            boolean r0 = r0.hasKnob
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.fragment.app.Fragment r0 = r8.currentFragment
            if (r0 == 0) goto L_0x0011
            android.view.View r0 = r0.getView()
            r8.rootView = r0
        L_0x0011:
            com.szchoiceway.settings.MainActivity r0 = r8.mainActivity
            if (r0 == 0) goto L_0x0023
            android.view.View r1 = r8.rootView
            if (r1 != 0) goto L_0x0023
            android.view.Window r0 = r0.getWindow()
            android.view.View r0 = r0.getDecorView()
            r8.rootView = r0
        L_0x0023:
            com.szchoiceway.settings.MainActivity r0 = r8.mainActivity
            r1 = 2
            r2 = 1
            r3 = 0
            r4 = 8
            if (r0 == 0) goto L_0x00a4
            r5 = 2131231168(0x7f0801c0, float:1.807841E38)
            android.view.View r0 = r0.findViewById(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.szchoiceway.settings.MainActivity r5 = r8.mainActivity
            r6 = 2131231182(0x7f0801ce, float:1.8078438E38)
            android.view.View r5 = r5.findViewById(r6)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            com.szchoiceway.settings.MainActivity r6 = r8.mainActivity
            r7 = 2131231166(0x7f0801be, float:1.8078405E38)
            android.view.View r6 = r6.findViewById(r7)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            int r7 = com.szchoiceway.settings.BaseApp.focusPage
            if (r7 != r2) goto L_0x0078
            if (r0 == 0) goto L_0x005a
            int r7 = r0.getVisibility()
            if (r7 != r4) goto L_0x005a
            r0.setVisibility(r3)
        L_0x005a:
            if (r5 == 0) goto L_0x0065
            int r0 = r5.getVisibility()
            if (r0 != 0) goto L_0x0065
            r5.setVisibility(r4)
        L_0x0065:
            if (r6 == 0) goto L_0x00a4
            com.szchoiceway.settings.MainActivity r0 = r8.mainActivity
            android.content.res.Resources r0 = r0.getResources()
            r5 = 2131165873(0x7f0702b1, float:1.7945975E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r5)
            r6.setBackground(r0)
            goto L_0x00a4
        L_0x0078:
            int r7 = com.szchoiceway.settings.BaseApp.focusPage
            if (r7 != r1) goto L_0x00a4
            if (r0 == 0) goto L_0x0087
            int r7 = r0.getVisibility()
            if (r7 != 0) goto L_0x0087
            r0.setVisibility(r4)
        L_0x0087:
            if (r5 == 0) goto L_0x0092
            int r0 = r5.getVisibility()
            if (r0 != r4) goto L_0x0092
            r5.setVisibility(r3)
        L_0x0092:
            if (r6 == 0) goto L_0x00a4
            com.szchoiceway.settings.MainActivity r0 = r8.mainActivity
            android.content.res.Resources r0 = r0.getResources()
            r5 = 2131165907(0x7f0702d3, float:1.7946044E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r5)
            r6.setBackground(r0)
        L_0x00a4:
            java.lang.String r0 = r8.tag
            r0.hashCode()
            r5 = -1
            int r6 = r0.hashCode()
            switch(r6) {
                case -1935568735: goto L_0x0132;
                case -1463163304: goto L_0x0127;
                case -1392149325: goto L_0x011e;
                case -1114785072: goto L_0x0113;
                case -924054881: goto L_0x0108;
                case -720405303: goto L_0x00fd;
                case -537472898: goto L_0x00f2;
                case 83436534: goto L_0x00e7;
                case 291273003: goto L_0x00db;
                case 518208504: goto L_0x00ce;
                case 518212436: goto L_0x00c1;
                case 1561374927: goto L_0x00b4;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            r1 = r5
            goto L_0x013d
        L_0x00b4:
            java.lang.String r1 = "FragmentVolSet_KSW"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00bd
            goto L_0x00b1
        L_0x00bd:
            r1 = 11
            goto L_0x013d
        L_0x00c1:
            java.lang.String r1 = "SystemSet_Dvr"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ca
            goto L_0x00b1
        L_0x00ca:
            r1 = 10
            goto L_0x013d
        L_0x00ce:
            java.lang.String r1 = "SystemSet_AUX"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d7
            goto L_0x00b1
        L_0x00d7:
            r1 = 9
            goto L_0x013d
        L_0x00db:
            java.lang.String r1 = "FragmentDataTimer"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00e4
            goto L_0x00b1
        L_0x00e4:
            r1 = r4
            goto L_0x013d
        L_0x00e7:
            java.lang.String r1 = "SystemSet_Display"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00f0
            goto L_0x00b1
        L_0x00f0:
            r1 = 7
            goto L_0x013d
        L_0x00f2:
            java.lang.String r1 = "SystemSet_BT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00fb
            goto L_0x00b1
        L_0x00fb:
            r1 = 6
            goto L_0x013d
        L_0x00fd:
            java.lang.String r1 = "Set_MusicPlayer"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0106
            goto L_0x00b1
        L_0x0106:
            r1 = 5
            goto L_0x013d
        L_0x0108:
            java.lang.String r1 = "Set_VideoPlayer"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0111
            goto L_0x00b1
        L_0x0111:
            r1 = 4
            goto L_0x013d
        L_0x0113:
            java.lang.String r1 = "SystemSet_Unit"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x011c
            goto L_0x00b1
        L_0x011c:
            r1 = 3
            goto L_0x013d
        L_0x011e:
            java.lang.String r2 = "Set_Other"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x013d
            goto L_0x00b1
        L_0x0127:
            java.lang.String r1 = "FragmentVolumeSet"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0130
            goto L_0x00b1
        L_0x0130:
            r1 = r2
            goto L_0x013d
        L_0x0132:
            java.lang.String r1 = "SystemSet_BackCar"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x013c
            goto L_0x00b1
        L_0x013c:
            r1 = r3
        L_0x013d:
            switch(r1) {
                case 0: goto L_0x016d;
                case 1: goto L_0x0169;
                case 2: goto L_0x0165;
                case 3: goto L_0x0161;
                case 4: goto L_0x015d;
                case 5: goto L_0x0159;
                case 6: goto L_0x0155;
                case 7: goto L_0x0151;
                case 8: goto L_0x014d;
                case 9: goto L_0x0149;
                case 10: goto L_0x0145;
                case 11: goto L_0x0141;
                default: goto L_0x0140;
            }
        L_0x0140:
            goto L_0x0170
        L_0x0141:
            r8.refreshFragmentVolSet_KSWThird(r9, r10)
            goto L_0x0170
        L_0x0145:
            r8.refreshFragmentSystemSet_Dvr(r9)
            goto L_0x0170
        L_0x0149:
            r8.refreshFragmentSystemSet_AUX(r9, r10)
            goto L_0x0170
        L_0x014d:
            r8.refreshFragmentDataTimerThird(r9, r10)
            goto L_0x0170
        L_0x0151:
            r8.refreshFragmentSystemSet_Display(r9)
            goto L_0x0170
        L_0x0155:
            r8.refreshFragmentSystemSet_BT(r9)
            goto L_0x0170
        L_0x0159:
            r8.refreshFragmentSet_MusicPlayer(r9)
            goto L_0x0170
        L_0x015d:
            r8.refreshFragmentSet_VideoPlayer(r9)
            goto L_0x0170
        L_0x0161:
            r8.refreshFragmentSystemSet_Unit(r9, r10)
            goto L_0x0170
        L_0x0165:
            r8.refreshFragmentSet_Other(r9)
            goto L_0x0170
        L_0x0169:
            r8.refreshFragmentVolumeSet(r9, r10)
            goto L_0x0170
        L_0x016d:
            r8.refreshFragmentSystemSet_BackCar(r9, r10)
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szchoiceway.settings.util.FocusUtil.refreshThirdViews(int, boolean):void");
    }

    public void enterThirdViews(int i) {
        if (this.mainActivity.hasKnob) {
            Fragment fragment = this.currentFragment;
            if (fragment != null) {
                this.rootView = fragment.getView();
            }
            if (this.rootView == null) {
                this.rootView = this.mainActivity.getWindow().getDecorView();
            }
            String str = this.tag;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1935568735:
                    if (str.equals("SystemSet_BackCar")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1463163304:
                    if (str.equals(FragmentVolumeSet.TAG)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1392149325:
                    if (str.equals("Set_Other")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1114785072:
                    if (str.equals("SystemSet_Unit")) {
                        c = 3;
                        break;
                    }
                    break;
                case -924054881:
                    if (str.equals("Set_VideoPlayer")) {
                        c = 4;
                        break;
                    }
                    break;
                case -720405303:
                    if (str.equals("Set_MusicPlayer")) {
                        c = 5;
                        break;
                    }
                    break;
                case -537472898:
                    if (str.equals("SystemSet_BT")) {
                        c = 6;
                        break;
                    }
                    break;
                case 83436534:
                    if (str.equals("SystemSet_Display")) {
                        c = 7;
                        break;
                    }
                    break;
                case 291273003:
                    if (str.equals("FragmentDataTimer")) {
                        c = 8;
                        break;
                    }
                    break;
                case 518208504:
                    if (str.equals("SystemSet_AUX")) {
                        c = 9;
                        break;
                    }
                    break;
                case 518212436:
                    if (str.equals("SystemSet_Dvr")) {
                        c = 10;
                        break;
                    }
                    break;
                case 1561374927:
                    if (str.equals("FragmentVolSet_KSW")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    enterFragmentSystemSet_BackCar(i);
                    return;
                case 1:
                    enterFragmentVolumeSet(i);
                    return;
                case 2:
                    enterFragmentSet_Other(i);
                    return;
                case 3:
                    enterFragmentSystemSet_Unit(i);
                    return;
                case 4:
                    enterFragmentSet_VideoPlayer(i);
                    return;
                case 5:
                    enterFragmentSet_MusicPlayer(i);
                    return;
                case 6:
                    enterFragmentSystemSet_BT(i);
                    return;
                case 7:
                    enterFragmentSystemSet_Display(i);
                    return;
                case 8:
                    enterFragmentDataTimerThird(i);
                    return;
                case 9:
                    enterFragmentSystemSet_AUX(i);
                    return;
                case 10:
                    enterFragmentSystemSet_Dvr(i);
                    return;
                case 11:
                    enterFragmentVolSet_KSWThird(i);
                    return;
                default:
                    return;
            }
        }
    }

    private void refreshFragmentNavSetNew(int i) {
        if (this.rootView == null) {
            return;
        }
        if (this.m_iUIIndex == 3 || isDefaultUI()) {
            AppListAdapter adapter = ((FragmentNavSetNew) this.currentFragment).getAdapter();
            View findViewById = this.rootView.findViewById(R.id.LytMsgYesNo);
            if (findViewById != null && findViewById.getVisibility() == 0) {
                ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.BtnResetYes);
                ImageButton imageButton2 = (ImageButton) this.rootView.findViewById(R.id.BtnResetNo);
                if (imageButton.isSelected()) {
                    imageButton.setSelected(false);
                    imageButton2.setSelected(true);
                    return;
                }
                imageButton.setSelected(true);
                imageButton2.setSelected(false);
            } else if (i == 0) {
                View findViewById2 = this.rootView.findViewById(this.focusViewIds.get(0).intValue());
                if (findViewById2 != null) {
                    findViewById2.setSelected(true);
                }
                adapter.setFocusIndex(-1);
            } else {
                View findViewById3 = this.rootView.findViewById(this.focusViewIds.get(0).intValue());
                if (findViewById3 != null && findViewById3.isSelected()) {
                    findViewById3.setSelected(false);
                }
                int i2 = i - 1;
                adapter.setFocusIndex(i2);
                RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.appList);
                this.currentRecycleView = recyclerView;
                recyclerView.smoothScrollToPosition(i2);
            }
        } else {
            ((FragmentNavSetNew) this.currentFragment).getAdapter().setFocusIndex(i);
            RecyclerView recyclerView2 = (RecyclerView) this.rootView.findViewById(R.id.appList);
            this.currentRecycleView = recyclerView2;
            if (i >= 0) {
                recyclerView2.smoothScrollToPosition(i);
            } else {
                recyclerView2.smoothScrollToPosition(0);
            }
        }
    }

    private void refreshFragmentLanguage(int i, boolean z) {
        if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            for (int i2 = 0; i2 < this.focusViewIds.size(); i2++) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                this.currentView = findViewById;
                if (findViewById != null) {
                    if (i2 == i) {
                        findViewById.setSelected(true);
                    } else {
                        findViewById.setSelected(false);
                    }
                }
            }
            ScrollView scrollView = (ScrollView) this.rootView.findViewById(R.id.mScrollView);
            if (scrollView != null && z) {
                int i3 = this.m_iUIIndex;
                if (i3 == 2) {
                    if (i >= 6 && i < 12) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 592));
                    } else if (i >= 12 && i < 18) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1178));
                    } else if (i >= 18) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 2000));
                    } else {
                        scrollView.scrollTo(0, 0);
                    }
                } else if (i3 == 6) {
                    if (i > 14) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 2000));
                    } else if (i > 9) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 860));
                    } else if (i > 4) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 428));
                    } else {
                        scrollView.scrollTo(0, 0);
                    }
                } else if (i3 == 4) {
                    if (i > 14) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 2000));
                    } else if (i > 9) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 958));
                    } else if (i > 4) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 478));
                    } else {
                        scrollView.scrollTo(0, 0);
                    }
                } else if (i >= 5 && i < 11) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 502));
                } else if (i >= 11 && i < 17) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1102));
                } else if (i >= 17) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1419));
                } else {
                    scrollView.scrollTo(0, 0);
                }
            }
        }
    }

    private void refreshFragmentSystemNew(int i, boolean z) {
        MainActivity mainActivity2 = this.mainActivity;
        if (mainActivity2 != null) {
            ImageView imageView = (ImageView) mainActivity2.findViewById(R.id.imgLeftBg);
            ImageView imageView2 = (ImageView) this.mainActivity.findViewById(R.id.imgRightBg);
            ImageView imageView3 = (ImageView) this.mainActivity.findViewById(R.id.imgDirection);
            if (BaseApp.focusPage == 1) {
                if (imageView != null && imageView.getVisibility() == 8) {
                    imageView.setVisibility(0);
                }
                if (imageView2 != null && imageView2.getVisibility() == 0) {
                    imageView2.setVisibility(8);
                }
                if (imageView3 != null) {
                    imageView3.setBackground(this.mainActivity.getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_bt_icon_right));
                }
            } else if (BaseApp.focusPage == 2) {
                if (imageView != null && imageView.getVisibility() == 0) {
                    imageView.setVisibility(8);
                }
                if (imageView2 != null && imageView2.getVisibility() == 8) {
                    imageView2.setVisibility(0);
                }
                if (imageView3 != null) {
                    imageView3.setBackground(this.mainActivity.getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_system_left));
                }
            }
        }
        if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            for (int i2 = 0; i2 < this.focusViewIds.size(); i2++) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                if (findViewById != null) {
                    if (i2 == i) {
                        findViewById.setSelected(true);
                    } else {
                        findViewById.setSelected(false);
                    }
                }
            }
            ScrollView scrollView = (ScrollView) this.rootView.findViewById(R.id.systemScrollView);
            if (scrollView != null && z) {
                if (i >= 5) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 512));
                } else if (i >= 0) {
                    scrollView.scrollTo(0, 0);
                }
            }
        }
    }

    private void refreshFragmentVolumeSet(int i, boolean z) {
        if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            for (int i2 = 0; i2 < this.focusViewIds.size(); i2++) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                if (findViewById != null) {
                    if (i2 == i) {
                        findViewById.setSelected(true);
                    } else {
                        findViewById.setSelected(false);
                    }
                }
            }
            ScrollView scrollView = (ScrollView) this.rootView.findViewById(R.id.mScrollView);
            if (scrollView != null && z) {
                if (i > 2) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 512));
                } else {
                    scrollView.scrollTo(0, 0);
                }
            }
        }
    }

    private void refreshFragmentVolSet_KSW(int i, boolean z) {
        if (this.rootView != null) {
            int i2 = this.m_iUIIndex;
            if (i2 == 6 || i2 == 3 || isDefaultUI() || (this.m_iUIIndex == 4 && BaseApp.isSmallResolution)) {
                if (i >= this.focusViewIds.size()) {
                    i = this.focusViewIds.size() - 1;
                }
                for (int i3 = 0; i3 < this.focusViewIds.size(); i3++) {
                    View findViewById = this.rootView.findViewById(this.focusViewIds.get(i3).intValue());
                    if (findViewById != null) {
                        if (i3 == i) {
                            findViewById.setSelected(true);
                        } else {
                            findViewById.setSelected(false);
                        }
                    }
                }
                ScrollView scrollView = (ScrollView) this.rootView.findViewById(R.id.mScrollView);
                if (scrollView != null && z) {
                    if (i > 4) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 800));
                    } else {
                        scrollView.scrollTo(0, 0);
                    }
                }
            } else {
                int i4 = this.m_iUIIndex;
                if (i4 == 2 || i4 == 7) {
                    ImageView imageView = (ImageView) this.rootView.findViewById(R.id.imgLeftBg);
                    ImageView imageView2 = (ImageView) this.rootView.findViewById(R.id.imgRightBg);
                    ImageView imageView3 = (ImageView) this.rootView.findViewById(R.id.imgDirection);
                    if (BaseApp.focusPage == 1) {
                        if (imageView != null && imageView.getVisibility() == 8) {
                            imageView.setVisibility(0);
                        }
                        if (imageView2 != null && imageView2.getVisibility() == 0) {
                            imageView2.setVisibility(8);
                        }
                        if (imageView3 != null) {
                            imageView3.setBackground(this.mainActivity.getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_bt_icon_right));
                        }
                    } else if (BaseApp.focusPage == 2) {
                        if (imageView != null && imageView.getVisibility() == 0) {
                            imageView.setVisibility(8);
                        }
                        if (imageView2 != null && imageView2.getVisibility() == 8) {
                            imageView2.setVisibility(0);
                        }
                        if (imageView3 != null) {
                            imageView3.setBackground(this.mainActivity.getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_system_left));
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    this.focusViewIds = arrayList;
                    arrayList.add(Integer.valueOf(R.id.rbAndroid));
                    this.focusViewIds.add(Integer.valueOf(R.id.rbOem));
                    this.focusViewIds.add(Integer.valueOf(R.id.rbSound));
                    if (i >= this.focusViewIds.size()) {
                        i = this.focusViewIds.size() - 1;
                    }
                    for (int i5 = 0; i5 < this.focusViewIds.size(); i5++) {
                        View findViewById2 = this.rootView.findViewById(this.focusViewIds.get(i5).intValue());
                        if (findViewById2 != null) {
                            if (i5 == i) {
                                findViewById2.setSelected(true);
                            } else {
                                findViewById2.setSelected(false);
                            }
                        }
                    }
                } else if (i4 == 4) {
                    if (i >= this.focusViewIds.size()) {
                        i = this.focusViewIds.size() - 1;
                    }
                    for (int i6 = 0; i6 < this.focusViewIds.size(); i6++) {
                        View findViewById3 = this.rootView.findViewById(this.focusViewIds.get(i6).intValue());
                        if (findViewById3 != null) {
                            if (i6 == i) {
                                findViewById3.setSelected(true);
                            } else {
                                findViewById3.setSelected(false);
                            }
                        }
                    }
                    ScrollView scrollView2 = (ScrollView) this.rootView.findViewById(R.id.mScrollView);
                    if (scrollView2 != null && z) {
                        if (i > 4) {
                            scrollView2.scrollTo(0, EventUtils.pxToDp(this.resolution, 54));
                        } else {
                            scrollView2.scrollTo(0, 0);
                        }
                    }
                }
            }
        }
    }

    private void refreshFragmentVolSet_KSWThird(int i, boolean z) {
        int i2 = i;
        int i3 = this.m_iUIIndex;
        if ((i3 != 2 && i3 != 4 && i3 != 7) || this.rootView == null) {
            return;
        }
        if (i3 == 2 || i3 == 7) {
            if (i2 == -1) {
                ((FragmentVolSet_KSW) this.currentFragment).showID8UserView = false;
                ((FragmentVolSet_KSW) this.currentFragment).showID8UserView();
            }
            ImageView imageView = (ImageView) this.rootView.findViewById(R.id.imgLeftBg);
            ImageView imageView2 = (ImageView) this.rootView.findViewById(R.id.imgRightBg);
            ImageView imageView3 = (ImageView) this.rootView.findViewById(R.id.imgDirection);
            if (BaseApp.focusPage == 1) {
                if (imageView != null && imageView.getVisibility() == 8) {
                    imageView.setVisibility(0);
                }
                if (imageView2 != null && imageView2.getVisibility() == 0) {
                    imageView2.setVisibility(8);
                }
                if (imageView3 != null) {
                    imageView3.setBackground(this.mainActivity.getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_bt_icon_right));
                }
            } else if (BaseApp.focusPage == 2) {
                if (imageView != null && imageView.getVisibility() == 0) {
                    imageView.setVisibility(8);
                }
                if (imageView2 != null && imageView2.getVisibility() == 8) {
                    imageView2.setVisibility(0);
                }
                if (imageView3 != null) {
                    imageView3.setBackground(this.mainActivity.getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_system_left));
                }
            }
            int i4 = this.mainActivity.lastYFocus;
            if (i4 == 0) {
                ArrayList arrayList = new ArrayList();
                this.focusViewIds = arrayList;
                arrayList.add(Integer.valueOf(R.id.viewSound_SeekBar0));
                this.focusViewIds.add(Integer.valueOf(R.id.viewSound_SeekBar1));
                BaseApp.getFocusUtil().addViewIds(this.focusViewIds);
            } else if (i4 == 1) {
                ArrayList arrayList2 = new ArrayList();
                this.focusViewIds = arrayList2;
                arrayList2.add(Integer.valueOf(R.id.viewSound_SeekBar2));
                this.focusViewIds.add(Integer.valueOf(R.id.viewSound_SeekBar3));
                BaseApp.getFocusUtil().addViewIds(this.focusViewIds);
            } else if (i4 == 2) {
                if (this.m_iUIIndex == 2) {
                    View findViewById = this.rootView.findViewById(R.id.viewUser);
                    if (findViewById != null) {
                        this.focusViewIds = new ArrayList();
                        if (findViewById.getVisibility() == 8) {
                            this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_custom));
                            this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_pop));
                            this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_classical));
                            this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_rock));
                            this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_jazz));
                            this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_dance));
                        } else {
                            this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_custom));
                            this.focusViewIds.add(Integer.valueOf(R.id.viewSound_SeekBar4));
                            this.focusViewIds.add(Integer.valueOf(R.id.viewSound_SeekBar5));
                            this.focusViewIds.add(Integer.valueOf(R.id.viewSound_SeekBar6));
                        }
                    }
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    this.focusViewIds = arrayList3;
                    arrayList3.add(Integer.valueOf(R.id.viewSound_SeekBar4));
                    this.focusViewIds.add(Integer.valueOf(R.id.viewSound_SeekBar5));
                    this.focusViewIds.add(Integer.valueOf(R.id.viewSound_SeekBar6));
                    this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_custom));
                    this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_pop));
                    this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_classical));
                    this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_rock));
                    this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_jazz));
                    this.focusViewIds.add(Integer.valueOf(R.id.KSW_btn_eq_dance));
                }
                BaseApp.getFocusUtil().addViewIds(this.focusViewIds);
            }
            if (i2 >= 0) {
                this.currentView = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
            }
            if (i2 >= this.focusViewIds.size()) {
                i2 = this.focusViewIds.size() - 1;
            }
            for (int i5 = 0; i5 < this.focusViewIds.size(); i5++) {
                View findViewById2 = this.rootView.findViewById(this.focusViewIds.get(i5).intValue());
                if (findViewById2 != null) {
                    if (i5 == i2) {
                        findViewById2.setSelected(true);
                    } else {
                        findViewById2.setSelected(false);
                    }
                }
            }
            ScrollView scrollView = (ScrollView) this.rootView.findViewById(R.id.scSound);
            if (scrollView != null && z) {
                if (this.m_iUIIndex == 2) {
                    if (i2 > 4) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 512));
                    } else if (i2 >= 0) {
                        scrollView.scrollTo(0, 0);
                    }
                } else if (i2 > 4) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 512));
                } else if (i2 >= 0) {
                    scrollView.scrollTo(0, 0);
                }
            }
        } else {
            if (i2 >= this.focusViewIds.size()) {
                i2 = this.focusViewIds.size() - 1;
            }
            for (int i6 = 0; i6 < this.focusViewIds.size(); i6++) {
                View findViewById3 = this.rootView.findViewById(this.focusViewIds.get(i6).intValue());
                if (findViewById3 != null) {
                    if (i6 == i2) {
                        findViewById3.setSelected(true);
                    } else {
                        findViewById3.setSelected(false);
                    }
                }
            }
        }
    }

    private void refreshFragmentDataTimerThird(int i, boolean z) {
        if (this.m_iUIIndex == 7) {
            this.focusViewIds = new ArrayList();
            if (this.mainActivity.lastYFocus == 0) {
                this.focusViewIds.add(Integer.valueOf(R.id.btnOriginalTime));
                this.focusViewIds.add(Integer.valueOf(R.id.btnAutoSync));
            } else {
                this.focusViewIds.add(Integer.valueOf(R.id.btn12Hour));
                this.focusViewIds.add(Integer.valueOf(R.id.btn24Hour));
            }
        }
        if (i >= this.focusViewIds.size()) {
            i = this.focusViewIds.size() - 1;
        }
        int i2 = 0;
        while (i2 < this.focusViewIds.size()) {
            View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
            if (findViewById != null) {
                findViewById.setSelected(i2 == i);
            }
            i2++;
        }
    }

    private void refreshFragmentDataTimer(int i, boolean z) {
        ScrollView scrollView;
        if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            int i2 = this.m_iUIIndex;
            if (i2 == 2) {
                ArrayList arrayList = new ArrayList();
                this.focusViewIds = arrayList;
                arrayList.add(Integer.valueOf(R.id.btnSyc));
                View findViewById = this.rootView.findViewById(R.id.viewSyc);
                if (findViewById != null && findViewById.getVisibility() == 0) {
                    this.focusViewIds.add(Integer.valueOf(R.id.btnOriginalTime));
                    this.focusViewIds.add(Integer.valueOf(R.id.btnAutoSync));
                }
                this.focusViewIds.add(Integer.valueOf(R.id.btnSys));
                View findViewById2 = this.rootView.findViewById(R.id.viewSys);
                if (findViewById2 != null && findViewById2.getVisibility() == 0) {
                    this.focusViewIds.add(Integer.valueOf(R.id.btn12Hour));
                    this.focusViewIds.add(Integer.valueOf(R.id.btn24Hour));
                }
            } else if (i2 == 6 && (scrollView = (ScrollView) this.rootView.findViewById(R.id.mScrollView)) != null && z) {
                if (i > 2) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 512));
                } else if (i >= 0) {
                    scrollView.scrollTo(0, 0);
                }
            }
            for (int i3 = 0; i3 < this.focusViewIds.size(); i3++) {
                View findViewById3 = this.rootView.findViewById(this.focusViewIds.get(i3).intValue());
                if (findViewById3 != null) {
                    if (i3 == i) {
                        findViewById3.setSelected(true);
                    } else {
                        findViewById3.setSelected(false);
                    }
                }
            }
        }
    }

    private void refreshFragmentStartCode(int i) {
        if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            for (int i2 = 0; i2 < this.focusViewIds.size(); i2++) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                if (findViewById != null) {
                    if (i2 == i) {
                        findViewById.setSelected(true);
                    } else {
                        findViewById.setSelected(false);
                    }
                }
            }
        }
    }

    private void refreshFragmentSysInfor(int i, boolean z) {
        if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            for (int i2 = 0; i2 < this.focusViewIds.size(); i2++) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                if (findViewById != null) {
                    if (i2 == i) {
                        findViewById.setSelected(true);
                    } else {
                        findViewById.setSelected(false);
                    }
                }
            }
            ScrollView scrollView = (ScrollView) this.rootView.findViewById(R.id.mScrollView);
            if (scrollView != null && z) {
                if (i >= 0) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 720));
                } else {
                    scrollView.scrollTo(0, 0);
                }
            }
        }
    }

    private void enterFragmentNavSetNew(int i) {
        View view = this.currentFragment.getView();
        this.rootView = view;
        if (view != null) {
            AppListAdapter adapter = ((FragmentNavSetNew) this.currentFragment).getAdapter();
            this.currentRecycleView = (RecyclerView) this.rootView.findViewById(R.id.appList);
            if (this.m_iUIIndex == 3 || isDefaultUI()) {
                View findViewById = this.rootView.findViewById(R.id.LytMsgYesNo);
                if (findViewById != null && findViewById.getVisibility() == 0) {
                    ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.BtnResetYes);
                    ImageButton imageButton2 = (ImageButton) this.rootView.findViewById(R.id.BtnResetNo);
                    if (imageButton.isSelected()) {
                        imageButton.performClick();
                    } else {
                        imageButton2.performClick();
                    }
                } else if (i == 0) {
                    View findViewById2 = this.rootView.findViewById(this.focusViewIds.get(0).intValue());
                    this.currentView = findViewById2;
                    findViewById2.performClick();
                } else {
                    adapter.getOnItemClickListener().onItemClick(i - 1);
                    adapter.notifyDataSetChanged();
                }
            } else {
                adapter.getOnItemClickListener().onItemClick(i);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void enterFragmentLanguage(int i) {
        if (i >= 0) {
            View view = this.currentFragment.getView();
            this.rootView = view;
            if (view != null) {
                View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
                this.currentView = findViewById;
                if ((findViewById instanceof ImageButton) || (findViewById instanceof Button)) {
                    findViewById.performClick();
                }
            }
        }
    }

    private void enterFragmentSystemNew(int i) {
        if (i >= 0) {
            View view = this.currentFragment.getView();
            this.rootView = view;
            if (view != null) {
                View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
                this.currentView = findViewById;
                if ((findViewById instanceof ImageButton) || (findViewById instanceof Button)) {
                    findViewById.performClick();
                }
            }
        }
    }

    private void enterFragmentVolumeSet(int i) {
        if (i >= 0) {
            View view = this.currentFragment.getView();
            this.rootView = view;
            if (view != null) {
                this.currentView = view.findViewById(this.focusViewIds.get(i).intValue());
                if ((this.m_iUIIndex == 4 && !BaseApp.isSmallResolution) || this.m_iUIIndex == 6) {
                    View view2 = this.currentView;
                    if (view2 instanceof Button) {
                        view2.performClick();
                        return;
                    }
                    for (int i2 = 0; i2 < this.seekbarViewIds.length; i2++) {
                        if (this.currentView.getId() == this.seekbarViewIds[i2]) {
                            i = i2;
                        }
                    }
                    if (!this.inSeekbarKnobMode) {
                        this.inSeekbarKnobMode = true;
                        this.currentView.setSelected(false);
                        MySeekbar1 mySeekbar1 = (MySeekbar1) this.rootView.findViewById(this.seekbarIds[i]);
                        this.currentMySeekbar = mySeekbar1;
                        this.currentSeekBarString = this.seekBarStrings[i];
                        this.seekBarProgress = mySeekbar1.getCurrentProgress();
                        TextView textView = (TextView) this.rootView.findViewById(this.textViewIds[i]);
                        this.currentText = textView;
                        if (textView != null) {
                            if (this.m_iUIIndex == 6) {
                                textView.setTextColor(Color.parseColor("#FF3300"));
                            } else {
                                textView.setTextColor(Color.parseColor("#BFB849"));
                            }
                        }
                        Log.d(TAG, "第" + i + "个进度条获取焦点, progress = " + this.seekBarProgress);
                        return;
                    }
                    this.inSeekbarKnobMode = false;
                    this.currentView.setSelected(true);
                    this.currentMySeekbar = null;
                    this.seekBarProgress = 0;
                    TextView textView2 = (TextView) this.rootView.findViewById(this.textViewIds[i]);
                    this.currentText = textView2;
                    if (textView2 != null) {
                        textView2.setTextColor(Color.parseColor("#FFFFFF"));
                    }
                    Log.d(TAG, "第" + i + "个进度条失去焦点");
                } else if (!this.inSeekbarKnobMode) {
                    this.inSeekbarKnobMode = true;
                    this.currentView.setSelected(false);
                    if (this.rootView.findViewById(this.seekbarIds[i]) instanceof MySeekbar1) {
                        MySeekbar1 mySeekbar12 = (MySeekbar1) this.rootView.findViewById(this.seekbarIds[i]);
                        this.currentMySeekbar = mySeekbar12;
                        this.seekBarProgress = mySeekbar12.getCurrentProgress();
                    } else {
                        SeekBar seekBar = (SeekBar) this.rootView.findViewById(this.seekbarIds[i]);
                        this.currentSeekbar = seekBar;
                        seekBar.setSelected(true);
                        this.seekBarProgress = this.currentSeekbar.getProgress();
                    }
                    this.currentSeekBarString = this.seekBarStrings[i];
                    TextView textView3 = (TextView) this.rootView.findViewById(this.textViewIds[i]);
                    this.currentText = textView3;
                    if (textView3 != null) {
                        int i3 = this.m_iUIIndex;
                        if (i3 == 3) {
                            textView3.setTextColor(Color.parseColor("#5ac0ff"));
                        } else if (i3 != 4 || !BaseApp.isSmallResolution) {
                            this.currentText.setTextColor(Color.parseColor("#FF3300"));
                        } else {
                            this.currentText.setTextColor(Color.parseColor("#5c6058"));
                        }
                    }
                    Log.d(TAG, "第" + i + "个进度条获取焦点, progress = " + this.seekBarProgress);
                } else {
                    this.inSeekbarKnobMode = false;
                    this.currentView.setSelected(true);
                    SeekBar seekBar2 = this.currentSeekbar;
                    if (seekBar2 != null) {
                        seekBar2.setSelected(false);
                        this.currentSeekbar = null;
                    }
                    if (this.currentMySeekbar != null) {
                        this.currentMySeekbar = null;
                    }
                    this.seekBarProgress = 0;
                    TextView textView4 = (TextView) this.rootView.findViewById(this.textViewIds[i]);
                    this.currentText = textView4;
                    if (textView4 != null) {
                        textView4.setTextColor(Color.parseColor("#FFFFFF"));
                    }
                    Log.d(TAG, "第" + i + "个进度条失去焦点");
                }
            }
        }
    }

    private void enterFragmentVolSet_KSW(int i) {
        if (i >= 0) {
            View view = this.currentFragment.getView();
            this.rootView = view;
            if (view != null) {
                int i2 = this.m_iUIIndex;
                if (i2 != 6 && i2 != 3 && !isDefaultUI() && (this.m_iUIIndex != 4 || !BaseApp.isSmallResolution)) {
                    View findViewById = this.rootView.findViewById(this.focusViewIds.get(i).intValue());
                    this.currentView = findViewById;
                    findViewById.performClick();
                } else if (i < 3) {
                    CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.chkUser);
                    if (checkBox == null || checkBox.isChecked()) {
                        View findViewById2 = this.rootView.findViewById(this.focusViewIds.get(i).intValue());
                        this.currentView = findViewById2;
                        if (!this.inSeekbarKnobMode) {
                            this.inSeekbarKnobMode = true;
                            findViewById2.setSelected(false);
                            int i3 = this.m_iUIIndex;
                            if (i3 == 6 || i3 == 4) {
                                MySeekbar1 mySeekbar1 = (MySeekbar1) this.rootView.findViewById(this.seekbarIds[i]);
                                this.currentMySeekbar = mySeekbar1;
                                this.seekBarProgress = mySeekbar1.getCurrentProgress();
                            } else {
                                SeekBar seekBar = (SeekBar) this.rootView.findViewById(this.seekbarIds[i]);
                                this.currentSeekbar = seekBar;
                                seekBar.setSelected(true);
                                this.seekBarProgress = this.currentSeekbar.getProgress();
                            }
                            this.currentSeekBarString = this.seekBarStrings[i];
                            TextView textView = (TextView) this.rootView.findViewById(this.textViewIds[i]);
                            this.currentText = textView;
                            if (textView != null) {
                                int i4 = this.m_iUIIndex;
                                if (i4 == 3) {
                                    textView.setTextColor(Color.parseColor("#5ac0ff"));
                                } else if (i4 == 4) {
                                    textView.setTextColor(Color.parseColor("#5c6058"));
                                } else {
                                    textView.setTextColor(Color.parseColor("#FF3300"));
                                }
                            }
                            Log.d(TAG, "第" + i + "个进度条获取焦点, progress = " + this.seekBarProgress);
                            return;
                        }
                        this.inSeekbarKnobMode = false;
                        findViewById2.setSelected(true);
                        int i5 = this.m_iUIIndex;
                        if (i5 == 6 || i5 == 4) {
                            this.currentMySeekbar = null;
                        } else {
                            this.currentSeekbar.setSelected(false);
                            this.currentSeekbar = null;
                        }
                        this.seekBarProgress = 0;
                        TextView textView2 = (TextView) this.rootView.findViewById(this.textViewIds[i]);
                        this.currentText = textView2;
                        if (textView2 != null) {
                            textView2.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        Log.d(TAG, "第" + i + "个进度条失去焦点");
                    }
                } else {
                    View findViewById3 = this.rootView.findViewById(this.focusViewIds.get(i).intValue());
                    this.currentView = findViewById3;
                    if ((findViewById3 instanceof ImageButton) || (findViewById3 instanceof Button)) {
                        findViewById3.performClick();
                    }
                }
            }
        }
    }

    private void enterFragmentDataTimer(int i) {
        if (i >= 0) {
            View view = this.currentFragment.getView();
            this.rootView = view;
            if (view != null) {
                View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
                this.currentView = findViewById;
                if ((findViewById instanceof ImageButton) || (findViewById instanceof Button)) {
                    findViewById.performClick();
                }
            }
        }
    }

    private void enterFragmentStartCode(int i) {
        if (i >= 0) {
            View view = this.currentFragment.getView();
            this.rootView = view;
            if (view != null) {
                View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
                this.currentView = findViewById;
                if ((findViewById instanceof ImageButton) || (findViewById instanceof Button)) {
                    findViewById.performClick();
                }
            }
        }
    }

    private void enterFragmentSysInfor(int i) {
        if (i >= 0) {
            View view = this.currentFragment.getView();
            this.rootView = view;
            if (view != null) {
                View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
                this.currentView = findViewById;
                if ((findViewById instanceof ImageButton) || (findViewById instanceof Button)) {
                    findViewById.performClick();
                    if (this.currentView.getId() == R.id.btn_mcu_upgrade) {
                        this.currentView.setSelected(false);
                        this.showMCUUpgradeView = true;
                    }
                }
            }
        }
    }

    private void refreshFragmentSystemSet_BackCar(int i, boolean z) {
        if (this.rootView != null) {
            int i2 = i;
            int size = i2 >= this.focusViewIds.size() ? this.focusViewIds.size() - 1 : i2;
            if (this.m_iUIIndex == 2 && this.rootView.findViewById(this.focusViewIds.get(0).intValue()) == null) {
                this.mainActivity.updateFocusViewDelay(size);
                return;
            }
            int i3 = 0;
            while (i3 < this.focusViewIds.size()) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i3).intValue());
                this.currentView = findViewById;
                if (findViewById != null) {
                    findViewById.setSelected(i3 == size);
                }
                i3++;
            }
            ScrollView scrollView = (ScrollView) this.rootView.findViewById(R.id.mBackCarScrollView);
            if (scrollView != null && z) {
                if (BaseApp.mProductIndex > 0) {
                    if (size >= 4) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, (int) GyroScopeWithCompassView.CARTYPE_KOLEOS_HI));
                    } else {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 0));
                    }
                } else if (!this.mShowAndroidCameraType) {
                    int i4 = this.m_iUIIndex;
                    if (i4 == 3 || i4 == 1) {
                        if (size >= 9) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1100));
                        } else if (size >= 5) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 588));
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    } else if (i4 == 2) {
                        if (size >= 11) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1238));
                        } else if (size >= 8) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 892));
                        } else if (size >= 5) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 483));
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    } else if (i4 == 6) {
                        if (size >= 12) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1119));
                        } else if (size >= 8) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 773));
                        } else if (size >= 5) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 429));
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    } else if (i4 == 4) {
                        if (size >= 13) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1200));
                        } else if (size >= 9) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 959));
                        } else if (size >= 5) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 478));
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    } else if (i4 != 7) {
                    } else {
                        if (size >= 14) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1079));
                        } else if (size >= 9) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 946));
                        } else if (size >= 5) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 471));
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    }
                } else if (this.m_iUIIndex != 3 && !isDefaultUI()) {
                    int i5 = this.m_iUIIndex;
                    if (i5 == 2) {
                        if (size >= 14) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1437));
                        } else if (size >= 12) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1188));
                        } else if (size >= 8) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 892));
                        } else if (size >= 5) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 483));
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    } else if (i5 == 6) {
                        if (size >= 15) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1291));
                        } else if (size >= 12) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1029));
                        } else if (size >= 8) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 773));
                        } else if (size >= 5) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 429));
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    } else if (i5 == 4) {
                        if (size >= 15) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1387));
                        } else if (size >= 12) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1152));
                        } else if (size >= 9) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 862));
                        } else if (size >= 5) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 478));
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    } else if (i5 != 7) {
                    } else {
                        if (size >= 13) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1269));
                        } else if (size >= 10) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 845));
                        } else if (size >= 5) {
                            scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 471));
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    }
                } else if (size >= 11) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 1203));
                } else if (size >= 5) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 586));
                } else {
                    scrollView.scrollTo(0, 0);
                }
            }
        }
    }

    private void refreshFragmentSystemSet_Display(int i) {
        if (this.m_iUIIndex == 2 && this.rootView.findViewById(this.focusViewIds.get(0).intValue()) == null) {
            this.mainActivity.updateFocusViewDelay(i);
        } else if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            int i2 = 0;
            while (i2 < this.focusViewIds.size()) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                this.currentView = findViewById;
                if (findViewById != null) {
                    findViewById.setSelected(i2 == i);
                }
                i2++;
            }
        }
    }

    private void refreshFragmentSystemSet_BT(int i) {
        if (this.m_iUIIndex == 2 && this.rootView.findViewById(this.focusViewIds.get(0).intValue()) == null) {
            this.mainActivity.updateFocusViewDelay(i);
        } else if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            int i2 = 0;
            while (i2 < this.focusViewIds.size()) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                this.currentView = findViewById;
                if (findViewById != null) {
                    findViewById.setSelected(i2 == i);
                }
                i2++;
            }
        }
    }

    private void refreshFragmentSystemSet_Unit(int i, boolean z) {
        if (this.m_iUIIndex == 2 && this.rootView.findViewById(this.focusViewIds.get(0).intValue()) == null) {
            this.mainActivity.updateFocusViewDelay(i);
        } else if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            int i2 = 0;
            while (i2 < this.focusViewIds.size()) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                this.currentView = findViewById;
                if (findViewById != null) {
                    findViewById.setSelected(i2 == i);
                }
                i2++;
            }
            ScrollView scrollView = (ScrollView) this.rootView.findViewById(R.id.mScrollView);
            if (scrollView != null && z) {
                int i3 = this.m_iUIIndex;
                if (i3 == 3 || i3 == 1) {
                    if (i >= 5) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 512));
                    } else {
                        scrollView.scrollTo(0, 0);
                    }
                } else if (i3 == 2) {
                    if (i >= 3) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 720));
                    } else {
                        scrollView.scrollTo(0, 0);
                    }
                } else if (i3 == 6) {
                    if (i >= 5) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 431));
                    } else if (i >= 3) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 426));
                    } else {
                        scrollView.scrollTo(0, 0);
                    }
                } else if (i3 == 4) {
                    if (i >= 5) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 435));
                    } else if (i >= 3) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 286));
                    } else {
                        scrollView.scrollTo(0, 0);
                    }
                } else if (i3 != 7) {
                } else {
                    if (i >= 4) {
                        scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 319));
                    } else {
                        scrollView.scrollTo(0, 0);
                    }
                }
            }
        }
    }

    private void refreshFragmentSystemSet_Dvr(int i) {
        if (this.m_iUIIndex == 2 && this.rootView.findViewById(this.focusViewIds.get(0).intValue()) == null) {
            this.mainActivity.updateFocusViewDelay(i);
        } else if (this.rootView != null) {
            AppListAdapter adapter = ((FragmentSystemSet_Dvr) this.currentFragment).getAdapter();
            if (i < this.focusViewIds.size()) {
                int i2 = 0;
                while (i2 < this.focusViewIds.size()) {
                    View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                    this.currentView = findViewById;
                    if (findViewById != null) {
                        findViewById.setSelected(i2 == i);
                    }
                    i2++;
                }
                if (adapter != null) {
                    adapter.setFocusIndex(-1);
                    return;
                }
                return;
            }
            for (int i3 = 0; i3 < this.focusViewIds.size(); i3++) {
                View findViewById2 = this.rootView.findViewById(this.focusViewIds.get(i3).intValue());
                if (findViewById2 != null && findViewById2.isSelected()) {
                    findViewById2.setSelected(false);
                }
            }
            if (adapter != null) {
                adapter.setFocusIndex(i - this.focusViewIds.size());
            }
            RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.appList);
            this.currentRecycleView = recyclerView;
            recyclerView.smoothScrollToPosition(i - this.focusViewIds.size());
        }
    }

    private void refreshFragmentSystemSet_AUX(int i, boolean z) {
        if (this.m_iUIIndex == 2 && this.rootView.findViewById(this.focusViewIds.get(0).intValue()) == null) {
            this.mainActivity.updateFocusViewDelay(i);
        } else if (this.rootView != null) {
            if (i >= this.focusViewIds.size()) {
                i = this.focusViewIds.size() - 1;
            }
            int i2 = 0;
            while (i2 < this.focusViewIds.size()) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                this.currentView = findViewById;
                if (findViewById != null) {
                    findViewById.setSelected(i2 == i);
                }
                i2++;
            }
            ScrollView scrollView = (ScrollView) this.rootView.findViewById(R.id.mScrollView);
            if (scrollView != null && z) {
                if (i >= 4) {
                    scrollView.scrollTo(0, EventUtils.pxToDp(this.resolution, 512));
                } else {
                    scrollView.scrollTo(0, 0);
                }
            }
        }
    }

    private void refreshFragmentSet_MusicPlayer(int i) {
        View view = this.rootView;
        if (view != null) {
            this.currentRecycleView = (RecyclerView) view.findViewById(R.id.appList);
            AppListAdapter adapter = ((FragmentSystemSet_MusicPlayer) this.currentFragment).getAdapter();
            if (adapter == null) {
                this.mainActivity.updateFocusViewDelay(i);
                return;
            }
            adapter.setFocusIndex(i);
            RecyclerView recyclerView = this.currentRecycleView;
            if (recyclerView != null && i >= 0) {
                recyclerView.smoothScrollToPosition(i);
            }
        }
    }

    private void refreshFragmentSet_VideoPlayer(int i) {
        View view = this.rootView;
        if (view != null) {
            this.currentRecycleView = (RecyclerView) view.findViewById(R.id.appList);
            AppListAdapter adapter = ((FragmentSystemSet_VideoPlayer) this.currentFragment).getAdapter();
            if (adapter == null) {
                this.mainActivity.updateFocusViewDelay(i);
                return;
            }
            adapter.setFocusIndex(i);
            RecyclerView recyclerView = this.currentRecycleView;
            if (recyclerView != null && i >= 0) {
                recyclerView.smoothScrollToPosition(i);
            }
        }
    }

    private void refreshFragmentSet_Other(int i) {
        if (this.m_iUIIndex == 2 && this.rootView.findViewById(this.focusViewIds.get(0).intValue()) == null) {
            this.mainActivity.updateFocusViewDelay(i);
        } else if (this.rootView != null) {
            int i2 = 0;
            while (i2 < this.focusViewIds.size()) {
                View findViewById = this.rootView.findViewById(this.focusViewIds.get(i2).intValue());
                this.currentView = findViewById;
                if (findViewById != null) {
                    findViewById.setSelected(i2 == i);
                }
                i2++;
            }
        }
    }

    private void enterFragmentSystemSet_BackCar(int i) {
        View view;
        if (i >= 0 && (view = this.rootView) != null) {
            View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
            this.currentView = findViewById;
            findViewById.performClick();
        }
    }

    private void enterFragmentSystemSet_Display(int i) {
        View view;
        if (i >= 0 && (view = this.rootView) != null) {
            View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
            this.currentView = findViewById;
            int i2 = this.m_iUIIndex;
            if (i2 == 3 || i2 == 1) {
                if (i < 2) {
                    findViewById.performClick();
                } else if (!this.inSeekbarKnobMode) {
                    this.inSeekbarKnobMode = true;
                    findViewById.setSelected(false);
                    SeekBar seekBar = (SeekBar) this.rootView.findViewById(this.seekbarIds[0]);
                    this.currentSeekbar = seekBar;
                    seekBar.setSelected(true);
                    this.currentSeekBarString = this.seekBarStrings[0];
                    this.seekBarProgress = this.currentSeekbar.getProgress();
                    this.currentText = (TextView) this.rootView.findViewById(R.id.KSW_BL_val);
                    this.tvPercent = (TextView) this.rootView.findViewById(R.id.TvPercent);
                    TextView textView = this.currentText;
                    if (textView != null) {
                        if (this.m_iUIIndex == 3) {
                            textView.setTextColor(Color.parseColor("#5ac0ff"));
                        } else {
                            textView.setTextColor(Color.parseColor("#FF3300"));
                        }
                    }
                    TextView textView2 = this.tvPercent;
                    if (textView2 == null) {
                        return;
                    }
                    if (this.m_iUIIndex == 3) {
                        textView2.setTextColor(Color.parseColor("#5ac0ff"));
                    } else {
                        textView2.setTextColor(Color.parseColor("#FF3300"));
                    }
                } else {
                    this.inSeekbarKnobMode = false;
                    findViewById.setSelected(true);
                    this.currentSeekbar.setSelected(false);
                    this.currentSeekbar = null;
                    this.seekBarProgress = 0;
                    TextView textView3 = this.currentText;
                    if (textView3 != null) {
                        textView3.setTextColor(-1);
                    }
                    TextView textView4 = this.tvPercent;
                    if (textView4 != null) {
                        textView4.setTextColor(-1);
                    }
                    this.currentText = null;
                }
            } else if (i < 2) {
                findViewById.performClick();
            } else if (!this.inSeekbarKnobMode) {
                this.inSeekbarKnobMode = true;
                findViewById.setSelected(false);
                this.currentMySeekbar = (MySeekbar1) this.rootView.findViewById(this.seekbarIds[0]);
                TextView textView5 = (TextView) this.rootView.findViewById(R.id.KSW_BL_val);
                this.currentText = textView5;
                if (textView5 != null) {
                    int i3 = this.m_iUIIndex;
                    if (i3 == 2) {
                        textView5.setTextColor(this.mainActivity.getColor(getAttrId(R.attr.ksw_id8_fontColor)));
                    } else if (i3 == 6) {
                        textView5.setTextColor(Color.parseColor("#FF3300"));
                    } else if (i3 == 4) {
                        textView5.setTextColor(Color.parseColor("#BFB849"));
                    } else if (i3 == 7) {
                        textView5.setTextColor(Color.parseColor("#9cc5e6"));
                    }
                }
                this.seekBarProgress = this.currentMySeekbar.getCurrentProgress();
            } else {
                this.inSeekbarKnobMode = false;
                findViewById.setSelected(true);
                TextView textView6 = this.currentText;
                if (textView6 != null) {
                    textView6.setTextColor(-1);
                    this.currentText = null;
                }
                this.currentMySeekbar = null;
                this.seekBarProgress = 0;
            }
        }
    }

    private void enterFragmentSystemSet_BT(int i) {
        View view;
        if (i >= 0 && (view = this.rootView) != null) {
            View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
            this.currentView = findViewById;
            findViewById.performClick();
        }
    }

    private void enterFragmentSystemSet_Unit(int i) {
        View view;
        if (i >= 0 && (view = this.rootView) != null) {
            View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
            this.currentView = findViewById;
            findViewById.performClick();
        }
    }

    private void enterFragmentSystemSet_Dvr(int i) {
        View view;
        if (i < 0 || (view = this.rootView) == null) {
            return;
        }
        if (i <= 2) {
            View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
            this.currentView = findViewById;
            findViewById.performClick();
            return;
        }
        AppListAdapter adapter = ((FragmentSystemSet_Dvr) this.currentFragment).getAdapter();
        adapter.getOnItemClickListener().onItemClick(i - 3);
        adapter.notifyDataSetChanged();
    }

    private void enterFragmentSystemSet_AUX(int i) {
        View view;
        if (i >= 0 && (view = this.rootView) != null) {
            View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
            this.currentView = findViewById;
            if (i <= 3) {
                findViewById.performClick();
            } else if (!this.inSeekbarKnobMode) {
                this.inSeekbarKnobMode = true;
                findViewById.setSelected(false);
                int i2 = i - 4;
                this.currentSeekBarString = this.seekBarStrings[i2];
                TextView textView = (TextView) this.rootView.findViewById(this.textViewIds[i2]);
                this.currentText = textView;
                if (textView != null) {
                    int i3 = this.m_iUIIndex;
                    if (i3 == 3) {
                        textView.setTextColor(Color.parseColor("#5ac0ff"));
                    } else if (i3 == 2) {
                        textView.setTextColor(this.mainActivity.getColor(getAttrId(R.attr.ksw_id8_fontColor)));
                    } else if (i3 == 4) {
                        if (BaseApp.isSmallResolution) {
                            this.currentText.setTextColor(Color.parseColor("#5c6058"));
                        } else {
                            this.currentText.setTextColor(Color.parseColor("#BFB849"));
                        }
                    } else if (i3 == 7) {
                        textView.setTextColor(Color.parseColor("#9cc5e6"));
                    } else {
                        textView.setTextColor(Color.parseColor("#FF3300"));
                    }
                }
                int i4 = this.m_iUIIndex;
                if (i4 == 3 || i4 == 1) {
                    SeekBar seekBar = (SeekBar) this.rootView.findViewById(this.seekbarIds[i2]);
                    this.currentSeekbar = seekBar;
                    seekBar.setSelected(true);
                    this.seekBarProgress = this.currentSeekbar.getProgress();
                    return;
                }
                MySeekbar1 mySeekbar1 = (MySeekbar1) this.rootView.findViewById(this.seekbarIds[i2]);
                this.currentMySeekbar = mySeekbar1;
                this.seekBarProgress = mySeekbar1.getCurrentProgress();
            } else {
                this.inSeekbarKnobMode = false;
                findViewById.setSelected(true);
                this.seekBarProgress = 0;
                TextView textView2 = this.currentText;
                if (textView2 != null) {
                    textView2.setTextColor(-1);
                    this.currentText = null;
                }
                int i5 = this.m_iUIIndex;
                if (i5 == 3 || i5 == 1) {
                    this.currentSeekbar.setSelected(false);
                    this.currentSeekbar = null;
                    return;
                }
                this.currentMySeekbar = null;
            }
        }
    }

    private void enterFragmentSet_MusicPlayer(int i) {
        AppListAdapter adapter = ((FragmentSystemSet_MusicPlayer) this.currentFragment).getAdapter();
        adapter.getOnItemClickListener().onItemClick(i);
        adapter.notifyDataSetChanged();
    }

    private void enterFragmentSet_VideoPlayer(int i) {
        AppListAdapter adapter = ((FragmentSystemSet_VideoPlayer) this.currentFragment).getAdapter();
        adapter.getOnItemClickListener().onItemClick(i);
        adapter.notifyDataSetChanged();
    }

    private void enterFragmentSet_Other(int i) {
        View view;
        if (i >= 0 && (view = this.rootView) != null) {
            View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
            this.currentView = findViewById;
            if (findViewById != null) {
                findViewById.performClick();
            }
        }
    }

    private void enterFragmentVolSet_KSWThird(int i) {
        View view;
        if (i >= 0) {
            int i2 = this.m_iUIIndex;
            if ((i2 == 2 || i2 == 4 || i2 == 7) && (view = this.rootView) != null) {
                View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
                this.currentView = findViewById;
                int i3 = this.m_iUIIndex;
                if (i3 == 2 || i3 == 7) {
                    int i4 = this.mainActivity.lastYFocus;
                    if (i4 == 0) {
                        this.seekbarIds = new int[]{R.id.my_seekbar1_00, R.id.my_seekbar1_01};
                        int[] iArr = {R.id.KSW_Vol_val_00, R.id.KSW_Vol_val_01};
                        if (!this.inSeekbarKnobMode) {
                            this.inSeekbarKnobMode = true;
                            this.currentView.setSelected(false);
                            this.currentMySeekbar = (MySeekbar1) this.rootView.findViewById(this.seekbarIds[i]);
                            TextView textView = (TextView) this.rootView.findViewById(iArr[i]);
                            this.currentText = textView;
                            if (textView != null) {
                                if (this.m_iUIIndex == 2) {
                                    textView.setTextColor(this.mainActivity.getColor(getAttrId(R.attr.ksw_id8_fontColor)));
                                } else {
                                    textView.setTextColor(Color.parseColor("#9cc5e6"));
                                }
                            }
                            this.seekBarProgress = this.currentMySeekbar.getCurrentProgress();
                            return;
                        }
                        this.inSeekbarKnobMode = false;
                        this.currentView.setSelected(true);
                        TextView textView2 = this.currentText;
                        if (textView2 != null) {
                            textView2.setTextColor(-1);
                            this.currentText = null;
                        }
                        this.currentMySeekbar = null;
                        this.seekBarProgress = 0;
                    } else if (i4 == 1) {
                        this.seekbarIds = new int[]{R.id.my_seekbar1_03, R.id.my_seekbar1_04};
                        int[] iArr2 = {R.id.KSW_Vol_val_03, R.id.KSW_Vol_val_04};
                        if (!this.inSeekbarKnobMode) {
                            this.inSeekbarKnobMode = true;
                            this.currentView.setSelected(false);
                            this.currentMySeekbar = (MySeekbar1) this.rootView.findViewById(this.seekbarIds[i]);
                            TextView textView3 = (TextView) this.rootView.findViewById(iArr2[i]);
                            this.currentText = textView3;
                            if (this.m_iUIIndex == 2) {
                                textView3.setTextColor(this.mainActivity.getColor(getAttrId(R.attr.ksw_id8_fontColor)));
                            } else {
                                textView3.setTextColor(Color.parseColor("#9cc5e6"));
                            }
                            this.seekBarProgress = this.currentMySeekbar.getCurrentProgress();
                            return;
                        }
                        this.inSeekbarKnobMode = false;
                        this.currentView.setSelected(true);
                        TextView textView4 = this.currentText;
                        if (textView4 != null) {
                            textView4.setTextColor(-1);
                            this.currentText = null;
                        }
                        this.currentMySeekbar = null;
                        this.seekBarProgress = 0;
                    } else if (i4 == 2) {
                        if (this.m_iUIIndex == 2) {
                            View findViewById2 = this.rootView.findViewById(R.id.viewUser);
                            if (findViewById2 == null) {
                                return;
                            }
                            if (findViewById2.getVisibility() != 0 || i <= 0) {
                                View view2 = this.currentView;
                                if (view2 != null) {
                                    view2.performClick();
                                    return;
                                }
                                return;
                            }
                            this.seekbarIds = new int[]{R.id.my_seekbar2_bass, R.id.my_seekbar2_alto, R.id.my_seekbar2_treble};
                            int[] iArr3 = {R.id.KSW_VolValue_Bass, R.id.KSW_VolValue_Alto, R.id.KSW_VolValue_Treble};
                            if (!this.inSeekbarKnobMode) {
                                this.inSeekbarKnobMode = true;
                                this.currentView.setSelected(false);
                                int i5 = i - 1;
                                this.currentMySeekbar2 = (MySeekbar2) this.rootView.findViewById(this.seekbarIds[i5]);
                                TextView textView5 = (TextView) this.rootView.findViewById(iArr3[i5]);
                                this.currentText = textView5;
                                if (textView5 != null) {
                                    textView5.setTextColor(this.mainActivity.getColor(getAttrId(R.attr.ksw_id8_fontColor)));
                                }
                                this.seekBarProgress = this.currentMySeekbar2.getCurrentProgress();
                                return;
                            }
                            this.inSeekbarKnobMode = false;
                            this.currentView.setSelected(true);
                            TextView textView6 = this.currentText;
                            if (textView6 != null) {
                                textView6.setTextColor(-1);
                                this.currentText = null;
                            }
                            this.currentMySeekbar2 = null;
                            this.seekBarProgress = 0;
                            return;
                        }
                        int[] iArr4 = {R.id.my_seekbar1_bass, R.id.my_seekbar1_alto, R.id.my_seekbar1_treble};
                        this.seekbarIds = iArr4;
                        int[] iArr5 = {R.id.KSW_VolValue_Bass, R.id.KSW_VolValue_Alto, R.id.KSW_VolValue_Treble};
                        if (i < iArr4.length) {
                            CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.chkUser);
                            if (checkBox != null && !checkBox.isChecked()) {
                                return;
                            }
                            if (!this.inSeekbarKnobMode) {
                                this.inSeekbarKnobMode = true;
                                this.currentView.setSelected(false);
                                this.currentMySeekbar = (MySeekbar1) this.rootView.findViewById(this.seekbarIds[i]);
                                TextView textView7 = (TextView) this.rootView.findViewById(iArr5[i]);
                                this.currentText = textView7;
                                if (textView7 != null) {
                                    textView7.setTextColor(Color.parseColor("#9cc5e6"));
                                }
                                this.seekBarProgress = this.currentMySeekbar.getCurrentProgress();
                                return;
                            }
                            this.inSeekbarKnobMode = false;
                            this.currentView.setSelected(true);
                            this.currentMySeekbar = null;
                            this.seekBarProgress = 0;
                            TextView textView8 = (TextView) this.rootView.findViewById(iArr5[i]);
                            this.currentText = textView8;
                            if (textView8 != null) {
                                textView8.setTextColor(Color.parseColor("#FFFFFF"));
                                return;
                            }
                            return;
                        }
                        View findViewById3 = this.rootView.findViewById(this.focusViewIds.get(i).intValue());
                        this.currentView = findViewById3;
                        if ((findViewById3 instanceof ImageButton) || (findViewById3 instanceof Button)) {
                            findViewById3.performClick();
                        }
                    }
                } else if (!this.inSeekbarKnobMode) {
                    this.inSeekbarKnobMode = true;
                    findViewById.setSelected(false);
                    this.currentSeekBarString = this.seekBarStrings[i];
                    TextView textView9 = (TextView) this.rootView.findViewById(this.textViewIds[i]);
                    this.currentText = textView9;
                    if (textView9 != null) {
                        textView9.setTextColor(Color.parseColor("#BFB849"));
                    }
                    MySeekbar1 mySeekbar1 = (MySeekbar1) this.rootView.findViewById(this.seekbarIds[i]);
                    this.currentMySeekbar = mySeekbar1;
                    this.seekBarProgress = mySeekbar1.getCurrentProgress();
                } else {
                    this.inSeekbarKnobMode = false;
                    findViewById.setSelected(true);
                    this.seekBarProgress = 0;
                    TextView textView10 = this.currentText;
                    if (textView10 != null) {
                        textView10.setTextColor(-1);
                        this.currentText = null;
                    }
                    this.currentMySeekbar = null;
                }
            }
        }
    }

    private void enterFragmentDataTimerThird(int i) {
        if (i >= 0) {
            if (this.m_iUIIndex == 7) {
                this.focusViewIds = new ArrayList();
                if (this.mainActivity.lastYFocus == 0) {
                    this.focusViewIds.add(Integer.valueOf(R.id.btnOriginalTime));
                    this.focusViewIds.add(Integer.valueOf(R.id.btnAutoSync));
                } else {
                    this.focusViewIds.add(Integer.valueOf(R.id.btn12Hour));
                    this.focusViewIds.add(Integer.valueOf(R.id.btn24Hour));
                }
            }
            View view = this.currentFragment.getView();
            this.rootView = view;
            if (view != null) {
                View findViewById = view.findViewById(this.focusViewIds.get(i).intValue());
                this.currentView = findViewById;
                if ((findViewById != null && (findViewById instanceof ImageButton)) || (findViewById instanceof Button)) {
                    findViewById.performClick();
                }
            }
        }
    }

    public void refreshSeekbar(int i) {
        int i2 = this.m_iUIIndex;
        if (i2 == 3 || i2 == 1) {
            if (i == 8) {
                if (this.seekBarProgress < this.currentSeekbar.getMax()) {
                    this.seekBarProgress++;
                }
            } else if (this.seekBarProgress > this.currentSeekbar.getMin()) {
                this.seekBarProgress--;
            }
            SeekBar seekBar = this.currentSeekbar;
            if (seekBar != null) {
                seekBar.setProgress(this.seekBarProgress);
                try {
                    if (this.tag.equals("SystemSet_AUX")) {
                        SysProviderOpt.getInstance(this.mainActivity).updateRecord(this.currentSeekBarString, this.currentSeekbar.getProgress() + "");
                    } else if (this.tag.equals("FragmentVolSet_KSW")) {
                        this.mService.putSettingInt(this.currentSeekBarString, this.currentSeekbar.getProgress() - 12);
                    } else {
                        this.mService.putSettingInt(this.currentSeekBarString, this.currentSeekbar.getProgress());
                    }
                    this.mService.appySetting();
                    this.mService.commitSetting();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        } else {
            MySeekbar1 mySeekbar1 = this.currentMySeekbar;
            if (mySeekbar1 != null) {
                if (i == 8) {
                    if (this.seekBarProgress < mySeekbar1.getMaxProgress()) {
                        this.seekBarProgress++;
                    }
                } else if (this.seekBarProgress > mySeekbar1.getMinProgress()) {
                    this.seekBarProgress--;
                }
                this.currentMySeekbar.setCurrentProgressStop(this.seekBarProgress);
                TextView textView = this.currentText;
                if (textView != null) {
                    int i3 = this.m_iUIIndex;
                    if (i3 == 2) {
                        textView.setTextColor(this.mainActivity.getColor(getAttrId(R.attr.ksw_id8_fontColor)));
                    } else if (i3 == 6) {
                        textView.setTextColor(Color.parseColor("#FF3300"));
                    } else if (i3 != 4) {
                    } else {
                        if (BaseApp.isSmallResolution) {
                            this.currentText.setTextColor(Color.parseColor("#5c6058"));
                        } else {
                            this.currentText.setTextColor(Color.parseColor("#BFB849"));
                        }
                    }
                }
            } else {
                MySeekbar2 mySeekbar2 = this.currentMySeekbar2;
                if (mySeekbar2 != null) {
                    if (i == 8) {
                        if (this.seekBarProgress < mySeekbar2.getMaxProgress()) {
                            this.seekBarProgress++;
                        }
                    } else if (this.seekBarProgress > mySeekbar2.getMinProgress()) {
                        this.seekBarProgress--;
                    }
                    this.currentMySeekbar2.setCurrentProgressStop(this.seekBarProgress);
                    TextView textView2 = this.currentText;
                    if (textView2 != null) {
                        textView2.setTextColor(this.mainActivity.getColor(getAttrId(R.attr.ksw_id8_fontColor)));
                    }
                }
            }
        }
    }

    public void setViewPageCurItem(int i) {
        if (i >= 0) {
            locateFragment(this.fragmentSystemNew.fragments.get(i), ((FragmentBase) this.fragmentSystemNew.fragments.get(i)).getFragmentTag());
            ((FragmentBase) this.fragmentSystemNew.fragments.get(i)).addViewIds();
        }
    }

    public boolean showNavSelectView() {
        View findViewById;
        Fragment fragment = this.currentFragment;
        if (fragment == null) {
            return false;
        }
        View view = fragment.getView();
        this.rootView = view;
        if (view == null || (findViewById = view.findViewById(R.id.LytMsgYesNo)) == null || findViewById.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void clearFocus() {
        if (this.mainActivity.hasKnob) {
            if (this.inSeekbarKnobMode) {
                this.inSeekbarKnobMode = false;
            }
            refreshThirdViews(-1, true);
            refreshSecondViews(-1, true);
        }
    }

    private int getAttrId(int i) {
        TypedValue typedValue = new TypedValue();
        this.mainActivity.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void clearSeekbarFocus() {
        this.inSeekbarKnobMode = false;
        this.seekBarProgress = 0;
        this.currentSeekBarString = "";
        SeekBar seekBar = this.currentSeekbar;
        if (seekBar != null) {
            seekBar.setSelected(false);
            this.currentSeekbar = null;
        }
        if (this.currentMySeekbar != null) {
            this.currentMySeekbar = null;
        }
        if (this.currentMySeekbar2 != null) {
            this.currentMySeekbar2 = null;
        }
        TextView textView = this.currentText;
        if (textView != null) {
            textView.setTextColor(Color.parseColor("#FFFFFF"));
        }
        TextView textView2 = this.tvPercent;
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    public boolean isDefaultUI() {
        return this.m_iUIIndex == 1 || this.m_iModeSet >= 100;
    }
}
