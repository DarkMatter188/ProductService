package com.example.productservice.ProductService;

import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getSingleProduct(Long id);

    List<Product> getAllProducts();
}
