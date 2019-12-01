/*
 * *
 *  * Created by Abhisek on 11/25/19 5:08 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 5:08 PM
 *
 */

package com.example.mvvmsample.ui.home;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmsample.R;
import com.example.mvvmsample.data.model.Notes;
import com.example.mvvmsample.data.model.NotesModel;
import com.example.mvvmsample.ui.addnotes.NotesViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View view;

    private RecyclerView recyclerView;
    private NoteAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Notes> noteList = new ArrayList<>();
    private NotesViewModel notesViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        //prepareMovieData();
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        notesViewModel = ViewModelProviders.of(getActivity()).get(NotesViewModel.class);
        mAdapter = new NoteAdapter();
        notesViewModel.getAllNotes().observe(getActivity(), notesModels -> {
            mAdapter.setNotes(notesModels);
            recyclerView.setAdapter(mAdapter);
        });


       /* mAdapter = new NoteAdapter(noteList);
        recyclerView.setAdapter(mAdapter);*/
        return view;
    }

    private void prepareMovieData() {

        Notes notes = new Notes("Today Notes","","10-12-2019");
        noteList.add(notes);

        notes = new Notes("Impotant Notes","","02-12-2018");
        noteList.add(notes);

        notes = new Notes("Late Notes","","31-08-2018");
        noteList.add(notes);

        notes = new Notes("Today Notes","","10-12-2019");
        noteList.add(notes);

        notes = new Notes("Impotant Notes","","02-12-2018");
        noteList.add(notes);

        notes = new Notes("Late Notes","","31-08-2018");
        noteList.add(notes);

        notes = new Notes("Today Notes","","10-12-2019");
        noteList.add(notes);

        notes = new Notes("Impotant Notes","","02-12-2018");
        noteList.add(notes);

        notes = new Notes("Late Notes","","31-08-2018");
        noteList.add(notes);
    }
}
