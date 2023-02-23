package com.alexandre.projetoClientesPessoal.service;

import com.alexandre.projetoClientesPessoal.entidy.Category;
import com.alexandre.projetoClientesPessoal.entidy.Product;
import com.alexandre.projetoClientesPessoal.mapper.ProductModelMapper;
import com.alexandre.projetoClientesPessoal.payload.CategoryResponse;
import com.alexandre.projetoClientesPessoal.payload.ProductResponse;
import com.alexandre.projetoClientesPessoal.payload.ProductResquest;
import com.alexandre.projetoClientesPessoal.repository.CategoryRepository;
import com.alexandre.projetoClientesPessoal.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    public List<ProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponseList = products.stream()
                .map(ProductModelMapper::mapProductToProductResponse)
                .collect(Collectors.toList());

//        for (Product p : products) {
//            ProductResponse productResponse = ProductResponse.builder()
//                    .id(p.getId())
//                    .name(p.getName())
//                    .productPrice(p.getProductPrice())
//                    .build();
//            productResponseList.add(productResponse);
//        }

        return productResponseList;
    }


    public ResponseEntity<?> getById(Long id) {

        Product product = productRepository.findByIdWithCategories(id)
                .orElseThrow(() -> new ResourceAccessException("Product not found"));

            List<CategoryResponse> categoriesList = new ArrayList<>();
            for (Category category : product.getCategoryList()) {
                CategoryResponse categoryResponse = CategoryResponse.builder()
                        .name(category.getName())
                        .id(category.getId())
                        .build();
                categoriesList.add(categoryResponse);
            }

            ProductResponse productResponse = ProductResponse.builder()

                    .id(product.getId())
                    .name(product.getName())
                    .productPrice(product.getProductPrice())
                    .categories(categoriesList)
                    .build();

            return ResponseEntity.ok(productResponse);


    }


    public ResponseEntity<?> createProduct(ProductResquest productRequest) {

        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new ResourceAccessException("Category not found"));

        Product product = new Product();

        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setProductPrice(productRequest.getProductPrice());

        List<Category> categories = new ArrayList<>();
        categories.add(category);
        product.setCategoryList(categories);

        productRepository.save(product);

        return ResponseEntity.ok("Product created sucessfully");
    }
}
