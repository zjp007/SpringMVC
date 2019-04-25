package dorm.domain.pojo;
/**
* @author 作者 zjp
* @version 创建时间：2019年4月18日 下午4:37:14
* 类说明 ：
*/
public interface dormEnum {
	//sex 0--男生/1--女生/2--未知
	
	//0--男生
	Integer Male = 0;
	
	//1--女生
	Integer Female = 1;
	
	//2--未知
	Integer Unknown = 2;
	
	//del_mark 0--未删除/1--删除
	
	//0--未删除
	Integer Notdeleted = 0;
	
	//1--删除
	Integer Deleted = 1;
}
