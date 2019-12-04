/*
 * *
 *  * Created by Abhisek on 11/22/19 6:29 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/22/19 2:55 PM
 *
 */

package com.example.mvvmsample.ui.dashboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.View;

import com.example.mvvmsample.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView= findViewById(R.id.bottomNavigation);
        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

                if(destination.getId() == R.id.loginFragment) {
                    //toolbar.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(View.GONE);
                }else {
                    bottomNavigationView.setVisibility(View.VISIBLE);
                }

             /*   switch (destination.getId()){
                    case R.id.
                }

                if(destination.getId() == R.id.full_screen_destination) {
                    //toolbar.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(View.GONE);
                } else {
                    toolbar.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.VISIBLE);
                }*/


            }
        });

    }

  /*  @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }*/


}