package com.example.novel.ui.chapter;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.callback.ChapterCallback;
import com.example.novel.logic.network.WarehouseUtils;

import java.util.List;

public class ChapterViewModel extends ViewModel {
    private static final String TAG = "ChapterViewModel";

    private List<Chapter> mChapterList;
    private MutableLiveData<Integer> mPosition = new MutableLiveData<>(0);
    private MutableLiveData<Chapter> mChapter = new MutableLiveData<>();

    private LiveData<String> mTitle = Transformations.map(mChapter, new Function<Chapter, String>() {
        @Override
        public String apply(Chapter input) {
            if (input == null) {
                return "";
            }
            return "第" + (mPosition.getValue() + 1) + "章" + input.getTitle();
        }
    });

    private LiveData<String> mContent = Transformations.map(mChapter, new Function<Chapter, String>() {
        @Override
        public String apply(Chapter input) {
            if (input == null || input.getContent() == null) {
                return null;
            }
            StringBuilder builder = new StringBuilder();
            for (String s : input.getContent()) {
                builder.append("\n\n")
                        .append("        ")
                        .append(s);
            }
            return builder.append("\n\n").toString();
        }
    });

    public void setPosition(int position) {
        mPosition.setValue(position);
        WarehouseUtils.getChapter(mChapterList.get(position).getHref(), new ChapterCallback() {
            @Override
            public void onResponse(Chapter chapter) {
                Log.e(TAG, "onResponse: " + chapter);
                mChapter.postValue(chapter);
            }
        });
    }

    public void toPrevious() {
        if (mPosition.getValue() - 1 >= 0) {
            setPosition(mPosition.getValue() - 1);
        }
    }

    public void toNext() {
        if (mPosition.getValue() + 1 < mChapterList.size()) {
            setPosition(mPosition.getValue() + 1);
        }
    }

    public MutableLiveData<Integer> getPosition() {
        return mPosition;
    }

    public void setChapterList(List<Chapter> chapterList) {
        mChapterList = chapterList;
    }

    public LiveData<String> getTitle() {
        return mTitle;
    }

    public LiveData<String> getContent() {
        return mContent;
    }
}
