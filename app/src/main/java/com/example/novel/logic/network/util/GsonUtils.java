package com.example.novel.logic.network.util;

import com.google.gson.Gson;

public class GsonUtils {
    private static Gson sInstance;

    public static Gson getInstance() {
        if (sInstance == null) {
            sInstance = new Gson();
        }
        return sInstance;
    }
}
