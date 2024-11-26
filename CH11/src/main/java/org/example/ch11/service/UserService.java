package org.example.ch11.service;

import lombok.RequiredArgsConstructor;
import org.example.ch11.User;
import org.example.ch11.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User getUserById(Long id) {
        return userMapper.findById(id);
    }

}