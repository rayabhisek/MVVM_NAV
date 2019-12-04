/*
 * *
 *  * Created by Abhisek on 11/25/19 5:08 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 5:08 PM
 *
 */

package com.example.mvvmsample.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.CompositeDisposable;

import com.example.mvvmsample.R;
import com.example.mvvmsample.ui.addnotes.NotesViewModel;
import com.example.mvvmsample.ui.addnotes.ViewModelFactory;
import com.example.mvvmsample.utils.Injection;


public class HomeFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private NoteAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private NotesViewModel notesViewModel;
    private ViewModelFactory mViewModelFactory;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        mViewModelFactory = Injection.provideViewModelFactory(getActivity());
        notesViewModel = ViewModelProviders.of(this, mViewModelFactory).get(NotesViewModel.class);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //homeViewModel = ViewModelProviders.of(getActivity()).get(NotesViewModel.class);
        //mAdapter = new NoteAdapter(homeViewModel);
        /*NotesModel notesModel = new NotesModel("Hii",)
        mAdapter.setNotes(notesModel);*/
        recyclerView.setAdapter(new NoteAdapter(notesViewModel));
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
