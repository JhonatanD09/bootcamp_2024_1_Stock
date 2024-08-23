package com.bootcamp.Stock.application.handler.category;


import com.bootcamp.Stock.application.dto.category.CategoryRequest;
import com.bootcamp.Stock.application.dto.category.CategoryResponse;
import com.bootcamp.Stock.application.mapper.category.MapperCategoryRequest;
import com.bootcamp.Stock.application.mapper.category.MapperCategoryResponse;
import com.bootcamp.Stock.application.utils.constans.Constans;
import com.bootcamp.Stock.application.utils.validators.ValidatorRequest;
import com.bootcamp.Stock.domain.api.ICategoryServicePort;
import com.bootcamp.Stock.domain.model.Category;
import com.bootcamp.Stock.infraestructure.exceptions.DescriptionToCategoryNotFound;
import com.bootcamp.Stock.infraestructure.exceptions.InvalidDataLength;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryHandler implements IHandlerCategory {

    private final ICategoryServicePort iCategoryServicePort;
    private final MapperCategoryRequest categoryRequest;
    private final  MapperCategoryResponse mapperCategoryResponse;

    @Override
    public void saveCategory(CategoryRequest categoryRequest) {
        if(categoryRequest.getDescription() == null || categoryRequest.getDescription().isEmpty()){
            throw  new DescriptionToCategoryNotFound();
        }else{
            if (ValidatorRequest.valideField(categoryRequest.getName(), Constans.MAX_LENGTH_NAME_CATEGORY) &&
                    ValidatorRequest.valideField(categoryRequest.getDescription(),Constans.MAX_LENGTH_DESCRIPTION_CATEGORY)){
                categoryRequest.setName(categoryRequest.getName().trim());
                iCategoryServicePort.createCategory( this.categoryRequest.toCategory(categoryRequest));
            }else {
                throw  new InvalidDataLength();
            }
        }
    }

    @Override
    public Page<CategoryResponse> getAllCategories(String order, Pageable pageable) {
        return mapCategoryPageToResponsePage(iCategoryServicePort.getAllCategories(order, pageable));
    }

    private  Page<CategoryResponse> mapCategoryPageToResponsePage(Page<Category> categoryPage) {
        List<CategoryResponse> categoryResponses = categoryPage.stream()
                .map(mapperCategoryResponse::toCategoryResponse)
                .collect(Collectors.toList());
        return new PageImpl<>(categoryResponses, categoryPage.getPageable(), categoryPage.getTotalElements());
    }
}
