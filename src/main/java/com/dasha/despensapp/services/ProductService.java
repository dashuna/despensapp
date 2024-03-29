package com.dasha.despensapp.services;

import com.dasha.despensapp.controller.dto.CategoryDTO;
import com.dasha.despensapp.controller.dto.ProductDTO;
import com.dasha.despensapp.controller.dto.UserDTO;
import com.dasha.despensapp.repository.CategoryRepository;
import com.dasha.despensapp.repository.InventoryRepository;
import com.dasha.despensapp.repository.ProductRepository;
import com.dasha.despensapp.repository.entity.CategoryJPA;
import com.dasha.despensapp.repository.entity.ProductJPA;
import com.dasha.despensapp.repository.entity.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<ProductDTO> getProducts(Long idInventory) {
        List<ProductJPA> products = productRepository.findByInventoryId(idInventory);
        List<ProductDTO> dtos = new ArrayList<>();

        for(ProductJPA jpa : products) {
            ProductDTO dto = mapToDTO(jpa);
            dtos.add(dto);
        }
        return dtos;
    }

    public ProductDTO saveProduct(ProductDTO dto) {
        ProductJPA jpa = mapToJPA(dto);
        ProductJPA guardado = productRepository.save(jpa);
        return mapToDTO(guardado);
    }


    public ProductDTO getById(Long id) {
        ProductJPA productJpa = productRepository.getById(id);
//        Optional<ProductJPA> dos = productRepository.findById(id);
        return mapToDTO(productJpa);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO mapToDTO(ProductJPA jpa) {
        ProductDTO dto = new ProductDTO();
        dto.setId(jpa.getId());
        dto.setName(jpa.getName());
        dto.setDescription(jpa.getDescription());
        dto.setCategory(mapToDTO(jpa.getCategory()));
        if (jpa.getPhoto() != null && jpa.getPhoto().length > 0) {
            dto.setPhoto(Base64.getEncoder().encodeToString(jpa.getPhoto()));
        }
        dto.setAmount(jpa.getAmount());
        return dto;
    }

    private ProductJPA mapToJPA (ProductDTO dto) {
        ProductJPA jpa = new ProductJPA();
        jpa.setId(dto.getId());
        jpa.setName(dto.getName());
        jpa.setDescription(dto.getDescription());
        jpa.setCategory(categoryRepository.findById(dto.getCategory().getId()).get());
        if (StringUtils.hasText(dto.getPhoto())) {
            jpa.setPhoto(Base64.getDecoder().decode(dto.getPhoto()));
        }
        jpa.setInventory(inventoryRepository.findById(dto.getInventoryId()).get());
        jpa.setAmount(dto.getAmount());

        return jpa;
    }


    private CategoryDTO mapToDTO(CategoryJPA jpa) {
        CategoryDTO dto = new CategoryDTO(jpa.getId(), jpa.getName());
        return dto;
    }


}
