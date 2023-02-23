package com.alexandre.projetoClientesPessoal.entidy;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Builder
@Entity
@Getter
@Setter
@Table(name = "tab_cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;
    private String email;
    @Column(name = "documento")
    private String document;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Address address;


}
