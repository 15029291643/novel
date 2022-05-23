package com.example.novel.ui.chapter;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.novel.R;
import com.example.novel.databinding.FragmentChapterBinding;
import com.example.novel.logic.model.Chapter;
import com.example.novel.logic.network.util.ConstantUtils;

public class ChapterFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentChapterBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chapter, container, false);
        ChapterViewModel viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(ChapterViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getActivity());
        viewModel.setChapter(ConstantUtils.CHAPTER_URL);
        return binding.getRoot();
    }
}