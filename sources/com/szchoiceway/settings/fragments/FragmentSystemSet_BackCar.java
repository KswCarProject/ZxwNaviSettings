package com.szchoiceway.settings.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemProperties;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.settings.fragments.FragmentSystemSet_BackCar;
import com.szchoiceway.settings.view.ClipScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import java.util.ArrayList;

public class FragmentSystemSet_BackCar extends FragmentBase implements View.OnClickListener {
    private static final String TAG = "SystemSet_BackCar";
    boolean b_kesaiwei_chk_BackcarMirror = false;
    boolean b_kesaiwei_chk_FrontMirror = false;
    boolean b_kesaiwei_chk_Mute = false;
    boolean b_kesaiwei_chk_Radar = false;
    boolean b_kesaiwei_chk_ReversingTrack = false;
    CheckBox chkAndroidCamera1080P = null;
    CheckBox chkAndroidCamera720P = null;
    int iAHDCameraType = 0;
    int iAndroidCameraType = 0;
    int i_kesaiwei_Camera_Selection = -1;
    CheckBox kesaiwei_Android_360 = null;
    CheckBox kesaiwei_Camera_360 = null;
    CheckBox kesaiwei_Camera_Original = null;
    CheckBox kesaiwei_Camera_install = null;
    CheckBox kesaiwei_chk_BackcarMirror = null;
    CheckBox kesaiwei_chk_FrontMirror = null;
    CheckBox kesaiwei_chk_Mute = null;
    CheckBox kesaiwei_chk_Radar = null;
    CheckBox kesaiwei_chk_ReversingTrack = null;
    CheckBox kesaiwei_chk_signal_AHD1080_25 = null;
    CheckBox kesaiwei_chk_signal_AHD1080_30 = null;
    CheckBox kesaiwei_chk_signal_AHD720_25 = null;
    CheckBox kesaiwei_chk_signal_AHD720_30 = null;
    CheckBox kesaiwei_chk_signal_CVBS_NTSC = null;
    CheckBox kesaiwei_chk_signal_CVBS_PAL = null;
    CheckBox kesaiwei_chk_signal_auto = null;
    /* access modifiers changed from: private */
    public ScrollView mBackCarScrollView;
    private MainActivity mMain;
    private View mMainView;
    boolean mNeedShowAndroidCameraType = false;
    private SysProviderOpt mProvider;
    private Toast mToast;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    /* access modifiers changed from: private */
    public View scrollLayout;
    /* access modifiers changed from: private */
    public int totalHeight = 0;
    View viewAndroid360CameraSelect;

