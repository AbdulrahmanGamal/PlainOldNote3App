package com.lynda.abdulrahman.plainnote3.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface NoteDao {

    //This OnConflictStrategy used to make this method for insert and update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertNote(NoteEntity note);


    //This OnConflictStrategy used to make this method for insert and update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertAll(List<NoteEntity> noteEntityList);

    @Delete
    void deleteNote(NoteEntity noteEntity);

    @Query( "SELECT * FROM notes WHERE id = :id")
    NoteEntity getNoteById(int id);

    @Query( "SELECT * FROM notes ORDER BY date DESC")
    LiveData<List<NoteEntity>> getAllNotes();


    @Query( "DELETE  FROM notes ")
    int deleteAllNotes();

    @Query( "SELECT COUNT(*) FROM notes")
    int getNotesCount();


}
