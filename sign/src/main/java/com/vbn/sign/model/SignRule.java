package com.vbn.sign.model;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="t_ground_sign_rule")
public class SignRule extends BaseEntity {

	@Id
	private String id;
	
	private String groundId;
	
	private String signRuleName;
	
	private Long signStartTime;
	
	private Long signEndTime;
	
	private Integer userSignTimes;
}
