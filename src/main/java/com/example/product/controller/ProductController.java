package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Long id, Model model) {
        return productService.getById(id);
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id, Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteById (@PathVariable Long id) {
        productService.deleteById(id);
    }
}
