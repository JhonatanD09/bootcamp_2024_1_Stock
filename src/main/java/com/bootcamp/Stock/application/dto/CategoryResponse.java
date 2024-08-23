package com.bootcamp.Stock.application.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryResponse {

    private long id;
    private String name;
    private  String description;
}
