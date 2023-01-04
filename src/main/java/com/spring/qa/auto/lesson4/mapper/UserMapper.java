package com.spring.qa.auto.lesson4.mapper;

import com.spring.qa.auto.lesson2.controller.rest.example.dto.User;
import com.spring.qa.auto.lesson4.entity.UserEntity;

public interface UserMapper {

    UserEntity dtoToEntity(User userDto);

    User entityToDto(UserEntity userEntity);
}
