package com.riwi.encuestas.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.riwi.encuestas.api.dto.request.SurveyReq;
import com.riwi.encuestas.api.dto.response.BasicQuestionResp;
import com.riwi.encuestas.api.dto.response.SurveyResp;
import com.riwi.encuestas.api.dto.response.UserResp;
import com.riwi.encuestas.domain.entity.QuestionEntity;
import com.riwi.encuestas.domain.entity.SurveyEntity;
import com.riwi.encuestas.domain.entity.UserEntity;
import com.riwi.encuestas.domain.repositories.SurveyRespository;
import com.riwi.encuestas.domain.repositories.UserRepository;
import com.riwi.encuestas.infrastructure.abstract_services.ISurveyService;
import com.riwi.encuestas.utils.enums.exceptions.BadRequestException;
import com.riwi.encuestas.utils.enums.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SurveyService implements ISurveyService {

    @Autowired
    private final UserRepository usersRepositoy;

    @Autowired
    private final SurveyRespository SurveyRespository;

    @Override
    public SurveyResp create(SurveyReq request) {
        UserEntity creator = this.usersRepositoy.findById(request.getCreator_id())
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("creator")));

        // if (creator.isActive().equals(true)) {
        // throw new BadRequestException("No cumples el rol para ser instructor de este
        // curso");
        // }

        SurveyEntity survey = this.requestToEntity(request);

        survey.setCreator(creator);
        return this.entityToResponse(this.SurveyRespository.save(survey));
    }

    @Override
    public SurveyResp get(String id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public SurveyResp update(SurveyReq request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<SurveyResp> getAll(int Page, int size) {
        if (Page < 0)
            Page = 0;

        PageRequest pagination = PageRequest.of(Page, size);

        return this.SurveyRespository.findAll(pagination)
                .map(survey -> this.entityToResponse(survey));
    }

    private SurveyResp entityToResponse(SurveyEntity entity) {

        UserResp creator = new UserResp();
        BeanUtils.copyProperties(entity.getCreator(), creator);

        List<BasicQuestionResp> questionResp = new ArrayList<>();
        // si queremos que imprima una lista de otra entidad aunque este vacia hacemos
        // esta validacion
        if (entity.getQuestions() != null) {
            for (QuestionEntity question : entity.getQuestions()) {
                questionResp
                        .add(new BasicQuestionResp(question.getQuestion_id(), question.getText(), question.getType()));
            }
        }

        return SurveyResp.builder()
                .survey_id(entity.getSurvey_id())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .creationDate(entity.getCreationDate())
                .active(entity.isActive())
                .build();
    }

    private SurveyEntity requestToEntity(SurveyReq request) {

        UserEntity creator = this.usersRepositoy.findById(request.getCreator_id())
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("creator")));

        return SurveyEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .creationDate(request.getCreationDate())
                .active(request.isActive())
                .creator(creator)
                .build();
    }

    private SurveyEntity find(String id) {
        return this.SurveyRespository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("Servicio")));
    }
}
