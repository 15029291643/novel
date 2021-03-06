package com.example.novel.ui.catalog;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.network.callback.CatalogCallback;
import com.example.novel.logic.network.util.OkhttpUtils;

import java.util.List;

public class CatalogViewModel extends ViewModel {
    private MutableLiveData<Catalog> mCatalogList = new MutableLiveData<>();

    public MutableLiveData<Catalog> getCatalogList() {
        if (mCatalogList == null) {
            mCatalogList.setValue(new Catalog());
        }
        return mCatalogList;
    }

    public void setCatalogList(String url) {
        OkhttpUtils.getCatalog(url, new CatalogCallback() {
            @Override
            public void onResponse(Catalog catalog) {
                mCatalogList.postValue(catalog);
            }
        });
    }
}
