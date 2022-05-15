package com.dasha.despensapp.services;

import com.dasha.despensapp.controller.dto.UserDTO;
import com.dasha.despensapp.repository.UserRepository;
import com.dasha.despensapp.repository.entity.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO insertUser(UserDTO dto) {
        UserJPA jpa = mapToJPA(dto);
        jpa.setId(null);
        UserJPA guardado = userRepository.save(jpa);
        return mapToDTO(guardado);
    }

    private UserJPA mapToJPA (UserDTO dto) {
        UserJPA jpa = new UserJPA();
        jpa.setId(dto.getId());
        jpa.setUser(dto.getUser());
        jpa.setPassword(dto.getPassword());
        jpa.setName(dto.getName());
        jpa.setLast_name(dto.getLast_name());
        jpa.setEmail(dto.getEmail());
        jpa.setTelephone(dto.getTelephone());
        jpa.setPhoto(dto.getPhoto());

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
