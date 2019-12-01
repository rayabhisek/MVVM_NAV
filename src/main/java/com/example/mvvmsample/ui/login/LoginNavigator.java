package com.example.mvvmsample.ui.login;

import com.example.mvvmsample.data.remote.response.LoginResponse;

import androidx.lifecycle.LiveData;

public interface LoginNavigator {

    void handleError(Throwable throwable);

    void login();

    void openMainActivity();

    void onStarted();

    void onSuccess(LiveData<LoginResponse> data);

    void onFailure();

}
