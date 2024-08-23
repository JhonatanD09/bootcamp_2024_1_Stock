package com.bootcamp.Stock.application.mapper.category;


import com.bootcamp.Stock.application.dto.category.CategoryRequest;
import com.bootcamp.Stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;



@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapperCategoryRequest {

    Category toCategory(CategoryRequest categoryRequest);

}
