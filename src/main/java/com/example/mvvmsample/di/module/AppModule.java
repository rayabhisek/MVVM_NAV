/*
 * *
 *  * Created by Abhisek on 11/26/19 11:57 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/26/19 11:57 AM
 *
 */

package com.example.mvvmsample.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }
/*
    @Provides
    @Singleton
    APIInterface provideApiService() {
        return new APIInterface();
    }

    @Provides
    @Singleton
    DBService provideDBService(Context context) {
        return new DBService(context);
    }*/

}
