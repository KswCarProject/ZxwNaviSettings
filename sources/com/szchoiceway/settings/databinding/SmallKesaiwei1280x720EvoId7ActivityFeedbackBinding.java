package com.szchoiceway.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.szchoiceway.settings.R;

public final class SmallKesaiwei1280x720EvoId7ActivityFeedbackBinding implements ViewBinding {
    public final CheckBox btnAndroidLog;
    public final Button btnEnd;
    public final Button btnMCULog;
    public final Button btnStart;
    public final CheckBox chkCan1;
    public final CheckBox chkCan2;
    private final RelativeLayout rootView;
    public final TextView tips;
    public final RelativeLayout viewCan1;
    public final RelativeLayout viewCan2;
    public final RelativeLayout viewPage1;
    public final RelativeLayout viewPage2;

    private SmallKesaiwei1280x720EvoId7ActivityFeedbackBinding(RelativeLayout relativeLayout, CheckBox checkBox, Button button, Button button2, Button button3, CheckBox checkBox2, CheckBox checkBox3, TextView textView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5) {
        this.rootView = relativeLayout;
        this.btnAndroidLog = checkBox;
        this.btnEnd = button;
        this.btnMCULog = button2;
        this.btnStart = button3;
        this.chkCan1 = checkBox2;
        this.chkCan2 = checkBox3;
        this.tips = textView;
        this.viewCan1 = relativeLayout2;
        this.viewCan2 = relativeLayout3;
        this.viewPage1 = relativeLayout4;
        this.viewPage2 = relativeLayout5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmallKesaiwei1280x720EvoId7ActivityFeedbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SmallKesaiwei1280x720EvoId7ActivityFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.small_kesaiwei_1280x720_evo_id7_activity_feedback, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SmallKesaiwei1280x720EvoId7ActivityFeedbackBinding bind(View view) {
        int i = R.id.btnAndroidLog;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.btnAndroidLog);
        if (checkBox != null) {
            i = R.id.btnEnd;
            Button button = (Button) view.findViewById(R.id.btnEnd);
            if (button != null) {
                i = R.id.btnMCULog;
                Button button2 = (Button) view.findViewById(R.id.btnMCULog);
                if (button2 != null) {
                    i = R.id.btnStart;
                    Button button3 = (Button) view.findViewById(R.id.btnStart);
                    if (button3 != null) {
                        i = R.id.chkCan1;
                        CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.chkCan1);
                        if (checkBox2 != null) {
                            i = R.id.chkCan2;
                            CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.chkCan2);
                            if (checkBox3 != null) {
                                i = R.id.tips;
                                TextView textView = (TextView) view.findViewById(R.id.tips);
                                if (textView != null) {
                                    i = R.id.viewCan1;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.viewCan1);
                                    if (relativeLayout != null) {
                                        i = R.id.viewCan2;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.viewCan2);
                                        if (relativeLayout2 != null) {
                                            i = R.id.viewPage1;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.viewPage1);
                                            if (relativeLayout3 != null) {
                                                i = R.id.viewPage2;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.viewPage2);
                                                if (relativeLayout4 != null) {
                                                    return new SmallKesaiwei1280x720EvoId7ActivityFeedbackBinding((RelativeLayout) view, checkBox, button, button2, button3, checkBox2, checkBox3, textView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
