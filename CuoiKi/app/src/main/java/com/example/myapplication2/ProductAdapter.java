package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<ProductItem> productList;

    // Constructor
    public ProductAdapter(Context context, List<ProductItem> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductItem product = productList.get(position);

        // Ánh xạ dữ liệu vào các thành phần giao diện
        holder.productName.setText(product.getProductName());
        holder.sellerInfo.setText(product.getSellerInfo());
        holder.productDescription.setText(product.getProductDescription());
        holder.productImage.setImageResource(product.getProductImage());

        // Xử lý trạng thái yêu thích
        if (product.isFavorite()) {
            holder.favoriteIcon.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            holder.favoriteIcon.setImageResource(android.R.drawable.btn_star_big_off);
        }

        // Sự kiện khi nhấn nút yêu thích
        holder.favoriteIcon.setOnClickListener(v -> {
            product.setFavorite(!product.isFavorite());
            notifyItemChanged(position);
        });

        // Xử lý sự kiện cho biểu tượng giỏ hàng
        holder.cartIcon.setOnClickListener(v -> {
            // Thực hiện hành động thêm vào giỏ hàng (hiện tại để trống)
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName, sellerInfo, productDescription;
        ImageView productImage, cartIcon, favoriteIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Ánh xạ các thành phần từ layout
            productName = itemView.findViewById(R.id.product_name);
            sellerInfo = itemView.findViewById(R.id.seller_info);
            productDescription = itemView.findViewById(R.id.product_description);
            productImage = itemView.findViewById(R.id.product_image);
            cartIcon = itemView.findViewById(R.id.cart_icon);
            favoriteIcon = itemView.findViewById(R.id.favorite_icon);
        }
    }
}
