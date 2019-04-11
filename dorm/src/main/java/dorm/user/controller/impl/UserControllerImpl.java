package dorm.user.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
//import javax.json.JsonString;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import dorm.user.controller.UserController;
import dorm.user.domain.pojo.UserBaseOrder;
import dorm.user.service.UserService;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月9日 下午3:17:29
* 类说明 ：处理传来的URL
*/
@Controller
@RequestMapping("/user")
@ResponseBody
public class UserControllerImpl implements UserController{
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	public UserService getUserService () {
		return userService;
	}
	
	public void setUserService (UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/returnTest",method=RequestMethod.GET)
	public String returnTest(@RequestParam String msg) {
		String msgString = "{\"msg\":" + msg + "}";
		return msgString;
	}
	
	//根据UserId获取User
	@Override
	@RequestMapping(value="/getUser", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String getUserByUserId(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		UserBaseOrder user = this.userService.getUserByUserId(userId);
		return JSON.toJSONString(user);
	}
	
	//获取所有User
	@Override
	@RequestMapping(value="/getAllUser",method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String getAllUsers(HttpServletRequest request, HttpServletResponse response) {
		List<UserBaseOrder> listUser = new ArrayList<UserBaseOrder>();
		listUser = this.userService.getAllUsers();
		JSONArray jsonArray = new JSONArray();
		for (UserBaseOrder user : listUser)
		{
			jsonArray.add(user);
		}
		String String= JSON.toJSONString(jsonArray);
		return String;
	}
	
	//更新User
	@Override
	@RequestMapping(value="/updateUser",method=RequestMethod.GET)
	public String updateUser(HttpServletRequest request, HttpServletResponse response) {
		String userString = request.getParameter("userBaseOrder");
		UserBaseOrder user = JSON.parseObject(userString, UserBaseOrder.class);
		String updateStatus = "{\"updateStatus\": " + this.userService.updateUser(user) + "}";
		return updateStatus;
	}
	
	//添加User
	@Override
	@RequestMapping(value="/insertUser",method=RequestMethod.GET)
	public String insertUser(HttpServletRequest request, HttpServletResponse response) {
		String userString = request.getParameter("userBaseOrder");
		UserBaseOrder user = JSON.parseObject(userString, UserBaseOrder.class);
		String insertStatus = "{\"insertStatus\": " + this.userService.insertUser(user) + "}";
		return insertStatus;
	}
	
	//删除User
	@Override
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public String deleteUser(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String deleteStr = "{\"deleteStatus\": " + this.userService.deleteUser(userId) + "}";
		return deleteStr;
	}
	
	//根据userId或者name模糊查询
	@Override
	@RequestMapping(value="/selectUser",method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String selectUserByUserIdOrName(HttpServletRequest request, HttpServletResponse response) {
		String selectStr = request.getParameter("selectStr");
		List<UserBaseOrder> listUser = new ArrayList<UserBaseOrder>();
		listUser = this.userService.selectUserByUserIdOrName(selectStr);
		JSONArray jsonArray = new JSONArray();
		for (UserBaseOrder user : listUser)
		{
			jsonArray.add(user);
		}
		String String= JSON.toJSONString(jsonArray);
		return String;
	}
	
	//登陆判断
	@Override
	@RequestMapping(value="/login",method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String loginUser(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		boolean loginFlag = false;
		if (this.userService.loginUser(userId, password)!=null) {
			loginFlag = true;
		}
		String loginStr = "{\"login\": " + loginFlag + "}";
		return loginStr;
	}

}
