package com.example.mvvmsample.ui.addnotes;


import com.example.mvvmsample.data.local.NotesDataSource;
import com.example.mvvmsample.data.model.NotesModel;
import com.example.mvvmsample.ui.base.BaseViewModel;


import io.reactivex.Completable;
import io.reactivex.Flowable;



public class NotesViewModel extends BaseViewModel {

    private NotesDataSource notesDataSource;

    public NotesViewModel(NotesDataSource notesDataSource) {
        this.notesDataSource = notesDataSource;
    }

    public Flowable getAllTasks(){
        return notesDataSource.getAll();
    }

    public Completable insertNotes(NotesModel notesModel){
        return Completable.fromAction(() -> {
            notesDataSource.insert(notesModel);
        });
    }




}
