package com.bootcamp.Stock.infraestructure.out.repository;


import com.bootcamp.Stock.infraestructure.out.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByName(String name);


    Page<CategoryEntity> findAllByOrderByNameAsc(Pageable pageable);

    Page<CategoryEntity> findAllByOrderByNameDesc(Pageable pageable);

}
