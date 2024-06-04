package com.riwi.encuestas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping
    @RequestMapping(path = "/surveys")
    public ResponseEntity<SurveyResp> insert(
            @Validated @RequestBody SurveyReq request) {
        return ResponseEntity.ok(this.surveyService.create(request));
    }
}
