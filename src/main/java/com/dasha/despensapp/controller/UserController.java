package com.dasha.despensapp.controller;

import com.dasha.despensapp.controller.dto.CategoryDTO;
import com.dasha.despensapp.controller.dto.UserDTO;
import com.dasha.despensapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO insertUser(@RequestBody UserDTO dto) {

        return userService.insertUser(dto);
    }

}
