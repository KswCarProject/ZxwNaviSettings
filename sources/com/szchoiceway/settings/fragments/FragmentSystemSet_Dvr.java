package com.szchoiceway.settings.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.settings.adapter.AppListAdapter;
import com.szchoiceway.settings.bean.AppInfo;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.util.AppUtil;
import java.util.ArrayList;
import java.util.List;

public class FragmentSystemSet_Dvr extends FragmentBase implements View.OnClickListener {
    private static final String TAG = "SystemSet_Dvr";
    /* access modifiers changed from: private */
    public AppListAdapter adapter;
    /* access modifiers changed from: private */
    public List<AppInfo> appList;
    AppUtil appUtil;
    int i_kesaiwei_DVR = 0;
    CheckBox kesaiwei_DVR_cvbs = null;
    CheckBox kesaiwei_DVR_off = null;
    CheckBox kesaiwei_DVR_usb = null;
    /* access modifiers changed from: private */
    public MainActivity mMain;
    private View mMainView;
    /* access modifiers changed from: private */
    public SysProviderOpt mProvider;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    private View myScrollbarBg;
    private RecyclerView recyclerView;
    View viewDvrApp = null;

    public String getFragmentTag() {
        return TAG;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mMain = (MainActivity) getActivity();
        SysProviderOpt instance = SysProviderOpt.getInstance(context);
        this.mProvider = instance;
        this.i_kesaiwei_DVR = instance.getRecordInteger(SysProviderOpt.KESAIWEI_RECORD_DVR, this.i_kesaiwei_DVR);
        AppUtil appUtil2 = new AppUtil(context, 0);
        this.appUtil = appUtil2;
        this.appList = appUtil2.getAppList();
        Log.d(TAG, "appList.size = " + this.appList.size());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_dvr, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_dvr, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_dvr, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_dvr, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_dvr, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_dvr, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_dvr_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_dvr, (ViewGroup) null);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_dvr, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set_dvr, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_dvr, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_dvr, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_dvr, (ViewGroup) null);
        } else if (this.m_iUIIndex != 5) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_dvr, (ViewGroup) null);
        } else if (this.m_iModeSet == 32) {
            view = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_dvr, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_dvr, (ViewGroup) null);
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
        this.kesaiwei_DVR_off = (CheckBox) view.findViewById(R.id.kesaiwei_dvr_OFF);
        this.kesaiwei_DVR_cvbs = (CheckBox) view.findViewById(R.id.kesaiwei_dvr_CVBS);
        this.kesaiwei_DVR_usb = (CheckBox) view.findViewById(R.id.kesaiwei_dvr_USB);
        this.viewDvrApp = view.findViewById(R.id.viewDvrApp);
        refreshChk();
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnDvrCVBS);
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btnDvrUSB);
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btnDvrOFF);
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this);
        }
        this.adapter = new AppListAdapter(getContext(), this.appList, 0);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.appList);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new AppListAdapter.OnItemClickListener() {
            public void onItemClick(int i) {
                FragmentSystemSet_Dvr.this.baseApp.setFocusPage(2);
                int unused = FragmentSystemSet_Dvr.this.m_CurrFocus = i + 3;
                FragmentSystemSet_Dvr.this.mMain.m_iCurrFocus = FragmentSystemSet_Dvr.this.m_CurrFocus;
                FragmentSystemSet_Dvr.this.mMain.lastYFocus = 4;
                if (FragmentSystemSet_Dvr.this.m_iModeSet == 19 || FragmentSystemSet_Dvr.this.isDefaultUI()) {
                    BaseApp.getFocusUtil().refreshFirstViews(FragmentSystemSet_Dvr.this.mMain, -1, false);
                }
                BaseApp.getFocusUtil().refreshSecondViews(-1, false);
                BaseApp.getFocusUtil().locateFragment(FragmentSystemSet_Dvr.this, FragmentSystemSet_Dvr.TAG);
                FragmentSystemSet_Dvr.this.addViewIds();
                BaseApp.getFocusUtil().refreshThirdViews(FragmentSystemSet_Dvr.this.mMain.m_iCurrFocus, false);
                String packageName = ((AppInfo) FragmentSystemSet_Dvr.this.appList.get(i)).getPackageName();
                FragmentSystemSet_Dvr.this.mProvider.updateRecord(SysProviderOpt.KSW_DVR_APK_PACKAGENAME, ((AppInfo) FragmentSystemSet_Dvr.this.appList.get(i)).getPackageName());
                Log.d(FragmentSystemSet_Dvr.TAG, "packageName = " + packageName + "className = " + ((AppInfo) FragmentSystemSet_Dvr.this.appList.get(i)).getClassName());
            }
        });
        MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
        this.myScrollbar = myScrollbar2;
        if (myScrollbar2 != null) {
            if (this.appList.size() <= 2) {
                this.myScrollbar.setVisibility(8);
            } else {
                this.myScrollbar.setVisibility(0);
            }
        }
        View findViewById = view.findViewById(R.id.myScrollbarBg);
        this.myScrollbarBg = findViewById;
        if (findViewById != null) {
            if (this.appList.size() <= 2) {
                this.myScrollbarBg.setVisibility(8);
            } else {
                this.myScrollbarBg.setVisibility(0);
            }
        }
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    FragmentSystemSet_Dvr.this.adapter.notifyDataSetChanged();
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange() - recyclerView.getHeight();
                if (FragmentSystemSet_Dvr.this.myScrollbar != null) {
                    FragmentSystemSet_Dvr.this.myScrollbar.setCurrentPercent((((float) computeVerticalScrollOffset) * 1.0f) / ((float) computeVerticalScrollRange));
                }
            }
        });
        initProductView(view);
    }

    private void refreshChk() {
        CheckBox checkBox = this.kesaiwei_DVR_off;
        boolean z = true;
        if (checkBox != null) {
            checkBox.setChecked(this.i_kesaiwei_DVR == 0);
        }
        CheckBox checkBox2 = this.kesaiwei_DVR_cvbs;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.i_kesaiwei_DVR == 1);
        }
        CheckBox checkBox3 = this.kesaiwei_DVR_usb;
        if (checkBox3 != null) {
            if (this.i_kesaiwei_DVR != 2) {
                z = false;
            }
            checkBox3.setChecked(z);
        }
        View view = this.viewDvrApp;
        if (view == null) {
            return;
        }
        if (this.i_kesaiwei_DVR == 2) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    private void initProductView(View view) {
        int i = 0;
        int recordInteger = SysProviderOpt.getInstance(getContext()).getRecordInteger(SysProviderOpt.KSW_DATA_PRODUCT_INDEX, 0);
        View findViewById = view.findViewById(R.id.view1);
        if (findViewById != null) {
            if (recordInteger > 0) {
                i = 8;
            }
            findViewById.setVisibility(i);
        }
    }

    public void onClick(View view) {
        if (BaseApp.getFocusUtil().inSeekbarKnobMode) {
            BaseApp.getFocusUtil().clearSeekbarFocus();
        }
        if (this.focusViews == null || this.focusViews.isEmpty()) {
            this.focusViews = new ArrayList();
            this.focusViews.add(Integer.valueOf(R.id.btnDvrOFF));
            this.focusViews.add(Integer.valueOf(R.id.btnDvrCVBS));
            this.focusViews.add(Integer.valueOf(R.id.btnDvrUSB));
        }
        for (int i = 0; i < this.focusViews.size(); i++) {
            if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                this.m_CurrFocus = i;
            }
        }
        this.baseApp.setFocusPage(2);
        this.mMain.m_iCurrFocus = this.m_CurrFocus;
        this.mMain.lastYFocus = 4;
        BaseApp.getFocusUtil().refreshFirstViews(this.mMain, -1, false);
        BaseApp.getFocusUtil().refreshSecondViews(-1, false);
        BaseApp.getFocusUtil().locateFragment(this, TAG);
        addViewIds();
        BaseApp.getFocusUtil().refreshThirdViews(this.mMain.m_iCurrFocus, false);
        switch (view.getId()) {
            case R.id.btnDvrCVBS:
                this.i_kesaiwei_DVR = 1;
                this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_RECORD_DVR, "" + this.i_kesaiwei_DVR);
                break;
            case R.id.btnDvrOFF:
                this.i_kesaiwei_DVR = 0;
                this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_RECORD_DVR, "" + this.i_kesaiwei_DVR);
                break;
            case R.id.btnDvrUSB:
                this.i_kesaiwei_DVR = 2;
                this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_RECORD_DVR, "" + this.i_kesaiwei_DVR);
                break;
        }
        refreshChk();
        kesaiwei_sendBroadcast2(9);
    }

    public void addViewIds() {
        super.addViewIds();
        int recordInteger = SysProviderOpt.getInstance(getContext()).getRecordInteger(SysProviderOpt.KSW_DATA_PRODUCT_INDEX, 0);
        this.focusViews = new ArrayList();
        this.focusViews.add(Integer.valueOf(R.id.btnDvrOFF));
        if (recordInteger <= 0) {
            this.focusViews.add(Integer.valueOf(R.id.btnDvrCVBS));
        }
        this.focusViews.add(Integer.valueOf(R.id.btnDvrUSB));
        BaseApp.getFocusUtil().addViewIds(this.focusViews);
    }

    public AppListAdapter getAdapter() {
        return this.adapter;
    }
}
