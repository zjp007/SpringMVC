package dorm.room.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import dorm.room.controller.RoomController;
import dorm.room.domain.pojo.RoomBaseOrder;
import dorm.room.service.RoomService;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月14日 下午4:26:25
* 类说明 ：
*/
@Controller
@RequestMapping("/room")
@ResponseBody
public class RoomControllerImpl implements RoomController{
	
	@Resource(name="roomServiceImpl")
	private RoomService roomService;
	
	public RoomService getRoomService() {
		return roomService;
	}
	
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	
	//查询所有room信息
	@Override
	@RequestMapping(value="/getALLRooms", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String getAllRomms(HttpServletRequest request, HttpServletResponse response) {
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
		List<RoomBaseOrder> listRoom = roomService.getAllRooms();
		
		JSONArray jsonArray = new JSONArray();
		if (start!=null&&end!=null) {
			for (int i = start;i<(end<listRoom.size() ? end : listRoom.size());i++)
			{
				jsonArray.add(listRoom.get(i));
			}
		}else {
			for (RoomBaseOrder room : listRoom)
			{
				jsonArray.add(room);
			}
		}
		Integer total = listRoom.size();
		Integer totalPage = (total % limit ==0) ? (total / limit) : (total / limit) + 1;
		String rows= JSON.toJSONString(jsonArray);
		String data = "{ \"total\": " + total + ", \"totalPage\": " + totalPage + ", \"rows\": " + rows + "}";
		String params = "{\"data\":" +  data + "}";
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		System.out.println("getRooms: " + params);
		return params;
	}
	
	//带查询参数 查询所有room信息
	@Override
	@RequestMapping(value="/getRoomsWithSearch", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String getRoomsWithSerach(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> serachStringMap = new HashMap<String, String> ();
		String roomIdOrName = request.getParameter("roomIdOrName")==null ? null : request.getParameter("roomIdOrName");
		String academy = request.getParameter("academy")==null ? null : request.getParameter("academy");
		String build = request.getParameter("build")==null ? null : request.getParameter("build");
		String school = request.getParameter("school")==null ? null : request.getParameter("school");
		String floor = request.getParameter("floor")==null ? null : request.getParameter("floor");
		serachStringMap.put("roomIdOrName", roomIdOrName);
		serachStringMap.put("academy", academy);
		serachStringMap.put("build", build);
		serachStringMap.put("school", school);
		serachStringMap.put("floor", floor);
		
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
		
		List<RoomBaseOrder> roomList = roomService.getRoomsWithSerach(serachStringMap);
		
		
		JSONArray jsonArray = new JSONArray();
		if (start!=null&&end!=null) {
			for (int i = start;i<(end<roomList.size() ? end : roomList.size());i++)
			{
				jsonArray.add(roomList.get(i));
			}
		}else {
			for (RoomBaseOrder room : roomList)
			{
				jsonArray.add(room);
			}
		}
		Integer total = roomList.size();
		Integer totalPage = (total % limit ==0) ? (total / limit) : (total / limit) + 1;
		String rows= JSON.toJSONString(jsonArray);
		String data = "{ \"total\": " + total + ", \"totalPage\": " + totalPage + ", \"rows\": " + rows + "}";
		String params = "{\"data\":" +  data + "}";
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		System.out.println("getRooms: " + params);
		return params;
	}
	
	//添加room
	@Override
	@RequestMapping(value="/addRoom", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String addRoom(HttpServletRequest request, HttpServletResponse response) {
		String roomBaseOrder = request.getParameter("roomBaseOrder");
		RoomBaseOrder room = JSON.parseObject(roomBaseOrder,RoomBaseOrder.class);
		Integer addStatus = roomService.addRoom(room);
		String params = "{ \"addStatus\": " + addStatus + "}";
		System.out.println("addStatus : " + addStatus);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return params;
	}
	
	//更新room
	@Override
	@RequestMapping(value="/updateRoom", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String updateRoom(HttpServletRequest request, HttpServletResponse response) {
		String roomBaseOrder = request.getParameter("roomBaseOrder");
		RoomBaseOrder room = JSON.parseObject(roomBaseOrder,RoomBaseOrder.class);
		Integer updateStatus = roomService.updateRoom(room);
		String params = "{ \"updateStatus\": " + updateStatus + "}";
		System.out.println("updateStatus : " + updateStatus);
		return params;
	}
	
	//删除
	@Override
	@RequestMapping(value="/deleteRoom", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String deleteRoom(HttpServletRequest request, HttpServletResponse response) {
		String roomId = request.getParameter("roomId");
		Boolean deleteStatus = roomService.deleteRoom(roomId);
		String params = "{ \"deleteStatus\": " + deleteStatus + "}";
		System.out.println("deleteStatus : " + deleteStatus);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return params;
	}

}
