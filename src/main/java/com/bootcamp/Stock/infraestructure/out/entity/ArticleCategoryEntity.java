package com.bootcamp.Stock.infraestructure.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articulos_categorias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name = "id_articulo")
    private ArticleEntity articleEntity;
}
