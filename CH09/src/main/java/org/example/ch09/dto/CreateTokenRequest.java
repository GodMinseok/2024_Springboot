package org.example.ch09.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTokenRequest {

    private String refreshToken;
}
