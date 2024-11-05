package org.example.ch09.service;

import lombok.RequiredArgsConstructor;
import org.example.ch09.domain.User;
import org.example.ch09.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Unexpected User"));
    }
}
