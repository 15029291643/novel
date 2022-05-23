package com.example.novel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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
    }
}