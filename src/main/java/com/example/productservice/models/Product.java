package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Product extends BaseModel {
    String title;
    Double price;
    //automatically save category in DB first
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn
    Category category;
    //M --------------- 1
    //Product ------ Category
}
