package com.szchoiceway.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VolumeSetViewModel extends ViewModel {
    public final MutableLiveData<Boolean> isAndroidVolumeLayoutVisibility = new MutableLiveData<>(true);
    public final MutableLiveData<Boolean> isOEMVolumeLayoutVisibility = new MutableLiveData<>(false);
    public final MutableLiveData<Boolean> isVolumeSetVisibility = new MutableLiveData<>(false);
}
