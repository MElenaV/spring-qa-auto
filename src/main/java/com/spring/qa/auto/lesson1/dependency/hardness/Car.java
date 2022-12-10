package com.spring.qa.auto.lesson1.dependency.hardness;

import java.lang.reflect.Field;

public class Car {

    private Engine engine;

    public Car() {
        engine = new Engine();
    }

}
