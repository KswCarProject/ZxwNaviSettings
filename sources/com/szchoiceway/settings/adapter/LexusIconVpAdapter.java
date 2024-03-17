package com.szchoiceway.settings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.szchoiceway.settings.R;
import java.util.ArrayList;

public class LexusIconVpAdapter extends PagerAdapter {
    private ArrayList<View> views = new ArrayList<>();

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public LexusIconVpAdapter(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lexus_icons_pager1, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.lexus_icons_pager2, (ViewGroup) null);
        this.views.add(inflate);
        this.views.add(inflate2);
    }

    public int getCount() {
        return this.views.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.views.get(i));
        return this.views.get(i);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.views.get(i));
    }
}
