package com.alexandre.projetoClientesPessoal.entidy;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categoria")
public class Category {

    @jakarta.persistence.Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nome")
    private String name;

    @ManyToMany(mappedBy = "categoryList")
    private List<Product> productList = new ArrayList<>();



}
