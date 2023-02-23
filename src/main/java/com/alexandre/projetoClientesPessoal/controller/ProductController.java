package com.alexandre.projetoClientesPessoal.controller;

import com.alexandre.projetoClientesPessoal.payload.ProductResponse;
import com.alexandre.projetoClientesPessoal.payload.ProductResquest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alexandre.projetoClientesPessoal.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAll() {

        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        return productService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductResquest productRequest){
        return productService.createProduct(productRequest);
    }
}
