package com.vbn.sign.controller.RestApi;

import java.util.ArrayList;
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
import com.vbn.sign.model.Sign;
import com.vbn.sign.model.SignRule;
import com.vbn.sign.model.User;
import com.vbn.sign.service.IActivityService;
import com.vbn.sign.service.IGroundService;
import com.vbn.sign.service.ISignRuleService;
import com.vbn.sign.service.ISignService;
import com.vbn.sign.service.IUserService;
import com.vbn.sign.util.DateUtils;
import com.vbn.sign.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sign")

public class SignController {
	
	@Autowired
	ISignService signService;
	
	@Autowired
	IGroundService groundService;
	
	@Autowired
	ISignRuleService signRuleService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IActivityService activityService;
	
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
	private JSONObject add(@RequestBody Sign sign) throws Exception {
		try {
			Integer result = 0;
			String msgString = "成功";
			if (sign.getId() != null) {
				result = 1;
				msgString = "暂不支持修改";
			} else {
				if (sign.getGroundId() != null) {
					Ground ground = groundService.queryById(sign.getGroundId());
					SignRule signParam = new SignRule();
					signParam.setGroundId(ground.getId());
					List<SignRule>signRules = signRuleService.queryListByWhere(signParam);
					// 判断时间段及用户能签到的次数
					if (sign.getUserId() != null) {
						User paramUser = new User();
						paramUser.setOpenId(sign.getUserId());
						User findUser = userService.queryOne(paramUser);
						if (findUser != null) {
							List<Sign>userSigns = signService.queryListByWhere(sign);
							Integer userSignsCount = userSigns == null ? 0 :userSigns.size();
							long signTimeStamp = DateUtils.date2TimeStamp(new Date());
							result = 1;
							msgString = "不在签到时间内";
							for (SignRule signRule : signRules) {
								long signStartTimeStamp = Long.valueOf(signRule.getSignStartTime());
								long signEndTimeStamp = Long.valueOf(signRule.getSignEndTime());
								if (signTimeStamp >= signStartTimeStamp && signTimeStamp <= signEndTimeStamp && userSignsCount < signRule.getUserSignTimes()) {
									sign.setId(StringUtils.newGUID());
									sign.setSignTime(DateUtils.date2TimeStamp(new Date()));
									sign.setActivityId(ground.getActivityId());
									sign.setSignRuleId(signRule.getId());
									sign.setStatus(1);
									sign.setUserId(findUser.getOpenId());
									sign.setCreateTime(DateUtils.date2TimeStamp(new Date()));
									signService.save(sign);
									result = 0;
									msgString = "签到成功";
								} else if (signTimeStamp >= signStartTimeStamp && signTimeStamp <= signEndTimeStamp) {
									msgString = "只能签"+signRule.getUserSignTimes()+"次";
								}
							}
						} else {
							result = 1;
							msgString = "用户未注册";
						}
						
					} else {
						result = 1;
						msgString = "用户不能为空";
					}
				} else {
					result = 1;
					msgString = "活动会场不能为空";
				}
			}
			if (result == 1) {
				return JSONResult.fillResultString(0, msgString, sign.getId());
			}
			return JSONResult.fillResultString(1, msgString, null); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(1, "失败", null); 
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private JSONObject list(@RequestParam(name="groundId", required = true ) String groundId, @RequestParam(name="activityId", required = true) String activityId) throws Exception {
		try {
			Activity activity = null;
			Ground ground = null;
			Sign sign = new Sign();
			sign.setStatus(1);
			if (groundId != null) {
				sign.setGroundId(groundId);
				Ground paramGround = new Ground();
				paramGround.setId(groundId);
				ground = groundService.queryOne(paramGround);
			}
			if (activityId != null) {
				sign.setActivityId(activityId);
				Activity paramActivity = new Activity();
				paramActivity.setId(activityId);
				activity = activityService.queryOne(paramActivity);
			}
			
			List<Sign>list = signService.queryListByWhere(sign, "create_time desc");
			for (Sign sign2 : list) {
				sign2.setActivity(activity);
				sign2.setGround(ground);
			}
			return JSONResult.fillResultString(0, "成功", list); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(1, "失败", null); 
		}
	}
	
	@RequestMapping(value = "/pageInfo", method = RequestMethod.GET)
	private JSONObject pageInfo(@RequestParam(name="groundId", required = true) String groundId, @RequestParam(name="activityId", required = true) String activityId, @RequestParam(name="page", required = true) Integer page, @RequestParam(name="pageSize", required = true) Integer pageSize) throws Exception {
		try {
			Activity activity = null;
			Ground ground = null;
			Sign sign = new Sign();
			sign.setStatus(1);
			if (groundId != null) {
				sign.setGroundId(groundId);
				Ground paramGround = new Ground();
				paramGround.setId(groundId);
				ground = groundService.queryOne(paramGround);
			}
			if (activityId != null) {
				sign.setActivityId(activityId);
				Activity paramActivity = new Activity();
				paramActivity.setId(activityId);
				activity = activityService.queryOne(paramActivity);
			}
			PageInfo<Sign>list = signService.queryPageListByWhere(sign, "create_time desc", page, pageSize);
			for (int i = 0; i < list.getList().size(); i++) {
				Sign sign2 = list.getList().get(i);
				sign2.setActivity(activity);
				sign2.setGround(ground);
			}
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
			Sign sign = signService.queryById(id);
			sign.setStatus(9);
			result = signService.updateSelective(sign);
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
