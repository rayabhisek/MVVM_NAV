/*
 * *
 *  * Created by Abhisek on 11/25/19 2:42 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 2:42 PM
 *
 */

package com.example.mvvmsample.ui.signup;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvvmsample.R;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViewById(R.id.ivBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
