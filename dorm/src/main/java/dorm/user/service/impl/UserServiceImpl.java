package dorm.user.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dorm.user.domain.mapper.UserMapper;
import dorm.user.domain.pojo.UserBaseOrder;
import dorm.user.service.UserService;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月9日 下午3:13:17
* 类说明 ：
*/
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	//根据UserId获取User
	@Override
	public UserBaseOrder getUserByUserId(String userId) {
		return this.userMapper.selectUser(userId);
	}
	
	//获取所有User
	@Override
	public List<UserBaseOrder> getAllUsers() {
		
		return this.userMapper.selectAllUser();
	}
	
	//更新User
	@Override
	public Integer updateUser(UserBaseOrder userBaseOrder) {
		
		return this.userMapper.updateUser(userBaseOrder);
	}
	
	//添加User
	@Override
	public Integer insertUser(UserBaseOrder userBaseOrder) {
		
		return this.userMapper.insertUser(userBaseOrder);
	}
	
	//删除User
	@Override
	public boolean deleteUser(String userId) {
		
		return this.userMapper.deleteUser(userId);
	}
	
	//根据userId或者name模糊查询
	@Override
	public List<UserBaseOrder> selectUserByUserIdOrName(String selectStr) {
		
		return this.userMapper.selectUserByUserIdOrName(selectStr);
	}
	
	//登陆判断
	@Override
	public UserBaseOrder loginUser(String userId, String password) {
		
		return this.userMapper.loginUser(userId, password);
	}

}
