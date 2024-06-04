package com.riwi.encuestas.api.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyReq {
    private String title;
    private String description;
    private LocalDate creationDate;
    private boolean active;
    private String creator_id;
}
