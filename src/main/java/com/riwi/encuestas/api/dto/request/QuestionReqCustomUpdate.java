package com.riwi.encuestas.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionReqCustomUpdate {
    @NotBlank(message = "la pregunta es requerida")
    private String text;
    @NotBlank(message = "el id del cuestionario es requerido")
    private String survey_id;
}
