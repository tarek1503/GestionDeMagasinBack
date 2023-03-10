package com.example.products.ServiceImp;

import com.example.products.dto.CategoryDto;
import com.example.products.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    Category saveCategory(CategoryDto categoryDto);
    List<Category> saveCategories(List<Category> Categories);
    List<Category> getCategories();
    Category getCategoryById(long id);

    Category getCategoryByName(String name);
    String deleteCategory(long id);
    Category updateCategory(CategoryDto categoryDto,Long id);
}
