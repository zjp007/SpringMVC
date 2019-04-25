package dorm.room.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dorm.room.domain.mapper.RoomMapper;
import dorm.room.domain.pojo.RoomBaseOrder;
import dorm.room.service.RoomService;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月14日 下午4:22:05
* 类说明 ：
*/
@Service("roomServiceImpl")
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomMapper roomMapper;
	
	@Override
	//获取所有宿舍信息
	public List<RoomBaseOrder> getAllRooms() {
		return roomMapper.selectALLRooms();
	}

	@Override
	public List<RoomBaseOrder> getRoomsWithSerach(Map<String, String> roomSerachMap) {
		String roomIdOrName = roomSerachMap.get("roomIdOrName");
		String academy = roomSerachMap.get("academy");
		String build = roomSerachMap.get("build");
		String school = roomSerachMap.get("school");
		String floor = roomSerachMap.get("floor");
		
		return roomMapper.selectRoomsWithSearch(roomIdOrName, academy, build, school, floor);
	}

	@Override
	public Integer updateRoom(RoomBaseOrder roomBaseOrder) {
		return roomMapper.updateRoom(roomBaseOrder);
	}

	@Override
	public Integer addRoom(RoomBaseOrder roomBaseOrder) {
		return roomMapper.insertRoom(roomBaseOrder);
	}

	@Override
	public Boolean deleteRoom(String roomId) {
		return roomMapper.deleteRoom(roomId);
	}

}
