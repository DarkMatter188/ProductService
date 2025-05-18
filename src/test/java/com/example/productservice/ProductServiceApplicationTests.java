package com.example.productservice;

import com.example.productservice.controllers.ProductController;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.projections.ProductWithIdAndTitle;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.DummyProductRepositoryFake;
import com.example.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductController productController;

    @Autowired
    private DummyProductRepositoryFake productRepositoryFake;
    @Autowired
    private DummyProductRepositoryFake dummyProductRepositoryFake;

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

    @Test
    public void testAddDataDummyProduct(){
        Product p = new Product();
        p.setTitle("Laptop");
        p.setPrice(10000.0);
        dummyProductRepositoryFake.save(p);
    }

    //Test Case - A method that is used to test some functionality
    @Test
    public void testAddition(){
        //3A framework for writing a TC
        //A - Arrange, A - Act, A - Assert
        //arrange
        int a = 2;
        int b = 3;

        //act
        int result = a + b; //result - actual value

        //assert
        //assert result == 7;

        //Use Junit jupiter lib or assertj core library to test complex cases
        assertEquals(5, result);

        //Other types of usecases
        assertTimeout(Duration.ofMillis(1000), () -> productRepository.findById(10l));
        assertTimeout(Duration.ofMillis(1000), ()-> productController.getAllProducts(1, 1));

        //Write a TC to check if function is throwing a type of exception or not
        assertThrows(
                ProductNotFoundException.class,
                () -> productController.getProductById(10l)
        );

        
    }

}
