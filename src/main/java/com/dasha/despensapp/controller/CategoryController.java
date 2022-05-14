package com.dasha.despensapp.controller;

import com.dasha.despensapp.controller.dto.CategoryDTO;
import com.dasha.despensapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping
    public List<CategoryDTO> getCategories() {

        return categoryService.getAllCategories();
    }
}
