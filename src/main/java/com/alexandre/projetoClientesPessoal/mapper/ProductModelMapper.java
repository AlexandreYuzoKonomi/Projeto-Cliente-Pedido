package com.alexandre.projetoClientesPessoal.mapper;

import com.alexandre.projetoClientesPessoal.entidy.Category;
import com.alexandre.projetoClientesPessoal.entidy.Product;
import com.alexandre.projetoClientesPessoal.payload.ProductResponse;
import com.alexandre.projetoClientesPessoal.repository.CategoryRepository;
import com.alexandre.projetoClientesPessoal.repository.ProductRepository;

public class ProductModelMapper {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public ProductModelMapper(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public static ProductResponse mapProductToProductResponse(Product product) {



        ProductResponse productResponse = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .productPrice(product.getProductPrice())
                .build();

        return productResponse;
    }
}
