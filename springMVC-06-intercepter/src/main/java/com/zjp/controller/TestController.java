package com.zjp.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @RequestMapping("/test/t1")
    public String test1(){
        System.out.println("zjp");
        return "zjp";
    }

    @RequestMapping("/test/t2")
    public String test2(HttpServletRequest request){
        request.getSession().setAttribute("userId","admin");
        System.out.println("login");
        return "login";
    }


    @RequestMapping("/test/t3")
    public String test3(HttpServletRequest request){
        request.getSession().removeAttribute("userId");
        System.out.println("out");
        return "out";
    }
}
