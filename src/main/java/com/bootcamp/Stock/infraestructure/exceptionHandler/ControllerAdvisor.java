package com.bootcamp.Stock.infraestructure.exceptionHandler;


import com.bootcamp.Stock.infraestructure.exceptions.CategoryAlreadyExistException;
import com.bootcamp.Stock.infraestructure.exceptions.DescriptionToCategoryNotFound;
import com.bootcamp.Stock.infraestructure.exceptions.InvalidDataLength;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleCatergoryAlreadyExistsException(
            CategoryAlreadyExistException categoryAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(DescriptionToCategoryNotFound.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFoundException(
            DescriptionToCategoryNotFound descriptionToCategoryNotFound) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DESCRIPTION_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(InvalidDataLength.class)
    public ResponseEntity<Map<String, String>> handleInvalidDataLength(
            InvalidDataLength invalidDataLength) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.INVALID_DATA_LENGTH.getMessage()));
    }


}
