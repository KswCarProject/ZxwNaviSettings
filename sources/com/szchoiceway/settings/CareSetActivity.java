package com.szchoiceway.settings;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.Window;
import android.widget.TextView;
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.settings.view.MySeekbar3;
import com.szchoiceway.zxwlib.bean.Customer;
import com.szchoiceway.zxwlib.utils.MultipleUtils;

public class CareSetActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public SysProviderOpt mProvider;
    /* access modifiers changed from: private */
    public int oilValue = 0;
    private MySeekbar3 seekbarOil;
    private MySeekbar3 seekbarSpeed;
    /* access modifiers changed from: private */
    public int speedValue = 0;
    /* access modifiers changed from: private */
    public TextView tvValueOil;
    /* access modifiers changed from: private */
    public TextView tvValueSpeed;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MultipleUtils.setCustomDensity(this, getApplication());
        SysProviderOpt instance = SysProviderOpt.getInstance(this);
        this.mProvider = instance;
        this.oilValue = instance.getRecordInteger(SysProviderOpt.KSE_TXZ_WARING_VALUE_OIL, 8);
        this.speedValue = this.mProvider.getRecordInteger(SysProviderOpt.KSE_TXZ_WARING_VALUE_SPEED, 200);
        transparentSystermTitleBar();
        if (Customer.isSmallResolution(this)) {
            setContentView(R.layout.small_activity_care_set);
        } else {
            setContentView(R.layout.activity_care_set);
        }
        initView();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        sendModeTitle(EventUtils.eSrcMode.SRC_CARE_SET.getIntValue());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        sendModeTitle(EventUtils.eSrcMode.SRC_NULL.getIntValue());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        sendModeTitle(EventUtils.eSrcMode.SRC_NULL.getIntValue());
    }

    private void initView() {
        this.tvValueOil = (TextView) findViewById(R.id.valueOil);
        this.tvValueSpeed = (TextView) findViewById(R.id.valueSpeed);
        this.seekbarOil = (MySeekbar3) findViewById(R.id.seekbarOil);
        this.seekbarSpeed = (MySeekbar3) findViewById(R.id.seekbarSpeed);
        TextView textView = this.tvValueOil;
        if (textView != null) {
            textView.setText("" + this.oilValue);
        }
        MySeekbar3 mySeekbar3 = this.seekbarOil;
        if (mySeekbar3 != null) {
            mySeekbar3.setCurrentProgress(this.oilValue);
            this.seekbarOil.setOnSeekListener(new MySeekbar3.OnSeekListener() {
                public void onSeekTouch() {
                }

                public void onSeeking(int i) {
                    if (CareSetActivity.this.tvValueOil != null) {
                        CareSetActivity.this.tvValueOil.setText("" + i);
                    }
                }

                public void onSeekStop(int i) {
                    if (CareSetActivity.this.tvValueOil != null) {
                        CareSetActivity.this.tvValueOil.setText("" + i);
                    }
                    int unused = CareSetActivity.this.oilValue = i;
                    CareSetActivity.this.mProvider.updateRecord(SysProviderOpt.KSE_TXZ_WARING_VALUE_OIL, "" + CareSetActivity.this.oilValue);
                    CareSetActivity.this.kesaiwei_sendBroadcast(65);
                }
            });
        }
        TextView textView2 = this.tvValueSpeed;
        if (textView2 != null) {
            textView2.setText("" + this.speedValue);
        }
        MySeekbar3 mySeekbar32 = this.seekbarSpeed;
        if (mySeekbar32 != null) {
            mySeekbar32.setCurrentProgress(this.speedValue);
            this.seekbarSpeed.setOnSeekListener(new MySeekbar3.OnSeekListener() {
                public void onSeekTouch() {
                }

                public void onSeeking(int i) {
                    if (CareSetActivity.this.tvValueSpeed != null) {
                        CareSetActivity.this.tvValueSpeed.setText("" + i);
                    }
                }

                public void onSeekStop(int i) {
                    if (CareSetActivity.this.tvValueSpeed != null) {
                        CareSetActivity.this.tvValueSpeed.setText("" + i);
                    }
                    int unused = CareSetActivity.this.speedValue = i;
                    CareSetActivity.this.mProvider.updateRecord(SysProviderOpt.KSE_TXZ_WARING_VALUE_SPEED, "" + CareSetActivity.this.speedValue);
                    CareSetActivity.this.kesaiwei_sendBroadcast(65);
                }
            });
        }
    }

    public void sendModeTitle(int i) {
        Intent intent = new Intent("com.szchoiceway.action.mode_title_change");
        intent.putExtra("com.szchoiceway.action.mode_title_change_extra", i);
        intent.putExtra("com.szchoiceway.action.mode_title_change_screen_extra", true);
        sendBroadcastAsUser(intent, UserHandle.ALL);
    }

    private void transparentSystermTitleBar() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 256 | 1024);
        window.setStatusBarColor(0);
    }

    /* access modifiers changed from: private */
    public void kesaiwei_sendBroadcast(int i) {
        Intent intent = new Intent(EventUtils.ZXW_SENDBROADCAST8902MOD);
        intent.putExtra(EventUtils.ZXW_SENDBROADCAST8902MOD_EXTRA, i);
        sendBroadcast(intent);
    }
}
