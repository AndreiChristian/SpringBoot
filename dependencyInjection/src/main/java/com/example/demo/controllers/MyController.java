package com.example.demo.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHello(){
        System.out.println("I am a controller");

        return "Hello everyone";
    }

}
