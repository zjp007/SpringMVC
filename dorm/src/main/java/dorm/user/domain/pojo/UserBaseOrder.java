package dorm.user.domain.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
* @author 作者 zjp
* @version 创建时间：2019年4月9日 下午2:24:15
* 类说明 ：
*/
public class UserBaseOrder {
	//id--序号 user_id--用户账号 name--用户名 password--密码 operate--权限操作项
	//spare01--备用字段01 spare02--备用字段02 spare03--备用字段03 spare04--备用字段04
	
	//id--序号
	private String id;
	
	// user_id--用户账号
	@JSONField(name="user_id")
	private String userId;
	
	//name--用户名
	private String name;
	
	//password--密码
	private String password;
	
	//operate--权限操作项
	private Integer operate;
	
	//spare01--备用字段01
	private String spare01;
	
	//spare02--备用字段02
	private String spare02;
	
	//spare03--备用字段03
	private String spare03;
		
	//spare04--备用字段04
	private String spare04;
	
	
	//getter and setter
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public String getSpare01() {
		return spare01;
	}

	public void setSpare01(String spare01) {
		this.spare01 = spare01;
	}

	public String getSpare02() {
		return spare02;
	}

	public void setSpare02(String spare02) {
		this.spare02 = spare02;
	}

	public String getSpare03() {
		return spare03;
	}

	public void setSpare03(String spare03) {
		this.spare03 = spare03;
	}

	public String getSpare04() {
		return spare04;
	}

	public void setSpare04(String spare04) {
		this.spare04 = spare04;
	}
	
	public String toString () {
		return JSON.toJSONString(this);
	}
}
