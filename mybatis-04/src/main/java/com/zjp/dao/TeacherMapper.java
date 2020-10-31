package com.zjp.dao;

import com.zjp.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    Teacher getTeacherById (@Param("id") Integer id);

    Teacher getTeacherById2 (@Param("id") Integer id);
}
