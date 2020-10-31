import com.zjp.config.MybatisConfig;
import com.zjp.dao.UserMapper;
import com.zjp.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void getOneTest(){
        SqlSession sqlSession = MybatisConfig.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);

        /*User userUpdate = new User();
        userUpdate.setId(6);
        userUpdate.setName("www1");
        userUpdate.setPwd("1234561");
        userMapper.update(userUpdate);*/

        sqlSession.clearCache();// 手动清理缓存

        User user1 = userMapper.getUserById(1);
        System.out.println(user1);

        System.out.println("================");

        System.out.println(user == user1);
        sqlSession.close();
    }


    //@Test
    public void updateTest(){
        SqlSession sqlSession = MybatisConfig.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(6);
        user.setName("www1");
        user.setPwd("1234561");

        userMapper.update(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void cache2Test(){
        SqlSession sqlSession1 = MybatisConfig.getSqlSession();
        SqlSession sqlSession2 = MybatisConfig.getSqlSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = userMapper1.getUserById(1);
        System.out.println(user1);
        sqlSession1.close();

        System.out.println("================");

        User user2 = userMapper2.getUserById(1);
        System.out.println(user2);
        System.out.println("================");

        System.out.println(user1 == user2);

        sqlSession2.close();
    }
}
