package com.riwi.encuestas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.encuestas.api.dto.request.UserReq;
import com.riwi.encuestas.api.dto.response.UserResp;
import com.riwi.encuestas.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserResp> insert(
            @Validated @RequestBody UserReq request) {
        return ResponseEntity.ok(this.userService.create(request));
    }
}
