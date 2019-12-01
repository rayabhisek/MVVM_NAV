/*
 * *
 *  * Created by Abhisek on 11/25/19 11:59 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 11:59 AM
 *
 */

package com.example.mvvmsample.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.mvvmsample.BR;
import com.example.mvvmsample.R;
import com.example.mvvmsample.ViewModelProviderFactory;

import com.example.mvvmsample.data.remote.response.LoginResponse;
import com.example.mvvmsample.databinding.ActivityLoginBinding;
import com.example.mvvmsample.ui.base.BaseActivity;
import com.example.mvvmsample.ui.dashboard.MainActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> implements LoginNavigator {

    private static final String TAG = LoginActivity.class.getCanonicalName().toString();
    @Inject
    ViewModelProviderFactory factory;
    private ActivityLoginBinding mActivityLoginBinding;
    private LoginViewModel loginViewModel;

    private String email,password;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        loginViewModel = ViewModelProviders.of(this,factory).get(LoginViewModel.class);
        return loginViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getmViewDataBinding();
        loginViewModel.setNavigator(this);

    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void login() {
        email = mActivityLoginBinding.etEmail.getText().toString();
        password = mActivityLoginBinding.etPassword.getText().toString();
        if (loginViewModel.isEmailAndPasswordValid(email, password)) {
            hideKeyboard();
            Log.d(TAG,"email"+email +"password"+password);
            loginViewModel.login(email, password);
        } else {
            Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void openMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onSuccess(LiveData<LoginResponse> loginResponse) {

        loginResponse.observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse loginResponse) {
                Toast.makeText(LoginActivity.this,loginResponse.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onFailure() {

    }

}
