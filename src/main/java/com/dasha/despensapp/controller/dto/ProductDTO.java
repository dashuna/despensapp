package com.dasha.despensapp.controller.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private CategoryDTO category;
    private String photo;

    private Long inventoryId;
    private BigDecimal amount;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, CategoryDTO category, String photo, Long inventoryId, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.photo = photo;
        this.inventoryId = inventoryId;
        this.amount = amount;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
