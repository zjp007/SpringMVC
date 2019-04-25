package dorm.student.domain.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月18日 下午4:23:24
* 类说明 ：
*/
public class StudentBaseOrder {
	//序号
	private String id;
	
	//学生学号
	@JSONField(name="student_id")
	private String studentId;
	
	//宿舍号
	@JSONField(name="room_id")
	private String roomId;
	
	//学生姓名
	private String name;
	
	//学生性别
	private Integer sex;
	
	//学生联系电话
	private String tel;
	
	//学生邮箱
	private String mail;
	
	//学生学院
	private String academy;
	
	//学生专业
	private String school;
	
	//删除标识
	@JSONField(name="del_mark")
	private Integer delMark;
	
	//学生在宿状态
	private Integer status;
	
	//备用字段spare01、spare02、spare03、spare04、spare05、spare06
	
	//getter and setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public Integer getDelMark() {
		return delMark;
	}

	public void setDelMark(Integer delMark) {
		this.delMark = delMark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
