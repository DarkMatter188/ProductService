package com.example.productservice.controlleradvice;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("ArithmeticException");
        exceptionDto.setSolution("I cannot tell!!");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_GATEWAY
        );
        return response;
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> handleNullPointerException(){
//        ResponseEntity<String> response = new ResponseEntity<>(
//                "Null Pointer Exception handled from Controller Advice",
//                HttpStatus.BAD_GATEWAY
//        );
//        return response;
//    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product not found");
        exceptionDto.setSolution("Please try again with a valid ID");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_GATEWAY
        );
        return response;
    }
}
