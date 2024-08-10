package com.example.productservice.controllers;

import com.example.productservice.ProductService.ProductService;
import com.example.productservice.ProductService.SelfProductService;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final RestClientAutoConfiguration restClientAutoConfiguration;
    //http methods to CRUD product
    private ProductService productService;


    public ProductController(@Qualifier("selfProductService") ProductService productService, RestClientAutoConfiguration restClientAutoConfiguration) {
        this.productService = productService;
        this.restClientAutoConfiguration = restClientAutoConfiguration;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        //Exception Handling
//        ResponseEntity<Product> responseEntity = null;
//        try {
//            Product product = productService.getSingleProduct(id);
//            responseEntity = new ResponseEntity<>(
//                    product,
//                    HttpStatus.OK
//            );
//        }catch (RuntimeException e){
//            responseEntity = new ResponseEntity<>(
//                    HttpStatus.NOT_FOUND
//            );
//        }
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping()
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws ProductNotFoundException {
        return productService.getAllProducts(pageNumber, pageSize);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category){
        System.out.println("Category: " + category);
        return productService.getProductByCategory(category);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(id, product);
    }

    @PostMapping("/")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }


    @DeleteMapping("/{id}")
    void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

}
