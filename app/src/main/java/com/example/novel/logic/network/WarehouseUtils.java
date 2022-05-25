package com.example.novel.logic.network;

import android.util.Log;
import android.widget.Toast;

import androidx.room.Room;

import com.example.novel.logic.dao.RoomUtils;
import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.callback.CatalogCallback;
import com.example.novel.logic.network.callback.ChapterCallback;
import com.example.novel.logic.network.util.OkhttpUtils;
import com.example.novel.ui.util.ToastUtils;

public class WarehouseUtils {
    private static final String TAG = "WarehouseUtils";

    public static void getChapter(String url, ChapterCallback callback) {
        RoomUtils.getChapterByUrl(url, new ChapterCallback() {
            @Override
            public void onResponse(Chapter chapter) {
                if (chapter != null) {
                    Log.e(TAG, "onResponse: " + "本地");
                    callback.onResponse(chapter);
                    return;
                }
                OkhttpUtils.getChapter(url, new ChapterCallback() {
                    @Override
                    public void onResponse(Chapter chapter) {
                        Log.e(TAG, "onResponse: " + "网络");
                        RoomUtils.addChapter(chapter);
                        callback.onResponse(chapter);
                    }
                });
            }
        });
    }

    public static void getCatalogByUrl(String url, CatalogCallback callback) {
        RoomUtils.getCatalogByUrl(url, new CatalogCallback() {
            @Override
            public void onResponse(Catalog catalog) {
                if (catalog != null) {
                    Log.e(TAG, "onResponse: " + "本地");
                    callback.onResponse(catalog);
                    return;
                }
                OkhttpUtils.getCatalog(url, new CatalogCallback() {
                    @Override
                    public void onResponse(Catalog catalog) {
                        Log.e(TAG, "onResponse: " + "网络");
                        RoomUtils.addCatalog(catalog);
                        callback.onResponse(catalog);
                    }
                });
            }
        });
    }
}
