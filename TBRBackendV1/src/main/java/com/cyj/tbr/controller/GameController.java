package com.cyj.tbr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

    @GetMapping("/hello")
    @ResponseBody
    public String HelloWorld() {
        System.out.println("Hello World");
        return "Hello World";
    }

}
