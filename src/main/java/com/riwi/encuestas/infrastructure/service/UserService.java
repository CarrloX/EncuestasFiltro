package com.riwi.encuestas.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.encuestas.api.dto.request.UserReq;
import com.riwi.encuestas.api.dto.response.UserResp;
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
        return this.entityToResp(this.find(id));
    }

    @Override
    public UserResp update(UserReq request, String id) {

        UserEntity userUpdate = this.requestToEntity(request);
        userUpdate.setUser_id(id);

        return this.entityToResp(this.usersRepositoy.save(userUpdate));
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<UserResp> getAll(int Page, int size) {
        if (Page < 0)
            Page = 0;

        PageRequest pagination = PageRequest.of(Page, size);

        return this.usersRepositoy.findAll(pagination)
                .map(user -> this.entityToResp(user));
    }

    private UserResp entityToResp(UserEntity entity) {

        return UserResp.builder()
                .user_id(entity.getUser_id())
                .name(entity.getName())
                .email(entity.getEmail())
                .active(entity.isActive())
                // .password(entity.getPassword())
                // .surveys(entity.getSurveys())
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
