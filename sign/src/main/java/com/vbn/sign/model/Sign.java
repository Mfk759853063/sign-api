package com.vbn.sign.model;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="t_sign")
public class Sign extends BaseEntity {
	
	@Id
	private String id;
	
	private String activityId;
	
	private String groundId;
	
	private String signRuleId;
	
	private String signTime;

	private String userId;
	
	
}