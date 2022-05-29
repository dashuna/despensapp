package com.dasha.despensapp.controller.dto;

public class InventoryDTO {

    private Long id;
    private String name;

    public InventoryDTO() {
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
