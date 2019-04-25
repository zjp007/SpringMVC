package dorm.student.domain.pojo;
/**
* @author 作者 zjp
* @version 创建时间：2019年4月18日 下午4:33:51
* 类说明 ：
*/
public interface StudentEnum {
	//1--在宿舍/2--请假/3--退宿/4--放假/5--待入住
	
	//1--在宿舍
	Integer AtRoom = 1;
	
	//2--请假
	Integer Leave = 2;
	
	//3--退宿
	Integer Retreat = 3;
	
	//4--放假
	Integer Holiday = 4;
	
	//5--待入住
	Integer Staying = 5;
}
