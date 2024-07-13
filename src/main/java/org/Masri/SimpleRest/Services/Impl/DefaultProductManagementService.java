package org.Masri.SimpleRest.Services.Impl;

import org.Masri.SimpleRest.Enteties.Product;
import org.Masri.SimpleRest.Enteties.impl.DefaultProduct;
import org.Masri.SimpleRest.Services.ProductManagementService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DefaultProductManagementService implements ProductManagementService {
    private static DefaultProductManagementService  instance;
   static  List<Product> products ;
    static {
        products=new ArrayList<>();
        products.add(new DefaultProduct("LapTop HP","Electric",450.66));
        products.add(new DefaultProduct("LapTop Dell","Electric",750.00));
        products.add(new DefaultProduct("LapTop Asus","Electric",650.00));
        products.add(new DefaultProduct("LapTop Lenovo","Electric",950.76));
        products.add(new DefaultProduct("LapTop Acer","Electric",1200.00));
        products.add(new DefaultProduct("LapTop Mis","Electric",2500.66));
        products.add(new DefaultProduct("LapTop Microsoft","Electric",900.50));
        products.add(new DefaultProduct("LapTop Mac","Electric",1450.65));
    }
    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int productIdToAddToCart) {
        Stream<Product> stream = products.stream().filter(product -> product.getId() == productIdToAddToCart);
        return stream.findFirst().orElse(null);
    }

    public static DefaultProductManagementService getInstance() {
        if(instance==null){
            instance = new DefaultProductManagementService();
        }
        return instance;
    }
}
