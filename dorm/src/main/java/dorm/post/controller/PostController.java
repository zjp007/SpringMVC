package dorm.post.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月19日 下午10:21:12
* 类说明 ：
*/
public interface PostController {
	
	//带参数查询
	String getPostsWithSearch (HttpServletRequest request, HttpServletResponse response);
	
	//新增
	String addPost (HttpServletRequest request, HttpServletResponse response);
	
	//修改
	String updatePost (HttpServletRequest request, HttpServletResponse response);
	
	//删除
	String deletePost (HttpServletRequest request, HttpServletResponse response);
}
