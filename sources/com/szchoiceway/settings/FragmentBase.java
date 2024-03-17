package com.szchoiceway.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.settings.util.FocusUtil;
import com.szchoiceway.zxwlib.utils.MultipleUtils;
import java.util.ArrayList;
import java.util.List;

public class FragmentBase extends Fragment {
    private static final String TAG = "FragmentBase";
    public static View mContentView;
    protected BaseApp baseApp;
    protected FocusUtil focusUtil = BaseApp.getFocusUtil();
    protected List<Integer> focusViews = new ArrayList();
    protected boolean isSmallResolution = BaseApp.isSmallResolution;
    protected int mProductIndex = BaseApp.mProductIndex;
    protected SysProviderOpt mProvider;
    protected String mResolution = BaseApp.mResolution;
    protected int m_CurrFocus = -1;
    protected int m_iModeSet = BaseApp.m_iModeSet;
    protected int m_iUIIndex = BaseApp.m_iUIIndex;
    protected int m_iUITypeVer = BaseApp.m_iUITypeVer;
    MainActivity mainActivity = null;

    public void NotifyServiceConntected(IEventService iEventService) {
    }

    public void addViewIds() {
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
    }

    public String getFragmentTag() {
        return "";
    }

    public void hideContentView() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void showContentView() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mProvider = SysProviderOpt.getInstance(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MultipleUtils.setCustomDensity(getMainActivity(), getMainActivity().getApplication());
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void setMainActivity(MainActivity mainActivity2) {
        this.mainActivity = mainActivity2;
    }

    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }

    public void setFragmentContentView(View view) {
        mContentView = view;
    }

    public static View getContentView() {
        return mContentView;
    }

    public void showView() {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.setVisibility(0);
        }
    }

    public void hideView() {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void kesaiwei_sendBroadcast2(int i) {
        Intent intent = new Intent(EventUtils.ZXW_SENDBROADCAST8902MOD);
        intent.putExtra(EventUtils.ZXW_SENDBROADCAST8902MOD_EXTRA, i);
        MainActivity mainActivity2 = (MainActivity) getActivity();
        if (mainActivity2 == null) {
            mainActivity2 = getMainActivity();
        }
        mainActivity2.sendBroadcast(intent);
    }

    /* access modifiers changed from: protected */
    public void kesaiwei_sendBroadcast3(int i, int i2, int i3) {
        Intent intent = new Intent(EventUtils.ZXW_SENDBROADCAST8902MOD);
        intent.putExtra(EventUtils.ZXW_SENDBROADCAST8902MOD_EXTRA, i);
        intent.putExtra(EventUtils.ZXW_SENDBROADCAST8902MOD_DATA0, i2);
        intent.putExtra(EventUtils.ZXW_SENDBROADCAST8902MOD_DATA1, i3);
        MainActivity mainActivity2 = (MainActivity) getActivity();
        if (mainActivity2 == null) {
            mainActivity2 = getMainActivity();
        }
        mainActivity2.sendBroadcast(intent);
    }

    public boolean isDefaultUI() {
        return this.m_iUIIndex == 1 || this.m_iModeSet >= 100;
    }
}
