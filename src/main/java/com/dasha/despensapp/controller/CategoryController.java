package com.dasha.despensapp.controller;

import com.dasha.despensapp.config.CustomUserDetails;
import com.dasha.despensapp.config.JwtTokenUtil;
import com.dasha.despensapp.controller.dto.CategoryDTO;
import com.dasha.despensapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping
    public List<CategoryDTO> getCategories() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.err.println("El usuario es: "+ user.getUsername());
        return categoryService.getAllCategories();
    }
}
