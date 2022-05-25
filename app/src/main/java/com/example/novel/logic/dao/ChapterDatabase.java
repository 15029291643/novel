package com.example.novel.logic.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.novel.logic.model.Chapter;

@Database(entities = {Chapter.class}, version = 1, exportSchema = false)
public abstract class ChapterDatabase extends RoomDatabase {
    public abstract ChapterDao getChapterDao();

    private static ChapterDatabase sDatabase;

    public static ChapterDatabase getInstance(Context content) {
        if (sDatabase == null) {
            sDatabase = Room.databaseBuilder(content, ChapterDatabase.class, "chapter")
                    .allowMainThreadQueries()
                    .build();
        }
        return sDatabase;
    }
}
