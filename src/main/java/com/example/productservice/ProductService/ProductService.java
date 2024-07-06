package com.example.productservice.ProductService;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    List<Product> getProductByCategory(String category);

    Product updateProduct(Long id, Product product);
    Product replaceProduct(Long id, Product product);

    Product addNewProduct(Product product);

    void deleteProduct(Long id);

}
