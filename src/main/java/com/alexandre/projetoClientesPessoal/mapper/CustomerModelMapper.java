package com.alexandre.projetoClientesPessoal.mapper;

import com.alexandre.projetoClientesPessoal.entidy.Customer;
import com.alexandre.projetoClientesPessoal.payload.CustomerResponse;

public class CustomerModelMapper {

    public static CustomerResponse mapCustomerToCustomerResponse(Customer customer){
        CustomerResponse customerResponse = CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .document(customer.getDocument())
                .build();

      return customerResponse;
    }
}
