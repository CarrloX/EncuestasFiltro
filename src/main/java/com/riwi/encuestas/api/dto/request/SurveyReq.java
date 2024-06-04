package com.riwi.encuestas.api.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyReq {
        @NotBlank(message = "el titulo del cuestionario es requerido")
    private String title;
    @NotBlank(message = "la descripcion es requerida")
    private String description;
    @NotBlank(message = "la fecha de creacion del cuestionario es requerido")
    private LocalDate creationDate;
    @NotBlank(message = "debe especificar si el usuario esta activo o no")
    private boolean active;
    @NotBlank(message = "el id del creador es requerida")
    private String creator_id;
}