    public String getFragmentTag() {
        return TAG;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        SysProviderOpt instance = SysProviderOpt.getInstance(context);
        this.mProvider = instance;
        this.b_kesaiwei_chk_BackcarMirror = instance.getRecordBoolean(SysProviderOpt.KESAIWEI_SYS_BACKCAR_MIRROR, this.b_kesaiwei_chk_BackcarMirror);
        this.b_kesaiwei_chk_FrontMirror = this.mProvider.getRecordBoolean(SysProviderOpt.KESAIWEI_SYS_FRONT_MIRROR, this.b_kesaiwei_chk_FrontMirror);
        this.b_kesaiwei_chk_ReversingTrack = this.mProvider.getRecordBoolean(SysProviderOpt.KESAIWEI_SYS_REVERSING_TRACK, this.b_kesaiwei_chk_ReversingTrack);
        this.b_kesaiwei_chk_Radar = this.mProvider.getRecordBoolean(SysProviderOpt.KESAIWEI_SYS_RADAR, this.b_kesaiwei_chk_Radar);
        this.b_kesaiwei_chk_Mute = this.mProvider.getRecordBoolean(SysProviderOpt.KSW_REVEERSING_MUTE_SELECT_INDEX, this.b_kesaiwei_chk_Mute);
        boolean z = false;
        this.i_kesaiwei_Camera_Selection = this.mProvider.getRecordInteger("KESAIWEI_SYS_CAMERA_SELECTION", 0);
        this.iAHDCameraType = this.mProvider.getRecordInteger(SysProviderOpt.KSW_AHD_CAMERA_TYPE, this.iAHDCameraType);
        this.iAndroidCameraType = this.mProvider.getRecordInteger(SysProviderOpt.KSW_ANDROID_CAMERA_TYPE, this.iAndroidCameraType);
        if (Build.VERSION.SDK_INT > 31 && this.i_kesaiwei_Camera_Selection == 3) {
            z = true;
        }
        this.mNeedShowAndroidCameraType = z;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        Log.d(TAG, "onCreateView");
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_backcar, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_backcar, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_backcar, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_backcar, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_backcar, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_backcar, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_backcar_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_backcar, (ViewGroup) null);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_backcar, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set_backcar, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_backcar, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_backcar, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_backcar, (ViewGroup) null);
        } else if (this.m_iUIIndex != 5) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_backcar, (ViewGroup) null);
        } else if (this.m_iModeSet == 32) {
            view = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_backcar, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_backcar, (ViewGroup) null);
        }
        this.mMainView = view;
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void onResume() {
        super.onResume();
        if (this.mMainView == null) {
            this.mMainView = getView();
        }
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mMain = mainActivity;
        this.baseApp = (BaseApp) mainActivity.getApplication();
        this.myScrollbar = (MyScrollbar) view.findViewById(R.id.myScrollbar);
        this.mBackCarScrollView = (ScrollView) view.findViewById(R.id.mBackCarScrollView);
        View findViewById = view.findViewById(R.id.scrollLayout);
        this.scrollLayout = findViewById;
        if (findViewById != null) {
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    FragmentSystemSet_BackCar.this.scrollLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    FragmentSystemSet_BackCar fragmentSystemSet_BackCar = FragmentSystemSet_BackCar.this;
                    int unused = fragmentSystemSet_BackCar.totalHeight = fragmentSystemSet_BackCar.scrollLayout.getHeight();
                    if (FragmentSystemSet_BackCar.this.mBackCarScrollView != null) {
                        FragmentSystemSet_BackCar.this.mBackCarScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                                FragmentSystemSet_BackCar.AnonymousClass1.this.lambda$onGlobalLayout$0$FragmentSystemSet_BackCar$1(view, i, i2, i3, i4);
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onGlobalLayout$0$FragmentSystemSet_BackCar$1(View view, int i, int i2, int i3, int i4) {
                    Log.d(FragmentSystemSet_BackCar.TAG, "scrollY = " + i2);
                    float access$100 = (((float) i2) * 1.0f) / ((float) (FragmentSystemSet_BackCar.this.totalHeight - FragmentSystemSet_BackCar.this.mBackCarScrollView.getHeight()));
                    if (FragmentSystemSet_BackCar.this.myScrollbar != null) {
                        FragmentSystemSet_BackCar.this.myScrollbar.setCurrentPercent(access$100);
                    }
                    if (FragmentSystemSet_BackCar.this.mBackCarScrollView instanceof ClipScrollView) {
                        ((ClipScrollView) FragmentSystemSet_BackCar.this.mBackCarScrollView).setScrollHeight(i2);
                    }
                }
            });
        }
        int[] iArr = {R.id.btnFrontMirror, R.id.btnBackcarMirror, R.id.btnReversingTrack, R.id.btnRadar, R.id.btnMute, R.id.btnCameraInstall, R.id.btnCameraOriginal, R.id.btnCamera360, R.id.btnAndroid360, R.id.btnAndroid360_1080P, R.id.btnAndroid360_720P, R.id.btnSignal_auto, R.id.btnSignal_AHD1080_30, R.id.btnSignal_AHD1080_25, R.id.btnSignal_AHD720_30, R.id.btnSignal_AHD720_25, R.id.btnSignal_CVBS_NTSC, R.id.btnSignal_CVBS_PAL};
        for (int i = 0; i < 18; i++) {
            View findViewById2 = view.findViewById(iArr[i]);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(this);
            }
        }
        initBackCarChk();
        initCameraChk();
        initSignalTypeChk();
        initProductView();
    }

    private void initBackCarChk() {
        View view = this.mMainView;
        if (view != null) {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.kesaiwei_chk_BackcarMirror);
            this.kesaiwei_chk_BackcarMirror = checkBox;
            if (checkBox != null) {
                checkBox.setChecked(this.b_kesaiwei_chk_BackcarMirror);
            }
            CheckBox checkBox2 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_FrontMirror);
            this.kesaiwei_chk_FrontMirror = checkBox2;
            if (checkBox2 != null) {
                checkBox2.setChecked(this.b_kesaiwei_chk_FrontMirror);
            }
            CheckBox checkBox3 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_ReversingTrack);
            this.kesaiwei_chk_ReversingTrack = checkBox3;
            if (checkBox3 != null) {
                checkBox3.setChecked(this.b_kesaiwei_chk_ReversingTrack);
            }
            CheckBox checkBox4 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_Radar);
            this.kesaiwei_chk_Radar = checkBox4;
            if (checkBox4 != null) {
                checkBox4.setChecked(this.b_kesaiwei_chk_Radar);
            }
            CheckBox checkBox5 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_Mute);
            this.kesaiwei_chk_Mute = checkBox5;
            if (checkBox5 != null) {
                checkBox5.setChecked(this.b_kesaiwei_chk_Mute);
            }
        }
    }

    private void initCameraChk() {
        View view = this.mMainView;
        if (view != null) {
            this.kesaiwei_Camera_install = (CheckBox) view.findViewById(R.id.kesaiwei_Camera_Install);
            this.kesaiwei_Camera_Original = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_Camera_Original);
            this.kesaiwei_Camera_360 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_Camera_360);
            this.kesaiwei_Android_360 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_Android360);
            this.viewAndroid360CameraSelect = this.mMainView.findViewById(R.id.viewAndroid360CameraSelect);
            this.chkAndroidCamera1080P = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_Android360_1080P);
            this.chkAndroidCamera720P = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_Android360_720P);
            refreshCameraChk();
        }
    }

    private void refreshCameraChk() {
        CheckBox checkBox = this.kesaiwei_Camera_install;
        boolean z = false;
        if (checkBox != null) {
            checkBox.setChecked(this.i_kesaiwei_Camera_Selection == 0);
        }
        CheckBox checkBox2 = this.kesaiwei_Camera_Original;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.i_kesaiwei_Camera_Selection == 1);
        }
        CheckBox checkBox3 = this.kesaiwei_Camera_360;
        if (checkBox3 != null) {
            checkBox3.setChecked(this.i_kesaiwei_Camera_Selection == 2);
        }
        CheckBox checkBox4 = this.kesaiwei_Android_360;
        if (checkBox4 != null) {
            checkBox4.setChecked(this.i_kesaiwei_Camera_Selection == 3);
        }
        boolean z2 = Build.VERSION.SDK_INT > 31 && this.i_kesaiwei_Camera_Selection == 3;
        this.mNeedShowAndroidCameraType = z2;
        View view = this.viewAndroid360CameraSelect;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
        CheckBox checkBox5 = this.chkAndroidCamera1080P;
        if (checkBox5 != null) {
            checkBox5.setChecked(this.iAndroidCameraType == 0);
        }
        CheckBox checkBox6 = this.chkAndroidCamera720P;
        if (checkBox6 != null) {
            if (this.iAndroidCameraType == 1) {
                z = true;
            }
            checkBox6.setChecked(z);
        }
    }

    private void initSignalTypeChk() {
        View view = this.mMainView;
        if (view != null) {
            this.kesaiwei_chk_signal_auto = (CheckBox) view.findViewById(R.id.kesaiwei_chk_signal_auto);
            this.kesaiwei_chk_signal_AHD1080_30 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_signal_AHD1080_30);
            this.kesaiwei_chk_signal_AHD1080_25 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_signal_AHD1080_25);
            this.kesaiwei_chk_signal_AHD720_30 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_signal_AHD720_30);
            this.kesaiwei_chk_signal_AHD720_25 = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_signal_AHD720_25);
            this.kesaiwei_chk_signal_CVBS_NTSC = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_signal_CVBS_NTSC);
            this.kesaiwei_chk_signal_CVBS_PAL = (CheckBox) this.mMainView.findViewById(R.id.kesaiwei_chk_signal_CVBS_PAL);
            refreshSignalTypeChk();
        }
    }

    private void initProductView() {
        if (this.mMainView != null) {
            int[] iArr = {R.id.viewFrontCamera, R.id.viewRearCamera, R.id.viewTrack, R.id.viewRadar, R.id.viewCameraInstall, R.id.layoutCameraSignal};
            int i = 0;
            while (true) {
                int i2 = 8;
                if (i >= 6) {
                    break;
                }
                View findViewById = this.mMainView.findViewById(iArr[i]);
                if (findViewById != null) {
                    if (this.mProductIndex <= 0) {
                        i2 = 0;
                    }
                    findViewById.setVisibility(i2);
                }
                i++;
            }
            int[] iArr2 = {R.id.viewCamera360};
            for (int i3 = 0; i3 < 1; i3++) {
                View findViewById2 = this.mMainView.findViewById(iArr2[i3]);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(this.mProductIndex > 1 ? 8 : 0);
                }
            }
        }
    }

    private void refreshSignalTypeChk() {
        CheckBox checkBox = this.kesaiwei_chk_signal_auto;
        boolean z = false;
        if (checkBox != null) {
            checkBox.setChecked(this.iAHDCameraType == 0);
        }
        CheckBox checkBox2 = this.kesaiwei_chk_signal_AHD1080_30;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.iAHDCameraType == 1);
        }
        CheckBox checkBox3 = this.kesaiwei_chk_signal_AHD1080_25;
        if (checkBox3 != null) {
            checkBox3.setChecked(this.iAHDCameraType == 2);
        }
        CheckBox checkBox4 = this.kesaiwei_chk_signal_AHD720_30;
        if (checkBox4 != null) {
            checkBox4.setChecked(this.iAHDCameraType == 3);
        }
        CheckBox checkBox5 = this.kesaiwei_chk_signal_AHD720_25;
        if (checkBox5 != null) {
            checkBox5.setChecked(this.iAHDCameraType == 4);
        }
        CheckBox checkBox6 = this.kesaiwei_chk_signal_CVBS_NTSC;
        if (checkBox6 != null) {
            checkBox6.setChecked(this.iAHDCameraType == 6);
        }
        CheckBox checkBox7 = this.kesaiwei_chk_signal_CVBS_PAL;
        if (checkBox7 != null) {
            if (this.iAHDCameraType == 7) {
                z = true;
            }
            checkBox7.setChecked(z);
        }
    }

    public void onClick(View view) {
        if (this.focusViews == null || this.focusViews.size() == 0 || BaseApp.getFocusUtil().getViewIds() == null || BaseApp.getFocusUtil().getViewIds().size() == 0) {
            addViewIds();
        }
        if (this.m_iModeSet == 19 || isDefaultUI() || this.m_iUIIndex == 7) {
            for (int i = 0; i < this.focusViews.size(); i++) {
                if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                    this.m_CurrFocus = i;
                }
            }
            BaseApp.getFocusUtil().refreshFirstViews(this.mMain, -1, false);
            BaseApp.getFocusUtil().refreshSecondViews(-1, false);
            this.baseApp.setFocusPage(2);
            this.mMain.m_iCurrFocus = this.m_CurrFocus;
            this.mMain.lastYFocus = 0;
            BaseApp.getFocusUtil().locateFragment(this, TAG);
            BaseApp.getFocusUtil().refreshThirdViews(this.mMain.m_iCurrFocus, false);
        } else if (BaseApp.m_iUIIndex == 2) {
            this.baseApp.setFocusPage(2);
            BaseApp.getFocusUtil().refreshSecondViews(-1, false);
            BaseApp.getFocusUtil().locateFragment(this, TAG);
            for (int i2 = 0; i2 < this.focusViews.size(); i2++) {
                if (view.getId() == ((Integer) this.focusViews.get(i2)).intValue()) {
                    this.m_CurrFocus = i2;
                }
            }
            this.mMain.m_iCurrFocus = this.m_CurrFocus;
            BaseApp.getFocusUtil().refreshThirdViews(this.mMain.m_iCurrFocus, false);
        } else if (this.m_iUIIndex == 6 || this.m_iUIIndex == 4) {
            for (int i3 = 0; i3 < this.focusViews.size(); i3++) {
                if (view.getId() == ((Integer) this.focusViews.get(i3)).intValue()) {
                    this.m_CurrFocus = i3;
                }
            }
            this.mMain.m_iCurrFocus = this.m_CurrFocus;
            BaseApp.getFocusUtil().refreshThirdViews(this.mMain.m_iCurrFocus, false);
        }
        int id = view.getId();
        switch (id) {
            case R.id.btnAndroid360:
                if (this.i_kesaiwei_Camera_Selection != 3) {
                    showToast();
                }
                this.i_kesaiwei_Camera_Selection = 3;
                this.mProvider.updateRecord("KESAIWEI_SYS_CAMERA_SELECTION", "" + this.i_kesaiwei_Camera_Selection);
                refreshCameraChk();
                addViewIds();
                kesaiwei_sendBroadcast2(4);
                return;
            case R.id.btnAndroid360_1080P:
                if (this.iAndroidCameraType != 0) {
                    showToast();
                }
                this.iAndroidCameraType = 0;
                this.mProvider.updateRecord(SysProviderOpt.KSW_ANDROID_CAMERA_TYPE, "" + this.iAndroidCameraType);
                SystemProperties.set("persist.camera.sensor360.resolution", "" + this.iAndroidCameraType);
                refreshCameraChk();
                return;
            case R.id.btnAndroid360_720P:
                if (this.iAndroidCameraType != 1) {
                    showToast();
                }
                this.iAndroidCameraType = 1;
                this.mProvider.updateRecord(SysProviderOpt.KSW_ANDROID_CAMERA_TYPE, "" + this.iAndroidCameraType);
                SystemProperties.set("persist.camera.sensor360.resolution", "" + this.iAndroidCameraType);
                refreshCameraChk();
                return;
            default:
                String str = "1";
                switch (id) {
                    case R.id.btnBackcarMirror:
                        boolean z = !this.b_kesaiwei_chk_BackcarMirror;
                        this.b_kesaiwei_chk_BackcarMirror = z;
                        this.kesaiwei_chk_BackcarMirror.setChecked(z);
                        SysProviderOpt sysProviderOpt = this.mProvider;
                        if (!this.b_kesaiwei_chk_BackcarMirror) {
                            str = "0";
                        }
                        sysProviderOpt.updateRecord(SysProviderOpt.KESAIWEI_SYS_BACKCAR_MIRROR, str);
                        kesaiwei_sendBroadcast2(1);
                        return;
                    case R.id.btnFrontMirror:
                        boolean z2 = !this.b_kesaiwei_chk_FrontMirror;
                        this.b_kesaiwei_chk_FrontMirror = z2;
                        this.kesaiwei_chk_FrontMirror.setChecked(z2);
                        SysProviderOpt sysProviderOpt2 = this.mProvider;
                        if (!this.b_kesaiwei_chk_FrontMirror) {
                            str = "0";
                        }
                        sysProviderOpt2.updateRecord(SysProviderOpt.KESAIWEI_SYS_FRONT_MIRROR, str);
                        kesaiwei_sendBroadcast2(1);
                        return;
                    case R.id.btnMute:
                        boolean z3 = !this.b_kesaiwei_chk_Mute;
                        this.b_kesaiwei_chk_Mute = z3;
                        this.kesaiwei_chk_Mute.setChecked(z3);
                        SysProviderOpt sysProviderOpt3 = this.mProvider;
                        if (!this.b_kesaiwei_chk_Mute) {
                            str = "0";
                        }
                        sysProviderOpt3.updateRecord(SysProviderOpt.KSW_REVEERSING_MUTE_SELECT_INDEX, str);
                        kesaiwei_sendBroadcast2(30);
                        return;
                    case R.id.btnRadar:
                        boolean z4 = !this.b_kesaiwei_chk_Radar;
                        this.b_kesaiwei_chk_Radar = z4;
                        this.kesaiwei_chk_Radar.setChecked(z4);
                        SysProviderOpt sysProviderOpt4 = this.mProvider;
                        if (!this.b_kesaiwei_chk_Radar) {
                            str = "0";
                        }
                        sysProviderOpt4.updateRecord(SysProviderOpt.KESAIWEI_SYS_RADAR, str);
                        kesaiwei_sendBroadcast2(28);
                        return;
                    default:
                        switch (id) {
                            case R.id.btnCamera360:
                                if (this.i_kesaiwei_Camera_Selection != 2) {
                                    showToast();
                                }
                                this.i_kesaiwei_Camera_Selection = 2;
                                this.mProvider.updateRecord("KESAIWEI_SYS_CAMERA_SELECTION", "" + this.i_kesaiwei_Camera_Selection);
                                refreshCameraChk();
                                addViewIds();
                                kesaiwei_sendBroadcast2(4);
                                return;
                            case R.id.btnCameraInstall:
                                if (this.i_kesaiwei_Camera_Selection != 0) {
                                    showToast();
                                }
                                this.i_kesaiwei_Camera_Selection = 0;
                                this.mProvider.updateRecord("KESAIWEI_SYS_CAMERA_SELECTION", "" + this.i_kesaiwei_Camera_Selection);
                                refreshCameraChk();
                                addViewIds();
                                kesaiwei_sendBroadcast2(4);
                                return;
                            case R.id.btnCameraOriginal:
                                if (this.i_kesaiwei_Camera_Selection != 1) {
                                    showToast();
                                }
                                this.i_kesaiwei_Camera_Selection = 1;
                                this.mProvider.updateRecord("KESAIWEI_SYS_CAMERA_SELECTION", "" + this.i_kesaiwei_Camera_Selection);
                                refreshCameraChk();
                                addViewIds();
                                kesaiwei_sendBroadcast2(4);
                                return;
                            default:
                                switch (id) {
                                    case R.id.btnReversingTrack:
                                        boolean z5 = !this.b_kesaiwei_chk_ReversingTrack;
                                        this.b_kesaiwei_chk_ReversingTrack = z5;
                                        this.kesaiwei_chk_ReversingTrack.setChecked(z5);
                                        SysProviderOpt sysProviderOpt5 = this.mProvider;
                                        if (!this.b_kesaiwei_chk_ReversingTrack) {
                                            str = "0";
                                        }
                                        sysProviderOpt5.updateRecord(SysProviderOpt.KESAIWEI_SYS_REVERSING_TRACK, str);
                                        kesaiwei_sendBroadcast2(27);
                                        return;
                                    case R.id.btnSignal_AHD1080_25:
                                        this.iAHDCameraType = 2;
                                        this.mProvider.updateRecord(SysProviderOpt.KSW_AHD_CAMERA_TYPE, "" + this.iAHDCameraType);
                                        refreshSignalTypeChk();
                                        kesaiwei_sendBroadcast2(40);
                                        return;
                                    case R.id.btnSignal_AHD1080_30:
                                        this.iAHDCameraType = 1;
                                        this.mProvider.updateRecord(SysProviderOpt.KSW_AHD_CAMERA_TYPE, "" + this.iAHDCameraType);
                                        refreshSignalTypeChk();
                                        kesaiwei_sendBroadcast2(40);
                                        return;
                                    case R.id.btnSignal_AHD720_25:
                                        this.iAHDCameraType = 4;
                                        this.mProvider.updateRecord(SysProviderOpt.KSW_AHD_CAMERA_TYPE, "" + this.iAHDCameraType);
                                        refreshSignalTypeChk();
                                        kesaiwei_sendBroadcast2(40);
                                        return;
                                    case R.id.btnSignal_AHD720_30:
                                        this.iAHDCameraType = 3;
                                        this.mProvider.updateRecord(SysProviderOpt.KSW_AHD_CAMERA_TYPE, "" + this.iAHDCameraType);
                                        refreshSignalTypeChk();
                                        kesaiwei_sendBroadcast2(40);
                                        return;
                                    case R.id.btnSignal_CVBS_NTSC:
                                        this.iAHDCameraType = 6;
                                        this.mProvider.updateRecord(SysProviderOpt.KSW_AHD_CAMERA_TYPE, "" + this.iAHDCameraType);
                                        refreshSignalTypeChk();
                                        kesaiwei_sendBroadcast2(40);
                                        return;
                                    case R.id.btnSignal_CVBS_PAL:
                                        this.iAHDCameraType = 7;
                                        this.mProvider.updateRecord(SysProviderOpt.KSW_AHD_CAMERA_TYPE, "" + this.iAHDCameraType);
                                        refreshSignalTypeChk();
                                        kesaiwei_sendBroadcast2(40);
                                        return;
                                    case R.id.btnSignal_auto:
                                        this.iAHDCameraType = 0;
                                        this.mProvider.updateRecord(SysProviderOpt.KSW_AHD_CAMERA_TYPE, "" + this.iAHDCameraType);
                                        refreshSignalTypeChk();
                                        kesaiwei_sendBroadcast2(40);
                                        return;
                                    default:
                                        return;
                                }
                        }
                }
        }
    }

    public void addViewIds() {
        super.addViewIds();
        Log.d(TAG, "addViewIds resumed = " + isResumed());
        if (this.i_kesaiwei_Camera_Selection == -1 && getMainActivity() != null) {
            this.i_kesaiwei_Camera_Selection = SysProviderOpt.getInstance(getMainActivity()).getRecordInteger("KESAIWEI_SYS_CAMERA_SELECTION", this.i_kesaiwei_Camera_Selection);
        }
        this.mNeedShowAndroidCameraType = Build.VERSION.SDK_INT > 31 && this.i_kesaiwei_Camera_Selection == 3;
        BaseApp.getFocusUtil().showAndroidCameraType(this.mNeedShowAndroidCameraType);
        this.focusViews = new ArrayList();
        if (this.mProductIndex > 0) {
            this.focusViews.add(Integer.valueOf(R.id.btnMute));
            this.focusViews.add(Integer.valueOf(R.id.btnCameraOriginal));
            if (this.mProductIndex == 1) {
                this.focusViews.add(Integer.valueOf(R.id.btnCamera360));
            }
            this.focusViews.add(Integer.valueOf(R.id.btnAndroid360));
            if (this.mNeedShowAndroidCameraType) {
                this.focusViews.add(Integer.valueOf(R.id.btnAndroid360_1080P));
                this.focusViews.add(Integer.valueOf(R.id.btnAndroid360_720P));
            }
        } else {
            this.focusViews.add(Integer.valueOf(R.id.btnFrontMirror));
            this.focusViews.add(Integer.valueOf(R.id.btnBackcarMirror));
            this.focusViews.add(Integer.valueOf(R.id.btnReversingTrack));
            this.focusViews.add(Integer.valueOf(R.id.btnRadar));
            this.focusViews.add(Integer.valueOf(R.id.btnMute));
            this.focusViews.add(Integer.valueOf(R.id.btnCameraInstall));
            this.focusViews.add(Integer.valueOf(R.id.btnCameraOriginal));
            this.focusViews.add(Integer.valueOf(R.id.btnCamera360));
            this.focusViews.add(Integer.valueOf(R.id.btnAndroid360));
            if (this.mNeedShowAndroidCameraType) {
                this.focusViews.add(Integer.valueOf(R.id.btnAndroid360_1080P));
                this.focusViews.add(Integer.valueOf(R.id.btnAndroid360_720P));
            }
            this.focusViews.add(Integer.valueOf(R.id.btnSignal_auto));
            this.focusViews.add(Integer.valueOf(R.id.btnSignal_AHD1080_30));
            this.focusViews.add(Integer.valueOf(R.id.btnSignal_AHD1080_25));
            this.focusViews.add(Integer.valueOf(R.id.btnSignal_AHD720_30));
            this.focusViews.add(Integer.valueOf(R.id.btnSignal_AHD720_25));
            this.focusViews.add(Integer.valueOf(R.id.btnSignal_CVBS_NTSC));
            this.focusViews.add(Integer.valueOf(R.id.btnSignal_CVBS_PAL));
        }
        BaseApp.getFocusUtil().addViewIds(this.focusViews);
    }

    private void showToast() {
        Toast toast = this.mToast;
        if (toast != null) {
            toast.cancel();
        }
        this.mToast = Toast.makeText(getContext(), "", 0);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getMainActivity()).inflate(R.layout.layout_toast, (ViewGroup) null, false);
        ((TextView) viewGroup.findViewById(R.id.tvMessage)).setText(getString(R.string.lbl_toast_switch_camera));
        this.mToast.setView(viewGroup);
        this.mToast.show();
    }
}
