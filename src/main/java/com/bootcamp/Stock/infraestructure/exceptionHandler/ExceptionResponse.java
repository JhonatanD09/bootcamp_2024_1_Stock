package com.bootcamp.Stock.infraestructure.exceptionHandler;


public enum ExceptionResponse {
    CATEGORY_ALREADY_EXISTS("El nombre de esa categoria ya esta registrado"),
    DESCRIPTION_NOT_FOUND("No ingresaste una descripcion para la categoria"),
    INVALID_DATA_LENGTH("El campo nombre o descripcion superan la cantidad maxima de caracteres"),
;

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}