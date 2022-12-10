package com.spring.qa.auto.lesson1.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.qa.auto.lesson1.beans.component.Juggler;
import com.spring.qa.auto.lesson1.beans.config.BeanConfiguration;

public class BeanContextGetter {

    public static void main(String[] args) {
        ApplicationContext context1 =
                new AnnotationConfigApplicationContext(BeanConfiguration.class);

        Juggler juggler1 = (Juggler) context1.getBean("duke");

        juggler1.setName("Duke");

        ApplicationContext context2 =
                new AnnotationConfigApplicationContext("ru.geekbrains.auto.qa.autoqa.lesson1.beans.component");

        Juggler juggler2 = (Juggler) context2.getBean("juggler");

        juggler2.setName("Alex");

        System.out.println(juggler1 + " " + juggler2);


    }
}
