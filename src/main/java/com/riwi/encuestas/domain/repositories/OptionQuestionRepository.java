package com.riwi.encuestas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.encuestas.domain.entity.OptionQuestion;

public interface OptionQuestionRepository extends JpaRepository<OptionQuestion, String> {
    
}
