package com.alexandre.projetoClientesPessoal.service;

import com.alexandre.projetoClientesPessoal.entidy.Category;
import com.alexandre.projetoClientesPessoal.mapper.CategoryModelMapper;
import com.alexandre.projetoClientesPessoal.payload.CategoryResponse;
import com.alexandre.projetoClientesPessoal.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponse> getAll() {

        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponse> categoryResponseList = categoryList.stream()
                .map(CategoryModelMapper::mapCategoryToCategoryResponse)
                .collect(Collectors.toList());

//        for(Category c : categoryList){
//            CategoryResponse categoryResponse = CategoryResponse.builder()
//                    .id(c.getId())
//                    .name(c.getName())
//                    .build();
//            categoryResponseList.add(categoryResponse);
//
//        }

        return categoryResponseList;
    }

    public CategoryResponse getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Category not found"));

//        if (categoryOptional.isPresent()){
//            Category category = categoryOptional.get();

//            CategoryResponse categoryResponse = CategoryResponse.builder()
//                    .id(category.getId())
//                    .name(category.getName())
//                    .build();
            return CategoryModelMapper.mapCategoryToCategoryResponse(category);
        }

}
