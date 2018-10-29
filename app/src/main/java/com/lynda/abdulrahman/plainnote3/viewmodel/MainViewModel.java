package com.lynda.abdulrahman.plainnote3.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.lynda.abdulrahman.plainnote3.database.AppRepository;
import com.lynda.abdulrahman.plainnote3.database.NoteEntity;
import com.lynda.abdulrahman.plainnote3.utilities.SampleData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public LiveData<List<NoteEntity>>mNoteEntityList;
    private AppRepository mRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository=AppRepository.getInstance(application.getApplicationContext());
        mNoteEntityList=mRepository.mNotes;
    }

    public void addSampleData() {
        mRepository.addSampleData();
    }

    public void deleteAllData() {
        mRepository.deleteAllData();

    }
}
