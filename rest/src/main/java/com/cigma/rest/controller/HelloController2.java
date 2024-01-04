package com.cigma.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {
    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/name")
    public String name() {
        return name;
    }

    @RequestMapping(value = "/port")
    public String port() {
        return port;
    }
}