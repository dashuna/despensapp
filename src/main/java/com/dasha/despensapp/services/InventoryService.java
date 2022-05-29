package com.dasha.despensapp.services;

import com.dasha.despensapp.controller.dto.InventoryDTO;
import com.dasha.despensapp.repository.InventoryRepository;
import com.dasha.despensapp.repository.UserInventoryRepository;
import com.dasha.despensapp.repository.entity.InventoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private UserInventoryRepository userInventoryRepository;

    public List<InventoryDTO> getInventories(Long idUser) {
        List<InventoryJPA> inventories = userInventoryRepository.findByUserId(idUser);
        List<InventoryDTO> dtos = new ArrayList<>();

        for (InventoryJPA jpa : inventories) {
            InventoryDTO dto = mapToDTO(jpa);
            dtos.add(dto);
        }

        return dtos;
    }

    private InventoryDTO mapToDTO(InventoryJPA jpa) {
        InventoryDTO dto = new InventoryDTO();
        dto.setId(jpa.getId());
        dto.setName(jpa.getName());
        return dto;
    }
}
