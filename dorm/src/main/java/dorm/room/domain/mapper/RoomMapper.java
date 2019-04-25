package dorm.room.domain.mapper;
/**
* @author 作者 zjp
* @version 创建时间：2019年4月14日 下午4:05:41
* 类说明 ：
*/

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import dorm.room.domain.pojo.RoomBaseOrder;


@MapperScan
public interface RoomMapper {
	//查询所有宿舍信息
	List<RoomBaseOrder> selectALLRooms ();
	
	//带参数查询
	List<RoomBaseOrder> selectRoomsWithSearch (@Param("roomIdOrName")String roomIdOrName, @Param("academy")String academy, @Param("build")String build, @Param("school")String school, @Param("floor")String floor);
	
	//修改
	Integer updateRoom (RoomBaseOrder roomBaseOrder);
	
	//添加
	Integer insertRoom (RoomBaseOrder roomBaseOrder);
	
	//删除
	Boolean deleteRoom (@Param("roomId")String roomId);
}
