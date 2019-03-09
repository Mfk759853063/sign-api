package com.vbn.sign.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.mapper.ActivityMapper;
import com.vbn.sign.model.Activity;
import com.vbn.sign.service.IActivityService;

@Service
public class ActivityServiceImp extends BaseServiceImp<Activity> implements IActivityService {

	@Autowired
	private ActivityMapper activityMaper;
	
	public long totalCount() throws Exception {
		return activityMaper.totalCount();
	}
	
	public List<Activity>allActivitys() throws Exception {
		return activityMaper.allActivitys();
	}
}
