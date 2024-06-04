package com.riwi.encuestas.api.dto.response;

import java.util.List;

import com.riwi.encuestas.domain.entity.SurveyEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResp {
    private String user_id;
    private String name;
    private String email;
    private String password;
    private boolean active;
    private List<SurveyEntity> surveys;
}
