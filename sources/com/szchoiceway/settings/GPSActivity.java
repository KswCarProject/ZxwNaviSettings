package com.szchoiceway.settings;

import android.app.Activity;
import android.location.Criteria;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import com.szchoiceway.settings.view.GPSStateInforView;
import com.szchoiceway.settings.view.SatelliteDisplayView;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class GPSActivity extends Activity {
    protected static final String TAG = "MainActivity";
    private TextView TvAltitude = null;
    /* access modifiers changed from: private */
    public TextView TvBeiDouConnect = null;
    /* access modifiers changed from: private */
    public GPSStateInforView TvBeidouStateInfor = null;
    /* access modifiers changed from: private */
    public TextView TvGPSConnect = null;
    /* access modifiers changed from: private */
    public GPSStateInforView TvGPSStateInfor = null;
    private TextView TvGPSTimer = null;
    private TextView TvLatitude = null;
    private TextView TvLongitude = null;
    /* access modifiers changed from: private */
    public SatelliteDisplayView TvSatelliteDisp = null;
    private TextView TvSpeed = null;
    private GpsStatus gpsStatus;
    Handler handler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                GPSActivity.this.refreshLocation();
            }
        }
    };
    private Location location;
    private final LocationListener locationListener = new LocationListener() {
        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (GPSActivity.this.TvGPSStateInfor != null) {
                GPSActivity.this.TvGPSStateInfor.setGpsValidState(i);
            }
        }

        public void onLocationChanged(Location location) {
            GPSActivity.this.updateToNewLocation(location);
        }
    };
    private LocationManager locationManager;
    /* access modifiers changed from: private */
    public int mBeidouCount = 0;
    private GnssStatus.Callback mGnssStatusCallback = new GnssStatus.Callback() {
        public void onFirstFix(int i) {
        }

        public void onStarted() {
        }

        public void onStopped() {
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            if (GPSActivity.this.TvGPSStateInfor != null) {
                GPSActivity.this.TvGPSStateInfor.setData(gnssStatus);
            }
            if (GPSActivity.this.TvBeidouStateInfor != null) {
                GPSActivity.this.TvBeidouStateInfor.setData(gnssStatus);
            }
            if (GPSActivity.this.TvSatelliteDisp != null) {
                GPSActivity.this.TvSatelliteDisp.setData(gnssStatus);
            }
            int satelliteCount = gnssStatus.getSatelliteCount();
            for (int i = 0; i < satelliteCount; i++) {
                if (gnssStatus.getConstellationType(i) == 1) {
                    GPSActivity.access$408(GPSActivity.this);
                } else if (gnssStatus.getConstellationType(i) == 5) {
                    GPSActivity.access$508(GPSActivity.this);
                }
            }
            if (GPSActivity.this.TvGPSConnect != null) {
                GPSActivity.this.TvGPSConnect.setText(GPSActivity.this.mGpsCount + "");
            }
            if (GPSActivity.this.TvBeiDouConnect != null) {
                GPSActivity.this.TvBeiDouConnect.setText(GPSActivity.this.mBeidouCount + "");
            }
        }
    };
    /* access modifiers changed from: private */
    public int mGpsCount = 0;

    static /* synthetic */ int access$408(GPSActivity gPSActivity) {
        int i = gPSActivity.mGpsCount;
        gPSActivity.mGpsCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$508(GPSActivity gPSActivity) {
        int i = gPSActivity.mBeidouCount;
        gPSActivity.mBeidouCount = i + 1;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(R.layout.activity_gps);
        initView();
    }

    private void initView() {
        this.TvAltitude = (TextView) findViewById(R.id.TvAltitude);
        this.TvSpeed = (TextView) findViewById(R.id.TvSpeed);
        this.TvLongitude = (TextView) findViewById(R.id.TvLongitude);
        this.TvLatitude = (TextView) findViewById(R.id.TvLatitude);
        this.TvGPSTimer = (TextView) findViewById(R.id.TvGPSTimer);
        this.TvGPSStateInfor = (GPSStateInforView) findViewById(R.id.TvGPSStateInfor);
        this.TvBeidouStateInfor = (GPSStateInforView) findViewById(R.id.TvBeidouStateInfor);
        this.TvSatelliteDisp = (SatelliteDisplayView) findViewById(R.id.TvSatelliteDisp);
        this.locationManager = (LocationManager) getSystemService("location");
        getLocation();
    }

    private void getLocation() {
        checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.locationManager.registerGnssStatusCallback(this.mGnssStatusCallback, new Handler());
            refreshLocation();
        }
    }

    /* access modifiers changed from: private */
    public void refreshLocation() {
        String str;
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(true);
        criteria.setBearingRequired(true);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(1);
        criteria.setSpeedRequired(true);
        String bestProvider = this.locationManager.getBestProvider(criteria, true);
        this.location = this.locationManager.getLastKnownLocation(bestProvider);
        Iterator<String> it = this.locationManager.getProviders(true).iterator();
        loop0:
        while (true) {
            str = bestProvider;
            while (it.hasNext()) {
                bestProvider = it.next();
                Location lastKnownLocation = this.locationManager.getLastKnownLocation(bestProvider);
                if (lastKnownLocation != null && (this.location == null || lastKnownLocation.getAccuracy() < this.location.getAccuracy())) {
                    this.location = lastKnownLocation;
                }
            }
            break loop0;
        }
        Location location2 = this.location;
        if (location2 == null) {
            this.handler.sendEmptyMessageDelayed(0, 1000);
            return;
        }
        updateToNewLocation(location2);
        this.locationManager.requestLocationUpdates(str, 1000, 0.0f, this.locationListener);
    }

    /* access modifiers changed from: private */
    public void updateToNewLocation(Location location2) {
        Log.i(TAG, "updateToNewLocation location = " + location2);
        if (location2 != null) {
            location2.getBearing();
            float latitude = (float) location2.getLatitude();
            float longitude = (float) location2.getLongitude();
            float speed = location2.getSpeed() * 3.7f;
            Date date = new Date(location2.getTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            float altitude = (float) location2.getAltitude();
            Log.d(TAG, "GpsSpeed = " + speed);
            TextView textView = this.TvAltitude;
            if (textView != null) {
                textView.setText("" + altitude + " m");
            }
            TextView textView2 = this.TvSpeed;
            if (textView2 != null) {
                textView2.setText(String.format("%.2f", new Object[]{Float.valueOf(speed)}) + " km/h");
            }
            TextView textView3 = this.TvLongitude;
            if (textView3 != null) {
                textView3.setText("" + longitude);
            }
            TextView textView4 = this.TvLatitude;
            if (textView4 != null) {
                textView4.setText("" + latitude);
            }
            TextView textView5 = this.TvGPSTimer;
            if (textView5 != null) {
                textView5.setText("" + simpleDateFormat.format(date));
                return;
            }
            return;
        }
        TextView textView6 = this.TvAltitude;
        if (textView6 != null) {
            textView6.setText("0 m");
        }
        TextView textView7 = this.TvSpeed;
        if (textView7 != null) {
            textView7.setText("0 km/h");
        }
        TextView textView8 = this.TvLongitude;
        if (textView8 != null) {
            textView8.setText("000°00′00″");
        }
        TextView textView9 = this.TvLatitude;
        if (textView9 != null) {
            textView9.setText("000°00′00″");
        }
        TextView textView10 = this.TvGPSTimer;
        if (textView10 != null) {
            textView10.setText("");
        }
    }
}
