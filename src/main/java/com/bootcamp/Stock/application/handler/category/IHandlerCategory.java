package com.bootcamp.Stock.application.handler.category;


import com.bootcamp.Stock.application.dto.category.CategoryRequest;
import com.bootcamp.Stock.application.dto.category.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHandlerCategory {

    void saveCategory(CategoryRequest categoryRequest);

    Page<CategoryResponse> getAllCategories(String order, Pageable pageable);

}
