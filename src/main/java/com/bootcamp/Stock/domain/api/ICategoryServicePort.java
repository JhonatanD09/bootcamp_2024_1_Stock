package com.bootcamp.Stock.domain.api;

import com.bootcamp.Stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface  ICategoryServicePort {

    void createCategory(Category category);
    Page<Category> getAllCategories(String order, Pageable pageable);

}
