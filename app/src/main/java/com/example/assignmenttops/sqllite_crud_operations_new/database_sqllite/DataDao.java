package com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDao {

    @Insert
    void InsertData(Data data);

    @Update
    void UpdateData(Data data);

    @Delete
    void deleteData(Data data);
    
    @Query("select * from Data")
    List<Data>getAllData();


}
