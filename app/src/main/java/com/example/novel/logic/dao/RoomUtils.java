package com.example.novel.logic.dao;

import android.util.Log;

import com.example.novel.ui.base.BaseApplication;
import com.example.novel.logic.dao.dao.CatalogDao;
import com.example.novel.logic.dao.dao.ChapterDao;
import com.example.novel.logic.dao.database.CatalogDatabase;
import com.example.novel.logic.dao.database.ChapterDatabase;
import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.callback.CatalogCallback;
import com.example.novel.logic.network.callback.ChapterCallback;

import java.util.List;

public class RoomUtils {
    private static final String TAG = "RoomUtils";
    private static ChapterDao sChapterDao;
    private static CatalogDao sCatalogDao;

    private static ChapterDao getChapterDao() {
        if (sChapterDao == null) {
            sChapterDao = ChapterDatabase.getInstance(BaseApplication.getContext()).getChapterDao();
        }
        return sChapterDao;
    }

    private static CatalogDao getCatalogDao() {
        if (sCatalogDao == null) {
            sCatalogDao = CatalogDatabase.getDatabase(BaseApplication.getContext()).getChapterDao();
        }
        return sCatalogDao;
    }

    public static void getChapterByUrl(String url, ChapterCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Chapter chapter = getChapterDao().selectByUrl(url);
                callback.onResponse(chapter);
            }
        }).start();
    }

    public static void addChapter(Chapter chapter) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getChapterDao().insert(chapter);
            }
        }).start();
    }

    public static void getChapterAll() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Chapter> chapters = getChapterDao().selectAll();
                for (Chapter chapter : chapters) {
                    Log.e(TAG, "run: " + chapter);
                }
            }
        }).start();
    }

    public static void addCatalog(Catalog catalog) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getCatalogDao().insert(catalog);
            }
        }).start();
    }

    public static void getCatalogByUrl(String url, CatalogCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Catalog catalog = getCatalogDao().selectByUrl(url);
                callback.onResponse(catalog);
            }
        }).start();
    }
}
