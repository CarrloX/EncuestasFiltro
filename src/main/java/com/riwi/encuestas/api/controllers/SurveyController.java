package com.riwi.encuestas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.encuestas.api.dto.request.SurveyReq;
import com.riwi.encuestas.api.dto.response.SurveyResp;
import com.riwi.encuestas.infrastructure.abstract_services.ISurveyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SurveyController {

    @Autowired
    private final ISurveyService surveyService;

    @GetMapping(path = "/surveys")
    public ResponseEntity<Page<SurveyResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(this.surveyService.getAll(page - 1, size));
    }

    @PostMapping
    @RequestMapping(path = "/surveys")
    public ResponseEntity<SurveyResp> insert(
            @Validated @RequestBody SurveyReq request) {
        return ResponseEntity.ok(this.surveyService.create(request));
    }

    @GetMapping(path = "/surveys/{id}")
    public ResponseEntity<SurveyResp> get(
            @PathVariable String id) {
        return ResponseEntity.ok(this.surveyService.get(id));
    }
}
