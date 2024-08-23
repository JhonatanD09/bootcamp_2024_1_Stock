package com.bootcamp.Stock.domain.usecase;

import com.bootcamp.Stock.domain.api.IArticleServicePort;
import com.bootcamp.Stock.domain.model.Article;
import com.bootcamp.Stock.domain.spi.IArticlePersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleUseCase implements IArticleServicePort {

    private final IArticlePersistencePort iArticlePersistencePort;

    @Override
    public void addArticle(Article article, int[] idCategories) {
        iArticlePersistencePort.addArticle(article,idCategories);
    }
}
