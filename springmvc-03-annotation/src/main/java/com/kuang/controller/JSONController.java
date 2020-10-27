package com.kuang.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController = @Controller + @ResponseBody
public class JSONController {

    @ResponseBody
    @RequestMapping(value = "/json/test1", produces = "application/json;charset=UTF-8") //fastjson 解决乱码
    public String getJsonTest1(){
        JSONObject object = new JSONObject();
        object.put("id","1");
        object.put("name","赵建平");
        object.put("age",21);
        return object.toString();
    }
}
