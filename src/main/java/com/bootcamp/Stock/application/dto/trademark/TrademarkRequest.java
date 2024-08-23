package com.bootcamp.Stock.application.dto.trademark;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class TrademarkRequest {

    private long id;
    private String name;
    private  String description;


}
