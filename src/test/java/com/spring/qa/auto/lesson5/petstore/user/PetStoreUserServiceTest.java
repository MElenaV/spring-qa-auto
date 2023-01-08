package com.spring.qa.auto.lesson5.petstore.user;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.spring.qa.auto.lesson5.petstore.config.PetStoreTestConfig;
import com.spring.qa.auto.lesson5.restassured.petstore.EndPoints;
import com.spring.qa.auto.lesson5.restassured.petstore.dto.PetStoreUserDto;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PetStoreTestConfig.class)
@TestPropertySource(locations = "/application.properties")
public class PetStoreUserServiceTest {

    @Autowired
    private RequestSpecification requestSpecification;

    @Test
    void saveUserAndGetByUserNameTest() {

        //pre-condition - create user
        PetStoreUserDto userDto = PetStoreUserDto.builder()
                .firstName("firstName")
                .id(100)
                .lastName("lastName")
                .username("userName")
                .email("email@email.com")
                .password("qwerty")
                .phone("phone")
                .userStatus(5)
                .build();

        // step 1 - post user
        requestSpecification
                .body(userDto)
                .post(EndPoints.USER.getUrl())
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.OK.value());

        // step - 2 get user by username
        PetStoreUserDto userFromService = requestSpecification
                .get(EndPoints.USER.getUrl() + "/" + userDto.getUsername())
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(PetStoreUserDto.class);

        //assert response
        Assertions.assertThat(userFromService).isEqualTo(userDto);
    }

    @Test
    void deleteUserTest() {

        //pre-condition - create user
        PetStoreUserDto userDto = PetStoreUserDto.builder()
                .firstName("firstName")
                .id(200)
                .lastName("lastName")
                .username("userDelete")
                .email("email@email.com")
                .password("qwerty")
                .phone("phone")
                .userStatus(5)
                .build();


        //post user
        requestSpecification
                .body(userDto)
                .post(EndPoints.USER.getUrl())
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.OK.value());

        //delete user by username
        requestSpecification
                .delete(EndPoints.USER.getUrl() + "/" + userDto.getUsername())
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.OK.value());


        //get user again and assert that response code is 404
        requestSpecification
                .get(EndPoints.USER.getUrl() + "/" + userDto.getUsername())
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.NOT_FOUND.value());

    }

    @Test
    void updateUserTest() {

        //pre-condition - create user
        PetStoreUserDto userDto = PetStoreUserDto.builder()
                .firstName("firstName")
                .id(201)
                .lastName("lastName")
                .username("userCreate")
                .email("email@email.com")
                .password("qwerty")
                .phone("phone")
                .userStatus(5)
                .build();
        //post user
        requestSpecification
                .body(userDto)
                .post(EndPoints.USER.getUrl())
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.OK.value());

        PetStoreUserDto userDtoNew = PetStoreUserDto.builder()
                .firstName("firstName2")
                .id(userDto.getId())
                .lastName("lastName2")
                .username("userUpdate")
                .email("email2@email.com")
                .password("qwerty2")
                .phone("phone2")
                .userStatus(5)
                .build();

        //put user
        requestSpecification
                .body(userDtoNew)
                .put(EndPoints.USER.getUrl() + "/" + userDtoNew.getUsername())
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value());

        PetStoreUserDto userFromService = requestSpecification
                .get(EndPoints.USER.getUrl() + "/" + userDtoNew.getUsername())
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(PetStoreUserDto.class);

        //assert response
        Assertions.assertThat(userFromService).isEqualTo(userDtoNew);
    }
}
