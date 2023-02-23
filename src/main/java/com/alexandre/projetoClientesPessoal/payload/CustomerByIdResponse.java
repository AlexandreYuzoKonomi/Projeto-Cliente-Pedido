package com.alexandre.projetoClientesPessoal.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CustomerByIdResponse {

    private Long id;
    private String name;
    private String email;
    private String document;
    private List<AdressResponse> adress;


    // private Long adressId;
//    private String adressLocation;
//    private String number;
//    private String complementLocation;
//    private String district;
//    private String cep;
//    private String city;

}
