package com.example.mvvmsample.ui.addnotes;

import android.app.Application;


import com.example.mvvmsample.data.repository.NotesRepository;
import com.example.mvvmsample.data.model.NotesModel;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class NotesViewModel extends AndroidViewModel {

    private NotesRepository mRepository;

    private LiveData<List<NotesModel>> mAllWords;

    public NotesViewModel(Application application) {
        super(application);
        mRepository = new NotesRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<NotesModel>> getAllNotes() { return mAllWords; }

    public void insert(NotesModel notes) {
        mRepository.insert(notes);
    }


}
