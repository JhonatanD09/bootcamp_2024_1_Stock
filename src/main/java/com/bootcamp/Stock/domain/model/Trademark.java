package com.bootcamp.Stock.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class Trademark {

    private long id;
    private String name;
    private String description;

}
