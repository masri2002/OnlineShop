package org.Masri.SimpleRest.Enteties.impl;

import org.Masri.SimpleRest.Enteties.Cart;
import org.Masri.SimpleRest.Enteties.Product;

import java.util.ArrayList;
import java.util.List;

public class DefaultCart implements Cart {
    private List<Product> products =new ArrayList<Product>();

    public DefaultCart() {
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public void addProduct(Product productById) {
     products.add(productById);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void clear() {
     products.clear();
    }
}
