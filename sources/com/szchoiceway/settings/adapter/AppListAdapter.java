package com.szchoiceway.settings.adapter;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.settings.bean.AppInfo;
import com.szchoiceway.zxwlib.bean.Customer;
import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final String TAG = "AppListAdapter";
    private List<AppInfo> appInfoList;
    private String dvrPackageName;
    private int focusIndex = -1;
    private boolean isSmallResolution = false;
    /* access modifiers changed from: private */
    public Context mContext;
    private OnItemClickListener mListener;
    private SysProviderOpt mProvider;
    private String mResolution = "1920x720";
    /* access modifiers changed from: private */
    public int mType;
    /* access modifiers changed from: private */
    public int m_iModeSet = 16;
    /* access modifiers changed from: private */
    public int m_iUIIndex = 0;
    private String musicPackageName;
    private String navPackageName;
    private String videoPackageName;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public AppListAdapter(Context context, List<AppInfo> list, int i) {
        this.mContext = context;
        this.isSmallResolution = Customer.isSmallResolution(context);
        this.mResolution = SysProviderOpt.getInstance(this.mContext).getRecordValue("KSW_UI_RESOLUTION", "1920x720");
        this.mProvider = SysProviderOpt.getInstance(context);
        this.m_iModeSet = BaseApp.m_iModeSet;
        this.m_iUIIndex = BaseApp.m_iUIIndex;
        this.appInfoList = list;
        this.mType = i;
    }

    public void setList(List<AppInfo> list) {
        this.appInfoList = list;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (this.isSmallResolution) {
            int i2 = this.m_iUIIndex;
            if (i2 == 2) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kesaiwei_1920x720_evo_id8_set_app_item, viewGroup, false);
            } else if (i2 == 6) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.small_kesaiwei_1920x720_benz_set_app_item, viewGroup, false);
            } else if (this.m_iModeSet == 19) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pemp_id7_set_app_item, viewGroup, false);
            } else if (i2 == 4) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.small_audi_set_app_item, viewGroup, false);
            } else if (i2 == 5) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.landrover_set_app_item, viewGroup, false);
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kesaiwei_1920x720_evo_id7_set_app_item, viewGroup, false);
            }
        } else if (!"1560x700".equals(this.mResolution)) {
            int i3 = this.m_iUIIndex;
            if (i3 == 2) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kesaiwei_1920x720_evo_id8_set_app_item, viewGroup, false);
            } else if (i3 == 6) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kesaiwei_1920x720_benz_set_app_item, viewGroup, false);
            } else if (i3 == 7) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kesaiwei_1920x720_lexus_set_app_item, viewGroup, false);
            } else if (this.m_iModeSet == 19) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pemp_id7_set_app_item, viewGroup, false);
            } else if (i3 == 4) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.audi_set_app_item, viewGroup, false);
            } else if (i3 == 5) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.landrover_set_app_item, viewGroup, false);
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kesaiwei_1920x720_evo_id7_set_app_item, viewGroup, false);
            }
        } else if (this.m_iUIIndex == 4) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.audi_set_app_item_1560x700, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kesaiwei_1920x720_evo_id7_set_app_item, viewGroup, false);
        }
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        this.dvrPackageName = this.mProvider.getRecordValue(SysProviderOpt.KSW_DVR_APK_PACKAGENAME, "");
        this.musicPackageName = this.mProvider.getRecordValue(SysProviderOpt.MUSIC_PACKAGENAME, EventUtils.MUSIC_MODE_PACKAGE_NAME);
        this.videoPackageName = this.mProvider.getRecordValue("Video_PackageName", "com.szchoiceway.videoplayer");
        this.navPackageName = this.mProvider.getRecordValue("NAV_PACKAGENAME", "com.szchoiceway.navigation");
        String packageName = this.appInfoList.get(i).getPackageName();
        int i2 = this.mType;
        if (i2 == 0) {
            myViewHolder.chkApp.setChecked(this.dvrPackageName.equals(packageName));
        } else if (i2 == 1) {
            myViewHolder.chkApp.setChecked(this.musicPackageName.equals(packageName));
        } else if (i2 == 2) {
            myViewHolder.chkApp.setChecked(this.videoPackageName.equals(packageName));
        } else if (i2 == 3 && myViewHolder.chkApp != null) {
            myViewHolder.chkApp.setChecked(this.navPackageName.equals(packageName));
        }
        int i3 = this.m_iModeSet;
        if ((i3 == 18 || i3 == 22 || i3 == 21) && i == this.appInfoList.size() - 1) {
            myViewHolder.line.setVisibility(8);
        }
        String label = this.appInfoList.get(i).getLabel();
        if (packageName.equals(EventUtils.MUSIC_MODE_PACKAGE_NAME)) {
            label = this.mContext.getString(R.string.lb_local_music);
        } else if (packageName.equals("com.szchoiceway.videoplayer")) {
            label = this.mContext.getString(R.string.lb_local_video);
        }
        myViewHolder.appName.setText(label);
        if (myViewHolder.appIcon != null) {
            myViewHolder.appIcon.setBackground(this.appInfoList.get(i).getIcon());
        }
        myViewHolder.btnApp.setOnClickListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                AppListAdapter.this.lambda$onBindViewHolder$0$AppListAdapter(this.f$1, view);
            }
        });
        if (myViewHolder.btnApp == null) {
            return;
        }
        if (i == this.focusIndex) {
            myViewHolder.btnApp.setSelected(true);
        } else {
            myViewHolder.btnApp.setSelected(false);
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$AppListAdapter(int i, View view) {
        this.mListener.onItemClick(i);
        Log.d(TAG, "onClick");
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.appInfoList.size();
    }

    public void setFocusIndex(int i) {
        this.focusIndex = i;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public ImageView appIcon;
        /* access modifiers changed from: private */
        public TextView appName;
        /* access modifiers changed from: private */
        public ImageButton btnApp;
        /* access modifiers changed from: private */
        public CheckBox chkApp;
        /* access modifiers changed from: private */
        public View line;

        public MyViewHolder(View view) {
            super(view);
            this.appName = (TextView) view.findViewById(R.id.appLabel);
            this.chkApp = (CheckBox) view.findViewById(R.id.chkApp);
            this.appIcon = (ImageView) view.findViewById(R.id.appIcon);
            this.line = view.findViewById(R.id.line);
            this.btnApp = (ImageButton) view.findViewById(R.id.btnApp);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int unused = AppListAdapter.this.m_iModeSet = BaseApp.m_iModeSet;
            if (AppListAdapter.this.m_iModeSet == 19 || AppListAdapter.this.m_iUIIndex == 1 || AppListAdapter.this.m_iModeSet >= 100) {
                if (AppListAdapter.this.mType == 0) {
                    layoutParams.height = (int) AppListAdapter.this.mContext.getResources().getDimension(R.dimen.app_dvr_height);
                } else if (AppListAdapter.this.mType == 1 || AppListAdapter.this.mType == 2) {
                    layoutParams.height = (int) AppListAdapter.this.mContext.getResources().getDimension(R.dimen.app_music_height);
                } else {
                    layoutParams.height = (int) AppListAdapter.this.mContext.getResources().getDimension(R.dimen.app_nav_height);
                }
                view.setLayoutParams(layoutParams);
                if (AppListAdapter.this.mType == 3) {
                    this.chkApp.setVisibility(8);
                    this.line.setVisibility(0);
                    return;
                }
                this.chkApp.setVisibility(0);
                this.line.setVisibility(8);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.mListener;
    }

    private int getAttrId(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }
}
