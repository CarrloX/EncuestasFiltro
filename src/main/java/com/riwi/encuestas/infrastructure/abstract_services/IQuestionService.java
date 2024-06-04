package com.riwi.encuestas.infrastructure.abstract_services;

import com.riwi.encuestas.api.dto.request.QuestionReq;
import com.riwi.encuestas.api.dto.response.QuestionResp;

public interface IQuestionService extends CrudService<QuestionReq,QuestionResp,String>{
    
}
