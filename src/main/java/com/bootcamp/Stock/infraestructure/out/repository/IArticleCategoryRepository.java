package com.bootcamp.Stock.infraestructure.out.repository;

import com.bootcamp.Stock.infraestructure.out.entity.ArticleCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleCategoryRepository extends JpaRepository<ArticleCategoryEntity, Long> {
}
