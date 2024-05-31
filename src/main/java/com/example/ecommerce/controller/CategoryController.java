package com.example.ecommerce.controller;

import com.example.ecommerce.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
   private CategoryService categoryService;
}
