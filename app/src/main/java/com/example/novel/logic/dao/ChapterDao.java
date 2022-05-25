package com.example.novel.logic.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.model.Chapter;

import java.util.List;

@Dao
public interface ChapterDao {
    @Insert
    void insert(Chapter chapter);

    @Query("select * from Chapter where href = :url")
    Chapter selectByUrl(String url);

    @Query("select * from Chapter")
    List<Chapter> selectAll();
 }
