package com.spring.qa.auto.lesson4.user.unit;


import com.spring.qa.auto.lesson2.controller.rest.example.dto.User;
import com.spring.qa.auto.lesson4.entity.UserEntity;
import com.spring.qa.auto.lesson4.mapper.UserMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserMapperWrongUnitTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void convertEntityToDtoTest() {
        //pre-condition
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(50);
        userEntity.setFirstName("First Name");
        userEntity.setSecondName("Second Name");
        userEntity.setId(10);

        //step
        User user = userMapper.entityToDto(userEntity);

        //assert
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(user.getId()).isEqualTo(userEntity.getId());
            s.assertThat(user.getFirstName()).isEqualTo(userEntity.getFirstName());
            s.assertThat(user.getSecondName()).isEqualTo(userEntity.getSecondName());
            s.assertThat(user.getAge()).isEqualTo(userEntity.getAge());
        });
    }

    @Test
    void convertDtoToEntityTest() {
        //pre-condition
        User user = new User();
        user.setAge(50);
        user.setFirstName("First Name");
        user.setSecondName("Second Name");

        //step
        UserEntity userEntity = userMapper.dtoToEntity(user);

        //assert
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(userEntity.getFirstName()).isEqualTo(user.getFirstName());
            s.assertThat(userEntity.getSecondName()).isEqualTo(user.getSecondName());
            s.assertThat(userEntity.getAge()).isEqualTo(user.getAge());
        });
    }
}
