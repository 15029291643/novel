package com.example.novel.ui.chapter;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.novel.R;
import com.example.novel.databinding.FragmentChapterBinding;
import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.util.ConstantUtils;

public class ChapterFragment extends Fragment {
    private static final String TAG = "ChapterFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentChapterBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chapter, container, false);
        ChapterViewModel viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(ChapterViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getActivity());
        Catalog catalog = (Catalog) getArguments().getSerializable("catalog");
        int position = getArguments().getInt("position");
        viewModel.setChapterList(catalog.getChapterList());
        viewModel.setPosition(position);
        binding.chapterCatalog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.popBackStack();
            }
        });
        viewModel.getPosition().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.catalogScrollView.setScrollY(0);
            }
        });
        return binding.getRoot();
    }
}