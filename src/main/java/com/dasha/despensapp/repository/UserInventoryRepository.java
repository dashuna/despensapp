package com.dasha.despensapp.repository;

import com.dasha.despensapp.repository.entity.InventoryJPA;
import com.dasha.despensapp.repository.entity.UserInventoryJPA;
import com.dasha.despensapp.repository.entity.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInventoryRepository extends JpaRepository<UserInventoryJPA, Long> {

//    @Query("SELECT U.inventory FROM UserInventoryJPA U WHERE U.user.id = :userId")
//    List<InventoryJPA> findByUserId(@Param("userId") Long userId);

    @Query("SELECT U FROM UserInventoryJPA U WHERE U.user.id = :userId")
    List<UserInventoryJPA> findByUserId(@Param("userId") Long userId);

    @Query("SELECT U.user FROM UserInventoryJPA U WHERE U.inventory.id = :inventoryId")
    List<UserJPA> findUserByInventory(@Param("inventoryId") Long inventoryId);

    @Query("SELECT U FROM UserInventoryJPA U WHERE U.user.id = :userId AND U.inventory.id = :inventoryId")
    UserInventoryJPA findByUserIdAndInventoryId(@Param("userId")Long userId,@Param("inventoryId") Long inventoryId);
}
