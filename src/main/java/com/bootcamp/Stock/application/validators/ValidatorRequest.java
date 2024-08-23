package com.bootcamp.Stock.application.validators;

public class ValidatorRequest {

    public static boolean valideField(String field, int length){
        return  field.length() <= length;
    }


}
