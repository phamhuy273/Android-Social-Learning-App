package com.example.sociallearningapp.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sociallearningapp.R;
import com.example.sociallearningapp.databinding.ActivityMainBinding;
import com.example.sociallearningapp.ui.feed.FeedFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // Hàm thay đổi bức tranh (Fragment) trên khung MainActivity
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Khởi tạo giao diện bằng ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //báo biết kích thước của mấy cái thanh hệ thống (Pin, Sóng, Giờ...) "
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {

            // 1. Lấy thông số (Insets) của các thanh hệ thống (System Bars)
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, systemBars.top, 0, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
        if (savedInstanceState == null) {
            replaceFragment(new FeedFragment());
        }
    }
}