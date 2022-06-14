package com.dasha.despensapp.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShoppingProductDTO {

    private Long id;
    private ProductDTO product;
    private UserNameDTO userAdded;
    private UserNameDTO userBuyed;
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

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public UserNameDTO getUserAdded() {
        return userAdded;
    }

    public void setUserAdded(UserNameDTO userAdded) {
        this.userAdded = userAdded;
    }

    public UserNameDTO getUserBuyed() {
        return userBuyed;
    }

    public void setUserBuyed(UserNameDTO userBuyed) {
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
