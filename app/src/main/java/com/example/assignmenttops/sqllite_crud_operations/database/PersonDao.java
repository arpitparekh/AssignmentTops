package com.example.assignmenttops.sqllite_crud_operations.database;

import android.app.Person;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    void savePerson(PersonDataSql personDataSql);

    @Update
    void updatePerson(PersonDataSql personDataSql);

    @Delete
    void deletePerson(PersonDataSql personDataSql);

    @Query("Select * From PersonDataSql")
    List<PersonDataSql> getPersonData();

}
