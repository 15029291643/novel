package com.example.novel.ui.util;

import android.os.Looper;
import android.widget.Toast;

import com.example.novel.ui.base.BaseActivity;
import com.example.novel.ui.base.BaseApplication;


public class ToastUtils {
    // Can't toast on a thread that has not called Looper.prepare()
    /*public static void showOnUiThread(String message) {
        if (!isMainThread()) {
            BaseActivity.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    show(message);
                }
            });
        } else {
            show(message);
        }
    }*/

    public static void show(String message) {
        Toast.makeText(BaseApplication.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() != Looper.myLooper();
    }
}
