package com.szchoiceway.settings.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.MainActivity;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.settings.fragments.FragmentSystemSet_AUX;
import com.szchoiceway.settings.view.MyScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.settings.view.MySeekbar1;
import java.util.ArrayList;

public class FragmentSystemSet_AUX extends FragmentBase implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private static final String TAG = "SystemSet_AUX";
    TextView KSW_aux1_val = null;
    TextView KSW_aux2_val = null;
    int auxPosition1 = 0;
    int auxPosition2 = 0;
    SeekBar auxSeekBar1 = null;
    SeekBar auxSeekBar2 = null;
    int auxType = 0;
    boolean b_kesaiwei_chk_auto_aux = false;
    CheckBox kesaiwei_aux_typeA = null;
    CheckBox kesaiwei_aux_typeB = null;
    CheckBox kesaiwei_aux_type_customize = null;
    CheckBox kesaiwei_chk_auto_aux = null;
    /* access modifiers changed from: private */
    public MainActivity mMain;
    private View mMainView;
    /* access modifiers changed from: private */
    public SysProviderOpt mProvider;
    ScrollView mScrollView;
    /* access modifiers changed from: private */
    public MyScrollbar myScrollbar;
    MySeekbar1 my_KSW_aux1_SeekBar;
    MySeekbar1 my_KSW_aux2_SeekBar;
    /* access modifiers changed from: private */
    public View scrollLayout;
    /* access modifiers changed from: private */
    public int totalHeight = 0;

    public String getFragmentTag() {
        return TAG;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mMain = mainActivity;
        if (mainActivity != null) {
            this.m_CurrFocus = mainActivity.m_iCurrFocus;
        }
        SysProviderOpt instance = SysProviderOpt.getInstance(context);
        this.mProvider = instance;
        this.b_kesaiwei_chk_auto_aux = instance.getRecordBoolean(SysProviderOpt.KESAIWEI_RECORD_AUX_SWITCHING, this.b_kesaiwei_chk_auto_aux);
        this.auxType = this.mProvider.getRecordInteger(SysProviderOpt.KESAIWEI_SYS_SD_HOST, this.auxType);
        this.auxPosition1 = this.mProvider.getRecordInteger(SysProviderOpt.KSW_AUX_ITEM_POSITION, this.auxPosition1);
        this.auxPosition2 = this.mProvider.getRecordInteger(SysProviderOpt.KSW_AUX_ITEM_POSITION2, this.auxPosition2);
        Log.d(TAG, "b_kesaiwei_chk_auto_aux = " + this.b_kesaiwei_chk_auto_aux + ", auxType = " + this.auxType);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (this.isSmallResolution) {
            if (this.m_iUIIndex == 2) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_aux, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_sys_set_aux, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_aux, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_sys_set_aux, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_aux, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_aux, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_aux_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_aux, (ViewGroup) null);
            }
        } else if (this.m_iUIIndex == 2) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id8_fragment_sys_set_aux, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_sys_set_aux, (ViewGroup) null);
        } else if (this.m_iUIIndex == 7) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_aux, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_sys_set_aux, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_sys_set_aux, (ViewGroup) null);
        } else if (this.m_iUIIndex != 5) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_sys_set_aux, (ViewGroup) null);
        } else if (this.m_iModeSet == 32) {
            view = layoutInflater.inflate(R.layout.landrover_theme_fragment_sys_set_aux, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.landrover_fragment_sys_set_aux, (ViewGroup) null);
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
        this.mScrollView = (ScrollView) view.findViewById(R.id.mScrollView);
        this.myScrollbar = (MyScrollbar) view.findViewById(R.id.myScrollbar);
        View findViewById = view.findViewById(R.id.scrollLayout);
        this.scrollLayout = findViewById;
        if (findViewById != null) {
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    FragmentSystemSet_AUX.this.scrollLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    FragmentSystemSet_AUX fragmentSystemSet_AUX = FragmentSystemSet_AUX.this;
                    int unused = fragmentSystemSet_AUX.totalHeight = fragmentSystemSet_AUX.scrollLayout.getHeight();
                    Log.d(FragmentSystemSet_AUX.TAG, "totalHeight = " + FragmentSystemSet_AUX.this.totalHeight);
                    if (FragmentSystemSet_AUX.this.mScrollView != null) {
                        FragmentSystemSet_AUX.this.mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                                FragmentSystemSet_AUX.AnonymousClass1.this.lambda$onGlobalLayout$0$FragmentSystemSet_AUX$1(view, i, i2, i3, i4);
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onGlobalLayout$0$FragmentSystemSet_AUX$1(View view, int i, int i2, int i3, int i4) {
                    float access$100 = (((float) i2) * 1.0f) / ((float) (FragmentSystemSet_AUX.this.totalHeight - FragmentSystemSet_AUX.this.mScrollView.getHeight()));
                    if (FragmentSystemSet_AUX.this.myScrollbar != null) {
                        FragmentSystemSet_AUX.this.myScrollbar.setCurrentPercent(access$100);
                    }
                    Log.d(FragmentSystemSet_AUX.TAG, "scrollY = " + i2 + ", percent = " + access$100);
                }
            });
        }
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.kesaiwei_chk_auto_aux);
        this.kesaiwei_chk_auto_aux = checkBox;
        if (checkBox != null) {
            checkBox.setChecked(this.b_kesaiwei_chk_auto_aux);
        }
        this.kesaiwei_aux_typeA = (CheckBox) view.findViewById(R.id.kesaiwei_aux_typeA);
        this.kesaiwei_aux_typeB = (CheckBox) view.findViewById(R.id.kesaiwei_aux_typeH);
        this.kesaiwei_aux_type_customize = (CheckBox) view.findViewById(R.id.kesaiwei_aux_type_customize);
        refreshChk();
        int[] iArr = {R.id.btnAutoAux, R.id.btnAuxTypeA, R.id.btnAuxTypeH, R.id.btnAuxTypeCustomize};
        for (int i = 0; i < 4; i++) {
            View findViewById2 = view.findViewById(iArr[i]);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(this);
            }
        }
        this.auxSeekBar1 = (SeekBar) view.findViewById(R.id.KSW_aux1_SeekBar);
        this.KSW_aux1_val = (TextView) view.findViewById(R.id.KSW_aux1_val);
        SeekBar seekBar = this.auxSeekBar1;
        if (seekBar != null) {
            seekBar.setProgress(this.auxPosition1);
            this.auxSeekBar1.setOnSeekBarChangeListener(this);
        }
        refreshAux1ItemPosition();
        this.auxSeekBar2 = (SeekBar) view.findViewById(R.id.KSW_aux2_SeekBar);
        this.KSW_aux2_val = (TextView) view.findViewById(R.id.KSW_aux2_val);
        SeekBar seekBar2 = this.auxSeekBar2;
        if (seekBar2 != null) {
            seekBar2.setProgress(this.auxPosition2);
            this.auxSeekBar2.setOnSeekBarChangeListener(this);
        }
        refreshAux2ItemPosition();
        MySeekbar1 mySeekbar1 = (MySeekbar1) view.findViewById(R.id.my_seekBar1_aux1);
        this.my_KSW_aux1_SeekBar = mySeekbar1;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.auxPosition1);
            this.my_KSW_aux1_SeekBar.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentSystemSet_AUX.this.setScrollEnable(false);
                }

                public void onSeeking(int i) {
                    FragmentSystemSet_AUX.this.auxPosition1 = i;
                    FragmentSystemSet_AUX.this.refreshAux1ItemPosition();
                    FragmentSystemSet_AUX fragmentSystemSet_AUX = FragmentSystemSet_AUX.this;
                    fragmentSystemSet_AUX.kesaiwei_sendBroadcast3(48, 23, fragmentSystemSet_AUX.auxPosition1);
                    if (FragmentSystemSet_AUX.this.m_iUIIndex == 2) {
                        FragmentSystemSet_AUX.this.KSW_aux1_val.setTextColor(FragmentSystemSet_AUX.this.mMain.getColor(FragmentSystemSet_AUX.this.getAttrId(R.attr.ksw_id8_fontColor)));
                    }
                }

                public void onSeekStop(int i) {
                    FragmentSystemSet_AUX.this.setScrollEnable(true);
                    FragmentSystemSet_AUX.this.auxPosition1 = i;
                    FragmentSystemSet_AUX.this.refreshAux1ItemPosition();
                    if (FragmentSystemSet_AUX.this.m_iUIIndex != 5 && !FragmentSystemSet_AUX.this.focusUtil.inSeekbarKnobMode) {
                        FragmentSystemSet_AUX.this.KSW_aux1_val.setTextColor(-1);
                    }
                    FragmentSystemSet_AUX fragmentSystemSet_AUX = FragmentSystemSet_AUX.this;
                    fragmentSystemSet_AUX.kesaiwei_sendBroadcast3(48, 23, fragmentSystemSet_AUX.auxPosition1);
                    FragmentSystemSet_AUX.this.mProvider.updateRecord(SysProviderOpt.KSW_AUX_ITEM_POSITION, FragmentSystemSet_AUX.this.auxPosition1 + "");
                }
            });
        }
        MySeekbar1 mySeekbar12 = (MySeekbar1) view.findViewById(R.id.my_seekBar1_aux2);
        this.my_KSW_aux2_SeekBar = mySeekbar12;
        if (mySeekbar12 != null) {
            mySeekbar12.setCurrentProgress(this.auxPosition2);
            this.my_KSW_aux2_SeekBar.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentSystemSet_AUX.this.setScrollEnable(false);
                }

                public void onSeeking(int i) {
                    FragmentSystemSet_AUX.this.auxPosition2 = i;
                    FragmentSystemSet_AUX.this.refreshAux2ItemPosition();
                    FragmentSystemSet_AUX fragmentSystemSet_AUX = FragmentSystemSet_AUX.this;
                    fragmentSystemSet_AUX.kesaiwei_sendBroadcast3(48, 24, fragmentSystemSet_AUX.auxPosition2);
                    if (FragmentSystemSet_AUX.this.m_iUIIndex == 2) {
                        FragmentSystemSet_AUX.this.KSW_aux2_val.setTextColor(FragmentSystemSet_AUX.this.mMain.getColor(FragmentSystemSet_AUX.this.getAttrId(R.attr.ksw_id8_fontColor)));
                    }
                }

                public void onSeekStop(int i) {
                    FragmentSystemSet_AUX.this.setScrollEnable(true);
                    FragmentSystemSet_AUX.this.auxPosition2 = i;
                    FragmentSystemSet_AUX.this.refreshAux2ItemPosition();
                    if (FragmentSystemSet_AUX.this.m_iUIIndex != 5 && !FragmentSystemSet_AUX.this.focusUtil.inSeekbarKnobMode) {
                        FragmentSystemSet_AUX.this.KSW_aux2_val.setTextColor(-1);
                    }
                    FragmentSystemSet_AUX fragmentSystemSet_AUX = FragmentSystemSet_AUX.this;
                    fragmentSystemSet_AUX.kesaiwei_sendBroadcast3(48, 24, fragmentSystemSet_AUX.auxPosition2);
                    FragmentSystemSet_AUX.this.mProvider.updateRecord(SysProviderOpt.KSW_AUX_ITEM_POSITION2, FragmentSystemSet_AUX.this.auxPosition2 + "");
                }
            });
        }
        int[] iArr2 = {R.id.btnReduce1, R.id.btnAdd1, R.id.btnReduce2, R.id.btnAdd2};
        for (int i2 = 0; i2 < 4; i2++) {
            View findViewById3 = view.findViewById(iArr2[i2]);
            if (findViewById3 != null) {
                findViewById3.setOnClickListener(this);
            }
        }
    }

    public void onClick(View view) {
        if (BaseApp.getFocusUtil().inSeekbarKnobMode) {
            BaseApp.getFocusUtil().clearSeekbarFocus();
        }
        if (this.focusViews == null || this.focusViews.isEmpty()) {
            this.focusViews = new ArrayList();
            this.focusViews.add(Integer.valueOf(R.id.btnAutoAux));
            this.focusViews.add(Integer.valueOf(R.id.btnAuxTypeA));
            this.focusViews.add(Integer.valueOf(R.id.btnAuxTypeH));
            this.focusViews.add(Integer.valueOf(R.id.btnAuxTypeCustomize));
            this.focusViews.add(Integer.valueOf(R.id.viewKSW_aux1_SeekBar));
            this.focusViews.add(Integer.valueOf(R.id.viewKSW_aux2_SeekBar));
        }
        for (int i = 0; i < this.focusViews.size(); i++) {
            if (view.getId() == ((Integer) this.focusViews.get(i)).intValue()) {
                this.m_CurrFocus = i;
            }
        }
        this.baseApp.setFocusPage(2);
        this.mMain.m_iCurrFocus = this.m_CurrFocus;
        this.mMain.lastYFocus = 5;
        BaseApp.getFocusUtil().refreshFirstViews(this.mMain, -1, false);
        BaseApp.getFocusUtil().refreshSecondViews(-1, false);
        BaseApp.getFocusUtil().locateFragment(this, TAG);
        addViewIds();
        BaseApp.getFocusUtil().refreshThirdViews(this.mMain.m_iCurrFocus, false);
        switch (view.getId()) {
            case R.id.btnAdd1:
                int i2 = this.auxPosition1 + 1;
                this.auxPosition1 = i2;
                if (i2 > 12) {
                    this.auxPosition1 = 12;
                }
                this.my_KSW_aux1_SeekBar.setCurrentProgress(this.auxPosition1);
                refreshAux1ItemPosition();
                kesaiwei_sendBroadcast3(48, 23, this.auxPosition1);
                this.mProvider.updateRecord(SysProviderOpt.KSW_AUX_ITEM_POSITION, this.auxPosition1 + "");
                return;
            case R.id.btnAdd2:
                int i3 = this.auxPosition2 + 1;
                this.auxPosition2 = i3;
                if (i3 > 12) {
                    this.auxPosition2 = 12;
                }
                this.my_KSW_aux2_SeekBar.setCurrentProgress(this.auxPosition2);
                refreshAux2ItemPosition();
                kesaiwei_sendBroadcast3(48, 24, this.auxPosition2);
                this.mProvider.updateRecord(SysProviderOpt.KSW_AUX_ITEM_POSITION2, this.auxPosition2 + "");
                return;
            case R.id.btnAutoAux:
                boolean z = !this.b_kesaiwei_chk_auto_aux;
                this.b_kesaiwei_chk_auto_aux = z;
                this.kesaiwei_chk_auto_aux.setChecked(z);
                this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_RECORD_AUX_SWITCHING, this.b_kesaiwei_chk_auto_aux ? "1" : "0");
                kesaiwei_sendBroadcast2(8);
                return;
            case R.id.btnAuxTypeA:
                this.auxType = 1;
                this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_SYS_SD_HOST, "" + this.auxType);
                refreshChk();
                kesaiwei_sendBroadcast2(3);
                return;
            case R.id.btnAuxTypeCustomize:
                this.auxType = 3;
                this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_SYS_SD_HOST, "" + this.auxType);
                refreshChk();
                kesaiwei_sendBroadcast2(3);
                return;
            case R.id.btnAuxTypeH:
                this.auxType = 2;
                this.mProvider.updateRecord(SysProviderOpt.KESAIWEI_SYS_SD_HOST, "" + this.auxType);
                refreshChk();
                kesaiwei_sendBroadcast2(3);
                return;
            case R.id.btnReduce1:
                int i4 = this.auxPosition1 - 1;
                this.auxPosition1 = i4;
                if (i4 < 0) {
                    this.auxPosition1 = 0;
                }
                this.my_KSW_aux1_SeekBar.setCurrentProgress(this.auxPosition1);
                refreshAux1ItemPosition();
                kesaiwei_sendBroadcast3(48, 23, this.auxPosition1);
                this.mProvider.updateRecord(SysProviderOpt.KSW_AUX_ITEM_POSITION, this.auxPosition1 + "");
                return;
            case R.id.btnReduce2:
                int i5 = this.auxPosition2 - 1;
                this.auxPosition2 = i5;
                if (i5 < 0) {
                    this.auxPosition2 = 0;
                }
                this.my_KSW_aux2_SeekBar.setCurrentProgress(this.auxPosition2);
                refreshAux2ItemPosition();
                kesaiwei_sendBroadcast3(48, 24, this.auxPosition2);
                this.mProvider.updateRecord(SysProviderOpt.KSW_AUX_ITEM_POSITION2, this.auxPosition2 + "");
                return;
            default:
                return;
        }
    }

    private void refreshChk() {
        CheckBox checkBox = this.kesaiwei_aux_typeA;
        boolean z = false;
        if (checkBox != null) {
            checkBox.setChecked(this.auxType == 1);
        }
        CheckBox checkBox2 = this.kesaiwei_aux_typeB;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.auxType == 2);
        }
        CheckBox checkBox3 = this.kesaiwei_aux_type_customize;
        if (checkBox3 != null) {
            if (this.auxType == 3) {
                z = true;
            }
            checkBox3.setChecked(z);
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int id = seekBar.getId();
        if (id == R.id.KSW_aux1_SeekBar) {
            this.auxPosition1 = i;
            refreshAux1ItemPosition();
            kesaiwei_sendBroadcast3(48, 23, this.auxPosition1);
        } else if (id == R.id.KSW_aux2_SeekBar) {
            this.auxPosition2 = i;
            refreshAux2ItemPosition();
            kesaiwei_sendBroadcast3(48, 24, this.auxPosition2);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();
        if (id == R.id.KSW_aux1_SeekBar) {
            this.mProvider.updateRecord(SysProviderOpt.KSW_AUX_ITEM_POSITION, this.auxPosition1 + "");
        } else if (id == R.id.KSW_aux2_SeekBar) {
            this.mProvider.updateRecord(SysProviderOpt.KSW_AUX_ITEM_POSITION2, this.auxPosition2 + "");
        }
    }

    /* access modifiers changed from: private */
    public void refreshAux1ItemPosition() {
        TextView textView = this.KSW_aux1_val;
        if (textView != null) {
            textView.setText("" + this.auxPosition1);
        }
    }

    /* access modifiers changed from: private */
    public void refreshAux2ItemPosition() {
        TextView textView = this.KSW_aux2_val;
        if (textView != null) {
            textView.setText("" + this.auxPosition2);
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        this.focusViews.add(Integer.valueOf(R.id.btnAutoAux));
        this.focusViews.add(Integer.valueOf(R.id.btnAuxTypeA));
        this.focusViews.add(Integer.valueOf(R.id.btnAuxTypeH));
        this.focusViews.add(Integer.valueOf(R.id.btnAuxTypeCustomize));
        this.focusViews.add(Integer.valueOf(R.id.viewKSW_aux1_SeekBar));
        this.focusViews.add(Integer.valueOf(R.id.viewKSW_aux2_SeekBar));
        BaseApp.getFocusUtil().addViewIds(this.focusViews);
    }

    /* access modifiers changed from: private */
    public int getAttrId(int i) {
        if (getActivity() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        this.mMain.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: private */
    public void setScrollEnable(boolean z) {
        ScrollView scrollView = this.mScrollView;
        if (scrollView != null && (scrollView instanceof MyScrollView)) {
            ((MyScrollView) scrollView).setScrollAble(z);
        }
    }
}
