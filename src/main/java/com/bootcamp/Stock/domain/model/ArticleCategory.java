package com.bootcamp.Stock.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ArticleCategory {

    private  long id;

    private int idCategory;

    private int idArticle;
}
