package dorm.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月18日 下午5:16:48
* 类说明 ：
*/
public interface StudentController {
	
	//查询所有
	String getAllStudents (HttpServletRequest request, HttpServletResponse response);
	
	//带参数查询
	String getStudentsWithSearch (HttpServletRequest request, HttpServletResponse response);
	
	//添加
	String addStudent (HttpServletRequest request, HttpServletResponse response);
	
	//修改
	String updateStudent (HttpServletRequest request, HttpServletResponse response);
	
	//删除
	String deleteStudent (HttpServletRequest request, HttpServletResponse response);
}
