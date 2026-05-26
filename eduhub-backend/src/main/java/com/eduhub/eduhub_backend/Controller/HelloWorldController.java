package com.eduhub.eduhub_backend.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
public class HelloWorldController {

    private final Environment environment;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String PORT;
    HelloWorldController(Environment environment)
    {
        this.environment=environment;
    }




    @GetMapping("helloWorld")
    public String HelloWorld()
    {
        return "Hello World";
    }
    @GetMapping("Home")
    public String HomePage()
    {
        return "Hi, Aarockya Rathish Raj A";
    }

    @GetMapping("/env")
    public String getEnvironment()
    {
        String port=environment.getProperty("server.port");
        return "App Name: "+appName+" Port: "+port+ "PORT: "+PORT;
    }

}
