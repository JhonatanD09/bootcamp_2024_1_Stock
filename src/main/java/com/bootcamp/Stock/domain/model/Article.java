package com.bootcamp.Stock.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Article {

    private long id;
    private String name;
    private String description;
    private int quantity;
    private  double price;
    private long idTrademark;
}
