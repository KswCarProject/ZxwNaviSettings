package com.szchoiceway.settings;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.app.LocalePicker;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.settings.FragmentLanguage;
import com.szchoiceway.settings.adapter.MainMenuAdapter;
import com.szchoiceway.settings.bean.MainMenuBean;
import com.szchoiceway.settings.view.ClipScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FragmentLanguage extends FragmentBase implements View.OnClickListener {
    private static final String TAG = "FragmentLanguage";
    private MainMenuAdapter adapter;
    private List<CheckBox> checkBoxList;
    private int languageIndex = 0;
    private List<MainMenuBean> languageList;
    private CheckBox mChbAr = null;
    private CheckBox mChbDe = null;
    private CheckBox mChbEl = null;
    private CheckBox mChbEn = null;
    private CheckBox mChbEs = null;
    private CheckBox mChbFr = null;
    private CheckBox mChbHr = null;
    private CheckBox mChbIt = null;
    private CheckBox mChbIw = null;
    private CheckBox mChbJa = null;
    private CheckBox mChbKo = null;
    private CheckBox mChbNl = null;
    private CheckBox mChbPl = null;
    private CheckBox mChbPt = null;
    private CheckBox mChbRu = null;
    private CheckBox mChbSChinese = null;
    private CheckBox mChbTChinese = null;
    private CheckBox mChbTh = null;
    private CheckBox mChbTr = null;
    private CheckBox mChbVi = null;
    /* access modifiers changed from: private */
    public ScrollView mScrollView;
    private int m_CurrFocus = 0;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    private RecyclerView recycleViewLanguage;
    /* access modifiers changed from: private */
    public View scrollLayout;
    /* access modifiers changed from: private */
    public int totalHeight = 0;

    public String getFragmentTag() {
        return TAG;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            this.baseApp = (BaseApp) mainActivity.getApplication();
        }
        if (this.m_iUITypeVer != 41) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_language, (ViewGroup) null);
        } else if (this.isSmallResolution) {
            if (isDefaultUI()) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_language, (ViewGroup) null);
            } else if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_language, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_language, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_language, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_language_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_language_set, (ViewGroup) null);
                initData();
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_language, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_language_set_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_language, (ViewGroup) null);
            }
        } else if (isDefaultUI()) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_language, (ViewGroup) null);
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_language, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_language, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_language, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_language, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_language_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 5) {
            view = layoutInflater.inflate(R.layout.landrover_fragment_language_set, (ViewGroup) null);
            initData();
        } else {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_language, (ViewGroup) null);
        }
        bindViewListener(view);
        return view;
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        MainActivity mainActivity = (MainActivity) getActivity();
        if (view != null) {
            this.myScrollbar = (MyScrollbar) view.findViewById(R.id.myScrollbar);
            this.mScrollView = (ScrollView) view.findViewById(R.id.mScrollView);
            View findViewById = view.findViewById(R.id.scrollLayout);
            this.scrollLayout = findViewById;
            if (findViewById != null) {
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        FragmentLanguage.this.scrollLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        FragmentLanguage fragmentLanguage = FragmentLanguage.this;
                        int unused = fragmentLanguage.totalHeight = fragmentLanguage.scrollLayout.getHeight();
                        if (FragmentLanguage.this.mScrollView != null) {
                            FragmentLanguage.this.mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                                public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                                    FragmentLanguage.AnonymousClass1.this.lambda$onGlobalLayout$0$FragmentLanguage$1(view, i, i2, i3, i4);
                                }
                            });
                        }
                    }

                    public /* synthetic */ void lambda$onGlobalLayout$0$FragmentLanguage$1(View view, int i, int i2, int i3, int i4) {
                        float access$100 = (((float) i2) * 1.0f) / ((float) (FragmentLanguage.this.totalHeight - FragmentLanguage.this.mScrollView.getHeight()));
                        if (FragmentLanguage.this.myScrollbar != null) {
                            FragmentLanguage.this.myScrollbar.setCurrentPercent(access$100);
                        }
                        if (FragmentLanguage.this.mScrollView instanceof ClipScrollView) {
                            ((ClipScrollView) FragmentLanguage.this.mScrollView).setScrollHeight(i2);
                        }
                    }
                });
            }
            View findViewById2 = view.findViewById(R.id.btnReturn);
            Log.d(TAG, "btnReturn = " + findViewById2);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        FragmentLanguage.this.lambda$bindViewListener$0$FragmentLanguage(view);
                    }
                });
            }
            int[] iArr = {R.id.btnLangSCN, R.id.btnLangTCN, R.id.btnLangEN, R.id.btnLangAR, R.id.btnLangDE, R.id.btnLangEL, R.id.btnLangES, R.id.btnLangFR, R.id.btnLangIT, R.id.btnLangIW, R.id.btnLangJA, R.id.btnLangKO, R.id.btnLangNL, R.id.btnLangPL, R.id.btnLangPT, R.id.btnLangRU, R.id.btnLangTH, R.id.btnLangTR, R.id.btnLangVI, R.id.btnLangHR};
            for (int i = 0; i < 20; i++) {
                View findViewById3 = view.findViewById(iArr[i]);
                if (findViewById3 != null) {
                    findViewById3.setOnClickListener(this);
                }
            }
            this.checkBoxList = new ArrayList();
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.CkbLangSCN);
            this.mChbSChinese = checkBox;
            this.checkBoxList.add(checkBox);
            CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.CkbLangTCN);
            this.mChbTChinese = checkBox2;
            this.checkBoxList.add(checkBox2);
            CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.CkbLangEN);
            this.mChbEn = checkBox3;
            this.checkBoxList.add(checkBox3);
            CheckBox checkBox4 = (CheckBox) view.findViewById(R.id.CkbLangAR);
            this.mChbAr = checkBox4;
            this.checkBoxList.add(checkBox4);
            CheckBox checkBox5 = (CheckBox) view.findViewById(R.id.CkbLangDE);
            this.mChbDe = checkBox5;
            this.checkBoxList.add(checkBox5);
            CheckBox checkBox6 = (CheckBox) view.findViewById(R.id.CkbLangEL);
            this.mChbEl = checkBox6;
            this.checkBoxList.add(checkBox6);
            CheckBox checkBox7 = (CheckBox) view.findViewById(R.id.CkbLangES);
            this.mChbEs = checkBox7;
            this.checkBoxList.add(checkBox7);
            CheckBox checkBox8 = (CheckBox) view.findViewById(R.id.CkbLangFR);
            this.mChbFr = checkBox8;
            this.checkBoxList.add(checkBox8);
            CheckBox checkBox9 = (CheckBox) view.findViewById(R.id.CkbLangIT);
            this.mChbIt = checkBox9;
            this.checkBoxList.add(checkBox9);
            CheckBox checkBox10 = (CheckBox) view.findViewById(R.id.CkbLangIW);
            this.mChbIw = checkBox10;
            this.checkBoxList.add(checkBox10);
            CheckBox checkBox11 = (CheckBox) view.findViewById(R.id.CkbLangJA);
            this.mChbJa = checkBox11;
            this.checkBoxList.add(checkBox11);
            CheckBox checkBox12 = (CheckBox) view.findViewById(R.id.CkbLangKO);
            this.mChbKo = checkBox12;
            this.checkBoxList.add(checkBox12);
            CheckBox checkBox13 = (CheckBox) view.findViewById(R.id.CkbLangNL);
            this.mChbNl = checkBox13;
            this.checkBoxList.add(checkBox13);
            CheckBox checkBox14 = (CheckBox) view.findViewById(R.id.CkbLangPL);
            this.mChbPl = checkBox14;
            this.checkBoxList.add(checkBox14);
            CheckBox checkBox15 = (CheckBox) view.findViewById(R.id.CkbLangPT);
            this.mChbPt = checkBox15;
            this.checkBoxList.add(checkBox15);
            CheckBox checkBox16 = (CheckBox) view.findViewById(R.id.CkbLangRU);
            this.mChbRu = checkBox16;
            this.checkBoxList.add(checkBox16);
            CheckBox checkBox17 = (CheckBox) view.findViewById(R.id.CkbLangTH);
            this.mChbTh = checkBox17;
            this.checkBoxList.add(checkBox17);
            CheckBox checkBox18 = (CheckBox) view.findViewById(R.id.CkbLangTR);
            this.mChbTr = checkBox18;
            this.checkBoxList.add(checkBox18);
            CheckBox checkBox19 = (CheckBox) view.findViewById(R.id.CkbLangVI);
            this.mChbVi = checkBox19;
            this.checkBoxList.add(checkBox19);
            CheckBox checkBox20 = (CheckBox) view.findViewById(R.id.CkbLangHR);
            this.mChbHr = checkBox20;
            this.checkBoxList.add(checkBox20);
            String language = Locale.getDefault().getLanguage();
            String country = Locale.getDefault().getCountry();
            Log.i(TAG, "--->>> lan = " + language + ", country = " + country);
            if (language.equals("zh") && country.equals("CN")) {
                checked(this.mChbSChinese);
                this.languageIndex = 0;
            } else if (language.equals("zh") && country.equals("TW")) {
                checked(this.mChbTChinese);
                this.languageIndex = 1;
            } else if (language.equals("en")) {
                checked(this.mChbEn);
                this.languageIndex = 2;
            } else if (language.equals("ar")) {
                checked(this.mChbAr);
                this.languageIndex = 3;
            } else if (language.equals("de")) {
                checked(this.mChbDe);
                this.languageIndex = 4;
            } else if (language.equals("el")) {
                checked(this.mChbEl);
                this.languageIndex = 5;
            } else if ("es".equals(language)) {
                checked(this.mChbEs);
                this.languageIndex = 6;
            } else if ("fr".equals(language)) {
                checked(this.mChbFr);
                this.languageIndex = 7;
            } else if ("it".equals(language)) {
                checked(this.mChbIt);
                this.languageIndex = 8;
            } else if ("iw".equals(language)) {
                checked(this.mChbIw);
                this.languageIndex = 9;
            } else if ("ja".equals(language)) {
                checked(this.mChbJa);
                this.languageIndex = 10;
            } else if ("ko".equals(language)) {
                checked(this.mChbKo);
                this.languageIndex = 11;
            } else if ("nl".equals(language)) {
                checked(this.mChbNl);
                this.languageIndex = 12;
            } else if ("pl".equals(language)) {
                checked(this.mChbPl);
                this.languageIndex = 13;
            } else if ("pt".equals(language)) {
                checked(this.mChbPt);
                this.languageIndex = 14;
            } else if ("ru".equals(language)) {
                checked(this.mChbRu);
                this.languageIndex = 15;
            } else if ("th".equals(language)) {
                checked(this.mChbTh);
                this.languageIndex = 16;
            } else if ("tr".equals(language)) {
                checked(this.mChbTr);
                this.languageIndex = 17;
            } else if ("vi".equals(language)) {
                checked(this.mChbVi);
                this.languageIndex = 18;
            } else if ("hr".equals(language)) {
                checked(this.mChbHr);
                this.languageIndex = 19;
            }
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewLanguage);
            this.recycleViewLanguage = recyclerView;
            if (recyclerView != null) {
                this.adapter = new MainMenuAdapter(this.mainActivity, this.languageList, 1);
                this.recycleViewLanguage.setLayoutManager(new LinearLayoutManager(getContext()));
                this.recycleViewLanguage.setAdapter(this.adapter);
                this.adapter.setPosition(this.languageIndex);
                this.adapter.setOnItemClickListener(new MainMenuAdapter.OnItemClickListener() {
                    public final void onItemClick(int i) {
                        FragmentLanguage.this.lambda$bindViewListener$1$FragmentLanguage(i);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$bindViewListener$0$FragmentLanguage(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        Log.d(TAG, "onClick btnReturn main = " + mainActivity);
        if (mainActivity != null) {
            mainActivity.hideID8Content();
        }
    }

    public /* synthetic */ void lambda$bindViewListener$1$FragmentLanguage(int i) {
        this.adapter.setPosition(this.languageIndex);
        switchLanguageByIndex(i);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onClick(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (this.focusViews == null || this.focusViews.size() == 0) {
            addViewIds();
        }
        for (int i = 0; i < this.focusViews.size(); i++) {
            if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                this.m_CurrFocus = i;
            }
        }
        this.baseApp.setFocusPage(1);
        mainActivity.m_iCurrFocus = this.m_CurrFocus;
        mainActivity.lastXFocus = 1;
        BaseApp.getFocusUtil().locateFragment(this, TAG);
        BaseApp.getFocusUtil().refreshSecondViews(mainActivity.m_iCurrFocus, false);
        BaseApp.getFocusUtil().refreshFirstViews(mainActivity, -1, false);
        switch (view.getId()) {
            case R.id.btnLangAR /*2131230981*/:
                checked(this.mChbAr);
                LocalePicker.updateLocale(new Locale("ar"));
                break;
            case R.id.btnLangDE /*2131230982*/:
                checked(this.mChbDe);
                LocalePicker.updateLocale(Locale.GERMAN);
                break;
            case R.id.btnLangEL /*2131230983*/:
                checked(this.mChbEl);
                LocalePicker.updateLocale(new Locale("el"));
                break;
            case R.id.btnLangEN /*2131230984*/:
                checked(this.mChbEn);
                LocalePicker.updateLocale(Locale.US);
                break;
            case R.id.btnLangES /*2131230985*/:
                checked(this.mChbEs);
                LocalePicker.updateLocale(new Locale("es", "ES"));
                break;
            case R.id.btnLangFR /*2131230986*/:
                checked(this.mChbFr);
                LocalePicker.updateLocale(Locale.FRENCH);
                break;
            case R.id.btnLangHR /*2131230987*/:
                checked(this.mChbHr);
                LocalePicker.updateLocale(new Locale("hr"));
                break;
            case R.id.btnLangIT /*2131230988*/:
                checked(this.mChbIt);
                LocalePicker.updateLocale(Locale.ITALY);
                break;
            case R.id.btnLangIW /*2131230989*/:
                checked(this.mChbIw);
                LocalePicker.updateLocale(new Locale("iw"));
                break;
            case R.id.btnLangJA /*2131230990*/:
                checked(this.mChbJa);
                LocalePicker.updateLocale(Locale.JAPANESE);
                break;
            case R.id.btnLangKO /*2131230991*/:
                checked(this.mChbKo);
                LocalePicker.updateLocale(Locale.KOREA);
                break;
            case R.id.btnLangNL /*2131230992*/:
                checked(this.mChbNl);
                LocalePicker.updateLocale(new Locale("nl"));
                break;
            case R.id.btnLangPL /*2131230993*/:
                checked(this.mChbPl);
                LocalePicker.updateLocale(new Locale("pl"));
                break;
            case R.id.btnLangPT /*2131230994*/:
                checked(this.mChbPt);
                LocalePicker.updateLocale(new Locale("pt", "BR"));
                break;
            case R.id.btnLangRU /*2131230995*/:
                checked(this.mChbRu);
                LocalePicker.updateLocale(new Locale("ru"));
                break;
            case R.id.btnLangSCN /*2131230996*/:
                checked(this.mChbSChinese);
                LocalePicker.updateLocale(Locale.SIMPLIFIED_CHINESE);
                break;
            case R.id.btnLangTCN /*2131230997*/:
                checked(this.mChbTChinese);
                LocalePicker.updateLocale(Locale.TRADITIONAL_CHINESE);
                break;
            case R.id.btnLangTH /*2131230998*/:
                checked(this.mChbTh);
                LocalePicker.updateLocale(new Locale("th"));
                break;
            case R.id.btnLangTR /*2131230999*/:
                checked(this.mChbTr);
                LocalePicker.updateLocale(new Locale("tr"));
                break;
            case R.id.btnLangVI /*2131231000*/:
                checked(this.mChbVi);
                LocalePicker.updateLocale(new Locale("vi"));
                break;
        }
        mainActivity.finish();
        EventUtils.startActivityIfNotRuning(getContext(), "com.szchoiceway.settings", "com.szchoiceway.settings.MainActivity");
    }

    public void checked(CheckBox checkBox) {
        for (CheckBox next : this.checkBoxList) {
            if (next != null) {
                next.setChecked(false);
            }
        }
        if (checkBox != null) {
            checkBox.setChecked(true);
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        this.focusViews.add(Integer.valueOf(R.id.btnLangSCN));
        this.focusViews.add(Integer.valueOf(R.id.btnLangTCN));
        this.focusViews.add(Integer.valueOf(R.id.btnLangEN));
        this.focusViews.add(Integer.valueOf(R.id.btnLangAR));
        this.focusViews.add(Integer.valueOf(R.id.btnLangDE));
        this.focusViews.add(Integer.valueOf(R.id.btnLangEL));
        this.focusViews.add(Integer.valueOf(R.id.btnLangES));
        this.focusViews.add(Integer.valueOf(R.id.btnLangFR));
        this.focusViews.add(Integer.valueOf(R.id.btnLangIT));
        this.focusViews.add(Integer.valueOf(R.id.btnLangIW));
        this.focusViews.add(Integer.valueOf(R.id.btnLangJA));
        this.focusViews.add(Integer.valueOf(R.id.btnLangKO));
        this.focusViews.add(Integer.valueOf(R.id.btnLangNL));
        this.focusViews.add(Integer.valueOf(R.id.btnLangPL));
        this.focusViews.add(Integer.valueOf(R.id.btnLangPT));
        this.focusViews.add(Integer.valueOf(R.id.btnLangRU));
        this.focusViews.add(Integer.valueOf(R.id.btnLangTH));
        this.focusViews.add(Integer.valueOf(R.id.btnLangTR));
        this.focusViews.add(Integer.valueOf(R.id.btnLangVI));
        this.focusViews.add(Integer.valueOf(R.id.btnLangHR));
        BaseApp.getFocusUtil().addViewIds(this.focusViews);
    }

    private void initData() {
        this.languageList = new ArrayList();
        String[] strArr = {"中文简体", "中文繁體", "English", "العربية", "Deutsch", "Ελληνικά", "Espanol", "Français", "Italiano", "עִברִית", "日本語", "한국인", "Nederlands", "Polski", "Português", "русский", "ไทย", "Türkçe", "Tiếng Việt", "Hrvatski"};
        for (int i = 0; i < 20; i++) {
            String str = strArr[i];
            MainMenuBean mainMenuBean = new MainMenuBean();
            mainMenuBean.setTvTitle(str);
            this.languageList.add(mainMenuBean);
        }
    }

    private void switchLanguageByIndex(int i) {
        switch (i) {
            case 0:
                LocalePicker.updateLocale(Locale.SIMPLIFIED_CHINESE);
                return;
            case 1:
                LocalePicker.updateLocale(Locale.TRADITIONAL_CHINESE);
                return;
            case 2:
                LocalePicker.updateLocale(Locale.US);
                return;
            case 3:
                LocalePicker.updateLocale(new Locale("ar"));
                return;
            case 4:
                LocalePicker.updateLocale(Locale.GERMAN);
                return;
            case 5:
                LocalePicker.updateLocale(new Locale("el"));
                return;
            case 6:
                LocalePicker.updateLocale(new Locale("es", "ES"));
                return;
            case 7:
                LocalePicker.updateLocale(Locale.FRENCH);
                return;
            case 8:
                LocalePicker.updateLocale(Locale.ITALY);
                return;
            case 9:
                LocalePicker.updateLocale(new Locale("iw"));
                return;
            case 10:
                LocalePicker.updateLocale(Locale.JAPANESE);
                return;
            case 11:
                LocalePicker.updateLocale(Locale.KOREA);
                return;
            case 12:
                LocalePicker.updateLocale(new Locale("nl"));
                return;
            case 13:
                LocalePicker.updateLocale(new Locale("pl"));
                return;
            case 14:
                LocalePicker.updateLocale(new Locale("pt", "BR"));
                return;
            case 15:
                LocalePicker.updateLocale(new Locale("ru"));
                return;
            case 16:
                LocalePicker.updateLocale(new Locale("th"));
                return;
            case 17:
                LocalePicker.updateLocale(new Locale("tr"));
                return;
            case 18:
                LocalePicker.updateLocale(new Locale("vi"));
                return;
            case 19:
                LocalePicker.updateLocale(new Locale("hr"));
                return;
            default:
                return;
        }
    }
}
