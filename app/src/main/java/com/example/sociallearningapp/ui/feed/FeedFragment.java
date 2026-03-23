package com.example.sociallearningapp.ui.feed; // Sửa lại package nếu cần

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

// NHỚ IMPORT CÁC FILE NÀY CỦA BẠN:
import com.example.sociallearningapp.databinding.FragmentFeedBinding;
import com.example.sociallearningapp.ui.adapter.PostAdapter;
import com.example.sociallearningapp.ui.adapter.feed.StoryAdapter;

public class FeedFragment extends Fragment {

    // 1. Khai báo đồ nghề của Quản đốc
    private FragmentFeedBinding binding; // Khung giao diện
    private FeedViewModel viewModel;     // Nhà kho chứa dữ liệu
    private StoryAdapter storyAdapter;   // Anh công nhân 1
    private PostAdapter postAdapter;     // Anh công nhân 2

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Thổi phồng giao diện bằng ViewBinding
        binding = FragmentFeedBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ---------------------------------------------------------
        // PHẦN 1: SETUP BĂNG CHUYỀN VÀ CÔNG NHÂN (RECYCLERVIEW & ADAPTER)
        // ---------------------------------------------------------

        // A. Setup cho Story (Lướt Ngang)
        storyAdapter = new StoryAdapter();
        // Lệnh: Xếp danh sách theo chiều ngang (HORIZONTAL)
        binding.rvStories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvStories.setAdapter(storyAdapter); // Giao việc cho công nhân Story

        // B. Setup cho Post (Lướt Dọc)
        postAdapter = new PostAdapter();
        // Lệnh: Xếp danh sách theo chiều dọc (Mặc định của LinearLayoutManager là dọc)
        binding.rvFeed.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFeed.setAdapter(postAdapter); // Giao việc cho công nhân Post


        // ---------------------------------------------------------
        // PHẦN 2: KẾT NỐI VỚI NHÀ KHO (VIEWMODEL) & LẮNG NGHE DỮ LIỆU
        // ---------------------------------------------------------

        // Khởi tạo Nhà kho (ViewModel)
        viewModel = new ViewModelProvider(this).get(FeedViewModel.class);

        // A. Bật radio nghe kênh Story: Nếu có dữ liệu Story mới, ném ngay cho storyAdapter
        viewModel.getStories().observe(getViewLifecycleOwner(), stories -> {
            if (stories != null) {
                storyAdapter.setStories(stories);
            }
        });

        // B. Bật radio nghe kênh Post: Nếu có bài viết mới, ném ngay cho postAdapter
        viewModel.getPosts().observe(getViewLifecycleOwner(), posts -> {
            if (posts != null) {
                postAdapter.setListPosts(posts);
            }
        });
    }

    // Chống tràn RAM khi chuyển sang màn hình khác
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}