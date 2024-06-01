package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ProductResponse;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;
    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);

    }
//    @PostMapping("/category_id")
//    public ProductResponse saveProduct(@PathVariable long category_id,
//                                       @RequestBody Product product){
//         Category category = categoryService.findCategoryById(category_id);
//         product.setCategory(category);
//         category.getProductList().add(product);
//         return productService.saveProduct(product);
//    }

    @PostMapping("/category/{category_id}")
    public ProductResponse addProductToCategory(@PathVariable("category_id") long categoryId,
                                                @RequestBody Product product) {
        Category category = categoryService.findCategoryById(categoryId);
        if (category == null) {
            throw new IllegalArgumentException("Category not found");
        }
        product.setCategory(category);
        category.getProductList().add(product);
        return productService.saveProduct(product);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }




}
