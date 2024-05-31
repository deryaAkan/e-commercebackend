package com.example.ecommerce.service;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category saveCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    Optional<Category> getCategoryByName(String name);
    List<Category> getAllCategories();
    void deleteCategory(Long id);
}
