package com.dasha.despensapp.repository;

import com.dasha.despensapp.repository.entity.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserJPA, Long> {

    @Query("SELECT U FROM UserJPA U WHERE U.user = :user")
    Optional<UserJPA> findByUser(@Param("user") String user);



}
