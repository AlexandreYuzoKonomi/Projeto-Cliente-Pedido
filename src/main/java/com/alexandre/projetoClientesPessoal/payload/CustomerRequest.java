package com.alexandre.projetoClientesPessoal.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class CustomerRequest {
    private Long id;
    private String name;
    private String email;
    private String document;
    private Long adressId;
}

