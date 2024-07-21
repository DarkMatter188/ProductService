package com.example.productservice.ProductService;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("fakeStoreProductService")

public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());


        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        category.setId(fakeStoreProductDto.getId());
        category.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);
        return product;
    }


    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {

//        throw new ArithmeticException();

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id does not exist ", id);
        }
        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto fakeStoreProductDtos[] = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
        }
        return products;
    }

    public List<Product> getProductByCategory(String category) {
        FakeStoreProductDto fakeStoreProductDtos[] = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category,
                FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        // Uncomment and fix this if the category needs to be set.
        // fakeStoreProductDto.setCategory(product.getCategory().getDescription());

        // Set up the request callback to include the request entity
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);

        // Set up the response extractor to parse the response
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());

        try {
            FakeStoreProductDto response = restTemplate.execute(
                    "https://fakestoreapi.com/products/" + id,
                    HttpMethod.PATCH,
                    requestCallback,
                    responseExtractor
            );

            // Convert the response DTO to the Product object
            return convertFakeStoreProductToProduct(response);
        } catch (Exception e) {
            // Handle the error or log it
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        // Uncomment and fix this if the category needs to be set.
         fakeStoreProductDto.setCategory(product.getCategory().getName());

        // Set up the request callback to include the request entity
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);

        // Set up the response extractor to parse the response
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());

        try {
            FakeStoreProductDto response = restTemplate.execute(
                    "https://fakestoreapi.com/products/" + id,
                    HttpMethod.PUT,
                    requestCallback,
                    responseExtractor
            );

            // Convert the response DTO to the Product object
            return convertFakeStoreProductToProduct(response);
        } catch (Exception e) {
            // Handle the error or log it
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product addNewProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        // Uncomment and fix this if the category needs to be set.
        // fakeStoreProductDto.setCategory(product.getCategory().getDescription());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(
                FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto1 = restTemplate.execute(
                "https://fakestoreapi.com/products/" , HttpMethod.POST, requestCallback, responseExtractor);

        return convertFakeStoreProductToProduct(fakeStoreProductDto1);
    }


    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }

    public ResponseEntity<String> handleArithmeticException(){
        ResponseEntity<String> respone = new ResponseEntity<>(
                "Arithmetic exception handled from Service class",
                HttpStatus.BAD_GATEWAY
        );
        return respone;
    }
}
