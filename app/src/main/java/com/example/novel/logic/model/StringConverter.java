package com.example.novel.logic.model;


import androidx.room.TypeConverter;

import com.example.novel.logic.network.util.GsonUtils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class StringConverter {

    @TypeConverter
    public String objectToString(List<String> list) {
        return GsonUtils.getInstance().toJson(list);
    }

    @TypeConverter
    public List<String> stringToObject(String json) {
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        return GsonUtils.getInstance().fromJson(json, listType);
    }
}