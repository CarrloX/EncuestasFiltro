package com.riwi.encuestas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.encuestas.api.dto.request.QuestionReq;
import com.riwi.encuestas.api.dto.response.QuestionResp;
import com.riwi.encuestas.infrastructure.abstract_services.IQuestionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class QuestionController {

    @Autowired
    private final IQuestionService questionService;

    @PostMapping
    @RequestMapping(path = "/questions")
    public ResponseEntity<QuestionResp> insert(
            @Validated @RequestBody QuestionReq request) {
        return ResponseEntity.ok(this.questionService.create(request));
    }
}
