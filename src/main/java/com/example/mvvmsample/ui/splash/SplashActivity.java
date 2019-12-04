/*
 * *
 *  * Created by Abhisek on 11/22/19 4:46 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/22/19 4:39 PM
 *
 */

package com.example.mvvmsample.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.example.mvvmsample.R;
import com.example.mvvmsample.ViewModelProviderFactory;
import com.example.mvvmsample.databinding.ActivitySpalshBinding;
import com.example.mvvmsample.ui.base.BaseActivity;
import com.example.mvvmsample.ui.dashboard.MainActivity;
import com.example.mvvmsample.ui.login.LoginActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySpalshBinding,SplashViewModel> implements SplashNavigator {


    @Inject
    ViewModelProviderFactory factory;

    private SplashViewModel mSplashViewModel;

    @Override
    public int getBindingVariable() {
        return com.example.mvvmsample.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_spalsh;
    }

    @Override
    public SplashViewModel getViewModel() {
        mSplashViewModel = ViewModelProviders.of(this,factory).get(SplashViewModel.class);
        return mSplashViewModel;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.startSeeding();
    }

    @Override
    public void openLoginActivity() {
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    @Override
    public void openMainActivity() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
