/*
 * *
 *  * Created by Abhisek on 11/25/19 6:00 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 6:00 PM
 *
 */

package com.example.mvvmsample.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmsample.R;
import com.example.mvvmsample.data.model.Notes;
import com.example.mvvmsample.data.model.NotesModel;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter  extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private List<NotesModel> notesList;
    private List<NotesModel> notes =new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, notes, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvTitle);
            notes = (TextView) view.findViewById(R.id.tvNotes);

        }
    }
/*     NoteAdapter(List<NotesModel> notesList) {
        this.notesList = notesList;
    }*/

    public void setNotes(List<NotesModel> notes){
        this.notes = notes;
        notifyDataSetChanged();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      //  NotesModel notes = notesList.get(position);
        NotesModel notesModel = notes.get(position);
        holder.title.setText(notesModel.getTitle());
        holder.notes.setText(notesModel.getNotes());
       // holder.year.setText(notes.getDate());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}