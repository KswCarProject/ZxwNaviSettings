package com.szchoiceway.settings.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.FragSettingsAdapter;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.adapter.MainMenuAdapter;
import com.szchoiceway.settings.bean.MainMenuBean;
import com.szchoiceway.settings.fragments.FragmentSystemNew;
import com.szchoiceway.settings.view.ClipScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.zxwlib.bean.Customer;
import java.util.ArrayList;
import java.util.List;

public class FragmentSystemNew extends FragmentBase implements View.OnClickListener {
    private static final String TAG = "FragmentSystemNew";
    private FragSettingsAdapter adapter;
    private int focusIndex = -1;
    public ArrayList<Fragment> fragments = null;
    private ImageView imgRightIcon;
    private List<MainMenuBean> list;
    private View listView;
    private MainActivity mMain;
    public ViewPager mPager = null;
    private View mainView;
    private MainMenuAdapter menuAdapter;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    private View pagerView;
    private int[] radioButtonsId;
    private RecyclerView recyclerView;
    /* access modifiers changed from: private */
    public View scrollLayout;
    /* access modifiers changed from: private */
    public ScrollView systemScrollView;
    /* access modifiers changed from: private */
    public int totalHeight = 0;
    private TextView tvTitle;

    static /* synthetic */ boolean lambda$bindViewListener$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public String getFragmentTag() {
        return TAG;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Log.d(TAG, "onCreateView");
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_main, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_main, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_main, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_main, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_main, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_main_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_main, (ViewGroup) null);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_main, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_main, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_main, (ViewGroup) null);
        } else if (this.m_iUIIndex != 5) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_main, (ViewGroup) null);
        } else if (this.m_iModeSet == 32) {
            view = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_main, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_main, (ViewGroup) null);
        }
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void onResume() {
        super.onResume();
        this.mainView = getView();
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        Log.d(TAG, "bindViewListener");
        super.bindViewListener(view);
        this.mainView = view;
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mMain = mainActivity;
        if (mainActivity != null) {
            this.baseApp = (BaseApp) mainActivity.getApplication();
        }
        if (view != null) {
            this.listView = view.findViewById(R.id.listView);
            View findViewById = view.findViewById(R.id.pagerView);
            this.pagerView = findViewById;
            if (findViewById != null && this.m_iModeSet == 32) {
                this.pagerView.setOnTouchListener($$Lambda$FragmentSystemNew$OH8HH7HusvnKcSxmDm0C21Tse8.INSTANCE);
            }
            hideContentView();
            this.myScrollbar = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            this.systemScrollView = (ScrollView) view.findViewById(R.id.systemScrollView);
            View findViewById2 = view.findViewById(R.id.scrollLayout);
            this.scrollLayout = findViewById2;
            if (findViewById2 != null) {
                findViewById2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        FragmentSystemNew.this.scrollLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        FragmentSystemNew fragmentSystemNew = FragmentSystemNew.this;
                        int unused = fragmentSystemNew.totalHeight = fragmentSystemNew.scrollLayout.getHeight();
                        if (FragmentSystemNew.this.systemScrollView != null) {
                            FragmentSystemNew.this.systemScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                                public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                                    FragmentSystemNew.AnonymousClass1.this.lambda$onGlobalLayout$0$FragmentSystemNew$1(view, i, i2, i3, i4);
                                }
                            });
                        }
                    }

                    public /* synthetic */ void lambda$onGlobalLayout$0$FragmentSystemNew$1(View view, int i, int i2, int i3, int i4) {
                        float access$100 = (((float) i2) * 1.0f) / ((float) (FragmentSystemNew.this.totalHeight - FragmentSystemNew.this.systemScrollView.getHeight()));
                        if (FragmentSystemNew.this.myScrollbar != null) {
                            FragmentSystemNew.this.myScrollbar.setCurrentPercent(access$100);
                        }
                        if (FragmentSystemNew.this.systemScrollView instanceof ClipScrollView) {
                            ((ClipScrollView) FragmentSystemNew.this.systemScrollView).setScrollHeight(i2);
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imgRightIcon);
            this.imgRightIcon = imageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (this.mProductIndex > 0) {
                this.radioButtonsId = new int[]{R.id.btnBackCarSet, R.id.btnDisplaySet, R.id.btnBtSet, R.id.btnUnitSet, R.id.btnDvrSet, R.id.btnMusicAppSet, R.id.btnVideoAppSet, R.id.btnOtherSet};
            } else {
                this.radioButtonsId = new int[]{R.id.btnBackCarSet, R.id.btnDisplaySet, R.id.btnBtSet, R.id.btnUnitSet, R.id.btnDvrSet, R.id.btnAuxSwitchSet, R.id.btnMusicAppSet, R.id.btnVideoAppSet, R.id.btnOtherSet};
            }
            for (int findViewById3 : this.radioButtonsId) {
                View findViewById4 = view.findViewById(findViewById3);
                if (findViewById4 != null) {
                    findViewById4.setOnClickListener(this);
                }
            }
            initViewPager(view);
            View findViewById5 = view.findViewById(R.id.btnReturn);
            if (findViewById5 != null) {
                findViewById5.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        FragmentSystemNew.this.lambda$bindViewListener$1$FragmentSystemNew(view);
                    }
                });
            }
            View findViewById6 = view.findViewById(R.id.btnHidePagerView);
            if (findViewById6 != null) {
                findViewById6.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        FragmentSystemNew.this.lambda$bindViewListener$2$FragmentSystemNew(view);
                    }
                });
            }
            this.recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewSystemSet);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            if (this.recyclerView != null) {
                initData();
                this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(getMainActivity(), this.list, 2);
                this.menuAdapter = mainMenuAdapter;
                this.recyclerView.setAdapter(mainMenuAdapter);
                this.menuAdapter.setPosition(0);
                this.menuAdapter.setOnItemClickListener(new MainMenuAdapter.OnItemClickListener() {
                    public final void onItemClick(int i) {
                        FragmentSystemNew.this.lambda$bindViewListener$3$FragmentSystemNew(i);
                    }
                });
            }
            initProductView(view);
        }
    }

    public /* synthetic */ void lambda$bindViewListener$1$FragmentSystemNew(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        Log.d(TAG, "onClick btnReturn main = " + mainActivity);
        if (mainActivity != null) {
            mainActivity.hideID8Content();
        }
    }

    public /* synthetic */ void lambda$bindViewListener$2$FragmentSystemNew(View view) {
        hideContentView();
    }

    public /* synthetic */ void lambda$bindViewListener$3$FragmentSystemNew(int i) {
        this.menuAdapter.setPosition(i);
        if (this.tvTitle != null) {
            String tvTitle2 = this.list.get(i).getTvTitle();
            if (i == 6) {
                tvTitle2 = getResources().getString(R.string.lbl_set_music_apk);
            }
            if (i == 7) {
                tvTitle2 = getResources().getString(R.string.lbl_set_video_apk);
            }
            this.tvTitle.setText(tvTitle2);
        }
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i, false);
        }
        hideViewList();
        this.baseApp.setFocusPage(2);
    }

    private void initProductView(View view) {
        View findViewById = view.findViewById(R.id.viewProductLine);
        int i = 8;
        if (findViewById != null) {
            findViewById.setVisibility(this.mProductIndex > 0 ? 8 : 0);
        }
        View findViewById2 = view.findViewById(R.id.btnAuxSwitchSet);
        if (findViewById2 != null) {
            if (this.mProductIndex <= 0) {
                i = 0;
            }
            findViewById2.setVisibility(i);
        }
    }

    private void initViewPager(View view) {
        this.fragments = new ArrayList<>();
        this.mPager = (ViewPager) view.findViewById(R.id.viewPager);
        if (this.m_iUITypeVer == 41) {
            FragmentSystemSet_BackCar fragmentSystemSet_BackCar = new FragmentSystemSet_BackCar();
            FragmentSystemSet_Display fragmentSystemSet_Display = new FragmentSystemSet_Display();
            FragmentSystemSet_BT fragmentSystemSet_BT = new FragmentSystemSet_BT();
            FragmentSystemSet_Unit fragmentSystemSet_Unit = new FragmentSystemSet_Unit();
            FragmentSystemSet_Dvr fragmentSystemSet_Dvr = new FragmentSystemSet_Dvr();
            FragmentSystemSet_AUX fragmentSystemSet_AUX = new FragmentSystemSet_AUX();
            FragmentSystemSet_MusicPlayer fragmentSystemSet_MusicPlayer = new FragmentSystemSet_MusicPlayer();
            FragmentSystemSet_VideoPlayer fragmentSystemSet_VideoPlayer = new FragmentSystemSet_VideoPlayer();
            FragmentSystemSet_Other fragmentSystemSet_Other = new FragmentSystemSet_Other();
            this.fragments.add(fragmentSystemSet_BackCar);
            this.fragments.add(fragmentSystemSet_Display);
            this.fragments.add(fragmentSystemSet_BT);
            this.fragments.add(fragmentSystemSet_Unit);
            this.fragments.add(fragmentSystemSet_Dvr);
            if (this.mProductIndex == 0) {
                this.fragments.add(fragmentSystemSet_AUX);
            }
            this.fragments.add(fragmentSystemSet_MusicPlayer);
            this.fragments.add(fragmentSystemSet_VideoPlayer);
            this.fragments.add(fragmentSystemSet_Other);
            FragSettingsAdapter fragSettingsAdapter = new FragSettingsAdapter(getChildFragmentManager(), this.fragments);
            this.adapter = fragSettingsAdapter;
            this.mPager.setAdapter(fragSettingsAdapter);
            if (this.m_iUIIndex == 6 || this.m_iUIIndex == 3 || isDefaultUI()) {
                setPage(0);
            } else if (this.m_iUIIndex == 2) {
                setPage(0);
                this.mPager.setVisibility(8);
            }
        }
    }

    private void setPage(int i) {
        int[] iArr;
        ViewPager viewPager = this.mPager;
        int i2 = 0;
        if (viewPager != null) {
            viewPager.setCurrentItem(i, false);
        }
        if (this.m_iUIIndex == 7) {
            if (this.mainView != null && (iArr = this.radioButtonsId) != null && iArr.length > 0) {
                while (true) {
                    int[] iArr2 = this.radioButtonsId;
                    if (i2 < iArr2.length) {
                        RadioButton radioButton = (RadioButton) this.mainView.findViewById(iArr2[i2]);
                        if (radioButton != null) {
                            radioButton.setTextColor(i2 == i ? Color.parseColor("#9cc5e6") : -1);
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        } else if (this.m_iUIIndex == 4 && Customer.isSmallResolution(getContext())) {
            while (true) {
                int[] iArr3 = this.radioButtonsId;
                if (i2 < iArr3.length) {
                    RadioButton radioButton2 = (RadioButton) this.mainView.findViewById(iArr3[i2]);
                    if (radioButton2 != null) {
                        radioButton2.setTextColor(i2 == i ? Color.parseColor("#5c6058") : -1);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void onClick(View view) {
        if (this.focusUtil.inSeekbarKnobMode) {
            this.focusUtil.clearSeekbarFocus();
        }
        int i = 0;
        while (true) {
            int[] iArr = this.radioButtonsId;
            if (i >= iArr.length) {
                break;
            }
            RadioButton radioButton = (RadioButton) this.mMain.findViewById(iArr[i]);
            if (radioButton != null) {
                if (view.getId() == this.radioButtonsId[i]) {
                    this.m_CurrFocus = i;
                    if (this.mPager != null) {
                        setPage(this.m_CurrFocus);
                    }
                    if (isDefaultUI()) {
                        radioButton.setTextColor(Color.parseColor("#FF3300"));
                    } else if (this.m_iUIIndex == 2) {
                        radioButton.setTextColor(getResources().getColor(getAttrId(R.attr.ksw_id8_fontColor)));
                        this.mPager.setVisibility(0);
                    } else if (this.m_iModeSet == 19) {
                        radioButton.setTextColor(Color.parseColor("#5ac0ff"));
                    }
                } else {
                    radioButton.setTextColor(Color.parseColor("#FFFFFF"));
                }
            }
            i++;
        }
        if (BaseApp.m_iModeSet == 19 || isDefaultUI() || this.m_iUIIndex == 7) {
            this.baseApp.setFocusPage(1);
            this.mMain.m_iCurrFocus = this.m_CurrFocus;
            if (this.m_iUIIndex == 7) {
                this.mMain.lastXFocus = 0;
            } else {
                this.mMain.lastXFocus = 2;
            }
            this.focusUtil.refreshFirstViews(this.mMain, -1, false);
            this.focusUtil.refreshThirdViews(-1, true);
            this.focusUtil.locateFragment(this, TAG);
            addViewIds();
            this.focusUtil.refreshSecondViews(this.mMain.m_iCurrFocus, false);
        } else if (BaseApp.m_iUIIndex == 2) {
            ImageView imageView = this.imgRightIcon;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.baseApp.setFocusPage(1);
            this.mMain.m_iCurrFocus = this.m_CurrFocus;
            this.focusUtil.refreshThirdViews(-1, true);
            this.focusUtil.locateFragment(this, TAG);
            addViewIds();
            this.focusUtil.refreshSecondViews(this.mMain.m_iCurrFocus, false);
        } else if (BaseApp.m_iUIIndex == 6 || this.m_iUIIndex == 4) {
            this.mMain.m_iCurrFocus = this.m_CurrFocus;
            this.mMain.lastYFocus = this.m_CurrFocus;
            this.focusUtil.refreshSecondViews(this.mMain.m_iCurrFocus, false);
            this.baseApp.setFocusPage(2);
            this.focusUtil.setViewPageCurItem(this.mMain.m_iCurrFocus);
            hideViewList();
            this.mMain.m_iCurrFocus = -1;
            this.focusUtil.refreshThirdViews(this.mMain.m_iCurrFocus, true);
        } else if (BaseApp.m_iUIIndex == 7) {
            this.mMain.m_iCurrFocus = this.m_CurrFocus;
            this.mMain.lastYFocus = this.m_CurrFocus;
            this.focusUtil.refreshSecondViews(this.mMain.m_iCurrFocus, false);
            this.baseApp.setFocusPage(2);
            hideViewList();
            this.mMain.m_iCurrFocus = -1;
            this.focusUtil.refreshThirdViews(this.mMain.m_iCurrFocus, true);
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        this.focusViews.add(Integer.valueOf(R.id.btnBackCarSet));
        this.focusViews.add(Integer.valueOf(R.id.btnDisplaySet));
        this.focusViews.add(Integer.valueOf(R.id.btnBtSet));
        this.focusViews.add(Integer.valueOf(R.id.btnUnitSet));
        this.focusViews.add(Integer.valueOf(R.id.btnDvrSet));
        Log.d(TAG, "addViewIds mProductIndex = " + this.mProductIndex);
        if (this.mProductIndex == 0) {
            this.focusViews.add(Integer.valueOf(R.id.btnAuxSwitchSet));
        }
        this.focusViews.add(Integer.valueOf(R.id.btnMusicAppSet));
        this.focusViews.add(Integer.valueOf(R.id.btnVideoAppSet));
        this.focusViews.add(Integer.valueOf(R.id.btnOtherSet));
        this.focusUtil.addViewIds(this.focusViews);
    }

    private int getAttrId(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void hideViews() {
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            viewPager.setVisibility(8);
        }
        ImageView imageView = this.imgRightIcon;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void hideContentView() {
        super.hideContentView();
        View view = this.listView;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.pagerView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void hideViewList() {
        View view = this.listView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.pagerView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private void initData() {
        this.list = new ArrayList();
        int[] iArr = {R.string.lbl_set_backcar, R.string.lbl_set_display, R.string.lbl_set_bt, R.string.lbl_set_unit, R.string.lbl_set_dvr, R.string.lbl_set_aux, R.string.lbl_set_musicplayer, R.string.lbl_set_videoplayer, R.string.lbl_set_other};
        for (int i = 0; i < 9; i++) {
            int i2 = iArr[i];
            MainMenuBean mainMenuBean = new MainMenuBean();
            mainMenuBean.setTvTitle(getResources().getString(i2));
            this.list.add(mainMenuBean);
        }
    }
}
