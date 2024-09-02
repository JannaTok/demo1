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
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/products")
    public String createProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/products";
    }

    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id, Product product) {
        productService.updateProduct(id, product);
        return "redirect:/products";
    }

    @DeleteMapping("/products/{id}")
    public String deleteById (@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
