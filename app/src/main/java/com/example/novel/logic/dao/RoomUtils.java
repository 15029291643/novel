package com.example.novel.logic.dao;

import android.util.Log;

import androidx.room.Room;

import com.example.novel.BaseApplication;
import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.callback.ChapterCallback;

import java.util.List;

import javax.security.auth.callback.Callback;

public class RoomUtils {
    private static final String TAG = "RoomUtils";
    private static ChapterDao sChapterDao;

    private static ChapterDao getChapterDao() {
        if (sChapterDao == null) {
            sChapterDao = ChapterDatabase.getInstance(BaseApplication.getContext()).getChapterDao();
        }
        return sChapterDao;
    }

    public static void getChapter(String url, ChapterCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Chapter chapter = getChapterDao().selectByUrl(url);
                callback.onResponse(chapter);
            }
        }).start();
    }

    public static void insert(Chapter chapter) {
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
}
