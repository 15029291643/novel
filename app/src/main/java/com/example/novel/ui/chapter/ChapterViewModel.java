package com.example.novel.ui.chapter;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.callback.ChapterCallback;
import com.example.novel.logic.network.util.OkhttpUtils;

public class ChapterViewModel extends ViewModel {
    private MutableLiveData<Chapter> mChapter = new MutableLiveData<>();
    private LiveData<String> mContent = Transformations.map(mChapter, new Function<Chapter, String>() {
        @Override
        public String apply(Chapter input) {
            if (input == null || input.getContent() == null) {
                return null;
            }
            StringBuilder builder = new StringBuilder();
            for (String s : input.getContent()) {
                builder.append(s)
                        .append("\n\n\n");
            }
            return builder.toString();
        }
    });

    public LiveData<String> getContent() {
        return mContent;
    }

    public MutableLiveData<Chapter> getChapter() {
        if (mChapter.getValue() == null) {
            mChapter.setValue(new Chapter());
        }
        return mChapter;
    }

    public void setChapter(String url) {
        OkhttpUtils.getChapter(url, new ChapterCallback() {
            @Override
            public void onResponse(Chapter chapter) {
                mChapter.postValue(chapter);
            }
        });
    }
}
