package com.zjp.dao;

import com.zjp.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    //查询所有学生的信息，包括老师的信息
    List<Student> getAllStudents ();

    List<Student> getAllStudents2 ();

    Student getStudentById (@Param("id") Integer id);

}
