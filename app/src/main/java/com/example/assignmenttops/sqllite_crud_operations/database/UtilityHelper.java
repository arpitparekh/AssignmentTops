package com.example.assignmenttops.sqllite_crud_operations.database;

import android.content.Context;

import androidx.room.Room;

import com.example.assignmenttops.R;

public class UtilityHelper {

    public static AppDatabase getDataBase(Context context){
        AppDatabase database = Room.databaseBuilder(context,
                AppDatabase.class,
                context.getString(R.string.app_name))
                .allowMainThreadQueries()                     // allow on main thread
                .build();

        return database;
    }
}
