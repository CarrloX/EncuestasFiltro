package com.riwi.encuestas.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasicSurveyResp {
    private String survey_id;
    private String title;
    private String description;
    private LocalDate creationDate;
    private boolean active;
    private UserResp creator;
}
