package com.szchoiceway.settings;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.szchoiceway.zxwlib.utils.MultipleUtils;

public class BaseActivity extends FragmentActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setDensity(getApplication(), this);
    }

    public static void setDensity(Application application, Activity activity) {
        MultipleUtils.setCustomDensity(activity, application);
    }
}
