package com.example.novel.logic.dao.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.novel.logic.dao.dao.CatalogDao;
import com.example.novel.logic.model.Catalog;

@Database(entities = {Catalog.class}, version = 1, exportSchema = false)
public abstract class CatalogDatabase extends RoomDatabase {
    private static CatalogDatabase sDatabase;

    public static CatalogDatabase getDatabase(Context context) {
        if (sDatabase == null) {
            sDatabase = Room.databaseBuilder(context, CatalogDatabase.class, "catalog")
                    .allowMainThreadQueries()
                    .build();
        }
        return sDatabase;
    }

    public abstract CatalogDao getChapterDao();
}
