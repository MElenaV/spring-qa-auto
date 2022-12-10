package com.spring.qa.auto.lesson1.beans.component;

import org.springframework.stereotype.Component;

@Component
public class Juggler {

    private String name;
    private String secondName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    //logic code
}
