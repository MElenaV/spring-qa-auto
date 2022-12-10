package com.spring.qa.auto.lesson1.dependency.ioc;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Car {

    //private final Engine engine;

    //Field Injection
    @Autowired
    private Engine engine;

    /*
    //Constructor Injection
    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
     */

    /*
    //Setter Injection
    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
     */


}
