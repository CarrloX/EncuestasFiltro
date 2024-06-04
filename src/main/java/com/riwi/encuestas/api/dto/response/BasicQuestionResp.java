package com.riwi.encuestas.api.dto.response;

import com.riwi.encuestas.utils.enums.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasicQuestionResp {
    private String question_id;
    private String text;
    private Type type;
}
