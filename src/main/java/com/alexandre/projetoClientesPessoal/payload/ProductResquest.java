package com.alexandre.projetoClientesPessoal.payload;

import com.alexandre.projetoClientesPessoal.entidy.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@Builder
public class ProductResquest {
    private Long id;
    private String name;
    private Double productPrice;
    private Long categoryId;

}
