package com.example.productservice.repositories;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DummyProductRepositoryFake implements DummyProduct {
    Map<Long, Product> productMap = new HashMap<>();
    long id = 0L;

    public DummyProductRepositoryFake(){};

    @Override
    public Product findById(long categoryId) {
        return productMap.get(categoryId);
    }

    @Override
    public void save(Product product) {
        if(id == 0L){
            id++;
            product.setId(id);
            productMap.put(id, product);
        }
        else{
            productMap.put(product.getId(), product);
        }
    }
}
