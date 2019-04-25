package dorm.post.domain.pojo;
/**
* @author 作者 zjp
* @version 创建时间：2019年4月19日 下午9:05:26
* 类说明 ：
*/
public interface PostEnum {
	//type （1--宿舍通知公告/2--宿舍维修公告/3--宿舍财务公告）
	
	//1--宿舍通知公告
	Integer room_notice = 1;
	
	//2--宿舍维修公告
	Integer room_repair = 2;
	
	//3--宿舍财务公告
	Integer room_coast = 3;
	
	//status 公告状态(1--新建/2--待审核/3--已发布/4--已关闭)
	//1--新建
	Integer status_new = 1;
	
	//2--待审核
	Integer status_check = 2;
	
	//3--已发布
	Integer status_publish = 3;
	
	//4--已关闭
	Integer status_close = 4;
}
