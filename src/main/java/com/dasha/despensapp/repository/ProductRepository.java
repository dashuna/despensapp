package com.dasha.despensapp.repository;

import com.dasha.despensapp.repository.entity.ProductJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductJPA, Long> {

    @Query("SELECT P FROM ProductJPA P " +
            //"JOIN FETCH P.category " +
            "WHERE P.inventory.id = :idInventory")
    List<ProductJPA> findByInventoryId(@Param("idInventory") Long idInventory);

}
