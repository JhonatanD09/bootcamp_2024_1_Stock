package com.bootcamp.Stock.domain.spi;


import com.bootcamp.Stock.domain.model.Article;

public interface IArticlePersistencePort {

    void addArticle(Article article, int [] idCategories);
}
