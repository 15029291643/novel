package com.example.novel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }
}
