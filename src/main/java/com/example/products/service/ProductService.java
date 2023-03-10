package com.example.products.service;

import com.example.products.repository.CategoryRepository;
import com.example.products.repository.ProductRepository;
import com.example.products.ServiceImp.IProductService;
import com.example.products.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepo;

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
        return "product removed !!" + id;
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

    @Override
    public List<Product> getProductsByCategory(Long id) {
        return productRepo.findProductsByCategory_Id(id);
    }



/*@Override
    public String addProductToCategory(Long idCategory, Long idProduct) {
        Category category = categoryRepo.findById(idCategory).orElse(null);
        Product product = productRepo.findById(idProduct).orElse(null);
        List<Product> productsCategory = category.getProducts();
        int x = 0;

        for (Product p : productsCategory) {
            if (p.getIdProduct() == product.getIdProduct()) {
                x = x + 1;
            }
        }

        if (x == 0) {

                category.getProducts().add(product);
                return "Product added successfuly";

        } else
            return "Product already has this category";
    }*/

}
