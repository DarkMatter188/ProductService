package com.example.productservice.ProductService;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.DummyProductRepositoryFake;
import com.example.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SelfProductServiceTest {
    //Need to call dependency of service but mock for repo
    @Autowired
    ProductService productService;


    @Test
    void getSingleProduct() throws ProductNotFoundException {
        DummyProductRepositoryFake productRepositoryFake = new DummyProductRepositoryFake();
        Product expectedProduct = new Product();
        expectedProduct.setTitle("One Piece");
        expectedProduct.setPrice(1000.00);

        productRepositoryFake.save(expectedProduct);

        assertEquals("One Piece", productRepositoryFake.findById(1L).getTitle());

    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getProductByCategory() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void replaceProduct() {
    }

    @Test
    void addNewProduct() {
    }

    @Test
    void deleteProduct() {
    }
}