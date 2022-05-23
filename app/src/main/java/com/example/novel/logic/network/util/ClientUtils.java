package com.example.novel.logic.network.util;

import okhttp3.OkHttpClient;

public class ClientUtils {
    private static OkHttpClient client;

    private ClientUtils() {
    }

    public static OkHttpClient getInstance() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }
}
