package com.example.novel.logic.model;


import androidx.room.TypeConverter;

import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.util.GsonUtils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ChapterConverter {

    @TypeConverter
    public String objectToString(List<Chapter> list) {
        return GsonUtils.getInstance().toJson(list);
    }

    @TypeConverter
    public List<Chapter> stringToObject(String json) {
        Type listType = new TypeToken<List<Chapter>>() {
        }.getType();
        return GsonUtils.getInstance().fromJson(json, listType);
    }
}