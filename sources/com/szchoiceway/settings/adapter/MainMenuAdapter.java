package com.szchoiceway.settings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.szchoiceway.settings.R;
import com.szchoiceway.settings.SysProviderOpt;
import com.szchoiceway.settings.bean.MainMenuBean;
import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final int TYPE_LANGUAGE = 1;
    private static final int TYPE_MAIN = 0;
    private static final int TYPE_SYSTEM_SET_MAIN = 2;
    private Context context;
    private List<MainMenuBean> list;
    private OnItemClickListener listener;
    private int m_iModeSet = 25;
    private int position;
    private int type;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public MainMenuAdapter(Context context2, List<MainMenuBean> list2, int i) {
        this.context = context2;
        this.m_iModeSet = SysProviderOpt.getInstance(context2).getRecordInteger("KESAIWEI_SYS_MODE_SELECTION", this.m_iModeSet);
        this.list = list2;
        this.type = i;
    }

    public void setPosition(int i) {
        this.position = i;
        notifyDataSetChanged();
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        int i2 = this.type;
        if (i2 == 1) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.landrover_language_set_item, viewGroup, false);
        } else if (i2 == 2) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.landrover_fragment_sys_set_main_item, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.landrover_main_set_item, viewGroup, false);
        }
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        boolean z = true;
        if (myViewHolder.chkIcon != null) {
            if (this.list.get(i).getChkDrawable() != null) {
                myViewHolder.chkIcon.setBackground(this.list.get(i).getChkDrawable());
            }
            myViewHolder.chkIcon.setChecked(this.position == i);
        }
        if (myViewHolder.txtTitle != null) {
            myViewHolder.txtTitle.setText(this.list.get(i).getTvTitle());
            int i2 = this.type;
            if (i2 == 0 || i2 == 2) {
                myViewHolder.txtTitle.setSelected(this.position == i);
            }
        }
        if (myViewHolder.btnMainSetItem != null) {
            ImageButton access$200 = myViewHolder.btnMainSetItem;
            if (this.position != i) {
                z = false;
            }
            access$200.setSelected(z);
            myViewHolder.btnMainSetItem.setOnClickListener(new View.OnClickListener(i) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    MainMenuAdapter.this.lambda$onBindViewHolder$0$MainMenuAdapter(this.f$1, view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$MainMenuAdapter(int i, View view) {
        this.listener.onItemClick(i);
    }

    public int getItemCount() {
        return this.list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public ImageButton btnMainSetItem;
        /* access modifiers changed from: private */
        public CheckBox chkIcon;
        /* access modifiers changed from: private */
        public TextView txtTitle;

        public MyViewHolder(View view) {
            super(view);
            this.chkIcon = (CheckBox) view.findViewById(R.id.chkIcon);
            this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            this.btnMainSetItem = (ImageButton) view.findViewById(R.id.btnMainSetItem);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
}
