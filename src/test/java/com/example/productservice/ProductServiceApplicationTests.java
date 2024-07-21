package com.example.productservice;

import com.example.productservice.projections.ProductWithIdAndTitle;
import com.example.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {

    }

    @Test
    void testDBQueries(){
        List<ProductWithIdAndTitle> productWithIdAndTitles = productRepository.randomSearch();
        for(ProductWithIdAndTitle product : productWithIdAndTitles){
            System.out.println(product.getId() + " " + product.getTitle());
        }

        System.out.println("DEBUG");
    }

    @Test
    void testDBQueries1(){
        List<ProductWithIdAndTitle> productWithIdAndTitles = productRepository.randomSearch2(1L);
        for(ProductWithIdAndTitle product : productWithIdAndTitles){
            System.out.println(product.getId() + " " + product.getTitle());
        }

        System.out.println("DEBUG");
    }



}
