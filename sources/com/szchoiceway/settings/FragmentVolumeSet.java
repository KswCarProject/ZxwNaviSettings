package com.szchoiceway.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.eventcenter.IEventService;
import com.szchoiceway.settings.view.MyScrollView;
import com.szchoiceway.settings.view.MyScrollbar;
import com.szchoiceway.settings.view.MySeekbar1;
import java.util.ArrayList;
import java.util.List;

public class FragmentVolumeSet extends FragmentBase implements View.OnClickListener, View.OnTouchListener {
    public static final String TAG = "FragmentVolumeSet";
    TextView KSW_VolValue_Alto;
    TextView KSW_VolValue_Bass;
    TextView KSW_VolValue_Treble;
    TextView KSW_Vol_val_00;
    TextView KSW_Vol_val_01;
    TextView KSW_Vol_val_03;
    TextView KSW_Vol_val_04;
    /* access modifiers changed from: private */
    public int SEEK_SCOPE;
    private List<CheckBox> chkList = new ArrayList();
    private boolean enable = true;
    /* access modifiers changed from: private */
    public int iVol_00 = 30;
    /* access modifiers changed from: private */
    public int iVol_01 = 30;
    private int iVol_02 = 30;
    /* access modifiers changed from: private */
    public int iVol_03 = 22;
    /* access modifiers changed from: private */
    public int iVol_04 = 22;
    private int iVol_05 = 10;
    Integer[] ksw_i_classical_arr = {7, 1, 3};
    Integer[] ksw_i_dance_arr = {5, -1, 7};
    Integer[] ksw_i_jazz_arr = {1, 4, 4};
    Integer[] ksw_i_pop_arr = {4, -3, 4};
    Integer[] ksw_i_rock_arr = {3, -1, 5};
    Integer[] ksw_i_user_arr = {0, 0, 0};
    int ksw_m_i_eq_mode = 0;
    private VolsetKSW_Receiver mModel = new VolsetKSW_Receiver();
    ScrollView mScrollView;
    IEventService mService = null;
    SeekBar mVolSeekBar_00;
    SeekBar mVolSeekBar_01;
    SeekBar mVolSeekBar_03;
    SeekBar mVolSeekBar_04;
    private MainActivity main = null;
    /* access modifiers changed from: private */
    public View mainView;
    MySeekbar1 mySeekbar1Alto;
    MySeekbar1 mySeekbar1Bass;
    MySeekbar1 mySeekbar1Treble;
    MySeekbar1 mySeekbar1_00;
    MySeekbar1 mySeekbar1_01;
    MySeekbar1 mySeekbar1_03;
    MySeekbar1 mySeekbar1_04;
    View viewAndroidVolume;
    View viewOemVolume;

