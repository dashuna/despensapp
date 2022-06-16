package com.dasha.despensapp.repository.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductJPA {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_category", nullable=false)
    private CategoryJPA category;

    private byte[] photo;
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_inventory", nullable=false)
    private InventoryJPA inventory;

    @OneToMany(mappedBy="product", fetch = FetchType.LAZY)
    private List<ShoppingProductJPA> shoppingProducts;

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

    public CategoryJPA getCategory() {
        return category;
    }

    public void setCategory(CategoryJPA category) {
        this.category = category;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public InventoryJPA getInventory() {
        return inventory;
    }

    public void setInventory(InventoryJPA inventory) {
        this.inventory = inventory;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<ShoppingProductJPA> getShoppingProducts() {
        return shoppingProducts;
    }

    public void setShoppingProducts(List<ShoppingProductJPA> shoppingProducts) {
        this.shoppingProducts = shoppingProducts;
    }
}
