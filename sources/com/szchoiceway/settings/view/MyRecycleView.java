package com.szchoiceway.settings.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewOverlay;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.szchoiceway.settings.R;

public class MyRecycleView extends RecyclerView {
    private static final String TAG = "MyRecycleView";
    private float itemHeight;
    private LinearLayoutManager manager;
    private int topPosition = 0;

    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public MyRecycleView(Context context) {
        super(context);
        init(context);
    }

    public MyRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MyRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.itemHeight = context.getResources().getDimension(R.dimen.landrover_main_item_height);
    }

    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
            this.manager = linearLayoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPositionWithOffset(this.topPosition, 0);
            }
        }
    }

    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        this.topPosition = Math.round((((float) computeVerticalScrollOffset()) * 1.0f) / this.itemHeight);
    }

    public int getTopPosition() {
        return this.topPosition;
    }
}
