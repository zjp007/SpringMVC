package dorm.room.service;
/**
* @author 作者 zjp
* @version 创建时间：2019年4月14日 下午4:19:37
* 类说明 ：
*/

import java.util.List;
import java.util.Map;

import dorm.room.domain.pojo.RoomBaseOrder;

public interface RoomService {
	//查询所有
	List<RoomBaseOrder> getAllRooms ();
	
	//条件查询
	List<RoomBaseOrder> getRoomsWithSerach (Map<String, String> roomSerachMap);
	
	//修改
	Integer updateRoom (RoomBaseOrder roomBaseOrder);
	
	//添加
	Integer addRoom (RoomBaseOrder roomBaseOrder);
	
	//删除
	Boolean deleteRoom (String roomId);
}
