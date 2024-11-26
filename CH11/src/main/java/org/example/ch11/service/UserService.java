package org.example.ch11.service;

import java.util.List;
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

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

    // 조건에 따라 사용자 필터링
    public List<User> getUsersByCondition(String name, String email) {
        return userMapper.findByCondition(name, email);
    }

    // 다중 ID로 사용자 조회
    public List<User> getUsersByIds(List<Long> ids) {
        return userMapper.findByIds(ids);
    }

}
