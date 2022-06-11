package com.dasha.despensapp.services;

import com.dasha.despensapp.controller.dto.InventoryDTO;
import com.dasha.despensapp.controller.dto.UserDTO;
import com.dasha.despensapp.repository.InventoryRepository;
import com.dasha.despensapp.repository.UserInventoryRepository;
import com.dasha.despensapp.repository.UserRepository;
import com.dasha.despensapp.repository.entity.InventoryJPA;
import com.dasha.despensapp.repository.entity.UserInventoryJPA;
import com.dasha.despensapp.repository.entity.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private UserInventoryRepository userInventoryRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<InventoryDTO> getInventories(Long idUser) {
        List<InventoryJPA> inventories = userInventoryRepository.findByUserId(idUser);
        List<InventoryDTO> dtos = new ArrayList<>();

        for (InventoryJPA jpa : inventories) {
            InventoryDTO dto = mapToDTO(jpa);
            dtos.add(dto);
        }
        return dtos;
    }

    public InventoryDTO saveInventory(InventoryDTO dto, Long idUser) {
        InventoryJPA jpa = mapToJPA(dto);
        InventoryJPA guardado = inventoryRepository.save(jpa);

        UserInventoryJPA userInventoryJPA = new UserInventoryJPA();
        userInventoryJPA.setInventory(guardado);
        userInventoryJPA.setUser(userRepository.getById(idUser));
        userInventoryJPA.setAccepted(true);
        userInventoryJPA.setAdmin(true);
        userInventoryRepository.save(userInventoryJPA);

        return mapToDTO(guardado);
    }
    public List<UserDTO> getUserByInventory(Long idInventory) {
        List<UserJPA> users = userInventoryRepository.findUserByInventory(idInventory);
        List<UserDTO> dtos = new ArrayList<>();

        for(UserJPA jpa : users) {
            UserDTO dto = mapToDTO(jpa);
            dto.setPassword(null);
            dtos.add(dto);
        }
        return dtos;
    }

    /*public InventoryDTO sendInvitation(InventoryDTO dto, String user) {
        InventoryJPA jpa = mapToJPA(dto);
        InventoryJPA inventoryJPA = inventoryRepository.getById(jpa.getId());

        UserInventoryJPA userInventoryJPA = new UserInventoryJPA();
        userInventoryJPA.setInventory(inventoryJPA);
        userInventoryJPA.setUser(userRepository.getById());
        userInventoryJPA.setAccepted(false);
    }*/


    private InventoryDTO mapToDTO(InventoryJPA jpa) {
        InventoryDTO dto = new InventoryDTO();
        dto.setId(jpa.getId());
        dto.setName(jpa.getName());
        return dto;
    }

    private InventoryJPA mapToJPA (InventoryDTO dto) {
        InventoryJPA jpa = new InventoryJPA();
        jpa.setId(dto.getId());
        jpa.setName(dto.getName());

        return jpa;
    }

    private UserDTO mapToDTO (UserJPA jpa) {
        UserDTO dto = new UserDTO();
        dto.setId(jpa.getId());
        dto.setUser(jpa.getUser());
        dto.setPassword(jpa.getPassword());
        dto.setName(jpa.getName());
        dto.setLast_name(jpa.getLast_name());
        dto.setEmail(jpa.getEmail());
        dto.setTelephone(jpa.getTelephone());
        dto.setPhoto(jpa.getPhoto());

        return dto;
    }
}
