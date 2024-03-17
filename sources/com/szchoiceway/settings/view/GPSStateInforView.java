package com.szchoiceway.settings.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.GnssStatus;
import android.util.AttributeSet;
import android.view.View;
import com.szchoiceway.settings.R;
import com.szchoiceway.zxwlib.GyroScopeWithCompassView;
import java.util.Random;

public class GPSStateInforView extends View {
    private static final String TAG = "GPSStateInforView";
    private static final int maxGpsSnrValue = 60;
    private static final int maxGpsStateCount = 12;
    private Bitmap bitmapD;
    private Bitmap bitmapF;
    private Bitmap bitmapN;
    private int drawableD;
    private int drawableF;
    private int drawableN;
    private int height = GyroScopeWithCompassView.CARTYPE_MALIBU_H_H;
    private int leftInterval = 8;
    private int mConstellationType = 1;
    private Paint mForePaint = new Paint();
    private GpsSateData[] mGpsData = new GpsSateData[12];
    private int mGpsState = 1;
    private boolean mHaveDrawable = false;
    private int mTextNumColor = -1;
    private float mTextSize = 16.0f;
    private int mUICategoryNum = 1;
    private RectF roundRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private Rect targetRect = new Rect(0, 0, 0, 0);
    private int width = 40;
    private int x = 1;
    private int y = 0;

    private class GpsSateData {
        boolean isValid;
        int prn;
        int snr;
        boolean usedInFixed;

        private GpsSateData() {
            this.prn = 0;
            this.snr = 0;
            this.usedInFixed = false;
            this.isValid = false;
        }
    }

    public GPSStateInforView(Context context) {
        super(context);
        init(context);
    }

