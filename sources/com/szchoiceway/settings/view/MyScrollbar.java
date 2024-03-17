package com.szchoiceway.settings.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.szchoiceway.settings.R;

public class MyScrollbar extends View {
    private static final String TAG = "MyScrollbar";
    private Bitmap barBitmap;
    private Drawable barDrawable;
    private int barHeight;
    private float currentPercent = 0.0f;
    private Context mContext;
    private int totalHeight;

    public MyScrollbar(Context context) {
        super(context);
    }

    public MyScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MyScrollbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        Drawable drawable = context.obtainStyledAttributes(attributeSet, R.styleable.MyScrollbar).getDrawable(0);
        this.barDrawable = drawable;
        if (drawable == null) {
            this.barDrawable = this.mContext.getResources().getDrawable(R.drawable.ksw_1920x720_evo_id8_settings_system_list_slider);
        }
        Bitmap bitmap = ((BitmapDrawable) this.barDrawable).getBitmap();
        this.barBitmap = bitmap;
        this.barHeight = bitmap.getHeight();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() - this.barHeight;
        this.totalHeight = height;
        canvas.drawBitmap(this.barBitmap, 0.0f, this.currentPercent * ((float) height), (Paint) null);
    }

    public void setCurrentPercent(float f) {
        this.currentPercent = f;
        postInvalidate();
    }
}
