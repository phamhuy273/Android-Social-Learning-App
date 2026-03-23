package com.example.sociallearningapp.ui.adapter.feed; // Sửa lại nếu bạn để ở thư mục khác

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sociallearningapp.data.model.Story; // Import đúng đường dẫn model của bạn
import com.example.sociallearningapp.databinding.ItemStoryBinding;

import java.util.ArrayList;
import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    // Kho chứa nguyên liệu (Danh sách các Story)
    private List<Story> storyList = new ArrayList<>();

    //  (Fragment) sẽ gọi hàm này để ném dữ liệu mới vào
    public void setStories(List<Story> stories) {
        this.storyList = stories;
        notifyDataSetChanged();
    }

    // 1. LẤY KHUÔN ĐÚC (Chỉ chạy lúc đầu)
    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Dùng ViewBinding để "thổi phồng" file item_story.xml lên
        ItemStoryBinding binding = ItemStoryBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new StoryViewHolder(binding);
    }

    // 2. ĐỔ DỮ LIỆU VÀO KHUÔN (Chạy liên tục khi lướt)
    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        Story currentStory = storyList.get(position);

        // Nhét tên và hình ảnh vào giao diện
        holder.binding.tvStoryName.setText(currentStory.getUserName());
        holder.binding.imgStoryAvatar.setImageResource(currentStory.getAvatarResId());

        // Bắt sự kiện khi bấm ô story
        holder.binding.getRoot().setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Đang mở story của " + currentStory.getUserName(), Toast.LENGTH_SHORT).show();
        });
    }

    // 3. ĐẾM SỐ LƯỢNG HÀNG
    @Override
    public int getItemCount() {
        return storyList.size();
    }

    // ==========================================
    // LỚP GIỮ KHUÔN (ViewHolder)
    // ==========================================
    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        ItemStoryBinding binding;

        public StoryViewHolder(ItemStoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}