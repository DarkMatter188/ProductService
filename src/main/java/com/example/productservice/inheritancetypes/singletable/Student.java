package com.example.productservice.inheritancetypes.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "0")
@Entity
public class Student extends User {
    private String batch;
}
