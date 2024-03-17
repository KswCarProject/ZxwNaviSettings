package com.szchoiceway.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.settings.adapter.AppListAdapter;
import com.szchoiceway.settings.bean.AppInfo;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.util.AppUtil;
import java.util.ArrayList;
import java.util.List;

public class FragmentNavSetNew extends FragmentBase implements View.OnClickListener {
    public static final String TAG = "FragmentNavSetNew";
    private ImageButton BtnResetNo;
    private ImageButton BtnResetYes;
    private ImageButton BtnRunNav;
    /* access modifiers changed from: private */
    public AppListAdapter adapter;
    private Drawable appIcon;
    private List<AppInfo> appInfoList;
    private String appName;
    private AppUtil appUtil;
    private String className;
    private ImageView imageAppIcon;
    public View msgView;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    private RecyclerView recyclerView;
    private int selectionPosition = 0;
    private TextView tvAppName;

    public String getFragmentTag() {
        return TAG;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mProvider = SysProviderOpt.getInstance(getContext());
        AppUtil appUtil2 = new AppUtil(getContext(), 3);
        this.appUtil = appUtil2;
        this.appInfoList = appUtil2.getAppList();
        this.adapter = new AppListAdapter(getContext(), this.appInfoList, 3);
        this.appName = this.mProvider.getRecordValue("NAV_PACKAGENAME", "com.szchoiceway.navigation");
        this.className = this.mProvider.getRecordValue("NAV_ACTIVITYNAME", "com.szchoiceway.navigation.MainActivity");
        for (AppInfo next : this.appInfoList) {
            if (this.appName.equals(next.getPackageName())) {
                this.appIcon = next.getIcon();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Log.d(TAG, "onCreateView");
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_nav_set_new, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_nav_set, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_nav_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_nav_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_nav_set, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_nav_set_new, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_nav_set_1560x700, viewGroup, false);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_nav_set_new, viewGroup, false);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_nav_set_new, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_nav_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_nav_set, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_nav_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_nav_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 5) {
            view = layoutInflater.inflate(R.layout.landrover_fragment_nav_set, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_nav_set_new, (ViewGroup) null);
        }
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
        if (this.appUtil != null && getContext() != null) {
            this.appUtil.initAppList(getContext());
            List<AppInfo> appList = this.appUtil.getAppList();
            this.appInfoList = appList;
            this.adapter.setList(appList);
            this.adapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        BaseApp baseApp = (BaseApp) getActivity().getApplication();
        MainActivity mainActivity = (MainActivity) getActivity();
        this.tvAppName = (TextView) view.findViewById(R.id.TvApkInfor);
        this.imageAppIcon = (ImageView) view.findViewById(R.id.VwApkIcon);
        refreshCurrentNavi();
        View findViewById = view.findViewById(R.id.LytMsgYesNo);
        this.msgView = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.BtnResetYes);
        this.BtnResetYes = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.BtnResetNo);
        this.BtnResetNo = imageButton2;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.BtnRunNav);
        this.BtnRunNav = imageButton3;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(new View.OnClickListener(baseApp, mainActivity) {
                public final /* synthetic */ BaseApp f$1;
                public final /* synthetic */ MainActivity f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    FragmentNavSetNew.this.lambda$bindViewListener$0$FragmentNavSetNew(this.f$1, this.f$2, view);
                }
            });
        }
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.appList);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new AppListAdapter.OnItemClickListener(baseApp, mainActivity) {
            public final /* synthetic */ BaseApp f$1;
            public final /* synthetic */ MainActivity f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onItemClick(int i) {
                FragmentNavSetNew.this.lambda$bindViewListener$1$FragmentNavSetNew(this.f$1, this.f$2, i);
            }
        });
        MyScrollbar myScrollbar2 = (MyScrollbar) view.findViewById(R.id.myScrollbar);
        this.myScrollbar = myScrollbar2;
        if (myScrollbar2 != null) {
            if (this.m_iUIIndex == 4) {
                if (this.appInfoList.size() <= 5) {
                    this.myScrollbar.setVisibility(8);
                } else {
                    this.myScrollbar.setVisibility(0);
                }
            } else if (this.appInfoList.size() <= 6) {
                this.myScrollbar.setVisibility(8);
            } else {
                this.myScrollbar.setVisibility(0);
            }
        }
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    FragmentNavSetNew.this.adapter.notifyDataSetChanged();
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange() - recyclerView.getHeight();
                if (FragmentNavSetNew.this.myScrollbar != null) {
                    float f = (((float) computeVerticalScrollOffset) * 1.0f) / ((float) computeVerticalScrollRange);
                    if (FragmentNavSetNew.this.myScrollbar != null) {
                        FragmentNavSetNew.this.myScrollbar.setCurrentPercent(f);
                    }
                }
            }
        });
        View findViewById2 = view.findViewById(R.id.btnReturn);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FragmentNavSetNew.this.lambda$bindViewListener$2$FragmentNavSetNew(view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$bindViewListener$0$FragmentNavSetNew(BaseApp baseApp, MainActivity mainActivity, View view) {
        baseApp.setFocusPage(1);
        mainActivity.m_iCurrFocus = 0;
        mainActivity.lastXFocus = 0;
        BaseApp.getFocusUtil().locateFragment(this, TAG);
        BaseApp.getFocusUtil().refreshSecondViews(mainActivity.m_iCurrFocus, true);
        BaseApp.getFocusUtil().refreshFirstViews(mainActivity, -1, false);
        if (!this.appName.equals("com.szchoiceway.navigation.MainActivity")) {
            EventUtils.startActivityIfNotRuning(getContext(), this.appName, this.className);
        }
    }

    public /* synthetic */ void lambda$bindViewListener$1$FragmentNavSetNew(BaseApp baseApp, MainActivity mainActivity, int i) {
        if (this.m_iModeSet == 19 || isDefaultUI()) {
            baseApp.setFocusPage(1);
            mainActivity.m_iCurrFocus = i + 1;
            mainActivity.lastXFocus = 0;
            BaseApp.getFocusUtil().locateFragment(this, TAG);
            BaseApp.getFocusUtil().refreshFirstViews(mainActivity, -1, false);
            if (BaseApp.getFocusUtil().getViewIds() != null && BaseApp.getFocusUtil().getViewIds().size() == 0) {
                addViewIds();
            }
            BaseApp.getFocusUtil().refreshSecondViews(mainActivity.m_iCurrFocus, false);
            this.selectionPosition = i;
            this.msgView.setVisibility(0);
            this.BtnResetYes.setSelected(true);
            this.BtnResetNo.setSelected(false);
        } else if (this.m_iUIIndex == 7) {
            mainActivity.lastXFocus = 1;
            BaseApp.getFocusUtil().refreshFirstViews(mainActivity, -1, false);
            baseApp.setFocusPage(1);
            mainActivity.m_iCurrFocus = i;
            BaseApp.getFocusUtil().locateFragment(this, TAG);
            BaseApp.getFocusUtil().refreshSecondViews(mainActivity.m_iCurrFocus, false);
            this.selectionPosition = i;
            this.appName = this.appInfoList.get(i).getPackageName();
            this.className = this.appInfoList.get(this.selectionPosition).getClassName();
            this.mProvider.updateRecord("NAV_PACKAGENAME", this.appName);
            this.mProvider.updateRecord("NAV_ACTIVITYNAME", this.className);
        } else {
            mainActivity.m_iCurrFocus = i;
            BaseApp.getFocusUtil().refreshSecondViews(mainActivity.m_iCurrFocus, false);
            this.selectionPosition = i;
            this.appName = this.appInfoList.get(i).getPackageName();
            this.className = this.appInfoList.get(this.selectionPosition).getClassName();
            this.mProvider.updateRecord("NAV_PACKAGENAME", this.appName);
            this.mProvider.updateRecord("NAV_ACTIVITYNAME", this.className);
        }
    }

    public /* synthetic */ void lambda$bindViewListener$2$FragmentNavSetNew(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        Log.d(TAG, "onClick btnReturn main = " + mainActivity);
        if (mainActivity != null) {
            mainActivity.hideID8Content();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.BtnResetNo) {
            this.msgView.setVisibility(8);
        } else if (id == R.id.BtnResetYes) {
            this.appName = this.appInfoList.get(this.selectionPosition).getPackageName();
            this.className = this.appInfoList.get(this.selectionPosition).getClassName();
            this.mProvider.updateRecord("NAV_PACKAGENAME", this.appName);
            this.mProvider.updateRecord("NAV_ACTIVITYNAME", this.className);
            Log.d(TAG, "appName = " + this.appName + ", className = " + this.className);
            this.appIcon = this.appInfoList.get(this.selectionPosition).getIcon();
            refreshCurrentNavi();
            this.msgView.setVisibility(8);
        }
    }

    private void refreshCurrentNavi() {
        if (!"com.szchoiceway.navigation".equals(this.appName) && !"".equals(this.appName)) {
            TextView textView = this.tvAppName;
            if (textView != null) {
                textView.setText(this.appName);
            }
            ImageView imageView = this.imageAppIcon;
            if (imageView != null) {
                imageView.setBackground(this.appIcon);
            }
        }
    }

    public void addViewIds() {
        super.addViewIds();
        if (this.m_iModeSet == 19 || isDefaultUI()) {
            this.focusViews = new ArrayList();
            this.focusViews.add(Integer.valueOf(R.id.BtnRunNav));
            this.focusViews.add(Integer.valueOf(R.id.LytMsgYesNo));
            this.focusViews.add(Integer.valueOf(R.id.BtnResetYes));
            this.focusViews.add(Integer.valueOf(R.id.BtnResetNo));
            this.focusUtil.addViewIds(this.focusViews);
        }
    }

    public AppListAdapter getAdapter() {
        return this.adapter;
    }
}
