package com.example.novel.ui.catalog;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.novel.R;
import com.example.novel.databinding.FragmentCatalogBinding;
import com.example.novel.databinding.FragmentChapterBinding;
import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.network.util.ConstantUtils;

public class CatalogFragment extends Fragment {
    private static final String TAG = "CatalogFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCatalogBinding binding = FragmentCatalogBinding.inflate(inflater, container, false);
        CatalogViewModel viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(CatalogViewModel.class);
        CatalogAdapter adapter = new CatalogAdapter();
        binding.catalogRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.catalogRecyclerView.setAdapter(adapter);
        viewModel.getCatalogList().observe(getActivity(), new Observer<Catalog>() {
            @Override
            public void onChanged(Catalog catalog) {
               adapter.setCatalog(catalog);
               binding.catalogTitle.setText(catalog.getTitle());
            }
        });
        viewModel.setCatalogList(ConstantUtils.CATALOG_URL);
        return binding.getRoot();
    }
}