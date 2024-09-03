package com.example.product.service;


import com.example.product.model.Product;
import com.example.product.repository.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Page<Product> getAllProductsPage(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    public void createProduct(Product product) {
        productRepo.save(product);
    }

    public Product getById(long id) {
        return productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("NOT FOUND"));
    }

    public void updateProduct (long id, Product product) {
        Optional<Product> productOptional = productRepo.findById(id);

        if (productOptional.isPresent()) {
            Product oldProduct = productOptional.get();
            oldProduct.setName(product.getName());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setQuantity(product.getQuantity());
            oldProduct.setDescription(product.getDescription());
            productRepo.save(oldProduct);
        }else {
            throw new EntityNotFoundException("ENTITY NOT FOUND");
        }
    }
    public void deleteById (long id) {
        productRepo.deleteById(id);
        }
}
