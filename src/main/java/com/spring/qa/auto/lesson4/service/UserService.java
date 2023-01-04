package com.spring.qa.auto.lesson4.service;

import com.spring.qa.auto.lesson2.controller.rest.example.dto.User;

public interface UserService {

    void save(User userDto);

    void update(User userDto);

    User getById(Integer id);

    void delete(Integer id);
}
