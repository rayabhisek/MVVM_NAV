package com.example.mvvmsample.data.remote;
import com.example.mvvmsample.data.remote.postbody.SignupPostBody;
import com.example.mvvmsample.data.remote.postbody.UserPostBody;
import com.example.mvvmsample.data.remote.response.LoginResponse;
import com.example.mvvmsample.data.remote.response.SignupResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface APIInterface {

    @Headers({
            "Content-Type:application/json"
    })
    @POST(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
    Call<LoginResponse> doLogin(@Body UserPostBody userPostBody);

    @Headers({
            "Content-Type:application/json"
    })
    @POST(ApiEndPoint.ENDPOINT_SERVER_SIGNUP)
    Call<SignupResponse> doSignup(@Body SignupPostBody signupPostBody);

}
