package org.example.ch09.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTokenRequest {

    private String refreshToken;
}
