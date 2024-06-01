package com.example.ecommerce.service;

import com.example.ecommerce.dto.CategoryResponse;
import com.example.ecommerce.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category saveCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    Optional<Category> getCategoryByTitle(String title);
    List<Category> getAllCategories();
    void deleteCategory(Long id);
    Category findCategoryById(Long id);
}
