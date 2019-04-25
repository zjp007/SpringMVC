package dorm.student.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import dorm.student.domain.pojo.StudentBaseOrder;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月18日 下午4:41:56
* 类说明 ：
*/
@MapperScan
public interface StudentMapper {
	//查询所有
	List<StudentBaseOrder> selectAllStudentd ();
	
	//带查询参数查询
	List<StudentBaseOrder> selectStudentsWithSearch (@Param("delMark")Integer delMark, @Param("studentId")String studentId
			, @Param("roomId")String roomId, @Param("name")String name, @Param("academy")String academy, @Param("school")String school
			,@Param("status")Integer status );
	
	//添加
	Integer insertStudent (StudentBaseOrder studentBaseOrder);
	
	//修改
	Integer updateStudent (StudentBaseOrder studentBaseOrder);
	
	//删除
	Boolean deleteStudent (@Param("StudentId")String studentId);
}
