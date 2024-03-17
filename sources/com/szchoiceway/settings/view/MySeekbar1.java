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
import com.szchoiceway.eventcenter.EventUtils;
import com.szchoiceway.settings.BaseApp;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;

public class MySeekbar1 extends View {
    private static final String TAG = "MySeekbar";
    private int cutHeight = 23;
    private int cutWidth = 45;
    private int mCurProgress = 0;
    private boolean mEnable = true;
    private int mHeight = 0;
    private int mMaxProgress = 40;
    private int mMeasureHeight = 0;
    private int mMeasureWidth = 0;
    private int mMinProgress = 0;
    Paint mPaint;
    Path mPath;
    public OnSeekListener mSeekListener;
    private int mWidth = 0;
    float mX = 0.0f;
    private int m_iModeSet = 0;
    private int m_iUIIndex = 0;
    private Bitmap myProgress = null;
    private Bitmap myProgressBackground = null;
    private Bitmap myThumb = null;
    private String resolution = "1920x720";
    private Bitmap scaleBg = null;
    private Bitmap scaleProgress = null;

    public interface OnSeekListener {
        void onSeekStop(int i);

        void onSeekTouch();

        void onSeeking(int i);
    }

    public MySeekbar1(Context context) {
        super(context);
    }

    public MySeekbar1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MySeekbar1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Log.d(TAG, "init");
        this.m_iUIIndex = BaseApp.m_iUIIndex;
        this.resolution = SysProviderOpt.getInstance(context).getRecordValue("KSW_UI_RESOLUTION", "1920x720");
        this.m_iModeSet = SysProviderOpt.getInstance(context).getRecordInteger("KESAIWEI_SYS_MODE_SELECTION", this.m_iModeSet);
        if ("1280x480".equalsIgnoreCase(this.resolution) || "1440x540".equalsIgnoreCase(this.resolution)) {
            this.cutWidth = 48;
        } else {
            this.cutWidth = 45;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MySeekbar1);
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
        int i;
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        if (!(this.myProgress == null || (bitmap2 = this.scaleProgress) == null)) {
            this.myProgress = bitmap2;
        }
        if (!(this.myProgressBackground == null || (bitmap = this.scaleBg) == null)) {
            this.myProgressBackground = bitmap;
        }
        int i2 = this.m_iUIIndex;
        if (i2 == 2) {
            Bitmap bitmap3 = this.myProgressBackground;
            if (bitmap3 != null) {
                canvas.drawBitmap(bitmap3, (float) EventUtils.pxToDp(this.mContext, -8), (float) EventUtils.pxToDp(this.mContext, 40), this.mPaint);
            }
            float f = (((float) (this.mCurProgress * width)) * 1.0f) / ((float) this.mMaxProgress);
            if (this.myProgress != null) {
                canvas.save();
                Path path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.lineTo(f - ((float) EventUtils.pxToDp(this.mContext, 6)), 0.0f);
                float f2 = (float) height;
                path.lineTo(f - ((float) EventUtils.pxToDp(this.mContext, this.cutWidth)), f2);
                path.lineTo(0.0f, f2);
                path.lineTo(0.0f, 0.0f);
                canvas.clipPath(path);
                canvas.drawBitmap(this.myProgress, 0.0f, (float) EventUtils.pxToDp(this.mContext, 40), this.mPaint);
                canvas.restore();
            }
            Bitmap bitmap4 = this.myThumb;
            if (bitmap4 != null) {
                canvas.drawBitmap(bitmap4, f - ((float) bitmap4.getWidth()), (float) EventUtils.pxToDp(this.mContext, 40), this.mPaint);
            }
        } else if (i2 == 6 || i2 == 1 || this.m_iModeSet >= 100) {
            float f3 = 30.0f;
            if (this.myProgressBackground != null) {
                f3 = (((float) (getHeight() - this.myProgressBackground.getHeight())) * 1.0f) / 2.0f;
                canvas.drawBitmap(this.myProgressBackground, 0.0f, f3, this.mPaint);
            }
            float width2 = (((float) (this.mCurProgress * getWidth())) * 1.0f) / ((float) this.mMaxProgress);
            if (this.myProgress != null) {
                canvas.save();
                this.mPath.reset();
                this.mPath.moveTo(0.0f, 0.0f);
                this.mPath.lineTo(width2, 0.0f);
                this.mPath.lineTo(width2, (float) getHeight());
                this.mPath.lineTo(0.0f, (float) getHeight());
                this.mPath.lineTo(0.0f, 0.0f);
                canvas.clipPath(this.mPath);
                canvas.drawBitmap(this.myProgress, 0.0f, f3, this.mPaint);
                canvas.restore();
            }
        } else if (i2 == 4 || i2 == 7) {
            if (this.myProgress != null && this.myProgressBackground != null) {
                Bitmap bitmap5 = this.myThumb;
                int i3 = 0;
                if (bitmap5 == null) {
                    i = 0;
                } else {
                    int width3 = bitmap5.getWidth();
                    i3 = this.myThumb.getHeight();
                    i = width3;
                }
                float height2 = (((float) (height - this.myProgress.getHeight())) * 1.0f) / 2.0f;
                float f4 = (((float) (height - i3)) * 1.0f) / 2.0f;
                float f5 = (float) i;
                float f6 = (f5 * 1.0f) / 2.0f;
                float f7 = (((float) (this.mCurProgress * (width - i))) * 1.0f) / ((float) this.mMaxProgress);
                canvas.save();
                this.mPath.reset();
                float f8 = f5 + f7;
                this.mPath.moveTo(f8, 0.0f);
                float f9 = (float) width;
                this.mPath.lineTo(f9, 0.0f);
                float f10 = (float) height;
                this.mPath.lineTo(f9, f10);
                this.mPath.lineTo(f8, f10);
                this.mPath.lineTo(f8, 0.0f);
                canvas.clipPath(this.mPath);
                canvas.drawBitmap(this.myProgressBackground, f6, height2, this.mPaint);
                canvas.restore();
                canvas.save();
                this.mPath.reset();
                this.mPath.moveTo(0.0f, 0.0f);
                if (this.m_iUIIndex == 7) {
                    float f11 = f7 + f6;
                    this.mPath.lineTo(f11, 0.0f);
                    this.mPath.lineTo(f11, f10);
                } else {
                    this.mPath.lineTo(f7, 0.0f);
                    this.mPath.lineTo(f7, f10);
                }
                this.mPath.lineTo(0.0f, f10);
                this.mPath.lineTo(0.0f, 0.0f);
                canvas.clipPath(this.mPath);
                canvas.drawBitmap(this.myProgress, f6, height2, this.mPaint);
                canvas.restore();
                Bitmap bitmap6 = this.myThumb;
                if (bitmap6 != null) {
                    canvas.drawBitmap(bitmap6, f7, f4, this.mPaint);
                }
            }
        } else if (i2 == 5) {
            this.mPath.reset();
            Bitmap bitmap7 = this.myThumb;
            if (bitmap7 != null && this.myProgress != null && this.myProgressBackground != null) {
                float width4 = (float) (bitmap7.getWidth() / 2);
                float width5 = ((((float) (this.mCurProgress * (width - this.myThumb.getWidth()))) * 1.0f) / ((float) this.mMaxProgress)) + width4;
                float height3 = (float) ((height - this.myProgressBackground.getHeight()) / 2);
                canvas.drawBitmap(this.myProgressBackground, width4, height3, this.mPaint);
                canvas.save();
                this.mPath.moveTo(0.0f, 0.0f);
                this.mPath.lineTo(width5, 0.0f);
                float f12 = (float) height;
                this.mPath.lineTo(width5, f12);
                this.mPath.lineTo(0.0f, f12);
                this.mPath.lineTo(0.0f, 0.0f);
                canvas.clipPath(this.mPath);
                canvas.drawBitmap(this.myProgress, width4, height3, this.mPaint);
                canvas.restore();
                canvas.drawBitmap(this.myThumb, width5 - width4, (float) ((height - this.myThumb.getHeight()) / 2), this.mPaint);
            }
        }
    }

    private void scaleViews() {
        int i;
        Matrix matrix = new Matrix();
        int i2 = this.m_iModeSet;
        if (i2 == 32 || (i = this.m_iUIIndex) == 6 || i == 1 || i2 >= 100 || i == 4) {
            int i3 = this.mWidth;
            Bitmap bitmap = this.myThumb;
            if (bitmap != null) {
                i3 -= bitmap.getWidth();
            }
            int i4 = i3;
            Bitmap bitmap2 = this.myProgress;
            if (!(bitmap2 == null || bitmap2.getWidth() == i4)) {
                matrix.setScale((((float) i4) * 1.0f) / ((float) this.myProgress.getWidth()), 1.0f);
                Bitmap bitmap3 = this.myProgress;
                this.scaleProgress = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.myProgress.getHeight(), matrix, true);
            }
            Bitmap bitmap4 = this.myProgressBackground;
            if (bitmap4 != null && bitmap4.getWidth() != i4) {
                matrix.setScale((((float) i4) * 1.0f) / ((float) this.myProgressBackground.getWidth()), 1.0f);
                Bitmap bitmap5 = this.myProgressBackground;
                this.scaleBg = Bitmap.createBitmap(bitmap5, 0, 0, bitmap5.getWidth(), this.myProgressBackground.getHeight(), matrix, true);
            }
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

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r0 != 3) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.mEnable
            r1 = 1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r6.getAction()
            r2 = 1077936128(0x40400000, float:3.0)
            if (r0 == 0) goto L_0x00a8
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r0 == r1) goto L_0x006b
            r4 = 2
            if (r0 == r4) goto L_0x001a
            r6 = 3
            if (r0 == r6) goto L_0x006b
            goto L_0x00bb
        L_0x001a:
            float r6 = r6.getX()
            r5.mX = r6
            r0 = 0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00bb
            int r0 = r5.getWidth()
            float r0 = (float) r0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 < 0) goto L_0x0036
            int r6 = r5.getWidth()
            float r6 = (float) r6
            r5.mX = r6
            goto L_0x003e
        L_0x0036:
            float r6 = r5.mX
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x003e
            r5.mX = r2
        L_0x003e:
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
            if (r2 >= 0) goto L_0x0053
            float r6 = (float) r0
        L_0x0053:
            int r0 = r5.mMaxProgress
            float r2 = (float) r0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x005b
            float r6 = (float) r0
        L_0x005b:
            int r0 = r5.mCurProgress
            int r6 = (int) r6
            if (r0 == r6) goto L_0x00bb
            r5.setCurrentProgress(r6)
            com.szchoiceway.settings.view.MySeekbar1$OnSeekListener r0 = r5.mSeekListener
            if (r0 == 0) goto L_0x00bb
            r0.onSeeking(r6)
            goto L_0x00bb
        L_0x006b:
            com.szchoiceway.settings.view.MySeekbar1$OnSeekListener r6 = r5.mSeekListener
            if (r6 == 0) goto L_0x00bb
            float r6 = r5.mX
            int r0 = r5.getWidth()
            float r0 = (float) r0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x0081
            int r6 = r5.getWidth()
            float r6 = (float) r6
            r5.mX = r6
        L_0x0081:
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
            if (r2 >= 0) goto L_0x0096
            float r6 = (float) r0
        L_0x0096:
            int r0 = r5.mMaxProgress
            float r2 = (float) r0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x009e
            float r6 = (float) r0
        L_0x009e:
            int r6 = (int) r6
            r5.setCurrentProgress(r6)
            com.szchoiceway.settings.view.MySeekbar1$OnSeekListener r0 = r5.mSeekListener
            r0.onSeekStop(r6)
            goto L_0x00bb
        L_0x00a8:
            float r6 = r6.getX()
            r5.mX = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x00b4
            r5.mX = r2
        L_0x00b4:
            com.szchoiceway.settings.view.MySeekbar1$OnSeekListener r6 = r5.mSeekListener
            if (r6 == 0) goto L_0x00bb
            r6.onSeekTouch()
        L_0x00bb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szchoiceway.settings.view.MySeekbar1.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnSeekListener(OnSeekListener onSeekListener) {
        this.mSeekListener = onSeekListener;
    }
}
