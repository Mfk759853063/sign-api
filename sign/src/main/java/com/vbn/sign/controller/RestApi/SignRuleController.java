package com.vbn.sign.controller.RestApi;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.vbn.sign.service.IActivityService;
import com.vbn.sign.service.IGroundService;
import com.vbn.sign.service.ISignRuleService;
import com.vbn.sign.util.DateUtils;
import com.vbn.sign.util.StringUtils;

@RestController
@RequestMapping("/signRule")
public class SignRuleController {
	
	@Autowired
	ISignRuleService signRuleService;
	
	@Autowired
	IGroundService groundService;
	
	@Autowired
	IActivityService activityService;
	
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
	private JSONObject add(@RequestBody SignRule signRule) throws Exception {
		try {
			Integer result = 0;
			if (signRule.getId() != null) {
				result = signRuleService.updateSelective(signRule);
			} else {
				signRule.setId(StringUtils.newGUID());
				signRule.setStatus(1);
				signRule.setCreateTime(DateUtils.date2TimeStamp(new Date()));
				result = signRuleService.save(signRule);
			}
			if (result == 1) {
				return JSONResult.fillResultString(0, "成功", signRule.getId());
			}
			return JSONResult.fillResultString(1, "失败", null); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(1, "失败", null); 
		}
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	private JSONObject info(@RequestParam(name = "id", required = true) String id) throws Exception {
		try {
			
			SignRule signRule = new SignRule();
			signRule.setStatus(1);
			signRule.setId(id);
			SignRule findSignRule = signRuleService.queryOne(signRule);
			
			Ground ground = new Ground();
			ground.setStatus(1);
			ground.setId(findSignRule.getGroundId());
			Ground findGround = groundService.queryOne(ground);
			
			Activity activity = new Activity();
			activity.setStatus(1);
			activity.setId(findGround.getActivityId());
			Activity findActivity = activityService.queryOne(activity);
			
			Map<String, Object>objMap = new HashMap<String, Object>();
			objMap.put("rule", findSignRule);
			objMap.put("ground", findGround);
			objMap.put("activity", findActivity);
			return JSONResult.fillResultString(0, "成功", objMap); 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(1, "失败", null); 
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private JSONObject list(@RequestParam(name="groundId", required = true) String groundId) throws Exception {
		try {
			
			Ground ground = new Ground();
			ground.setStatus(1);
			ground.setId(groundId);
			Ground findGround = groundService.queryOne(ground);
			
			Activity activity = new Activity();
			activity.setStatus(1);
			activity.setId(findGround.getActivityId());
			Activity findActivity = activityService.queryOne(activity);
			
			SignRule signRule = new SignRule();
			signRule.setStatus(1);
			signRule.setGroundId(groundId);
			List<SignRule>list = signRuleService.queryListByWhere(signRule, "create_time desc");
			Map<String, Object>objMap = new HashMap<String, Object>();
			objMap.put("rules", list);
			objMap.put("ground", findGround);
			objMap.put("activity", findActivity);
			return JSONResult.fillResultString(0, "成功", objMap); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(1, "失败", null); 
		}
	}
	
	@RequestMapping(value = "/pageInfo", method = RequestMethod.GET)
	private JSONObject pageInfo(@RequestParam(name="page", required = true) Integer page, @RequestParam(name="pageSize", required = true) Integer pageSize) throws Exception {
		try {
			SignRule signRule = new SignRule();
			signRule.setStatus(1);
			PageInfo<SignRule>list = signRuleService.queryPageListByWhere(signRule, "create_time desc", page, pageSize);
			return JSONResult.fillResultStringWithPageInfo(0, "成功", list); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(1, "失败", null); 
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	private JSONObject delete(@RequestParam(name = "id", required = true) String id) throws Exception {
		try {
			Integer result = 0;
			SignRule signRule = signRuleService.queryById(id);
			signRule.setStatus(9);
			result = signRuleService.updateSelective(signRule);
			if (result == 1) {
				return JSONResult.fillResultString(0, "成功", null);
			}
			return JSONResult.fillResultString(1, "失败", null); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(1, "失败", null); 
		}
	} 
}
