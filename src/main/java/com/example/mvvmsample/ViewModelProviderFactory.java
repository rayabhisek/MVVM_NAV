package com.example.mvvmsample;



import android.app.Application;

import com.example.mvvmsample.ui.addnotes.NotesViewModel;
import com.example.mvvmsample.ui.home.HomeViewModel;
import com.example.mvvmsample.ui.login.LoginViewModel;
import com.example.mvvmsample.ui.splash.SplashViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private Application application;
    @Inject
    public ViewModelProviderFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            //noinspection unchecked
            return (T) new SplashViewModel();
        }
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel();
        }
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            //noinspection unchecked
            return (T) new HomeViewModel();
        }

        
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

}
