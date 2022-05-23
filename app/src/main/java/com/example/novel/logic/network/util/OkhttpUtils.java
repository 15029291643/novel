package com.example.novel.logic.network.util;

import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.callback.CatalogCallback;
import com.example.novel.logic.network.callback.ChapterCallback;
import com.example.novel.logic.network.callback.HtmlCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpUtils {
    private static final String TAG = "NovelUtils";

    private static void getHtml(String url, HtmlCallback callback) {
        Request request = new  Request.Builder()
                .url(url)
                .build();
        ClientUtils.getInstance().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String html = new String(response.body().bytes(), "gbk");
                callback.onResponse(html);
            }
        });
    }

    public static void getChapter(String url, ChapterCallback callback) {
        getHtml(url, new HtmlCallback() {
            @Override
            public void onResponse(String html) {
                Chapter chapter = JsoupUtils.toChapter(html);
                callback.onResponse(chapter);
            }
        });
    }

    public static void getCatalog(String url, CatalogCallback callback) {
        getHtml(url, new HtmlCallback() {
            @Override
            public void onResponse(String html) {
                Catalog catalog = JsoupUtils.toCatalog(html);
                callback.onResponse(catalog);
            }
        });
    }
}
