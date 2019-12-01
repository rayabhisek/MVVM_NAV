/*
 * *
 *  * Created by Abhisek on 11/26/19 11:58 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/26/19 11:58 AM
 *
 */

package com.example.mvvmsample.di.builder;

import com.example.mvvmsample.ui.login.LoginActivity;
import com.example.mvvmsample.ui.signup.SignUpActivity;
import com.example.mvvmsample.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract SignUpActivity bindSignUpActivity();
}
