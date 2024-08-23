package com.bootcamp.Stock.infraestructure.out.repository;

import com.bootcamp.Stock.infraestructure.out.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {

    Optional<ArticleEntity> findByName(String name);
}
