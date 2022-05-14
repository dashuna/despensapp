package com.dasha.despensapp.services;

import com.dasha.despensapp.controller.dto.CategoryDTO;
import com.dasha.despensapp.repository.CategoryRepository;
import com.dasha.despensapp.repository.entity.CategoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {
        List<CategoryJPA> categoriesJpa = categoryRepository.findAll();

//        categoriesJpa.stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());

        List<CategoryDTO> categoryDTOs = new ArrayList<>();

        for(CategoryJPA jpa : categoriesJpa) {
            CategoryDTO dto = mapToDTO(jpa);
            categoryDTOs.add(dto);
        }

        return categoryDTOs;
    }

    private CategoryDTO mapToDTO(CategoryJPA jpa) {
        CategoryDTO dto = new CategoryDTO(jpa.getId(), jpa.getName());
        return dto;
    }
}
