/*
 * *
 *  * Created by Abhisek on 11/22/19 6:29 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/22/19 2:55 PM
 *
 */

package com.example.mvvmsample.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
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

    }

  /*  @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }*/


}