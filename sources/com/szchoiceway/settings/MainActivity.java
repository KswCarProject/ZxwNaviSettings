package com.szchoiceway.settings;

import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.settings.adapter.MainMenuAdapter;
import com.szchoiceway.settings.bean.MainMenuBean;
import com.szchoiceway.settings.fragments.FragmentSystemNew;
import com.szchoiceway.settings.fragments.FragmentSystemNew_Copilot;
import com.szchoiceway.settings.util.FocusUtil;
import com.szchoiceway.settings.view.ClipScrollView;
import com.szchoiceway.settings.view.MyRecycleView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.zxwlib.GyroScopeWithCompassView;
import com.szchoiceway.zxwlib.bean.Customer;
import com.szchoiceway.zxwlib.utils.MultipleUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    public static final int MODE_EFFICT = 0;
    public static final int MODE_PERSONAL = 2;
    public static final int MODE_SPORT = 1;
    protected static final String TAG = "MainActivity";
    public static MainActivity mMainActivity = null;
    public static boolean run_CodeActivity = false;
    private int androidSettingsIndex = 7;
    private TranslateAnimation b2tAction;
    /* access modifiers changed from: private */
    public BaseApp baseApp;
    private boolean benzCheckedChange = false;
    public int[] bgDrawableIdList;
    ImageButton btnAppList;
    ImageButton btnMusic;
    ImageButton btnNav;
    ImageButton btnTel;
    private View contentView;
    private String country;
    private int currentMode = -1;
    private int currentPage = -1;
    public boolean focusOnPasswordView = false;
    /* access modifiers changed from: private */
    public FocusUtil focusUtil;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    public boolean hasKnob = true;
    public int iBgSetIndex = 0;
    private ImageView iconView;
    private ScrollView id_scroll_view = null;
    private ImageView img1;
    private ImageView imgBg;
    private boolean isFactoryPage = false;
    private boolean isSmallResolution = false;
    private int[] itemIconIds;
    public ImageView ivBackground;
    private TranslateAnimation l2rAction;
    /* access modifiers changed from: private */
    public int landroverSelection = 0;
    private int[] landroverSelectionIds;
    private String language;
    public int lastXFocus = 0;
    public int lastYFocus = 0;
    public List<Integer> leftButtonIds = new ArrayList();
    public boolean leftFocus = false;
    private int mCurSetIndex = -1;
    /* access modifiers changed from: private */
    public ArrayList<Fragment> mFragmentList = null;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                MainActivity.this.focusUtil.refreshThirdViews(MainActivity.this.m_iCurrFocus, true);
            }
        }
    };
    private boolean mInitVar = false;
    private NavSetModel mModel = new NavSetModel();
    private ViewPager mPager = null;
    private String mResolution = "1920x720";
    /* access modifiers changed from: private */
    public IEventService mService = null;
    /* access modifiers changed from: private */
    public FragSettingsAdapter mSetAdapter = null;
    public SysProviderOpt mSysProviderOpt = null;
    protected Toast mTip = null;
    private TextView mTvDate;
    private TextView mTvInputUserFreq = null;
    private String mUserInputFreq = "";
    public int m_iCurrFocus = 0;
    public int m_iModeSet = 16;
    /* access modifiers changed from: private */
    public int m_iUIIndex = 0;
    public int m_iUITypeVer = 41;
    /* access modifiers changed from: private */
    public boolean m_onResum = false;
    /* access modifiers changed from: private */
    public MainMenuAdapter menuAdapter;
    private List<MainMenuBean> menuList;
    private int[] modes;
    private MyScrollbar myScrollbar = null;
    private ServiceConnection osc = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(MainActivity.TAG, "onServiceConnected");
            IEventService unused = MainActivity.this.mService = IEventService.Stub.asInterface(iBinder);
            if (MainActivity.this.focusUtil != null) {
                MainActivity.this.focusUtil.setService(MainActivity.this.mService, MainActivity.this);
            }
            if (MainActivity.this.mSetAdapter != null) {
                MainActivity.this.mSetAdapter.notifyDataSetChanged();
            }
            Log.i(MainActivity.TAG, "onServiceConnected end");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(MainActivity.TAG, "onServiceDisconnected");
            IEventService unused = MainActivity.this.mService = null;
        }
    };
    public int[] passwordButtonIds;
    private View passwordView;
    private TranslateAnimation r2lAction;
    public List<Integer> radioButtonIds = new ArrayList();
    /* access modifiers changed from: private */
    public MyRecycleView recycleViewMenu;
    private View scrollLayout = null;
    private int[] settingsTitleIds;
    /* access modifiers changed from: private */
    public boolean showContentView = false;
    private Fragment showFragment;
    /* access modifiers changed from: private */
    public boolean showPasswordView = false;
    private TranslateAnimation t2bAction;
    private TextView textSettingsTitle;
    private int themeIndex = 0;
    private View titleView;
    /* access modifiers changed from: private */
    public int topPosition = 0;
    TextView txtModeTitle;
    public String xml_client;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        startConnectService();
        super.onCreate(bundle);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BaseApp baseApp2 = (BaseApp) getApplication();
        this.baseApp = baseApp2;
        MultipleUtils.setCustomDensity(this, baseApp2);
        this.isSmallResolution = Customer.isSmallResolution(this);
        this.baseApp.setFocusPage(0);
        this.focusUtil = BaseApp.getFocusUtil();
        Locale locale = Locale.getDefault();
        this.language = locale.getLanguage();
        this.country = locale.getCountry();
        Log.i(TAG, "onCreate: language = " + this.language + ",country = " + this.country);
        SysProviderOpt instance = SysProviderOpt.getInstance(this);
        this.mSysProviderOpt = instance;
        mMainActivity = this;
        this.m_iUITypeVer = instance.getRecordInteger("Set_User_UI_Type", this.m_iUITypeVer);
        this.m_iModeSet = this.mSysProviderOpt.getRecordInteger("KESAIWEI_SYS_MODE_SELECTION", this.m_iModeSet);
        this.m_iUIIndex = Customer.getUIIndex(this);
        String recordValue = this.mSysProviderOpt.getRecordValue("KSW_UI_RESOLUTION", "1920x720");
        this.mResolution = recordValue;
        FocusUtil focusUtil2 = this.focusUtil;
        if (focusUtil2 != null) {
            focusUtil2.loadResolution(recordValue);
        }
        Log.i(TAG, "m_iUITypeVer  = " + this.m_iUITypeVer + ", m_iModeSet = " + this.m_iModeSet + ", m_iUIIndex = " + this.m_iUIIndex);
        this.xml_client = this.mSysProviderOpt.getRecordValue(SysProviderOpt.KSW_FACTORY_SET_CLIENT);
        Log.d(TAG, "setContentView m_iModeSet = " + this.m_iModeSet);
        if (this.m_iUIIndex == 5) {
            setLandRoverTheme();
            getWindow().addFlags(1024);
        } else {
            getWindow().addFlags(512);
        }
        if (Customer.isSmallResolution(getApplicationContext())) {
            int i = this.m_iUIIndex;
            if (i == 6) {
                setContentView(R.layout.small_kesaiwei_1920x720_benz_activity_main);
            } else if (i == 4) {
                setContentView(R.layout.small_audi_activity_main);
            } else {
                setContentView(R.layout.kesaiwei_1920x720_evo_id7_activity_main);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                setContentView(R.layout.audi_activity_main_1560x700);
            } else {
                setContentView(R.layout.kesaiwei_1920x720_evo_id7_activity_main);
            }
        } else if (isDefaultUI()) {
            setContentView(R.layout.kesaiwei_1920x720_evo_id7_activity_main);
        } else {
            int i2 = this.m_iUIIndex;
            if (i2 == 2) {
                this.themeIndex = this.mSysProviderOpt.getRecordInteger("KESAIWEI_SYS_DISPLAY_MODE", 0);
                Log.d(TAG, "theme = " + this.themeIndex);
                int i3 = this.themeIndex;
                if (i3 == 0) {
                    setTheme(R.style.ksw_id8_b);
                } else if (i3 == 1) {
                    setTheme(R.style.ksw_id8_r);
                } else {
                    setTheme(R.style.ksw_id8_y);
                }
                setContentView(R.layout.kesaiwei_1920x720_evo_id8_activity_main);
            } else if (i2 == 6) {
                setContentView(R.layout.kesaiwei_1920x720_benz_activity_main);
            } else if (i2 == 7) {
                setContentView(R.layout.lexus_activity_main);
            } else {
                int i4 = this.m_iModeSet;
                if (i4 == 19) {
                    setContentView(R.layout.pemp_id7_activity_main);
                } else if (i2 == 4) {
                    setContentView(R.layout.audi_activity_main);
                } else if (i2 == 5) {
                    this.hasKnob = false;
                    if (i4 == 32) {
                        setContentView(R.layout.landrover_theme_activity_main);
                    } else if (i4 == 39) {
                        setContentView(R.layout.landrover_copilot_activity_main);
                    } else {
                        setContentView(R.layout.landrover_activity_main);
                    }
                } else {
                    setContentView(R.layout.kesaiwei_1920x720_evo_id7_activity_main);
                }
            }
        }
        FocusUtil focusUtil3 = this.focusUtil;
        if (focusUtil3 != null) {
            focusUtil3.setActivity(this);
        }
        initData();
        initView();
        initViewPager();
        registerReceiver();
        refreshMainFocusView(true);
        gotoPageOnCreate();
    }

    private void gotoPageOnCreate() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i = extras.getInt("GotoPageNum", -1);
            Log.d(TAG, "onCreate mPage = " + i);
            if (i != -1) {
                if (this.showPasswordView) {
                    hidePasswordView();
                }
                if (this.m_iModeSet == 19 || isDefaultUI()) {
                    this.m_iCurrFocus = i;
                    setViewPageCurItem(i);
                    this.focusUtil.refreshFirstViews(this, i, true);
                    ScrollView scrollView = (ScrollView) findViewById(R.id.id_scroll_view);
                    if (scrollView != null) {
                        scrollView.scrollTo(0, 0);
                    }
                    setViewPageTitleColor(this.m_iCurrFocus);
                    return;
                }
                int i2 = this.m_iUIIndex;
                if (i2 == 2) {
                    this.m_iCurrFocus = i;
                    this.baseApp.setFocusPage(1);
                    this.focusUtil.locateFragment(this.mFragmentList.get(this.m_iCurrFocus), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                    ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).addViewIds();
                    View findViewById = findViewById(this.radioButtonIds.get(this.m_iCurrFocus).intValue());
                    if (findViewById != null) {
                        findViewById.setSelected(true);
                    }
                    setViewPageCurItem(this.m_iCurrFocus);
                    showID8Content();
                } else if (i2 == 6 || i2 == 4) {
                    this.m_iCurrFocus = i;
                    this.baseApp.setFocusPage(1);
                    int i3 = this.m_iCurrFocus;
                    this.lastYFocus = i3;
                    this.focusUtil.locateFragment(this.mFragmentList.get(i3), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                    ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).addViewIds();
                    for (Integer intValue : this.radioButtonIds) {
                        int intValue2 = intValue.intValue();
                        View findViewById2 = findViewById(intValue2);
                        if (findViewById2 != null) {
                            if (intValue2 == this.radioButtonIds.get(this.m_iCurrFocus).intValue()) {
                                findViewById2.setSelected(true);
                            } else {
                                findViewById2.setSelected(false);
                            }
                        }
                    }
                    setViewPageCurItem(this.m_iCurrFocus);
                    showContentView();
                } else if (i2 == 7) {
                    this.m_iCurrFocus = i;
                    this.baseApp.setFocusPage(0);
                    int i4 = this.m_iCurrFocus;
                    this.lastYFocus = i4;
                    this.focusUtil.locateFragment(this.mFragmentList.get(i4), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                    ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).addViewIds();
                    for (Integer intValue3 : this.radioButtonIds) {
                        int intValue4 = intValue3.intValue();
                        View findViewById3 = findViewById(intValue4);
                        if (findViewById3 != null) {
                            if (intValue4 == this.radioButtonIds.get(this.m_iCurrFocus).intValue()) {
                                findViewById3.setSelected(true);
                            } else {
                                findViewById3.setSelected(false);
                            }
                        }
                    }
                    setViewPageCurItem(this.m_iCurrFocus);
                } else if (i2 == 5) {
                    MainMenuAdapter mainMenuAdapter = this.menuAdapter;
                    if (mainMenuAdapter != null) {
                        mainMenuAdapter.setPosition(i);
                    }
                    setViewPageCurItem(i);
                    refreshLandroverSelection(i);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            int intExtra = intent.getIntExtra("GotoPageNum", -1);
            Log.d(TAG, "onNewIntent mPage = " + intExtra);
            if (intExtra != -1) {
                if (this.showPasswordView) {
                    hidePasswordView();
                }
                if (this.m_iModeSet == 19 || isDefaultUI()) {
                    this.m_iCurrFocus = intExtra;
                    setViewPageCurItem(intExtra);
                    this.focusUtil.clearFocus();
                    this.baseApp.setFocusPage(0);
                    this.focusUtil.refreshFirstViews(this, this.m_iCurrFocus, true);
                    ScrollView scrollView = (ScrollView) findViewById(R.id.id_scroll_view);
                    if (scrollView != null) {
                        scrollView.scrollTo(0, 0);
                    }
                    setViewPageTitleColor(this.m_iCurrFocus);
                    return;
                }
                int i = this.m_iUIIndex;
                if (i == 2) {
                    this.focusUtil.clearFocus();
                    this.m_iCurrFocus = intExtra;
                    this.baseApp.setFocusPage(1);
                    this.focusUtil.locateFragment(this.mFragmentList.get(this.m_iCurrFocus), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                    ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).addViewIds();
                    View findViewById = findViewById(this.radioButtonIds.get(this.m_iCurrFocus).intValue());
                    if (findViewById != null) {
                        findViewById.setSelected(true);
                    }
                    setViewPageCurItem(this.m_iCurrFocus);
                    showID8Content();
                } else if (i == 6 || i == 4) {
                    this.m_iCurrFocus = intExtra;
                    this.baseApp.setFocusPage(1);
                    int i2 = this.m_iCurrFocus;
                    this.lastYFocus = i2;
                    this.focusUtil.locateFragment(this.mFragmentList.get(i2), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                    ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).addViewIds();
                    for (Integer intValue : this.radioButtonIds) {
                        int intValue2 = intValue.intValue();
                        View findViewById2 = findViewById(intValue2);
                        if (findViewById2 != null) {
                            if (intValue2 == this.radioButtonIds.get(this.m_iCurrFocus).intValue()) {
                                findViewById2.setSelected(true);
                            } else {
                                findViewById2.setSelected(false);
                            }
                        }
                    }
                    setViewPageCurItem(this.m_iCurrFocus);
                    showContentView();
                } else if (i == 7) {
                    this.m_iCurrFocus = intExtra;
                    this.baseApp.setFocusPage(0);
                    int i3 = this.m_iCurrFocus;
                    this.lastYFocus = i3;
                    this.focusUtil.locateFragment(this.mFragmentList.get(i3), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                    ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).addViewIds();
                    for (Integer intValue3 : this.radioButtonIds) {
                        int intValue4 = intValue3.intValue();
                        View findViewById3 = findViewById(intValue4);
                        if (findViewById3 != null) {
                            if (intValue4 == this.radioButtonIds.get(this.m_iCurrFocus).intValue()) {
                                findViewById3.setSelected(true);
                            } else {
                                findViewById3.setSelected(false);
                            }
                        }
                    }
                    setViewPageCurItem(this.m_iCurrFocus);
                } else if (i == 5) {
                    MainMenuAdapter mainMenuAdapter = this.menuAdapter;
                    if (mainMenuAdapter != null) {
                        mainMenuAdapter.setPosition(intExtra);
                    }
                    setViewPageCurItem(intExtra);
                    refreshLandroverSelection(intExtra);
                }
            }
        }
    }

    private void initData() {
        int i = this.m_iUIIndex;
        if (i == 2) {
            this.androidSettingsIndex = 5;
        } else if (i == 5) {
            if (this.m_iModeSet == 39) {
                this.androidSettingsIndex = 3;
            } else {
                this.androidSettingsIndex = 6;
            }
        } else if (i == 7) {
            this.androidSettingsIndex = 6;
        } else {
            this.androidSettingsIndex = 7;
        }
        this.mFragmentList = new ArrayList<>();
        if (this.m_iUITypeVer == 41) {
            FragmentNavSetNew fragmentNavSetNew = new FragmentNavSetNew();
            FragmentDataTimer fragmentDataTimer = new FragmentDataTimer();
            FragmentLanguage fragmentLanguage = new FragmentLanguage();
            FragmentSysInfor fragmentSysInfor = new FragmentSysInfor();
            FragmentVolumeSet fragmentVolumeSet = new FragmentVolumeSet();
            FragmentVolSet_KSW fragmentVolSet_KSW = new FragmentVolSet_KSW();
            FragmentSystemNew fragmentSystemNew = new FragmentSystemNew();
            int i2 = this.m_iUIIndex;
            if (i2 == 6 || i2 == 4) {
                this.mFragmentList.add(fragmentSystemNew);
                this.mFragmentList.add(fragmentNavSetNew);
                this.mFragmentList.add(fragmentVolumeSet);
                this.mFragmentList.add(fragmentVolSet_KSW);
                this.mFragmentList.add(fragmentLanguage);
                this.mFragmentList.add(fragmentDataTimer);
                this.mFragmentList.add(fragmentSysInfor);
            } else if (i2 == 7) {
                FragmentStartCode fragmentStartCode = new FragmentStartCode();
                this.mFragmentList.add(fragmentSystemNew);
                this.mFragmentList.add(fragmentNavSetNew);
                this.mFragmentList.add(fragmentVolSet_KSW);
                this.mFragmentList.add(fragmentLanguage);
                this.mFragmentList.add(fragmentDataTimer);
                this.mFragmentList.add(fragmentSysInfor);
                this.mFragmentList.add(fragmentStartCode);
            } else if (i2 == 3 || isDefaultUI()) {
                FragmentStartCode fragmentStartCode2 = new FragmentStartCode();
                this.mFragmentList.add(fragmentNavSetNew);
                this.mFragmentList.add(fragmentLanguage);
                this.mFragmentList.add(fragmentSystemNew);
                this.mFragmentList.add(fragmentVolumeSet);
                this.mFragmentList.add(fragmentVolSet_KSW);
                this.mFragmentList.add(fragmentDataTimer);
                this.mFragmentList.add(fragmentStartCode2);
                this.mFragmentList.add(fragmentSysInfor);
            } else {
                int i3 = this.m_iUIIndex;
                if (i3 == 2) {
                    FragmentStartCode fragmentStartCode3 = new FragmentStartCode();
                    this.mFragmentList.add(fragmentSystemNew);
                    this.mFragmentList.add(fragmentNavSetNew);
                    this.mFragmentList.add(fragmentVolSet_KSW);
                    this.mFragmentList.add(fragmentLanguage);
                    this.mFragmentList.add(fragmentDataTimer);
                    this.mFragmentList.add(fragmentStartCode3);
                    this.mFragmentList.add(fragmentSysInfor);
                } else if (i3 == 5) {
                    FragmentStartCode fragmentStartCode4 = new FragmentStartCode();
                    if (this.m_iModeSet == 39) {
                        this.mFragmentList.add(new FragmentSystemNew_Copilot());
                        this.mFragmentList.add(fragmentLanguage);
                        this.mFragmentList.add(fragmentSysInfor);
                        this.mFragmentList.add(fragmentStartCode4);
                    }
                    this.mFragmentList.add(fragmentSystemNew);
                    this.mFragmentList.add(fragmentNavSetNew);
                    this.mFragmentList.add(fragmentVolumeSet);
                    this.mFragmentList.add(fragmentLanguage);
                    this.mFragmentList.add(fragmentDataTimer);
                    this.mFragmentList.add(fragmentSysInfor);
                    this.mFragmentList.add(fragmentStartCode4);
                    initSetItem();
                }
            }
        }
    }

    private void initView() {
        if (this.m_iUITypeVer == 41) {
            this.id_scroll_view = (ScrollView) findViewById(R.id.id_scroll_view);
            this.myScrollbar = (MyScrollbar) findViewById(R.id.myScrollbar);
            this.scrollLayout = findViewById(R.id.scrollLayout);
            this.txtModeTitle = (TextView) findViewById(R.id.txtModeTitle);
            ScrollView scrollView = this.id_scroll_view;
            if (scrollView != null) {
                scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                        MainActivity.this.lambda$initView$0$MainActivity(view, i, i2, i3, i4);
                    }
                });
            }
            int i = 0;
            if (this.m_iModeSet == 19 || isDefaultUI()) {
                this.modes = new int[]{EventUtils.eSrcMode.SRC_SETTINGS_NAVIGATION.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_LANGUAGE.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_SYSTEM.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_VOLUME.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_EQ.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_DATATIMER.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_FACTORY.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_SYSTEM_INFO.getIntValue()};
                ArrayList arrayList = new ArrayList();
                this.radioButtonIds = arrayList;
                arrayList.add(Integer.valueOf(R.id.BtnNavSet));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnLanguage));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnSysSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnVolumeSet));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnVolSet_KSW));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnDataTimer));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnFatSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnMoreSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnSysInfor));
                for (Integer intValue : this.radioButtonIds) {
                    View findViewById = findViewById(intValue.intValue());
                    if (findViewById != null) {
                        findViewById.setOnClickListener(this);
                    }
                }
                View findViewById2 = findViewById(R.id.btnReturn);
                if (findViewById2 != null) {
                    findViewById2.setOnClickListener(this);
                    return;
                }
                return;
            }
            int i2 = this.m_iUIIndex;
            if (i2 == 2) {
                initAnimationID8();
                this.modes = new int[]{EventUtils.eSrcMode.SRC_SETTINGS_SYSTEM.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_NAVIGATION.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_EQ.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_LANGUAGE.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_DATATIMER.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_FACTORY.getIntValue(), EventUtils.eSrcMode.SRC_SETTINGS_SYSTEM_INFO.getIntValue()};
                ArrayList arrayList2 = new ArrayList();
                this.radioButtonIds = arrayList2;
                arrayList2.add(Integer.valueOf(R.id.BtnSysSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnNavSet));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnVolSet_KSW));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnLanguage));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnDataTimer));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnMoreSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnFatSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnSysInfor));
                for (Integer intValue2 : this.radioButtonIds) {
                    View findViewById3 = findViewById(intValue2.intValue());
                    if (findViewById3 != null) {
                        findViewById3.setOnClickListener(this);
                    }
                }
                this.leftButtonIds = new ArrayList();
                ImageButton imageButton = (ImageButton) findViewById(R.id.btnAppList);
                this.btnAppList = imageButton;
                if (imageButton != null) {
                    this.leftButtonIds.add(Integer.valueOf(R.id.btnAppList));
                    this.btnAppList.setOnClickListener(this);
                }
                ImageButton imageButton2 = (ImageButton) findViewById(R.id.btnMusic);
                this.btnMusic = imageButton2;
                if (imageButton2 != null) {
                    this.leftButtonIds.add(Integer.valueOf(R.id.btnMusic));
                    this.btnMusic.setOnClickListener(this);
                }
                ImageButton imageButton3 = (ImageButton) findViewById(R.id.btnTel);
                this.btnTel = imageButton3;
                if (imageButton3 != null) {
                    this.leftButtonIds.add(Integer.valueOf(R.id.btnTel));
                    this.btnTel.setOnClickListener(this);
                }
                ImageButton imageButton4 = (ImageButton) findViewById(R.id.btnNav);
                this.btnNav = imageButton4;
                if (imageButton4 != null) {
                    this.leftButtonIds.add(Integer.valueOf(R.id.btnNav));
                    this.btnNav.setOnClickListener(this);
                }
            } else if (i2 == 6) {
                initAnimation();
                ImageButton imageButton5 = (ImageButton) findViewById(R.id.kswBenzBack);
                if (imageButton5 != null) {
                    imageButton5.setOnClickListener(this);
                }
                if (this.isSmallResolution) {
                    this.itemIconIds = new int[]{R.drawable.small_ksw_benz_xitongshezhi, R.drawable.small_ksw_benz_daohangshezhi, R.drawable.small_ksw_benz_yinpinshezhi, R.drawable.small_ksw_benz_yinxiaoshezhi, R.drawable.small_ksw_benz_yuyanshezhi, R.drawable.small_ksw_benz_shijianshezhi, R.drawable.small_ksw_benz_xitongxinxi, R.drawable.small_ksw_benz_small_ksw_benz_anzhuoshezhi, R.drawable.small_ksw_benz_gongchengshezhi};
                } else {
                    this.itemIconIds = new int[]{R.drawable.ksw_benz_xitongshezhi_zuo, R.drawable.ksw_benz_daohangshezhi_zuo, R.drawable.ksw_benz_yinpinshezhi_zuo, R.drawable.ksw_benz_yinxiaoshezhi_zuo, R.drawable.ksw_benz_yuyan_zuo, R.drawable.ksw_benz_shijian_zuo, R.drawable.ksw_benz_xitongxinxi_zuo, R.drawable.ksw_benz_anzhuoshezhi_zuo, R.drawable.ksw_benz_gongchangshezhi_zuo};
                }
                ImageView imageView = (ImageView) findViewById(R.id.iconView);
                this.iconView = imageView;
                imageView.setBackgroundResource(this.itemIconIds[0]);
                this.settingsTitleIds = new int[]{R.string.lbl_sys_set, R.string.lbl_nav_set, R.string.lbl_volume_set, R.string.lbl_sound_set, R.string.lbl_language_set, R.string.lbl_datatimer_set, R.string.lbl_sys_infor, R.string.lbl_android_set, R.string.lbl_fat_set};
                TextView textView = (TextView) findViewById(R.id.textSettingsTitle);
                this.textSettingsTitle = textView;
                textView.setText(this.settingsTitleIds[0]);
                ArrayList arrayList3 = new ArrayList();
                this.radioButtonIds = arrayList3;
                arrayList3.add(Integer.valueOf(R.id.BtnSysSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnNavSet));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnVolumeSet));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnVolSet_KSW));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnLanguage));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnDataTimer));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnSysInfor));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnMoreSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnFatSetting));
                for (Integer intValue3 : this.radioButtonIds) {
                    View findViewById4 = findViewById(intValue3.intValue());
                    if (findViewById4 != null) {
                        findViewById4.setOnClickListener(this);
                    }
                }
                View findViewById5 = findViewById(R.id.titleView);
                this.titleView = findViewById5;
                if (findViewById5 != null) {
                    findViewById5.setVisibility(0);
                }
                View findViewById6 = findViewById(R.id.contentView);
                this.contentView = findViewById6;
                if (findViewById6 != null) {
                    findViewById6.setVisibility(8);
                }
                View findViewById7 = findViewById(R.id.passwordView);
                this.passwordView = findViewById7;
                if (findViewById7 != null) {
                    findViewById7.setVisibility(8);
                }
                this.mTvInputUserFreq = (TextView) findViewById(R.id.TvInputUserFreq);
                int[] iArr = {R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9, R.id.BtnNumOK, R.id.BtnNum0, R.id.BtnNumDel};
                this.passwordButtonIds = iArr;
                int length = iArr.length;
                while (i < length) {
                    int i3 = iArr[i];
                    ImageButton imageButton6 = (ImageButton) findViewById(i3);
                    if (imageButton6 != null) {
                        imageButton6.setOnClickListener(new View.OnClickListener(i3) {
                            public final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                MainActivity.this.lambda$initView$1$MainActivity(this.f$1, view);
                            }
                        });
                    }
                    i++;
                }
            } else if (i2 == 4) {
                if ("1560x700".equals(this.mResolution)) {
                    this.itemIconIds = new int[]{R.drawable.audi_mib3_settings_icon_set2_1560x700, R.drawable.audi_mib3_settings_icon_gps2_1560x700, R.drawable.audi_mib3_settings_icon_audio2_1560x700, R.drawable.audi_mib3_settings_icon_eq2_1560x700, R.drawable.audi_mib3_settings_icon_language2_1560x700, R.drawable.audi_mib3_settings_icon_time2_1560x700, R.drawable.audi_mib3_settings_icon_info2_1560x700, R.drawable.audi_mib3_settings_icon_android2_1560x700, R.drawable.audi_mib3_settings_icon_factory2_1560x700};
                } else {
                    this.itemIconIds = new int[]{R.drawable.audi_mib3_settings_icon_set2, R.drawable.audi_mib3_settings_icon_gps2, R.drawable.audi_mib3_settings_icon_audio2, R.drawable.audi_mib3_settings_icon_eq2, R.drawable.audi_mib3_settings_icon_language2, R.drawable.audi_mib3_settings_icon_time2, R.drawable.audi_mib3_settings_icon_info2, R.drawable.audi_mib3_settings_icon_android2, R.drawable.audi_mib3_settings_icon_factory2};
                }
                ImageView imageView2 = (ImageView) findViewById(R.id.iconView);
                this.iconView = imageView2;
                if (imageView2 != null) {
                    imageView2.setBackground((Drawable) null);
                }
                ArrayList arrayList4 = new ArrayList();
                this.radioButtonIds = arrayList4;
                arrayList4.add(Integer.valueOf(R.id.BtnSysSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnNavSet));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnVolumeSet));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnVolSet_KSW));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnLanguage));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnDataTimer));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnSysInfor));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnMoreSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnFatSetting));
                for (Integer intValue4 : this.radioButtonIds) {
                    View findViewById8 = findViewById(intValue4.intValue());
                    if (findViewById8 != null) {
                        findViewById8.setOnClickListener(this);
                    }
                }
                View findViewById9 = findViewById(R.id.titleView);
                this.titleView = findViewById9;
                if (findViewById9 != null) {
                    findViewById9.setVisibility(0);
                }
                View findViewById10 = findViewById(R.id.contentView);
                this.contentView = findViewById10;
                if (findViewById10 != null) {
                    findViewById10.setVisibility(8);
                }
                View findViewById11 = findViewById(R.id.passwordView);
                this.passwordView = findViewById11;
                if (findViewById11 != null) {
                    findViewById11.setVisibility(8);
                }
                this.mTvDate = (TextView) findViewById(R.id.tvDate);
                this.mTvInputUserFreq = (TextView) findViewById(R.id.TvInputUserFreq);
                int[] iArr2 = {R.id.BtnNumDel, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9, R.id.BtnNum0, R.id.BtnNumOK};
                this.passwordButtonIds = iArr2;
                int length2 = iArr2.length;
                while (i < length2) {
                    int i4 = iArr2[i];
                    ImageButton imageButton7 = (ImageButton) findViewById(i4);
                    if (imageButton7 != null) {
                        imageButton7.setOnClickListener(new View.OnClickListener(i4) {
                            public final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                MainActivity.this.lambda$initView$2$MainActivity(this.f$1, view);
                            }
                        });
                    }
                    i++;
                }
            } else if (i2 == 5) {
                this.imgBg = (ImageView) findViewById(R.id.imgBg);
                int i5 = this.m_iModeSet;
                if (!(i5 == 32 || i5 == 39)) {
                    setLandRoverBg();
                }
                this.img1 = (ImageView) findViewById(R.id.img1);
                this.landroverSelectionIds = new int[]{R.id.btnMainSetItem0, R.id.btnMainSetItem1, R.id.btnMainSetItem2, R.id.btnMainSetItem3, R.id.btnMainSetItem4};
                refreshLandroverSelection(0);
                this.recycleViewMenu = (MyRecycleView) findViewById(R.id.recycleViewMenu);
                this.menuAdapter = new MainMenuAdapter(this, this.menuList, 0);
                MyRecycleView myRecycleView = this.recycleViewMenu;
                if (myRecycleView != null) {
                    myRecycleView.setLayoutManager(new LinearLayoutManager(this));
                    this.recycleViewMenu.setAdapter(this.menuAdapter);
                    this.menuAdapter.setPosition(0);
                    this.menuAdapter.setOnItemClickListener(new MainMenuAdapter.OnItemClickListener() {
                        public final void onItemClick(int i) {
                            MainActivity.this.lambda$initView$3$MainActivity(i);
                        }
                    });
                    this.recycleViewMenu.setOnScrollListener(new RecyclerView.OnScrollListener() {
                        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                            super.onScrollStateChanged(recyclerView, i);
                            if (i == 0 && MainActivity.this.topPosition != MainActivity.this.recycleViewMenu.getTopPosition()) {
                                int topPosition = MainActivity.this.recycleViewMenu.getTopPosition() + MainActivity.this.landroverSelection;
                                MainActivity.this.menuAdapter.setPosition(topPosition);
                                MainActivity.this.onClickByPosition(topPosition);
                                MainActivity mainActivity = MainActivity.this;
                                int unused = mainActivity.topPosition = mainActivity.recycleViewMenu.getTopPosition();
                            }
                        }

                        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                            super.onScrolled(recyclerView, i, i2);
                        }
                    });
                }
            } else if (i2 == 7) {
                this.modes = new int[]{GyroScopeWithCompassView.CARTYPE_Kaluola_OLD_HI, GyroScopeWithCompassView.CARTYPE_Polo2016_HI, GyroScopeWithCompassView.CARTYPE_Kaluola_OLD_LO, GyroScopeWithCompassView.CARTYPE_DAQIE2013_LO, GyroScopeWithCompassView.CARTYPE_DAQIE2013_HI, GyroScopeWithCompassView.CARTYPE_JIANGLING_S330_HI, GyroScopeWithCompassView.CARTYPE_JIANGLING_S330_LO};
                ArrayList arrayList5 = new ArrayList();
                this.radioButtonIds = arrayList5;
                arrayList5.add(Integer.valueOf(R.id.BtnSysSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnNavSet));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnVolumeSet));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnLanguage));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnDataTimer));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnSysInfor));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnMoreSetting));
                this.radioButtonIds.add(Integer.valueOf(R.id.BtnFatSetting));
                for (Integer intValue5 : this.radioButtonIds) {
                    View findViewById12 = findViewById(intValue5.intValue());
                    if (findViewById12 != null) {
                        findViewById12.setOnClickListener(this);
                    }
                }
            }
        }
    }

    public /* synthetic */ void lambda$initView$0$MainActivity(View view, int i, int i2, int i3, int i4) {
        View view2 = this.scrollLayout;
        if (view2 != null) {
            float height = (((float) i2) * 1.0f) / ((float) (view2.getHeight() - this.id_scroll_view.getHeight()));
            MyScrollbar myScrollbar2 = this.myScrollbar;
            if (myScrollbar2 != null) {
                myScrollbar2.setCurrentPercent(height);
            }
        }
        ScrollView scrollView = this.id_scroll_view;
        if (scrollView instanceof ClipScrollView) {
            ((ClipScrollView) scrollView).setScrollHeight(i2);
        }
    }

    public /* synthetic */ void lambda$initView$1$MainActivity(int i, View view) {
        clickCode(i);
    }

    public /* synthetic */ void lambda$initView$2$MainActivity(int i, View view) {
        clickCode(i);
    }

    public /* synthetic */ void lambda$initView$3$MainActivity(int i) {
        this.menuAdapter.setPosition(i);
        onClickByPosition(i);
        refreshLandroverSelection(i - this.recycleViewMenu.getTopPosition());
    }

    private void initViewPager() {
        ImageView imageView;
        Log.d(TAG, "initView");
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        this.mPager = viewPager;
        if (viewPager != null) {
            FragSettingsAdapter fragSettingsAdapter = new FragSettingsAdapter(getSupportFragmentManager(), this.mFragmentList);
            this.mSetAdapter = fragSettingsAdapter;
            this.mPager.setAdapter(fragSettingsAdapter);
            setViewPageCurItem(0);
            setViewPageTitleColor(0);
            if (this.m_iUIIndex == 4 && (imageView = this.iconView) != null) {
                imageView.setBackground((Drawable) null);
            }
        }
    }

    public void setViewPageCurItem(int i) {
        int i2;
        if (i >= 0) {
            this.currentPage = i;
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setBackgroundResource(this.itemIconIds[i]);
            }
            if (this.m_iUIIndex == 6) {
                TextView textView = this.textSettingsTitle;
                if (textView != null) {
                    textView.setText(this.settingsTitleIds[this.currentPage]);
                }
                ImageView imageView2 = (ImageView) findViewById(R.id.ksw_benz_view2_right);
                if (imageView2 != null) {
                    if (i == 0) {
                        imageView2.setVisibility(8);
                    } else {
                        imageView2.setVisibility(0);
                    }
                }
            }
            if (this.m_iUIIndex == 7) {
                int i3 = 0;
                while (i3 < this.radioButtonIds.size()) {
                    ((RadioButton) findViewById(this.radioButtonIds.get(i3).intValue())).setChecked(i3 == i);
                    i3++;
                }
            }
            int i4 = this.androidSettingsIndex;
            if (i < i4) {
                int[] iArr = this.modes;
                if (iArr != null && i < iArr.length) {
                    sendModeTitle(iArr[i]);
                }
                this.currentMode = i;
                Log.d(TAG, "setViewPageCurItem itemIdx = " + i);
                this.mPager.setCurrentItem(i, false);
            } else if (i == i4) {
                startMoreSettings();
            } else {
                int[] iArr2 = this.modes;
                if (iArr2 != null && i - 1 < iArr2.length) {
                    sendModeTitle(iArr2[i2]);
                }
                int i5 = i - 1;
                this.currentMode = i5;
                Log.d(TAG, "setViewPageCurItem itemIdx = " + i5);
                this.mPager.setCurrentItem(i5, false);
            }
        }
    }

    private void setViewPageTitleColor(int i) {
        int i2 = 0;
        if (isDefaultUI()) {
            while (i2 < this.radioButtonIds.size()) {
                if (i2 == i) {
                    ((Button) findViewById(this.radioButtonIds.get(i2).intValue())).setTextColor(Color.parseColor("#FF3300"));
                } else {
                    ((Button) findViewById(this.radioButtonIds.get(i2).intValue())).setTextColor(Color.parseColor("#ffffff"));
                }
                i2++;
            }
        } else if (this.m_iModeSet == 19) {
            while (i2 < this.radioButtonIds.size()) {
                if (i2 == i) {
                    ((Button) findViewById(this.radioButtonIds.get(i2).intValue())).setTextColor(Color.parseColor("#5ac0ff"));
                } else {
                    ((Button) findViewById(this.radioButtonIds.get(i2).intValue())).setTextColor(Color.parseColor("#ffffff"));
                }
                i2++;
            }
        }
    }

    public void onStart() {
        Log.i(TAG, "onStart");
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        int[] iArr;
        Log.i(TAG, "onResume");
        if (getRequestedOrientation() != 0) {
            setRequestedOrientation(0);
        }
        super.onResume();
        if (this.m_iUIIndex != 2) {
            clickVirtual();
        }
        refreshDate();
        int i = this.currentMode;
        if (i >= 0 && (iArr = this.modes) != null) {
            int i2 = this.androidSettingsIndex;
            if (i < i2) {
                sendModeTitle(iArr[i]);
            } else if (i > i2) {
                sendModeTitle(iArr[i - 1]);
            }
        }
        this.m_onResum = true;
        int recordInteger = this.mSysProviderOpt.getRecordInteger(SysProviderOpt.SET_BACKGROUND_INDEX, this.iBgSetIndex);
        this.iBgSetIndex = recordInteger;
        ImageView imageView = this.ivBackground;
        if (imageView != null) {
            int[] iArr2 = this.bgDrawableIdList;
            if (recordInteger >= iArr2.length) {
                this.iBgSetIndex = iArr2.length - 1;
            }
            imageView.setBackgroundResource(iArr2[this.iBgSetIndex]);
        }
        if (this.m_iUIIndex == 6) {
            this.showContentView = false;
        }
    }

    private void setLandRoverTheme() {
        int recordInteger = this.mSysProviderOpt.getRecordInteger("KSW_LANDROVER_THEME_BACKGROUND_INDEX", 0);
        int i = this.m_iModeSet;
        int i2 = R.style.landrover_blue;
        if (i == 32 || i == 39) {
            if (recordInteger != 0) {
                i2 = R.style.landrover_white;
            }
            setTheme(i2);
            return;
        }
        setTheme(R.style.landrover_blue);
    }

    /* access modifiers changed from: private */
    public void setLandRoverBg() {
        int recordInteger = this.mSysProviderOpt.getRecordInteger("KSW_LANDROVER_THEME_BACKGROUND_INDEX", 0);
        ImageView imageView = this.imgBg;
        if (imageView != null) {
            imageView.setBackgroundResource(recordInteger == 0 ? R.drawable.landrover_main_bk1 : R.drawable.landrover_main_bk2_black);
        }
    }

    /* access modifiers changed from: private */
    public void refreshDate() {
        Calendar instance = Calendar.getInstance();
        String format = String.format("%d-%d-%d", new Object[]{Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5))});
        TextView textView = this.mTvDate;
        if (textView != null) {
            textView.setText(format);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        sendModeTitle(EventUtils.eSrcMode.SRC_NULL.getIntValue());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.m_onResum = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        unregisterReceiver();
        ArrayList<Fragment> arrayList = this.mFragmentList;
        if (arrayList != null) {
            arrayList.clear();
            this.mFragmentList = null;
        }
        stopConntectService();
        if (this.fragmentManager != null) {
            this.fragmentManager = null;
        }
        if (this.showFragment != null) {
            this.showFragment = null;
        }
        this.focusUtil.inSeekbarKnobMode = false;
        this.focusUtil.showMCUUpgradeView = false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && this.m_iUITypeVer == 41) {
            if (this.focusUtil.inSeekbarKnobMode) {
                this.focusUtil.clearSeekbarFocus();
            }
            if (this.m_iUIIndex == 6) {
                if (this.baseApp.getFocusPage() == 2) {
                    ((FragmentSystemNew) getCurrentFragment()).hideContentView();
                    this.m_iCurrFocus = this.lastYFocus;
                    this.baseApp.setFocusPage(1);
                    this.focusUtil.locateFragment(this.mFragmentList.get(this.lastXFocus), ((FragmentBase) this.mFragmentList.get(this.lastXFocus)).getFragmentTag());
                    ((FragmentBase) this.mFragmentList.get(this.lastXFocus)).addViewIds();
                } else if (this.baseApp.getFocusPage() == 1) {
                    showTitleView();
                } else if (this.showPasswordView) {
                    hidePasswordView();
                } else {
                    finish();
                }
                return true;
            } else if ((this.m_iModeSet == 19 || isDefaultUI()) && this.isFactoryPage) {
                setViewPageCurItem(7);
                this.isFactoryPage = false;
                return true;
            } else if (this.m_iUIIndex == 2 && this.mPager.getVisibility() == 0) {
                hideID8Content();
                return true;
            } else {
                int i2 = this.m_iUIIndex;
                if (i2 == 4) {
                    if (this.baseApp.getFocusPage() == 2) {
                        ((FragmentBase) getCurrentFragment()).hideContentView();
                        this.m_iCurrFocus = this.lastYFocus;
                        this.baseApp.setFocusPage(1);
                        this.focusUtil.locateFragment(this.mFragmentList.get(this.lastXFocus), ((FragmentBase) this.mFragmentList.get(this.lastXFocus)).getFragmentTag());
                        ((FragmentBase) this.mFragmentList.get(this.lastXFocus)).addViewIds();
                        this.focusUtil.refreshSecondViews(this.m_iCurrFocus, true);
                    } else if (this.baseApp.getFocusPage() == 1) {
                        showTitleView();
                    } else if (this.showPasswordView) {
                        hidePasswordView();
                    } else {
                        finish();
                    }
                    return true;
                } else if (i2 == 5) {
                    if (this.baseApp.getFocusPage() == 2) {
                        ((FragmentBase) getCurrentFragment()).hideContentView();
                        this.baseApp.setFocusPage(1);
                    } else {
                        finish();
                    }
                    return true;
                } else {
                    finish();
                }
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void startCodeActivity() {
        Log.d(TAG, "startCodeActivity");
        startActivity(new Intent(this, CodeActivity.class));
    }

    public void onClick(View view) {
        int i;
        Log.d(TAG, "onClick");
        if (view != null && !this.focusUtil.showNavSelectView()) {
            if (this.focusUtil.inSeekbarKnobMode) {
                this.focusUtil.clearSeekbarFocus();
            }
            if (this.m_iModeSet == 19 || isDefaultUI() || (i = this.m_iUIIndex) == 7) {
                if (this.radioButtonIds.contains(Integer.valueOf(view.getId()))) {
                    this.focusUtil.refreshThirdViews(-1, false);
                    this.focusUtil.refreshSecondViews(-1, false);
                    for (int i2 = 0; i2 < this.radioButtonIds.size(); i2++) {
                        if (this.radioButtonIds.get(i2).intValue() == view.getId() && this.m_iCurrFocus != i2) {
                            this.m_iCurrFocus = i2;
                        }
                    }
                    setViewPageTitleColor(this.m_iCurrFocus);
                    if (view.getId() != R.id.BtnMoreSetting) {
                        int i3 = this.m_iCurrFocus;
                        if (i3 < this.androidSettingsIndex) {
                            this.focusUtil.locateFragment(this.mFragmentList.get(i3), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                            ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).addViewIds();
                        } else {
                            this.focusUtil.locateFragment(this.mFragmentList.get(i3 - 1), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus - 1)).getFragmentTag());
                            ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus - 1)).addViewIds();
                        }
                        if (this.currentPage != this.m_iModeSet) {
                            setViewPageCurItem(this.m_iCurrFocus);
                        }
                    }
                    if (this.baseApp.getFocusPage() != 0) {
                        this.baseApp.setFocusPage(0);
                    }
                    refreshMainFocusView(false);
                }
            } else if (i == 2) {
                if (this.radioButtonIds.contains(Integer.valueOf(view.getId()))) {
                    this.leftFocus = false;
                    for (int i4 = 0; i4 < this.radioButtonIds.size(); i4++) {
                        if (this.radioButtonIds.get(i4).intValue() == view.getId() && this.m_iCurrFocus != i4) {
                            this.m_iCurrFocus = i4;
                        }
                    }
                    refreshMainFocusView(false);
                    if (view.getId() != R.id.BtnMoreSetting) {
                        int i5 = this.m_iCurrFocus;
                        if (i5 < this.androidSettingsIndex) {
                            this.focusUtil.locateFragment(this.mFragmentList.get(i5), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                            ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).addViewIds();
                        } else {
                            this.focusUtil.locateFragment(this.mFragmentList.get(i5 - 1), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus - 1)).getFragmentTag());
                            ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus - 1)).addViewIds();
                        }
                        if (this.currentPage != this.m_iModeSet) {
                            setViewPageCurItem(this.m_iCurrFocus);
                        }
                        showID8Content();
                    }
                }
            } else if (i == 6) {
                if (this.radioButtonIds.contains(Integer.valueOf(view.getId()))) {
                    this.focusUtil.refreshThirdViews(-1, false);
                    this.focusUtil.refreshSecondViews(-1, false);
                    for (int i6 = 0; i6 < this.radioButtonIds.size(); i6++) {
                        if (this.radioButtonIds.get(i6).intValue() == view.getId() && this.m_iCurrFocus != i6) {
                            this.m_iCurrFocus = i6;
                        }
                    }
                    refreshMainFocusView(false);
                    if (view.getId() != R.id.BtnFatSetting) {
                        if (this.showPasswordView) {
                            hidePasswordView();
                        }
                        if (view.getId() != R.id.BtnMoreSetting) {
                            int i7 = this.m_iCurrFocus;
                            if (i7 < this.androidSettingsIndex) {
                                this.focusUtil.locateFragment(this.mFragmentList.get(i7), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                                ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).addViewIds();
                            } else {
                                this.focusUtil.locateFragment(this.mFragmentList.get(i7 - 1), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus - 1)).getFragmentTag());
                                ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus - 1)).addViewIds();
                            }
                            setViewPageCurItem(this.m_iCurrFocus);
                            showContentView();
                        }
                    } else if (!this.showPasswordView) {
                        showPasswordView();
                    }
                }
            } else if (i == 4 && this.radioButtonIds.contains(Integer.valueOf(view.getId()))) {
                this.focusUtil.refreshThirdViews(-1, false);
                this.focusUtil.refreshSecondViews(-1, false);
                for (int i8 = 0; i8 < this.radioButtonIds.size(); i8++) {
                    if (this.radioButtonIds.get(i8).intValue() == view.getId() && this.m_iCurrFocus != i8) {
                        this.m_iCurrFocus = i8;
                    }
                }
                int i9 = this.m_iCurrFocus;
                Log.d(TAG, "onClick m_iCurrFocus = " + this.m_iCurrFocus + ", pageIndex = " + i9);
                refreshMainFocusView(false);
                if (view.getId() == R.id.BtnFatSetting) {
                    showPasswordView();
                } else {
                    int i10 = this.m_iCurrFocus;
                    int i11 = this.androidSettingsIndex;
                    if (i10 < i11) {
                        this.focusUtil.locateFragment(this.mFragmentList.get(i10), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus)).getFragmentTag());
                        setViewPageCurItem(this.m_iCurrFocus);
                        showContentView();
                        ((FragmentBase) this.mFragmentList.get(i9)).addViewIds();
                    } else if (i10 > i11) {
                        this.focusUtil.locateFragment(this.mFragmentList.get(i10 - 1), ((FragmentBase) this.mFragmentList.get(this.m_iCurrFocus - 1)).getFragmentTag());
                        setViewPageCurItem(this.m_iCurrFocus);
                        showContentView();
                        ((FragmentBase) this.mFragmentList.get(i9 - 1)).addViewIds();
                    }
                    this.focusUtil.refreshSecondViews(-1, true);
                }
            }
            switch (view.getId()) {
                case R.id.BtnMoreSetting:
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings"));
                    intent.setFlags(270532608);
                    startActivity(intent);
                    return;
                case R.id.btnAppList:
                    this.leftFocus = true;
                    this.m_iCurrFocus = 0;
                    refreshMainFocusView(false);
                    sendBroadcast(new Intent(EventUtils.ZXW_ACTION_SHOW_APPLIST));
                    moveTaskToBack(true);
                    return;
                case R.id.btnMusic:
                    this.leftFocus = true;
                    this.m_iCurrFocus = 1;
                    refreshMainFocusView(false);
                    enterMusic();
                    return;
                case R.id.btnNav:
                    this.leftFocus = true;
                    this.m_iCurrFocus = 3;
                    refreshMainFocusView(false);
                    boolean z = Locale.getDefault().getLanguage().equals("zh") && Locale.getDefault().getCountry().equals("CN");
                    String recordValue = this.mSysProviderOpt.getRecordValue("NAV_PACKAGENAME", "com.szchoiceway.navigation");
                    String recordValue2 = this.mSysProviderOpt.getRecordValue("NAV_ACTIVITYNAME", "com.szchoiceway.navigation.MainActivity");
                    if ((z && com.szchoiceway.zxwlib.utils.EventUtils.GOOGLE_MAP_MODE_PACKAGE_NAME.equals(recordValue)) || !EventUtils.getInstallStatus(this, recordValue)) {
                        recordValue = "com.szchoiceway.navigation";
                        recordValue2 = "com.szchoiceway.navigation.MainActivity";
                    }
                    if (!"com.szchoiceway.navigation".equals(recordValue) || !"com.szchoiceway.navigation.MainActivity".equals(recordValue2)) {
                        try {
                            Log.d(TAG, "sendMusicMode");
                            this.mService.sendMode(EventUtils.eSrcMode.SRC_THIRD_APP.getIntValue(), false);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        EventUtils.startActivityIfNotRuning(this, recordValue, recordValue2);
                        return;
                    }
                    setViewPageCurItem(1);
                    this.focusUtil.locateFragment(this.mFragmentList.get(1), ((FragmentBase) this.mFragmentList.get(1)).getFragmentTag());
                    showID8Content();
                    return;
                case R.id.btnReturn:
                    finish();
                    return;
                case R.id.btnTel:
                    this.leftFocus = true;
                    this.m_iCurrFocus = 2;
                    refreshMainFocusView(false);
                    enterBT();
                    return;
                case R.id.kswBenzBack:
                    clickBack();
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void onClickByPosition(int i) {
        setViewPageCurItem(i);
    }

    private void startConnectService() {
        Log.d(TAG, "startService");
        startService(new Intent("com.szchoiceway.eventcenter.EventService").setPackage(EventUtils.EVENT_SERVICE_PACKAGE));
        try {
            Intent intent = new Intent();
            intent.setAction("com.szchoiceway.eventcenter.EventService");
            intent.setPackage(EventUtils.EVENT_SERVICE_PACKAGE);
            Log.d(TAG, "onBindService: " + bindService(intent, this.osc, 1));
        } catch (Exception e) {
            Log.e(TAG, "onBindService error " + e.toString());
        }
    }

    private void stopConntectService() {
        try {
            unbindService(this.osc);
        } catch (Exception e) {
            Log.e(TAG, "unbindService error " + e.toString());
        }
    }

    public IEventService getService() {
        return this.mService;
    }

    /* access modifiers changed from: package-private */
    public void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.szchoiceway.NaviSettings.GotoPage");
        intentFilter.addAction(EventUtils.CHEKU_WEATHER_IPC);
        intentFilter.addAction("AUTONAVI_STANDARD_BROADCAST_SEND");
        intentFilter.addAction("com.choiceway.eventcenter.EventUtils.ZXW_ORIGINAL_MCU_KEY_FOCUS_MOVE_EVT");
        intentFilter.addAction(EventUtils.CHEKU_BOTTOM_KEY_PARK);
        intentFilter.addAction(EventUtils.KSW_ZXW_BT_CONNECED_SHOW_VIEW);
        intentFilter.addAction(EventUtils.KSW_UPDATE_VOL_SET_VIEW);
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction(EventUtils.KSW_ZXW_MCUUPGRADE_MCU_UPGRADE_VIEW_LOSS_FOCUS);
        intentFilter.addAction("KESAIWEI_DISPLAY_MODE_CHANGED_ACTION");
        intentFilter.addAction(EventUtils.ZXW_ACTION_KSW_THEME_CHANGE);
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        registerReceiver(this.mModel, intentFilter);
    }

    public void unregisterReceiver() {
        unregisterReceiver(this.mModel);
    }

    class NavSetModel extends BroadcastReceiver {
        NavSetModel() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("com.choiceway.eventcenter.EventUtils.ZXW_ORIGINAL_MCU_KEY_FOCUS_MOVE_EVT")) {
                if (MainActivity.this.hasKnob && MainActivity.this.m_onResum) {
                    int intExtra = intent.getIntExtra("com.choiceway.eventcenter.EventUtils.ZXW_ORIGINAL_MCU_KEY_FOCUS_MOVE_DATA", -1);
                    if (MainActivity.this.m_iUITypeVer == 41 && intExtra != -1 && !MainActivity.this.focusUtil.showMCUUpgradeView) {
                        if (intExtra == 1) {
                            if (MainActivity.this.focusUtil.inSeekbarKnobMode) {
                                return;
                            }
                            if (MainActivity.this.m_iUIIndex == 4) {
                                MainActivity.this.clickBack();
                            } else if (MainActivity.this.baseApp.getFocusPage() == 0) {
                                if (MainActivity.this.m_iUIIndex == 2) {
                                    if (MainActivity.this.leftFocus) {
                                        EventUtils.sendBroadcastCanKeyExtra(MainActivity.this, "com.choiceway.eventcenter.EventUtils.ZXW_CAN_KEY_EVT", 85);
                                        return;
                                    }
                                    MainActivity.this.leftFocus = true;
                                    MainActivity.this.m_iCurrFocus = 0;
                                    MainActivity.this.refreshMainFocusView(true);
                                } else if (MainActivity.this.m_iUIIndex != 6 || !MainActivity.this.showPasswordView || MainActivity.this.focusOnPasswordView) {
                                    EventUtils.sendBroadcastCanKeyExtra(MainActivity.this, "com.choiceway.eventcenter.EventUtils.ZXW_CAN_KEY_EVT", 85);
                                } else {
                                    MainActivity.this.m_iCurrFocus = -1;
                                    MainActivity.this.refreshMainFocusView(true);
                                    MainActivity.this.m_iCurrFocus = 0;
                                    MainActivity.this.focusOnPasswordView = true;
                                    MainActivity.this.refreshMainFocusView(true);
                                }
                            } else if (MainActivity.this.baseApp.getFocusPage() == 1) {
                                if (MainActivity.this.m_iUIIndex == 2) {
                                    MainActivity.this.hideID8Content();
                                } else if (MainActivity.this.m_iModeSet == 19 || MainActivity.this.isDefaultUI() || MainActivity.this.m_iUIIndex == 7) {
                                    MainActivity.this.baseApp.setFocusPage(0);
                                    MainActivity mainActivity = MainActivity.this;
                                    mainActivity.m_iCurrFocus = mainActivity.lastXFocus;
                                    MainActivity.this.refreshMainFocusView(true);
                                    MainActivity.this.focusUtil.refreshSecondViews(-1, true);
                                } else if (MainActivity.this.m_iUIIndex == 6) {
                                    MainActivity.this.showTitleView();
                                    MainActivity.this.refreshMainFocusView(true);
                                }
                            } else if (MainActivity.this.baseApp.getFocusPage() != 2) {
                            } else {
                                if (MainActivity.this.m_iUIIndex != 6) {
                                    MainActivity.this.baseApp.setFocusPage(1);
                                    MainActivity mainActivity2 = MainActivity.this;
                                    mainActivity2.m_iCurrFocus = mainActivity2.lastYFocus;
                                    MainActivity.this.focusUtil.refreshThirdViews(-1, true);
                                    MainActivity.this.focusUtil.locateFragment((Fragment) MainActivity.this.mFragmentList.get(MainActivity.this.lastXFocus), ((FragmentBase) MainActivity.this.mFragmentList.get(MainActivity.this.lastXFocus)).getFragmentTag());
                                    ((FragmentBase) MainActivity.this.mFragmentList.get(MainActivity.this.lastXFocus)).addViewIds();
                                    MainActivity.this.focusUtil.refreshSecondViews(MainActivity.this.m_iCurrFocus, true);
                                    return;
                                }
                                ((FragmentSystemNew) MainActivity.this.getCurrentFragment()).hideContentView();
                                MainActivity.this.baseApp.setFocusPage(1);
                                MainActivity mainActivity3 = MainActivity.this;
                                mainActivity3.m_iCurrFocus = mainActivity3.lastYFocus;
                                MainActivity.this.focusUtil.locateFragment((Fragment) MainActivity.this.mFragmentList.get(MainActivity.this.lastXFocus), ((FragmentBase) MainActivity.this.mFragmentList.get(MainActivity.this.lastXFocus)).getFragmentTag());
                                ((FragmentBase) MainActivity.this.mFragmentList.get(MainActivity.this.lastXFocus)).addViewIds();
                            }
                        } else if (intExtra == 2) {
                            if (MainActivity.this.focusUtil.inSeekbarKnobMode) {
                                return;
                            }
                            if (MainActivity.this.baseApp.getFocusPage() == 0) {
                                if (MainActivity.this.leftFocus) {
                                    MainActivity.this.leftFocus = false;
                                    MainActivity.this.m_iCurrFocus = 0;
                                    MainActivity.this.refreshMainFocusView(true);
                                } else if (MainActivity.this.focusOnPasswordView) {
                                    MainActivity.this.m_iCurrFocus = -1;
                                    MainActivity.this.refreshMainFocusView(true);
                                    MainActivity.this.focusOnPasswordView = false;
                                    MainActivity.this.m_iCurrFocus = 8;
                                    MainActivity.this.refreshMainFocusView(true);
                                } else {
                                    FocusUtil access$600 = MainActivity.this.focusUtil;
                                    MainActivity mainActivity4 = MainActivity.this;
                                    access$600.enterFirstViews(mainActivity4, mainActivity4.m_iCurrFocus);
                                    if (MainActivity.this.m_iModeSet == 19 || MainActivity.this.isDefaultUI() || MainActivity.this.m_iUIIndex == 7) {
                                        MainActivity.this.baseApp.setFocusPage(1);
                                        MainActivity mainActivity5 = MainActivity.this;
                                        mainActivity5.lastXFocus = mainActivity5.m_iCurrFocus;
                                        MainActivity.this.m_iCurrFocus = -1;
                                        MainActivity.this.refreshMainFocusView(true);
                                        MainActivity.this.m_iCurrFocus = 0;
                                        MainActivity.this.focusUtil.refreshSecondViews(MainActivity.this.m_iCurrFocus, true);
                                    }
                                }
                            } else if (MainActivity.this.baseApp.getFocusPage() == 1) {
                                Log.d(MainActivity.TAG, "lastXFocus = " + MainActivity.this.lastXFocus);
                                if ((MainActivity.this.m_iModeSet == 19 || MainActivity.this.isDefaultUI()) && MainActivity.this.lastXFocus == 2) {
                                    MainActivity mainActivity6 = MainActivity.this;
                                    mainActivity6.lastYFocus = mainActivity6.m_iCurrFocus;
                                    MainActivity.this.focusUtil.enterSecondViews(MainActivity.this.m_iCurrFocus);
                                    MainActivity.this.focusUtil.refreshSecondViews(-1, true);
                                    MainActivity.this.baseApp.setFocusPage(2);
                                    MainActivity.this.focusUtil.setViewPageCurItem(MainActivity.this.m_iCurrFocus);
                                    MainActivity.this.m_iCurrFocus = 0;
                                    MainActivity.this.focusUtil.refreshThirdViews(MainActivity.this.m_iCurrFocus, true);
                                } else if (MainActivity.this.m_iUIIndex == 2 || MainActivity.this.m_iUIIndex == 7) {
                                    Log.d(MainActivity.TAG, "二级到三级 lastXFocus = " + MainActivity.this.lastXFocus + ", m_iCurrFocus = " + MainActivity.this.m_iCurrFocus);
                                    if (MainActivity.this.m_iCurrFocus >= 0) {
                                        if (MainActivity.this.lastXFocus == 2) {
                                            MainActivity.this.focusUtil.enterSecondViews(MainActivity.this.m_iCurrFocus);
                                            MainActivity.this.focusUtil.refreshSecondViews(-1, true);
                                            MainActivity.this.baseApp.setFocusPage(2);
                                            MainActivity mainActivity7 = MainActivity.this;
                                            mainActivity7.lastYFocus = mainActivity7.m_iCurrFocus;
                                            MainActivity.this.m_iCurrFocus = 0;
                                            MainActivity.this.focusUtil.refreshThirdViews(MainActivity.this.m_iCurrFocus, true);
                                        } else if (MainActivity.this.lastXFocus == 0) {
                                            MainActivity mainActivity8 = MainActivity.this;
                                            mainActivity8.lastYFocus = mainActivity8.m_iCurrFocus;
                                            MainActivity.this.focusUtil.enterSecondViews(MainActivity.this.m_iCurrFocus);
                                            MainActivity.this.focusUtil.refreshSecondViews(-1, true);
                                            MainActivity.this.baseApp.setFocusPage(2);
                                            MainActivity.this.focusUtil.setViewPageCurItem(MainActivity.this.m_iCurrFocus);
                                            MainActivity.this.m_iCurrFocus = 0;
                                            MainActivity.this.focusUtil.refreshThirdViews(MainActivity.this.m_iCurrFocus, true);
                                        } else if (MainActivity.this.lastXFocus == 4 && MainActivity.this.m_iUIIndex == 7) {
                                            MainActivity.this.focusUtil.enterSecondViews(MainActivity.this.m_iCurrFocus);
                                            MainActivity.this.focusUtil.refreshSecondViews(-1, true);
                                            MainActivity.this.baseApp.setFocusPage(2);
                                            MainActivity mainActivity9 = MainActivity.this;
                                            mainActivity9.lastYFocus = mainActivity9.m_iCurrFocus;
                                            MainActivity.this.m_iCurrFocus = 0;
                                            MainActivity.this.focusUtil.refreshThirdViews(MainActivity.this.m_iCurrFocus, true);
                                        }
                                    }
                                } else if (MainActivity.this.m_iUIIndex == 6 || MainActivity.this.m_iUIIndex == 4) {
                                    MainActivity mainActivity10 = MainActivity.this;
                                    mainActivity10.lastYFocus = mainActivity10.m_iCurrFocus;
                                    MainActivity.this.focusUtil.enterSecondViews(MainActivity.this.m_iCurrFocus);
                                }
                            }
                        } else if (MainActivity.this.baseApp.getFocusPage() == 0) {
                            if (intExtra != 5) {
                                if (intExtra != 7) {
                                    if (intExtra == 8 && !MainActivity.this.showContentView) {
                                        MainActivity.this.zxwOriginalMcuKeyRight();
                                        MainActivity.this.refreshMainFocusView(true);
                                    }
                                } else if (!MainActivity.this.showContentView) {
                                    MainActivity.this.zxwOriginalMcuKeyLeft();
                                    MainActivity.this.refreshMainFocusView(true);
                                }
                            } else if ((MainActivity.this.m_iUIIndex == 6 || MainActivity.this.m_iUIIndex == 4) && MainActivity.this.focusOnPasswordView) {
                                FocusUtil access$6002 = MainActivity.this.focusUtil;
                                MainActivity mainActivity11 = MainActivity.this;
                                access$6002.enterFirstViews_PasswordView(mainActivity11, mainActivity11.m_iCurrFocus);
                            } else {
                                FocusUtil access$6003 = MainActivity.this.focusUtil;
                                MainActivity mainActivity12 = MainActivity.this;
                                access$6003.enterFirstViews(mainActivity12, mainActivity12.m_iCurrFocus);
                            }
                        } else if (MainActivity.this.baseApp.getFocusPage() == 1) {
                            if (intExtra == 5) {
                                MainActivity.this.focusUtil.enterSecondViews(MainActivity.this.m_iCurrFocus);
                            } else if (intExtra != 7) {
                                if (intExtra == 8) {
                                    if (MainActivity.this.focusUtil.inSeekbarKnobMode) {
                                        MainActivity.this.focusUtil.refreshSeekbar(8);
                                        return;
                                    }
                                    if (!MainActivity.this.focusUtil.showNavSelectView()) {
                                        MainActivity.this.zxwOriginalMcuKeyRight();
                                    }
                                    MainActivity.this.focusUtil.refreshSecondViews(MainActivity.this.m_iCurrFocus, true);
                                }
                            } else if (MainActivity.this.focusUtil.inSeekbarKnobMode) {
                                MainActivity.this.focusUtil.refreshSeekbar(7);
                            } else {
                                if (!MainActivity.this.focusUtil.showNavSelectView()) {
                                    MainActivity.this.zxwOriginalMcuKeyLeft();
                                }
                                MainActivity.this.focusUtil.refreshSecondViews(MainActivity.this.m_iCurrFocus, true);
                            }
                        } else if (intExtra == 5) {
                            MainActivity.this.focusUtil.enterThirdViews(MainActivity.this.m_iCurrFocus);
                        } else if (intExtra != 7) {
                            if (intExtra == 8) {
                                if (MainActivity.this.focusUtil.inSeekbarKnobMode) {
                                    MainActivity.this.focusUtil.refreshSeekbar(8);
                                    return;
                                }
                                MainActivity.this.zxwOriginalMcuKeyRight();
                                MainActivity.this.focusUtil.refreshThirdViews(MainActivity.this.m_iCurrFocus, true);
                            }
                        } else if (MainActivity.this.focusUtil.inSeekbarKnobMode) {
                            MainActivity.this.focusUtil.refreshSeekbar(7);
                        } else {
                            MainActivity.this.zxwOriginalMcuKeyLeft();
                            MainActivity.this.focusUtil.refreshThirdViews(MainActivity.this.m_iCurrFocus, true);
                        }
                    }
                }
            } else if (action.equals("android.intent.action.LOCALE_CHANGED")) {
                Log.i(MainActivity.TAG, "--->>> 系统语言改变");
            } else if (action.equals(EventUtils.KSW_ZXW_MCUUPGRADE_MCU_UPGRADE_VIEW_LOSS_FOCUS)) {
                if (MainActivity.this.focusUtil.showMCUUpgradeView) {
                    MainActivity.this.focusUtil.showMCUUpgradeView = false;
                    MainActivity.this.focusUtil.refreshSecondViews(0, true);
                }
            } else if (action.equals("KESAIWEI_DISPLAY_MODE_CHANGED_ACTION")) {
                Log.i(MainActivity.TAG, "--->>> id8主题颜色改变");
                MainActivity.this.finish();
            } else if (action.equals(EventUtils.ZXW_ACTION_KSW_THEME_CHANGE)) {
                if (MainActivity.this.m_iUIIndex != 5) {
                    return;
                }
                if (MainActivity.this.m_iModeSet == 32 || MainActivity.this.m_iModeSet == 39) {
                    MainActivity.this.recreate();
                } else {
                    MainActivity.this.setLandRoverBg();
                }
            } else if ("android.intent.action.DATE_CHANGED".equals(action)) {
                MainActivity.this.refreshDate();
            }
        }
    }

    /* access modifiers changed from: private */
    public void refreshMainFocusView(boolean z) {
        int i = this.m_iUIIndex;
        if ((i == 6 || i == 4) && this.focusOnPasswordView) {
            this.focusUtil.refreshFirstViews_PasswordView(this, this.m_iCurrFocus);
        } else {
            this.focusUtil.refreshFirstViews(this, this.m_iCurrFocus, z);
        }
    }

    /* access modifiers changed from: private */
    public void zxwOriginalMcuKeyLeft() {
        int i = this.m_iCurrFocus - 1;
        this.m_iCurrFocus = i;
        if (i < 0) {
            this.m_iCurrFocus = 0;
        }
    }

    /* access modifiers changed from: private */
    public void zxwOriginalMcuKeyRight() {
        this.m_iCurrFocus++;
        int size = this.radioButtonIds.size();
        int i = this.m_iUIIndex;
        if ((i == 6 || i == 4) && this.focusOnPasswordView) {
            size = this.passwordButtonIds.length;
        } else if (this.leftFocus) {
            size = this.leftButtonIds.size();
        } else if (this.baseApp.getFocusPage() != 0) {
            size = this.focusUtil.getFocusViewSize();
        }
        if (this.m_iCurrFocus >= size) {
            this.m_iCurrFocus = size - 1;
        }
    }

    private void transparentSystermTitleBar() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 256 | 1024);
        window.setStatusBarColor(0);
    }

    /* access modifiers changed from: private */
    public void showTitleView() {
        ImageView imageView;
        View view;
        this.showContentView = false;
        if (!(this.titleView == null || (view = this.contentView) == null)) {
            if (view.getVisibility() == 0) {
                TranslateAnimation translateAnimation = this.l2rAction;
                if (translateAnimation != null) {
                    this.contentView.startAnimation(translateAnimation);
                }
                this.contentView.setVisibility(8);
            }
            if (this.titleView.getVisibility() == 8) {
                TranslateAnimation translateAnimation2 = this.r2lAction;
                if (translateAnimation2 != null) {
                    this.titleView.startAnimation(translateAnimation2);
                }
                this.titleView.setVisibility(0);
            }
        }
        this.m_iCurrFocus = this.lastXFocus;
        Log.d(TAG, "showTitleView m_iCurrFocus = " + this.m_iCurrFocus);
        if (this.baseApp.getFocusPage() == 1) {
            this.baseApp.setFocusPage(0);
        }
        if (this.m_iUIIndex == 4 && (imageView = this.iconView) != null) {
            imageView.setBackground((Drawable) null);
        }
    }

    private void showContentView() {
        this.showContentView = true;
        View view = this.titleView;
        if (!(view == null || this.contentView == null)) {
            if (view.getVisibility() == 0) {
                TranslateAnimation translateAnimation = this.l2rAction;
                if (translateAnimation != null) {
                    this.titleView.startAnimation(translateAnimation);
                }
                this.titleView.setVisibility(8);
            }
            if (this.contentView.getVisibility() == 8) {
                TranslateAnimation translateAnimation2 = this.r2lAction;
                if (translateAnimation2 != null) {
                    this.contentView.startAnimation(translateAnimation2);
                }
                this.contentView.setVisibility(0);
            }
        }
        this.lastXFocus = this.m_iCurrFocus;
        this.m_iCurrFocus = -1;
        if (this.baseApp.getFocusPage() == 0) {
            this.baseApp.setFocusPage(1);
        }
    }

    private void showPasswordView() {
        this.showPasswordView = true;
        if (this.m_iUIIndex == 4) {
            this.m_iCurrFocus = 0;
            this.focusOnPasswordView = true;
            refreshMainFocusView(false);
        }
        View view = this.passwordView;
        if (view != null && view.getVisibility() == 8) {
            TranslateAnimation translateAnimation = this.t2bAction;
            if (translateAnimation != null) {
                this.passwordView.startAnimation(translateAnimation);
            }
            this.passwordView.setVisibility(0);
        }
    }

    private void hidePasswordView() {
        this.showPasswordView = false;
        if (this.m_iUIIndex == 4) {
            this.m_iCurrFocus = 8;
            this.focusOnPasswordView = false;
        }
        View view = this.passwordView;
        if (view != null && view.getVisibility() == 0) {
            TranslateAnimation translateAnimation = this.b2tAction;
            if (translateAnimation != null) {
                this.passwordView.startAnimation(translateAnimation);
            }
            this.passwordView.setVisibility(8);
        }
        TextView textView = this.mTvInputUserFreq;
        if (textView != null) {
            textView.setText("");
            this.mUserInputFreq = "";
        }
    }

    private void showID8Content() {
        Log.d(TAG, "showID8Content");
        ViewPager viewPager = this.mPager;
        if (viewPager != null && viewPager.getVisibility() == 8) {
            this.mPager.startAnimation(this.t2bAction);
            this.mPager.setVisibility(0);
        }
        this.baseApp.setFocusPage(1);
        this.lastXFocus = this.m_iCurrFocus;
        this.m_iCurrFocus = -1;
        this.focusUtil.refreshSecondViews(-1, true);
        if (BaseApp.m_iUIIndex == 2) {
            View findViewById = findViewById(R.id.viewPager);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            View findViewById2 = findViewById(R.id.viewAndroid);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            View findViewById3 = findViewById(R.id.viewOem);
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
            View findViewById4 = findViewById(R.id.viewSound);
            if (findViewById4 != null) {
                findViewById4.setVisibility(8);
            }
            View findViewById5 = findViewById(R.id.imgLeftBg);
            if (findViewById5 != null) {
                findViewById5.setVisibility(0);
            }
            View findViewById6 = findViewById(R.id.imgRightBg);
            if (findViewById6 != null) {
                findViewById6.setVisibility(8);
            }
            View findViewById7 = findViewById(R.id.imgDirection);
            if (findViewById7 != null) {
                findViewById7.setBackground(getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_bt_icon_right));
            }
        }
    }

    public void hideID8Content() {
        ArrayList<Fragment> arrayList;
        Log.d(TAG, "hideID8Content");
        this.baseApp.setFocusPage(0);
        int i = this.lastXFocus;
        if (i == 2) {
            ((FragmentVolSet_KSW) getCurrentFragment()).hideViews();
        } else if (i == 0) {
            ((FragmentSystemNew) getCurrentFragment()).hideViews();
        }
        this.m_iCurrFocus = this.lastXFocus;
        refreshMainFocusView(true);
        ViewPager viewPager = this.mPager;
        if (viewPager != null && viewPager.getVisibility() == 0) {
            this.mPager.startAnimation(this.b2tAction);
            this.mPager.setVisibility(8);
        }
        if (this.m_iUIIndex == 2 && (arrayList = this.mFragmentList) != null && arrayList.size() > 4) {
            FragmentStartCode fragmentStartCode = (FragmentStartCode) this.mFragmentList.get(5);
            if (fragmentStartCode.mTvInputUserFreq != null) {
                fragmentStartCode.mTvInputUserFreq.setText("");
            }
            if (fragmentStartCode.mUserInputFreq != null) {
                fragmentStartCode.mUserInputFreq = "";
            }
            if (fragmentStartCode.mTvTitle != null) {
                fragmentStartCode.mTvTitle.setVisibility(0);
            }
        }
    }

    public void sendModeTitle(int i) {
        String str;
        switch (i) {
            case GyroScopeWithCompassView.CARTYPE_Polo2016_HI /*202*/:
                if (this.m_iUIIndex != 2) {
                    str = getString(R.string.lbl_nav_set);
                    break;
                } else {
                    str = getString(R.string.lbl_nav_set).toUpperCase();
                    break;
                }
            case GyroScopeWithCompassView.CARTYPE_DAQIE2013_LO /*203*/:
                if (this.m_iUIIndex != 2) {
                    str = getString(R.string.lbl_language_set);
                    break;
                } else {
                    str = getString(R.string.lbl_language_set).toUpperCase();
                    break;
                }
            case GyroScopeWithCompassView.CARTYPE_DAQIE2013_HI /*204*/:
                if (this.m_iUIIndex != 2) {
                    str = getString(R.string.lbl_datatimer_set);
                    break;
                } else {
                    str = getString(R.string.lbl_datatimer_set).toUpperCase();
                    break;
                }
            case GyroScopeWithCompassView.CARTYPE_MALIBU_H_H /*205*/:
                str = getString(R.string.lbl_volume_set);
                break;
            case GyroScopeWithCompassView.CARTYPE_Kaluola_OLD_LO /*206*/:
                int i2 = this.m_iUIIndex;
                if (i2 != 2) {
                    if (i2 != 7) {
                        str = getString(R.string.lbl_sound_set2);
                        break;
                    } else {
                        str = getString(R.string.lb_id8_settings_audio);
                        break;
                    }
                } else {
                    str = getString(R.string.lb_id8_settings_audio).toUpperCase();
                    break;
                }
            case GyroScopeWithCompassView.CARTYPE_Kaluola_OLD_HI /*207*/:
                if (this.m_iUIIndex != 2) {
                    str = getString(R.string.lbl_sys_set);
                    break;
                } else {
                    str = getString(R.string.lbl_sys_set).toUpperCase();
                    break;
                }
            case GyroScopeWithCompassView.CARTYPE_JIANGLING_S330_LO /*208*/:
                if (this.m_iUIIndex != 2) {
                    str = getString(R.string.lbl_fat_set);
                    break;
                } else {
                    str = getString(R.string.lbl_fat_set).toUpperCase();
                    break;
                }
            case GyroScopeWithCompassView.CARTYPE_JIANGLING_S330_HI /*209*/:
                if (this.m_iUIIndex != 2) {
                    str = getString(R.string.lbl_sys_infor);
                    break;
                } else {
                    str = getString(R.string.lbl_sys_infor).toUpperCase();
                    break;
                }
            default:
                str = "";
                break;
        }
        TextView textView = this.txtModeTitle;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void startMoreSettings() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings"));
        intent.setFlags(270532608);
        startActivity(intent);
    }

    private void clickVirtual() {
        Log.d(TAG, "clickVirtual");
        getResources().getDisplayMetrics();
        new Thread($$Lambda$MainActivity$pbb1DolkJvP1oL88s4tnIV5yf8.INSTANCE).start();
    }

    static /* synthetic */ void lambda$clickVirtual$4() {
        Instrumentation instrumentation = new Instrumentation();
        instrumentation.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, -1.0f, 0.0f, 0));
        instrumentation.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, -1.0f, 0.0f, 0));
    }

    private void initAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        this.r2lAction = translateAnimation;
        translateAnimation.setDuration(500);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        this.l2rAction = translateAnimation2;
        translateAnimation2.setDuration(500);
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.t2bAction = translateAnimation3;
        translateAnimation3.setDuration(300);
        TranslateAnimation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.b2tAction = translateAnimation4;
        translateAnimation4.setDuration(300);
    }

    private void initAnimationID8() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.t2bAction = translateAnimation;
        translateAnimation.setDuration(300);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.b2tAction = translateAnimation2;
        translateAnimation2.setDuration(300);
    }

    private void enterMusic() {
        String recordValue = this.mSysProviderOpt.getRecordValue(SysProviderOpt.MUSIC_PACKAGENAME, EventUtils.MUSIC_MODE_PACKAGE_NAME);
        String recordValue2 = this.mSysProviderOpt.getRecordValue(SysProviderOpt.MUSIC_ACTIVITYNAME, EventUtils.MUSIC_MODE_CLASS_NAME);
        if (!EventUtils.MUSIC_MODE_PACKAGE_NAME.equals(recordValue)) {
            try {
                Log.d(TAG, "sendMusicMode");
                this.mService.sendMode(EventUtils.eSrcMode.SRC_MUSIC.getIntValue(), false);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "musicPackage = " + recordValue + ", musicMainClass = " + recordValue2);
        EventUtils.startActivityIfNotRuning(this, recordValue, recordValue2);
    }

    private void enterNavi() {
        String str = "com.szchoiceway.navigation";
        String recordValue = this.mSysProviderOpt.getRecordValue("NAV_PACKAGENAME", str);
        String str2 = "com.szchoiceway.navigation.MainActivity";
        String recordValue2 = this.mSysProviderOpt.getRecordValue("NAV_ACTIVITYNAME", str2);
        if (EventUtils.getInstallStatus(this, recordValue)) {
            str = recordValue;
            str2 = recordValue2;
        }
        EventUtils.startActivityIfNotRuning(this, str, str2);
    }

    private void enterBT() {
        if (this.mSysProviderOpt.getRecordInteger("KESAIWEI_RECORD_BT_INDEX", 0) == 1) {
            sendBroadcast(new Intent("com.szchoiceway.eventcenter.EventUtils.ACTION_SWITCH_ORIGINACAR"));
        } else {
            EventUtils.startActivityIfNotRuning(this, "com.szchoiceway.btsuite", "com.szchoiceway.btsuite.BTMainActivity");
        }
    }

    public Fragment getCurrentFragment() {
        Log.d(TAG, "lastXFocus = " + this.lastXFocus);
        int i = this.lastXFocus;
        int i2 = this.androidSettingsIndex;
        if (i < i2) {
            return this.mFragmentList.get(i);
        }
        if (i > i2) {
            return this.mFragmentList.get(i - 1);
        }
        return null;
    }

    public void updateFocusViewDelay(int i) {
        this.m_iCurrFocus = i;
        this.mHandler.sendEmptyMessageDelayed(0, 50);
    }

    private void clickCode(int i) {
        switch (i) {
            case R.id.BtnNum0:
                inputUserFreq(0);
                return;
            case R.id.BtnNum1:
                inputUserFreq(1);
                return;
            case R.id.BtnNum2:
                inputUserFreq(2);
                return;
            case R.id.BtnNum3:
                inputUserFreq(3);
                return;
            case R.id.BtnNum4:
                inputUserFreq(4);
                return;
            case R.id.BtnNum5:
                inputUserFreq(5);
                return;
            case R.id.BtnNum6:
                inputUserFreq(6);
                return;
            case R.id.BtnNum7:
                inputUserFreq(7);
                return;
            case R.id.BtnNum8:
                inputUserFreq(8);
                return;
            case R.id.BtnNum9:
                inputUserFreq(9);
                return;
            case R.id.BtnNumDel:
                inputUserFreq(11);
                return;
            case R.id.BtnNumOK:
                confirmUserFreq();
                return;
            default:
                return;
        }
    }

    private void inputUserFreq(int i) {
        Log.i(TAG, "inputUser num = " + i);
        TextView textView = this.mTvInputUserFreq;
        if (textView != null) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
            this.mTvInputUserFreq.setTextSize(2, getResources().getDimension(R.dimen.password_font_size));
        }
        if (this.mUserInputFreq.equals(getString(R.string.lbl_code_error))) {
            this.mUserInputFreq = "";
        }
        if (i != 11) {
            this.mUserInputFreq += i;
        } else if (this.mUserInputFreq.length() == 1) {
            this.mUserInputFreq = "";
        } else if (this.mUserInputFreq.length() > 0) {
            String str = this.mUserInputFreq;
            this.mUserInputFreq = str.substring(0, str.length() - 1);
        }
        TextView textView2 = this.mTvInputUserFreq;
        if (textView2 != null) {
            textView2.setText(this.mUserInputFreq);
        }
    }

    private void confirmUserFreq() {
        if (this.mUserInputFreq.length() != 0) {
            if (isValidUserFreq()) {
                Log.i(TAG, "Code ok");
                this.mUserInputFreq = "";
                EventUtils.startActivityIfNotRuning(this, "com.szchoiceway.fatset", "com.szchoiceway.fatset.FatSetMainActivity");
            } else {
                Log.i(TAG, "Code error");
                this.mUserInputFreq = getString(R.string.lbl_code_error);
                TextView textView = this.mTvInputUserFreq;
                if (textView != null) {
                    textView.setTypeface(Typeface.defaultFromStyle(0));
                    this.mTvInputUserFreq.setTextSize(2, getResources().getDimension(R.dimen.password_error_font_size));
                }
            }
            TextView textView2 = this.mTvInputUserFreq;
            if (textView2 != null) {
                textView2.setText(this.mUserInputFreq);
            }
        }
    }

    private boolean isValidUserFreq() {
        String str;
        if (this.m_iUITypeVer == 41) {
            str = this.mSysProviderOpt.getRecordValue(SysProviderOpt.KSW_FACTORY_SET_PASSWORD);
            if (str.equals("")) {
                str = "1314";
            }
        } else {
            str = null;
        }
        if (this.mUserInputFreq.equals(str)) {
            return true;
        }
        Log.i(TAG, "Code error");
        return false;
    }

    /* access modifiers changed from: private */
    public void clickBack() {
        try {
            Runtime.getRuntime().exec(" input keyevent 4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initSetItem() {
        this.menuList = new ArrayList();
        MainMenuBean mainMenuBean = new MainMenuBean();
        if (this.m_iModeSet == 39) {
            mainMenuBean.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_system_set)));
            mainMenuBean.setTvTitle(getString(R.string.lbl_sys_set));
            this.menuList.add(mainMenuBean);
            MainMenuBean mainMenuBean2 = new MainMenuBean();
            mainMenuBean2.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_language_set)));
            mainMenuBean2.setTvTitle(getString(R.string.lbl_language_set));
            this.menuList.add(mainMenuBean2);
            MainMenuBean mainMenuBean3 = new MainMenuBean();
            mainMenuBean3.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_system_info)));
            mainMenuBean3.setTvTitle(getString(R.string.lbl_sys_infor));
            this.menuList.add(mainMenuBean3);
            MainMenuBean mainMenuBean4 = new MainMenuBean();
            mainMenuBean4.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_android_set)));
            mainMenuBean4.setTvTitle(getString(R.string.lbl_android_set));
            this.menuList.add(mainMenuBean4);
            MainMenuBean mainMenuBean5 = new MainMenuBean();
            mainMenuBean5.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_factory_set)));
            mainMenuBean5.setTvTitle(getString(R.string.lbl_fat_set));
            this.menuList.add(mainMenuBean5);
            return;
        }
        mainMenuBean.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_system_set)));
        mainMenuBean.setTvTitle(getString(R.string.lbl_sys_set));
        mainMenuBean.setTag("NAVISETTINGS_SYSTEM_SET");
        this.menuList.add(mainMenuBean);
        MainMenuBean mainMenuBean6 = new MainMenuBean();
        mainMenuBean6.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_nav_set)));
        mainMenuBean6.setTvTitle(getString(R.string.lbl_nav_set));
        this.menuList.add(mainMenuBean6);
        MainMenuBean mainMenuBean7 = new MainMenuBean();
        mainMenuBean7.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_volume_set)));
        mainMenuBean7.setTvTitle(getString(R.string.lbl_volume_set));
        this.menuList.add(mainMenuBean7);
        MainMenuBean mainMenuBean8 = new MainMenuBean();
        mainMenuBean8.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_language_set)));
        mainMenuBean8.setTvTitle(getString(R.string.lbl_language_set));
        this.menuList.add(mainMenuBean8);
        MainMenuBean mainMenuBean9 = new MainMenuBean();
        mainMenuBean9.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_time_set)));
        mainMenuBean9.setTvTitle(getString(R.string.lbl_datatimer_set));
        this.menuList.add(mainMenuBean9);
        MainMenuBean mainMenuBean10 = new MainMenuBean();
        mainMenuBean10.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_system_info)));
        mainMenuBean10.setTvTitle(getString(R.string.lbl_sys_infor));
        this.menuList.add(mainMenuBean10);
        MainMenuBean mainMenuBean11 = new MainMenuBean();
        mainMenuBean11.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_android_set)));
        mainMenuBean11.setTvTitle(getString(R.string.lbl_android_set));
        this.menuList.add(mainMenuBean11);
        MainMenuBean mainMenuBean12 = new MainMenuBean();
        mainMenuBean12.setChkDrawable(getDrawable(getAttrId(R.attr.ksw_landrover_main_chk_icon_factory_set)));
        mainMenuBean12.setTvTitle(getString(R.string.lbl_fat_set));
        this.menuList.add(mainMenuBean12);
    }

    private void refreshLandroverSelection(int i) {
        if (i > -1 && i < this.landroverSelectionIds.length) {
            this.landroverSelection = i;
            int i2 = 0;
            while (true) {
                int[] iArr = this.landroverSelectionIds;
                if (i2 >= iArr.length) {
                    break;
                }
                View findViewById = findViewById(iArr[i2]);
                if (findViewById != null) {
                    findViewById.setSelected(i2 == i);
                }
                i2++;
            }
            ImageView imageView = this.img1;
            if (imageView != null) {
                imageView.setImageLevel(i);
            }
        }
    }

    private void clickHome() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    private int getAttrId(int i) {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean isDefaultUI() {
        return this.m_iUIIndex == 1 || this.m_iModeSet >= 100;
    }
}
