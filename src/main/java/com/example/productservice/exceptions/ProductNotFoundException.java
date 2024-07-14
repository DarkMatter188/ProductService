package com.example.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception{
    private long uid;

    public ProductNotFoundException(String message, long uid){
        super("message"+uid);
        this.uid = uid;
    }
}
