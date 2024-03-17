package com.szchoiceway.settings.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ScrollView;
import com.szchoiceway.settings.R;

public class ClipScrollView extends ScrollView {
    private static final String TAG = "ClipScrollView";
    private Paint paint;
    private Path path;
    private int radius = 20;
    private float scrollHeight = 0.0f;

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public ClipScrollView(Context context) {
        super(context);
        init(context);
    }

    public ClipScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ClipScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.radius = (int) context.getResources().getDimension(R.dimen.clip_scroll_radius);
        this.path = new Path();
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.paint.setColor(0);
        setLayerType(1, (Paint) null);
    }

    public void setScrollHeight(int i) {
        this.scrollHeight = (float) i;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.path.reset();
        this.path.moveTo((float) this.radius, 0.0f);
        this.path.quadTo(0.0f, 0.0f, 0.0f, (float) this.radius);
        this.path.lineTo(0.0f, (((float) getHeight()) + this.scrollHeight) - ((float) this.radius));
        this.path.quadTo(0.0f, ((float) getHeight()) + this.scrollHeight, (float) this.radius, ((float) getHeight()) + this.scrollHeight);
        this.path.lineTo((float) getWidth(), ((float) getHeight()) + this.scrollHeight);
        this.path.lineTo((float) getWidth(), 0.0f);
        this.path.lineTo((float) this.radius, 0.0f);
        canvas.clipPath(this.path);
        canvas.drawPaint(this.paint);
    }
}
