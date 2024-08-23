package com.bootcamp.Stock.application.mapper;


import com.bootcamp.Stock.application.dto.CategoryResponse;
import com.bootcamp.Stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapperCategoryResponse {

    MapperCategoryResponse INSTANCE = Mappers.getMapper(MapperCategoryResponse.class);

    CategoryResponse toCategoryResponse(Category category);
}
