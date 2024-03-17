package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.joanzapata.pdfview.PDFView;
import com.szchoiceway.settings.R;

public final class Kesaiwei1920x720ActivityManualBinding implements ViewBinding {
    public final View btnFloat1;
    public final View btnFloat2;
    public final GridView gridView;
    public final Button importPdf;
    public final Button importPdf2;
    public final Button openPdf;
    public final PDFView pdfView;
    private final RelativeLayout rootView;
    public final TextView tips;
    public final RelativeLayout viewPdf;
    public final RelativeLayout viewTips;

    private Kesaiwei1920x720ActivityManualBinding(RelativeLayout relativeLayout, View view, View view2, GridView gridView2, Button button, Button button2, Button button3, PDFView pDFView, TextView textView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.btnFloat1 = view;
        this.btnFloat2 = view2;
        this.gridView = gridView2;
        this.importPdf = button;
        this.importPdf2 = button2;
        this.openPdf = button3;
        this.pdfView = pDFView;
        this.tips = textView;
        this.viewPdf = relativeLayout2;
        this.viewTips = relativeLayout3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Kesaiwei1920x720ActivityManualBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static Kesaiwei1920x720ActivityManualBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.kesaiwei_1920x720_activity_manual, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Kesaiwei1920x720ActivityManualBinding bind(View view) {
        int i = R.id.btnFloat1;
        View findViewById = view.findViewById(R.id.btnFloat1);
        if (findViewById != null) {
            i = R.id.btnFloat2;
            View findViewById2 = view.findViewById(R.id.btnFloat2);
            if (findViewById2 != null) {
                i = R.id.gridView;
                GridView gridView2 = (GridView) view.findViewById(R.id.gridView);
                if (gridView2 != null) {
                    i = R.id.importPdf;
                    Button button = (Button) view.findViewById(R.id.importPdf);
                    if (button != null) {
                        i = R.id.importPdf2;
                        Button button2 = (Button) view.findViewById(R.id.importPdf2);
                        if (button2 != null) {
                            i = R.id.openPdf;
                            Button button3 = (Button) view.findViewById(R.id.openPdf);
                            if (button3 != null) {
                                i = R.id.pdfView;
                                PDFView pDFView = (PDFView) view.findViewById(R.id.pdfView);
                                if (pDFView != null) {
                                    i = R.id.tips;
                                    TextView textView = (TextView) view.findViewById(R.id.tips);
                                    if (textView != null) {
                                        i = R.id.viewPdf;
                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.viewPdf);
                                        if (relativeLayout != null) {
                                            i = R.id.viewTips;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.viewTips);
                                            if (relativeLayout2 != null) {
                                                return new Kesaiwei1920x720ActivityManualBinding((RelativeLayout) view, findViewById, findViewById2, gridView2, button, button2, button3, pDFView, textView, relativeLayout, relativeLayout2);
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
