package com.vbn.sign.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.vbn.sign.common.JSONResult;
import com.vbn.sign.model.Activity;
import com.vbn.sign.model.Ground;
import com.vbn.sign.model.SignRule;
import com.vbn.sign.service.ActivityService;
import com.vbn.sign.service.GroundService;
import com.vbn.sign.util.DateUtils;
import com.vbn.sign.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ground")
@Slf4j
public class GroundController {
	
	@Autowired
	GroundService groundService;
	
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
	private JSONObject add(@RequestBody Ground ground) throws Exception {
		try {
			Integer result = 0;
			if (ground.getId() != null) {
				result = groundService.updateSelective(ground);
			} else {
				ground.setId(StringUtils.newGUID());
				ground.setStatus(1);
				ground.setCreateTime(String.valueOf(DateUtils.date2TimeStamp(new Date())));
				result = groundService.save(ground);
			}
			if (result == 1) {
				return JSONResult.fillResultString(0, "成功", ground.getId());
			}
			return JSONResult.fillResultString(0, "失败", null); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(0, "失败", null); 
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private JSONObject list() throws Exception {
		try {
			Ground ground = new Ground();
			ground.setStatus(1);
			List<Ground>list = groundService.queryListByWhere(ground, "create_time desc");
			return JSONResult.fillResultString(0, "成功", list); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(0, "失败", null); 
		}
	}
	
	@RequestMapping(value = "/pageInfo", method = RequestMethod.GET)
	private JSONObject pageInfo(@RequestParam(name="page", required = true) Integer page, @RequestParam(name="pageSize", required = true) Integer pageSize) throws Exception {
		try {
			Ground ground = new Ground();
			ground.setStatus(1);
			PageInfo<Ground>list = groundService.queryPageListByWhere(ground, "create_time desc", page, pageSize);
			return JSONResult.fillResultStringWithPageInfo(0, "成功", list); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(0, "失败", null); 
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private JSONObject delete(@RequestParam(name = "id", required = true) String id) throws Exception {
		try {
			Integer result = 0;
			Ground ground = groundService.queryById(id);
			ground.setStatus(9);
			result = groundService.updateSelective(ground);
			if (result == 1) {
				return JSONResult.fillResultString(0, "成功", null);
			}
			return JSONResult.fillResultString(0, "失败", null); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(0, "失败", null); 
		}
	} 
}
