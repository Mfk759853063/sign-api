package com.vbn.sign.controller.RestApi;

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
import com.vbn.sign.service.IActivityService;
import com.vbn.sign.util.DateUtils;
import com.vbn.sign.util.StringUtils;

@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	IActivityService activityService;
	
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
	private JSONObject add(@RequestBody Activity activity) throws Exception {
		try {
			Integer result = 0;
			if (activity.getId() != null) {
				result = activityService.updateSelective(activity);
			} else {
				activity.setId(StringUtils.newGUID());
				activity.setStatus(1);
				activity.setCreateTime(String.valueOf(DateUtils.date2TimeStamp(new Date())));
				result = activityService.save(activity);
			}
			if (result == 1) {
				return JSONResult.fillResultString(0, "成功", activity.getId());
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
			Activity activity = new Activity();
			activity.setStatus(1);
			List<Activity>list = activityService.queryListByWhere(activity, "create_time desc");
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
			Activity activity = new Activity();
			activity.setStatus(1);
			PageInfo<Activity>list = activityService.queryPageListByWhere(activity, "create_time desc", page, pageSize);
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
			Activity activity = activityService.queryById(id);
			activity.setStatus(9);
			result = activityService.updateSelective(activity);
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
