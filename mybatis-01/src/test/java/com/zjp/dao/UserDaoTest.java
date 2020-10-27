package com.zjp.dao;

import com.zjp.config.MybatisConfig;
import com.zjp.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        // 1.获取SqlSession对象
        SqlSession sqlSession = MybatisConfig.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 2.执行SQL
        userDao.getAllUser();
        List<User> userList = MybatisConfig.getSqlSession().getMapper(UserDao.class).getAllUser();
        Arrays.asList(userList).forEach(s-> System.out.println(s));

        // 关闭SqlSession
        sqlSession.close();
    }
}
