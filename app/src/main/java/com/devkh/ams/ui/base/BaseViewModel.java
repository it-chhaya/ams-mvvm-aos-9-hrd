package com.devkh.ams.ui.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {

    ObservableBoolean mIsLoading = new ObservableBoolean();

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }



}
