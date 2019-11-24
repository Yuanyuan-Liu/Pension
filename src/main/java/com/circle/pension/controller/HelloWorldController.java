package com.circle.pension.controller;

import com.circle.pension.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class HelloWorldController {
    private HelloWorldService helloWorldService;

    @Autowired
    HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/say")
    public Object sayHello() {
        return helloWorldService.sayHello();
    }
}
