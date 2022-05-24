package com.example.novel.logic.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.model.Chapter;

@Dao
public interface ChapterDao {
    @Insert
    void insert(Chapter chapter);

    @Query("select * from Chapter WHERE href = :url")
    Chapter get(String url);
 }
