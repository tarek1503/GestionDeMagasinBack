package com.example.products.ServiceImp;

import com.example.products.entity.Product;

import java.util.List;

public interface IProductService {
    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product> products);
    List<Product> getProducts();
    Product getProdcutById(long id);

    Product getProductByName(String nom);
    String deleteProduct(long id);
    Product updateProduct(Product product);
    List<Product> getProductsByCategory(Long id);
/*
    String addProductToCategory(Long idCategory,Long idProduct);
*/
}
