package com.vbn.sign.model;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="t_ground")
public class Ground extends BaseEntity {
	
	@Id
	private String id;
	
	private String activityId;
	
	private String groundName;
	
	private String groundAddr;
	
	private List<SignRule>signRules;
	
}
