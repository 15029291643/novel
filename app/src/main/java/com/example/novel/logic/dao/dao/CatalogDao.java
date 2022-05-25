package com.example.novel.logic.dao.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.novel.logic.model.Catalog;

import java.util.List;

@Dao
public interface CatalogDao {
    @Insert
    void insert(Catalog catalog);

    @Query("select * from Catalog where href == :url")
    Catalog selectByUrl(String url);

    @Query("select * from Catalog")
    List<Catalog> insertAll();
}
