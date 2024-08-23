package com.bootcamp.Stock.infraestructure.exceptionHandler;


import com.bootcamp.Stock.infraestructure.exceptions.*;
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

    @ExceptionHandler(TrademarkAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleTrademarkAlreadyExistException(
            TrademarkAlreadyExistException trademarkAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.TRADEMARK_ALREADY_EXISTS.getMessage()));
    }


    @ExceptionHandler(DescriptionToCategoryNotFound.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFoundException(
            DescriptionToCategoryNotFound descriptionToCategoryNotFound) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DESCRIPTION_CATEGORY_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(DescriptionToTrademarkNotFound.class)
    public ResponseEntity<Map<String, String>> handleDescriptionToTrademarkNotFound(
            DescriptionToTrademarkNotFound descriptionToTrademarkNotFound) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DESCRIPTION_TRADEMARK_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(InvalidDataLength.class)
    public ResponseEntity<Map<String, String>> handleInvalidDataLength(
            InvalidDataLength invalidDataLength) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.INVALID_DATA_LENGTH.getMessage()));
    }


}
