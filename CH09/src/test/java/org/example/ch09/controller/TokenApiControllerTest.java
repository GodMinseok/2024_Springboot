package org.example.ch09.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ch09.JwtProperties;
import org.example.ch09.config.JwtFactory;
import org.example.ch09.domain.RefreshToken;
import org.example.ch09.domain.User;
import org.example.ch09.dto.CreateTokenRequest;
import org.example.ch09.repository.RefreshTokenRepository;
import org.example.ch09.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TokenApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @BeforeEach
    protected void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        userRepository.deleteAll();
    }

    @DisplayName("createNewToken : 새로운 엑세스 토큰을 발급한다." )
    @Test
    public void createNewToken() throws Exception {
        //given
        final String url = "/api/token";

        // 신규 사용자 등록
        User user = User.builder()
                .email("test@test.com")
                .password("test")
                .build();
        User savedUser = userRepository.save(user);

        // refreshToken 발급
        JwtFactory jwtFactory = JwtFactory.builder()
                .subject(savedUser.getEmail())
                .claims(Map.of("id", savedUser.getId()))
                .build();
        String refreshToken = jwtFactory.createToken(jwtProperties);
        refreshTokenRepository.save(new RefreshToken(savedUser.getId(), refreshToken));

        // CreateTokenRequest 생성
        CreateTokenRequest createTokenRequest = new CreateTokenRequest();
        createTokenRequest.setRefreshToken(refreshToken);

        final String requestBody = objectMapper.writeValueAsString(createTokenRequest);
        System.out.println(requestBody);

        //when
        ResultActions resultActions = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));
        //then
        // -- status code == 201
        // -- accessToken
        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.accessToken").isNotEmpty());
    }
}