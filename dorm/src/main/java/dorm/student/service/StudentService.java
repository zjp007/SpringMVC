package dorm.student.service;
/**
* @author 作者 zjp
* @version 创建时间：2019年4月18日 下午5:16:33
* 类说明 ：
*/

import java.util.List;
import java.util.Map;

import dorm.student.domain.pojo.StudentBaseOrder;

public interface StudentService {
	//查询所有
	List<StudentBaseOrder> getAllStudents ();
	
	//带参数查询
	List<StudentBaseOrder> getStudentsWithSearch (Map<String, Object> searchMap);
	
	//添加
	Integer addStudent (StudentBaseOrder studentBaseOrder);
	
	//修改
	Integer updateStudent (StudentBaseOrder studentBaseOrder);
	
	//删除
	Boolean deleteStudent (String studentId);
}
