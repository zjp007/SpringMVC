package dorm.post.domain.mapper;

import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.apache.ibatis.annotations.Param;
import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;
import org.mybatis.spring.annotation.MapperScan;

import dorm.post.domain.pojo.PostBaseOrder;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月19日 下午9:33:30
* 类说明 ：
*/
@MapperScan
public interface PostMapper {
	
	//带查询参数的查询
	List<PostBaseOrder> selectPostsWithSearch (Map<String, Object> searchMap);
	
	//增加
	Integer insertPost (PostBaseOrder postBaseOrder);
	
	//修改
	Integer updatePost (PostBaseOrder postBaseOrder);
	
	//删除
	Boolean deletePost (@Param("postId")String postId);
}
