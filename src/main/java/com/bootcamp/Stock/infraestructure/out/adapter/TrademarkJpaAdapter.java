package com.bootcamp.Stock.infraestructure.out.adapter;

import com.bootcamp.Stock.domain.model.Category;
import com.bootcamp.Stock.domain.model.Trademark;
import com.bootcamp.Stock.domain.spi.ITrademarkPersistencePort;
import com.bootcamp.Stock.infraestructure.exceptions.TrademarkAlreadyExistException;
import com.bootcamp.Stock.infraestructure.out.entity.TrademarkEntity;
import com.bootcamp.Stock.infraestructure.out.mapper.ITrademarkEntityMapper;
import com.bootcamp.Stock.infraestructure.out.repository.ITrademarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TrademarkJpaAdapter implements ITrademarkPersistencePort {

    private final ITrademarkRepository iTrademarkRepository;
    private final ITrademarkEntityMapper iTrademarkEntityMapper;

    @Override
    public void createTrademark(Trademark trademark) {
        if(iTrademarkRepository.findByName(trademark.getName()).isPresent()){
            throw new TrademarkAlreadyExistException();
        }else{
            iTrademarkRepository.save(iTrademarkEntityMapper.toTrademarkEntity(trademark));
        }
    }

    @Override
    public Page<Trademark> getAllCategories(String order, Pageable pageable) {
        return order.trim().equalsIgnoreCase("ASC")
                ?mapTrademarkPageToResponsePage(iTrademarkRepository.findAllByOrderByNameAsc(pageable))
                :mapTrademarkPageToResponsePage(iTrademarkRepository.findAllByOrderByNameDesc(pageable));
    }


    private  Page<Trademark> mapTrademarkPageToResponsePage(Page<TrademarkEntity> trademarkEntityPage) {
        List<Trademark> categoryResponses = trademarkEntityPage.stream()
                .map(iTrademarkEntityMapper::toTrademark)
                .collect(Collectors.toList());
        return new PageImpl<>(categoryResponses, trademarkEntityPage.getPageable(), trademarkEntityPage.getTotalElements());
    }
}
