package com.example.roomtest.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface toyDao {
    @Query("SELECT * FROM toyInfo")
    List<toyInfo> getAll();

    @Query("SELECT * FROM toyInfo WHERE mId IN (:toyIds)")
    List<toyInfo> loadAllByIds(int[] toyIds);

    @Insert
    void insert(toyInfo... toyInfos);

    @Delete
    void delete(toyInfo toyInfo);
}
