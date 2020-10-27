package com.zjp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AJAXController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello faker!";
    }
}
