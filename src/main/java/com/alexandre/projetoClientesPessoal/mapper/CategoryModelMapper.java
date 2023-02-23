package com.alexandre.projetoClientesPessoal.mapper;

import com.alexandre.projetoClientesPessoal.entidy.Category;
import com.alexandre.projetoClientesPessoal.payload.CategoryResponse;

public class CategoryModelMapper {

    public static CategoryResponse mapCategoryToCategoryResponse(Category category) {

        CategoryResponse categoryResponse = CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();

        return categoryResponse;

    }
}
