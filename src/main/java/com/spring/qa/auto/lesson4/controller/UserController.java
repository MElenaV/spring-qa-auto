package com.spring.qa.auto.lesson4.controller;

import com.spring.qa.auto.lesson2.controller.rest.example.dto.User;
import com.spring.qa.auto.lesson4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-rest")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    void save(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping
    void update(@RequestBody User user) {
        userService.update(user);
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable Integer id) {
        userService.delete(id);
    }
}
