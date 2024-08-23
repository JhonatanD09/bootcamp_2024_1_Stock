package com.bootcamp.Stock.application.mapper.trademark;

import com.bootcamp.Stock.application.dto.trademark.TrademarkRequest;
import com.bootcamp.Stock.domain.model.Trademark;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapperTrademarkRequest {

    Trademark toTrademark(TrademarkRequest request);
}
