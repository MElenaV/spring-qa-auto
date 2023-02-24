package com.spring.qa.auto.lesson7.util;

import lombok.SneakyThrows;

public class Pause {

    @SneakyThrows
    public static void pause(Integer seconds) {
        Thread.sleep(seconds * 1000);
    }
}
