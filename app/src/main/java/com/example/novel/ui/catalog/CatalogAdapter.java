package com.example.novel.ui.catalog;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
    private List<Chapter> mChapterList;

    public void setCatalogList(List<Chapter> catalogList) {
        mChapterList = catalogList;
        notifyDataSetChanged();
    }

    public CatalogAdapter(List<Chapter> chapterList) {
        mChapterList = chapterList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_catalog, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (mChapterList == null) {
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                Bundle bundle = new Bundle();
                bundle.putSerializable("chapter", mChapterList.get(position));
                controller.navigate(R.id.action_catalogFragment_to_chapterFragment, bundle);
            }
        });
        holder.title.setText(mChapterList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (mChapterList == null) {
            return 0;
        }
        return mChapterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.catalog_title);
        }
    }
}
