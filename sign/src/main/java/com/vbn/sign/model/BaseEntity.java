package com.vbn.sign.model;

import java.io.Serializable;

import lombok.Data;


@Data
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long createTime;
	
	private String extra;
	
	private Integer status;

}
