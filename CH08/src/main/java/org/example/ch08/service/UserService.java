package org.example.ch08.service;

import lombok.RequiredArgsConstructor;
import org.example.ch08.domain.User;
import org.example.ch08.dto.AddUserRequest;
import org.example.ch08.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest req) {
        User newUser = User.builder()
                .email(req.getEmail())
                .password(bCryptPasswordEncoder.encode(req.getPassword())) // 패스워드 암호화
                .build();
        return userRepository.save(newUser).getId();
    }

}
