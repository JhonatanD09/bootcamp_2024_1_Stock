package com.bootcamp.Stock.domain.usecase;


import com.bootcamp.Stock.domain.api.ICategoryServicePort;
import com.bootcamp.Stock.domain.model.Category;
import com.bootcamp.Stock.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort iCategoryPersistencePort;

    @Override
    public void createCategory(Category category) {
        System.out.println("USECASE"+ category.getName());
        iCategoryPersistencePort.createCategory(category);
    }

    @Override
    public Page<Category> getAllCategories(String order, Pageable pageable) {
        return iCategoryPersistencePort.getAllCategories(order, pageable);
    }
}
