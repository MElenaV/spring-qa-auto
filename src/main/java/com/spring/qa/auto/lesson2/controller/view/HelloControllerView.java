package com.spring.qa.auto.lesson2.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloControllerView {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello() {
        return "hello";
    }
}
