package com.example.assignmenttops.prepopulateRoom;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DbDao {

    @Query("select*from datatable")
    List<datatable> getAllDbData();

}
