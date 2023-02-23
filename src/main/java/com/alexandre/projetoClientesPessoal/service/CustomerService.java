package com.alexandre.projetoClientesPessoal.service;

import com.alexandre.projetoClientesPessoal.entidy.Address;
import com.alexandre.projetoClientesPessoal.entidy.Customer;
import com.alexandre.projetoClientesPessoal.mapper.CustomerModelMapper;
import com.alexandre.projetoClientesPessoal.payload.AdressResponse;
import com.alexandre.projetoClientesPessoal.payload.CustomerByIdResponse;
import com.alexandre.projetoClientesPessoal.payload.CustomerRequest;
import com.alexandre.projetoClientesPessoal.payload.CustomerResponse;
import com.alexandre.projetoClientesPessoal.repository.AdressRepository;
import com.alexandre.projetoClientesPessoal.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AdressRepository adressRepository;

    public CustomerService(CustomerRepository customerRepository, AdressRepository adressRepository) {
        this.customerRepository = customerRepository;
        this.adressRepository = adressRepository;
    }

    public List<CustomerResponse> getAll() {
        List<Customer> customerList = customerRepository.findAll();

        List<CustomerResponse> customerResponse = customerList.stream()
                .map(CustomerModelMapper::mapCustomerToCustomerResponse)
                .collect(Collectors.toList());
        return customerResponse;

    }

    public ResponseEntity<?> getById(Long id) {

        Customer customer = customerRepository.findById(id)
               .orElseThrow(() -> new ResourceAccessException("customer not found"));

            List<AdressResponse> adressResponseList = customerRepository.findAddressList(id) ;

            CustomerByIdResponse customerResponse = CustomerByIdResponse.builder()
                    .id(customer.getId())
                    .name(customer.getName())
                    .email(customer.getEmail())
                    .document(customer.getDocument())
                    .adress(adressResponseList)
                    .build();

            return ResponseEntity.ok(customerResponse);

    }

    public ResponseEntity<?> create(CustomerRequest customerRequest) {

        Address address = adressRepository.findById(customerRequest.getAdressId())
                .orElseThrow(() -> new ResourceAccessException("Adress not found!!"));

        Customer customer = Customer.builder()
                .id(customerRequest.getId())
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .document(customerRequest.getDocument())
                .address(address)
                .build();
        customerRepository.save(customer);

        return ResponseEntity.ok("Customer created successfully");
    }

    public ResponseEntity<?> deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customerRepository.delete(customer);
        return ResponseEntity.ok("Customer deleted sucessfully");
    }

    public ResponseEntity<?> search(String query){

        List<Customer> customerList = customerRepository.searchCustomer(query);

        return ResponseEntity.ok(customerList);
    }
}
