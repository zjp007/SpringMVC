package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {

    @RequestMapping(value = "/test/{a}/{b}", method = RequestMethod.GET)
    public String getName(Model model, @PathVariable String a, @PathVariable String b){
        String result = a + b;
        model.addAttribute("msg", "a = " + a + "</br> b = " + b);
        return "hello";
    }

    // 重定向 地址会发生变化，变成return的值
    @GetMapping("/test/redirectOne")
    public String testOne(){
        return "redirect:/index.jsp";
    }

    @GetMapping("/test/redirectTwo")
    public String testTwo(){
        return "redirect:/test/aaa/bbb";
    }

    //转发 (默认) 地址不会发生变化
    @GetMapping("/test/redirectThree")
    public String testThree(){
        return "forward:/WEB-INF/jsp/hello.jsp";
    }

    @GetMapping("/test/redirectFour")
    public String testFour(){
        return "forward:/test/aaa/bbb";
    }
}
