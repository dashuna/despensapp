package com.dasha.despensapp.repository;

import com.dasha.despensapp.repository.entity.InventoryJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryJPA, Long> {

}
