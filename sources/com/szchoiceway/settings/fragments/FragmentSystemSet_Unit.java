package com.szchoiceway.settings.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ScrollView;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.settings.fragments.FragmentSystemSet_Unit;
import com.szchoiceway.settings.view.ClipScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.zxwlib.utils.EventUtils;
import java.util.ArrayList;

public class FragmentSystemSet_Unit extends FragmentBase implements View.OnClickListener {
    private static final String TAG = "SystemSet_Unit";
    CheckBox kesaiwei_distance_UnitImperial = null;
    CheckBox kesaiwei_distance_UnitMetric = null;
    CheckBox kesaiwei_oil_UnitL = null;
    CheckBox kesaiwei_oil_UnitUK = null;
    CheckBox kesaiwei_oil_UnitUS = null;
    CheckBox kesaiwei_temp_unitC = null;
    CheckBox kesaiwei_temp_unitF = null;
    /* access modifiers changed from: private */
    public MainActivity mMain;
    private View mMainView;
    private SysProviderOpt mProvider;
    /* access modifiers changed from: private */
    public ScrollView mScrollView;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    /* access modifiers changed from: private */
    public View scrollLayout;
    /* access modifiers changed from: private */
    public int totalHeight = 0;
    private int unitDistance = 0;
    private int unitOil = 0;
    private int unitTemp = 0;

