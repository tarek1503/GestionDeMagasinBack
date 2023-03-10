package com.example.products.controllers;

import com.example.products.entity.Product;
import com.example.products.repository.ProductRepository;
import com.example.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/GestionProd")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){

        return productService.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> findAlProducts(){
        return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable long id){
        return productService.getProdcutById(id);
    }
    @GetMapping("/product/{name}")

    public Product findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }
    @GetMapping("/categorypro/{category}")

    public List<Product> findProductsByCategory(@PathVariable("category") Long id){
        return productService.getProductsByCategory(id);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){

        return productService.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){

        return productService.deleteProduct(id);
    }

    @GetMapping("/productsByCategory/{id}")
    public List<Product> getProductsByCategory(@PathVariable long id) {
        return productRepository.findProductsByCategory_Id(id);
    }

}
