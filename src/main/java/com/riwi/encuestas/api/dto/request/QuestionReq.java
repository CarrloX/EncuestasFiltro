package com.riwi.encuestas.api.dto.request;

import com.riwi.encuestas.utils.enums.Type;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionReq {
    @NotBlank(message = "la pregunta es requerida")
    private String text;
    @NotBlank(message = "el tipo de pregunta si es abierta o cerrada es requerida")
    private Type type;
    @NotBlank(message = "debe especificar si la pregunta es afirmativa o negativa")
    private boolean active;
    @NotBlank(message = "el id del cuestionario es requerido")
    private String survey_id;
}
