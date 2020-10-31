import com.zjp.config.MybatisConfig;
import com.zjp.dao.TeacherMapper;
import com.zjp.pojo.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void teacherTest(){
        SqlSession sqlSession = MybatisConfig.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void teacherTest2(){
        SqlSession sqlSession = MybatisConfig.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById2(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
