package dorm.post.domain.pojo;


import com.alibaba.fastjson.annotation.JSONField;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月19日 下午9:02:25
* 类说明 ：
*/
public class PostBaseOrder {
	//id--序号/post_id--公告信息表号/title--公告信息标题/content--公告信息内容
	//remark--公告信息备注/create_id--创建人/create_time--创建时间/release_id--发布人
	//release_time--发布时间/start_time--公告开始时间/end_time--公告结束时间/del_mark--删除标记
	//type--公告类型（1--宿舍通知公告/2--宿舍维修公告/3--宿舍财务公告）
	//status--公告状态(1--新建/2--待审核/3--已发布/4--已关闭)
	
	//id--序号
	private String id;
	
	//post_id--公告信息表号
	@JSONField(name="post_id")
	private String  postId;
	
	//title--公告信息标题
	private String title;
	
	//content--公告信息内容
	private String content;
	
	//remark--公告信息备注
	private String remark;
	
	//create_id--创建人
	@JSONField(name="create_id")
	private String createId;
	
	//create_time--创建时间
	@JSONField(name="create_time")
	private String createTime;
	
	//release_id--发布人
	@JSONField(name="release_id")
	private String releaseId;
	
	//release_time--发布时间
	@JSONField(name="release_time")
	private String releaseTime;
	
	//start_time--开始时间
	@JSONField(name="start_time")
	private String startTime;
	
	//end_time--结束时间
	@JSONField(name="end_time")
	private String endTime;
	
	//del_mark--删除标记
	@JSONField(name="del_mark")
	private Integer delMark;
	
	//type--公告类型（1--宿舍通知公告/2--宿舍维修公告/3--宿舍财务公告）
	private Integer type;
	
	//status--公告状态(1--新建/2--待审核/3--已发布/4--已关闭)
	private Integer status;
	
	//getter and setter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getDelMark() {
		return delMark;
	}

	public void setDelMark(Integer delMark) {
		this.delMark = delMark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
