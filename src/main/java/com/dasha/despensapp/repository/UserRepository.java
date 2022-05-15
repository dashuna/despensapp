package com.dasha.despensapp.repository;

import com.dasha.despensapp.repository.entity.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJPA, Long> {

}
