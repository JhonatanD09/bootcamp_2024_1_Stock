package com.bootcamp.Stock.application.dto.category;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CategoryRequest {

    private long id;
    private String name;
    private  String description;


}