    public String getFragmentTag() {
        return TAG;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mMain = (MainActivity) getActivity();
        SysProviderOpt instance = SysProviderOpt.getInstance(context);
        this.mProvider = instance;
        this.unitDistance = instance.getRecordInteger(SysProviderOpt.KSW_DISTACNE_UNIT, 0);
        this.unitOil = this.mProvider.getRecordInteger(SysProviderOpt.KSW_OIL_UNIT, 0);
        this.unitTemp = this.mProvider.getRecordInteger(SysProviderOpt.KSW_TEMP_UNIT, 0);
        Log.d(TAG, "unitDistance = " + this.unitDistance + ", unitOil = " + this.unitOil + ", unitTemp = " + this.unitTemp);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_unit, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_unit, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_unit, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_unit, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_unit, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_unit, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_unit_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_unit, (ViewGroup) null);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_unit, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set_unit, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_unit, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_unit, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_unit, (ViewGroup) null);
        } else if (this.m_iUIIndex != 5) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_unit, (ViewGroup) null);
        } else if (this.m_iModeSet == 32) {
            view = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_unit, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_unit, (ViewGroup) null);
        }
        this.mMainView = view;
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mMain = mainActivity;
        this.baseApp = (BaseApp) mainActivity.getApplication();
        this.myScrollbar = (MyScrollbar) view.findViewById(R.id.myScrollbar);
        this.mScrollView = (ScrollView) view.findViewById(R.id.mScrollView);
        View findViewById = view.findViewById(R.id.scrollLayout);
        this.scrollLayout = findViewById;
        if (findViewById != null) {
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    FragmentSystemSet_Unit.this.scrollLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    FragmentSystemSet_Unit fragmentSystemSet_Unit = FragmentSystemSet_Unit.this;
                    int unused = fragmentSystemSet_Unit.totalHeight = fragmentSystemSet_Unit.scrollLayout.getHeight();
                    if (FragmentSystemSet_Unit.this.mScrollView != null && FragmentSystemSet_Unit.this.myScrollbar != null) {
                        FragmentSystemSet_Unit.this.mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                                FragmentSystemSet_Unit.AnonymousClass1.this.lambda$onGlobalLayout$0$FragmentSystemSet_Unit$1(view, i, i2, i3, i4);
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onGlobalLayout$0$FragmentSystemSet_Unit$1(View view, int i, int i2, int i3, int i4) {
                    float access$100 = (((float) i2) * 1.0f) / ((float) (FragmentSystemSet_Unit.this.totalHeight - FragmentSystemSet_Unit.this.mScrollView.getHeight()));
                    if (FragmentSystemSet_Unit.this.myScrollbar != null) {
                        FragmentSystemSet_Unit.this.myScrollbar.setCurrentPercent(access$100);
                    }
                    if (FragmentSystemSet_Unit.this.mScrollView instanceof ClipScrollView) {
                        ((ClipScrollView) FragmentSystemSet_Unit.this.mScrollView).setScrollHeight(i2);
                    }
                    Log.d(FragmentSystemSet_Unit.TAG, "scrollY = " + i2 + ", percent = " + access$100);
                }
            });
        }
        int[] iArr = {R.id.btnDistanceUnitMetric, R.id.btnDistanceUnitImperial, R.id.btnOilUnitL, R.id.btnOilUnitIUS, R.id.btnOilUnitUK, R.id.btnTempUnitC, R.id.btnTempUnitF};
        for (int i = 0; i < 7; i++) {
            View findViewById2 = view.findViewById(iArr[i]);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(this);
            }
        }
        this.kesaiwei_distance_UnitMetric = (CheckBox) view.findViewById(R.id.kesaiwei_distance_UnitMetric);
        this.kesaiwei_distance_UnitImperial = (CheckBox) view.findViewById(R.id.kesaiwei_distance_UnitImperial);
        refreshChkDistance();
        this.kesaiwei_oil_UnitL = (CheckBox) view.findViewById(R.id.kesaiwei_oil_UnitL);
        this.kesaiwei_oil_UnitUS = (CheckBox) view.findViewById(R.id.kesaiwei_oil_UnitUS);
        this.kesaiwei_oil_UnitUK = (CheckBox) view.findViewById(R.id.kesaiwei_oil_UnitUK);
        refreshChkOil();
        this.kesaiwei_temp_unitC = (CheckBox) view.findViewById(R.id.kesaiwei_temp_unitC);
        this.kesaiwei_temp_unitF = (CheckBox) view.findViewById(R.id.kesaiwei_temp_unitF);
        refreshChkTemp();
    }

    private void refreshChkDistance() {
        CheckBox checkBox = this.kesaiwei_distance_UnitMetric;
        boolean z = false;
        if (checkBox != null) {
            checkBox.setChecked(this.unitDistance == 0);
        }
        CheckBox checkBox2 = this.kesaiwei_distance_UnitImperial;
        if (checkBox2 != null) {
            if (this.unitDistance == 1) {
                z = true;
            }
            checkBox2.setChecked(z);
        }
    }

    private void refreshChkOil() {
        CheckBox checkBox = this.kesaiwei_oil_UnitL;
        boolean z = false;
        if (checkBox != null) {
            checkBox.setChecked(this.unitOil == 0);
        }
        CheckBox checkBox2 = this.kesaiwei_oil_UnitUS;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.unitOil == 1);
        }
        CheckBox checkBox3 = this.kesaiwei_oil_UnitUK;
        if (checkBox3 != null) {
            if (this.unitOil == 2) {
                z = true;
            }
            checkBox3.setChecked(z);
        }
    }

    private void refreshChkTemp() {
        CheckBox checkBox = this.kesaiwei_temp_unitC;
        boolean z = false;
        if (checkBox != null) {
            checkBox.setChecked(this.unitTemp == 0);
        }
        CheckBox checkBox2 = this.kesaiwei_temp_unitF;
        if (checkBox2 != null) {
            if (this.unitTemp == 1) {
                z = true;
            }
            checkBox2.setChecked(z);
        }
    }

    public void onClick(View view) {
        Log.d(TAG, "onClick");
        if (BaseApp.getFocusUtil().inSeekbarKnobMode) {
            BaseApp.getFocusUtil().clearSeekbarFocus();
        }
        if (this.focusViews == null || this.focusViews.isEmpty()) {
            this.focusViews = new ArrayList();
            this.focusViews.add(Integer.valueOf(R.id.btnDistanceUnitMetric));
            this.focusViews.add(Integer.valueOf(R.id.btnDistanceUnitImperial));
            this.focusViews.add(Integer.valueOf(R.id.btnOilUnitL));
            this.focusViews.add(Integer.valueOf(R.id.btnOilUnitIUS));
            this.focusViews.add(Integer.valueOf(R.id.btnOilUnitUK));
            this.focusViews.add(Integer.valueOf(R.id.btnTempUnitC));
            this.focusViews.add(Integer.valueOf(R.id.btnTempUnitF));
        }
        for (int i = 0; i < this.focusViews.size(); i++) {
            if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                this.m_CurrFocus = i;
            }
        }
        this.baseApp.setFocusPage(2);
        this.mMain.m_iCurrFocus = this.m_CurrFocus;
        this.mMain.lastYFocus = 3;
        BaseApp.getFocusUtil().refreshFirstViews(this.mMain, -1, false);
        BaseApp.getFocusUtil().refreshSecondViews(-1, false);
        BaseApp.getFocusUtil().locateFragment(this, TAG);
        addViewIds();
        BaseApp.getFocusUtil().refreshThirdViews(this.mMain.m_iCurrFocus, false);
        switch (view.getId()) {
            case R.id.btnDistanceUnitImperial:
                this.unitDistance = 1;
                this.mProvider.updateRecord(SysProviderOpt.KSW_DISTACNE_UNIT, "" + this.unitDistance);
                refreshChkDistance();
                kesaiwei_sendBroadcast2(4);
                break;
            case R.id.btnDistanceUnitMetric:
                this.unitDistance = 0;
                this.mProvider.updateRecord(SysProviderOpt.KSW_DISTACNE_UNIT, "" + this.unitDistance);
                refreshChkDistance();
                kesaiwei_sendBroadcast2(4);
                break;
            case R.id.btnOilUnitIUS:
                this.unitOil = 1;
                this.mProvider.updateRecord(SysProviderOpt.KSW_OIL_UNIT, "" + this.unitOil);
                refreshChkOil();
                kesaiwei_sendBroadcast2(4);
                break;
            case R.id.btnOilUnitL:
                this.unitOil = 0;
                this.mProvider.updateRecord(SysProviderOpt.KSW_OIL_UNIT, "" + this.unitOil);
                refreshChkOil();
                kesaiwei_sendBroadcast2(4);
                break;
            case R.id.btnOilUnitUK:
                this.unitOil = 2;
                this.mProvider.updateRecord(SysProviderOpt.KSW_OIL_UNIT, "" + this.unitOil);
                refreshChkOil();
                kesaiwei_sendBroadcast2(4);
                break;
            case R.id.btnTempUnitC:
                this.unitTemp = 0;
                this.mProvider.updateRecord(SysProviderOpt.KSW_TEMP_UNIT, "" + this.unitTemp);
                refreshChkTemp();
                kesaiwei_sendBroadcast2(4);
                break;
            case R.id.btnTempUnitF:
                this.unitTemp = 1;
                this.mProvider.updateRecord(SysProviderOpt.KSW_TEMP_UNIT, "" + this.unitTemp);
                refreshChkTemp();
                kesaiwei_sendBroadcast2(4);
                break;
        }
        MainActivity mainActivity = this.mMain;
        if (mainActivity != null && mainActivity.getService() != null) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                        FragmentSystemSet_Unit.this.mMain.getService().sendMcuData_KSW(new byte[]{EventUtils.MCU_KEY_MUSIC, 0, 104, 2, 5, 0});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        this.focusViews.add(Integer.valueOf(R.id.btnDistanceUnitMetric));
        this.focusViews.add(Integer.valueOf(R.id.btnDistanceUnitImperial));
        this.focusViews.add(Integer.valueOf(R.id.btnOilUnitL));
        this.focusViews.add(Integer.valueOf(R.id.btnOilUnitIUS));
        this.focusViews.add(Integer.valueOf(R.id.btnOilUnitUK));
        if (BaseApp.m_iUIIndex != 2) {
            this.focusViews.add(Integer.valueOf(R.id.btnTempUnitC));
            this.focusViews.add(Integer.valueOf(R.id.btnTempUnitF));
        }
        BaseApp.getFocusUtil().addViewIds(this.focusViews);
    }
}
