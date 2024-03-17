package com.szchoiceway.settings;

import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.core.app.NotificationCompat;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.settings.FragmentDataTimer;
import com.szchoiceway.settings.view.MyScrollbar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FragmentDataTimer extends FragmentBase implements DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener, View.OnClickListener {
    private static final int LAYOUT_TYPE_SYC = 0;
    private static final int LAYOUT_TYPE_SYS = 1;
    private String TAG = "FragmentDataTimer";
    ImageButton btn12Hour;
    private List<Integer> btnMenuIds;
    private View btnSyc;
    private List<Integer> btnSycIds;
    private View btnSys;
    private List<Integer> btnSysIds;
    private ImageButton iBKSWBack;
    private int iUserMode_KSW = 1;
    ImageView imgSyc;
    ImageView imgSys;
    private ImageView imgViewFocusList_src_anniu = null;
    CheckBox kesaiwei_chk_12Hour = null;
    CheckBox kesaiwei_chk_24Hour = null;
    CheckBox kesaiwei_chk_Auto_Sync = null;
    CheckBox kesaiwei_chk_Manually_set = null;
    CheckBox kesaiwei_chk_Original_Time = null;
    RelativeLayout kesaiwei_date_show = null;
    ImageView lineSys;
    /* access modifiers changed from: private */
    public ScrollView mScrollView;
    View mainView;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    /* access modifiers changed from: private */
    public View scrollLayout;
    /* access modifiers changed from: private */
    public int totalHeight = 0;
    TextView valueSyc;
    TextView valueSys;
    View viewSyc;
    View viewSys;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        this.mainActivity = (MainActivity) getActivity();
        if (this.m_iUITypeVer != 41) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_datatimer, (ViewGroup) null);
        } else if (this.isSmallResolution) {
            if (isDefaultUI()) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_datatimer, (ViewGroup) null);
            } else if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_datatimer, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_datatimer, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_datatimer, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_time_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_time_set, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_datatimer, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_time_set_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_datatimer, (ViewGroup) null);
            }
        } else if (isDefaultUI()) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_datatimer, (ViewGroup) null);
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_datatimer, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_datatimer, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_datatimer, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_datatimer, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_time_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 5) {
            view = layoutInflater.inflate(R.layout.landrover_fragment_time_set, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_datatimer, (ViewGroup) null);
        }
        bindViewListener(view);
        return view;
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        if (view != null) {
            initView(view);
            this.mainView = view;
            this.myScrollbar = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            this.mScrollView = (ScrollView) view.findViewById(R.id.mScrollView);
            View findViewById = view.findViewById(R.id.scrollLayout);
            this.scrollLayout = findViewById;
            if (findViewById != null) {
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        FragmentDataTimer.this.scrollLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        FragmentDataTimer fragmentDataTimer = FragmentDataTimer.this;
                        int unused = fragmentDataTimer.totalHeight = fragmentDataTimer.scrollLayout.getHeight();
                        if (FragmentDataTimer.this.mScrollView != null) {
                            FragmentDataTimer.this.mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                                public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                                    FragmentDataTimer.AnonymousClass1.this.lambda$onGlobalLayout$0$FragmentDataTimer$1(view, i, i2, i3, i4);
                                }
                            });
                        }
                    }

                    public /* synthetic */ void lambda$onGlobalLayout$0$FragmentDataTimer$1(View view, int i, int i2, int i3, int i4) {
                        float access$100 = (((float) i2) * 1.0f) / ((float) (FragmentDataTimer.this.totalHeight - FragmentDataTimer.this.mScrollView.getHeight()));
                        if (FragmentDataTimer.this.myScrollbar != null) {
                            FragmentDataTimer.this.myScrollbar.setCurrentPercent(access$100);
                        }
                    }
                });
            }
            View findViewById2 = view.findViewById(R.id.btnReturn);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        FragmentDataTimer.this.lambda$bindViewListener$0$FragmentDataTimer(view);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$bindViewListener$0$FragmentDataTimer(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        Log.d(this.TAG, "onClick btnReturn main = " + mainActivity);
        if (mainActivity != null) {
            mainActivity.hideID8Content();
        }
    }

    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        long timeInMillis = instance.getTimeInMillis();
        if (timeInMillis / 1000 < 2147483647L) {
            SystemClock.setCurrentTimeMillis(timeInMillis);
        }
    }

    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        long timeInMillis = instance.getTimeInMillis();
        if (timeInMillis / 1000 < 2147483647L) {
            SystemClock.setCurrentTimeMillis(timeInMillis);
        }
    }

    private void initView(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
            this.iUserMode_KSW = mainActivity.mSysProviderOpt.getRecordInteger(SysProviderOpt.KESAIWEI_SYS_USER_TIME_TYPE, this.iUserMode_KSW);
        }
        this.imgSyc = (ImageView) view.findViewById(R.id.imgSyc);
        this.imgSys = (ImageView) view.findViewById(R.id.imgSys);
        this.lineSys = (ImageView) view.findViewById(R.id.lineSys);
        this.valueSys = (TextView) view.findViewById(R.id.valueSys);
        this.valueSyc = (TextView) view.findViewById(R.id.valueSyc);
        this.viewSyc = view.findViewById(R.id.viewSyc);
        this.btnSyc = view.findViewById(R.id.btnSyc);
        this.btnSys = view.findViewById(R.id.btnSys);
        View view2 = this.viewSyc;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        ImageView imageView = this.imgSyc;
        if (imageView != null) {
            imageView.setBackground(getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_time_down));
        }
        View findViewById = view.findViewById(R.id.viewSys);
        this.viewSys = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        ImageView imageView2 = this.lineSys;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.imgSys;
        if (imageView3 != null) {
            imageView3.setBackground(getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_time_down));
        }
        this.kesaiwei_chk_12Hour = (CheckBox) view.findViewById(R.id.kesaiwei_12_hour);
        this.kesaiwei_chk_24Hour = (CheckBox) view.findViewById(R.id.kesaiwei_24_hour);
        this.btn12Hour = (ImageButton) view.findViewById(R.id.btn12Hour);
        setCheck_24_hour();
        this.kesaiwei_chk_Original_Time = (CheckBox) view.findViewById(R.id.kesaiwei_Original_Time);
        this.kesaiwei_chk_Auto_Sync = (CheckBox) view.findViewById(R.id.kesaiwei_Auto_Sync);
        setCheck_time_Selection();
        int[] iArr = {R.id.btnSyc, R.id.btnSys, R.id.btnOriginalTime, R.id.btnAutoSync, R.id.btn24Hour, R.id.btn12Hour};
        for (int i = 0; i < 6; i++) {
            View findViewById2 = view.findViewById(iArr[i]);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(this);
            }
        }
        ArrayList arrayList = new ArrayList();
        this.btnMenuIds = arrayList;
        arrayList.add(Integer.valueOf(R.id.btnSyc));
        this.btnMenuIds.add(Integer.valueOf(R.id.btnSys));
        ArrayList arrayList2 = new ArrayList();
        this.btnSycIds = arrayList2;
        arrayList2.add(Integer.valueOf(R.id.btnOriginalTime));
        this.btnSycIds.add(Integer.valueOf(R.id.btnAutoSync));
        ArrayList arrayList3 = new ArrayList();
        this.btnSysIds = arrayList3;
        arrayList3.add(Integer.valueOf(R.id.btn12Hour));
        this.btnSysIds.add(Integer.valueOf(R.id.btn24Hour));
        if (this.m_iUIIndex == 7) {
            showLayout(0);
        }
    }

    public void onClick(View view) {
        Log.d(this.TAG, "onClick");
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        this.baseApp = (BaseApp) mainActivity.getApplication();
        if (BaseApp.m_iUIIndex == 6 || BaseApp.m_iModeSet == 19 || isDefaultUI() || (this.m_iUIIndex == 4 && this.isSmallResolution)) {
            addViewIds();
            for (int i = 0; i < this.focusViews.size(); i++) {
                if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                    this.m_CurrFocus = i;
                }
            }
            mainActivity.m_iCurrFocus = this.m_CurrFocus;
            this.baseApp.setFocusPage(1);
            mainActivity.lastXFocus = 5;
            BaseApp.getFocusUtil().refreshSecondViews(mainActivity.m_iCurrFocus, false);
            if (BaseApp.m_iModeSet == 19 || isDefaultUI()) {
                BaseApp.getFocusUtil().refreshFirstViews(mainActivity, -1, false);
            }
        } else if (BaseApp.m_iUIIndex == 2) {
            addViewIds();
            for (int i2 = 0; i2 < this.focusUtil.getViewIds().size(); i2++) {
                if (view.getId() == this.focusUtil.getViewIds().get(i2).intValue()) {
                    this.m_CurrFocus = i2;
                }
            }
            mainActivity.m_iCurrFocus = this.m_CurrFocus;
            BaseApp.getFocusUtil().refreshSecondViews(mainActivity.m_iCurrFocus, false);
        } else if (BaseApp.m_iUIIndex == 7) {
            mainActivity.lastXFocus = 4;
            if (this.btnMenuIds.contains(Integer.valueOf(view.getId()))) {
                BaseApp.getFocusUtil().refreshFirstViews(mainActivity, -1, false);
                BaseApp.getFocusUtil().refreshThirdViews(-1, false);
                addViewIds();
                for (int i3 = 0; i3 < this.btnMenuIds.size(); i3++) {
                    if (view.getId() == this.btnMenuIds.get(i3).intValue()) {
                        this.m_CurrFocus = i3;
                    }
                }
                mainActivity.m_iCurrFocus = this.m_CurrFocus;
                this.baseApp.setFocusPage(1);
                BaseApp.getFocusUtil().refreshSecondViews(mainActivity.m_iCurrFocus, false);
            } else if (this.btnSycIds.contains(Integer.valueOf(view.getId()))) {
                BaseApp.getFocusUtil().refreshFirstViews(mainActivity, -1, false);
                BaseApp.getFocusUtil().refreshSecondViews(-1, false);
                mainActivity.lastYFocus = 0;
                addViewIds();
                for (int i4 = 0; i4 < this.btnSycIds.size(); i4++) {
                    if (view.getId() == this.btnSycIds.get(i4).intValue()) {
                        this.m_CurrFocus = i4;
                    }
                }
                mainActivity.m_iCurrFocus = this.m_CurrFocus;
                this.baseApp.setFocusPage(2);
                BaseApp.getFocusUtil().refreshThirdViews(mainActivity.m_iCurrFocus, false);
            } else if (this.btnSysIds.contains(Integer.valueOf(view.getId()))) {
                BaseApp.getFocusUtil().refreshFirstViews(mainActivity, -1, false);
                BaseApp.getFocusUtil().refreshSecondViews(-1, false);
                mainActivity.lastYFocus = 1;
                addViewIds();
                for (int i5 = 0; i5 < this.btnSysIds.size(); i5++) {
                    if (view.getId() == this.btnSysIds.get(i5).intValue()) {
                        this.m_CurrFocus = i5;
                    }
                }
                mainActivity.m_iCurrFocus = this.m_CurrFocus;
                this.baseApp.setFocusPage(2);
                BaseApp.getFocusUtil().refreshThirdViews(mainActivity.m_iCurrFocus, false);
            }
        }
        switch (view.getId()) {
            case R.id.btn12Hour /*2131230924*/:
                mainActivity.mSysProviderOpt.updateRecord(SysProviderOpt.KESAIWEI_SYS_ANDROID_IS_24_HOUR, "0");
                if (getContext() != null) {
                    Settings.System.putString(getContext().getContentResolver(), "time_12_24", "12");
                }
                setCheck_24_hour();
                ((AlarmManager) mainActivity.getSystemService(NotificationCompat.CATEGORY_ALARM)).setTime(Calendar.getInstance().getTimeInMillis());
                mainActivity.sendBroadcast(new Intent("android.intent.action.TIME_SET"));
                if (this.m_iUIIndex == 4 && !this.isSmallResolution) {
                    mainActivity.m_iCurrFocus = 0;
                    BaseApp.getFocusUtil().refreshThirdViews(mainActivity.m_iCurrFocus, false);
                    return;
                }
                return;
            case R.id.btn24Hour /*2131230925*/:
                mainActivity.mSysProviderOpt.updateRecord(SysProviderOpt.KESAIWEI_SYS_ANDROID_IS_24_HOUR, "1");
                if (getContext() != null) {
                    Settings.System.putString(getContext().getContentResolver(), "time_12_24", "24");
                }
                setCheck_24_hour();
                ((AlarmManager) mainActivity.getSystemService(NotificationCompat.CATEGORY_ALARM)).setTime(Calendar.getInstance().getTimeInMillis());
                mainActivity.sendBroadcast(new Intent("android.intent.action.TIME_SET"));
                if (this.m_iUIIndex == 4 && !this.isSmallResolution) {
                    mainActivity.m_iCurrFocus = 1;
                    BaseApp.getFocusUtil().refreshThirdViews(mainActivity.m_iCurrFocus, false);
                    return;
                }
                return;
            case R.id.btnAutoSync /*2131230943*/:
                this.iUserMode_KSW = 1;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord(SysProviderOpt.KESAIWEI_SYS_USER_TIME_TYPE, "" + this.iUserMode_KSW);
                }
                setCheck_time_Selection();
                setSettingsAutomaticDateTimeIfNeeded(true);
                mainActivity.sendBroadcast(new Intent(EventUtils.ZXW_ACTION_UPDATE_GPS_TIME));
                return;
            case R.id.btnOriginalTime /*2131231020*/:
                this.iUserMode_KSW = 0;
                if (!(mainActivity == null || mainActivity.mSysProviderOpt == null)) {
                    mainActivity.mSysProviderOpt.updateRecord(SysProviderOpt.KESAIWEI_SYS_USER_TIME_TYPE, "" + this.iUserMode_KSW);
                }
                setCheck_time_Selection();
                setSettingsAutomaticDateTimeIfNeeded(false);
                return;
            case R.id.btnSyc /*2131231043*/:
                if (this.m_iUIIndex != 2) {
                    showLayout(0);
                    if (this.m_iUIIndex == 4) {
                        mainActivity.lastYFocus = 0;
                        this.baseApp.setFocusPage(2);
                        addViewIds();
                        mainActivity.m_iCurrFocus = -1;
                        BaseApp.getFocusUtil().refreshThirdViews(-1, false);
                        return;
                    }
                    return;
                } else if (this.viewSyc.getVisibility() == 0) {
                    this.viewSyc.setVisibility(8);
                    ImageView imageView = this.imgSyc;
                    if (imageView != null) {
                        imageView.setBackground(getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_time_down));
                        return;
                    }
                    return;
                } else if (this.viewSyc.getVisibility() == 8) {
                    this.viewSyc.setVisibility(0);
                    ImageView imageView2 = this.imgSyc;
                    if (imageView2 != null) {
                        imageView2.setBackground(getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_time_up));
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case R.id.btnSys /*2131231044*/:
                if (this.m_iUIIndex != 2) {
                    showLayout(1);
                    if (this.m_iUIIndex == 4) {
                        mainActivity.lastYFocus = 1;
                        this.baseApp.setFocusPage(2);
                        addViewIds();
                        mainActivity.m_iCurrFocus = -1;
                        BaseApp.getFocusUtil().refreshThirdViews(-1, false);
                        return;
                    }
                    return;
                } else if (this.viewSys.getVisibility() == 0) {
                    this.viewSys.setVisibility(8);
                    ImageView imageView3 = this.lineSys;
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                    }
                    ImageView imageView4 = this.imgSys;
                    if (imageView4 != null) {
                        imageView4.setBackground(getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_time_down));
                        return;
                    }
                    return;
                } else if (this.viewSys.getVisibility() == 8) {
                    this.viewSys.setVisibility(0);
                    ImageView imageView5 = this.lineSys;
                    if (imageView5 != null) {
                        imageView5.setVisibility(0);
                    }
                    ImageView imageView6 = this.imgSys;
                    if (imageView6 != null) {
                        imageView6.setBackground(getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_time_up));
                        return;
                    }
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private void showLayout(int i) {
        if (i == 1) {
            View view = this.viewSyc;
            if (!(view == null || view.getVisibility() == 8)) {
                this.viewSyc.setVisibility(8);
            }
            View view2 = this.btnSyc;
            if (view2 != null && (view2 instanceof RadioButton) && ((RadioButton) view2).isChecked()) {
                ((RadioButton) this.btnSyc).setChecked(false);
            }
            View view3 = this.viewSys;
            if (!(view3 == null || view3.getVisibility() == 0)) {
                this.viewSys.setVisibility(0);
            }
            View view4 = this.btnSys;
            if (view4 != null && (view4 instanceof RadioButton) && !((RadioButton) view4).isChecked()) {
                ((RadioButton) this.btnSys).setChecked(true);
                return;
            }
            return;
        }
        View view5 = this.viewSyc;
        if (!(view5 == null || view5.getVisibility() == 0)) {
            this.viewSyc.setVisibility(0);
        }
        View view6 = this.btnSyc;
        if (view6 != null && (view6 instanceof RadioButton) && !((RadioButton) view6).isChecked()) {
            ((RadioButton) this.btnSyc).setChecked(true);
        }
        View view7 = this.viewSys;
        if (!(view7 == null || view7.getVisibility() == 8)) {
            this.viewSys.setVisibility(8);
        }
        View view8 = this.btnSys;
        if (view8 != null && (view8 instanceof RadioButton) && ((RadioButton) view8).isChecked()) {
            ((RadioButton) this.btnSys).setChecked(false);
        }
    }

    private void setCheck_time_Selection() {
        CheckBox checkBox = this.kesaiwei_chk_Original_Time;
        boolean z = false;
        if (checkBox != null) {
            checkBox.setChecked(this.iUserMode_KSW == 0);
        }
        CheckBox checkBox2 = this.kesaiwei_chk_Auto_Sync;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.iUserMode_KSW == 1);
        }
        CheckBox checkBox3 = this.kesaiwei_chk_Manually_set;
        if (checkBox3 != null) {
            if (this.iUserMode_KSW == 2) {
                z = true;
            }
            checkBox3.setChecked(z);
        }
        TextView textView = this.valueSyc;
        if (textView != null) {
            if (this.iUserMode_KSW == 0) {
                textView.setText(getResources().getString(R.string.lb_time_car));
            }
            if (this.iUserMode_KSW == 1) {
                this.valueSyc.setText(getResources().getString(R.string.lb_time_android));
            }
        }
    }

    private void setCheck_24_hour() {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        String string = Settings.System.getString(mainActivity.getContentResolver(), "time_12_24");
        if ("12".equals(string)) {
            Settings.System.putString(mainActivity.getContentResolver(), "time_12_24", "12");
            CheckBox checkBox = this.kesaiwei_chk_24Hour;
            if (checkBox != null) {
                checkBox.setChecked(false);
            }
            CheckBox checkBox2 = this.kesaiwei_chk_12Hour;
            if (checkBox2 != null) {
                checkBox2.setChecked(true);
            }
        }
        if ("24".equals(string)) {
            Settings.System.putString(mainActivity.getContentResolver(), "time_12_24", "24");
            CheckBox checkBox3 = this.kesaiwei_chk_24Hour;
            if (checkBox3 != null) {
                checkBox3.setChecked(true);
            }
            CheckBox checkBox4 = this.kesaiwei_chk_12Hour;
            if (checkBox4 != null) {
                checkBox4.setChecked(false);
            }
        }
        RelativeLayout relativeLayout = this.kesaiwei_date_show;
        if (relativeLayout != null) {
            if (this.iUserMode_KSW == 2) {
                relativeLayout.setVisibility(0);
            } else {
                relativeLayout.setVisibility(4);
            }
        }
        if (this.valueSys != null) {
            CheckBox checkBox5 = this.kesaiwei_chk_12Hour;
            if (checkBox5 != null && checkBox5.isChecked()) {
                this.valueSys.setText(getResources().getString(R.string.lb_time_12));
            }
            CheckBox checkBox6 = this.kesaiwei_chk_24Hour;
            if (checkBox6 != null && checkBox6.isChecked()) {
                this.valueSys.setText(getResources().getString(R.string.lb_time_24));
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.i(this.TAG, "*****onDestroyView*****");
    }

    public void setSettingsAutomaticDateTimeIfNeeded(boolean z) {
        String string = Settings.Global.getString(getActivity().getContentResolver(), "auto_time");
        if (z) {
            if (string.contentEquals("0")) {
                Settings.Global.putString(getActivity().getContentResolver(), "auto_time", "1");
            }
        } else if (string.contentEquals("1")) {
            Settings.Global.putString(getActivity().getContentResolver(), "auto_time", "0");
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        int i = BaseApp.m_iUIIndex;
        Integer valueOf = Integer.valueOf(R.id.btn24Hour);
        Integer valueOf2 = Integer.valueOf(R.id.btn12Hour);
        Integer valueOf3 = Integer.valueOf(R.id.btnAutoSync);
        Integer valueOf4 = Integer.valueOf(R.id.btnOriginalTime);
        if (i == 6 || BaseApp.m_iModeSet == 19 || BaseApp.m_iUIIndex == 1 || (this.m_iUIIndex == 4 && this.isSmallResolution)) {
            this.focusViews.add(valueOf4);
            this.focusViews.add(valueOf3);
            this.focusViews.add(valueOf2);
            this.focusViews.add(valueOf);
        } else if (BaseApp.m_iUIIndex == 2) {
            this.focusViews.add(Integer.valueOf(R.id.btnSyc));
            View view = this.viewSyc;
            if (view != null && view.getVisibility() == 0) {
                this.focusViews.add(valueOf4);
                this.focusViews.add(valueOf3);
            }
            this.focusViews.add(Integer.valueOf(R.id.btnSys));
            View view2 = this.viewSys;
            if (view2 != null && view2.getVisibility() == 0) {
                this.focusViews.add(valueOf2);
                this.focusViews.add(valueOf);
            }
        } else if (this.m_iUIIndex == 4) {
            if (BaseApp.focusPage == 1) {
                this.focusViews.add(Integer.valueOf(R.id.btnSyc));
                this.focusViews.add(Integer.valueOf(R.id.btnSys));
            } else if (BaseApp.focusPage == 2) {
                View view3 = this.viewSyc;
                if (view3 != null && view3.getVisibility() == 0) {
                    this.focusViews.add(valueOf4);
                    this.focusViews.add(valueOf3);
                }
                View view4 = this.viewSys;
                if (view4 != null && view4.getVisibility() == 0) {
                    this.focusViews.add(valueOf2);
                    this.focusViews.add(valueOf);
                }
            }
        } else if (this.m_iUIIndex == 7) {
            this.focusViews.add(Integer.valueOf(R.id.btnSyc));
            this.focusViews.add(Integer.valueOf(R.id.btnSys));
        }
        BaseApp.getFocusUtil().addViewIds(this.focusViews);
    }

    public String getFragmentTag() {
        return this.TAG;
    }

    public void hideContentView() {
        super.hideContentView();
        View view = this.viewSyc;
        if (view != null && view.getVisibility() == 0) {
            this.viewSyc.setVisibility(8);
        }
        View view2 = this.viewSys;
        if (view2 != null && view2.getVisibility() == 0) {
            this.viewSys.setVisibility(8);
        }
    }
}
