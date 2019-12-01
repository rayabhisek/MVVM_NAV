package com.example.mvvmsample.data.remote;

import com.example.mvvmsample.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static volatile Retrofit retrofit;
    private static final String BASE_URL = BuildConfig.BASE_URL;

    private RetrofitHelper() {
    }

    public static Retrofit getRetrofitInstance() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!


        if (retrofit == null) {
            synchronized (Retrofit.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(httpClient.build())
                            .build();
                }
            }
        }
        return retrofit;
    }

}
