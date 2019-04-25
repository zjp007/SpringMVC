package dorm.student.controller.impl;

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

import dorm.student.controller.StudentController;
import dorm.student.domain.pojo.StudentBaseOrder;
import dorm.student.service.StudentService;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月18日 下午5:38:28
* 类说明 ：
*/
@Controller
@RequestMapping("/student")
@ResponseBody
public class StudentControllerImpl implements StudentController{
	@Resource(name="studentServicImpl")
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return this.studentService;
	}
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	//查询所有student
	@Override
	@RequestMapping(value="/getAllStudents", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String getAllStudents(HttpServletRequest request, HttpServletResponse response) {
		//页面大小
		Integer limit = request.getParameter("limit")==null ? null : Integer.parseInt(request.getParameter("limit"));
		//页码
		Integer offset = request.getParameter("offset")==null ? null : Integer.parseInt(request.getParameter("offset"));
		Integer start = null;
		Integer end = null;
		if(limit!=null&&offset!=null) {
			start = limit * offset;
			end = start + limit;
		}
		List<StudentBaseOrder> studentList = studentService.getAllStudents();
		JSONArray jsonArray = new JSONArray();
		if (start!=null&&end!=null) {
			for (int i = start;i<(end<studentList.size() ? end : studentList.size());i++)
			{
				jsonArray.add(studentList.get(i));
			}
		}else {
			for (StudentBaseOrder student : studentList)
			{
				jsonArray.add(student);
			}
		}
		Integer total = studentList.size();
		Integer totalPage = (total % limit ==0) ? (total / limit) : (total / limit) + 1;
		String rows= JSON.toJSONString(jsonArray);
		String data = "{ \"total\": " + total + ", \"totalPage\": " + totalPage + ", \"rows\": " + rows + "}";
		String params = "{\"data\":" +  data + "}";

		response.setHeader("Access-Control-Allow-Origin", "*");

		System.out.println("getAllStudents: " + params);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return params;
	}
	
	//参数查询
	@Override
	@RequestMapping(value="/getStudentsWithSearch", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String getStudentsWithSearch(HttpServletRequest request, HttpServletResponse response) {
		Integer delMark = (request.getParameter("delMark")==null||request.getParameter("delMark")=="") ? null : Integer.parseInt(request.getParameter("delMark"));
		String studentId = request.getParameter("StudentId")==null ? null : request.getParameter("StudentId");
		String roomId = request.getParameter("roomId")==null ? null : request.getParameter("roomId");
		String name = request.getParameter("name")==null ? null : request.getParameter("name");
		String academy = request.getParameter("academy")==null ? null : request.getParameter("academy");
		String school = request.getParameter("school")==null ? null : request.getParameter("school");
		Integer status = (request.getParameter("status")==null||request.getParameter("status")=="") ? null : Integer.parseInt(request.getParameter("status"));
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("delMark", delMark);
		searchMap.put("studentId", studentId);
		searchMap.put("roomId", roomId);
		searchMap.put("name", name);
		searchMap.put("academy", academy);
		searchMap.put("school", school);
		searchMap.put("status", status);
		System.out.println("searchMap : " + searchMap);
		//页面大小
		Integer limit = request.getParameter("limit")==null ? null : Integer.parseInt(request.getParameter("limit"));
		//页码
		Integer offset = request.getParameter("offset")==null ? null : Integer.parseInt(request.getParameter("offset"));
		Integer start = null;
		Integer end = null;
		if(limit!=null&&offset!=null) {
			start = limit * offset;
			end = start + limit;
		}
		List<StudentBaseOrder> studentList = studentService.getStudentsWithSearch(searchMap);
		JSONArray jsonArray = new JSONArray();
		if (start!=null&&end!=null) {
			for (int i = start;i<(end<studentList.size() ? end : studentList.size());i++)
			{
				jsonArray.add(studentList.get(i));
			}
		}else {
			for (StudentBaseOrder student : studentList)
			{
				jsonArray.add(student);
			}
		}
		Integer total = studentList.size();
		Integer totalPage = (total % limit ==0) ? (total / limit) : (total / limit) + 1;
		String rows= JSON.toJSONString(jsonArray);
		String data = "{ \"total\": " + total + ", \"totalPage\": " + totalPage + ", \"rows\": " + rows + "}";
		String params = "{\"data\":" +  data + "}";

		response.setHeader("Access-Control-Allow-Origin", "*");

		System.out.println("getAllStudents: " + params);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return params;
	}
	
	//添加
	@Override
	@RequestMapping(value="/addStudent", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String addStudent(HttpServletRequest request, HttpServletResponse response) {
		String student = request.getParameter("studentBaseOrder");
		System.out.println("addStudent : " + student);
		StudentBaseOrder studentBaseOrder = JSON.parseObject(student, StudentBaseOrder.class);
		Integer addStatus = studentService.addStudent(studentBaseOrder);
		String params = "{\"addStatus\" :" + addStatus + "}";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return params;
	}
	
	//修改
	@Override
	@RequestMapping(value="/updateStudent", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String updateStudent(HttpServletRequest request, HttpServletResponse response) {
		String student = request.getParameter("studentBaseOrder");
		System.out.println("updateStudent : " + student);
		StudentBaseOrder studentBaseOrder = JSON.parseObject(student, StudentBaseOrder.class);
		Integer updateStatus = studentService.updateStudent(studentBaseOrder);
		String params = "{\"updateStatus\" :" + updateStatus + "}";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return params;
	}
	
	//删除
	@Override
	@RequestMapping(value="/deleteStudent", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		String studentId = request.getParameter("studentId");
		System.out.println("deleteStudent : " + studentId);
		
		Boolean deleteStatus = studentService.deleteStudent(studentId);
		String params = "{\"deleteStatus\" :" + deleteStatus + "}";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return params;
	}
	
	
}
