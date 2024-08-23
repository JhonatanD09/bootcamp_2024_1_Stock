package com.bootcamp.Stock.infraestructure.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "marcas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrademarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")
    private String description;
}
