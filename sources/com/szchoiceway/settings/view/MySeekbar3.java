package com.szchoiceway.settings.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.zxwlib.bean.Customer;

public class MySeekbar3 extends View {
    private static final String TAG = "MySeekbar3";
    private int mCurProgress = 0;
    private int mHeight = 0;
    private int mMaxProgress = 40;
    private int mMeasureHeight = 0;
    private int mMeasureWidth = 0;
    private int mMinProgress = 0;
    private Paint mPaint;
    private Path mPath;
    public OnSeekListener mSeekListener;
    private int mWidth = 0;
    float mX = 0.0f;
    private Bitmap myProgress = null;
    private Bitmap myProgressBackground = null;
    private Bitmap myThumb = null;
    private String resolution = "1920x720";
    private Bitmap scaleBg = null;
    private Bitmap scaleProgress = null;
    private int thumbWidth = 0;
    private float topOffset = 30.0f;
    private int totalWidth = 0;

    public interface OnSeekListener {
        void onSeekStop(int i);

        void onSeekTouch();

        void onSeeking(int i);
    }

    public MySeekbar3(Context context) {
        super(context);
    }

    public MySeekbar3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MySeekbar3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Log.d(TAG, "init");
        this.resolution = SysProviderOpt.getInstance(context).getRecordValue("KSW_UI_RESOLUTION", "1920x720");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MySeekbar3);
        this.myProgressBackground = ((BitmapDrawable) obtainStyledAttributes.getDrawable(4)).getBitmap();
        this.myProgress = ((BitmapDrawable) obtainStyledAttributes.getDrawable(3)).getBitmap();
        if (obtainStyledAttributes.getDrawable(5) != null) {
            this.myThumb = ((BitmapDrawable) obtainStyledAttributes.getDrawable(5)).getBitmap();
        }
        this.mMinProgress = obtainStyledAttributes.getInt(2, 0);
        this.mMaxProgress = obtainStyledAttributes.getInt(1, 40);
        this.mCurProgress = obtainStyledAttributes.getInt(0, 20);
        obtainStyledAttributes.recycle();
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        setCurrentProgress(this.mCurProgress);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mMeasureWidth = i;
        this.mMeasureHeight = i2;
        setMeasuredDimension(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        scaleViews();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.myProgressBackground != null) {
            float height = (((float) (getHeight() - this.myProgressBackground.getHeight())) * 1.0f) / 2.0f;
            this.topOffset = height;
            canvas.drawBitmap(this.myProgressBackground, ((float) this.thumbWidth) * 0.5f, height, this.mPaint);
        }
        float f = ((((float) this.mCurProgress) * 1.0f) / ((float) this.mMaxProgress)) * ((float) this.totalWidth);
        if (this.myProgress != null) {
            canvas.save();
            this.mPath.reset();
            this.mPath.moveTo(0.0f, 0.0f);
            this.mPath.lineTo(f, 0.0f);
            this.mPath.lineTo(f, (float) getHeight());
            this.mPath.lineTo(0.0f, (float) getHeight());
            this.mPath.lineTo(0.0f, 0.0f);
            canvas.clipPath(this.mPath);
            canvas.drawBitmap(this.myProgress, ((float) this.thumbWidth) * 0.5f, this.topOffset, this.mPaint);
            canvas.restore();
        }
        if (this.myThumb != null) {
            float height2 = (((float) (getHeight() - this.myThumb.getHeight())) * 1.0f) / 2.0f;
            this.topOffset = height2;
            canvas.drawBitmap(this.myThumb, f, height2, this.mPaint);
        }
    }

    private void scaleViews() {
        int i;
        int i2;
        Matrix matrix = new Matrix();
        this.totalWidth = this.mWidth;
        if (this.myThumb != null) {
            if (Customer.isSmallResolution(this.mContext)) {
                matrix.setScale(0.7f, 0.7f);
                Bitmap bitmap = this.myThumb;
                this.myThumb = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.myThumb.getHeight(), matrix, true);
            }
            int width = this.myThumb.getWidth();
            this.thumbWidth = width;
            this.totalWidth = this.mWidth - width;
        }
        Bitmap bitmap2 = this.myProgress;
        if (!(bitmap2 == null || bitmap2.getWidth() == (i2 = this.totalWidth))) {
            matrix.reset();
            matrix.setScale((((float) i2) * 1.0f) / ((float) this.myProgress.getWidth()), 1.0f);
            Bitmap bitmap3 = this.myProgress;
            this.scaleProgress = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.myProgress.getHeight(), matrix, true);
        }
        Bitmap bitmap4 = this.myProgressBackground;
        if (bitmap4 != null && bitmap4.getWidth() != (i = this.totalWidth)) {
            matrix.reset();
            matrix.setScale((((float) i) * 1.0f) / ((float) this.myProgressBackground.getWidth()), 1.0f);
            Bitmap bitmap5 = this.myProgressBackground;
            this.scaleBg = Bitmap.createBitmap(bitmap5, 0, 0, bitmap5.getWidth(), this.myProgressBackground.getHeight(), matrix, true);
        }
    }

    public void setCurrentProgress(int i) {
        this.mCurProgress = i;
        postInvalidate();
    }

    public void setCurrentProgressStop(int i) {
        OnSeekListener onSeekListener = this.mSeekListener;
        if (onSeekListener != null) {
            onSeekListener.onSeekStop(i);
        }
        this.mCurProgress = i;
        postInvalidate();
    }

    public int getMaxProgress() {
        return this.mMaxProgress;
    }

    public int getMinProgress() {
        return this.mMinProgress;
    }

    public int getCurrentProgress() {
        return this.mCurProgress;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r0 != 3) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = 1
            r2 = 1077936128(0x40400000, float:3.0)
            if (r0 == 0) goto L_0x00a1
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r0 == r1) goto L_0x0064
            r4 = 2
            if (r0 == r4) goto L_0x0015
            r6 = 3
            if (r0 == r6) goto L_0x0064
            goto L_0x00b4
        L_0x0015:
            float r6 = r6.getX()
            r5.mX = r6
            r0 = 0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00b4
            int r0 = r5.getWidth()
            float r0 = (float) r0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 < 0) goto L_0x0031
            int r6 = r5.getWidth()
            float r6 = (float) r6
            r5.mX = r6
            goto L_0x0039
        L_0x0031:
            float r6 = r5.mX
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0039
            r5.mX = r2
        L_0x0039:
            float r6 = r5.mX
            int r0 = r5.mMaxProgress
            float r0 = (float) r0
            float r6 = r6 * r0
            float r6 = r6 * r3
            int r0 = r5.getWidth()
            float r0 = (float) r0
            float r6 = r6 / r0
            int r0 = r5.mMinProgress
            float r2 = (float) r0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x004e
            float r6 = (float) r0
        L_0x004e:
            int r0 = r5.mMaxProgress
            float r2 = (float) r0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0056
            float r6 = (float) r0
        L_0x0056:
            int r0 = r5.mCurProgress
            int r6 = (int) r6
            if (r0 == r6) goto L_0x00b4
            r5.setCurrentProgress(r6)
            com.szchoiceway.settings.view.MySeekbar3$OnSeekListener r0 = r5.mSeekListener
            r0.onSeeking(r6)
            goto L_0x00b4
        L_0x0064:
            com.szchoiceway.settings.view.MySeekbar3$OnSeekListener r6 = r5.mSeekListener
            if (r6 == 0) goto L_0x00b4
            float r6 = r5.mX
            int r0 = r5.getWidth()
            float r0 = (float) r0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x007a
            int r6 = r5.getWidth()
            float r6 = (float) r6
            r5.mX = r6
        L_0x007a:
            float r6 = r5.mX
            int r0 = r5.mMaxProgress
            float r0 = (float) r0
            float r6 = r6 * r0
            float r6 = r6 * r3
            int r0 = r5.getWidth()
            float r0 = (float) r0
            float r6 = r6 / r0
            int r0 = r5.mMinProgress
            float r2 = (float) r0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x008f
            float r6 = (float) r0
        L_0x008f:
            int r0 = r5.mMaxProgress
            float r2 = (float) r0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0097
            float r6 = (float) r0
        L_0x0097:
            int r6 = (int) r6
            r5.setCurrentProgress(r6)
            com.szchoiceway.settings.view.MySeekbar3$OnSeekListener r0 = r5.mSeekListener
            r0.onSeekStop(r6)
            goto L_0x00b4
        L_0x00a1:
            float r6 = r6.getX()
            r5.mX = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x00ad
            r5.mX = r2
        L_0x00ad:
            com.szchoiceway.settings.view.MySeekbar3$OnSeekListener r6 = r5.mSeekListener
            if (r6 == 0) goto L_0x00b4
            r6.onSeekTouch()
        L_0x00b4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szchoiceway.settings.view.MySeekbar3.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnSeekListener(OnSeekListener onSeekListener) {
        this.mSeekListener = onSeekListener;
    }
}
