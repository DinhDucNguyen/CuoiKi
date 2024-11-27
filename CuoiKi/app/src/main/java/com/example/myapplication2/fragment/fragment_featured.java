package com.example.myapplication2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.ProductAdapter;
import com.example.myapplication2.ProductItem;
import com.example.myapplication2.R;

import java.util.ArrayList;
import java.util.List;

public class fragment_featured extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<ProductItem> itemList;

    public fragment_featured() {
        // Required empty public constructor
    }

    public static fragment_featured newInstance(String param1, String param2) {
        fragment_featured fragment = new fragment_featured();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Khởi tạo danh sách sản phẩm trong onCreate (hoặc onCreateView)
        itemList = new ArrayList<>();
        generateSampleData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_product, container, false);

        // Khởi tạo RecyclerView
        recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Gắn Adapter cho RecyclerView
        adapter = new ProductAdapter(getContext(), itemList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Phương thức tạo dữ liệu mẫu cho danh sách sản phẩm
    private void generateSampleData() {
        itemList.add(new ProductItem("Kem đánh răng", "Nguyễn Đình Đức", "sản phẩm làm trắng răng", R.drawable.product, false));
        itemList.add(new ProductItem("Chuột không dây", "Trần Đình Việt", " Sử dụng thuận tiện mọi lúc", R.drawable.product2, true));
        itemList.add(new ProductItem("Product 3", "Seller C", "Description 3", R.drawable.product, false));
        itemList.add(new ProductItem("Product 4", "Seller D", "Description 4", R.drawable.product2, true));
    }
}
