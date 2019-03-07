package com.vbn.sign.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vbn.sign.common.MyMapper;
import com.vbn.sign.model.Activity;


@Mapper
public interface ActivityMapper extends MyMapper<Activity>  {

	public long totalCount();
	
	List<Activity>allActivitys();
	
	
}
