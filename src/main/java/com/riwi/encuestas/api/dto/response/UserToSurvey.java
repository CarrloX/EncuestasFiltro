package com.riwi.encuestas.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserToSurvey {
    private String survey_id;
    private String title;
    private String description;
    private UserResp creator_id;
}
