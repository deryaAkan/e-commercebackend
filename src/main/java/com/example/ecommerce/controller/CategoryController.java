package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
   private CategoryService categoryService;

   public CategoryController(CategoryService categoryService) {
      this.categoryService = categoryService;
   }

   @PostMapping
   public ResponseEntity<Category> createCategory(@RequestBody Category category){
      Category savedCategory = categoryService.saveCategory(category);
      return ResponseEntity.ok(savedCategory);
   }

   @GetMapping
   public ResponseEntity<List<Category>> getAllCategories(){
      List<Category> categories = categoryService.getAllCategories();
      return ResponseEntity.ok(categories);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
      categoryService.deleteCategory(id);
      return ResponseEntity.noContent().build();
   }
}
