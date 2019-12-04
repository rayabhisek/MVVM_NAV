/*
 * *
 *  * Created by Abhisek on 11/25/19 6:00 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 6:00 PM
 *
 */

package com.example.mvvmsample.ui.home;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import com.example.mvvmsample.R;
import com.example.mvvmsample.data.model.Notes;
import com.example.mvvmsample.data.model.NotesModel;
import com.example.mvvmsample.ui.addnotes.NotesViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteAdapter  extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    List<NotesModel> notesList;
    private NotesViewModel notesViewModel;
  //
    @SuppressLint("CheckResult")
    public NoteAdapter(NotesViewModel notesViewModel) {
        this.notesViewModel = notesViewModel;


        notesViewModel.getAllTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(notes -> {
                    notesList = (List<NotesModel>) notes;
                    Log.e("Adapter", "" + notesList.size());
                    notifyDataSetChanged();

                }, throwable -> {
                    Log.e("Adapter", "" + throwable.getClass());
                });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, notes, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvTitle);
            notes = (TextView) view.findViewById(R.id.tvNotes);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NotesModel notesModel = notesList.get(position);
        holder.title.setText(notesModel.getTitle());
        holder.notes.setText(notesModel.getNotes());
       // holder.year.setText(notes.getDate());
    }

    @Override
    public int getItemCount() {
        return notesList!=null ? notesList.size():0;
    }
}