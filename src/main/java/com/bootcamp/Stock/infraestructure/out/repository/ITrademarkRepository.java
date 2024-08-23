package com.bootcamp.Stock.infraestructure.out.repository;

import com.bootcamp.Stock.infraestructure.out.entity.CategoryEntity;
import com.bootcamp.Stock.infraestructure.out.entity.TrademarkEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITrademarkRepository extends JpaRepository<TrademarkEntity,Long> {

    Optional<TrademarkEntity> findByName(String name);

    Page<TrademarkEntity> findAllByOrderByNameAsc(Pageable pageable);

    Page<TrademarkEntity> findAllByOrderByNameDesc(Pageable pageable);
}
