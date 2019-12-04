/*
 * *
 *  * Created by Abhisek on 11/26/19 11:54 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/26/19 11:54 AM
 *
 */

package com.example.mvvmsample.di.component;

import android.app.Application;
import android.content.Context;

import com.example.mvvmsample.MvvmApp;
import com.example.mvvmsample.di.builder.ActivityBuilder;
import com.example.mvvmsample.di.module.AppModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class,ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


}
