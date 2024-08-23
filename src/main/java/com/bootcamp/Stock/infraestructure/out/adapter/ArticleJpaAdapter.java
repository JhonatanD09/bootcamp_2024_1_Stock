package com.bootcamp.Stock.infraestructure.out.adapter;

import com.bootcamp.Stock.domain.model.Article;
import com.bootcamp.Stock.domain.spi.IArticlePersistencePort;
import com.bootcamp.Stock.infraestructure.exceptions.CategoryNotFoundException;
import com.bootcamp.Stock.infraestructure.exceptions.TrademarkNotFoundException;
import com.bootcamp.Stock.infraestructure.out.entity.ArticleCategoryEntity;
import com.bootcamp.Stock.infraestructure.out.entity.ArticleEntity;
import com.bootcamp.Stock.infraestructure.out.entity.TrademarkEntity;
import com.bootcamp.Stock.infraestructure.out.mapper.IArticleEntityMapper;
import com.bootcamp.Stock.infraestructure.out.repository.IArticleCategoryRepository;
import com.bootcamp.Stock.infraestructure.out.repository.IArticleRepository;
import com.bootcamp.Stock.infraestructure.out.repository.ICategoryRepository;
import com.bootcamp.Stock.infraestructure.out.repository.ITrademarkRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ArticleJpaAdapter implements IArticlePersistencePort {

    private final IArticleRepository iArticleRepository;
    private final IArticleCategoryRepository iArticleCategoryRepository;
    private final ICategoryRepository iCategoryRepository;
    private final ITrademarkRepository iTrademarkRepository;
    private final IArticleEntityMapper iArticleEntityMapper;

    @Override
    public void addArticle(Article article, int[] idCategories) {


        for (long i : idCategories){
            if(iCategoryRepository.findById(i).isEmpty()){
              throw new CategoryNotFoundException();
            };
        }

        TrademarkEntity trademark = iTrademarkRepository.findById(article.getIdTrademark())
                .orElseThrow(TrademarkNotFoundException::new);

        ArticleEntity articleEntity = iArticleEntityMapper.toArticleEntity(article);
        articleEntity.setTrademark(trademark);
        iArticleRepository.save(articleEntity);


        for (long i : idCategories){
            ArticleCategoryEntity articleCategoryEntity = new ArticleCategoryEntity();
            articleCategoryEntity.setArticleEntity(articleEntity);
            articleCategoryEntity.setCategoryEntity(
                    iCategoryRepository.findById(i).isPresent()?iCategoryRepository.findById(i).get():null
            );
            iArticleCategoryRepository.save(articleCategoryEntity);
        }


    }
}
