package org.example.ch09.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch09.dto.CreateTokenRequest;
import org.example.ch09.service.TokenService;
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
    public ResponseEntity<CreateTokenRequest> createNewAccessToken(@RequestBody CreateTokenRequest request) {
        String newToken = tokenService.creteNewAccessToekn(request.getRefreshToken());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateTokenRequest(newToken));
    }
}
