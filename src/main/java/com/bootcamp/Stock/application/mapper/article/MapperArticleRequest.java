package com.bootcamp.Stock.application.mapper.article;

import com.bootcamp.Stock.application.dto.article.ArticleRequest;
import com.bootcamp.Stock.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapperArticleRequest {

    Article toArticle(ArticleRequest articleRequest);
}
