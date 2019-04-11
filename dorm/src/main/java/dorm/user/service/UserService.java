package dorm.user.service;

import java.util.List;

import dorm.user.domain.pojo.UserBaseOrder;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月9日 下午2:01:07
* 类说明 ：service逻辑处理
*/
public interface UserService {
	//根据UserId获取User
	UserBaseOrder getUserByUserId (String userId);
	
	//获取所有User
	List<UserBaseOrder> getAllUsers ();
	
	//更新User
	Integer updateUser (UserBaseOrder userBaseOrder);
	
	//添加User
	Integer insertUser (UserBaseOrder userBaseOrder);
	
	//删除User
	boolean deleteUser (String userId);
	
	//根据userId或者name模糊查询
	List<UserBaseOrder> selectUserByUserIdOrName (String selectStr);
	
	//登陆判断
	UserBaseOrder loginUser (String userId, String password);
}
