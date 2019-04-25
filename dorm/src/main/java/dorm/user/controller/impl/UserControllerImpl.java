package dorm.user.controller.impl;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.net.*;
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
	@RequestMapping(value="/getUser", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String getUserByUserId(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		System.out.println("userId: " + userId);
		UserBaseOrder user = this.userService.getUserByUserId(userId);
		System.out.println("getUser: " + user);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return JSON.toJSONString(user);
	}
	
	//获取所有User
	//, produces = "text/plain;charset=utf-8"
	@Override
	@RequestMapping(value="/getAllUser",method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		URLConnection.setDefaultRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		//页面大小
		Integer limit = request.getParameter("limit")==null ? null : Integer.parseInt(request.getParameter("limit"));
		//页码
		Integer offset = request.getParameter("offset")==null ? null : Integer.parseInt(request.getParameter("offset"));
		Integer start = null;
		Integer end = null;
		if(limit!=null&&offset!=null) {
			start = limit * offset;
			end = start + limit;
		}
		List<UserBaseOrder> listUser = new ArrayList<UserBaseOrder>();
		listUser = this.userService.getAllUsers();
		JSONArray jsonArray = new JSONArray();
		if (start!=null&&end!=null) {
			for (int i = start;i<(end<listUser.size() ? end : listUser.size());i++)
			{
				jsonArray.add(listUser.get(i));
			}
		}else {
			for (UserBaseOrder user : listUser)
			{
				jsonArray.add(user);
			}
		}
		Integer total = listUser.size();
		Integer totalPage = (total % limit ==0) ? (total / limit) : (total / limit) + 1;
		String rows= JSON.toJSONString(jsonArray);
		String data = "{ \"total\": " + total + ", \"totalPage\": " + totalPage + ", \"rows\": " + rows + "}";
		String params = "{\"data\":" +  data + "}";

		response.setHeader("Access-Control-Allow-Origin", "*");

		System.out.println("getAllUser: " + params);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return params;
	}
	
	//更新User
	@Override
	@RequestMapping(value="/updateUser",method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String updateUser(HttpServletRequest request, HttpServletResponse response) {
		URLConnection.setDefaultRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		String userString = null;
		
		//传入值乱码问题解决
		try {
			request.setCharacterEncoding("utf-8");
			userString =new String(request.getParameter("userBaseOrder").getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		UserBaseOrder user = JSON.parseObject(userString, UserBaseOrder.class);
		String updateStatus = "{\"updateStatus\": " + this.userService.updateUser(user) + "}";
		System.out.println("updateUser: " + userString);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return updateStatus;
	}
	
	//添加User
	@Override
	@RequestMapping(value="/insertUser",method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String insertUser(HttpServletRequest request, HttpServletResponse response) {
		URLConnection.setDefaultRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		String userString = null;
		
		//传入值乱码问题解决
		try {
			request.setCharacterEncoding("utf-8");
			userString =new String(request.getParameter("userBaseOrder").getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		System.out.println("insertUser : " + userString);
		UserBaseOrder user = JSON.parseObject(userString, UserBaseOrder.class);
		String insertStatus = "{\"insertStatus\": " + this.userService.insertUser(user) + "}";
		System.out.println("insertUser: " + userString);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return insertStatus;
	}
	
	//删除User
	@Override
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String deleteUser(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String deleteStr = "{\"deleteStatus\": " + this.userService.deleteUser(userId) + "}";
		System.out.println("deleteUser: " + userId);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return deleteStr;
	}
	
	//根据userId或者name模糊查询
	//, produces = "text/plain;charset=utf-8"
	@SuppressWarnings("deprecation")
	@Override
	@RequestMapping(value="/selectUser",method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String selectUsers (HttpServletRequest request, HttpServletResponse response) {
		URLConnection.setDefaultRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		String selectStr = "";
		selectStr = request.getParameter("selectStr");
		//传入值乱码问题解决
//		try {
//			request.setCharacterEncoding("utf-8");
//			selectStr =new String(request.getParameter("selectStr").getBytes("iso8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
		//String selectStr = request.getParameter("selectStr") == null ? null : request.getParameter("selectStr");
		System.out.println("selectStr: "+selectStr);
		System.out.println("request.getParameter('selectStr'): " + request.getParameter("selectStr"));
		//页面大小
		Integer limit = request.getParameter("limit")==null ? 10 : Integer.parseInt(request.getParameter("limit"));
		//页码
		Integer offset = request.getParameter("offset")==null ? 0 : Integer.parseInt(request.getParameter("offset"));
		Integer start = null;
		Integer end = null;
		if(limit!=null&&offset!=null) {
			start = limit * offset;
			end = start + limit;
		}
		List<UserBaseOrder> listUser = new ArrayList<UserBaseOrder>();
		listUser = this.userService.selectUsers(selectStr);
		JSONArray jsonArray = new JSONArray();
		if (start!=null&&end!=null) {
			for (int i = start;i<(end<listUser.size() ? end : listUser.size());i++)
			{
				jsonArray.add(listUser.get(i));
			}
		}else {
			for (UserBaseOrder user : listUser)
			{
				jsonArray.add(user);
			}
		}
		Integer total = listUser.size();
		Integer totalPage = (total % limit ==0) ? (total / limit) : (total / limit) + 1;
		String rows= JSON.toJSONString(jsonArray);
		String data = "{ \"total\": " + total + ", \"totalPage\": " + totalPage + ", \"rows\": " + rows + "}";
		String params = "{\"data\":" +  data + "}";
		//String callBackStr = callback + "(" + params +  ")";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		//response.getWriter().write(callBackStr);
		System.out.println("selectUser: " + params);
		return params;
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
		System.out.println("userId: " + userId + "password :" + password);
		return loginStr;
	}

}
