package com.bootcamp.Stock.application.dto.article;

import lombok.Data;

@Data
public class ArticleRequest {

    private long id;
    private String name;
    private String description;
    private int quantity;
    private  double price;
    private long idTrademark;
    private int [] idCategories;
}
