package com.szchoiceway.settings.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.List;

public class FragmentSystemSet_VideoPlayer extends FragmentBase {
    private static final String TAG = "Set_VideoPlayer";
    /* access modifiers changed from: private */
    public AppListAdapter adapter;
    /* access modifiers changed from: private */
    public List<AppInfo> appList;
    AppUtil appUtil;
    /* access modifiers changed from: private */
    public MainActivity mMain;
    private View mMainView;
    /* access modifiers changed from: private */
    public SysProviderOpt mProvider;
    private int maxApkCount = 4;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    private View myScrollbarBg;
    private RecyclerView recyclerView;

    public String getFragmentTag() {
        return TAG;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mMain = (MainActivity) getActivity();
        if (this.m_iUIIndex == 4) {
            this.maxApkCount = 5;
        }
        this.mProvider = SysProviderOpt.getInstance(context);
        AppUtil appUtil2 = new AppUtil(context, 2);
        this.appUtil = appUtil2;
        this.appList = appUtil2.getAppList();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_video, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_video, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_video, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                this.maxApkCount = 5;
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_music_video, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_media_select, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_video, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_video_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_music, (ViewGroup) null);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_video, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set_video, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_video, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_video, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_video, (ViewGroup) null);
        } else if (this.m_iUIIndex == 5) {
            view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_media_select, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_video, (ViewGroup) null);
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
        this.adapter = new AppListAdapter(getContext(), this.appList, 2);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.appList);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new AppListAdapter.OnItemClickListener() {
            public void onItemClick(int i) {
                FragmentSystemSet_VideoPlayer.this.baseApp.setFocusPage(2);
                int unused = FragmentSystemSet_VideoPlayer.this.m_CurrFocus = i;
                FragmentSystemSet_VideoPlayer.this.mMain.m_iCurrFocus = FragmentSystemSet_VideoPlayer.this.m_CurrFocus;
                if (FragmentSystemSet_VideoPlayer.this.mProductIndex > 0) {
                    FragmentSystemSet_VideoPlayer.this.mMain.lastYFocus = 6;
                } else {
                    FragmentSystemSet_VideoPlayer.this.mMain.lastYFocus = 7;
                }
                BaseApp.getFocusUtil().refreshFirstViews(FragmentSystemSet_VideoPlayer.this.mMain, -1, false);
                BaseApp.getFocusUtil().refreshSecondViews(-1, false);
                BaseApp.getFocusUtil().locateFragment(FragmentSystemSet_VideoPlayer.this, FragmentSystemSet_VideoPlayer.TAG);
                BaseApp.getFocusUtil().refreshThirdViews(FragmentSystemSet_VideoPlayer.this.mMain.m_iCurrFocus, false);
                String packageName = ((AppInfo) FragmentSystemSet_VideoPlayer.this.appList.get(i)).getPackageName();
                FragmentSystemSet_VideoPlayer.this.mProvider.updateRecord("Video_PackageName", ((AppInfo) FragmentSystemSet_VideoPlayer.this.appList.get(i)).getPackageName());
                String className = ((AppInfo) FragmentSystemSet_VideoPlayer.this.appList.get(i)).getClassName();
                Log.d(FragmentSystemSet_VideoPlayer.TAG, "packageName = " + packageName + "className = " + className);
                FragmentSystemSet_VideoPlayer.this.mProvider.updateRecord("Video_ActivityName", className);
            }
        });
        MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
        this.myScrollbar = myScrollbar2;
        if (myScrollbar2 != null) {
            if (this.appList.size() <= 4) {
                this.myScrollbar.setVisibility(8);
            } else {
                this.myScrollbar.setVisibility(0);
            }
        }
        View findViewById = view.findViewById(R.id.myScrollbarBg);
        this.myScrollbarBg = findViewById;
        if (findViewById != null) {
            if (this.appList.size() <= this.maxApkCount) {
                this.myScrollbarBg.setVisibility(8);
            } else {
                this.myScrollbarBg.setVisibility(0);
            }
        }
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    FragmentSystemSet_VideoPlayer.this.adapter.notifyDataSetChanged();
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange() - recyclerView.getHeight();
                if (FragmentSystemSet_VideoPlayer.this.myScrollbar != null) {
                    float f = (((float) computeVerticalScrollOffset) * 1.0f) / ((float) computeVerticalScrollRange);
                    if (FragmentSystemSet_VideoPlayer.this.myScrollbar != null) {
                        FragmentSystemSet_VideoPlayer.this.myScrollbar.setCurrentPercent(f);
                    }
                }
            }
        });
    }

    public AppListAdapter getAdapter() {
        return this.adapter;
    }
}
