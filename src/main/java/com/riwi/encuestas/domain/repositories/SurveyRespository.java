package com.riwi.encuestas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.encuestas.domain.entity.SurveyEntity;

public interface SurveyRespository extends JpaRepository<SurveyEntity, String>{
    
}
