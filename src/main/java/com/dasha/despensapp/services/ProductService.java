package com.dasha.despensapp.services;

import com.dasha.despensapp.controller.dto.CategoryDTO;
import com.dasha.despensapp.controller.dto.ProductDTO;
import com.dasha.despensapp.repository.ProductRepository;
import com.dasha.despensapp.repository.entity.CategoryJPA;
import com.dasha.despensapp.repository.entity.ProductJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductDTO mapToDTO(ProductJPA jpa) {
        ProductDTO dto = new ProductDTO();
        dto.setId(jpa.getId());
        dto.setName(jpa.getName());
        dto.setDescription(jpa.getDescription());
        dto.setCategory(mapToDTO(jpa.getCategory()));
        dto.setPhoto(jpa.getPhoto());
        dto.setAmount(jpa.getAmount());

        return dto;
    }

    public List<ProductDTO> getProducts(Long idInventory) {
        List<ProductJPA> products = productRepository.findByInventoryId(idInventory);
        List<ProductDTO> dtos = new ArrayList<>();

        for(ProductJPA jpa : products) {
            ProductDTO dto = mapToDTO(jpa);
            dtos.add(dto);
        }
        return dtos;
    }

    private CategoryDTO mapToDTO(CategoryJPA jpa) {
        CategoryDTO dto = new CategoryDTO(jpa.getId(), jpa.getName());
        return dto;
    }
}
