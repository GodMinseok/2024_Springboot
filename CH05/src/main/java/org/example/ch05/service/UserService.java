package org.example.ch05.service;

import lombok.RequiredArgsConstructor;
import org.example.ch05.domain.User;
import org.example.ch05.dto.AddUserRequest;
import org.example.ch05.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest req) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User newUser = User.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword())) // 패스워드 암호화
                .build();
        return userRepository.save(newUser).getId();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }


}
