package com.example.mvvmsample.ui.login;
import android.text.TextUtils;

import com.example.mvvmsample.data.remote.postbody.UserPostBody;
import com.example.mvvmsample.data.remote.response.LoginResponse;
import com.example.mvvmsample.data.repository.UserRepository;
import com.example.mvvmsample.ui.base.BaseViewModel;
import com.example.mvvmsample.utils.CommonUtils;

import androidx.lifecycle.LiveData;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    private static final String TAG = LoginViewModel.class.getCanonicalName().toString();
    private LiveData<LoginResponse> loginResponse;
    public LoginViewModel() {

    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String email, String password) {
        UserPostBody userPostBody = new UserPostBody(email,password);
        loginResponse = new UserRepository().userLogin(userPostBody);
        getNavigator().onSuccess(loginResponse);
        getNavigator().openMainActivity();
    }

    public void onServerLoginClick(){
        getNavigator().login();

    }
}
