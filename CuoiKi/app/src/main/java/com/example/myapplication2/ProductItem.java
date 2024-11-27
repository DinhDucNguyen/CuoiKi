package com.example.myapplication2;

public class ProductItem {
    private String productName;       // Tên sản phẩm
    private String sellerInfo;        // Thông tin người bán
    private String productDescription; // Mô tả sản phẩm
    private int productImage;         // ID ảnh sản phẩm (drawable resource)
    private boolean isFavorite;       // Trạng thái yêu thích

    // Constructor
    public ProductItem(String productName, String sellerInfo, String productDescription, int productImage, boolean isFavorite) {
        this.productName = productName;
        this.sellerInfo = sellerInfo;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.isFavorite = isFavorite;
    }

    // Getter và Setter
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(String sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
