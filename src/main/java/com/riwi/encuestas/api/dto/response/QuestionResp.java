package com.riwi.encuestas.api.dto.response;

import java.util.List;

import com.riwi.encuestas.domain.entity.OptionQuestion;
import com.riwi.encuestas.utils.enums.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResp {
    private String question_id;
    private String text;
    private Type type;
    private boolean active;
    private BasicSurveyResp survey;
    private List<OptionQuestion> optionQuestions;
}
