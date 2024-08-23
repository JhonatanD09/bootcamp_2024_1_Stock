package com.bootcamp.Stock.domain.spi;

import com.bootcamp.Stock.domain.model.Category;
import com.bootcamp.Stock.domain.model.Trademark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITrademarkPersistencePort {

    void createTrademark(Trademark trademark);
    Page<Trademark> getAllCategories(String order, Pageable pageable);
}
