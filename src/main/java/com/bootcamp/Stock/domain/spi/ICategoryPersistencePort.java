package com.bootcamp.Stock.domain.spi;


import com.bootcamp.Stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryPersistencePort {

    void createCategory(Category category);
    Page<Category> getAllCategories(String order, Pageable pageable);
}
