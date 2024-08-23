package com.bootcamp.Stock.application.handler.trademark;

import com.bootcamp.Stock.application.dto.trademark.TrademarkRequest;
import com.bootcamp.Stock.application.dto.trademark.TrademarkResponse;
import com.bootcamp.Stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHandlerTrademark {

    void createTrademark(TrademarkRequest request);
    Page<TrademarkResponse> getAllTrademarks(String order, Pageable pageable);

}
