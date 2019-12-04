package com.example.mvvmsample.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_table")
public class NotesModel implements Comparable<NotesModel> {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int id;

    @NonNull
    @ColumnInfo(name = "title")
    String title;

    @NonNull
    @ColumnInfo(name = "notes")
    String notes;


    @Override
    public String toString() {
        return "NotesModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }


    public NotesModel(@NonNull String title, @NonNull String notes) {
        this.title = title;
        this.notes = notes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int compareTo(NotesModel notesModel) {
        return this.title.compareToIgnoreCase(notesModel.getTitle());
    }
}
