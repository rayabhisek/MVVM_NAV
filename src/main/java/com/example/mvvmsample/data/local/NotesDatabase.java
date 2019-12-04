package com.example.mvvmsample.data.local;

import android.content.Context;


import com.example.mvvmsample.data.model.NotesModel;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NotesModel.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDao notesDao();
    private static volatile NotesDatabase INSTANCE;


    public static NotesDatabase newInstance(Context context){
        if (INSTANCE == null) {
            synchronized (NotesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            NotesDatabase.class, "Note.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
