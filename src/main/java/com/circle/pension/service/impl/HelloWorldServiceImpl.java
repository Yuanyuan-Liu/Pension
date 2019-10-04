package com.circle.pension.service.impl;

import com.circle.pension.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    /**
     *
     */
    @Override
    public Object sayHello() {
        return "Hello World!";
    }
}
