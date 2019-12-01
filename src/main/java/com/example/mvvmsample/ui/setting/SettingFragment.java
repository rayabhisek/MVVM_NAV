/*
 * *
 *  * Created by Abhisek on 11/25/19 5:08 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 5:08 PM
 *
 */

package com.example.mvvmsample.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvvmsample.R;

public class SettingFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setting,container,false);
        return view;
    }
}
