package com.example.novel.logic.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.List;

@Entity

public class Chapter implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String href;
    private String title;
    @TypeConverters(StringConverter.class)
    private List<String> content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", href='" + href + '\'' +
                ", title='" + title + '\'' +
                ", content=" + content +
                '}';
    }
}
