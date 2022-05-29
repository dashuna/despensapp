package com.dasha.despensapp.repository;

import com.dasha.despensapp.repository.entity.InventoryJPA;
import com.dasha.despensapp.repository.entity.UserInventoryJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInventoryRepository extends JpaRepository<UserInventoryJPA, Long> {

    @Query("SELECT U.inventory FROM UserInventoryJPA U WHERE U.user.id = :userId")
    List<InventoryJPA> findByUserId(@Param("userId") Long userId);
}
