package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("msg", "helloSpringMVC");
        return "hello";
    }

    @RequestMapping("/jsp")
    public String sayJsp(Model model, HttpServletRequest request, HttpServletResponse response){
        String jspName = request.getParameter("name");
        model.addAttribute("msg", "jspName");
        return jspName;
    }

    @ResponseBody
    @RequestMapping("/str")
    public String getStr(HttpServletRequest request, HttpServletResponse response){
        String jspName = request.getParameter("name");
        return jspName;
    }
}
