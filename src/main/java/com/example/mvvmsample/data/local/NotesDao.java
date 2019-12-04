package com.example.mvvmsample.data.local;


import com.example.mvvmsample.data.model.NotesModel;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Flowable;

@Dao
public interface NotesDao {

/*
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(NotesModel word);

*/

  /*  @Query("SELECT * from notes_table ORDER BY id ASC")
    List<NotesModel> getNotesModel();


    @Query("SELECT * from notes_table ORDER BY id ASC")
    LiveData<List<NotesModel>> notesModelLive();*/



    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(NotesModel notes);


    @Query("SELECT * from notes_table ORDER BY id ASC")
    Flowable<List<NotesModel>> getAllNotes();
}
