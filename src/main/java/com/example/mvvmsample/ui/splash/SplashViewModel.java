/*
 * *
 *  * Created by Abhisek on 11/22/19 4:47 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/22/19 4:39 PM
 *
 */

package com.example.mvvmsample.ui.splash;

import android.os.Handler;

import com.example.mvvmsample.ui.base.BaseViewModel;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    void startSeeding() {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                getNavigator().openLoginActivity();
            }
        }, 5000);

    }


}
