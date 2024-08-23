package com.bootcamp.Stock.domain.api;

import com.bootcamp.Stock.domain.model.Article;

public interface IArticleServicePort {

    void addArticle(Article article, int [] idCategories);

}
