package com.szchoiceway.settings;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.szchoiceway.eventcenter.EventUtils;
import java.util.ArrayList;

public class FragmentStartCode extends FragmentBase implements View.OnClickListener {
    private static final String TAG = "FragmentStartCode";
    private SysProviderOpt mSysProviderOpt;
    protected Toast mTip = null;
    public TextView mTvInputUserFreq = null;
    public TextView mTvTitle;
    public String mUserInputFreq = "";
    private MainActivity main;
    private View mainView = null;

    public String getFragmentTag() {
        return TAG;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.main = (MainActivity) getActivity();
        this.mSysProviderOpt = SysProviderOpt.getInstance(context);
        Log.d(TAG, "m_iModeSet = " + this.m_iModeSet + ", m_iUITypeVer = " + this.m_iUITypeVer);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.d(TAG, "onCreateView");
        View view = null;
        if (this.m_iUITypeVer == 41) {
            if (isDefaultUI()) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_startcode, (ViewGroup) null);
            } else if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_startcode, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_startcode, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_startcode, (ViewGroup) null);
            } else if (this.m_iUIIndex == 7) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_code_layout, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_startcode, (ViewGroup) null);
            }
        }
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mainView = getView();
        return view;
    }

    public void onResume() {
        TextView textView;
        super.onResume();
        Log.d(TAG, "onResume");
        if (this.mainView == null) {
            this.mainView = getView();
        }
        TextView textView2 = this.mTvInputUserFreq;
        if (textView2 != null && textView2.getText().length() == 0 && (textView = this.mTvTitle) != null) {
            textView.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        this.mainActivity = (MainActivity) getActivity();
        this.baseApp = (BaseApp) this.mainActivity.getApplication();
        if (view != null) {
            int[] iArr = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9, R.id.BtnNumDel, R.id.BtnNumOK};
            for (int i = 0; i < 12; i++) {
                View findViewById = view.findViewById(iArr[i]);
                if (findViewById != null) {
                    findViewById.setOnClickListener(this);
                }
            }
            this.mTvInputUserFreq = (TextView) view.findViewById(R.id.TvInputUserFreq);
            this.mTvTitle = (TextView) view.findViewById(R.id.TvTitle);
            TextView textView = this.mTvInputUserFreq;
            if (textView != null) {
                textView.setText(this.mUserInputFreq);
            }
            TextView textView2 = this.mTvTitle;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
    }

    public void onClick(View view) {
        Log.d(TAG, "onClick");
        switch (view.getId()) {
            case R.id.BtnNum0 /*2131230727*/:
                inputUserFreq(0);
                return;
            case R.id.BtnNum1 /*2131230728*/:
                inputUserFreq(1);
                return;
            case R.id.BtnNum2 /*2131230731*/:
                inputUserFreq(2);
                return;
            case R.id.BtnNum3 /*2131230733*/:
                inputUserFreq(3);
                return;
            case R.id.BtnNum4 /*2131230735*/:
                inputUserFreq(4);
                return;
            case R.id.BtnNum5 /*2131230737*/:
                inputUserFreq(5);
                return;
            case R.id.BtnNum6 /*2131230738*/:
                inputUserFreq(6);
                return;
            case R.id.BtnNum7 /*2131230739*/:
                inputUserFreq(7);
                return;
            case R.id.BtnNum8 /*2131230741*/:
                inputUserFreq(8);
                return;
            case R.id.BtnNum9 /*2131230742*/:
                inputUserFreq(9);
                return;
            case R.id.BtnNumDel /*2131230743*/:
                inputUserFreq(11);
                return;
            case R.id.BtnNumOK /*2131230745*/:
                Log.i(TAG, "++++++BtnNumOK confirmUserFreq++++++");
                confirmUserFreq();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void inputUserFreq(int i) {
        Log.i(TAG, "inputUser num = " + i);
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
        TextView textView = this.mTvInputUserFreq;
        if (textView != null) {
            textView.setText(this.mUserInputFreq);
        }
        if (this.mTvTitle == null) {
            return;
        }
        if ("".equals(this.mUserInputFreq)) {
            this.mTvTitle.setVisibility(0);
        } else {
            this.mTvTitle.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void confirmUserFreq() {
        if (this.mUserInputFreq.length() != 0) {
            if (isValidUserFreq()) {
                Log.i(TAG, "Code ok");
                this.mUserInputFreq = "";
                if (getActivity() != null) {
                    EventUtils.startActivityIfNotRuning(getActivity().getApplicationContext(), "com.szchoiceway.fatset", "com.szchoiceway.fatset.FatSetMainActivity");
                }
            } else {
                Log.i(TAG, "Code error");
                this.mUserInputFreq = getString(R.string.lbl_code_error);
                TextView textView = this.mTvInputUserFreq;
                if (textView != null) {
                    textView.setTypeface(Typeface.defaultFromStyle(0));
                    this.mTvInputUserFreq.setTextSize(2, 28.0f);
                }
            }
            TextView textView2 = this.mTvInputUserFreq;
            if (textView2 != null) {
                textView2.setText(this.mUserInputFreq);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isValidUserFreq() {
        boolean z;
        String recordValue = this.mSysProviderOpt.getRecordValue(SysProviderOpt.KSW_FACTORY_SET_PASSWORD);
        if (recordValue.equals("")) {
            recordValue = "1314";
        }
        if (recordValue.equals(this.mUserInputFreq)) {
            z = true;
        } else {
            Log.i(TAG, "Code error");
            z = false;
        }
        Log.d(TAG, "CodeStr = " + recordValue);
        return z;
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        boolean isDefaultUI = isDefaultUI();
        Integer valueOf = Integer.valueOf(R.id.BtnNumDel);
        Integer valueOf2 = Integer.valueOf(R.id.BtnNum0);
        Integer valueOf3 = Integer.valueOf(R.id.BtnNumOK);
        Integer valueOf4 = Integer.valueOf(R.id.BtnNum9);
        Integer valueOf5 = Integer.valueOf(R.id.BtnNum8);
        Integer valueOf6 = Integer.valueOf(R.id.BtnNum7);
        Integer valueOf7 = Integer.valueOf(R.id.BtnNum6);
        Integer valueOf8 = Integer.valueOf(R.id.BtnNum5);
        Integer valueOf9 = Integer.valueOf(R.id.BtnNum4);
        Integer valueOf10 = Integer.valueOf(R.id.BtnNum3);
        Integer valueOf11 = Integer.valueOf(R.id.BtnNum2);
        Integer valueOf12 = Integer.valueOf(R.id.BtnNum1);
        if (isDefaultUI) {
            this.focusViews.add(valueOf12);
            this.focusViews.add(valueOf11);
            this.focusViews.add(valueOf10);
            this.focusViews.add(valueOf9);
            this.focusViews.add(valueOf8);
            this.focusViews.add(valueOf7);
            this.focusViews.add(valueOf6);
            this.focusViews.add(valueOf5);
            this.focusViews.add(valueOf4);
            this.focusViews.add(valueOf3);
            this.focusViews.add(valueOf2);
            this.focusViews.add(valueOf);
        } else if (BaseApp.m_iUIIndex == 2 || BaseApp.m_iUIIndex == 7) {
            this.focusViews.add(valueOf12);
            this.focusViews.add(valueOf11);
            this.focusViews.add(valueOf10);
            this.focusViews.add(valueOf);
            this.focusViews.add(valueOf9);
            this.focusViews.add(valueOf8);
            this.focusViews.add(valueOf7);
            this.focusViews.add(valueOf2);
            this.focusViews.add(valueOf6);
            this.focusViews.add(valueOf5);
            this.focusViews.add(valueOf4);
            this.focusViews.add(valueOf3);
        } else if (BaseApp.m_iModeSet == 19) {
            this.focusViews.add(valueOf12);
            this.focusViews.add(valueOf11);
            this.focusViews.add(valueOf10);
            this.focusViews.add(valueOf);
            this.focusViews.add(valueOf9);
            this.focusViews.add(valueOf8);
            this.focusViews.add(valueOf7);
            this.focusViews.add(valueOf2);
            this.focusViews.add(valueOf6);
            this.focusViews.add(valueOf5);
            this.focusViews.add(valueOf4);
            this.focusViews.add(valueOf3);
        }
        this.focusUtil.addViewIds(this.focusViews);
    }
}
