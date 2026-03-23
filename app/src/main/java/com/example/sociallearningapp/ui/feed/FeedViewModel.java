package com.example.sociallearningapp.ui.feed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sociallearningapp.data.model.Post;
import com.example.sociallearningapp.data.model.Story;

import java.util.ArrayList;
import java.util.List;

public class FeedViewModel extends ViewModel {
    private final MutableLiveData<List<Story>> storiesLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Post>> postsLiveData = new MutableLiveData<>();
    public FeedViewModel()
    {
        loadMockData();
    }

    public LiveData<List<Story>> getStories() { return storiesLiveData; }
    public LiveData<List<Post>> getPosts() { return postsLiveData; }
    private void loadMockData() {
        // 1. Tạo dữ liệu giả cho Story
        List<Story> dummyStories = new ArrayList<>();
        // Lưu ý: Thay R.drawable.ic_launcher_background bằng ảnh thật trong file drawable của bạn
        dummyStories.add(new Story("Tin của bạn", android.R.drawable.ic_menu_camera));
        dummyStories.add(new Story("Quang Huy", android.R.drawable.ic_menu_gallery));
        dummyStories.add(new Story("Thành viên A", android.R.drawable.ic_menu_compass));
        dummyStories.add(new Story("Thành viên B", android.R.drawable.ic_menu_share));
        dummyStories.add(new Story("Tin của bạn", android.R.drawable.ic_menu_camera));
        dummyStories.add(new Story("Quang Huy", android.R.drawable.ic_menu_gallery));
        dummyStories.add(new Story("Thành viên A", android.R.drawable.ic_menu_compass));
        dummyStories.add(new Story("Thành viên B", android.R.drawable.ic_menu_share));
        dummyStories.add(new Story("Tin của bạn", android.R.drawable.ic_menu_camera));
        dummyStories.add(new Story("Quang Huy", android.R.drawable.ic_menu_gallery));
        dummyStories.add(new Story("Thành viên A", android.R.drawable.ic_menu_compass));
        dummyStories.add(new Story("Thành viên B", android.R.drawable.ic_menu_share));
        storiesLiveData.setValue(dummyStories);

        // 2. Tạo dữ liệu giả cho Post
        List<Post> dummyPosts = new ArrayList<>();
        dummyPosts.add(new Post("Quang Huy", "Vừa xong", "Xin chào mọi người! Đồ án app mạng xã hội học tập của nhóm mình sắp hoàn thiện giao diện rồi.", android.R.drawable.ic_menu_gallery));
        dummyPosts.add(new Post("Giảng viên", "2 giờ trước", "Nhắc nhở: Tuần sau các nhóm nộp báo cáo tiến độ nhé.", android.R.drawable.ic_menu_info_details));
        dummyPosts.add(new Post("Sinh viên IT", "Hôm qua", "Cần tìm tài liệu về Spring Boot, anh em nào có share mình với!", android.R.drawable.ic_menu_help));
        dummyPosts.add(new Post("Quang Huy", "Vừa xong", "Xin chào mọi người! Đồ án app mạng xã hội học tập của nhóm mình sắp hoàn thiện giao diện rồi.", android.R.drawable.ic_menu_gallery));
        dummyPosts.add(new Post("Giảng viên", "2 giờ trước", "Nhắc nhở: Tuần sau các nhóm nộp báo cáo tiến độ nhé.", android.R.drawable.ic_menu_info_details));
        dummyPosts.add(new Post("Sinh viên IT", "Hôm qua", "Cần tìm tài liệu về Spring Boot, anh em nào có share mình với!", android.R.drawable.ic_menu_help));
        dummyPosts.add(new Post("Quang Huy", "Vừa xong", "Xin chào mọi người! Đồ án app mạng xã hội học tập của nhóm mình sắp hoàn thiện giao diện rồi.", android.R.drawable.ic_menu_gallery));
        dummyPosts.add(new Post("Giảng viên", "2 giờ trước", "Nhắc nhở: Tuần sau các nhóm nộp báo cáo tiến độ nhé.", android.R.drawable.ic_menu_info_details));
        dummyPosts.add(new Post("Sinh viên IT", "Hôm qua", "Cần tìm tài liệu về Spring Boot, anh em nào có share mình với!", android.R.drawable.ic_menu_help));
        postsLiveData.setValue(dummyPosts);
    }
}
