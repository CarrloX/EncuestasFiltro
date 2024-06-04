package com.riwi.encuestas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.encuestas.api.dto.errors.BaseErrorResponse;
import com.riwi.encuestas.api.dto.request.SurveyReq;
import com.riwi.encuestas.api.dto.response.SurveyResp;
import com.riwi.encuestas.infrastructure.abstract_services.ISurveyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SurveyController {

    @Autowired
    private final ISurveyService surveyService;

    @Operation(summary = "obtiene toda las encuestas de forma paginada")

    @GetMapping(path = "/surveys")
    public ResponseEntity<Page<SurveyResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(this.surveyService.getAll(page - 1, size));
    }

    @ApiResponse(responseCode = "400", description = "cuando el request no es valido", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = BaseErrorResponse.class))
    })

    @PostMapping
    @RequestMapping(path = "/surveys")
    public ResponseEntity<SurveyResp> insert(
            @Validated @RequestBody SurveyReq request) {
        return ResponseEntity.ok(this.surveyService.create(request));
    }

    @ApiResponse(responseCode = "400", description = "cuando el ID no es valido", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })

    @GetMapping(path = "/surveys/{id}")
    public ResponseEntity<SurveyResp> get(
            @PathVariable String id) {
        return ResponseEntity.ok(this.surveyService.get(id));
    }
}
