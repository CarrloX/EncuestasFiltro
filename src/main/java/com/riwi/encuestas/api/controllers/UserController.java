package com.riwi.encuestas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.encuestas.api.dto.request.UserReq;
import com.riwi.encuestas.api.dto.response.UserResp;
import com.riwi.encuestas.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private final IUserService userService;

    @PostMapping
    @RequestMapping(path = "/users")
    public ResponseEntity<UserResp> insert(
            @Validated @RequestBody UserReq request) {
        return ResponseEntity.ok(this.userService.create(request));
    }

    @GetMapping
    @RequestMapping(path = "/class")
    public ResponseEntity<Page<UserResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(this.userService.getAll(page - 1, size));
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserResp> get(
            @PathVariable String id) {
        return ResponseEntity.ok(this.userService.get(id));
    }

    @PutMapping(path = "users/{id}")
    public ResponseEntity<UserResp> update(
            @Validated @RequestBody UserReq request,
            @PathVariable String id) {
        return ResponseEntity.ok(this.userService.update(request, id));
    }
}
