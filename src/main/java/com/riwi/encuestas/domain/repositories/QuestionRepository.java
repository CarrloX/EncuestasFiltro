package com.riwi.encuestas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.encuestas.domain.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, String>{
    
}
