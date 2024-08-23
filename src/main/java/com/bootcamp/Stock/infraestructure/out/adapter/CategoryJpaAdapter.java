package com.bootcamp.Stock.infraestructure.out.adapter;


import com.bootcamp.Stock.domain.model.Category;
import com.bootcamp.Stock.domain.spi.ICategoryPersistencePort;
import com.bootcamp.Stock.infraestructure.exceptions.CategoryAlreadyExistException;
import com.bootcamp.Stock.infraestructure.out.entity.CategoryEntity;
import com.bootcamp.Stock.infraestructure.out.mapper.ICategoryEntityMapper;
import com.bootcamp.Stock.infraestructure.out.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository iCategoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;


    @Override
    public void createCategory(Category category) {
        if(iCategoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistException();
        }else{
            iCategoryRepository.save(categoryEntityMapper.toCategoryEntity(category));
        }

    }

    @Override
    public Page<Category> getAllCategories(String order, Pageable pageable) {
        return order.trim().equalsIgnoreCase("ASC")
                ?mapCategoryPageToResponsePage(iCategoryRepository.findAllByOrderByNameAsc(pageable))
                :mapCategoryPageToResponsePage(iCategoryRepository.findAllByOrderByNameDesc(pageable));
    }

    private  Page<Category> mapCategoryPageToResponsePage(Page<CategoryEntity> categoryPage) {
        List<Category> categoryResponses = categoryPage.stream()
                .map(categoryEntityMapper::toCategory)
                .collect(Collectors.toList());
        return new PageImpl<>(categoryResponses, categoryPage.getPageable(), categoryPage.getTotalElements());
    }
}
