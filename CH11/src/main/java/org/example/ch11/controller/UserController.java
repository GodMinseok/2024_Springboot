package org.example.ch11.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.ch11.User;
import org.example.ch11.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // 조건에 따라 사용자 조회
    // http://localhost:8080/users/condition?name=User01
    @GetMapping("/users/condition")
    public List<User> getUsersByCondition(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        return userService.getUsersByCondition(name, email);
    }

    // 다중 ID로 사용자 조회
    // http://localhost:8080/users/ids?ids=1,2
    @GetMapping("/users/ids")
    public List<User> getUsersByIds(@RequestParam List<Long> ids) {
        return userService.getUsersByIds(ids);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
