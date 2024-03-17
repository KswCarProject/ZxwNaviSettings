package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.view.GPSStateInforView;
import com.szchoiceway.settings.view.SatelliteDisplayView;

public final class ActivityGpsBinding implements ViewBinding {
    public final TextView TvAltitude;
    public final TextView TvAltitudeTitle;
    public final GPSStateInforView TvBeidouStateInfor;
    public final GPSStateInforView TvGPSStateInfor;
    public final TextView TvGPSTimer;
    public final TextView TvGPSTimerTitle;
    public final TextView TvLatitude;
    public final TextView TvLongitude;
    public final SatelliteDisplayView TvSatelliteDisp;
    public final TextView TvSpeed;
    private final RelativeLayout rootView;

    private ActivityGpsBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, GPSStateInforView gPSStateInforView, GPSStateInforView gPSStateInforView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, SatelliteDisplayView satelliteDisplayView, TextView textView7) {
        this.rootView = relativeLayout;
        this.TvAltitude = textView;
        this.TvAltitudeTitle = textView2;
        this.TvBeidouStateInfor = gPSStateInforView;
        this.TvGPSStateInfor = gPSStateInforView2;
        this.TvGPSTimer = textView3;
        this.TvGPSTimerTitle = textView4;
        this.TvLatitude = textView5;
        this.TvLongitude = textView6;
        this.TvSatelliteDisp = satelliteDisplayView;
        this.TvSpeed = textView7;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGpsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityGpsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_gps, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityGpsBinding bind(View view) {
        int i = R.id.TvAltitude;
        TextView textView = (TextView) view.findViewById(R.id.TvAltitude);
        if (textView != null) {
            i = R.id.TvAltitudeTitle;
            TextView textView2 = (TextView) view.findViewById(R.id.TvAltitudeTitle);
            if (textView2 != null) {
                i = R.id.TvBeidouStateInfor;
                GPSStateInforView gPSStateInforView = (GPSStateInforView) view.findViewById(R.id.TvBeidouStateInfor);
                if (gPSStateInforView != null) {
                    i = R.id.TvGPSStateInfor;
                    GPSStateInforView gPSStateInforView2 = (GPSStateInforView) view.findViewById(R.id.TvGPSStateInfor);
                    if (gPSStateInforView2 != null) {
                        i = R.id.TvGPSTimer;
                        TextView textView3 = (TextView) view.findViewById(R.id.TvGPSTimer);
                        if (textView3 != null) {
                            i = R.id.TvGPSTimerTitle;
                            TextView textView4 = (TextView) view.findViewById(R.id.TvGPSTimerTitle);
                            if (textView4 != null) {
                                i = R.id.TvLatitude;
                                TextView textView5 = (TextView) view.findViewById(R.id.TvLatitude);
                                if (textView5 != null) {
                                    i = R.id.TvLongitude;
                                    TextView textView6 = (TextView) view.findViewById(R.id.TvLongitude);
                                    if (textView6 != null) {
                                        i = R.id.TvSatelliteDisp;
                                        SatelliteDisplayView satelliteDisplayView = (SatelliteDisplayView) view.findViewById(R.id.TvSatelliteDisp);
                                        if (satelliteDisplayView != null) {
                                            i = R.id.TvSpeed;
                                            TextView textView7 = (TextView) view.findViewById(R.id.TvSpeed);
                                            if (textView7 != null) {
                                                return new ActivityGpsBinding((RelativeLayout) view, textView, textView2, gPSStateInforView, gPSStateInforView2, textView3, textView4, textView5, textView6, satelliteDisplayView, textView7);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
