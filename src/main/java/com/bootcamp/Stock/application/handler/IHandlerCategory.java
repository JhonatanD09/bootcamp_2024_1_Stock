package com.bootcamp.Stock.application.handler;


import com.bootcamp.Stock.application.dto.CategoryRequest;
import com.bootcamp.Stock.application.dto.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHandlerCategory {

    void saveCategory(CategoryRequest categoryRequest);

    Page<CategoryResponse> getAllCategories(String order, Pageable pageable);

}
