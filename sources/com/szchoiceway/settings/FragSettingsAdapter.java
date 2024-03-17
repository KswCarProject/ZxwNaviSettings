package com.szchoiceway.settings;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class FragSettingsAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list;

    public FragSettingsAdapter(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
        super(fragmentManager);
        this.list = arrayList;
    }

    public int getCount() {
        return this.list.size();
    }

    public Fragment getItem(int i) {
        return this.list.get(i);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }
}
