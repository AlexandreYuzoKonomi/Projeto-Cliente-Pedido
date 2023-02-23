package com.alexandre.projetoClientesPessoal.repository;

import com.alexandre.projetoClientesPessoal.entidy.Address;
import com.alexandre.projetoClientesPessoal.payload.AdressResponse;

import java.util.List;

public interface CustomerRepositoryCustom {


    List<AdressResponse> findAddressList (Long id);
}
