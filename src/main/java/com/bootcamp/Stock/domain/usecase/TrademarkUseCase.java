package com.bootcamp.Stock.domain.usecase;

import com.bootcamp.Stock.domain.api.ITrademarkServicePort;
import com.bootcamp.Stock.domain.model.Category;
import com.bootcamp.Stock.domain.model.Trademark;
import com.bootcamp.Stock.domain.spi.ITrademarkPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class TrademarkUseCase implements ITrademarkServicePort {

    private final ITrademarkPersistencePort iTrademarkPersistencePort;

    @Override
    public void createTrademark(Trademark trademark) {
        iTrademarkPersistencePort.createTrademark(trademark);
    }

    @Override
    public Page<Trademark> getAllCategories(String order, Pageable pageable) {
        return iTrademarkPersistencePort.getAllCategories(order,pageable);
    }
}
