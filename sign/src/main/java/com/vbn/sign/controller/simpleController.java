package com.vbn.sign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.vbn.sign.common.JSONResult;
import com.vbn.sign.model.Activity;
import com.vbn.sign.service.ActivityService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class simpleController {

	@Autowired
	ActivityService activityService;
	
	@RequestMapping("test")
	public JSONObject test3() {
//		long count = activityService.totalCount();
		List<Activity> list = activityService.allActivitys();
		return JSONResult.fillResultString(0, "成功",  list);
	}
	
	@RequestMapping("findAll")
	public JSONObject test() {
		Activity activity = new Activity();
		activity.setStatus(1);
		List<Activity> list = activityService.queryListByWhere(activity);
		log.info("{}",list.size());
		return JSONResult.fillResultString(0, "成功", list);
	}
	
	@RequestMapping("update")
	public JSONObject test2() {
		Activity activity = activityService.queryById("sfksjfksfjksfjskl");
		activity.setStatus(9);
		activityService.updateSelective(activity);
		return JSONResult.fillResultString(0, "成功", "");
	}
}
