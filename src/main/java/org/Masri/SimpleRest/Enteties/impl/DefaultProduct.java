package org.Masri.SimpleRest.Enteties.impl;

import org.Masri.SimpleRest.Enteties.Product;

public class DefaultProduct implements Product {
    private int id;
    private String productName;
    private String categoryName;
    private Double price;
    private static int count = 0;

    public DefaultProduct(String productName, String categoryName, Double price) {
        this.id = ++count;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public int getId() {
        return this.id;
    }
    @Override
    public String getProductName() {
        return this.productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DefaultProduct{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                '}';
    }
}
