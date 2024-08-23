package com.bootcamp.Stock.infraestructure.out.mapper;

import com.bootcamp.Stock.domain.model.Article;
import com.bootcamp.Stock.infraestructure.out.entity.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IArticleEntityMapper {


    ArticleEntity toArticleEntity(Article article);
    Article toArticle(ArticleEntity articleEntity);
}
