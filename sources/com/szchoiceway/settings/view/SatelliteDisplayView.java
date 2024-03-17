package com.szchoiceway.settings.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.location.GnssStatus;
import android.util.AttributeSet;
import android.view.View;
import com.szchoiceway.settings.R;

public class SatelliteDisplayView extends View {
    private static final String TAG = "SatelliteDisplayView";
    private static final int maxGpsStateCount = 24;
    private int compassRadius = 0;
    private int cx = 0;
    private int cy = 0;
    private Paint mForePaint = new Paint();
    private GpsSateData[] mGpsData = new GpsSateData[24];
    private Bitmap satelliteBitmap = null;

    private float degreeToRadian(float f) {
        return (float) ((((double) f) * 3.141592653589793d) / 180.0d);
    }

    private class GpsSateData {
        float azimuth;
        float elevation;
        boolean isValid;
        int prn;
        int snr;

        private GpsSateData() {
            this.prn = 0;
            this.snr = 0;
            this.azimuth = 0.0f;
            this.elevation = 0.0f;
            this.isValid = false;
        }
    }

    public SatelliteDisplayView(Context context) {
        super(context);
        init();
    }

    public SatelliteDisplayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SatelliteDisplayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mForePaint.setAntiAlias(true);
        this.mForePaint.setTextSize(20.0f);
        this.mForePaint.setTextAlign(Paint.Align.CENTER);
        for (int i = 0; i < 24; i++) {
            this.mGpsData[i] = new GpsSateData();
            this.mGpsData[i].isValid = false;
        }
    }

    public void setCompassRadius(int i) {
        this.compassRadius = i;
    }

    public void setData(GnssStatus gnssStatus) {
        for (int i = 0; i < 24; i++) {
            if (i < gnssStatus.getSatelliteCount()) {
                this.mGpsData[i].prn = gnssStatus.getSvid(i);
                this.mGpsData[i].snr = (int) gnssStatus.getCn0DbHz(i);
                this.mGpsData[i].azimuth = gnssStatus.getAzimuthDegrees(i);
                this.mGpsData[i].elevation = gnssStatus.getElevationDegrees(i);
                this.mGpsData[i].isValid = true;
            } else {
                this.mGpsData[i].isValid = false;
            }
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.satelliteBitmap == null) {
            this.satelliteBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.weixing);
        }
        this.cx = getWidth() / 2;
        this.cy = getHeight() / 2;
        if (this.satelliteBitmap != null) {
            if (this.compassRadius == 0) {
                this.compassRadius = (getWidth() / 2) - this.satelliteBitmap.getWidth();
            }
            for (int i = 0; i < 24; i++) {
                if (this.mGpsData[i].isValid) {
                    drawSatellite(canvas, this.mGpsData[i], this.cx, this.cy, this.compassRadius);
                }
            }
        }
    }

    private void drawSatellite(Canvas canvas, GpsSateData gpsSateData, int i, int i2, int i3) {
        float f = ((float) i3) * ((90.0f - gpsSateData.elevation) / 90.0f);
        double degreeToRadian = (double) degreeToRadian((360.0f - gpsSateData.azimuth) + 90.0f);
        double d = (double) f;
        float cos = (float) (((double) i) + (Math.cos(degreeToRadian) * d));
        float width = (float) (this.satelliteBitmap.getWidth() / 2);
        canvas.drawBitmap(this.satelliteBitmap, cos - width, ((float) (((double) i2) - (Math.sin(degreeToRadian) * d))) - width, this.mForePaint);
    }
}
