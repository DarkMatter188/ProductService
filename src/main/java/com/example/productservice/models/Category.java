package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class Category extends BaseModel {
    String name;
    String description;
//    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
//    private List<Product> products;
}
