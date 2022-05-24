package com.example.novel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.callback.CatalogCallback;
import com.example.novel.logic.network.callback.ChapterCallback;
import com.example.novel.logic.network.util.ConstantUtils;
import com.example.novel.logic.network.util.OkhttpUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSystemBarTransparent();
    }

    protected void setSystemBarTransparent(){
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}