package com.vbn.sign.model;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="t_user")
public class User extends BaseEntity {
	@Id
	private String id;
	
	private String openId;
	
	private String name;
}
