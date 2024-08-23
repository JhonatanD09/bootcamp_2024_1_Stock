package com.bootcamp.Stock.application.mapper.category;


import com.bootcamp.Stock.application.dto.category.CategoryResponse;
import com.bootcamp.Stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapperCategoryResponse {

    MapperCategoryResponse INSTANCE = Mappers.getMapper(MapperCategoryResponse.class);

    CategoryResponse toCategoryResponse(Category category);
}
