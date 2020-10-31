import com.zjp.config.MybatisConfig;
import com.zjp.dao.StudentMapper;
import com.zjp.dao.TeacherMapper;
import com.zjp.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.zjp.pojo.Teacher;

import java.util.Arrays;
import java.util.List;

public class MyTest {

    @Test
    public void teachTest(){
        SqlSession sqlSession = MybatisConfig.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void studentTest(){
        SqlSession sqlSession = MybatisConfig.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getAllStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void studentTest2(){
        SqlSession sqlSession = MybatisConfig.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getAllStudents2();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
