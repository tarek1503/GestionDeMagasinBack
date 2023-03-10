package com.example.products.dto;

import com.example.products.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {


    private String name;


    public static Category fromDto(CategoryDto categoryDto) {
        return Category.builder()
                .name(categoryDto.getName()).build();
    }

    public static CategoryDto fromModel(Category category) {
        return new CategoryDto(category.getName());
    }
}
