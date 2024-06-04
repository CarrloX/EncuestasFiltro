package com.riwi.encuestas.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.encuestas.api.dto.request.QuestionReq;
import com.riwi.encuestas.api.dto.response.QuestionResp;
import com.riwi.encuestas.domain.repositories.QuestionRepository;
import com.riwi.encuestas.infrastructure.abstract_services.IQuestionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService{
    
        @Autowired
    private final QuestionRepository questionRepository;

        @Override
        public QuestionResp create(QuestionReq request) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'create'");
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
}
