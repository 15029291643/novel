package com.example.novel.logic.network.util;

import android.util.Log;

import com.example.novel.logic.dao.RoomUtils;
import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.callback.ChapterCallback;

public class WarehouseUtils {
    private static final String TAG = "WarehouseUtils";

    public static void getChapter(String url, ChapterCallback callback) {
        RoomUtils.getChapter(url, new ChapterCallback() {
            @Override
            public void onResponse(Chapter chapter) {
                if (chapter != null) {
                    Log.e(TAG, "onResponse: " + "本地返回");
                    Log.e(TAG, "onResponse: " + chapter);
                    callback.onResponse(chapter);
                    return;
                }
                OkhttpUtils.getChapter(url, new ChapterCallback() {
                    @Override
                    public void onResponse(Chapter chapter) {
                        Log.e(TAG, "onResponse: " + "网络返回");
                        Log.e(TAG, "onResponse: " + chapter);
                        RoomUtils.insert(chapter);
                        callback.onResponse(chapter);
                    }
                });
            }
        });
    }
}
