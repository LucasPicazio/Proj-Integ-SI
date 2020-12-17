package com.pisi.marketplace.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResource {


    @JsonProperty("productName")
    private String productName;

    @JsonProperty("productType")
    private String productType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("stock")
    private int stock;

    @JsonProperty("price")
    private int price;

    @JsonProperty("imageSource")
    private String imageSource;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    @Override
    public String toString() {
        return "ProductResource [productName=" + productName + ", productType=" + productType + ", description="
                + description + ", stock=" + stock + ", price=" + price + ", imageSource=" + imageSource + "]";
    }

}
