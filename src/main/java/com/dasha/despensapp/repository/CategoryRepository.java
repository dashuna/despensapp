package com.dasha.despensapp.repository;

import com.dasha.despensapp.repository.entity.CategoryJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryJPA, Long> {


}
