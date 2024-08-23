package com.bootcamp.Stock.application.handler.article;

import com.bootcamp.Stock.application.dto.article.ArticleRequest;
import com.bootcamp.Stock.application.mapper.article.MapperArticleRequest;
import com.bootcamp.Stock.application.utils.constans.Constans;
import com.bootcamp.Stock.application.utils.validators.ValidatorRequest;
import com.bootcamp.Stock.domain.api.IArticleServicePort;
import com.bootcamp.Stock.infraestructure.exceptions.DescriptionToCategoryNotFound;
import com.bootcamp.Stock.infraestructure.exceptions.InvalidDataLength;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleHandler implements IArticleHandler{

    private final IArticleServicePort iArticleServicePort;
    private final MapperArticleRequest mapperArticleRequest;

    @Override
    public void addArticle(ArticleRequest articleRequest) {
        if(articleRequest.getDescription() == null || articleRequest.getDescription().isEmpty()){
            throw  new DescriptionToCategoryNotFound();
        }else{
            if (ValidatorRequest.valideField(articleRequest.getName(), Constans.MAX_LENGTH_NAME_CATEGORY) &&
                    ValidatorRequest.valideField(articleRequest.getDescription(),Constans.MAX_LENGTH_DESCRIPTION_CATEGORY)){
                articleRequest.setName(articleRequest.getName().trim());
                //TODO Validar cantidad de categorias
                iArticleServicePort.addArticle(mapperArticleRequest.toArticle(articleRequest),articleRequest.getIdCategories());
            }else {
                throw  new InvalidDataLength();
            }
        }

    }
}
