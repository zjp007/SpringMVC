package dorm.student.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dorm.student.domain.mapper.StudentMapper;
import dorm.student.domain.pojo.StudentBaseOrder;
import dorm.student.service.StudentService;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月18日 下午5:27:54
* 类说明 ：
*/
@Service("studentServicImpl")
public class StudentServicImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public List<StudentBaseOrder> getAllStudents() {
		return studentMapper.selectAllStudentd();
	}

	@Override
	public List<StudentBaseOrder> getStudentsWithSearch(Map<String, Object> searchMap) {
		Integer delMark = (Integer) searchMap.get("delMark");
		String studentId = searchMap.get("studentId").toString();
		String roomId = searchMap.get("roomId").toString();
		String name = searchMap.get("name").toString();
		String academy = searchMap.get("academy").toString();
		String school = searchMap.get("school").toString();
		Integer status = (Integer) searchMap.get("status");
		return studentMapper.selectStudentsWithSearch(delMark, studentId, roomId, name, academy, school, status);
	}

	@Override
	public Integer addStudent(StudentBaseOrder studentBaseOrder) {
		return studentMapper.insertStudent(studentBaseOrder);
	}

	@Override
	public Integer updateStudent(StudentBaseOrder studentBaseOrder) {
		
		return studentMapper.updateStudent(studentBaseOrder);
	}

	@Override
	public Boolean deleteStudent(String studentId) {
		
		return studentMapper.deleteStudent(studentId);
	}
	
}
