package com.example.productservice.inheritancetypes.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "2")
@Entity
public class Instructor extends User {
    private String subject;
}
