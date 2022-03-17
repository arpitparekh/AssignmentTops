package com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Data.class}, version = 1,exportSchema = false)
public abstract class ApplicationDatabase extends RoomDatabase {

    public abstract DataDao dataDao();

    private static ApplicationDatabase db;

    public static ApplicationDatabase getInstance(Context context) {

        if (db == null) {
            db = Room.databaseBuilder(context,ApplicationDatabase.class,"MyDatabase")
                    .allowMainThreadQueries()
                    .build();

        }
        return db;
    }

}
