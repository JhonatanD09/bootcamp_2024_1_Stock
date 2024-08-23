package com.bootcamp.Stock.application.handler.trademark;

import com.bootcamp.Stock.application.dto.category.CategoryResponse;
import com.bootcamp.Stock.application.dto.trademark.TrademarkRequest;
import com.bootcamp.Stock.application.dto.trademark.TrademarkResponse;
import com.bootcamp.Stock.application.mapper.trademark.MapperTrademarkRequest;
import com.bootcamp.Stock.application.mapper.trademark.MapperTrademarkResponse;
import com.bootcamp.Stock.application.utils.constans.Constans;
import com.bootcamp.Stock.application.utils.validators.ValidatorRequest;
import com.bootcamp.Stock.domain.api.ITrademarkServicePort;
import com.bootcamp.Stock.domain.model.Category;
import com.bootcamp.Stock.domain.model.Trademark;
import com.bootcamp.Stock.infraestructure.exceptions.DescriptionToCategoryNotFound;
import com.bootcamp.Stock.infraestructure.exceptions.DescriptionToTrademarkNotFound;
import com.bootcamp.Stock.infraestructure.exceptions.InvalidDataLength;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrademarkHandler implements IHandlerTrademark{

    private final ITrademarkServicePort iTrademarkServicePort;
    private final MapperTrademarkRequest mapperTrademarkRequest;
    private final MapperTrademarkResponse mapperTrademarkResponse;

    @Override
    public void createTrademark(TrademarkRequest request) {
        if(request.getDescription() == null || request.getDescription().isEmpty()){
            throw  new DescriptionToTrademarkNotFound();
        }else{
            if (ValidatorRequest.valideField(request.getName(), Constans.MAX_LENGTH_NAME_TRADEMARK) &&
                    ValidatorRequest.valideField(request.getDescription(),Constans.MAX_LENGTH_DESCRIPTION_TRADEMARK)){
                request.setName(request.getName().trim());
                iTrademarkServicePort.createTrademark(mapperTrademarkRequest.toTrademark(request));
            }else {
                throw  new InvalidDataLength();
            }
        }
    }

    @Override
    public Page<TrademarkResponse> getAllTrademarks(String order, Pageable pageable) {
        return mapCategoryPageToResponsePage(iTrademarkServicePort.getAllCategories(order,pageable));
    }

    private  Page<TrademarkResponse> mapCategoryPageToResponsePage(Page<Trademark> trademarks) {
        List<TrademarkResponse> categoryResponses = trademarks.stream()
                .map(mapperTrademarkResponse::toTrademarkResponse)
                .collect(Collectors.toList());
        return new PageImpl<>(categoryResponses, trademarks.getPageable(), trademarks.getTotalElements());
    }
}
