package dorm.room.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月14日 下午4:19:58
* 类说明 ：
*/
public interface RoomController {
	//获取所有room
	String getAllRomms (HttpServletRequest request, HttpServletResponse response);
	
	//根据查询条件获取room
	String getRoomsWithSerach (HttpServletRequest request, HttpServletResponse response);
	
	//添加
	String addRoom (HttpServletRequest request, HttpServletResponse response);
	
	//修改
	String updateRoom (HttpServletRequest request, HttpServletResponse response);
	
	//删除
	String deleteRoom (HttpServletRequest request, HttpServletResponse response);
}
