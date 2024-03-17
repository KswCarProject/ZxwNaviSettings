package com.szchoiceway.settings;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.settings.FragmentVolSet_KSW;
import com.szchoiceway.settings.view.ClipScrollView;
import com.szchoiceway.settings.view.MyScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.settings.view.MySeekbar1;
import com.szchoiceway.settings.view.MySeekbar2;
import java.util.ArrayList;
import java.util.List;

public class FragmentVolSet_KSW extends FragmentBase implements View.OnClickListener {
    private static final int LAYOUT_TYPE_ANDROID = 0;
    private static final int LAYOUT_TYPE_EQ = 2;
    private static final int LAYOUT_TYPE_HIDE = -1;
    private static final int LAYOUT_TYPE_OEM = 1;
    protected static final String TAG = "FragmentVolSet_KSW";
    Integer[] arrEqClassical = {7, 1, 3};
    Integer[] arrEqCustom = {0, 0, 0};
    Integer[] arrEqDance = {5, -1, 7};
    Integer[] arrEqJazz = {1, 4, 4};
    Integer[] arrEqPop = {4, -3, 4};
    Integer[] arrEqRock = {3, -1, 5};
    CheckBox chkClassical;
    CheckBox chkDance;
    CheckBox chkJazz;
    private List<CheckBox> chkList;
    CheckBox chkPop;
    CheckBox chkRock;
    CheckBox chkUser;
    ImageView imgLeftBg;
    ImageView imgRight;
    ImageView imgRightBg;
    ImageView imgRightIcon;
    ImageView imgUser;
    int indexEqMode = 0;
    View layoutAndroid;
    View layoutEq;
    View layoutOem;
    private VolsetKSW_Receiver mModel = new VolsetKSW_Receiver();
    ScrollView mScrollView;
    IEventService mService = null;
    private SysProviderOpt mSysProviderOpt = null;
    /* access modifiers changed from: private */
    public int m_CurrFocus = -1;
    private View mainView = null;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    MySeekbar1 mySeekbar1EqAlto;
    MySeekbar1 mySeekbar1EqBass;
    MySeekbar1 mySeekbar1EqTreble;
    MySeekbar1 mySeekbar1Volume00;
    MySeekbar1 mySeekbar1Volume01;
    MySeekbar1 mySeekbar1Volume03;
    MySeekbar1 mySeekbar1Volume04;
    MySeekbar2 mySeekbar2EqAlto;
    MySeekbar2 mySeekbar2EqBass;
    MySeekbar2 mySeekbar2EqTreble;
    RadioButton rbAndroid;
    List<Integer> rbIds;
    RadioButton rbOem;
    RadioButton rbSound;
    /* access modifiers changed from: private */
    public View scrollLayout;
    SeekBar seekBarVolume00;
    SeekBar seekBarVolume01;
    SeekBar seekBarVolume03;
    SeekBar seekBarVolume04;
    SeekBar seekbarEqAlto;
    SeekBar seekbarEqBass;
    SeekBar seekbarEqTreble;
    public boolean showID8UserView = false;
    List<Integer> soundModeIds;
    TextView tvEqAlto;
    TextView tvEqBass;
    TextView tvEqTreble;
    TextView tvVolume00;
    TextView tvVolume01;
    TextView tvVolume03;
    TextView tvVolume04;
    View viewMain;
    View viewOther;
    View viewUser;
    /* access modifiers changed from: private */
    public int volume00 = 30;
    /* access modifiers changed from: private */
    public int volume01 = 30;
    private int volume02 = 30;
    /* access modifiers changed from: private */
    public int volume03 = 22;
    /* access modifiers changed from: private */
    public int volume04 = 22;
    private int volume05 = 10;

