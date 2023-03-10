package com.example.products.service;

import com.example.products.repository.CategoryRepository;
import com.example.products.ServiceImp.ICategoryService;
import com.example.products.dto.CategoryDto;
import com.example.products.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.products.dto.CategoryDto.fromDto;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(CategoryDto categoryDto) {
        return categoryRepository.save(fromDto(categoryDto));
    }

    @Override
    public List<Category> saveCategories(List<Category> Categories) {
        return categoryRepository.saveAll(Categories);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public String deleteCategory(long id) {
        categoryRepository.deleteById(id);
        return "category removed !!" +id;
    }

    @Override
    public Category updateCategory(CategoryDto categoryDto,Long id) {
        Category existingCategory = categoryRepository.findById(id).get();
        existingCategory.setName(categoryDto.getName());
        return categoryRepository.save(existingCategory);
    }
}
