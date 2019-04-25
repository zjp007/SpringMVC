package dorm.user.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

//import javax.json.JsonString;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import dorm.user.domain.pojo.UserBaseOrder;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月9日 下午2:01:42
* 类说明 ：
*/
public interface UserController {
	//根据UserId获取User
	String getUserByUserId (HttpServletRequest request, HttpServletResponse response);
	
	//获取所有User
	String getAllUsers (HttpServletRequest request, HttpServletResponse response) throws IOException;
		
	//更新User
	String updateUser (HttpServletRequest request, HttpServletResponse response);
		
	//添加User
	String insertUser (HttpServletRequest request, HttpServletResponse response);
		
	//删除User
	String deleteUser (HttpServletRequest request, HttpServletResponse response);
	
	//查询
	String selectUsers (HttpServletRequest request, HttpServletResponse response);
	
	//登陆判断
	String loginUser (HttpServletRequest request, HttpServletResponse response);
}
