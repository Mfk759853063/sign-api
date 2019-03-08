package com.vbn.sign.model;


import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="t_activity")
public class Activity extends BaseEntity {

	@Id
	private String id;
	
	private String activityName;
	
	private String activityStartTime;
	
	private String activityEndTime;
	
	private String activityDesc;
	
}
