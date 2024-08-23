package com.bootcamp.Stock.application.mapper;


import com.bootcamp.Stock.application.dto.CategoryRequest;
import com.bootcamp.Stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;



@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapperCategoryRequest {

    Category toCategory(CategoryRequest categoryRequest);

}
