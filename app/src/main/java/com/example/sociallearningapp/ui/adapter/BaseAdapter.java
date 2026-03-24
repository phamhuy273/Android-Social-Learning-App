package com.example.sociallearningapp.ui.adapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    // 1. Kho chứa hàng dùng chung
    protected List<T> itemList = new ArrayList<>();

    // 2. Hàm nhập hàng
    public void setItems(List<T> items) {
        this.itemList = items;
        notifyDataSetChanged();
    }

    // 3. Hàm đếm số lượng
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}