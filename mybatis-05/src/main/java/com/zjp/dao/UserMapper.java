package com.zjp.dao;

import com.zjp.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUserById(@Param("id") Integer id);

    int update(User user);
}
