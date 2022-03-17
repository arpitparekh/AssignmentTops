package com.example.assignmenttops.sqllite_crud_operations.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PersonDataSql.class}, version = 1, exportSchema = false)
// export Schema false ma error avti hati
public abstract class AppDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}
