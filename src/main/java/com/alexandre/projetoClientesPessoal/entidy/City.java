package com.alexandre.projetoClientesPessoal.entidy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tab_cidade")
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="estado")
    private LocalizationState localizationState;

}
