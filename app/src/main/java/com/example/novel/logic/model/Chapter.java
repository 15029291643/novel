package com.example.novel.logic.model;

import androidx.room.Entity;

import java.io.Serializable;
import java.util.List;

@Entity
public class Chapter implements Serializable {
    private String href;
    private String title;
    private List<String> content;

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
                "href='" + href + '\'' +
                ", title='" + title + '\'' +
                ", content=" + content +
                '}';
    }
}