    public String getFragmentTag() {
        return TAG;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        Log.d(TAG, "onCreateView m_iModeSet = " + this.m_iModeSet);
        if (this.isSmallResolution) {
            if (isDefaultUI()) {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_volume_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 6) {
                view = layoutInflater.inflate(R.layout.small_kesaiwei_1920x720_benz_fragment_volume_set, (ViewGroup) null);
            } else if (this.m_iModeSet == 19) {
                view = layoutInflater.inflate(R.layout.pemp_id7_fragment_volume_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.small_audi_fragment_volume_set, (ViewGroup) null);
            } else if (this.m_iUIIndex == 5) {
                view = layoutInflater.inflate(R.layout.landrover_fragment_volume_set, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_volume_set, (ViewGroup) null);
            }
        } else if ("1560x700".equals(this.mResolution)) {
            if (this.m_iUIIndex == 4) {
                view = layoutInflater.inflate(R.layout.audi_fragment_volume_set_1560x700, (ViewGroup) null);
            } else {
                view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_volume_set, (ViewGroup) null);
            }
        } else if (isDefaultUI()) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_volume_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 6) {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_benz_fragment_volume_set, (ViewGroup) null);
        } else if (this.m_iModeSet == 19) {
            view = layoutInflater.inflate(R.layout.pemp_id7_fragment_volume_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 4) {
            view = layoutInflater.inflate(R.layout.audi_fragment_volume_set, (ViewGroup) null);
        } else if (this.m_iUIIndex == 5) {
            view = layoutInflater.inflate(R.layout.landrover_fragment_volume_set, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.kesaiwei_1920x720_evo_id7_fragment_volume_set, (ViewGroup) null);
        }
        this.mainView = view;
        try {
            bindViewListener(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.szchoiceway.settings.vol");
        if (getContext() != null) {
            getContext().registerReceiver(this.mModel, intentFilter);
        }
        return view;
    }

    public void onResume() {
        super.onResume();
        if (this.mainView == null) {
            this.mainView = getView();
        }
        mcu_to_vol_set_view();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mainView = null;
        if (getContext() != null) {
            getContext().unregisterReceiver(this.mModel);
        }
    }

    /* access modifiers changed from: protected */
    public void bindViewListener(View view) {
        super.bindViewListener(view);
        this.SEEK_SCOPE = (int) getContext().getResources().getDimension(R.dimen.scroll_scope);
        if (view != null) {
            Log.i(TAG, "--->>> bindViewListener");
            initService((IEventService) null);
            Button button = (Button) view.findViewById(R.id.btnAndroidVolume);
            if (button != null) {
                button.setOnClickListener(this);
            }
            Button button2 = (Button) view.findViewById(R.id.btnOemVolume);
            if (button2 != null) {
                button2.setOnClickListener(this);
            }
            View findViewById = view.findViewById(R.id.viewAndroidVolume);
            this.viewAndroidVolume = findViewById;
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            View findViewById2 = view.findViewById(R.id.viewOemVolume);
            this.viewOemVolume = findViewById2;
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            initVolSeekBar_00(view);
            initVolSeekBar_01(view);
            initVolSeekBar_03(view);
            initVolSeekBar_04(view);
            this.mScrollView = (ScrollView) view.findViewById(R.id.mScrollView);
            View findViewById3 = view.findViewById(R.id.scrollLayout);
            ScrollView scrollView = this.mScrollView;
            if (scrollView != null) {
                scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener(findViewById3, view) {
                    public final /* synthetic */ View f$1;
                    public final /* synthetic */ View f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                        FragmentVolumeSet.this.lambda$bindViewListener$0$FragmentVolumeSet(this.f$1, this.f$2, view, i, i2, i3, i4);
                    }
                });
            }
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnEq);
            if (imageButton != null) {
                imageButton.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        FragmentVolumeSet.this.lambda$bindViewListener$1$FragmentVolumeSet(view);
                    }
                });
            }
            if (this.KSW_VolValue_Bass != null) {
                if (this.ksw_i_user_arr[0].intValue() > 0) {
                    this.KSW_VolValue_Bass.setText("+" + this.ksw_i_user_arr[0]);
                } else {
                    this.KSW_VolValue_Bass.setText("" + this.ksw_i_user_arr[0]);
                }
            }
            if (this.KSW_VolValue_Alto != null) {
                if (this.ksw_i_user_arr[1].intValue() > 0) {
                    this.KSW_VolValue_Alto.setText("+" + this.ksw_i_user_arr[1]);
                } else {
                    this.KSW_VolValue_Alto.setText("" + this.ksw_i_user_arr[1]);
                }
            }
            if (this.KSW_VolValue_Treble != null) {
                if (this.ksw_i_user_arr[2].intValue() > 0) {
                    this.KSW_VolValue_Treble.setText("+" + this.ksw_i_user_arr[2]);
                } else {
                    this.KSW_VolValue_Treble.setText("" + this.ksw_i_user_arr[2]);
                }
            }
            refresh_vol_info();
            init_KSW_VolSeekBar_page2_low();
            init_KSW_VolSeekBar_page2_mid();
            init_KSW_VolSeekBar_page2_hight();
        }
    }

    public /* synthetic */ void lambda$bindViewListener$0$FragmentVolumeSet(View view, View view2, View view3, int i, int i2, int i3, int i4) {
        float height = (((float) i2) * 1.0f) / ((float) (view.getHeight() - this.mScrollView.getHeight()));
        MyScrollbar myScrollbar = (MyScrollbar) view2.findViewById(R.id.myScrollbar);
        if (myScrollbar != null) {
            myScrollbar.setCurrentPercent(height);
        }
    }

    public /* synthetic */ void lambda$bindViewListener$1$FragmentVolumeSet(View view) {
        EventUtils.startActivityIfNotRuning(getContext(), EventUtils.EQ_MODE_PACKAGE_NAME, EventUtils.EQ_MODE_CLASS_NAME);
    }

    private void init_KSW_get_page2_vol_info(IEventService iEventService) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null) {
            if (iEventService == null) {
                iEventService = mainActivity.getService();
            }
            if (iEventService != null) {
                try {
                    this.ksw_m_i_eq_mode = iEventService.getSettingInt(EventUtils.KESAIWEI_EQ_MODE_SELECT, this.ksw_m_i_eq_mode);
                    Integer[] numArr = this.ksw_i_user_arr;
                    numArr[0] = Integer.valueOf(iEventService.getSettingInt(EventUtils.KESAIWEI_EQ_USER_LOW, numArr[0].intValue()));
                    Integer[] numArr2 = this.ksw_i_user_arr;
                    numArr2[1] = Integer.valueOf(iEventService.getSettingInt(EventUtils.KESAIWEI_EQ_USER_MID, numArr2[1].intValue()));
                    Integer[] numArr3 = this.ksw_i_user_arr;
                    numArr3[2] = Integer.valueOf(iEventService.getSettingInt(EventUtils.KESAIWEI_EQ_USER_HIGHT, numArr3[2].intValue()));
                    Log.d(TAG, "init_KSW_get_page2_vol_info ksw_i_user_arr[0] = " + this.ksw_i_user_arr[0] + ", ksw_i_user_arr[1] = " + this.ksw_i_user_arr[1] + ", ksw_i_user_arr[2] = " + this.ksw_i_user_arr[2]);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void init_KSW_VolSeekBar_page2_mid() {
        MySeekbar1 mySeekbar1 = this.mySeekbar1Alto;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.ksw_i_user_arr[1].intValue() + 12);
            this.mySeekbar1Alto.setOnTouchListener(this);
            this.mySeekbar1Alto.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolumeSet.this.setScrollEnable(false);
                }

                public void onSeeking(int i) {
                    FragmentVolumeSet.this.ksw_i_user_arr[1] = Integer.valueOf(i - 12);
                    if (FragmentVolumeSet.this.KSW_VolValue_Alto != null) {
                        if (FragmentVolumeSet.this.ksw_i_user_arr[1].intValue() > 0) {
                            FragmentVolumeSet.this.KSW_VolValue_Alto.setText("+" + FragmentVolumeSet.this.ksw_i_user_arr[1]);
                        } else {
                            FragmentVolumeSet.this.KSW_VolValue_Alto.setText("" + FragmentVolumeSet.this.ksw_i_user_arr[1]);
                        }
                    }
                    FragmentVolumeSet.this.send_KSW_page2_vol_info();
                }

                public void onSeekStop(int i) {
                    FragmentVolumeSet.this.setScrollEnable(true);
                    FragmentVolumeSet.this.ksw_i_user_arr[1] = Integer.valueOf(i - 12);
                    if (FragmentVolumeSet.this.KSW_VolValue_Alto != null) {
                        if (FragmentVolumeSet.this.ksw_i_user_arr[1].intValue() > 0) {
                            FragmentVolumeSet.this.KSW_VolValue_Alto.setText("+" + FragmentVolumeSet.this.ksw_i_user_arr[1]);
                        } else {
                            FragmentVolumeSet.this.KSW_VolValue_Alto.setText("" + FragmentVolumeSet.this.ksw_i_user_arr[1]);
                        }
                        if (!FragmentVolumeSet.this.focusUtil.inSeekbarKnobMode) {
                            FragmentVolumeSet.this.KSW_VolValue_Alto.setTextColor(-1);
                        }
                    }
                    FragmentVolumeSet.this.send_KSW_page2_vol_info();
                    FragmentVolumeSet.this.save_KSW_set_page2_vol_info();
                }
            });
        }
    }

    private void refresh_vol_info() {
        Log.d(TAG, "refresh_vol_info ksw_m_i_eq_mode = " + this.ksw_m_i_eq_mode);
        for (int i = 0; i < this.chkList.size(); i++) {
            CheckBox checkBox = this.chkList.get(i);
            if (checkBox != null) {
                if (i == this.ksw_m_i_eq_mode) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
            }
        }
        this.enable = this.ksw_m_i_eq_mode == 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.ksw_i_user_arr);
        arrayList.add(this.ksw_i_pop_arr);
        arrayList.add(this.ksw_i_classical_arr);
        arrayList.add(this.ksw_i_rock_arr);
        arrayList.add(this.ksw_i_jazz_arr);
        arrayList.add(this.ksw_i_dance_arr);
        int i2 = this.ksw_m_i_eq_mode;
        if (i2 < 6 && i2 >= 0) {
            if (this.KSW_VolValue_Bass != null) {
                if (((Integer[]) arrayList.get(i2))[0].intValue() > 0) {
                    this.KSW_VolValue_Bass.setText("+" + ((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[0]);
                } else {
                    this.KSW_VolValue_Bass.setText("" + ((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[0]);
                }
            }
            MySeekbar1 mySeekbar1 = this.mySeekbar1Bass;
            if (mySeekbar1 != null) {
                mySeekbar1.setCurrentProgress(((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[0].intValue() + 12);
            }
            if (this.KSW_VolValue_Alto != null) {
                if (((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[1].intValue() > 0) {
                    this.KSW_VolValue_Alto.setText("+" + ((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[1]);
                } else {
                    this.KSW_VolValue_Alto.setText("" + ((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[1]);
                }
            }
            MySeekbar1 mySeekbar12 = this.mySeekbar1Alto;
            if (mySeekbar12 != null) {
                mySeekbar12.setCurrentProgress(((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[1].intValue() + 12);
            }
            if (this.KSW_VolValue_Treble != null) {
                if (((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[2].intValue() > 0) {
                    this.KSW_VolValue_Treble.setText("+" + ((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[2]);
                } else {
                    this.KSW_VolValue_Treble.setText("" + ((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[2]);
                }
            }
            MySeekbar1 mySeekbar13 = this.mySeekbar1Treble;
            if (mySeekbar13 != null) {
                mySeekbar13.setCurrentProgress(((Integer[]) arrayList.get(this.ksw_m_i_eq_mode))[2].intValue() + 12);
            }
        }
    }

    private void init_KSW_VolSeekBar_page2_low() {
        MySeekbar1 mySeekbar1 = this.mySeekbar1Bass;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.ksw_i_user_arr[0].intValue() + 12);
            this.mySeekbar1Bass.setOnTouchListener(this);
            this.mySeekbar1Bass.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolumeSet.this.setScrollEnable(false);
                }

                public void onSeeking(int i) {
                    FragmentVolumeSet.this.ksw_i_user_arr[0] = Integer.valueOf(i - 12);
                    if (FragmentVolumeSet.this.KSW_VolValue_Bass != null) {
                        if (FragmentVolumeSet.this.ksw_i_user_arr[0].intValue() > 0) {
                            FragmentVolumeSet.this.KSW_VolValue_Bass.setText("+" + FragmentVolumeSet.this.ksw_i_user_arr[0]);
                        } else {
                            FragmentVolumeSet.this.KSW_VolValue_Bass.setText("" + FragmentVolumeSet.this.ksw_i_user_arr[0]);
                        }
                    }
                    FragmentVolumeSet.this.send_KSW_page2_vol_info();
                }

                public void onSeekStop(int i) {
                    FragmentVolumeSet.this.setScrollEnable(true);
                    FragmentVolumeSet.this.ksw_i_user_arr[0] = Integer.valueOf(i - 12);
                    if (FragmentVolumeSet.this.KSW_VolValue_Bass != null) {
                        if (FragmentVolumeSet.this.ksw_i_user_arr[0].intValue() > 0) {
                            FragmentVolumeSet.this.KSW_VolValue_Bass.setText("+" + FragmentVolumeSet.this.ksw_i_user_arr[0]);
                        } else {
                            FragmentVolumeSet.this.KSW_VolValue_Bass.setText("" + FragmentVolumeSet.this.ksw_i_user_arr[0]);
                        }
                    }
                    FragmentVolumeSet.this.send_KSW_page2_vol_info();
                    FragmentVolumeSet.this.save_KSW_set_page2_vol_info();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void save_KSW_set_page2_vol_info() {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        IEventService service = mainActivity != null ? mainActivity.getService() : null;
        try {
            service.putSettingInt(EventUtils.KESAIWEI_EQ_MODE_SELECT, this.ksw_m_i_eq_mode);
            service.putSettingInt(EventUtils.KESAIWEI_EQ_USER_LOW, this.ksw_i_user_arr[0].intValue());
            service.putSettingInt(EventUtils.KESAIWEI_EQ_USER_MID, this.ksw_i_user_arr[1].intValue());
            service.putSettingInt(EventUtils.KESAIWEI_EQ_USER_HIGHT, this.ksw_i_user_arr[2].intValue());
            service.appySetting();
            service.commitSetting();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void send_KSW_page2_vol_info() {
        int i;
        int i2;
        IEventService service;
        int i3 = this.ksw_m_i_eq_mode;
        int i4 = 0;
        if (i3 == 0) {
            i4 = this.ksw_i_user_arr[0].intValue();
            i2 = this.ksw_i_user_arr[1].intValue();
            i = this.ksw_i_user_arr[2].intValue();
        } else if (i3 == 1) {
            i4 = this.ksw_i_pop_arr[0].intValue();
            i2 = this.ksw_i_pop_arr[1].intValue();
            i = this.ksw_i_pop_arr[2].intValue();
        } else if (i3 == 2) {
            i4 = this.ksw_i_classical_arr[0].intValue();
            i2 = this.ksw_i_classical_arr[1].intValue();
            i = this.ksw_i_classical_arr[2].intValue();
        } else if (i3 == 3) {
            i4 = this.ksw_i_rock_arr[0].intValue();
            i2 = this.ksw_i_rock_arr[1].intValue();
            i = this.ksw_i_rock_arr[2].intValue();
        } else if (i3 == 4) {
            i4 = this.ksw_i_jazz_arr[0].intValue();
            i2 = this.ksw_i_jazz_arr[1].intValue();
            i = this.ksw_i_jazz_arr[2].intValue();
        } else if (i3 != 5) {
            i2 = 0;
            i = 0;
        } else {
            i4 = this.ksw_i_dance_arr[0].intValue();
            i2 = this.ksw_i_dance_arr[1].intValue();
            i = this.ksw_i_dance_arr[2].intValue();
        }
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null && (service = mainActivity.getService()) != null) {
            try {
                service.send_KSW_page2_vol_info(this.ksw_m_i_eq_mode, i4, i2, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void init_KSW_VolSeekBar_page2_hight() {
        MySeekbar1 mySeekbar1 = this.mySeekbar1Treble;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.ksw_i_user_arr[2].intValue() + 12);
            this.mySeekbar1Treble.setOnTouchListener(this);
            this.mySeekbar1Treble.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolumeSet.this.setScrollEnable(false);
                }

                public void onSeeking(int i) {
                    FragmentVolumeSet.this.ksw_i_user_arr[2] = Integer.valueOf(i - 12);
                    if (FragmentVolumeSet.this.KSW_VolValue_Treble != null) {
                        if (FragmentVolumeSet.this.ksw_i_user_arr[2].intValue() > 0) {
                            FragmentVolumeSet.this.KSW_VolValue_Treble.setText("+" + FragmentVolumeSet.this.ksw_i_user_arr[2]);
                        } else {
                            FragmentVolumeSet.this.KSW_VolValue_Treble.setText("" + FragmentVolumeSet.this.ksw_i_user_arr[2]);
                        }
                    }
                    FragmentVolumeSet.this.send_KSW_page2_vol_info();
                }

                public void onSeekStop(int i) {
                    FragmentVolumeSet.this.setScrollEnable(true);
                    FragmentVolumeSet.this.ksw_i_user_arr[2] = Integer.valueOf(i - 12);
                    if (FragmentVolumeSet.this.KSW_VolValue_Treble != null) {
                        if (FragmentVolumeSet.this.ksw_i_user_arr[2].intValue() > 0) {
                            FragmentVolumeSet.this.KSW_VolValue_Treble.setText("+" + FragmentVolumeSet.this.ksw_i_user_arr[2]);
                        } else {
                            FragmentVolumeSet.this.KSW_VolValue_Treble.setText("" + FragmentVolumeSet.this.ksw_i_user_arr[2]);
                        }
                        if (!FragmentVolumeSet.this.focusUtil.inSeekbarKnobMode) {
                            FragmentVolumeSet.this.KSW_VolValue_Treble.setTextColor(-1);
                        }
                    }
                    FragmentVolumeSet.this.send_KSW_page2_vol_info();
                    FragmentVolumeSet.this.save_KSW_set_page2_vol_info();
                }
            });
        }
    }

    public void onClick(View view) {
        if (this.mainActivity == null) {
            this.mainActivity = (MainActivity) getActivity();
        }
        int id = view.getId();
        if (id != R.id.btnAndroidVolume) {
            if (id != R.id.btnOemVolume) {
                switch (id) {
                    case R.id.KSW_btn_eq_classical /*2131230799*/:
                        this.ksw_m_i_eq_mode = 2;
                        refresh_vol_info();
                        send_KSW_page2_vol_info();
                        save_KSW_set_page2_vol_info();
                        return;
                    case R.id.KSW_btn_eq_custom /*2131230800*/:
                        this.ksw_m_i_eq_mode = 0;
                        refresh_vol_info();
                        send_KSW_page2_vol_info();
                        save_KSW_set_page2_vol_info();
                        return;
                    case R.id.KSW_btn_eq_dance /*2131230801*/:
                        this.ksw_m_i_eq_mode = 5;
                        refresh_vol_info();
                        send_KSW_page2_vol_info();
                        save_KSW_set_page2_vol_info();
                        return;
                    case R.id.KSW_btn_eq_jazz /*2131230802*/:
                        this.ksw_m_i_eq_mode = 4;
                        refresh_vol_info();
                        send_KSW_page2_vol_info();
                        save_KSW_set_page2_vol_info();
                        return;
                    case R.id.KSW_btn_eq_pop /*2131230803*/:
                        this.ksw_m_i_eq_mode = 1;
                        refresh_vol_info();
                        send_KSW_page2_vol_info();
                        save_KSW_set_page2_vol_info();
                        return;
                    case R.id.KSW_btn_eq_rock /*2131230804*/:
                        this.ksw_m_i_eq_mode = 3;
                        refresh_vol_info();
                        send_KSW_page2_vol_info();
                        save_KSW_set_page2_vol_info();
                        return;
                    default:
                        return;
                }
            } else if (this.viewOemVolume != null) {
                BaseApp.focusPage = 2;
                this.mainActivity.m_iCurrFocus = -1;
                this.mainActivity.lastYFocus = 1;
                this.viewOemVolume.setVisibility(0);
                addViewIds();
            }
        } else if (this.viewAndroidVolume != null) {
            BaseApp.focusPage = 2;
            this.mainActivity.m_iCurrFocus = -1;
            this.mainActivity.lastYFocus = 0;
            this.viewAndroidVolume.setVisibility(0);
            addViewIds();
        }
    }

    public void hideContentView() {
        super.hideContentView();
        View view = this.viewAndroidVolume;
        if (view != null && view.getVisibility() == 0) {
            this.viewAndroidVolume.setVisibility(8);
        }
        View view2 = this.viewOemVolume;
        if (view2 != null && view2.getVisibility() == 0) {
            this.viewOemVolume.setVisibility(8);
        }
    }

    public void initVolSeekBar_00(View view) {
        TextView textView = (TextView) view.findViewById(R.id.KSW_Vol_val_00);
        this.KSW_Vol_val_00 = textView;
        if (textView != null) {
            textView.setText("" + this.iVol_00 + "");
        }
        MySeekbar1 mySeekbar1 = (MySeekbar1) this.mainView.findViewById(R.id.my_seekbar1_00);
        this.mySeekbar1_00 = mySeekbar1;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.iVol_00);
            this.mySeekbar1_00.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolumeSet.this.setScrollEnable(false);
                }

                public void onSeeking(int i) {
                    int unused = FragmentVolumeSet.this.iVol_00 = i;
                    if (FragmentVolumeSet.this.KSW_Vol_val_00 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_00.setText("" + FragmentVolumeSet.this.iVol_00);
                    }
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    fragmentVolumeSet.SendVolVal_KSW(false, 1, 1, fragmentVolumeSet.iVol_00);
                }

                public void onSeekStop(int i) {
                    FragmentVolumeSet.this.setScrollEnable(true);
                    int unused = FragmentVolumeSet.this.iVol_00 = i;
                    if (FragmentVolumeSet.this.KSW_Vol_val_00 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_00.setText("" + FragmentVolumeSet.this.iVol_00);
                    }
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    fragmentVolumeSet.SendVolVal_KSW(false, 1, 1, fragmentVolumeSet.iVol_00);
                    FragmentVolumeSet.this.SaveVolSettings_KSW();
                }
            });
        }
        SeekBar seekBar = (SeekBar) this.mainView.findViewById(R.id.KSW_VolSeekBar_00);
        this.mVolSeekBar_00 = seekBar;
        if (seekBar != null) {
            View findViewById = this.mainView.findViewById(R.id.view0);
            if (findViewById != null) {
                findViewById.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        FragmentVolumeSet.this.mVolSeekBar_00.getHitRect(rect);
                        if (motionEvent.getY() < ((float) (rect.top - FragmentVolumeSet.this.SEEK_SCOPE)) || motionEvent.getY() > ((float) (rect.bottom + FragmentVolumeSet.this.SEEK_SCOPE)) || motionEvent.getX() < ((float) rect.left) || motionEvent.getX() > ((float) rect.right)) {
                            return false;
                        }
                        return FragmentVolumeSet.this.mVolSeekBar_00.onTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getX() - ((float) rect.left), ((float) rect.top) + (((float) rect.height()) / 2.0f), motionEvent.getMetaState()));
                    }
                });
            }
            this.mVolSeekBar_00.setProgress(this.iVol_00);
            Log.i(TAG, "--->>> iVol_00 = " + this.iVol_00);
            this.mVolSeekBar_00.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    System.out.println("onProgressChanged*******************");
                    if (FragmentVolumeSet.this.mainView == null) {
                        FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                        View unused = fragmentVolumeSet.mainView = fragmentVolumeSet.getView();
                    }
                    if (FragmentVolumeSet.this.mainView != null) {
                        FragmentVolumeSet fragmentVolumeSet2 = FragmentVolumeSet.this;
                        int unused2 = fragmentVolumeSet2.iVol_00 = fragmentVolumeSet2.mVolSeekBar_00.getProgress();
                        if (FragmentVolumeSet.this.KSW_Vol_val_00 != null) {
                            FragmentVolumeSet.this.KSW_Vol_val_00.setText("" + FragmentVolumeSet.this.iVol_00 + "");
                        }
                        FragmentVolumeSet fragmentVolumeSet3 = FragmentVolumeSet.this;
                        fragmentVolumeSet3.SendVolVal_KSW(false, 1, 1, fragmentVolumeSet3.iVol_00);
                    }
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    System.out.println("onStopTrackingTouch*******************");
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    int unused = fragmentVolumeSet.iVol_00 = fragmentVolumeSet.mVolSeekBar_00.getProgress();
                    if (FragmentVolumeSet.this.KSW_Vol_val_00 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_00.setText("" + FragmentVolumeSet.this.iVol_00 + "");
                    }
                    FragmentVolumeSet.this.SaveVolSettings_KSW();
                    MainActivity mainActivity = (MainActivity) FragmentVolumeSet.this.getActivity();
                    IEventService iEventService = null;
                    if (mainActivity == null) {
                        mainActivity = FragmentVolumeSet.this.getMainActivity();
                    }
                    if (mainActivity != null) {
                        iEventService = mainActivity.getService();
                    }
                    try {
                        if (FragmentVolumeSet.this.iVol_00 > 0) {
                            iEventService.sendMuteState(false);
                        } else {
                            iEventService.sendMuteState(true);
                        }
                        iEventService.sendToOSData();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void initVolSeekBar_01(View view) {
        TextView textView = (TextView) view.findViewById(R.id.KSW_Vol_val_01);
        this.KSW_Vol_val_01 = textView;
        if (textView != null) {
            textView.setText("" + this.iVol_01 + "");
        }
        MySeekbar1 mySeekbar1 = (MySeekbar1) this.mainView.findViewById(R.id.my_seekbar1_01);
        this.mySeekbar1_01 = mySeekbar1;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.iVol_01);
            this.mySeekbar1_01.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolumeSet.this.setScrollEnable(false);
                }

                public void onSeeking(int i) {
                    int unused = FragmentVolumeSet.this.iVol_01 = i;
                    if (FragmentVolumeSet.this.KSW_Vol_val_01 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_01.setText("" + FragmentVolumeSet.this.iVol_01);
                    }
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    fragmentVolumeSet.SendVolVal_KSW(false, 1, 2, fragmentVolumeSet.iVol_01);
                }

                public void onSeekStop(int i) {
                    FragmentVolumeSet.this.setScrollEnable(true);
                    int unused = FragmentVolumeSet.this.iVol_01 = i;
                    if (FragmentVolumeSet.this.KSW_Vol_val_01 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_01.setText("" + FragmentVolumeSet.this.iVol_01);
                    }
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    fragmentVolumeSet.SendVolVal_KSW(false, 1, 2, fragmentVolumeSet.iVol_01);
                    FragmentVolumeSet.this.SaveVolSettings_KSW();
                }
            });
        }
        SeekBar seekBar = (SeekBar) this.mainView.findViewById(R.id.KSW_VolSeekBar_01);
        this.mVolSeekBar_01 = seekBar;
        if (seekBar != null) {
            View findViewById = this.mainView.findViewById(R.id.view1);
            if (findViewById != null) {
                findViewById.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        FragmentVolumeSet.this.mVolSeekBar_01.getHitRect(rect);
                        if (motionEvent.getY() < ((float) (rect.top - FragmentVolumeSet.this.SEEK_SCOPE)) || motionEvent.getY() > ((float) (rect.bottom + FragmentVolumeSet.this.SEEK_SCOPE)) || motionEvent.getX() < ((float) rect.left) || motionEvent.getX() > ((float) rect.right)) {
                            return false;
                        }
                        return FragmentVolumeSet.this.mVolSeekBar_01.onTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getX() - ((float) rect.left), ((float) rect.top) + (((float) rect.height()) / 2.0f), motionEvent.getMetaState()));
                    }
                });
            }
            this.mVolSeekBar_01.setProgress(this.iVol_01);
            Log.i(TAG, "--->>> iVol_01 = " + this.iVol_01);
            this.mVolSeekBar_01.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    System.out.println("onProgressChanged*******************");
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    int unused = fragmentVolumeSet.iVol_01 = fragmentVolumeSet.mVolSeekBar_01.getProgress();
                    if (FragmentVolumeSet.this.KSW_Vol_val_01 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_01.setText("" + FragmentVolumeSet.this.iVol_01 + "");
                    }
                    FragmentVolumeSet fragmentVolumeSet2 = FragmentVolumeSet.this;
                    fragmentVolumeSet2.SendVolVal_KSW(false, 1, 2, fragmentVolumeSet2.iVol_01);
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    System.out.println("onStopTrackingTouch*******************");
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    int unused = fragmentVolumeSet.iVol_01 = fragmentVolumeSet.mVolSeekBar_01.getProgress();
                    if (FragmentVolumeSet.this.KSW_Vol_val_01 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_01.setText("" + FragmentVolumeSet.this.iVol_01 + "");
                    }
                    FragmentVolumeSet.this.SaveVolSettings_KSW();
                }
            });
        }
    }

    public void initVolSeekBar_03(View view) {
        TextView textView = (TextView) view.findViewById(R.id.KSW_Vol_val_03);
        this.KSW_Vol_val_03 = textView;
        if (textView != null) {
            textView.setText("" + this.iVol_03 + "");
        }
        MySeekbar1 mySeekbar1 = (MySeekbar1) this.mainView.findViewById(R.id.my_seekbar1_03);
        this.mySeekbar1_03 = mySeekbar1;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.iVol_03);
            this.mySeekbar1_03.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolumeSet.this.setScrollEnable(false);
                }

                public void onSeeking(int i) {
                    int unused = FragmentVolumeSet.this.iVol_03 = i;
                    if (FragmentVolumeSet.this.KSW_Vol_val_03 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_03.setText("" + FragmentVolumeSet.this.iVol_03);
                    }
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    fragmentVolumeSet.SendVolVal_KSW(false, 2, 2, fragmentVolumeSet.iVol_03);
                }

                public void onSeekStop(int i) {
                    FragmentVolumeSet.this.setScrollEnable(true);
                    int unused = FragmentVolumeSet.this.iVol_03 = i;
                    if (FragmentVolumeSet.this.KSW_Vol_val_03 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_03.setText("" + FragmentVolumeSet.this.iVol_03);
                    }
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    fragmentVolumeSet.SendVolVal_KSW(false, 2, 2, fragmentVolumeSet.iVol_03);
                    FragmentVolumeSet.this.SaveVolSettings_KSW();
                }
            });
        }
        SeekBar seekBar = (SeekBar) this.mainView.findViewById(R.id.KSW_VolSeekBar_03);
        this.mVolSeekBar_03 = seekBar;
        if (seekBar != null) {
            View findViewById = this.mainView.findViewById(R.id.view2);
            if (findViewById != null) {
                findViewById.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        FragmentVolumeSet.this.mVolSeekBar_03.getHitRect(rect);
                        if (motionEvent.getY() < ((float) (rect.top - FragmentVolumeSet.this.SEEK_SCOPE)) || motionEvent.getY() > ((float) (rect.bottom + FragmentVolumeSet.this.SEEK_SCOPE)) || motionEvent.getX() < ((float) rect.left) || motionEvent.getX() > ((float) rect.right)) {
                            return false;
                        }
                        return FragmentVolumeSet.this.mVolSeekBar_03.onTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getX() - ((float) rect.left), ((float) rect.top) + (((float) rect.height()) / 2.0f), motionEvent.getMetaState()));
                    }
                });
            }
            this.mVolSeekBar_03.setProgress(this.iVol_03);
            Log.i(TAG, "--->>> iVol_03 = " + this.iVol_03);
            this.mVolSeekBar_03.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    System.out.println("onProgressChanged*******************");
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    int unused = fragmentVolumeSet.iVol_03 = fragmentVolumeSet.mVolSeekBar_03.getProgress();
                    if (FragmentVolumeSet.this.KSW_Vol_val_03 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_03.setText("" + FragmentVolumeSet.this.iVol_03 + "");
                    }
                    FragmentVolumeSet fragmentVolumeSet2 = FragmentVolumeSet.this;
                    fragmentVolumeSet2.SendVolVal_KSW(false, 2, 2, fragmentVolumeSet2.iVol_03);
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    System.out.println("onStopTrackingTouch*******************");
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    int unused = fragmentVolumeSet.iVol_03 = fragmentVolumeSet.mVolSeekBar_03.getProgress();
                    if (FragmentVolumeSet.this.KSW_Vol_val_03 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_03.setText("" + FragmentVolumeSet.this.iVol_03 + "");
                    }
                    FragmentVolumeSet.this.SaveVolSettings_KSW();
                }
            });
        }
    }

    public void initVolSeekBar_04(View view) {
        TextView textView = (TextView) view.findViewById(R.id.KSW_Vol_val_04);
        this.KSW_Vol_val_04 = textView;
        if (textView != null) {
            textView.setText("" + this.iVol_04 + "");
        }
        MySeekbar1 mySeekbar1 = (MySeekbar1) this.mainView.findViewById(R.id.my_seekbar1_04);
        this.mySeekbar1_04 = mySeekbar1;
        if (mySeekbar1 != null) {
            mySeekbar1.setCurrentProgress(this.iVol_04);
            this.mySeekbar1_04.setOnSeekListener(new MySeekbar1.OnSeekListener() {
                public void onSeekTouch() {
                    FragmentVolumeSet.this.setScrollEnable(false);
                }

                public void onSeeking(int i) {
                    int unused = FragmentVolumeSet.this.iVol_04 = i;
                    if (FragmentVolumeSet.this.KSW_Vol_val_04 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_04.setText("" + FragmentVolumeSet.this.iVol_04);
                    }
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    fragmentVolumeSet.SendVolVal_KSW(false, 2, 3, fragmentVolumeSet.iVol_04);
                }

                public void onSeekStop(int i) {
                    FragmentVolumeSet.this.setScrollEnable(true);
                    int unused = FragmentVolumeSet.this.iVol_04 = i;
                    if (FragmentVolumeSet.this.KSW_Vol_val_04 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_04.setText("" + FragmentVolumeSet.this.iVol_04);
                    }
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    fragmentVolumeSet.SendVolVal_KSW(false, 2, 3, fragmentVolumeSet.iVol_04);
                    FragmentVolumeSet.this.SaveVolSettings_KSW();
                }
            });
        }
        SeekBar seekBar = (SeekBar) this.mainView.findViewById(R.id.KSW_VolSeekBar_04);
        this.mVolSeekBar_04 = seekBar;
        if (seekBar != null) {
            View findViewById = this.mainView.findViewById(R.id.view3);
            if (findViewById != null) {
                findViewById.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        FragmentVolumeSet.this.mVolSeekBar_04.getHitRect(rect);
                        if (motionEvent.getY() < ((float) (rect.top - FragmentVolumeSet.this.SEEK_SCOPE)) || motionEvent.getY() > ((float) (rect.bottom + FragmentVolumeSet.this.SEEK_SCOPE)) || motionEvent.getX() < ((float) rect.left) || motionEvent.getX() > ((float) rect.right)) {
                            return false;
                        }
                        return FragmentVolumeSet.this.mVolSeekBar_04.onTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getX() - ((float) rect.left), ((float) rect.top) + (((float) rect.height()) / 2.0f), motionEvent.getMetaState()));
                    }
                });
            }
            this.mVolSeekBar_04.setProgress(this.iVol_04);
            Log.i(TAG, "--->>> iVol_04 = " + this.iVol_04);
            this.mVolSeekBar_04.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    System.out.println("onProgressChanged*******************");
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    int unused = fragmentVolumeSet.iVol_04 = fragmentVolumeSet.mVolSeekBar_04.getProgress();
                    if (FragmentVolumeSet.this.KSW_Vol_val_04 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_04.setText("" + FragmentVolumeSet.this.iVol_04 + "");
                    }
                    FragmentVolumeSet fragmentVolumeSet2 = FragmentVolumeSet.this;
                    fragmentVolumeSet2.SendVolVal_KSW(false, 2, 3, fragmentVolumeSet2.iVol_04);
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    System.out.println("onStopTrackingTouch*******************");
                    FragmentVolumeSet fragmentVolumeSet = FragmentVolumeSet.this;
                    int unused = fragmentVolumeSet.iVol_04 = fragmentVolumeSet.mVolSeekBar_04.getProgress();
                    if (FragmentVolumeSet.this.KSW_Vol_val_04 != null) {
                        FragmentVolumeSet.this.KSW_Vol_val_04.setText("" + FragmentVolumeSet.this.iVol_04 + "");
                    }
                    FragmentVolumeSet.this.SaveVolSettings_KSW();
                }
            });
        }
    }

    public void mcu_to_vol_set_view() {
        if (this.mVolSeekBar_00 != null && this.mVolSeekBar_01 != null && this.mService != null) {
            try {
                Log.d(TAG, "mute = " + this.mService.getMuteStatus() + ", vol_00 = " + this.mService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_00, this.iVol_00) + ", iVol_01 = " + this.mService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_01, this.iVol_01));
                if (this.mService.getMuteStatus()) {
                    this.iVol_00 = 0;
                } else {
                    this.iVol_00 = this.mService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_00, this.iVol_00);
                }
                this.mVolSeekBar_00.setProgress(this.iVol_00);
                int settingInt = this.mService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_01, this.iVol_01);
                this.iVol_01 = settingInt;
                this.mVolSeekBar_01.setProgress(settingInt);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void initVolSetttings_KSW(IEventService iEventService) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null) {
            if (iEventService == null) {
                iEventService = mainActivity.getService();
            }
            if (iEventService != null) {
                try {
                    this.iVol_00 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_00, this.iVol_00);
                    this.iVol_01 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_01, this.iVol_01);
                    this.iVol_02 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_02, this.iVol_02);
                    this.iVol_03 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_03, this.iVol_03);
                    this.iVol_04 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_04, this.iVol_04);
                    this.iVol_05 = iEventService.getSettingInt(EventUtils.KEY_KSW_VOL_VAL_05, this.iVol_05);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mainView == null) {
            this.mainView = getView();
            Log.i(TAG, "mainView = getView();");
        }
    }

    /* access modifiers changed from: protected */
    public void SaveVolSettings_KSW() {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        IEventService service = mainActivity != null ? mainActivity.getService() : null;
        try {
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_00, this.iVol_00);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_01, this.iVol_01);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_02, this.iVol_02);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_03, this.iVol_03);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_04, this.iVol_04);
            service.putSettingInt(EventUtils.KEY_KSW_VOL_VAL_05, this.iVol_05);
            service.appySetting();
            service.commitSetting();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void SendVolVal_KSW(boolean z, int i, int i2, int i3) {
        IEventService service;
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (mainActivity != null && (service = mainActivity.getService()) != null) {
            try {
                service.SendVol_KSW(z, i, i2, i3);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initService(IEventService iEventService) {
        Log.i(TAG, "initService...............");
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity == null) {
            mainActivity = getMainActivity();
        }
        if (this.mainView == null) {
            this.mainView = getView();
        }
        if (mainActivity != null) {
            if (this.mService == null) {
                this.mService = mainActivity.getService();
            }
            Log.i(TAG, "initService: mService = " + this.mService);
            initVolSetttings_KSW(this.mService);
            init_KSW_get_page2_vol_info(this.mService);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return !this.enable;
    }

    public class VolsetKSW_Receiver extends BroadcastReceiver {
        public VolsetKSW_Receiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.szchoiceway.settings.vol".equals(intent.getAction())) {
                FragmentVolumeSet.this.mcu_to_vol_set_view();
            }
        }
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusViews = new ArrayList();
        int i = this.m_iUIIndex;
        Integer valueOf = Integer.valueOf(R.id.viewKSW_Vol_val_04);
        Integer valueOf2 = Integer.valueOf(R.id.viewKSW_Vol_val_03);
        Integer valueOf3 = Integer.valueOf(R.id.viewKSW_Vol_val_01);
        Integer valueOf4 = Integer.valueOf(R.id.viewKSW_Vol_val_00);
        if (i != 4 || this.isSmallResolution) {
            this.focusViews.add(valueOf4);
            this.focusViews.add(valueOf3);
            this.focusViews.add(valueOf2);
            this.focusViews.add(valueOf);
        } else {
            View view = this.viewAndroidVolume;
            if (view == null || view.getVisibility() != 0) {
                View view2 = this.viewOemVolume;
                if (view2 == null || view2.getVisibility() != 0) {
                    this.focusViews.add(Integer.valueOf(R.id.btnAndroidVolume));
                    this.focusViews.add(Integer.valueOf(R.id.btnOemVolume));
                } else {
                    this.focusViews.add(valueOf2);
                    this.focusViews.add(valueOf);
                }
            } else {
                this.focusViews.add(valueOf4);
                this.focusViews.add(valueOf3);
            }
        }
        this.focusUtil.addViewIds(this.focusViews);
    }

    /* access modifiers changed from: private */
    public void setScrollEnable(boolean z) {
        ScrollView scrollView = this.mScrollView;
        if (scrollView instanceof MyScrollView) {
            ((MyScrollView) scrollView).setScrollAble(z);
        }
    }
}
