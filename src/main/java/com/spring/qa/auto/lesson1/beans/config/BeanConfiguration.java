package com.spring.qa.auto.lesson1.beans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.spring.qa.auto.lesson1.beans.component.Juggler;

@Configuration
@ComponentScan("ru.geekbrains.auto.qa.autoqa.lesson1.beans")
public class BeanConfiguration {

    @Bean(name = "duke")
    Juggler juggler() {
        return new Juggler();
    }


}
