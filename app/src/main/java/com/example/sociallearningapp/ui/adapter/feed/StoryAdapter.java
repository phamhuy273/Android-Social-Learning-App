package com.example.sociallearningapp.ui.adapter.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sociallearningapp.data.model.Story;
import com.example.sociallearningapp.databinding.ItemFeedStoryBinding;
import com.example.sociallearningapp.ui.adapter.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class StoryAdapter extends BaseAdapter<Story, StoryAdapter.StoryViewHolder> {
    private static final int TYPE_ADD_STORY = 0;
    private static final int TYPE_STORY = 1;
    // 1. LẤY KHUÔN ĐÚC (Chỉ chạy lúc đầu)
    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Dùng ViewBinding để "thổi phồng" file item_story.xml lên
        ItemFeedStoryBinding binding = ItemFeedStoryBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new StoryViewHolder(binding);
    }

    // 2. ĐỔ DỮ LIỆU VÀO KHUÔN (Chạy liên tục khi lướt)
    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        Story currentStory = itemList.get(position);

        // Nhét tên và hình ảnh vào giao diện
        holder.binding.tvStoryName.setText(currentStory.getUserName());
        holder.binding.imgStoryAvatar.setImageResource(currentStory.getAvatarResId());

        // Bắt sự kiện khi bấm ô story
        holder.binding.getRoot().setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Đang mở story của " + currentStory.getUserName(), Toast.LENGTH_SHORT).show();
        });
    }

    // ==========================================
    // LỚP GIỮ KHUÔN (ViewHolder)
    // ==========================================
    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        ItemFeedStoryBinding binding;

        public StoryViewHolder(ItemFeedStoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}