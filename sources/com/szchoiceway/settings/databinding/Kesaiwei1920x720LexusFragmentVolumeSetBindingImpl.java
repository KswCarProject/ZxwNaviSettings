package com.szchoiceway.settings.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.szchoiceway.model.VolumeSetViewModel;
import com.szchoiceway.settings.R;

public class Kesaiwei1920x720LexusFragmentVolumeSetBindingImpl extends Kesaiwei1920x720LexusFragmentVolumeSetBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.systemScrollView_le_guideline, 4);
        sparseIntArray.put(R.id.systemScrollView_ri_guideline, 5);
        sparseIntArray.put(R.id.android_volume_layout, 6);
        sparseIntArray.put(R.id.rbAndroid, 7);
        sparseIntArray.put(R.id.oem_volume_layout, 8);
        sparseIntArray.put(R.id.rbOem, 9);
        sparseIntArray.put(R.id.sound_setting_layout, 10);
        sparseIntArray.put(R.id.rbSound, 11);
        sparseIntArray.put(R.id.viewPager_le_guideline, 12);
        sparseIntArray.put(R.id.view0, 13);
        sparseIntArray.put(R.id.viewSound_SeekBar0, 14);
        sparseIntArray.put(R.id.title1_tv, 15);
        sparseIntArray.put(R.id.my_seekbar1_00, 16);
        sparseIntArray.put(R.id.KSW_Vol_val_00, 17);
        sparseIntArray.put(R.id.view1, 18);
        sparseIntArray.put(R.id.viewSound_SeekBar1, 19);
        sparseIntArray.put(R.id.title2_tv, 20);
        sparseIntArray.put(R.id.my_seekbar1_01, 21);
        sparseIntArray.put(R.id.KSW_Vol_val_01, 22);
        sparseIntArray.put(R.id.view2, 23);
        sparseIntArray.put(R.id.viewSound_SeekBar2, 24);
        sparseIntArray.put(R.id.text3_tv, 25);
        sparseIntArray.put(R.id.my_seekbar1_03, 26);
        sparseIntArray.put(R.id.KSW_Vol_val_03, 27);
        sparseIntArray.put(R.id.view3, 28);
        sparseIntArray.put(R.id.viewSound_SeekBar3, 29);
        sparseIntArray.put(R.id.text4_tv, 30);
        sparseIntArray.put(R.id.my_seekbar1_04, 31);
        sparseIntArray.put(R.id.KSW_Vol_val_04, 32);
        sparseIntArray.put(R.id.scSound, 33);
        sparseIntArray.put(R.id.scrollLayout, 34);
        sparseIntArray.put(R.id.view10, 35);
        sparseIntArray.put(R.id.viewSound_SeekBar4, 36);
        sparseIntArray.put(R.id.text5_tv, 37);
        sparseIntArray.put(R.id.my_seekbar1_bass, 38);
        sparseIntArray.put(R.id.KSW_VolValue_Bass, 39);
        sparseIntArray.put(R.id.view11, 40);
        sparseIntArray.put(R.id.viewSound_SeekBar5, 41);
        sparseIntArray.put(R.id.text6_tv, 42);
        sparseIntArray.put(R.id.my_seekbar1_alto, 43);
        sparseIntArray.put(R.id.KSW_VolValue_Alto, 44);
        sparseIntArray.put(R.id.view12, 45);
        sparseIntArray.put(R.id.viewSound_SeekBar6, 46);
        sparseIntArray.put(R.id.text7_tv, 47);
        sparseIntArray.put(R.id.my_seekbar1_treble, 48);
        sparseIntArray.put(R.id.KSW_VolValue_Treble, 49);
        sparseIntArray.put(R.id.view13, 50);
        sparseIntArray.put(R.id.KSW_btn_eq_custom, 51);
        sparseIntArray.put(R.id.chkUser, 52);
        sparseIntArray.put(R.id.view14, 53);
        sparseIntArray.put(R.id.KSW_btn_eq_pop, 54);
        sparseIntArray.put(R.id.chkPop, 55);
        sparseIntArray.put(R.id.view15, 56);
        sparseIntArray.put(R.id.KSW_btn_eq_classical, 57);
        sparseIntArray.put(R.id.chkClassical, 58);
        sparseIntArray.put(R.id.view16, 59);
        sparseIntArray.put(R.id.KSW_btn_eq_rock, 60);
        sparseIntArray.put(R.id.chkRock, 61);
        sparseIntArray.put(R.id.view17, 62);
        sparseIntArray.put(R.id.KSW_btn_eq_jazz, 63);
        sparseIntArray.put(R.id.chkJazz, 64);
        sparseIntArray.put(R.id.view18, 65);
        sparseIntArray.put(R.id.KSW_btn_eq_dance, 66);
        sparseIntArray.put(R.id.chkDance, 67);
        sparseIntArray.put(R.id.myScrollbar, 68);
    }

    public Kesaiwei1920x720LexusFragmentVolumeSetBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 69, sIncludes, sViewsWithIds));
    }

    private Kesaiwei1920x720LexusFragmentVolumeSetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, objArr[57], objArr[51], objArr[66], objArr[63], objArr[54], objArr[60], objArr[17], objArr[22], objArr[27], objArr[32], objArr[44], objArr[39], objArr[49], objArr[6], objArr[58], objArr[67], objArr[64], objArr[55], objArr[61], objArr[52], objArr[68], objArr[16], objArr[21], objArr[26], objArr[31], objArr[43], objArr[38], objArr[48], objArr[8], objArr[7], objArr[9], objArr[11], objArr[33], objArr[34], objArr[10], objArr[4], objArr[5], objArr[25], objArr[30], objArr[37], objArr[42], objArr[47], objArr[15], objArr[20], objArr[13], objArr[18], objArr[35], objArr[40], objArr[45], objArr[50], objArr[53], objArr[56], objArr[59], objArr[62], objArr[65], objArr[23], objArr[28], objArr[1], objArr[2], objArr[12], objArr[3], objArr[14], objArr[19], objArr[24], objArr[29], objArr[36], objArr[41], objArr[46]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.viewAndroid.setTag((Object) null);
        this.viewOem.setTag((Object) null);
        this.viewSound.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        setViewModel((VolumeSetViewModel) obj);
        return true;
    }

    public void setViewModel(VolumeSetViewModel volumeSetViewModel) {
        this.mViewModel = volumeSetViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelIsAndroidVolumeLayoutVisibility((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelIsOEMVolumeLayoutVisibility((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeViewModelIsVolumeSetVisibility((MutableLiveData) obj, i2);
    }

    private boolean onChangeViewModelIsAndroidVolumeLayoutVisibility(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelIsOEMVolumeLayoutVisibility(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelIsVolumeSetVisibility(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r19 = this;
            r1 = r19
            monitor-enter(r19)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00d3 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00d3 }
            monitor-exit(r19)     // Catch:{ all -> 0x00d3 }
            com.szchoiceway.model.VolumeSetViewModel r0 = r1.mViewModel
            r6 = 31
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r7 = 28
            r9 = 26
            r11 = 25
            r13 = 0
            if (r6 == 0) goto L_0x00b1
            long r14 = r2 & r11
            int r6 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0048
            if (r0 == 0) goto L_0x0025
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r14 = r0.isAndroidVolumeLayoutVisibility
            goto L_0x0026
        L_0x0025:
            r14 = 0
        L_0x0026:
            r1.updateLiveDataRegistration(r13, r14)
            if (r14 == 0) goto L_0x0032
            java.lang.Object r14 = r14.getValue()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            goto L_0x0033
        L_0x0032:
            r14 = 0
        L_0x0033:
            boolean r14 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r14)
            if (r6 == 0) goto L_0x0042
            if (r14 == 0) goto L_0x003e
            r17 = 1024(0x400, double:5.06E-321)
            goto L_0x0040
        L_0x003e:
            r17 = 512(0x200, double:2.53E-321)
        L_0x0040:
            long r2 = r2 | r17
        L_0x0042:
            if (r14 == 0) goto L_0x0045
            goto L_0x0048
        L_0x0045:
            r6 = 8
            goto L_0x0049
        L_0x0048:
            r6 = r13
        L_0x0049:
            long r17 = r2 & r9
            int r14 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0054
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r13 = r0.isOEMVolumeLayoutVisibility
            goto L_0x0055
        L_0x0054:
            r13 = 0
        L_0x0055:
            r15 = 1
            r1.updateLiveDataRegistration(r15, r13)
            if (r13 == 0) goto L_0x0062
            java.lang.Object r13 = r13.getValue()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            goto L_0x0063
        L_0x0062:
            r13 = 0
        L_0x0063:
            boolean r13 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r13)
            if (r14 == 0) goto L_0x0071
            if (r13 == 0) goto L_0x006e
            r14 = 64
            goto L_0x0070
        L_0x006e:
            r14 = 32
        L_0x0070:
            long r2 = r2 | r14
        L_0x0071:
            if (r13 == 0) goto L_0x0074
            goto L_0x0077
        L_0x0074:
            r13 = 8
            goto L_0x0078
        L_0x0077:
            r13 = 0
        L_0x0078:
            long r14 = r2 & r7
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00ad
            if (r0 == 0) goto L_0x0083
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r0 = r0.isVolumeSetVisibility
            goto L_0x0084
        L_0x0083:
            r0 = 0
        L_0x0084:
            r15 = 2
            r1.updateLiveDataRegistration(r15, r0)
            if (r0 == 0) goto L_0x0092
            java.lang.Object r0 = r0.getValue()
            r15 = r0
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            goto L_0x0093
        L_0x0092:
            r15 = 0
        L_0x0093:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r15)
            if (r14 == 0) goto L_0x00a1
            if (r0 == 0) goto L_0x009e
            r14 = 256(0x100, double:1.265E-321)
            goto L_0x00a0
        L_0x009e:
            r14 = 128(0x80, double:6.32E-322)
        L_0x00a0:
            long r2 = r2 | r14
        L_0x00a1:
            if (r0 == 0) goto L_0x00a6
            r16 = 0
            goto L_0x00a8
        L_0x00a6:
            r16 = 8
        L_0x00a8:
            r0 = r13
            r13 = r6
            r6 = r16
            goto L_0x00b4
        L_0x00ad:
            r0 = r13
            r13 = r6
            r6 = 0
            goto L_0x00b4
        L_0x00b1:
            r0 = 0
            r6 = 0
            r13 = 0
        L_0x00b4:
            long r11 = r11 & r2
            int r11 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00be
            android.widget.RelativeLayout r11 = r1.viewAndroid
            r11.setVisibility(r13)
        L_0x00be:
            long r9 = r9 & r2
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00c8
            android.widget.RelativeLayout r9 = r1.viewOem
            r9.setVisibility(r0)
        L_0x00c8:
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d2
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.viewSound
            r0.setVisibility(r6)
        L_0x00d2:
            return
        L_0x00d3:
            r0 = move-exception
            monitor-exit(r19)     // Catch:{ all -> 0x00d3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szchoiceway.settings.databinding.Kesaiwei1920x720LexusFragmentVolumeSetBindingImpl.executeBindings():void");
    }
}
