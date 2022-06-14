package com.dasha.despensapp.controller.dto;

import java.util.List;

public class ShoppingInventoryDTO {
    private Long inventoryId;
    private String name;

    private List<ShoppingProductDTO> products;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShoppingProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ShoppingProductDTO> products) {
        this.products = products;
    }
}
