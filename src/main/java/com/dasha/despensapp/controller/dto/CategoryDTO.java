package com.dasha.despensapp.controller.dto;

import java.util.List;

public class CategoryDTO {
    private Long id;
    private String name;
    //private List<CategoryDTO> childCategories;


    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
