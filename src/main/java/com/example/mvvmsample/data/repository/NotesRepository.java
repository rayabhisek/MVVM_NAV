package com.example.mvvmsample.data.repository;

import android.app.Application;

import com.example.mvvmsample.data.local.NotesDao;
import com.example.mvvmsample.data.local.NotesRoomDatabase;
import com.example.mvvmsample.data.model.NotesModel;

import java.util.List;

import androidx.lifecycle.LiveData;


public class NotesRepository {

    private NotesDao notesDao;
    private LiveData<List<NotesModel>> mAllNotes;

    public NotesRepository(Application application) {
        NotesRoomDatabase db = NotesRoomDatabase.getDatabase(application);
        notesDao = db.notesDao();
        mAllNotes = notesDao.notesModelLive();
    }
    public LiveData<List<NotesModel>> getAllWords() {
        return mAllNotes;
    }

   public void insert(NotesModel notesModel) {
        NotesRoomDatabase.databaseWriteExecutor.execute(() -> {
            notesDao.insert(notesModel);
        });
    }
}
