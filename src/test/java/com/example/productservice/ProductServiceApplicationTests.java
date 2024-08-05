package com.example.productservice;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.projections.ProductWithIdAndTitle;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;

//    @Test
//    void contextLoads() {
//
//    }

//    @Test
//    void testDBQueries(){
//
//    }

//    @Test
//    void testDBQueries(){
//        List<ProductWithIdAndTitle> productWithIdAndTitles = productRepository.randomSearch();
//        for(ProductWithIdAndTitle product : productWithIdAndTitles){
//            System.out.println(product.getId() + " " + product.getTitle());
//        }
//
//        System.out.println("DEBUG");
//    }

//    @Test
//    void testDBQueries1(){
//        List<ProductWithIdAndTitle> productWithIdAndTitles = productRepository.randomSearch2(1L);
//        for(ProductWithIdAndTitle product : productWithIdAndTitles){
//            System.out.println(product.getId() + " " + product.getTitle());
//        }
//
//        System.out.println("DEBUG");
//    }

//    @Test
//    void testDBQueries2(){
//        //Eager fetch will have join
//        Optional<Product> optionalProduct = productRepository.findById(1L);
//
//        //Lazy fetch will not have join
//        Optional<Category> optionalCategory = categoryRepository.findById(1L);
//
//        System.out.println("Getting all products");
//
//        List<Product> products = optionalCategory.get().getProducts();
//
//
//    }



}
