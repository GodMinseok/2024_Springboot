package org.example.ch05.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTokenRequest {

    private String refreshToken;
}
