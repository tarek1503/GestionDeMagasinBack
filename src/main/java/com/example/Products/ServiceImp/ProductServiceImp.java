package com.example.Products.ServiceImp;

import com.example.Products.entity.Product;

import java.util.List;

public interface ProductServiceImp {
    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product> products);
    List<Product> getProducts();
    Product getProdcutById(long id);

    Product getProductByName(String nom);
    String deleteProduct(long id);
    Product updateProduct(Product product);
}
