package com.example.sociallearningapp.ui.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sociallearningapp.data.model.Post;
import com.example.sociallearningapp.databinding.ItemPostBinding;
import java.util.ArrayList;
import java.util.List;


public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    private List<Post> ListPosts = new ArrayList<>();
    public void setListPosts(List<Post> listPosts) {
        this.ListPosts = listPosts;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position){
        Post CurrentPost = ListPosts.get(position);
        holder.binding.tvAuthorName.setText(CurrentPost.getAuthorName());
        holder.binding.tvTime.setText(CurrentPost.getTime());
        holder.binding.tvContent.setText(CurrentPost.getContent());
    }

    @Override
    public int getItemCount() {
        return ListPosts.size(); // Trả về tổng số bài viết đang có trong kho
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding binding; // Nắm giữ toàn bộ các thẻ View (TextView, ImageView...)

        public PostViewHolder(ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
