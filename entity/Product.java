package com.teamfive.search_elastic.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.NotNull;


@Document(indexName = "ecomm", type = "products")
public class Product {
    @Id
    private String productId;
    @NotEmpty
    @NotNull
    private String productName;
    @NotEmpty
    @NotNull
    private String category;

    private String keyFeatures;
    private String description;

    @NotNull
    @NotEmpty
    private String imgURL;

    @NotNull
    private int bestPrice;

    @NotNull
    @NotEmpty
    private float productRating;

    @NotNull
    @NotEmpty
    private boolean isOutOfStock;

    public String getKeyFeatures() { return keyFeatures; }

    public void setKeyFeatures(String keyFeatures) { this.keyFeatures = keyFeatures; }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public int getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(int bestPrice) {
        this.bestPrice = bestPrice;
    }

    public float getProductRating() {
        return productRating;
    }

    public void setProductRating(float productRating) {
        this.productRating = productRating;
    }

    public boolean isOutOfStock() {
        return isOutOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        isOutOfStock = outOfStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", bestPrice=" + bestPrice +
                ", productRating=" + productRating +
                ", isOutOfStock=" + isOutOfStock +
                '}';
    }
}
