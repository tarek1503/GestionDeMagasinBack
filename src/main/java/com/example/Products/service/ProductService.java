package com.example.Products.service;

import com.example.Products.ServiceImp.ProductServiceImp;
import com.example.Products.DAO.ProductRepository;
import com.example.Products.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    private ProductRepository productRepo ;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> saveProducts(List<Product> products) {
        return productRepo.saveAll(products);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProdcutById(long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product getProductByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public String deleteProduct(long id) {
        productRepo.deleteById(id);
        return "product removed !!" +id;
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productRepo.findById(product.getIdProduct()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setQuantiteStock(product.getQuantiteStock());
        existingProduct.setPrix(product.getPrix());
        /*existingProduct.setLigneCommandes(product.getLigneCommandes());
        existingProduct.setCategory(product.getCategory());*/

        return productRepo.save(existingProduct);
    }

}
