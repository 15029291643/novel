package com.example.novel.ui.base;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {
    public static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
