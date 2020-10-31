package com.zjp.dao;

import com.zjp.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> getAllUser();

    Integer add(User user);

    int update(User user);

    int delete(Integer id);
}
