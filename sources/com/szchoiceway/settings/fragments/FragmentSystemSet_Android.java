package com.szchoiceway.settings.fragments;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.szchoiceway.settings.FragmentBase;
import com.szchoiceway.settings.R;
import java.util.ArrayList;

public class FragmentSystemSet_Android extends FragmentBase implements View.OnClickListener {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_lexus_fragment_sys_set_android, viewGroup, false);
        inflate.findViewById(R.id.android_system_settings_tv).setOnClickListener(this);
        return inflate;
    }

    public void addViewIds() {
        super.addViewIds();
        this.focusUtil.addViewIds(new ArrayList<Integer>() {
            {
                add(Integer.valueOf(R.id.android_system_settings_tv));
            }
        });
    }

    public void onClick(View view) {
        startMoreSettings();
    }

    private void startMoreSettings() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings"));
        intent.setFlags(270532608);
        startActivity(intent);
    }
}
