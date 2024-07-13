package org.Masri.SimpleRest.Services;

import org.Masri.SimpleRest.Enteties.Product;

import java.util.List;

public interface ProductManagementService {
    List<Product> getProducts();

    Product getProductById(int productIdToAddToCart);
}
