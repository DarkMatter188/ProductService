package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import com.example.productservice.projections.ProductWithIdAndTitle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(Double price);

    @Override
    Page<Product> findAll(Pageable pageable);
    List<Product> findByTitleLike(String word);

    List<Product> findByTitleLikeIgnoreCase(String word);

//    List<Product> findTopByTitleContains(int top, String title);

    List<Product> findProductByTitleContainsAndPriceGreaterThan(String word, Double price);

    List<Product> findProductByTitleContainsOrderById(String word);

    Optional<Product> findById(Long id);

    //HQL Queries works on Model class
    @Query("select p.id as id, p.title as title from Product p")
    List<ProductWithIdAndTitle> randomSearch();

    //Native Queries MySQL hardcoded
    @Query(value = "select p.id, p.title from product p where p.id = :productId", nativeQuery = true)
    List<ProductWithIdAndTitle> randomSearch2(Long productId);


}
