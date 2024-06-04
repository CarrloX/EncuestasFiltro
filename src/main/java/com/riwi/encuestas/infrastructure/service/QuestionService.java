package com.riwi.encuestas.infrastructure.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.encuestas.api.dto.request.QuestionReq;
import com.riwi.encuestas.api.dto.response.BasicSurveyResp;
import com.riwi.encuestas.api.dto.response.QuestionResp;
import com.riwi.encuestas.domain.entity.QuestionEntity;
import com.riwi.encuestas.domain.entity.SurveyEntity;
import com.riwi.encuestas.domain.repositories.QuestionRepository;
import com.riwi.encuestas.domain.repositories.SurveyRespository;
import com.riwi.encuestas.infrastructure.abstract_services.IQuestionService;
import com.riwi.encuestas.utils.enums.exceptions.BadRequestException;
import com.riwi.encuestas.utils.enums.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {

    @Autowired
    private final QuestionRepository questionRepository;

    @Autowired
    private final SurveyRespository SurveyRespository;

    @Override
    public QuestionResp create(QuestionReq request) {
        SurveyEntity surveys = this.SurveyRespository.findById(request.getSurvey_id())
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("cuestionario")));

        QuestionEntity question = this.requestToEntity(request);

        question.setSurvey(surveys);
        return this.entityToResponse(this.questionRepository.save(question));
    }

    @Override
    public QuestionResp get(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public QuestionResp update(QuestionReq request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<QuestionResp> getAll(int Page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    private QuestionResp entityToResponse(QuestionEntity entity) {

        BasicSurveyResp survey = new BasicSurveyResp();
        BeanUtils.copyProperties(entity.getSurvey(), survey);

        return QuestionResp.builder()
                .question_id(entity.getQuestion_id())
                .text(entity.getText())
                .type(entity.getType())
                .active(entity.isActive())
                .survey(survey)
                .build();
    }

    private QuestionEntity requestToEntity(QuestionReq request) {

        SurveyEntity survey = this.SurveyRespository.findById(request.getSurvey_id())
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("curso")));

        return QuestionEntity.builder()
                .text(request.getText())
                .type(request.getType())
                .active(request.isActive())
                .survey(survey)
                .build();
    }

    private QuestionEntity find(String id) {
        return this.questionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("Servicio")));
    }
}
