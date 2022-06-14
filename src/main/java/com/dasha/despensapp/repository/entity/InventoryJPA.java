package com.dasha.despensapp.repository.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "inventories")
public class InventoryJPA {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy="inventory")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Set<UserInventoryJPA> userInventories;

    @OneToMany(mappedBy="inventory")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Set<ProductJPA> products;

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

    public Set<UserInventoryJPA> getUserInventories() {
        return userInventories;
    }

    public void setUserInventories(Set<UserInventoryJPA> userInventories) {
        this.userInventories = userInventories;
    }

    public Set<ProductJPA> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductJPA> products) {
        this.products = products;
    }
}