    public GPSStateInforView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.gpsView);
        this.drawableN = obtainStyledAttributes.getResourceId(2, this.drawableN);
        this.drawableD = obtainStyledAttributes.getResourceId(0, this.drawableD);
        this.drawableF = obtainStyledAttributes.getResourceId(1, this.drawableF);
        this.width = (int) obtainStyledAttributes.getDimension(9, 40.0f);
        this.height = (int) obtainStyledAttributes.getDimension(5, 205.0f);
        this.leftInterval = (int) obtainStyledAttributes.getDimension(6, 205.0f);
        this.mConstellationType = obtainStyledAttributes.getInt(4, 1);
        this.mTextNumColor = obtainStyledAttributes.getColor(7, -1);
        this.mTextSize = obtainStyledAttributes.getDimension(8, 16.0f);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public GPSStateInforView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.gpsView);
        this.drawableN = obtainStyledAttributes.getResourceId(2, this.drawableN);
        this.drawableD = obtainStyledAttributes.getResourceId(0, this.drawableD);
        this.drawableF = obtainStyledAttributes.getResourceId(1, this.drawableF);
        this.width = (int) obtainStyledAttributes.getDimension(9, 40.0f);
        this.height = (int) obtainStyledAttributes.getDimension(5, 205.0f);
        this.leftInterval = (int) obtainStyledAttributes.getDimension(6, 205.0f);
        this.mConstellationType = obtainStyledAttributes.getInt(4, 1);
        this.mTextNumColor = obtainStyledAttributes.getColor(7, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setUICategoryNum(int i) {
        this.mUICategoryNum = i;
    }

    private void init(Context context) {
        this.mForePaint.setAntiAlias(true);
        this.mForePaint.setTextSize(12.0f);
        this.mForePaint.setTextAlign(Paint.Align.CENTER);
        for (int i = 0; i < 12; i++) {
            this.mGpsData[i] = new GpsSateData();
        }
        if (this.drawableN != 0) {
            this.mForePaint.setTextSize(this.mTextSize);
            this.mHaveDrawable = true;
            this.bitmapN = BitmapFactory.decodeResource(context.getResources(), this.drawableN);
            this.bitmapD = BitmapFactory.decodeResource(context.getResources(), this.drawableD);
            this.bitmapF = BitmapFactory.decodeResource(context.getResources(), this.drawableF);
            this.width = this.bitmapN.getWidth();
            this.height = this.bitmapN.getHeight();
            return;
        }
        this.mHaveDrawable = false;
    }

    public void setData(GnssStatus gnssStatus) {
        int i = 0;
        for (int i2 = 0; i2 < gnssStatus.getSatelliteCount(); i2++) {
            if (gnssStatus.getConstellationType(i2) == this.mConstellationType) {
                this.mGpsData[i].prn = gnssStatus.getSvid(i2);
                this.mGpsData[i].snr = (int) gnssStatus.getCn0DbHz(i2);
                this.mGpsData[i].usedInFixed = gnssStatus.usedInFix(i2);
                if (this.mGpsData[i].snr > 60) {
                    this.mGpsData[i].snr = 60;
                }
                this.mGpsData[i].isValid = true;
                i++;
                if (i >= 12) {
                    break;
                }
            }
        }
        while (i < 12) {
            this.mGpsData[i].isValid = false;
            this.mGpsData[i].usedInFixed = false;
            i++;
        }
        invalidate();
    }

    private void testData() {
        Random random = new Random(System.currentTimeMillis());
        int i = 0;
        while (i < 12) {
            int i2 = i + 1;
            this.mGpsData[i].prn = i2;
            this.mGpsData[i].snr = random.nextInt(60);
            this.mGpsData[i].isValid = true;
            i = i2;
        }
    }

    public void setGpsValidState(int i) {
        this.mGpsState = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        Paint.FontMetricsInt fontMetricsInt = this.mForePaint.getFontMetricsInt();
        for (int i = 0; i < 12; i++) {
            if (this.mHaveDrawable) {
                canvas2.drawBitmap(this.bitmapN, (float) ((this.leftInterval + this.width) * i), 0.0f, this.mForePaint);
                if (this.mGpsData[i].isValid) {
                    int i2 = (this.height * (60 - this.mGpsData[i].snr)) / 60;
                    if (this.mGpsData[i].usedInFixed) {
                        canvas.save();
                        int i3 = this.y;
                        int i4 = i3 + i2 + 64;
                        int i5 = this.height;
                        if (i4 >= i3 + i5) {
                            int i6 = this.leftInterval;
                            int i7 = this.width;
                            canvas2.clipRect((i6 + i7) * i, i3 + i5, (i6 + i7) * (i + 1), i3 + i5);
                            canvas2.drawBitmap(this.bitmapF, (float) ((this.leftInterval + this.width) * i), 0.0f, this.mForePaint);
                        } else {
                            int i8 = this.leftInterval;
                            int i9 = this.width;
                            canvas2.clipRect((i8 + i9) * i, i3 + i2, (i8 + i9) * (i + 1), i3 + i5);
                            canvas2.drawBitmap(this.bitmapF, (float) ((this.leftInterval + this.width) * i), 0.0f, this.mForePaint);
                        }
                        canvas.restore();
                    } else {
                        canvas.save();
                        int i10 = this.y;
                        int i11 = i10 + i2 + 64;
                        int i12 = this.height;
                        if (i11 >= i10 + i12) {
                            int i13 = this.leftInterval;
                            int i14 = this.width;
                            canvas2.clipRect((i13 + i14) * i, i10 + i12, (i13 + i14) * (i + 1), i10 + i12);
                            canvas2.drawBitmap(this.bitmapD, (float) ((this.leftInterval + this.width) * i), 0.0f, this.mForePaint);
                        } else {
                            int i15 = this.leftInterval;
                            int i16 = this.width;
                            canvas2.clipRect((i15 + i16) * i, i10 + i2, (i15 + i16) * (i + 1), i10 + i12);
                            canvas2.drawBitmap(this.bitmapD, (float) ((this.leftInterval + this.width) * i), 0.0f, this.mForePaint);
                        }
                        canvas.restore();
                    }
                    if (this.mGpsData[i].snr < 10) {
                        this.targetRect.left = this.x + ((this.width + this.leftInterval) * i);
                        Rect rect = this.targetRect;
                        rect.right = rect.left + this.width;
                        this.targetRect.top = (this.y + i2) - 30;
                        this.targetRect.bottom = this.y + i2;
                    } else {
                        this.targetRect.left = this.x + ((this.width + this.leftInterval) * i);
                        Rect rect2 = this.targetRect;
                        rect2.right = rect2.left + this.width;
                        this.targetRect.top = this.y + i2;
                        Rect rect3 = this.targetRect;
                        rect3.bottom = rect3.top + 30;
                    }
                    int i17 = (this.targetRect.top + ((((this.targetRect.bottom - this.targetRect.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top;
                    if (this.mGpsState == 2) {
                        this.mForePaint.setColor(Color.rgb(200, 200, 200));
                    } else {
                        this.mForePaint.setColor(Color.rgb(100, 100, 100));
                    }
                    this.mForePaint.setColor(this.mTextNumColor);
                    canvas2.drawText("" + this.mGpsData[i].snr, (float) this.targetRect.centerX(), (float) i17, this.mForePaint);
                    this.mForePaint.setColor(this.mTextNumColor);
                    this.targetRect.left = this.x + ((this.width + this.leftInterval) * i);
                    Rect rect4 = this.targetRect;
                    rect4.right = rect4.left + this.width;
                    this.targetRect.top = this.y + this.height;
                    Rect rect5 = this.targetRect;
                    rect5.bottom = rect5.top + 40;
                    canvas2.drawText("" + this.mGpsData[i].prn, (float) this.targetRect.centerX(), (float) ((this.targetRect.top + ((((this.targetRect.bottom - this.targetRect.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top), this.mForePaint);
                }
            } else if (this.mGpsData[i].isValid) {
                if (this.mGpsData[i].usedInFixed) {
                    this.mForePaint.setColor(Color.rgb(255, 36, 66));
                } else {
                    this.mForePaint.setColor(Color.rgb(100, 100, 100));
                }
                int i18 = (this.height * (60 - this.mGpsData[i].snr)) / 60;
                int i19 = this.x;
                int i20 = this.width;
                int i21 = this.leftInterval;
                int i22 = this.y;
                canvas.drawRect((float) (((i20 + i21) * i) + i19), (float) (i22 + i18), (float) (i19 + ((i21 + i20) * i) + i20), (float) (i22 + this.height), this.mForePaint);
                if (this.mGpsData[i].snr < 10) {
                    this.targetRect.left = this.x + ((this.width + this.leftInterval) * i);
                    Rect rect6 = this.targetRect;
                    rect6.right = rect6.left + this.width;
                    this.targetRect.top = (this.y + i18) - 30;
                    this.targetRect.bottom = this.y + i18;
                } else {
                    this.targetRect.left = this.x + ((this.width + this.leftInterval) * i);
                    Rect rect7 = this.targetRect;
                    rect7.right = rect7.left + this.width;
                    this.targetRect.top = this.y + i18;
                    Rect rect8 = this.targetRect;
                    rect8.bottom = rect8.top + 30;
                }
                int i23 = (this.targetRect.top + ((((this.targetRect.bottom - this.targetRect.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top;
                this.mForePaint.setColor(this.mTextNumColor);
                canvas2.drawText("" + this.mGpsData[i].snr, (float) this.targetRect.centerX(), (float) i23, this.mForePaint);
                this.targetRect.left = this.x + ((this.width + this.leftInterval) * i);
                Rect rect9 = this.targetRect;
                rect9.right = rect9.left + this.width;
                this.targetRect.top = this.y + this.height;
                Rect rect10 = this.targetRect;
                rect10.bottom = rect10.top + 40;
                if (this.mUICategoryNum == 2) {
                    Rect rect11 = this.targetRect;
                    rect11.bottom = rect11.top + 26;
                }
                this.mForePaint.setColor(this.mTextNumColor);
                canvas2.drawText("" + this.mGpsData[i].prn, (float) this.targetRect.centerX(), (float) ((this.targetRect.top + ((((this.targetRect.bottom - this.targetRect.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top), this.mForePaint);
            }
        }
    }
}
