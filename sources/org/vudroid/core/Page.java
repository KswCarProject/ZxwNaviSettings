package org.vudroid.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;

class Page {
    private float aspectRatio;
    RectF bounds;
    private DocumentView documentView;
    private final Paint fillPaint = fillPaint();
    final int index;
    private PageTreeNode node;
    private final Paint strokePaint = strokePaint();
    private final TextPaint textPaint = textPaint();

    Page(DocumentView documentView2, int i) {
        this.documentView = documentView2;
        this.index = i;
        this.node = new PageTreeNode(documentView2, new RectF(0.0f, 0.0f, 1.0f, 1.0f), this, 1, (PageTreeNode) null);
    }

    /* access modifiers changed from: package-private */
    public float getPageHeight(int i, float f) {
        return (((float) i) / getAspectRatio()) * f;
    }

    public int getTop() {
        return Math.round(this.bounds.top);
    }

    public void draw(Canvas canvas) {
        if (isVisible()) {
            canvas.drawRect(this.bounds, this.fillPaint);
            canvas.drawText("Page " + (this.index + 1), this.bounds.centerX(), this.bounds.centerY(), this.textPaint);
            this.node.draw(canvas);
            Canvas canvas2 = canvas;
            canvas2.drawLine(this.bounds.left, this.bounds.top, this.bounds.right, this.bounds.top, this.strokePaint);
            canvas2.drawLine(this.bounds.left, this.bounds.bottom, this.bounds.right, this.bounds.bottom, this.strokePaint);
        }
    }

    private Paint strokePaint() {
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    private Paint fillPaint() {
        Paint paint = new Paint();
        paint.setColor(-7829368);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private TextPaint textPaint() {
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        textPaint2.setAntiAlias(true);
        textPaint2.setTextSize(24.0f);
        textPaint2.setTextAlign(Paint.Align.CENTER);
        return textPaint2;
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public void setAspectRatio(float f) {
        if (this.aspectRatio != f) {
            this.aspectRatio = f;
            this.documentView.invalidatePageSizes();
        }
    }

    public boolean isVisible() {
        return RectF.intersects(this.documentView.getViewRect(), this.bounds);
    }

    public void setAspectRatio(int i, int i2) {
        setAspectRatio((((float) i) * 1.0f) / ((float) i2));
    }

    /* access modifiers changed from: package-private */
    public void setBounds(RectF rectF) {
        this.bounds = rectF;
        this.node.invalidateNodeBounds();
    }

    public void updateVisibility() {
        this.node.updateVisibility();
    }

    public void invalidate() {
        this.node.invalidate();
    }
}
