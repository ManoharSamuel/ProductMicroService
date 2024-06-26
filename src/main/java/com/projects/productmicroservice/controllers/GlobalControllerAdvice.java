package com.projects.productmicroservice.controllers;

import com.projects.productmicroservice.dtos.ExceptionDTO;
import com.projects.productmicroservice.exceptions.CategoryDoesNotExistException;
import com.projects.productmicroservice.exceptions.ProductDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ProductDoesNotExistException.class)
    private ResponseEntity<ExceptionDTO> productDoesNotExistException(ProductDoesNotExistException productDoesNotExistException) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionDTO.setMessage(productDoesNotExistException.getMessage());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryDoesNotExistException.class)
    private ResponseEntity<ExceptionDTO> categoryDoesNotExistException(CategoryDoesNotExistException categoryDoesNotExistException) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionDTO.setMessage(categoryDoesNotExistException.getMessage());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
