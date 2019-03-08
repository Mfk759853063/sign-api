package com.vbn.sign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.common.BaseService;
import com.vbn.sign.mapper.ActivityMapper;
import com.vbn.sign.model.Activity;

import tk.mybatis.mapper.entity.Example;

@Service
public class ActivityService extends BaseService<Activity>  {
	
	@Autowired
	private ActivityMapper activityMaper;
	
	public long totalCount() throws Exception {
		return activityMaper.totalCount();
	}
	
	public List<Activity>allActivitys() throws Exception {
		return activityMaper.allActivitys();
	}
	
}
