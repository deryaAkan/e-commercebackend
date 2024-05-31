package com.example.ecommerce.service;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product saveProduct(Product product);
    Optional<Product> getProductById(Long id);
    Optional<Product> getProductByName(String  name);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Category category);
    void deleteProductById(Long id);

}
