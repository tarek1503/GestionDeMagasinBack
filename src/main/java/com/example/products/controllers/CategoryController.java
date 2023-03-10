package com.example.products.controllers;

import com.example.products.ServiceImp.ICategoryService;
import com.example.products.dto.CategoryDto;
import com.example.products.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping
    public Category saveCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.saveCategory(categoryDto);
    }
    @PostMapping("/addCategories")
    public List<Category> addCategories(@RequestBody List<Category> categories){
        return categoryService.saveCategories(categories);
    }
    @GetMapping("/all-categories")
    public List<Category> findCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/categoryById/{id}")
    public Category findProductById(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }
    @GetMapping("/category/{name}")

    public Category findProductByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable long id,@RequestBody CategoryDto  categoryDto){

        return categoryService.updateCategory(categoryDto,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){

        return categoryService.deleteCategory(id);
    }


}
