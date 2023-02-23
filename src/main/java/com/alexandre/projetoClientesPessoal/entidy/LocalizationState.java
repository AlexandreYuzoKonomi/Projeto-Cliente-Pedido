package com.alexandre.projetoClientesPessoal.entidy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tab_estado")
public class LocalizationState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;

    @OneToMany(mappedBy = "localizationState")
    private List<City> cities = new ArrayList<>();


}
