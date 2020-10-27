package com.kuang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {

    @RequestMapping("/jackson/t1")
    public String test1() throws JsonProcessingException {

        User user = new User();
        user.setId("1");
        user.setName("赵建平");
        user.setAge(21);
        user.setSex("男");
        user.setBornDate(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(user);

        return result;
    }
}
