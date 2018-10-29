package com.lynda.abdulrahman.plainnote3;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.intent.IntentStubberRegistry;
import android.util.Log;

import com.lynda.abdulrahman.plainnote3.database.AppDatabase;
import com.lynda.abdulrahman.plainnote3.database.NoteDao;
import com.lynda.abdulrahman.plainnote3.database.NoteEntity;
import com.lynda.abdulrahman.plainnote3.utilities.SampleData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG="JUnit";
    private AppDatabase mDb;
    private NoteDao mDao;
    @Before
    public  void createDb(){
        Context context= InstrumentationRegistry.getContext();
        mDb= Room
                .inMemoryDatabaseBuilder(context,AppDatabase.class)
                .build();
        mDao=mDb.noteDao();
        Log.i(TAG,"Db Created ");
    }

    @After
    public  void closeDb(){
       mDb.close();;
        Log.i(TAG,"Db Closed ");
    }

    @Test
    public void createAndRetrieveNotes(){
        mDao.InsertAll(SampleData.getNotes());
        int count=mDao.getNotesCount();
        Log.i(TAG,"Create and retrieve notes :  count - "+count);

        assertEquals(SampleData.getNotes().size(),count);
    }
    @Test
    public void compareString(){
        mDao.InsertAll(SampleData.getNotes());
       NoteEntity  noteEntity=mDao.getNoteById(1);
        NoteEntity  original=SampleData.getNotes().get(0);


        Log.i(TAG,"Create and retrieve notes :  String - "+noteEntity.getText());

        assertEquals(noteEntity.getText(),original.getText());
    }
}
