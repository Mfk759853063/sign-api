package com.vbn.sign.model;

import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;


@Table(name="t_sys_user")
@Data
public class SystemUser extends BaseEntity {
	
	@Id
	private String id;
	
	private String userName;
	
	@JSONField(serialize = false)
	private String userPwd;
	
	private Integer userType;
	
	private String extra;
	
	private String token;
	
	

}
