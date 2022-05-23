package com.example.novel.logic.model;

import java.util.List;

public class Catalog {
    private String title;
    private List<Chapter> chapterList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "title='" + title + '\'' +
                ", chapterList=" + chapterList +
                '}';
    }
}
