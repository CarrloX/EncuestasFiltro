package com.riwi.encuestas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(path = "/question")
    public ResponseEntity<QuestionResp> insert(
            @Validated @RequestBody QuestionReq request) {
        return ResponseEntity.ok(this.questionService.create(request));
    }

    @GetMapping
    @RequestMapping(path = "/questions")
    public ResponseEntity<Page<QuestionResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(this.questionService.getAll(page - 1, size));
    }

    @DeleteMapping(path = "/questions/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.questionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/questions/{id}")
    public ResponseEntity<QuestionResp> update(
            @Validated @RequestBody QuestionReq request,
            @PathVariable String id) {
        return ResponseEntity.ok(this.questionService.update(request, id));
    }
}
