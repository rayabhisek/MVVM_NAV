/*
 * *
 *  * Created by Abhisek on 11/25/19 5:08 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 5:08 PM
 *
 */

package com.example.mvvmsample.ui.addnotes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import com.example.mvvmsample.R;
import com.example.mvvmsample.data.model.NotesModel;
import com.example.mvvmsample.utils.Injection;

import javax.inject.Inject;

public class AddFragment extends Fragment {

    private static final String TAG = AddFragment.class.getCanonicalName();

    private View view;
    private EditText tvTitle,tvNotes;
    private ViewModelFactory mViewModelFactory;
    private NotesViewModel notesViewModel;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add, container,false);
        tvTitle=view.findViewById(R.id.etTitle);
        tvNotes=view.findViewById(R.id.etNotes);

        mViewModelFactory = Injection.provideViewModelFactory(getActivity());
        notesViewModel = ViewModelProviders.of(this, mViewModelFactory).get(NotesViewModel.class);

        view.findViewById(R.id.save).setOnClickListener(view -> {

            NotesModel notesModel =new NotesModel(tvTitle.getText().toString(),
                    tvNotes.getText().toString());

            compositeDisposable.add(notesViewModel.insertNotes(notesModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(()->{
                        Toast.makeText(getActivity(),"Notes Added Successfully",
                                Toast.LENGTH_LONG).show();

                    },throwable -> {
                        Log.e(TAG,"Error: 34 "+ throwable.getMessage());
                    }));
        });

        return view;
    }


    @Override
    public void onStop() {
        super.onStop();

    }
}
