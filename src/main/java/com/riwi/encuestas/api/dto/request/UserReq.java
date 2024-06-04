package com.riwi.encuestas.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {
    private String name;
    private String email;
    private boolean active;
    private String password;
}
