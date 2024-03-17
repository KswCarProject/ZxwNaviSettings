package com.szchoiceway.settings.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.ViewOverlay;
import androidx.recyclerview.widget.RecyclerView;
import com.szchoiceway.settings.R;

public class ClipRecyclerView extends RecyclerView {
    private static final String TAG = "ClipRecyclerView";
    private float bottomLeftRadius = 0.0f;
    private float bottomRightRadius = 0.0f;
    private Paint mPaint;
    private Path mPath;
    private float topLeftRadius = 0.0f;
    private float topRightRadius = 0.0f;

    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public ClipRecyclerView(Context context) {
        super(context);
    }

    public ClipRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ClipRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClipRecyclerView);
        this.topLeftRadius = obtainStyledAttributes.getDimension(2, 0.0f);
        this.topRightRadius = obtainStyledAttributes.getDimension(3, 0.0f);
        this.bottomLeftRadius = obtainStyledAttributes.getDimension(0, 0.0f);
        this.bottomRightRadius = obtainStyledAttributes.getDimension(1, 0.0f);
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        obtainStyledAttributes.recycle();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPath.reset();
        float f = this.topLeftRadius;
        if (f > 0.0f) {
            this.mPath.moveTo(f, 0.0f);
            this.mPath.quadTo(0.0f, 0.0f, 0.0f, this.topLeftRadius);
        } else {
            this.mPath.moveTo(0.0f, 0.0f);
        }
        if (this.bottomLeftRadius > 0.0f) {
            this.mPath.lineTo(0.0f, ((float) getHeight()) - this.bottomLeftRadius);
            this.mPath.quadTo(0.0f, (float) getHeight(), this.bottomLeftRadius, (float) getHeight());
        } else {
            this.mPath.lineTo(0.0f, (float) getHeight());
        }
        if (this.bottomRightRadius > 0.0f) {
            this.mPath.lineTo(((float) getWidth()) - this.bottomRightRadius, (float) getHeight());
            this.mPath.quadTo((float) getWidth(), (float) getHeight(), (float) getWidth(), ((float) getHeight()) - this.bottomRightRadius);
        } else {
            this.mPath.lineTo((float) getWidth(), (float) getHeight());
        }
        if (this.topRightRadius > 0.0f) {
            this.mPath.lineTo((float) getWidth(), this.topRightRadius);
            this.mPath.quadTo((float) getWidth(), 0.0f, ((float) getWidth()) - this.topRightRadius, 0.0f);
        } else {
            this.mPath.lineTo((float) getWidth(), 0.0f);
        }
        float f2 = this.topLeftRadius;
        if (f2 > 0.0f) {
            this.mPath.lineTo(f2, 0.0f);
        } else {
            this.mPath.lineTo(0.0f, 0.0f);
        }
        canvas.clipPath(this.mPath);
        canvas.drawPaint(this.mPaint);
    }
}
