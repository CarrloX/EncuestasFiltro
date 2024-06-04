package com.riwi.encuestas.infrastructure.abstract_services;

import com.riwi.encuestas.api.dto.request.UserReq;
import com.riwi.encuestas.api.dto.response.UserResp;

public interface IUserService extends CrudService<UserReq,UserResp,String>{
    
}
