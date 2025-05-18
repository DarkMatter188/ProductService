package com.example.productservice.repositories;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;

public interface DummyProduct {
    public Product findById(long productId);

    public void save(Product product);
}
