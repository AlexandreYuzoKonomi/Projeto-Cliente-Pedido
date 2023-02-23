package com.alexandre.projetoClientesPessoal.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryResponse {

    public Long id;
    public String name;
}
