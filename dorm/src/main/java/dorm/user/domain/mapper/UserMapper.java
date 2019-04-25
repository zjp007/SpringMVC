package dorm.user.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import dorm.user.domain.pojo.UserBaseOrder;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月9日 下午2:30:40
* 类说明 ：UserDao接口
*/
@MapperScan
public interface UserMapper {
	//根据userId查询
	UserBaseOrder selectByUserId (@Param(value="userId") String userId);
	
	//查询所有User
	List<UserBaseOrder> selectAllUser ();
	
	//修改User
	Integer updateUser (UserBaseOrder userBaseOrder);
	
	//删除User
	boolean deleteUser (@Param(value="userId") String userId);
	
	//增加User
	Integer insertUser (UserBaseOrder userBaseOrder);
	
	//查询
	List<UserBaseOrder> selectUsers (@Param(value="selectStr")String selectStr);
	
	//登陆判断
	UserBaseOrder loginUser (@Param(value="userId") String userId, @Param(value="password") String password);
}
