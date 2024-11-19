package org.example.ch05.controller;


import lombok.RequiredArgsConstructor;
import org.example.ch05.dto.CreateTokenRequest;
import org.example.ch05.dto.CreateTokenResponse;
import org.example.ch05.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateTokenResponse> createNewAccessToken(@RequestBody CreateTokenRequest req) {

        try {
            String newToken = tokenService.createNewAccessToken(req.getRefreshToken());
            return ResponseEntity.status(HttpStatus.CREATED).body(new CreateTokenResponse(newToken));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}