package dorm.user.domain.pojo;
/**
* @author 作者 zjp
* @version 创建时间：2019年4月9日 下午2:16:42
* 类说明 ：用户类型接口 （0--系统管理员/1--宿舍管理员/2--财务管理员/3--维修管理员/4--教师/5--学生/6--来访者）
*/
public interface UserEnum {
	
	//1--系统管理员
	Integer systemAdmin = 1;
	
	//2--宿舍管理员
	Integer dormAdmin = 2;
	
	//3--财务管理员
	Integer costAdmin = 3;
	
	//4--维修管理员
	Integer repairAdmin = 4;
	
	//5--教师
	Integer teacher = 5;
	
	//6--学生
	Integer student = 6;
	
	//7--来访者
	Integer visitor = 7;
}
