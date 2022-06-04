package com.dasha.despensapp.repository.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "categories")
public class CategoryJPA {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy="category")
    private List<ProductJPA> products;

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

    public List<ProductJPA> getProducts() {
        return products;
    }

    public void setProducts(List<ProductJPA> products) {
        this.products = products;
    }
}
