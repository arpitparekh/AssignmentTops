package com.example.assignmenttops.prepopulateRoom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {datatable.class},version = 1,exportSchema = false)
public abstract class DbDatabase extends RoomDatabase {

    public abstract DbDao dbDao();

    public static DbDatabase dbDatabase;

    public static DbDatabase getInstance(Context context){
        if(dbDatabase==null){
            dbDatabase= Room.databaseBuilder(context,DbDatabase.class,"FromAsset")
                    .createFromAsset("mydatabase.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return dbDatabase;
    }


}
