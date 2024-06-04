package com.riwi.encuestas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.encuestas.domain.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
    
}
