package com.example.productservice.controllers;

import com.example.productservice.ProductService.ProductService;
import com.example.productservice.models.Product;
import org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final RestClientAutoConfiguration restClientAutoConfiguration;
    //http methods to CRUD product
    private ProductService productService;


    public ProductController(ProductService productService, RestClientAutoConfiguration restClientAutoConfiguration) {
        this.productService = productService;
        this.restClientAutoConfiguration = restClientAutoConfiguration;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {

        return productService.getSingleProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category){
        System.out.println("Category: " + category);
        return productService.getProductByCategory(category);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @PostMapping("/")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }


    @DeleteMapping("/{id}")
    void deleteProductById(@PathVariable("id") Long id) {

    }

}
