package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EncodingController {

    //@ResponseBody
    @RequestMapping("e/t1")
    public String test1(Model model, @RequestParam("name") String name){
        System.out.println("name : " + name);
        model.addAttribute("msg",name);
        return "hello";
    }
}
