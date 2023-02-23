package com.alexandre.projetoClientesPessoal.entidy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="tab_endereco")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "logradouro")
    private String adressLocation;
    @Column(name = "numero")
    private String number;
    @Column(name = "complemento")
    private String complementLocation;
    @Column(name = "bairro")
    private String district;
    private String cep;
    @Column(name = "cidade_id")
    private String city;
}
