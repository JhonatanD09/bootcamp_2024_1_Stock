package com.bootcamp.Stock.infraestructure.out.mapper;

import com.bootcamp.Stock.domain.model.Category;
import com.bootcamp.Stock.domain.model.Trademark;
import com.bootcamp.Stock.infraestructure.out.entity.CategoryEntity;
import com.bootcamp.Stock.infraestructure.out.entity.TrademarkEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITrademarkEntityMapper {

    TrademarkEntity toTrademarkEntity(Trademark trademark);

    Trademark toTrademark(TrademarkEntity trademarkEntity);
}
