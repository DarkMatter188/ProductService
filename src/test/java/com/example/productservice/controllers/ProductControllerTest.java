package com.example.productservice.controllers;

import com.example.productservice.ProductService.ProductService;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//To initialise spring context or run whole spring project use this annotation

@SpringBootTest
class ProductControllerTest {
    //Need to inject bean of productController to test its functions
    @Autowired
    ProductController productController;

    //Do not inject real service obj then it will call direct method instead call mockbean
    @MockBean
    ProductService productService;

    @Test
    void testGetProductByIdPositive() throws ProductNotFoundException {
        Product productExpected = new Product();
        productExpected.setTitle("IPhone 15 Pro");
        productExpected.setPrice(150000.0);

        //use mock bean of service hardcode
        when(productService.getSingleProduct(1l)).
                thenReturn(productExpected);

        Product productActual = productController.getProductById(1l).getBody();
        assertEquals(productExpected, productActual);

    }

    @Test
    void testGetProductByIdNegative() throws ProductNotFoundException {
        when(productService.getSingleProduct(-1L)).
                thenThrow(ProductNotFoundException.class);

        assertThrows(
                ProductNotFoundException.class,
                () -> productController.getProductById(-1L)
        );
    }

    @Test
    public void testGetSingleProductTimeOut() throws ProductNotFoundException {
        Product expectedProduct = new Product();
        expectedProduct.setTitle("IPhone 15 Pro");
        expectedProduct.setPrice(10000.0);

        when(productService.getSingleProduct(1L)).
                thenReturn(expectedProduct);

        assertTimeout(
                Duration.ofMillis(10),
                () -> productController.getProductById(1L)
        );
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getProductsByCategory() {
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
    void deleteProductById() {
    }
}