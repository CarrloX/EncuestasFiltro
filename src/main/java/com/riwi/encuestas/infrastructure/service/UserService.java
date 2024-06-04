package com.riwi.encuestas.infrastructure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.encuestas.api.dto.request.UserReq;
import com.riwi.encuestas.api.dto.response.UserResp;
import com.riwi.encuestas.api.dto.response.UserToSurvey;
import com.riwi.encuestas.domain.entity.UserEntity;
import com.riwi.encuestas.domain.repositories.UserRepository;
import com.riwi.encuestas.infrastructure.abstract_services.IUserService;
import com.riwi.encuestas.utils.enums.exceptions.BadRequestException;
import com.riwi.encuestas.utils.enums.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository usersRepositoy;

    @Override
    public UserResp create(UserReq request) {
        UserEntity user = this.requestToEntity(request);
        return this.entityToResp(this.usersRepositoy.save(user));
    }

    @Override
    public UserResp get(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public UserResp update(UserReq request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<UserResp> getAll(int Page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    private UserResp entityToResp(UserEntity entity) {

        return UserResp.builder()
                .user_id(entity.getUser_id())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .surveys(entity.getSurveys())
                .build();
    }

    private UserEntity requestToEntity(UserReq request) {
        return UserEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .active(request.isActive())
                .build();
    }

    private UserEntity find(String id) {
        return this.usersRepositoy.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("servicio")));
    }
}
