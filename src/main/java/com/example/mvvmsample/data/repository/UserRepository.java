package com.example.mvvmsample.data.repository;

import com.example.mvvmsample.data.remote.APIInterface;
import com.example.mvvmsample.data.remote.RetrofitHelper;
import com.example.mvvmsample.data.remote.postbody.SignupPostBody;
import com.example.mvvmsample.data.remote.postbody.UserPostBody;
import com.example.mvvmsample.data.remote.response.LoginResponse;
import com.example.mvvmsample.data.remote.response.SignupResponse;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    APIInterface apiInterface;

    public MutableLiveData<LoginResponse> userLogin(UserPostBody userPostBody) {
        apiInterface = RetrofitHelper.getRetrofitInstance().create(APIInterface.class);
        final MutableLiveData<LoginResponse> loginResponse = new MutableLiveData<>();
        apiInterface.doLogin(userPostBody).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    loginResponse.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

        return loginResponse;
    }

    public MutableLiveData<SignupResponse> userSignup(SignupPostBody signupPostBody) {
        apiInterface = RetrofitHelper.getRetrofitInstance().create(APIInterface.class);
        final MutableLiveData<SignupResponse> signupResponse = new MutableLiveData<>();
        apiInterface.doSignup(signupPostBody).enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                if (response.isSuccessful()) {
                    signupResponse.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {

            }
        });

        return signupResponse;
    }

}
