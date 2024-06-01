package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductResponse;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.NotFoundException;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return new ProductResponse(savedProduct.getName(), savedProduct.getCategory().getTitle());
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductResponse getProductByName(String name) {
        Optional<Product> productOptional = productRepository.findByName(name);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            return new ProductResponse(product.getName(), product.getCategory().getTitle());
        }
        else throw new NotFoundException("Product not found with name:" + name, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
