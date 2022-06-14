package com.dasha.despensapp.repository.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "shopping_product")
public class ShoppingProductJPA {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_product", nullable=false)
    private ProductJPA product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user_added", nullable=false)
    private UserJPA userAdded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user_buyed")
    private UserJPA userBuyed;

    private BigDecimal amount;

    private Boolean buyed;

    private LocalDateTime addedDate;
    private LocalDateTime buyedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductJPA getProduct() {
        return product;
    }

    public void setProduct(ProductJPA product) {
        this.product = product;
    }

    public UserJPA getUserAdded() {
        return userAdded;
    }

    public void setUserAdded(UserJPA userAdded) {
        this.userAdded = userAdded;
    }

    public UserJPA getUserBuyed() {
        return userBuyed;
    }

    public void setUserBuyed(UserJPA userBuyed) {
        this.userBuyed = userBuyed;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getBuyed() {
        return buyed;
    }

    public void setBuyed(Boolean buyed) {
        this.buyed = buyed;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public LocalDateTime getBuyedDate() {
        return buyedDate;
    }

    public void setBuyedDate(LocalDateTime buyedDate) {
        this.buyedDate = buyedDate;
    }
}
