package com.bootcamp.Stock.infraestructure.out.mapper;

import com.bootcamp.Stock.application.dto.CategoryResponse;
import com.bootcamp.Stock.domain.model.Category;
import com.bootcamp.Stock.infraestructure.out.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;


import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ICategoryEntityMapper {

    ICategoryEntityMapper INSTANCE = Mappers.getMapper(ICategoryEntityMapper.class);
    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);

}
