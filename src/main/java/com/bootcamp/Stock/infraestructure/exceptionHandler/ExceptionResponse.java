package com.bootcamp.Stock.infraestructure.exceptionHandler;


public enum ExceptionResponse {
    CATEGORY_ALREADY_EXISTS("El nombre de esa categoria ya esta registrado"),
    TRADEMARK_ALREADY_EXISTS("El nombre de esa marca ya esta registrado"),
    DESCRIPTION_CATEGORY_NOT_FOUND("No ingresaste una descripcion para la categoria"),
    DESCRIPTION_TRADEMARK_NOT_FOUND("No ingresaste una descripcion para la marca"),
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