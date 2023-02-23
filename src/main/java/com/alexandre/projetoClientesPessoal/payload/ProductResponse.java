package com.alexandre.projetoClientesPessoal.payload;

import com.alexandre.projetoClientesPessoal.entidy.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private Double productPrice;
    private List<CategoryResponse> categories;


}
