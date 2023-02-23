package com.alexandre.projetoClientesPessoal.controller;

import com.alexandre.projetoClientesPessoal.entidy.Customer;
import com.alexandre.projetoClientesPessoal.payload.CustomerRequest;
import com.alexandre.projetoClientesPessoal.payload.CustomerResponse;
import com.alexandre.projetoClientesPessoal.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponse> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerRequest customerRequest) {

        return customerService.create(customerRequest);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {

        return customerService.deleteCustomer(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchProducts(@RequestParam("query") String query) {
        return (ResponseEntity<List<Customer>>) customerService.search(query);
    }
}
