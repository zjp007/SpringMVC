package dorm.post.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dorm.post.domain.mapper.PostMapper;
import dorm.post.domain.pojo.PostBaseOrder;
import dorm.post.service.PostService;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月19日 下午10:15:34
* 类说明 ：
*/
@Service("postServiceImpl")
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostMapper postMapper;
	
	//带参数查询
	@Override
	public List<PostBaseOrder> selectPostWithSearch(Map<String, Object> searchMap) {
		return postMapper.selectPostsWithSearch(searchMap);
	}

	//新增
	@Override
	public Integer insertPost(PostBaseOrder postBaseOrder) {
		return postMapper.insertPost(postBaseOrder);
	}

	//修改
	@Override
	public Integer updatePost(PostBaseOrder postBaseOrder) {
		
		return postMapper.updatePost(postBaseOrder);
	}

	//删除
	@Override
	public Boolean deletePost(String postId) {
		
		return postMapper.deletePost(postId);
	}
	
}
