package dorm.room.domain.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月14日 下午3:54:09
* 类说明 ：
*/
public class RoomBaseOrder {
	//序号
	private String id;
	
	//宿舍号
	@JSONField(name="room_id")
	private String roomId;
	
	//宿舍名
	private String name;
	
	//宿舍电费余额
	private Double electric;
	
	//宿舍水费余额
	private Double water;
	
	//宿舍容量（2/4/6/8）
	private Integer size;
	
	//宿舍已住人数
	private Integer used;
	
	//可住人数
	private Integer last;
	
	//宿舍所属学院
	private String academy;
	
	//宿舍所属班级
	private String school;
	
	//宿舍卫生评分
	private Double condition;
	
	//宿舍考勤评分
	private Double attendance;
	
	//宿舍固定资产情况 
	private Boolean assets;
	
	//宿舍所在楼栋
	private String build;
	
	//宿舍所在楼层
	private String floor;
	
	//spare01--备用字段01
	private String spare01;
		
	//spare02--备用字段02
	private String spare02;
		
	//spare03--备用字段03
	private String spare03;
			
	//spare04--备用字段04
	private String spare04;
	
	//spare04--备用字段05
	private String spare05;
	
	//spare04--备用字段06
	private String spare06;
	
	//getter and setter
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getElectric() {
		return electric;
	}

	public void setElectric(Double electric) {
		this.electric = electric;
	}

	public Double getWater() {
		return water;
	}

	public void setWater(Double water) {
		this.water = water;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Double getCondition() {
		return condition;
	}

	public void setCondition(Double condition) {
		this.condition = condition;
	}

	public Double getAttendance() {
		return attendance;
	}

	public void setAttendance(Double attendance) {
		this.attendance = attendance;
	}

	public Boolean getAssets() {
		return assets;
	}

	public void setAssets(Boolean assets) {
		this.assets = assets;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getSpare01() {
		return spare01;
	}

	public void setSpare01(String spare01) {
		this.spare01 = spare01;
	}

	public String getSpare02() {
		return spare02;
	}

	public void setSpare02(String spare02) {
		this.spare02 = spare02;
	}

	public String getSpare03() {
		return spare03;
	}

	public void setSpare03(String spare03) {
		this.spare03 = spare03;
	}

	public String getSpare04() {
		return spare04;
	}

	public void setSpare04(String spare04) {
		this.spare04 = spare04;
	}

	public String getSpare05() {
		return spare05;
	}

	public void setSpare05(String spare05) {
		this.spare05 = spare05;
	}

	public String getSpare06() {
		return spare06;
	}

	public void setSpare06(String spare06) {
		this.spare06 = spare06;
	}
}
