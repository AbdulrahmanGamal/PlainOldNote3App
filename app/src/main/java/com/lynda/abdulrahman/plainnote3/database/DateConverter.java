package com.lynda.abdulrahman.plainnote3.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timeStamp){
        return  timeStamp==null ? null : new Date(timeStamp);
    }
    @TypeConverter
    public static Long toLongTimeStamp(Date date){
        return  date==null ? null : date.getTime();
    }
}