    public String getFragmentTag() {
        return TAG;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        this.mSysProviderOpt = SysProviderOpt.getInstance(getContext());
        MainActivity mainActivity = (MainActivity) getActivity();
        Log.i(TAG, "m_iUITypeVer = " + this.m_iUITypeVer);
        if (this.isSmallResolution) {
            if (isDefaultUI()) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_vol_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_vol_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_vol_set, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_vol_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_vol_set, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_vol_set, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_vol_set_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_vol_set, (ViewGroup) null);
            }
        } else if (isDefaultUI()) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_vol_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_vol_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_vol_set, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_vol_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_vol_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_volume_set, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_vol_set, (ViewGroup) null);
        }
        this.mainView = view;
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i(TAG, "onCreateView'");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.szchoiceway.settings.vol");
        getActivity().registerReceiver(this.mModel, intentFilter);
        return view;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Log.i(TAG, "onViewCreated'");
        super.onViewCreated(view, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mainView = null;
        getActivity().unregisterReceiver(this.mModel);
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        if (view != null) {
            Log.i(TAG, "--->>> bindViewListener");
            initService((IEventService) null);
            MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            this.myScrollbar = myScrollbar2;
            if (myScrollbar2 != null && this.m_iUIIndex == 2) {
                this.myScrollbar.setVisibility(8);
            }
            if (this.m_iUIIndex == 2 || this.m_iUIIndex == 7) {
                this.mScrollView = (ScrollView) view.findViewById(R.id.scSound);
            } else {
                this.mScrollView = (ScrollView) view.findViewById(R.id.mScrollView);
            }
            View findViewById = view.findViewById(R.id.scrollLayout);
            this.scrollLayout = findViewById;
            if (findViewById != null) {
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        FragmentVolSet_KSW.this.scrollLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        if (FragmentVolSet_KSW.this.mScrollView != null) {
                            FragmentVolSet_KSW.this.mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                                public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                                    FragmentVolSet_KSW.AnonymousClass1.this.lambda$onGlobalLayout$0$FragmentVolSet_KSW$1(view, i, i2, i3, i4);
                                }
                            });
                        }
                    }

                    public /* synthetic */ void lambda$onGlobalLayout$0$FragmentVolSet_KSW$1(View view, int i, int i2, int i3, int i4) {
                        float f;
                        Log.d(FragmentVolSet_KSW.TAG, "");
                        if (FragmentVolSet_KSW.this.m_CurrFocus == 17) {
                            f = (((float) i2) * 1.0f) / 54.0f;
                        } else {
                            f = (((float) i2) * 1.0f) / ((float) (FragmentVolSet_KSW.this.scrollLayout.getHeight() - FragmentVolSet_KSW.this.mScrollView.getHeight()));
                        }
                        if (FragmentVolSet_KSW.this.myScrollbar != null) {
                            FragmentVolSet_KSW.this.myScrollbar.setCurrentPercent(f);
                        }
                        if (FragmentVolSet_KSW.this.mScrollView instanceof ClipScrollView) {
                            ((ClipScrollView) FragmentVolSet_KSW.this.mScrollView).setScrollHeight(i2);
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imgRightIcon);
            this.imgRightIcon = imageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            View findViewById2 = view.findViewById(R.id.btnReturn);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        FragmentVolSet_KSW.this.lambda$bindViewListener$0$FragmentVolSet_KSW(view);
                    }
                });
            }
            View findViewById3 = view.findViewById(R.id.viewUser);
            this.viewUser = findViewById3;
            if (findViewById3 != null && this.m_iUIIndex == 4) {
                this.viewUser.setVisibility(8);
            }
            if (this.m_iUIIndex == 2) {
                this.viewMain = view.findViewById(R.id.viewMain);
                this.imgRight = (ImageView) view.findViewById(R.id.imgDirection);
                this.imgLeftBg = (ImageView) view.findViewById(R.id.imgLeftBg);
                this.imgRightBg = (ImageView) view.findViewById(R.id.imgRightBg);
                hideViews();
                this.viewOther = view.findViewById(R.id.viewOther);
                this.imgUser = (ImageView) view.findViewById(R.id.imgUser);
                showID8UserView();
                int[] iArr = {R.id.btnReduce0, R.id.btnAdd0, R.id.btnReduce1, R.id.btnAdd1, R.id.btnReduce3, R.id.btnAdd3, R.id.btnReduce4, R.id.btnAdd4, R.id.btnReduceBass, R.id.btnAddBass, R.id.btnReduceAlto, R.id.btnAddAlto, R.id.btnReduceTreble, R.id.btnAddTreble};
                for (int i = 0; i < 14; i++) {
                    View findViewById4 = this.mainView.findViewById(iArr[i]);
                    if (findViewById4 != null) {
                        findViewById4.setOnClickListener(this);
                    }
                }
            }
            this.tvVolume00 = (TextView) view.findViewById(R.id.KSW_Vol_val_00);
            this.seekBarVolume00 = (SeekBar) view.findViewById(R.id.KSW_VolSeekBar_00);
            this.mySeekbar1Volume00 = (MySeekbar1) view.findViewById(R.id.my_seekbar1_00);
            initVolumeSeekBar00(view);
            this.tvVolume01 = (TextView) view.findViewById(R.id.KSW_Vol_val_01);
            this.seekBarVolume01 = (SeekBar) view.findViewById(R.id.KSW_VolSeekBar_01);
            this.mySeekbar1Volume01 = (MySeekbar1) view.findViewById(R.id.my_seekbar1_01);
            initVolumeSeekBar01(view);
            this.tvVolume03 = (TextView) view.findViewById(R.id.KSW_Vol_val_03);
            this.seekBarVolume03 = (SeekBar) view.findViewById(R.id.KSW_VolSeekBar_03);
            this.mySeekbar1Volume03 = (MySeekbar1) view.findViewById(R.id.my_seekbar1_03);
            initVolSeekBar_03(view);
            this.tvVolume04 = (TextView) view.findViewById(R.id.KSW_Vol_val_04);
            this.seekBarVolume04 = (SeekBar) view.findViewById(R.id.KSW_VolSeekBar_04);
            this.mySeekbar1Volume04 = (MySeekbar1) view.findViewById(R.id.my_seekbar1_04);
            initVolSeekBar_04(view);
            refreshVolumeInfo();
            this.rbAndroid = (RadioButton) view.findViewById(R.id.rbAndroid);
            this.rbOem = (RadioButton) view.findViewById(R.id.rbOem);
            this.rbSound = (RadioButton) view.findViewById(R.id.rbSound);
            this.layoutAndroid = view.findViewById(R.id.viewAndroid);
            this.layoutOem = view.findViewById(R.id.viewOem);
            this.layoutEq = view.findViewById(R.id.viewSound);
            ArrayList arrayList = new ArrayList();
            this.rbIds = arrayList;
            arrayList.add(Integer.valueOf(R.id.rbAndroid));
            this.rbIds.add(Integer.valueOf(R.id.rbOem));
            this.rbIds.add(Integer.valueOf(R.id.rbSound));
            for (Integer intValue : this.rbIds) {
                View findViewById5 = view.findViewById(intValue.intValue());
                if (findViewById5 != null) {
                    findViewById5.setOnClickListener(this);
                }
            }
            if (this.m_iUIIndex == 2) {
                showLayout(-1);
            } else {
                showLayout(0);
            }
            this.chkUser = (CheckBox) view.findViewById(R.id.chkUser);
            this.chkPop = (CheckBox) view.findViewById(R.id.chkPop);
            this.chkClassical = (CheckBox) view.findViewById(R.id.chkClassical);
            this.chkRock = (CheckBox) view.findViewById(R.id.chkRock);
            this.chkJazz = (CheckBox) view.findViewById(R.id.chkJazz);
            this.chkDance = (CheckBox) view.findViewById(R.id.chkDance);
            if (this.chkUser != null) {
                ArrayList arrayList2 = new ArrayList();
                this.chkList = arrayList2;
                arrayList2.add(this.chkUser);
                this.chkList.add(this.chkPop);
                this.chkList.add(this.chkClassical);
                this.chkList.add(this.chkRock);
                this.chkList.add(this.chkJazz);
                this.chkList.add(this.chkDance);
            }
            ArrayList arrayList3 = new ArrayList();
            this.soundModeIds = arrayList3;
            arrayList3.add(Integer.valueOf(R.id.KSW_btn_eq_custom));
            this.soundModeIds.add(Integer.valueOf(R.id.KSW_btn_eq_pop));
            this.soundModeIds.add(Integer.valueOf(R.id.KSW_btn_eq_classical));
            this.soundModeIds.add(Integer.valueOf(R.id.KSW_btn_eq_rock));
            this.soundModeIds.add(Integer.valueOf(R.id.KSW_btn_eq_jazz));
            this.soundModeIds.add(Integer.valueOf(R.id.KSW_btn_eq_dance));
            for (Integer intValue2 : this.soundModeIds) {
                View findViewById6 = view.findViewById(intValue2.intValue());
                if (findViewById6 != null) {
                    findViewById6.setOnClickListener(this);
                }
            }
            this.tvEqBass = (TextView) view.findViewById(R.id.KSW_VolValue_Bass);
            this.seekbarEqBass = (SeekBar) view.findViewById(R.id.KSW_VolSeekBar_page2_low);
            this.mySeekbar1EqBass = (MySeekbar1) view.findViewById(R.id.my_seekbar1_bass);
            this.mySeekbar2EqBass = (MySeekbar2) view.findViewById(R.id.my_seekbar2_bass);
            initEqSeekbarBass();
            this.tvEqAlto = (TextView) view.findViewById(R.id.KSW_VolValue_Alto);
            this.seekbarEqAlto = (SeekBar) view.findViewById(R.id.KSW_VolSeekBar_page2_mid);
            this.mySeekbar1EqAlto = (MySeekbar1) view.findViewById(R.id.my_seekbar1_alto);
            this.mySeekbar2EqAlto = (MySeekbar2) view.findViewById(R.id.my_seekbar2_alto);
            initEqSeekbarAlto();
            this.tvEqTreble = (TextView) view.findViewById(R.id.KSW_VolValue_Treble);
            this.seekbarEqTreble = (SeekBar) view.findViewById(R.id.KSW_VolSeekBar_page2_hight);
            this.mySeekbar1EqTreble = (MySeekbar1) view.findViewById(R.id.my_seekbar1_treble);
            this.mySeekbar2EqTreble = (MySeekbar2) view.findViewById(R.id.my_seekbar2_treble);
            initEqSeekbarTreble();
            refreshEqInfo();
        }
    }

    public /* synthetic */ void lambda$bindViewListener$0$FragmentVolSet_KSW(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        Log.d(TAG, "onClick btnReturn main = " + mainActivity);
        if (mainActivity != null) {
            mainActivity.hideID8Content();
        }
    }

    /* access modifiers changed from: protected */
    public void initService(IEventService iEventService) {
        Log.i(TAG, "initService...............");
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (this.mainView == null) {
            this.mainView = getView();
        }
        if (mainActivity != null) {
            if (this.mService == null) {
                this.mService = mainActivity.getService();
            }
            Log.i(TAG, "initService: mService = " + this.mService);
            initVolumeData(this.mService);
            initEqData(this.mService);
        }
    }

    private void initVolumeData(IEventService iEventService) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null) {
            if (iEventService == null) {
                iEventService = mainActivity.getService();
            }
            if (iEventService != null) {
                try {
                    this.volume00 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_00, this.volume00);
                    this.volume01 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_01, this.volume01);
                    this.volume02 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_02, this.volume02);
                    this.volume03 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_03, this.volume03);
                    this.volume04 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_04, this.volume04);
                    this.volume05 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_05, this.volume05);
                    Log.d(TAG, "initVolSetttings_KSW iVol_00 = " + this.volume00 + ", iVol_01 = " + this.volume01 + ", iVol_03 = " + this.volume03 + ", iVol_04 = " + this.volume04);
                    refreshVolumeInfo();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mainView == null) {
            this.mainView = getView();
            Log.i(TAG, "mainView = getView();");
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
        mcu_to_vol_set_view();
    }

    public void onClick(View view) {
        if (this.focusUtil.inSeekbarKnobMode) {
            this.focusUtil.clearSeekbarFocus();
        }
        if (this.focusViews == null || this.focusViews.isEmpty()) {
            addViewIds();
        }
        if (this.m_iUIIndex == 6 || this.m_iModeSet == 19 || isDefaultUI() || (this.m_iUIIndex == 4 && this.isSmallResolution)) {
            if (this.focusViews.contains(Integer.valueOf(view.getId()))) {
                for (int i = 0; i < this.focusViews.size(); i++) {
                    if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                        this.m_CurrFocus = i;
                    }
                }
                this.baseApp.setFocusPage(1);
                this.mainActivity.m_iCurrFocus = this.m_CurrFocus;
                BaseApp.getFocusUtil().locateFragment(this, TAG);
                BaseApp.getFocusUtil().refreshSecondViews(this.mainActivity.m_iCurrFocus, false);
                if (this.m_iModeSet == 19 || isDefaultUI()) {
                    this.mainActivity.lastXFocus = 4;
                    BaseApp.getFocusUtil().refreshFirstViews(this.mainActivity, -1, false);
                } else {
                    this.mainActivity.lastXFocus = 3;
                }
            }
        } else if (this.m_iUIIndex == 2) {
            if (this.rbIds.contains(Integer.valueOf(view.getId()))) {
                BaseApp.getFocusUtil().refreshThirdViews(-1, false);
                for (int i2 = 0; i2 < this.rbIds.size(); i2++) {
                    if (view.getId() == this.rbIds.get(i2).intValue()) {
                        this.m_CurrFocus = i2;
                    }
                }
                Log.d(TAG, "onClick rbids m_CurrFocus = " + this.m_CurrFocus);
                this.baseApp.setFocusPage(1);
                this.mainActivity.m_iCurrFocus = this.m_CurrFocus;
                BaseApp.getFocusUtil().refreshSecondViews(this.mainActivity.m_iCurrFocus, false);
            } else if (this.soundModeIds.contains(Integer.valueOf(view.getId()))) {
                for (int i3 = 0; i3 < this.soundModeIds.size(); i3++) {
                    if (view.getId() == this.soundModeIds.get(i3).intValue()) {
                        this.m_CurrFocus = i3;
                    }
                }
                Log.d(TAG, "onClick soundModeIds m_CurrFocus = " + this.m_CurrFocus);
                this.baseApp.setFocusPage(2);
                this.mainActivity.m_iCurrFocus = this.m_CurrFocus;
                this.mainActivity.lastYFocus = 2;
                BaseApp.getFocusUtil().refreshSecondViews(-1, false);
                BaseApp.getFocusUtil().refreshThirdViews(this.mainActivity.m_iCurrFocus, false);
            } else if (R.id.btnReduce0 == view.getId() || R.id.btnAdd0 == view.getId() || R.id.btnReduce1 == view.getId() || R.id.btnAdd1 == view.getId() || R.id.btnReduce3 == view.getId() || R.id.btnAdd3 == view.getId() || R.id.btnReduce4 == view.getId() || R.id.btnAdd4 == view.getId() || R.id.btnReduceBass == view.getId() || R.id.btnReduceBass == view.getId() || R.id.btnReduceAlto == view.getId() || R.id.btnReduceAlto == view.getId() || R.id.btnReduceTreble == view.getId() || R.id.btnReduceTreble == view.getId()) {
                ImageView imageView = this.imgLeftBg;
                if (!(imageView == null || imageView.getVisibility() == 8)) {
                    this.imgLeftBg.setVisibility(8);
                }
                ImageView imageView2 = this.imgRightBg;
                if (!(imageView2 == null || imageView2.getVisibility() == 0)) {
                    this.imgRightBg.setVisibility(0);
                }
            }
        } else if (this.m_iUIIndex == 7) {
            this.mainActivity.lastXFocus = 2;
            BaseApp.getFocusUtil().refreshFirstViews(this.mainActivity, -1, false);
            if (this.rbIds.contains(Integer.valueOf(view.getId()))) {
                BaseApp.getFocusUtil().refreshThirdViews(-1, false);
                this.baseApp.setFocusPage(1);
                for (int i4 = 0; i4 < this.rbIds.size(); i4++) {
                    if (view.getId() == this.rbIds.get(i4).intValue()) {
                        this.m_CurrFocus = i4;
                    }
                }
                this.mainActivity.m_iCurrFocus = this.m_CurrFocus;
                BaseApp.getFocusUtil().refreshSecondViews(this.mainActivity.m_iCurrFocus, false);
            } else if (this.soundModeIds.contains(Integer.valueOf(view.getId()))) {
                this.mainActivity.lastYFocus = 2;
                BaseApp.getFocusUtil().refreshSecondViews(-1, false);
                this.baseApp.setFocusPage(2);
                for (int i5 = 0; i5 < this.soundModeIds.size(); i5++) {
                    if (view.getId() == this.soundModeIds.get(i5).intValue()) {
                        this.m_CurrFocus = i5 + 3;
                    }
                }
                this.mainActivity.m_iCurrFocus = this.m_CurrFocus;
                BaseApp.getFocusUtil().refreshThirdViews(this.mainActivity.m_iCurrFocus, false);
            }
        } else if (this.m_iUIIndex == 4) {
            for (int i6 = 0; i6 < this.focusViews.size(); i6++) {
                if (view.getId() == ((Integer) this.focusViews.get(i6)).intValue()) {
                    this.m_CurrFocus = i6;
                }
            }
            this.mainActivity.m_iCurrFocus = this.m_CurrFocus;
            BaseApp.getFocusUtil().refreshSecondViews(this.mainActivity.m_iCurrFocus, false);
        }
        switch (view.getId()) {
            case R.id.KSW_btn_eq_classical /*2131230799*/:
                this.indexEqMode = 2;
                refreshEqInfo();
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.KSW_btn_eq_custom /*2131230800*/:
                Log.d(TAG, "onClick KSW_btn_eq_custom chkUser.isChecked() = " + this.chkUser.isChecked());
                this.indexEqMode = 0;
                refreshEqInfo();
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                if ((this.m_iUIIndex == 2 || this.m_iUIIndex == 4) && this.chkUser.isChecked()) {
                    this.showID8UserView = !this.showID8UserView;
                    showID8UserView();
                    return;
                }
                return;
            case R.id.KSW_btn_eq_dance /*2131230801*/:
                this.indexEqMode = 5;
                refreshEqInfo();
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.KSW_btn_eq_jazz /*2131230802*/:
                this.indexEqMode = 4;
                refreshEqInfo();
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.KSW_btn_eq_pop /*2131230803*/:
                this.indexEqMode = 1;
                refreshEqInfo();
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.KSW_btn_eq_rock /*2131230804*/:
                this.indexEqMode = 3;
                refreshEqInfo();
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.btnAdd0 /*2131230926*/:
                int i7 = this.volume00 + 1;
                this.volume00 = i7;
                if (i7 > 40) {
                    this.volume00 = 40;
                }
                this.tvVolume00.setText("" + this.volume00);
                this.mySeekbar1Volume00.setCurrentProgress(this.volume00);
                SendVolVal_KSW(false, 1, 1, this.volume00);
                SaveVolSettings_KSW();
                return;
            case R.id.btnAdd1 /*2131230927*/:
                int i8 = this.volume01 + 1;
                this.volume01 = i8;
                if (i8 > 40) {
                    this.volume01 = 40;
                }
                this.tvVolume01.setText("" + this.volume01);
                this.mySeekbar1Volume01.setCurrentProgress(this.volume01);
                SendVolVal_KSW(false, 1, 2, this.volume01);
                SaveVolSettings_KSW();
                return;
            case R.id.btnAdd3 /*2131230929*/:
                int i9 = this.volume03 + 1;
                this.volume03 = i9;
                if (i9 > 40) {
                    this.volume03 = 40;
                }
                this.tvVolume03.setText("" + this.volume03);
                this.mySeekbar1Volume03.setCurrentProgress(this.volume03);
                SendVolVal_KSW(false, 2, 2, this.volume03);
                SaveVolSettings_KSW();
                return;
            case R.id.btnAdd4 /*2131230930*/:
                int i10 = this.volume04 + 1;
                this.volume04 = i10;
                if (i10 > 40) {
                    this.volume04 = 40;
                }
                this.tvVolume04.setText("" + this.volume04);
                this.mySeekbar1Volume04.setCurrentProgress(this.volume04);
                SendVolVal_KSW(false, 2, 3, this.volume04);
                SaveVolSettings_KSW();
                return;
            case R.id.btnAddAlto /*2131230931*/:
                Integer[] numArr = this.arrEqCustom;
                Integer num = numArr[1];
                numArr[1] = Integer.valueOf(numArr[1].intValue() + 1);
                if (this.arrEqCustom[1].intValue() > 12) {
                    this.arrEqCustom[1] = 12;
                }
                if (this.tvEqAlto != null) {
                    if (this.arrEqCustom[1].intValue() > 0) {
                        this.tvEqAlto.setText("+" + this.arrEqCustom[1]);
                    } else {
                        this.tvEqAlto.setText("" + this.arrEqCustom[1]);
                    }
                }
                this.mySeekbar2EqAlto.setCurrentProgress(this.arrEqCustom[1].intValue() + 12);
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.btnAddBass /*2131230933*/:
                Integer[] numArr2 = this.arrEqCustom;
                Integer num2 = numArr2[0];
                numArr2[0] = Integer.valueOf(numArr2[0].intValue() + 1);
                if (this.arrEqCustom[0].intValue() > 12) {
                    this.arrEqCustom[0] = 12;
                }
                if (this.tvEqBass != null) {
                    if (this.arrEqCustom[0].intValue() > 0) {
                        this.tvEqBass.setText("+" + this.arrEqCustom[0]);
                    } else {
                        this.tvEqBass.setText("" + this.arrEqCustom[0]);
                    }
                }
                this.mySeekbar2EqBass.setCurrentProgress(this.arrEqCustom[0].intValue() + 12);
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.btnAddTreble /*2131230934*/:
                Integer[] numArr3 = this.arrEqCustom;
                Integer num3 = numArr3[2];
                numArr3[2] = Integer.valueOf(numArr3[2].intValue() + 1);
                if (this.arrEqCustom[2].intValue() > 12) {
                    this.arrEqCustom[2] = 12;
                }
                if (this.tvEqTreble != null) {
                    if (this.arrEqCustom[2].intValue() > 0) {
                        this.tvEqTreble.setText("+" + this.arrEqCustom[2]);
                    } else {
                        this.tvEqTreble.setText("" + this.arrEqCustom[2]);
                    }
                }
                this.mySeekbar2EqTreble.setCurrentProgress(this.arrEqCustom[2].intValue() + 12);
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.btnReduce0 /*2131231023*/:
                int i11 = this.volume00 - 1;
                this.volume00 = i11;
                if (i11 < 0) {
                    this.volume00 = 0;
                }
                this.tvVolume00.setText("" + this.volume00);
                this.mySeekbar1Volume00.setCurrentProgress(this.volume00);
                SendVolVal_KSW(false, 1, 1, this.volume00);
                SaveVolSettings_KSW();
                return;
            case R.id.btnReduce1 /*2131231024*/:
                int i12 = this.volume01 - 1;
                this.volume01 = i12;
                if (i12 < 0) {
                    this.volume01 = 0;
                }
                this.tvVolume01.setText("" + this.volume01);
                this.mySeekbar1Volume01.setCurrentProgress(this.volume01);
                SendVolVal_KSW(false, 1, 2, this.volume01);
                SaveVolSettings_KSW();
                return;
            case R.id.btnReduce3 /*2131231026*/:
                int i13 = this.volume03 - 1;
                this.volume03 = i13;
                if (i13 < 0) {
                    this.volume03 = 0;
                }
                this.tvVolume03.setText("" + this.volume03);
                this.mySeekbar1Volume03.setCurrentProgress(this.volume03);
                SendVolVal_KSW(false, 2, 2, this.volume03);
                SaveVolSettings_KSW();
                return;
            case R.id.btnReduce4 /*2131231027*/:
                int i14 = this.volume04 - 1;
                this.volume04 = i14;
                if (i14 < 0) {
                    this.volume04 = 0;
                }
                this.tvVolume04.setText("" + this.volume04);
                this.mySeekbar1Volume04.setCurrentProgress(this.volume04);
                SendVolVal_KSW(false, 2, 3, this.volume04);
                SaveVolSettings_KSW();
                return;
            case R.id.btnReduceAlto /*2131231028*/:
                Integer[] numArr4 = this.arrEqCustom;
                Integer num4 = numArr4[1];
                numArr4[1] = Integer.valueOf(numArr4[1].intValue() - 1);
                if (this.arrEqCustom[1].intValue() < -12) {
                    this.arrEqCustom[1] = -12;
                }
                if (this.tvEqAlto != null) {
                    if (this.arrEqCustom[1].intValue() > 0) {
                        this.tvEqAlto.setText("+" + this.arrEqCustom[1]);
                    } else {
                        this.tvEqAlto.setText("" + this.arrEqCustom[1]);
                    }
                }
                this.mySeekbar2EqAlto.setCurrentProgress(this.arrEqCustom[1].intValue() + 12);
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.btnReduceBass /*2131231030*/:
                Integer[] numArr5 = this.arrEqCustom;
                Integer num5 = numArr5[0];
                numArr5[0] = Integer.valueOf(numArr5[0].intValue() - 1);
                if (this.arrEqCustom[0].intValue() < -12) {
                    this.arrEqCustom[0] = -12;
                }
                if (this.tvEqBass != null) {
                    if (this.arrEqCustom[0].intValue() > 0) {
                        this.tvEqBass.setText("+" + this.arrEqCustom[0]);
                    } else {
                        this.tvEqBass.setText("" + this.arrEqCustom[0]);
                    }
                }
                this.mySeekbar2EqBass.setCurrentProgress(this.arrEqCustom[0].intValue() + 12);
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.btnReduceTreble /*2131231031*/:
                Integer[] numArr6 = this.arrEqCustom;
                Integer num6 = numArr6[2];
                numArr6[2] = Integer.valueOf(numArr6[2].intValue() - 1);
                if (this.arrEqCustom[2].intValue() < -12) {
                    this.arrEqCustom[2] = -12;
                }
                if (this.tvEqTreble != null) {
                    if (this.arrEqCustom[2].intValue() > 0) {
                        this.tvEqTreble.setText("+" + this.arrEqCustom[2]);
                    } else {
                        this.tvEqTreble.setText("" + this.arrEqCustom[2]);
                    }
                }
                this.mySeekbar2EqTreble.setCurrentProgress(this.arrEqCustom[2].intValue() + 12);
                send_KSW_page2_vol_info();
                save_KSW_set_page2_vol_info();
                return;
            case R.id.rbAndroid /*2131231336*/:
                showLayout(0);
                return;
            case R.id.rbOem /*2131231337*/:
                showLayout(1);
                return;
            case R.id.rbSound /*2131231338*/:
                showLayout(2);
                return;
            default:
                return;
        }
    }

    public void SendVolVal_KSW(boolean z, int i, int i2, int i3) {
        IEventService service;
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null && (service = mainActivity.getService()) != null) {
            try {
                service.SendVol_KSW(z, i, i2, i3);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void SaveVolSettings_KSW() {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        IEventService service = mainActivity != null ? mainActivity.getService() : null;
        try {
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_00, this.volume00);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_01, this.volume01);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_02, this.volume02);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_03, this.volume03);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_04, this.volume04);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_05, this.volume05);
            service.appySetting();
            service.commitSetting();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void sendMuteState(boolean z) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        IEventService service = mainActivity != null ? mainActivity.getService() : null;
        if (service != null) {
            try {
                service.sendMuteState(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void initVolumeSeekBar00(View view) {
        if (view != null) {
            MySeekbar1 mySeekbar1 = this.mySeekbar1Volume00;
            if (mySeekbar1 != null) {
                mySeekbar1.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                    public void onSeekTouch() {
                    }

                    public void onSeeking(int i) {
                        int unused = FragmentVolSet_KSW.this.volume00 = i;
                        if (FragmentVolSet_KSW.this.tvVolume00 != null) {
                            FragmentVolSet_KSW.this.tvVolume00.setText("" + FragmentVolSet_KSW.this.volume00);
                            if (FragmentVolSet_KSW.this.m_iUIIndex == 2) {
                                FragmentVolSet_KSW.this.tvVolume00.setTextColor(FragmentVolSet_KSW.this.mainActivity.getColor(FragmentVolSet_KSW.this.getAttrId(R.attr.ksw_id8_fontColor)));
                            }
                        }
                        FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                        fragmentVolSet_KSW.SendVolVal_KSW(false, 1, 1, fragmentVolSet_KSW.volume00);
                    }

                    public void onSeekStop(int i) {
                        int unused = FragmentVolSet_KSW.this.volume00 = i;
                        if (FragmentVolSet_KSW.this.tvVolume00 != null) {
                            FragmentVolSet_KSW.this.tvVolume00.setText("" + FragmentVolSet_KSW.this.volume00);
                            if (!FragmentVolSet_KSW.this.focusUtil.inSeekbarKnobMode) {
                                FragmentVolSet_KSW.this.tvVolume00.setTextColor(-1);
                            }
                        }
                        FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                        fragmentVolSet_KSW.SendVolVal_KSW(false, 1, 1, fragmentVolSet_KSW.volume00);
                        FragmentVolSet_KSW.this.SaveVolSettings_KSW();
                    }
                });
            }
            SeekBar seekBar = this.seekBarVolume00;
            if (seekBar != null) {
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                        FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                        int unused = fragmentVolSet_KSW.volume00 = fragmentVolSet_KSW.seekBarVolume00.getProgress();
                        if (FragmentVolSet_KSW.this.tvVolume00 != null) {
                            FragmentVolSet_KSW.this.tvVolume00.setText("" + FragmentVolSet_KSW.this.volume00 + "");
                        }
                        FragmentVolSet_KSW fragmentVolSet_KSW2 = FragmentVolSet_KSW.this;
                        fragmentVolSet_KSW2.SendVolVal_KSW(false, 1, 1, fragmentVolSet_KSW2.volume00);
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                        int unused = fragmentVolSet_KSW.volume00 = fragmentVolSet_KSW.seekBarVolume00.getProgress();
                        if (FragmentVolSet_KSW.this.tvVolume00 != null) {
                            FragmentVolSet_KSW.this.tvVolume00.setText("" + FragmentVolSet_KSW.this.volume00 + "");
                        }
                        FragmentVolSet_KSW.this.SaveVolSettings_KSW();
                        FragmentVolSet_KSW fragmentVolSet_KSW2 = FragmentVolSet_KSW.this;
                        fragmentVolSet_KSW2.sendMuteState(fragmentVolSet_KSW2.volume00 == 0);
                    }
                });
            }
        }
    }

    public void initVolumeSeekBar01(View view) {
        MySeekbar1 mySeekbar1 = this.mySeekbar1Volume01;
        if (mySeekbar1 != null) {
            mySeekbar1.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                }

                public void onSeeking(int i) {
                    int unused = FragmentVolSet_KSW.this.volume01 = i;
                    FragmentVolSet_KSW.this.tvVolume01.setText("" + FragmentVolSet_KSW.this.volume01);
                    if (FragmentVolSet_KSW.this.m_iUIIndex == 2) {
                        FragmentVolSet_KSW.this.tvVolume01.setTextColor(FragmentVolSet_KSW.this.mainActivity.getColor(FragmentVolSet_KSW.this.getAttrId(R.attr.ksw_id8_fontColor)));
                    }
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    fragmentVolSet_KSW.SendVolVal_KSW(false, 1, 2, fragmentVolSet_KSW.volume01);
                }

                public void onSeekStop(int i) {
                    int unused = FragmentVolSet_KSW.this.volume01 = i;
                    FragmentVolSet_KSW.this.tvVolume01.setText("" + FragmentVolSet_KSW.this.volume01);
                    if (!FragmentVolSet_KSW.this.focusUtil.inSeekbarKnobMode) {
                        FragmentVolSet_KSW.this.tvVolume01.setTextColor(-1);
                    }
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    fragmentVolSet_KSW.SendVolVal_KSW(false, 1, 2, fragmentVolSet_KSW.volume01);
                    FragmentVolSet_KSW.this.SaveVolSettings_KSW();
                }
            });
        }
        SeekBar seekBar = this.seekBarVolume01;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    int unused = fragmentVolSet_KSW.volume01 = fragmentVolSet_KSW.seekBarVolume01.getProgress();
                    if (FragmentVolSet_KSW.this.tvVolume01 != null) {
                        FragmentVolSet_KSW.this.tvVolume01.setText("" + FragmentVolSet_KSW.this.volume01);
                    }
                    FragmentVolSet_KSW fragmentVolSet_KSW2 = FragmentVolSet_KSW.this;
                    fragmentVolSet_KSW2.SendVolVal_KSW(false, 1, 2, fragmentVolSet_KSW2.volume01);
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    int unused = fragmentVolSet_KSW.volume01 = fragmentVolSet_KSW.seekBarVolume01.getProgress();
                    if (FragmentVolSet_KSW.this.tvVolume01 != null) {
                        FragmentVolSet_KSW.this.tvVolume01.setText("" + FragmentVolSet_KSW.this.volume01 + "");
                    }
                    FragmentVolSet_KSW.this.SaveVolSettings_KSW();
                }
            });
        }
    }

    public void initVolSeekBar_03(View view) {
        MySeekbar1 mySeekbar1 = this.mySeekbar1Volume03;
        if (mySeekbar1 != null) {
            mySeekbar1.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                }

                public void onSeeking(int i) {
                    int unused = FragmentVolSet_KSW.this.volume03 = i;
                    FragmentVolSet_KSW.this.tvVolume03.setText("" + FragmentVolSet_KSW.this.volume03);
                    if (FragmentVolSet_KSW.this.m_iUIIndex == 2) {
                        FragmentVolSet_KSW.this.tvVolume03.setTextColor(FragmentVolSet_KSW.this.mainActivity.getColor(FragmentVolSet_KSW.this.getAttrId(R.attr.ksw_id8_fontColor)));
                    }
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    fragmentVolSet_KSW.SendVolVal_KSW(false, 2, 2, fragmentVolSet_KSW.volume03);
                }

                public void onSeekStop(int i) {
                    int unused = FragmentVolSet_KSW.this.volume03 = i;
                    FragmentVolSet_KSW.this.tvVolume03.setText("" + FragmentVolSet_KSW.this.volume03);
                    if (!FragmentVolSet_KSW.this.focusUtil.inSeekbarKnobMode) {
                        FragmentVolSet_KSW.this.tvVolume03.setTextColor(-1);
                    }
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    fragmentVolSet_KSW.SendVolVal_KSW(false, 2, 2, fragmentVolSet_KSW.volume03);
                    FragmentVolSet_KSW.this.SaveVolSettings_KSW();
                }
            });
        }
        SeekBar seekBar = this.seekBarVolume03;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    int unused = fragmentVolSet_KSW.volume03 = fragmentVolSet_KSW.seekBarVolume03.getProgress();
                    if (FragmentVolSet_KSW.this.tvVolume03 != null) {
                        FragmentVolSet_KSW.this.tvVolume03.setText("" + FragmentVolSet_KSW.this.volume03 + "");
                    }
                    FragmentVolSet_KSW fragmentVolSet_KSW2 = FragmentVolSet_KSW.this;
                    fragmentVolSet_KSW2.SendVolVal_KSW(false, 2, 2, fragmentVolSet_KSW2.volume03);
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    System.out.println("onStopTrackingTouch*******************");
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    int unused = fragmentVolSet_KSW.volume03 = fragmentVolSet_KSW.seekBarVolume03.getProgress();
                    if (FragmentVolSet_KSW.this.tvVolume03 != null) {
                        FragmentVolSet_KSW.this.tvVolume03.setText("" + FragmentVolSet_KSW.this.volume03 + "");
                    }
                    FragmentVolSet_KSW.this.SaveVolSettings_KSW();
                }
            });
        }
    }

    public void initVolSeekBar_04(View view) {
        MySeekbar1 mySeekbar1 = this.mySeekbar1Volume04;
        if (mySeekbar1 != null) {
            mySeekbar1.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                }

                public void onSeeking(int i) {
                    int unused = FragmentVolSet_KSW.this.volume04 = i;
                    FragmentVolSet_KSW.this.tvVolume04.setText("" + FragmentVolSet_KSW.this.volume04);
                    if (FragmentVolSet_KSW.this.m_iUIIndex == 2) {
                        FragmentVolSet_KSW.this.tvVolume04.setTextColor(FragmentVolSet_KSW.this.mainActivity.getColor(FragmentVolSet_KSW.this.getAttrId(R.attr.ksw_id8_fontColor)));
                    }
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    fragmentVolSet_KSW.SendVolVal_KSW(false, 2, 3, fragmentVolSet_KSW.volume04);
                }

                public void onSeekStop(int i) {
                    int unused = FragmentVolSet_KSW.this.volume04 = i;
                    FragmentVolSet_KSW.this.tvVolume04.setText("" + FragmentVolSet_KSW.this.volume04);
                    if (!FragmentVolSet_KSW.this.focusUtil.inSeekbarKnobMode) {
                        FragmentVolSet_KSW.this.tvVolume04.setTextColor(-1);
                    }
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    fragmentVolSet_KSW.SendVolVal_KSW(false, 2, 3, fragmentVolSet_KSW.volume04);
                    FragmentVolSet_KSW.this.SaveVolSettings_KSW();
                }
            });
        }
        SeekBar seekBar = this.seekBarVolume04;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    System.out.println("onProgressChanged*******************");
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    int unused = fragmentVolSet_KSW.volume04 = fragmentVolSet_KSW.seekBarVolume04.getProgress();
                    if (FragmentVolSet_KSW.this.tvVolume04 != null) {
                        FragmentVolSet_KSW.this.tvVolume04.setText("" + FragmentVolSet_KSW.this.volume04);
                    }
                    FragmentVolSet_KSW fragmentVolSet_KSW2 = FragmentVolSet_KSW.this;
                    fragmentVolSet_KSW2.SendVolVal_KSW(false, 2, 3, fragmentVolSet_KSW2.volume04);
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    FragmentVolSet_KSW fragmentVolSet_KSW = FragmentVolSet_KSW.this;
                    int unused = fragmentVolSet_KSW.volume04 = fragmentVolSet_KSW.seekBarVolume04.getProgress();
                    if (FragmentVolSet_KSW.this.tvVolume03 != null) {
                        FragmentVolSet_KSW.this.tvVolume03.setText("" + FragmentVolSet_KSW.this.volume04);
                    }
                    FragmentVolSet_KSW.this.SaveVolSettings_KSW();
                }
            });
        }
    }

    private void refreshVolumeInfo() {
        TextView textView = this.tvVolume00;
        if (textView != null) {
            textView.setText("" + this.volume00);
        }
        SeekBar seekBar = this.seekBarVolume00;
        if (seekBar != null) {
            seekBar.setProgress(this.volume00);
        }
        MySeekbar1 mySeekbar1 = this.mySeekbar1Volume00;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.volume00);
        }
        TextView textView2 = this.tvVolume01;
        if (textView2 != null) {
            textView2.setText("" + this.volume01);
        }
        SeekBar seekBar2 = this.seekBarVolume01;
        if (seekBar2 != null) {
            seekBar2.setProgress(this.volume01);
        }
        MySeekbar1 mySeekbar12 = this.mySeekbar1Volume01;
        if (mySeekbar12 != null) {
            mySeekbar12.setCurrentProgress(this.volume01);
        }
        TextView textView3 = this.tvVolume03;
        if (textView3 != null) {
            textView3.setText("" + this.volume03);
        }
        SeekBar seekBar3 = this.seekBarVolume03;
        if (seekBar3 != null) {
            seekBar3.setProgress(this.volume03);
        }
        MySeekbar1 mySeekbar13 = this.mySeekbar1Volume03;
        if (mySeekbar13 != null) {
            mySeekbar13.setCurrentProgress(this.volume03);
        }
        TextView textView4 = this.tvVolume04;
        if (textView4 != null) {
            textView4.setText("" + this.volume04);
        }
        SeekBar seekBar4 = this.seekBarVolume04;
        if (seekBar4 != null) {
            seekBar4.setProgress(this.volume04);
        }
        MySeekbar1 mySeekbar14 = this.mySeekbar1Volume04;
        if (mySeekbar14 != null) {
            mySeekbar14.setCurrentProgress(this.volume04);
        }
    }

    private void refreshEqInfo() {
        String str;
        String str2;
        String str3;
        Log.d(TAG, "refresh_vol_info ksw_m_i_eq_mode = " + this.indexEqMode);
        if (this.chkList != null) {
            boolean z = false;
            for (int i = 0; i < this.chkList.size(); i++) {
                CheckBox checkBox = this.chkList.get(i);
                if (checkBox != null) {
                    if (i == this.indexEqMode) {
                        checkBox.setChecked(true);
                    } else {
                        checkBox.setChecked(false);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.arrEqCustom);
            arrayList.add(this.arrEqPop);
            arrayList.add(this.arrEqClassical);
            arrayList.add(this.arrEqRock);
            arrayList.add(this.arrEqJazz);
            arrayList.add(this.arrEqDance);
            int i2 = this.indexEqMode;
            if (i2 < 6 && i2 >= 0) {
                TextView textView = this.tvEqBass;
                if (textView != null) {
                    if (((Integer[]) arrayList.get(i2))[0].intValue() > 0) {
                        str3 = "+" + ((Integer[]) arrayList.get(this.indexEqMode))[0];
                    } else {
                        str3 = "" + ((Integer[]) arrayList.get(this.indexEqMode))[0];
                    }
                    textView.setText(str3);
                }
                SeekBar seekBar = this.seekbarEqBass;
                if (seekBar != null) {
                    seekBar.setProgress(((Integer[]) arrayList.get(this.indexEqMode))[0].intValue() + 12);
                }
                MySeekbar1 mySeekbar1 = this.mySeekbar1EqBass;
                if (mySeekbar1 != null) {
                    mySeekbar1.setCurrentProgress(((Integer[]) arrayList.get(this.indexEqMode))[0].intValue() + 12);
                    this.mySeekbar1EqBass.setEnable(this.indexEqMode == 0);
                }
                MySeekbar2 mySeekbar2 = this.mySeekbar2EqBass;
                if (mySeekbar2 != null) {
                    mySeekbar2.setCurrentProgress(((Integer[]) arrayList.get(this.indexEqMode))[0].intValue() + 12);
                }
                TextView textView2 = this.tvEqAlto;
                if (textView2 != null) {
                    if (((Integer[]) arrayList.get(this.indexEqMode))[1].intValue() > 0) {
                        str2 = "+" + ((Integer[]) arrayList.get(this.indexEqMode))[1];
                    } else {
                        str2 = "" + ((Integer[]) arrayList.get(this.indexEqMode))[1];
                    }
                    textView2.setText(str2);
                }
                SeekBar seekBar2 = this.seekbarEqAlto;
                if (seekBar2 != null) {
                    seekBar2.setProgress(((Integer[]) arrayList.get(this.indexEqMode))[1].intValue() + 12);
                }
                MySeekbar1 mySeekbar12 = this.mySeekbar1EqAlto;
                if (mySeekbar12 != null) {
                    mySeekbar12.setCurrentProgress(((Integer[]) arrayList.get(this.indexEqMode))[1].intValue() + 12);
                    this.mySeekbar1EqAlto.setEnable(this.indexEqMode == 0);
                }
                MySeekbar2 mySeekbar22 = this.mySeekbar2EqAlto;
                if (mySeekbar22 != null) {
                    mySeekbar22.setCurrentProgress(((Integer[]) arrayList.get(this.indexEqMode))[1].intValue() + 12);
                }
                TextView textView3 = this.tvEqTreble;
                if (textView3 != null) {
                    if (((Integer[]) arrayList.get(this.indexEqMode))[2].intValue() > 0) {
                        str = "+" + ((Integer[]) arrayList.get(this.indexEqMode))[2];
                    } else {
                        str = "" + ((Integer[]) arrayList.get(this.indexEqMode))[2];
                    }
                    textView3.setText(str);
                }
                SeekBar seekBar3 = this.seekbarEqTreble;
                if (seekBar3 != null) {
                    seekBar3.setProgress(((Integer[]) arrayList.get(this.indexEqMode))[2].intValue() + 12);
                }
                MySeekbar1 mySeekbar13 = this.mySeekbar1EqTreble;
                if (mySeekbar13 != null) {
                    mySeekbar13.setCurrentProgress(((Integer[]) arrayList.get(this.indexEqMode))[2].intValue() + 12);
                    MySeekbar1 mySeekbar14 = this.mySeekbar1EqTreble;
                    if (this.indexEqMode == 0) {
                        z = true;
                    }
                    mySeekbar14.setEnable(z);
                }
                MySeekbar2 mySeekbar23 = this.mySeekbar2EqTreble;
                if (mySeekbar23 != null) {
                    mySeekbar23.setCurrentProgress(((Integer[]) arrayList.get(this.indexEqMode))[2].intValue() + 12);
                }
            }
        }
    }

    private void initEqSeekbarBass() {
        MySeekbar2 mySeekbar2 = this.mySeekbar2EqBass;
        if (mySeekbar2 != null) {
            mySeekbar2.setOnSeekListener(new MySeekbar2.OnSeekListener() {
                public void onSeekTouch() {
                }

                public void onSeeking(int i) {
                    FragmentVolSet_KSW.this.arrEqCustom[0] = Integer.valueOf(i - 12);
                    if (FragmentVolSet_KSW.this.tvEqBass != null) {
                        if (FragmentVolSet_KSW.this.arrEqCustom[0].intValue() > 0) {
                            FragmentVolSet_KSW.this.tvEqBass.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                        } else {
                            FragmentVolSet_KSW.this.tvEqBass.setText("" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                        }
                        if (FragmentVolSet_KSW.this.m_iUIIndex == 2) {
                            FragmentVolSet_KSW.this.tvEqBass.setTextColor(FragmentVolSet_KSW.this.mainActivity.getColor(FragmentVolSet_KSW.this.getAttrId(R.attr.ksw_id8_fontColor)));
                        }
                    }
                    FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                }

                public void onSeekStop(int i) {
                    FragmentVolSet_KSW.this.arrEqCustom[0] = Integer.valueOf(i - 12);
                    if (FragmentVolSet_KSW.this.tvEqBass != null) {
                        if (FragmentVolSet_KSW.this.arrEqCustom[0].intValue() > 0) {
                            FragmentVolSet_KSW.this.tvEqBass.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                        } else {
                            FragmentVolSet_KSW.this.tvEqBass.setText("" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                        }
                        if (!FragmentVolSet_KSW.this.focusUtil.inSeekbarKnobMode) {
                            FragmentVolSet_KSW.this.tvEqBass.setTextColor(-1);
                        }
                    }
                    FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                    FragmentVolSet_KSW.this.save_KSW_set_page2_vol_info();
                }
            });
        }
        MySeekbar1 mySeekbar1 = this.mySeekbar1EqBass;
        if (mySeekbar1 != null) {
            mySeekbar1.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolSet_KSW.this.setScrollEnable(false);
                    if (FragmentVolSet_KSW.this.indexEqMode != 0) {
                    }
                }

                public void onSeeking(int i) {
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[0] = Integer.valueOf(i - 12);
                        if (FragmentVolSet_KSW.this.tvEqBass != null) {
                            if (FragmentVolSet_KSW.this.arrEqCustom[0].intValue() > 0) {
                                FragmentVolSet_KSW.this.tvEqBass.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                            } else {
                                FragmentVolSet_KSW.this.tvEqBass.setText("" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                            }
                        }
                        FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                    }
                }

                public void onSeekStop(int i) {
                    FragmentVolSet_KSW.this.setScrollEnable(true);
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[0] = Integer.valueOf(i - 12);
                        if (FragmentVolSet_KSW.this.tvEqBass != null) {
                            if (FragmentVolSet_KSW.this.arrEqCustom[0].intValue() > 0) {
                                FragmentVolSet_KSW.this.tvEqBass.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                            } else {
                                FragmentVolSet_KSW.this.tvEqBass.setText("" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                            }
                        }
                        FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                        FragmentVolSet_KSW.this.save_KSW_set_page2_vol_info();
                    }
                }
            });
        }
        SeekBar seekBar = this.seekbarEqBass;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[0] = Integer.valueOf(FragmentVolSet_KSW.this.seekbarEqBass.getProgress() - 12);
                        if (FragmentVolSet_KSW.this.tvEqBass != null) {
                            FragmentVolSet_KSW.this.tvEqBass.setText("" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                        }
                        FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                    }
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[0] = Integer.valueOf(FragmentVolSet_KSW.this.seekbarEqBass.getProgress() - 12);
                        if (FragmentVolSet_KSW.this.tvEqBass != null) {
                            FragmentVolSet_KSW.this.tvEqBass.setText("" + FragmentVolSet_KSW.this.arrEqCustom[0]);
                        }
                        FragmentVolSet_KSW.this.save_KSW_set_page2_vol_info();
                    }
                }
            });
        }
    }

    private void initEqSeekbarAlto() {
        MySeekbar2 mySeekbar2 = this.mySeekbar2EqAlto;
        if (mySeekbar2 != null) {
            mySeekbar2.setOnSeekListener(new MySeekbar2.OnSeekListener() {
                public void onSeekTouch() {
                }

                public void onSeeking(int i) {
                    FragmentVolSet_KSW.this.arrEqCustom[1] = Integer.valueOf(i - 12);
                    if (FragmentVolSet_KSW.this.tvEqAlto != null) {
                        if (FragmentVolSet_KSW.this.arrEqCustom[1].intValue() > 0) {
                            FragmentVolSet_KSW.this.tvEqAlto.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                        } else {
                            FragmentVolSet_KSW.this.tvEqAlto.setText("" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                        }
                        if (FragmentVolSet_KSW.this.m_iUIIndex == 2) {
                            FragmentVolSet_KSW.this.tvEqAlto.setTextColor(FragmentVolSet_KSW.this.mainActivity.getColor(FragmentVolSet_KSW.this.getAttrId(R.attr.ksw_id8_fontColor)));
                        }
                    }
                    FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                }

                public void onSeekStop(int i) {
                    FragmentVolSet_KSW.this.arrEqCustom[1] = Integer.valueOf(i - 12);
                    if (FragmentVolSet_KSW.this.tvEqAlto != null) {
                        if (FragmentVolSet_KSW.this.arrEqCustom[1].intValue() > 0) {
                            FragmentVolSet_KSW.this.tvEqAlto.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                        } else {
                            FragmentVolSet_KSW.this.tvEqAlto.setText("" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                        }
                        if (!FragmentVolSet_KSW.this.focusUtil.inSeekbarKnobMode) {
                            FragmentVolSet_KSW.this.tvEqAlto.setTextColor(-1);
                        }
                    }
                    FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                    FragmentVolSet_KSW.this.save_KSW_set_page2_vol_info();
                }
            });
        }
        MySeekbar1 mySeekbar1 = this.mySeekbar1EqAlto;
        if (mySeekbar1 != null) {
            mySeekbar1.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolSet_KSW.this.setScrollEnable(false);
                    if (FragmentVolSet_KSW.this.indexEqMode != 0) {
                    }
                }

                public void onSeeking(int i) {
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[1] = Integer.valueOf(i - 12);
                        if (FragmentVolSet_KSW.this.tvEqAlto != null) {
                            if (FragmentVolSet_KSW.this.arrEqCustom[1].intValue() > 0) {
                                FragmentVolSet_KSW.this.tvEqAlto.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                            } else {
                                FragmentVolSet_KSW.this.tvEqAlto.setText("" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                            }
                        }
                        FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                    }
                }

                public void onSeekStop(int i) {
                    FragmentVolSet_KSW.this.setScrollEnable(true);
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[1] = Integer.valueOf(i - 12);
                        if (FragmentVolSet_KSW.this.tvEqAlto != null) {
                            if (FragmentVolSet_KSW.this.arrEqCustom[1].intValue() > 0) {
                                FragmentVolSet_KSW.this.tvEqAlto.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                            } else {
                                FragmentVolSet_KSW.this.tvEqAlto.setText("" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                            }
                            if (!FragmentVolSet_KSW.this.focusUtil.inSeekbarKnobMode) {
                                FragmentVolSet_KSW.this.tvEqAlto.setTextColor(-1);
                            }
                        }
                        FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                        FragmentVolSet_KSW.this.save_KSW_set_page2_vol_info();
                    }
                }
            });
        }
        SeekBar seekBar = this.seekbarEqAlto;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[1] = Integer.valueOf(FragmentVolSet_KSW.this.seekbarEqAlto.getProgress() - 12);
                        if (FragmentVolSet_KSW.this.tvEqAlto != null) {
                            FragmentVolSet_KSW.this.tvEqAlto.setText("" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                        }
                        FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                    }
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[1] = Integer.valueOf(FragmentVolSet_KSW.this.seekbarEqAlto.getProgress() - 12);
                        if (FragmentVolSet_KSW.this.tvEqAlto != null) {
                            FragmentVolSet_KSW.this.tvEqAlto.setText("" + FragmentVolSet_KSW.this.arrEqCustom[1]);
                        }
                        FragmentVolSet_KSW.this.save_KSW_set_page2_vol_info();
                    }
                }
            });
        }
    }

    private void initEqSeekbarTreble() {
        MySeekbar2 mySeekbar2 = this.mySeekbar2EqTreble;
        if (mySeekbar2 != null) {
            mySeekbar2.setOnSeekListener(new MySeekbar2.OnSeekListener() {
                public void onSeekTouch() {
                }

                public void onSeeking(int i) {
                    FragmentVolSet_KSW.this.arrEqCustom[2] = Integer.valueOf(i - 12);
                    if (FragmentVolSet_KSW.this.tvEqTreble != null) {
                        if (FragmentVolSet_KSW.this.arrEqCustom[2].intValue() > 0) {
                            FragmentVolSet_KSW.this.tvEqTreble.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                        } else {
                            FragmentVolSet_KSW.this.tvEqTreble.setText("" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                        }
                        if (FragmentVolSet_KSW.this.m_iUIIndex == 2) {
                            FragmentVolSet_KSW.this.tvEqTreble.setTextColor(FragmentVolSet_KSW.this.mainActivity.getColor(FragmentVolSet_KSW.this.getAttrId(R.attr.ksw_id8_fontColor)));
                        }
                    }
                    FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                }

                public void onSeekStop(int i) {
                    FragmentVolSet_KSW.this.arrEqCustom[2] = Integer.valueOf(i - 12);
                    if (FragmentVolSet_KSW.this.tvEqTreble != null) {
                        if (FragmentVolSet_KSW.this.arrEqCustom[2].intValue() > 0) {
                            FragmentVolSet_KSW.this.tvEqTreble.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                        } else {
                            FragmentVolSet_KSW.this.tvEqTreble.setText("" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                        }
                        if (!FragmentVolSet_KSW.this.focusUtil.inSeekbarKnobMode) {
                            FragmentVolSet_KSW.this.tvEqTreble.setTextColor(-1);
                        }
                    }
                    FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                    FragmentVolSet_KSW.this.save_KSW_set_page2_vol_info();
                }
            });
        }
        MySeekbar1 mySeekbar1 = this.mySeekbar1EqTreble;
        if (mySeekbar1 != null) {
            mySeekbar1.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolSet_KSW.this.setScrollEnable(false);
                    if (FragmentVolSet_KSW.this.indexEqMode != 0) {
                    }
                }

                public void onSeeking(int i) {
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[2] = Integer.valueOf(i - 12);
                        if (FragmentVolSet_KSW.this.tvEqTreble != null) {
                            if (FragmentVolSet_KSW.this.arrEqCustom[2].intValue() > 0) {
                                FragmentVolSet_KSW.this.tvEqTreble.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                            } else {
                                FragmentVolSet_KSW.this.tvEqTreble.setText("" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                            }
                        }
                        FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                    }
                }

                public void onSeekStop(int i) {
                    FragmentVolSet_KSW.this.setScrollEnable(true);
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[2] = Integer.valueOf(i - 12);
                        if (FragmentVolSet_KSW.this.tvEqTreble != null) {
                            if (FragmentVolSet_KSW.this.arrEqCustom[2].intValue() > 0) {
                                FragmentVolSet_KSW.this.tvEqTreble.setText("+" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                            } else {
                                FragmentVolSet_KSW.this.tvEqTreble.setText("" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                            }
                            if (!FragmentVolSet_KSW.this.focusUtil.inSeekbarKnobMode) {
                                FragmentVolSet_KSW.this.tvEqTreble.setTextColor(-1);
                            }
                        }
                        FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                        FragmentVolSet_KSW.this.save_KSW_set_page2_vol_info();
                    }
                }
            });
        }
        SeekBar seekBar = this.seekbarEqTreble;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[2] = Integer.valueOf(FragmentVolSet_KSW.this.seekbarEqTreble.getProgress() - 12);
                        if (FragmentVolSet_KSW.this.tvEqTreble != null) {
                            FragmentVolSet_KSW.this.tvEqTreble.setText("" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                        }
                        FragmentVolSet_KSW.this.send_KSW_page2_vol_info();
                    }
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    if (FragmentVolSet_KSW.this.indexEqMode == 0) {
                        FragmentVolSet_KSW.this.arrEqCustom[2] = Integer.valueOf(FragmentVolSet_KSW.this.seekbarEqTreble.getProgress() - 12);
                        if (FragmentVolSet_KSW.this.tvEqTreble != null) {
                            FragmentVolSet_KSW.this.tvEqTreble.setText("" + FragmentVolSet_KSW.this.arrEqCustom[2]);
                        }
                        FragmentVolSet_KSW.this.save_KSW_set_page2_vol_info();
                    }
                }
            });
        }
    }

    private void initEqData(IEventService iEventService) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null) {
            if (iEventService == null) {
                iEventService = mainActivity.getService();
            }
            if (iEventService != null) {
                try {
                    this.indexEqMode = iEventService.getSettingInt(EventUtils.KESAIWEI_EQ_MODE_SELECT, this.indexEqMode);
                    Integer[] numArr = this.arrEqCustom;
                    numArr[0] = Integer.valueOf(iEventService.getSettingInt(EventUtils.KESAIWEI_EQ_USER_LOW, numArr[0].intValue()));
                    Integer[] numArr2 = this.arrEqCustom;
                    numArr2[1] = Integer.valueOf(iEventService.getSettingInt(EventUtils.KESAIWEI_EQ_USER_MID, numArr2[1].intValue()));
                    Integer[] numArr3 = this.arrEqCustom;
                    numArr3[2] = Integer.valueOf(iEventService.getSettingInt(EventUtils.KESAIWEI_EQ_USER_HIGHT, numArr3[2].intValue()));
                    Log.d(TAG, "init_KSW_get_page2_vol_info ksw_i_user_arr[0] = " + this.arrEqCustom[0] + ", ksw_i_user_arr[1] = " + this.arrEqCustom[1] + ", ksw_i_user_arr[2] = " + this.arrEqCustom[2]);
                    refreshEqInfo();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void save_KSW_set_page2_vol_info() {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        IEventService service = mainActivity != null ? mainActivity.getService() : null;
        try {
            service.putSettingInt(EventUtils.KESAIWEI_EQ_MODE_SELECT, this.indexEqMode);
            service.putSettingInt(EventUtils.KESAIWEI_EQ_USER_LOW, this.arrEqCustom[0].intValue());
            service.putSettingInt(EventUtils.KESAIWEI_EQ_USER_MID, this.arrEqCustom[1].intValue());
            service.putSettingInt(EventUtils.KESAIWEI_EQ_USER_HIGHT, this.arrEqCustom[2].intValue());
            service.appySetting();
            service.commitSetting();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void send_KSW_page2_vol_info() {
        int i;
        int i2;
        IEventService service;
        int i3 = this.indexEqMode;
        int i4 = 0;
        if (i3 == 0) {
            i4 = this.arrEqCustom[0].intValue();
            i2 = this.arrEqCustom[1].intValue();
            i = this.arrEqCustom[2].intValue();
        } else if (i3 == 1) {
            i4 = this.arrEqPop[0].intValue();
            i2 = this.arrEqPop[1].intValue();
            i = this.arrEqPop[2].intValue();
        } else if (i3 == 2) {
            i4 = this.arrEqClassical[0].intValue();
            i2 = this.arrEqClassical[1].intValue();
            i = this.arrEqClassical[2].intValue();
        } else if (i3 == 3) {
            i4 = this.arrEqRock[0].intValue();
            i2 = this.arrEqRock[1].intValue();
            i = this.arrEqRock[2].intValue();
        } else if (i3 == 4) {
            i4 = this.arrEqJazz[0].intValue();
            i2 = this.arrEqJazz[1].intValue();
            i = this.arrEqJazz[2].intValue();
        } else if (i3 != 5) {
            i2 = 0;
            i = 0;
        } else {
            i4 = this.arrEqDance[0].intValue();
            i2 = this.arrEqDance[1].intValue();
            i = this.arrEqDance[2].intValue();
        }
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null && (service = mainActivity.getService()) != null) {
            try {
                service.send_KSW_page2_vol_info(this.indexEqMode, i4, i2, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void mcu_to_vol_set_view() {
        IEventService iEventService;
        if (this.seekBarVolume00 != null && this.seekBarVolume01 != null && (iEventService = this.mService) != null) {
            try {
                if (iEventService.getMuteStatus()) {
                    this.volume00 = 0;
                } else {
                    this.volume00 = this.mService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_00, this.volume00);
                }
                this.seekBarVolume00.setProgress(this.volume00);
                int settingInt = this.mService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_01, this.volume01);
                this.volume01 = settingInt;
                this.seekBarVolume01.setProgress(settingInt);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void hideViews() {
        View view = this.layoutAndroid;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.layoutOem;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.layoutEq;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        RadioButton radioButton = this.rbAndroid;
        if (radioButton != null) {
            radioButton.setChecked(false);
        }
        RadioButton radioButton2 = this.rbOem;
        if (radioButton2 != null) {
            radioButton2.setChecked(false);
        }
        RadioButton radioButton3 = this.rbSound;
        if (radioButton3 != null) {
            radioButton3.setChecked(false);
        }
        ImageView imageView = this.imgRightIcon;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private void showLayout(int i) {
        RadioButton radioButton = this.rbAndroid;
        if (radioButton != null) {
            radioButton.setChecked(i == 0);
        }
        RadioButton radioButton2 = this.rbOem;
        if (radioButton2 != null) {
            radioButton2.setChecked(i == 1);
        }
        RadioButton radioButton3 = this.rbSound;
        if (radioButton3 != null) {
            radioButton3.setChecked(i == 2);
        }
        View view = this.layoutAndroid;
        int i2 = 8;
        if (view != null) {
            view.setVisibility(i == 0 ? 0 : 8);
        }
        View view2 = this.layoutOem;
        if (view2 != null) {
            view2.setVisibility(i == 1 ? 0 : 8);
        }
        View view3 = this.layoutEq;
        if (view3 != null) {
            view3.setVisibility(i == 2 ? 0 : 8);
        }
        ImageView imageView = this.imgRight;
        if (imageView != null) {
            imageView.setVisibility(i == -1 ? 8 : 0);
        }
        ImageView imageView2 = this.imgRightIcon;
        if (imageView2 != null) {
            if (i == -1) {
                i2 = 0;
            }
            imageView2.setVisibility(i2);
        }
        if (this.showID8UserView) {
            this.showID8UserView = false;
            showID8UserView();
        }
    }

    public void showID8UserView() {
        Log.d(TAG, "showID8UserView show = " + this.showID8UserView);
        if (this.showID8UserView) {
            View view = this.viewUser;
            if (view != null) {
                view.setVisibility(0);
                if (this.m_iUIIndex == 4) {
                    this.baseApp.setFocusPage(2);
                    addViewIds();
                    getMainActivity().m_iCurrFocus = -1;
                    BaseApp.getFocusUtil().refreshThirdViews(-1, true);
                }
            }
            View view2 = this.viewOther;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            ImageView imageView = this.imgUser;
            if (imageView != null) {
                imageView.setBackground(getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_time_up));
            }
            MyScrollbar myScrollbar2 = this.myScrollbar;
            if (myScrollbar2 != null) {
                myScrollbar2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.viewUser;
        if (view3 != null) {
            view3.setVisibility(8);
            if (this.m_iUIIndex == 4) {
                this.baseApp.setFocusPage(1);
            }
        }
        View view4 = this.viewOther;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        ImageView imageView2 = this.imgUser;
        if (imageView2 != null) {
            imageView2.setBackground(getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_time_down));
        }
        MyScrollbar myScrollbar3 = this.myScrollbar;
        if (myScrollbar3 != null) {
            myScrollbar3.setVisibility(0);
        }
    }

    public void hideContentView() {
        super.hideContentView();
        if (this.showID8UserView) {
            this.showID8UserView = false;
            showID8UserView();
        }
    }

    public class VolsetKSW_Receiver extends BroadcastReceiver {
        public VolsetKSW_Receiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.szchoiceway.settings.vol".equals(intent.getAction())) {
                FragmentVolSet_KSW.this.mcu_to_vol_set_view();
            }
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        int i = BaseApp.m_iUIIndex;
        Integer valueOf = Integer.valueOf(R.id.KSW_btn_eq_dance);
        Integer valueOf2 = Integer.valueOf(R.id.KSW_btn_eq_jazz);
        Integer valueOf3 = Integer.valueOf(R.id.KSW_btn_eq_rock);
        Integer valueOf4 = Integer.valueOf(R.id.KSW_btn_eq_classical);
        Integer valueOf5 = Integer.valueOf(R.id.KSW_btn_eq_pop);
        Integer valueOf6 = Integer.valueOf(R.id.KSW_btn_eq_custom);
        Integer valueOf7 = Integer.valueOf(R.id.viewKSW_Vol_page2_hight);
        Integer valueOf8 = Integer.valueOf(R.id.viewKSW_Vol_page2_mid);
        Integer valueOf9 = Integer.valueOf(R.id.viewKSW_Vol_page2_low);
        if (i == 6 || BaseApp.m_iModeSet == 19 || isDefaultUI() || (this.m_iUIIndex == 4 && this.isSmallResolution)) {
            this.focusViews.add(valueOf9);
            this.focusViews.add(valueOf8);
            this.focusViews.add(valueOf7);
            this.focusViews.add(valueOf6);
            this.focusViews.add(valueOf5);
            this.focusViews.add(valueOf4);
            this.focusViews.add(valueOf3);
            this.focusViews.add(valueOf2);
            this.focusViews.add(valueOf);
        } else if (BaseApp.m_iUIIndex == 2 || this.m_iUIIndex == 7) {
            this.focusViews.add(Integer.valueOf(R.id.rbAndroid));
            this.focusViews.add(Integer.valueOf(R.id.rbOem));
            this.focusViews.add(Integer.valueOf(R.id.rbSound));
        } else if (BaseApp.m_iUIIndex == 4) {
            View view = this.viewUser;
            if (view == null || view.getVisibility() != 0) {
                this.focusViews.add(valueOf6);
                this.focusViews.add(valueOf5);
                this.focusViews.add(valueOf4);
                this.focusViews.add(valueOf3);
                this.focusViews.add(valueOf2);
                this.focusViews.add(valueOf);
            } else {
                this.focusViews.add(valueOf9);
                this.focusViews.add(valueOf8);
                this.focusViews.add(valueOf7);
            }
        }
        this.focusUtil.addViewIds(this.focusViews);
    }

    /* access modifiers changed from: private */
    public int getAttrId(int i) {
        TypedValue typedValue = new TypedValue();
        this.mainActivity.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: private */
    public void setScrollEnable(boolean z) {
        ScrollView scrollView = this.mScrollView;
        if (scrollView instanceof MyScrollView) {
            ((MyScrollView) scrollView).setScrollAble(z);
        }
    }
}
