/*
 * *
 *  * Created by Abhisek on 11/25/19 5:08 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 5:08 PM
 *
 */

package com.example.mvvmsample.ui.addnotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmsample.R;
import com.example.mvvmsample.data.model.NotesModel;

public class AddFragment extends Fragment {

    private View view;
    private NotesViewModel notesViewModel;
    private EditText tvTitle,tvNotes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add, container,false);
        tvTitle=view.findViewById(R.id.etTitle);
        tvNotes=view.findViewById(R.id.etNotes);

        notesViewModel = ViewModelProviders.of(getActivity()).get(NotesViewModel.class);
        view.findViewById(R.id.save).setOnClickListener(view -> {

            NotesModel notesModel =new NotesModel(tvTitle.getText().toString(),
                    tvNotes.getText().toString());
            notesViewModel.insert(notesModel);

            notesViewModel.getAllNotes().observe(getActivity(),
                    notesModels -> Toast.makeText(getActivity(),
                            notesModels.toString(),
                            Toast.LENGTH_LONG).show());
        });

        return view;
    }
}
