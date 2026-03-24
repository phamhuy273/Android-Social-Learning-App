package com.example.sociallearningapp.ui.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sociallearningapp.data.model.Post;
import com.example.sociallearningapp.databinding.ItemFeedPostBinding;
import com.example.sociallearningapp.ui.feed.FeedFragment;
import java.util.ArrayList;
import java.util.List;


public class PostAdapter  extends BaseAdapter<Post, PostAdapter.PostViewHolder>{

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFeedPostBinding binding = ItemFeedPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
         return new PostViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position){
        Post CurrentPost = itemList.get(position);
        holder.binding.tvAuthorName.setText(CurrentPost.getAuthorName());
        holder.binding.tvTime.setText(CurrentPost.getTime());
        holder.binding.tvContent.setText(CurrentPost.getContent());
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ItemFeedPostBinding binding; // Nắm giữ toàn bộ các thẻ View (TextView, ImageView...)

        public PostViewHolder(ItemFeedPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
