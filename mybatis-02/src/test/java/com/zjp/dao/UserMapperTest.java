package com.zjp.dao;

import com.zjp.config.MybatisConfig;
import com.zjp.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getAll(){
        // 1.获取SqlSession对象
        SqlSession sqlSession = MybatisConfig.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 2.执行SQL
        userMapper.getAllUser();
        List<User> userList = MybatisConfig.getSqlSession().getMapper(UserMapper.class).getAllUser();
        Arrays.asList(userList).forEach(s-> System.out.println(s));

        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void add(){
        User user = new User();
        user.setName("qqq");
        user.setPwd("Qqq123456");

        SqlSession sqlSession = MybatisConfig.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.add(user);
        if(result > 0){
            System.out.println("插入数据成功！");
            System.out.println("数据：" + user);
            System.out.println(" result : " + result);
        }
        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void log4jTest(){
        try {
            getAll();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }finally {
            logger.error("没有问题");
        }
    }
}
