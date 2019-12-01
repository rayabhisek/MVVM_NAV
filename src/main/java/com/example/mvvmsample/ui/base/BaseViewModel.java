package com.example.mvvmsample.ui.base;

import java.lang.ref.WeakReference;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

public class BaseViewModel<N> extends ViewModel {


    private WeakReference<N> mNavigator;
    private ObservableBoolean mIsLoading;

    public BaseViewModel() {
    }


    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }



}
