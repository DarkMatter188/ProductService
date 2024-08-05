package com.example.productservice.ProductService;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")

public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    //Constructor injection and separate repo package for making DB Calls
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        //make DB Call from repo and use method here

        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id not found", id);
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findByTitleLike("Clothes");
    }

    @Override
    //PATCH request
    public Product updateProduct (Long id, Product product) throws ProductNotFoundException{
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id does not exist", id);
        }

        Product productInDB = optionalProduct.get();

        if(product.getTitle() != null){
            productInDB.setTitle(product.getTitle());
        }

        if(product.getPrice() != null){
            productInDB.setPrice(product.getPrice());
        }
        return productRepository.save(productInDB);
    }

    @Override
    //PUT Request to update full product
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException{
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id does not exist", id);
        }
        Product productInDB = optionalProduct.get();
        return productRepository.save(product);
    }

    @Override
    public Product addNewProduct(Product product) {
        //cannot save product without first saving category
        Category category = product.getCategory();
//        if(category.getId() == null){
//            //create new category object in DB
//            category = categoryRepository.save(category);
//            product.setCategory(category);
//        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
