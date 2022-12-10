package com.spring.qa.auto.lesson1.dependency.hardness.constructor;

import com.spring.qa.auto.lesson1.dependency.hardness.Engine;

public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public static void main(String[] args) {
        Car car = new Car(new Engine());
    }
}
