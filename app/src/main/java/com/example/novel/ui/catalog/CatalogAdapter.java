package com.example.novel.ui.catalog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novel.R;
import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.model.Chapter;

import java.util.List;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {
    private static final String TAG = "CatalogAdapter";

    private List<Chapter> mChapterList;
    private Catalog mCatalog;


    @SuppressLint("NotifyDataSetChanged")
    public void setCatalog(Catalog catalog) {
        mCatalog = catalog;
        mChapterList = mCatalog.getChapterList();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_catalog, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (mChapterList == null) {
            return;
        }
        holder.itemView.setOnClickListener(v -> {
            NavController controller = Navigation.findNavController(v);
            Bundle bundle = new Bundle();
            bundle.putSerializable("catalog", mCatalog);
            bundle.putInt("position", position);
            Log.e(TAG, "onClick: " + position);
            controller.navigate(R.id.action_catalogFragment_to_chapterFragment, bundle);
        });
        holder.title.setText("第" + (position + 1) + "章" + " " + mChapterList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (mChapterList == null) {
            return 0;
        }
        return mChapterList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.catalog_title);
        }
    }
}
