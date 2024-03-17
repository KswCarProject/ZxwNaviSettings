package com.szchoiceway.settings.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.szchoiceway.settings.R;

public class MySeekbar2 extends ImageView {
    private static final String TAG = "MySeekbar2";
    private Drawable drawable = null;
    private int mCurProgress = 12;
    private int mMaxProgress = 24;
    private int mMinProgress = 0;
    public OnSeekListener mSeekListener;
    float mX = 0.0f;
    private Bitmap myProgressBackground = null;

    public interface OnSeekListener {
        void onSeekStop(int i);

        void onSeekTouch();

        void onSeeking(int i);
    }

    public MySeekbar2(Context context) {
        super(context);
    }

    public MySeekbar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MySeekbar2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Log.d(TAG, "init");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MySeekbar2);
        this.drawable = obtainStyledAttributes.getDrawable(3);
        this.mMinProgress = obtainStyledAttributes.getInt(2, 0);
        this.mMaxProgress = obtainStyledAttributes.getInt(1, 24);
        this.mCurProgress = obtainStyledAttributes.getInt(0, 12);
        obtainStyledAttributes.recycle();
        setImageDrawable(this.drawable);
        setCurrentProgress(this.mCurProgress);
    }

    public void setCurrentProgress(int i) {
        this.mCurProgress = i;
        setImageLevel(i);
        postInvalidate();
    }

    public void setCurrentProgressStop(int i) {
        OnSeekListener onSeekListener = this.mSeekListener;
        if (onSeekListener != null) {
            onSeekListener.onSeekStop(i);
        }
        this.mCurProgress = i;
        setImageLevel(i);
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

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r0 != 3) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getAction()
            r1 = 1
            r2 = 1077936128(0x40400000, float:3.0)
            if (r0 == 0) goto L_0x00a1
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 1103101952(0x41c00000, float:24.0)
            r5 = 0
            if (r0 == r1) goto L_0x0064
            r6 = 2
            if (r0 == r6) goto L_0x0018
            r8 = 3
            if (r0 == r8) goto L_0x0064
            goto L_0x00b4
        L_0x0018:
            float r8 = r8.getX()
            r7.mX = r8
            int r0 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b4
            int r0 = r7.getWidth()
            float r0 = (float) r0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 < 0) goto L_0x0033
            int r8 = r7.getWidth()
            float r8 = (float) r8
            r7.mX = r8
            goto L_0x003b
        L_0x0033:
            float r8 = r7.mX
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x003b
            r7.mX = r2
        L_0x003b:
            float r8 = r7.mX
            int r0 = r7.mMaxProgress
            float r0 = (float) r0
            float r8 = r8 * r0
            float r8 = r8 * r3
            int r0 = r7.getWidth()
            float r0 = (float) r0
            float r8 = r8 / r0
            int r0 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r5 = r8
        L_0x004e:
            int r8 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r4 = r5
        L_0x0054:
            int r8 = r7.mCurProgress
            int r0 = (int) r4
            if (r8 == r0) goto L_0x00b4
            r7.setCurrentProgress(r0)
            com.szchoiceway.settings.view.MySeekbar2$OnSeekListener r8 = r7.mSeekListener
            if (r8 == 0) goto L_0x00b4
            r8.onSeeking(r0)
            goto L_0x00b4
        L_0x0064:
            com.szchoiceway.settings.view.MySeekbar2$OnSeekListener r8 = r7.mSeekListener
            if (r8 == 0) goto L_0x00b4
            float r8 = r7.mX
            int r0 = r7.getWidth()
            float r0 = (float) r0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 <= 0) goto L_0x007a
            int r8 = r7.getWidth()
            float r8 = (float) r8
            r7.mX = r8
        L_0x007a:
            float r8 = r7.mX
            int r0 = r7.mMaxProgress
            float r0 = (float) r0
            float r8 = r8 * r0
            float r8 = r8 * r3
            int r0 = r7.getWidth()
            float r0 = (float) r0
            float r8 = r8 / r0
            int r0 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r5 = r8
        L_0x008d:
            int r8 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r4 = r5
        L_0x0093:
            int r8 = r7.mCurProgress
            int r0 = (int) r4
            if (r8 == r0) goto L_0x009b
            r7.setCurrentProgress(r0)
        L_0x009b:
            com.szchoiceway.settings.view.MySeekbar2$OnSeekListener r8 = r7.mSeekListener
            r8.onSeekStop(r0)
            goto L_0x00b4
        L_0x00a1:
            float r8 = r8.getX()
            r7.mX = r8
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x00ad
            r7.mX = r2
        L_0x00ad:
            com.szchoiceway.settings.view.MySeekbar2$OnSeekListener r8 = r7.mSeekListener
            if (r8 == 0) goto L_0x00b4
            r8.onSeekTouch()
        L_0x00b4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szchoiceway.settings.view.MySeekbar2.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnSeekListener(OnSeekListener onSeekListener) {
        this.mSeekListener = onSeekListener;
    }
}
