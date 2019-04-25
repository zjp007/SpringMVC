package dorm.post.service;
/**
* @author 作者 zjp
* @version 创建时间：2019年4月19日 下午10:15:07
* 类说明 ：
*/

import java.util.List;
import java.util.Map;

import dorm.post.domain.pojo.PostBaseOrder;

public interface PostService {
	
	//带参数查询
	List<PostBaseOrder> selectPostWithSearch (Map<String, Object> searchMap);
	
	//添加
	Integer insertPost (PostBaseOrder postBaseOrder);
	
	//修改
	Integer updatePost (PostBaseOrder postBaseOrder);
	
	//删除
	Boolean deletePost (String postId);
}
