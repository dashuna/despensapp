package com.dasha.despensapp.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_inventories")
public class UserInventoryJPA {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_inventory", nullable=false)
    private InventoryJPA inventory;

    @ManyToOne
    @JoinColumn(name="id_user", nullable=false)
    private UserJPA user;

    private Boolean accepted;
    private Boolean isAdmin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InventoryJPA getInventory() {
        return inventory;
    }

    public void setInventory(InventoryJPA inventory) {
        this.inventory = inventory;
    }

    public UserJPA getUser() {
        return user;
    }

    public void setUser(UserJPA user) {
        this.user = user;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
