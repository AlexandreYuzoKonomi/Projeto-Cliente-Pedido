package com.alexandre.projetoClientesPessoal.payload;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdressResponse {
    private String adressLocation;
    private String number;
    private String complementLocation;
    private String district;
    private String cep;

}
