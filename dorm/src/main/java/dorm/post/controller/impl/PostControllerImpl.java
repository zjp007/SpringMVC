package dorm.post.controller.impl;

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

import dorm.post.controller.PostController;
import dorm.post.domain.pojo.PostBaseOrder;
import dorm.post.service.PostService;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月19日 下午10:21:32
* 类说明 ：
*/
@Controller
@ResponseBody
@RequestMapping("/post")
public class PostControllerImpl implements PostController{
	
	@Resource(name="postServiceImpl")
	private PostService postService;
	
	public PostService getPostService () {
		return this.postService;
	}
	
	public void setPostService (PostService postService) {
		this.postService = postService;
	}
	
	//带参数查询
	@Override
	@RequestMapping(value="/getPostsWithSearch", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String getPostsWithSearch(HttpServletRequest request, HttpServletResponse response) {
		//页面大小
		Integer limit = request.getParameter("limit")==null ? 10 : Integer.parseInt(request.getParameter("limit"));
		//页码
		Integer offset = request.getParameter("offset")==null ? 0 : Integer.parseInt(request.getParameter("offset"));
		Integer start = null;
		Integer end = null;
		if(limit!=null&&offset!=null) {
			start = limit * offset;
			end = start + limit;
		}
		Integer delMark = (request.getParameter("delMark") == null||request.getParameter("delMark") == "") ? null : Integer.parseInt(request.getParameter("delMark"));
		String postId = (request.getParameter("postId") == null||request.getParameter("postId") == "") ? null : request.getParameter("postId");
		String title = (request.getParameter("title") == null||request.getParameter("title") == "") ? null : request.getParameter("title");
		String createId = (request.getParameter("createId") == null||request.getParameter("createId") == "") ? null : request.getParameter("createId");
		String createTime = ((request.getParameter("createTime") == null||request.getParameter("createTime") == "") ? null : request.getParameter("createTime"));
		String releaseId = (request.getParameter("releaseId") == null||request.getParameter("releaseId") == "") ? null : request.getParameter("releaseId");
		String releaseTime = ((request.getParameter("releaseTime") == null||request.getParameter("releaseTime") == "") ? null : request.getParameter("releaseTime"));
		String startTime = (request.getParameter("startTime") == null||request.getParameter("startTime") == "") ? null : request.getParameter("startTime");
		String endTime = ((request.getParameter("endTime") == null||request.getParameter("endTime") == "") ? null : request.getParameter("endTime"));
		Integer type = (request.getParameter("type") == null||request.getParameter("type") == "") ? null : Integer.parseInt(request.getParameter("type"));
		Integer status = (request.getParameter("status") == null||request.getParameter("status") == "") ? null : Integer.parseInt(request.getParameter("status"));
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("delMark", delMark);
		searchMap.put("postId", postId);
		searchMap.put("title", title);
		searchMap.put("createId", createId);
		searchMap.put("createTime", createTime);
		searchMap.put("releaseId", releaseId);
		searchMap.put("releaseTime", releaseTime);
		searchMap.put("startTime", startTime);
		searchMap.put("endTime", endTime);
		searchMap.put("type", type);
		searchMap.put("status", status);
		System.out.println("searchMap : " + searchMap);
		List<PostBaseOrder> postList = postService.selectPostWithSearch(searchMap);
		JSONArray jsonArray = new JSONArray();
		if (start!=null&&end!=null) {
			for (int i = start;i<(end<postList.size() ? end : postList.size());i++)
			{
				jsonArray.add(postList.get(i));
			}
		}else {
			for (PostBaseOrder post : postList)
			{
				jsonArray.add(post);
			}
		}
		Integer total = postList.size();
		Integer totalPage = (total % limit ==0) ? (total / limit) : (total / limit) + 1;
		String rows= JSON.toJSONString(jsonArray);
		String data = "{ \"total\": " + total + ", \"totalPage\": " + totalPage + ", \"rows\": " + rows + "}";
		String params = "{\"data\":" +  data + "}";
		//String callBackStr = callback + "(" + params +  ")";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		//response.getWriter().write(callBackStr);
		System.out.println("selectUser: " + params);
		return params;
	}

	@Override
	@RequestMapping(value="/addPost", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String addPost(HttpServletRequest request, HttpServletResponse response) {
		String post = request.getParameter("postBaseOrder");
		PostBaseOrder postBaseOrder = JSON.parseObject(post, PostBaseOrder.class);
		//Integer addStatus = postService.insertPost(postBaseOrder);
		String addStatus = "{\"addStatus\": " + this.postService.insertPost(postBaseOrder) + "}";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return addStatus;
	}

	@Override
	@RequestMapping(value="/updatePost", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String updatePost(HttpServletRequest request, HttpServletResponse response) {
		String post = request.getParameter("postBaseOrder");
		PostBaseOrder postBaseOrder = JSON.parseObject(post, PostBaseOrder.class);
		//Integer addStatus = postService.insertPost(postBaseOrder);
		String updateStatus = "{\"updateStatus\": " + this.postService.insertPost(postBaseOrder) + "}";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return updateStatus;
	}

	@Override
	@RequestMapping(value="/deletePost", method=RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String deletePost(HttpServletRequest request, HttpServletResponse response) {
		String postId = request.getParameter("postId");
		String deleteStatus = "{\"updateStatus\": " + this.postService.deletePost(postId) + "}";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET,POST,PATCH,PUT,OPTIONS");
		response.setHeader("Access-Control-Expose-Headers","*");
		response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
		return deleteStatus;
	}

}
