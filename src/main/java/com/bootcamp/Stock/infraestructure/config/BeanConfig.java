package com.bootcamp.Stock.infraestructure.config;

import com.bootcamp.Stock.domain.api.ICategoryServicePort;
import com.bootcamp.Stock.domain.spi.ICategoryPersistencePort;
import com.bootcamp.Stock.domain.usecase.CategoryUseCase;
import com.bootcamp.Stock.infraestructure.out.adapter.CategoryJpaAdapter;
import com.bootcamp.Stock.infraestructure.out.mapper.ICategoryEntityMapper;
import com.bootcamp.Stock.infraestructure.out.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    private final ICategoryRepository iCategoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort iCategoryPersistencePort(){
        return new CategoryJpaAdapter(iCategoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort iCategoryServicePort(){
        return  new CategoryUseCase(iCategoryPersistencePort());
    }
}
