package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Product extends BaseModel {
    String title;
    Double price;

    @ManyToOne
    Category category;
    //M --------------- 1
    //Product ------ Category
}
