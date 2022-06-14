package com.dasha.despensapp.repository;

import com.dasha.despensapp.repository.entity.InventoryJPA;
import com.dasha.despensapp.repository.entity.ShoppingProductJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingProductRepository extends JpaRepository<ShoppingProductJPA, Long> {

    @Query("SELECT S FROM ShoppingProductJPA S WHERE S.product.id = :productId AND S.buyed = false")
    Optional<ShoppingProductJPA> findByProductIdAndBuyedFalse(Long productId);


    @Query("SELECT DISTINCT I FROM InventoryJPA I " +
            "JOIN I.userInventories U " +
            "JOIN FETCH I.products P " +
            "JOIN FETCH P.shoppingProducts S " +
            "JOIN FETCH S.userAdded UA " +
            "WHERE U.user.id = :userId " +
            "AND S.buyed = false")
    List<InventoryJPA> findShoppingInventoriesByUserId(Long userId);
}
